package dwz.web.purchase;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.common.CommonServiceMgr;
import dwz.business.goods.ProviderProduct;
import dwz.business.goods.ProviderProductServiceMgr;
import dwz.business.goods.SearchProviderProductVO;
import dwz.business.purchase.AddPurchaseVO;
import dwz.business.purchase.Arrival;
import dwz.business.purchase.ArrivalDetail;
import dwz.business.purchase.ArrivalExportUtil;
import dwz.business.purchase.Purchase;
import dwz.business.purchase.PurchaseDetail;
import dwz.business.purchase.PurchaseExportUtil;
import dwz.business.purchase.PurchaseServiceMgr;
import dwz.business.purchase.SearchPurchaseVO;
import dwz.business.purchase.SearchSaleDetailVO;
import dwz.business.sale.Sale;
import dwz.business.sale.SaleDetail;
import dwz.business.sale.SaleServiceMgr;
import dwz.business.sale.SearchSaleVO;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/purchase")
public class PurchaseController extends BaseController {
	
	@Autowired
	private ProviderProductServiceMgr providerProductServiceMgr;
	@Autowired
	private SaleServiceMgr saleServiceMgr;
	@Autowired
	private PurchaseServiceMgr purchaseServiceMgr;
	@Autowired
	private CommonServiceMgr commonServiceMgr;
	
	@RequestMapping("/make")
	public String make(Model model) {
		//List<SaleDetail> saleDetailList = saleServiceMgr.searchSaleForPurchase(getSessionOper());
		//model.addAttribute(saleDetailList);
		return "/purchase/make";
	}
	
	@RequestMapping("/goods")
	public String goods(SearchProviderProductVO vo, Model model) {
		
		int totalCount = providerProductServiceMgr.searchJoinProviderProductCount(vo, getSessionOper());
		List<ProviderProduct> providerProductList = providerProductServiceMgr.searchJoinProviderProduct(vo, getSessionOper());
		model.addAttribute(providerProductList);
		
		model.addAttribute("provider",vo.getProvider());
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/purchase/goods";
		
	}
	
	@SystemLog("制作采购单")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Purchase purchase) {
		purchase.setPurchaseNo(commonServiceMgr.getPaperNo(getSessionOper().getOrgId(), "CG"));
		purchaseServiceMgr.addPurchase(purchase, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listConf")
	public String listConf(Model model) {
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("1");//PURCHASE_STATUS (1-新采购单)
		List<Purchase> purchaseList = purchaseServiceMgr.searchPurchaseForDo(getSessionOper(), statusList);
		model.addAttribute(purchaseList);
		
		return "/purchase/list_conf";
	}
	
	@RequestMapping("/conf/{purchaseId}")
	public String conf(@PathVariable("purchaseId") int purchaseId, Model model) {
		
		Purchase purchase = purchaseServiceMgr.getPurchaseById(purchaseId);
		List<PurchaseDetail> purchaseDetailList = purchaseServiceMgr.findPurchaseDetailByPurchaseId(purchaseId);
		model.addAttribute("purchase", purchase);
		model.addAttribute("purchaseDetailList", purchaseDetailList);
		
		if("1".equals(purchase.getPurchaseProp())){
			return "/purchase/sale_conf";
		}else{
			return "/purchase/conf";
		}
		
	}
	
	@SystemLog("审批采购单")
	@RequestMapping(value = "/doConf", method = RequestMethod.POST)
	public ModelAndView doConf(Purchase purchase) {
		purchaseServiceMgr.updatePurchase(purchase, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listArrival")
	public String listArrival(SearchPurchaseVO vo, Model model) {
		
		List<Purchase> purchaseList = purchaseServiceMgr.searchPurchaseForArrival(vo, getSessionOper());
		model.addAttribute(purchaseList);
		model.addAttribute("provider", vo.getProvider());
		model.addAttribute("purchaseNo", vo.getPurchaseNo());
		
		return "/purchase/list_arrival";
	}
	
	@RequestMapping("/arrivalCheck/{purchaseId}")
	public String arrivalCheck(@PathVariable("purchaseId") int purchaseId, Model model, HttpServletResponse response) {
		int count = purchaseServiceMgr.getUnArrivalCount(purchaseId);
		if(count > 0){
			this.responseJson("1", response);
		}else{
			this.responseJson("0", response);
		}
		return null;
	}
	
	@RequestMapping("/arrival/{purchaseId}")
	public String arrival(@PathVariable("purchaseId") int purchaseId, Model model) {
		
		Purchase purchase = purchaseServiceMgr.getPurchaseById(purchaseId);
		List<PurchaseDetail> purchaseDetailList = purchaseServiceMgr.findPurchaseDetailByPurchaseId(purchaseId);
		model.addAttribute("purchase", purchase);
		model.addAttribute("purchaseDetailList", purchaseDetailList);
		
		if("1".equals(purchase.getPurchaseProp())){
			return "/purchase/sale_arrival";
		}else{
			return "/purchase/arrival";
		}
	}
	
	@SystemLog("登记到货")
	@RequestMapping(value = "/doArrival", method = RequestMethod.POST)
	public ModelAndView doArrival(Purchase purchase, Arrival arrival) {
		String arrivalNo = commonServiceMgr.getPaperNo(getSessionOper().getOrgId(), "JC");
		purchaseServiceMgr.addPurchaseArrival(purchase, arrival, arrivalNo, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listOver")
	public String listOver(Model model) {
		
		List<Arrival> purchaseList = purchaseServiceMgr.searchArrival(getSessionOper());
		model.addAttribute(purchaseList);
		
		return "/purchase/list_over";
	}
	
	@RequestMapping("/over/{arrivalId}")
	public String over(@PathVariable("arrivalId") int arrivalId, Model model) {
		
		Arrival arrival = purchaseServiceMgr.getArrivalById(arrivalId);
		Purchase purchase = purchaseServiceMgr.getPurchaseById(arrival.getPurchaseId());
		List<ArrivalDetail> arrivalDetailList = purchaseServiceMgr.findArrivalDetailByArrivalId(arrivalId);
		model.addAttribute("arrival", arrival);
		model.addAttribute("purchase", purchase);
		model.addAttribute("arrivalDetailList", arrivalDetailList);
		
		if("1".equals(purchase.getPurchaseProp())){
			return "/purchase/sale_over";
		}else{
			return "/purchase/over";
		}
	}
	
	@SystemLog("到货确认")
	@RequestMapping(value = "/doOver", method = RequestMethod.POST)
	public ModelAndView doOver(int arrivalId, int providerId, String providerName) {
		
		purchaseServiceMgr.doOver(arrivalId, providerId, providerName, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listSearch")
	public String listSearch(SearchPurchaseVO vo, Model model) {
		
		int totalCount = purchaseServiceMgr.searchPurchaseCount(vo, getSessionOper());
		List<Purchase> purchaseList = purchaseServiceMgr.searchPurchase(vo, getSessionOper());
		model.addAttribute(purchaseList);
		model.addAttribute("provider",vo.getProvider());
		model.addAttribute("product",vo.getProduct());
		model.addAttribute("saleNo", vo.getSaleNo());
		model.addAttribute("status", vo.getStatus());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/purchase/list_search";
	}
	
	@RequestMapping("/detail/{purchaseId}/{busiType}/{targetLeafId}")
	public String detail(@PathVariable("purchaseId") int purchaseId, @PathVariable("busiType") String busiType, @PathVariable("targetLeafId") int targetLeafId, Model model) {
		
		Purchase purchase = purchaseServiceMgr.getPurchaseById(purchaseId);
		List<PurchaseDetail> purchaseDetailList = purchaseServiceMgr.findPurchaseDetailByPurchaseId(purchaseId);
		List<Arrival> arrivalList = purchaseServiceMgr.findArrivalByPurchaseId(purchaseId);
		for(Arrival arrival : arrivalList){
			List<ArrivalDetail> arrivalDetailList = purchaseServiceMgr.findArrivalDetailByArrivalId(arrival.getArrivalId());
			arrival.setArrivalDetailList(arrivalDetailList);
		}
		
		model.addAttribute("purchase", purchase);
		model.addAttribute("purchaseDetailList", purchaseDetailList);
		model.addAttribute("arrivalList", arrivalList);
		model.addAttribute("busiType", busiType);
		model.addAttribute("targetLeafId", targetLeafId);
		
		if("1".equals(purchase.getPurchaseProp())){
			return "/purchase/sale_detail";
		}else{
			return "/purchase/detail";
		}
	}
	
	@SystemLog("强制结束单据")
	@RequestMapping("/forceOver/{purchaseId}")
	public ModelAndView forceOver(@PathVariable("purchaseId") int purchaseId) {

		int arrivalCount = purchaseServiceMgr.getUnArrivalCount(purchaseId);
		if(arrivalCount > 0){
			return ajaxDoneError("存在未收货确认的入仓单，无法强制结束。");
		}
		purchaseServiceMgr.forceOver(purchaseId,getSessionOper());

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/saleMake")
	public String saleMake(Model model) {
		//List<SaleDetail> saleDetailList = saleServiceMgr.searchSaleForPurchase(getSessionOper());
		//model.addAttribute(saleDetailList);
		return "/purchase/make_sale";
	}
	
	@RequestMapping("/saleGoods")
	public String saleGoods(SearchSaleDetailVO vo, int providerId, Model model) {
		
		List<SaleDetail> saleDetailList = saleServiceMgr.searchSaleDetail(vo, providerId, getSessionOper());
		model.addAttribute(saleDetailList);
		
		model.addAttribute("providerId", providerId);
		model.addAttribute("sale", vo.getSale());
		
		return "/purchase/sale_goods";
		
	}
	
	@SystemLog("导出采购单")
	@RequestMapping(value = "/exportPurchase/{purchaseId}")
	public ModelAndView exportPurchase(@PathVariable("purchaseId") int purchaseId ,HttpServletResponse response) {
		
		Purchase purchase = purchaseServiceMgr.getPurchaseById(purchaseId);
		List<PurchaseDetail> purchaseDetailList = purchaseServiceMgr.findPurchaseDetailByPurchaseId(purchaseId);
		
		PurchaseExportUtil.exportToExcel(purchase, purchaseDetailList, getSessionOper(), response);
		
		return null;
	}
	
	@SystemLog("导出入仓单")
	@RequestMapping(value = "/exportArrival/{arrivalId}")
	public ModelAndView exportArrival(@PathVariable("arrivalId") int arrivalId ,HttpServletResponse response) {
		
		Arrival arrival = purchaseServiceMgr.getArrivalById(arrivalId);
		Purchase purchase = purchaseServiceMgr.getPurchaseById(arrival.getPurchaseId());
		List<ArrivalDetail> arrivalDetailList = purchaseServiceMgr.findArrivalDetailByArrivalId(arrivalId);
		
		ArrivalExportUtil.exportToExcel(purchase, arrival, arrivalDetailList, getSessionOper(), response);
		
		return null;
	}
	
	@RequestMapping("/listSale")
	public String listSale(SearchSaleVO vo, Model model) {
		
		int totalCount = saleServiceMgr.searchPurSaleCount(vo, getSessionOper());
		List<Sale> saleList = saleServiceMgr.searchPurSale(vo, getSessionOper());
		
		model.addAttribute(saleList);
		model.addAttribute("consumer", vo.getConsumer());
		model.addAttribute("product",vo.getProduct());
		model.addAttribute("saleNo", vo.getSaleNo());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/purchase/list_sale";
	}
	
	@RequestMapping("/salePur/{saleId}")
	public String salePur(@PathVariable("saleId") int saleId, Model model) {
		
		Sale sale = saleServiceMgr.getSaleById(saleId);
		List<SaleDetail> saleDetailList = saleServiceMgr.findSaleDetailForPur(saleId);
		
		model.addAttribute("sale", sale);
		model.addAttribute("saleDetailList", saleDetailList);
		
		return "/purchase/salePur";
	}
	
	@RequestMapping("/goPurReg/{saleDetailId}")
	public String goPurReg(@PathVariable("saleDetailId") int saleDetailId, Model model) {
		
		SaleDetail saleDetail = saleServiceMgr.getSaleDetailForPur(saleDetailId);
		Sale sale = saleServiceMgr.getSaleById(saleDetail.getSaleId());
		List<ProviderProduct> providerProductList = saleServiceMgr.findPurchasePlan(saleDetail, getSessionOper());
		
		model.addAttribute("sale", sale);
		model.addAttribute("saleDetail", saleDetail);
		model.addAttribute("providerProductList", providerProductList);
		
		return "/purchase/purReg";
	}
	
	@SystemLog("制作采购单")
	@RequestMapping(value = "/insertSalePur", method = RequestMethod.POST)
	public ModelAndView insertSalePur(AddPurchaseVO addPurchaseVO) {
		purchaseServiceMgr.addSalePurchase(addPurchaseVO, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
}
