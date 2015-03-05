package dwz.web.sale;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.icu.text.SimpleDateFormat;

import dwz.business.common.CommonServiceMgr;
import dwz.business.goods.ProviderProduct;
import dwz.business.goods.ProviderProductServiceMgr;
import dwz.business.goods.SearchProviderProductVO;
import dwz.business.partner.Consumer;
import dwz.business.partner.ConsumerServiceMgr;
import dwz.business.sale.Deliver;
import dwz.business.sale.DeliverDetail;
import dwz.business.sale.Sale;
import dwz.business.sale.SaleBack;
import dwz.business.sale.SaleBackDetail;
import dwz.business.sale.SaleServiceMgr;
import dwz.business.sale.SearchFinishDeliverVO;
import dwz.business.sale.SearchSaleBackVO;
import dwz.business.stock.Stock;
import dwz.persistence.beans.BalConsume;
import dwz.persistence.beans.RptSaleBackColl;
import dwz.persistence.beans.SalSaleBackDetail;
import dwz.persistence.beans.StoStockChange;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/sale/back")
public class SaleBackController extends BaseController{
	
	@Autowired
	private SaleServiceMgr saleServiceMgr;
	@Autowired
	private CommonServiceMgr commonServiceMgr;
	@Autowired
	private ProviderProductServiceMgr providerProductServiceMgr;
	@Autowired
	private ConsumerServiceMgr consumerServiceMgr;
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/sale/back/add";
	}
	
	@RequestMapping("/product")
	public String goods(SearchProviderProductVO vo, Model model) {
		
		int totalCount = providerProductServiceMgr.searchJoinProviderProductCount(vo, getSessionOper());
		List<ProviderProduct> providerProductList = providerProductServiceMgr.searchJoinProviderProduct(vo, getSessionOper());
		model.addAttribute(providerProductList);
		
		model.addAttribute("provider",vo.getProvider());
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/sale/back/product";
		
	}
	
	@SystemLog("制作销售退货单（自由退货）")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(SaleBack saleBack) {
		saleBack.setSaleBackNo(commonServiceMgr.getPaperNo(getSessionOper().getOrgId(), "XT"));
		saleServiceMgr.addSaleBack(saleBack, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listDeal")
	public String listDeal(Model model) {
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("1");//SALE_BACK_STATUS (1-待审核)
		List<SaleBack> saleBackList = saleServiceMgr.searchSaleBackForDo(getSessionOper(), statusList);
		model.addAttribute(saleBackList);
		
		return "/sale/back/list_deal";
	}
	
	@RequestMapping("/deal/{saleBackId}")
	public String conf(@PathVariable("saleBackId") int saleBackId, Model model) {
		
		SaleBack saleBack = saleServiceMgr.getSaleBackById(saleBackId);
		List<SaleBackDetail> saleBackDetailList = saleServiceMgr.findSaleBackDetailBySaleBackId(saleBackId);
		model.addAttribute("saleBack", saleBack);
		model.addAttribute("saleBackDetailList", saleBackDetailList);
		
		return "/sale/back/deal";
	}
	
	@SystemLog("销售退货处理")
	@RequestMapping(value = "/doDeal", method = RequestMethod.POST)
	public ModelAndView doDeal(SaleBack saleBack) {
		if("2".equals(saleBack.getStatus())){//SALE_BACK_STATUS(2-已完成)
			boolean noDeal = false;
			StringBuffer sb = new StringBuffer();
			List<SaleBackDetail> saleBackDetailList = saleBack.getSaleBackDetailList();
			int i = 0;
			for(SaleBackDetail boDetail : saleBackDetailList){
				Integer stockQuantity = boDetail.getStockQuantity();
				Integer providerQuantity = boDetail.getProviderQuantity();
				Integer destroyQuantity = boDetail.getDestroyQuantity();
				if(stockQuantity==null && providerQuantity==null && destroyQuantity==null){
					noDeal = true;
					break;
				}
				
				int dealQuantity = 0;
				if(stockQuantity!=null){
					dealQuantity += stockQuantity;
				}else{
					boDetail.setStockQuantity(0);
				}
				if(providerQuantity!=null){
					dealQuantity += providerQuantity;
				}else{
					boDetail.setProviderQuantity(0);
				}
				if(destroyQuantity!=null){
					dealQuantity += destroyQuantity;
				}else{
					boDetail.setDestroyQuantity(0);
				}
				if(dealQuantity != boDetail.getBackQuantity()){
					if(sb.length() == 0){
						sb.append(i);
					}else{
						sb.append(","+i);
					}
				}
				i++;
			}
			
			if(noDeal){
				return ajaxDoneError("存在未处理的退货记录，请检查！");
			}
			if(sb.length() > 0){
				return ajaxDoneError("处理数量必须与退货数量一致！#"+sb);
			}
		}
		saleServiceMgr.doDeal(saleBack, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listFinishDeliver")
	public String listFinishDeliver(SearchFinishDeliverVO vo, Model model) {
		
		int totalCount = saleServiceMgr.searchFinishDeliverCount(vo, getSessionOper());
		List<Deliver> deliverList = saleServiceMgr.searchFinishDeliver(vo, getSessionOper());
		model.addAttribute(deliverList);
		model.addAttribute("consumer", vo.getConsumer());
		model.addAttribute("saleNo", vo.getSaleNo());
		model.addAttribute("deliverNo", vo.getDeliverNo());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/sale/back/list_finishDeliver";
	}
	
	@RequestMapping("/refAdd/{deliverId}")
	public String refAdd(@PathVariable("deliverId") int deliverId, Model model) {
		Deliver deliver = saleServiceMgr.getDeliverById(deliverId);
		List<DeliverDetail> deliverDetailList = saleServiceMgr.findDeliverDetail(deliverId);
		Sale sale = saleServiceMgr.getSaleById(deliver.getSaleId());
		Consumer consumer = consumerServiceMgr.getConsumer(sale.getConsumerId());
		model.addAttribute("deliver", deliver);
		model.addAttribute("deliverDetailList", deliverDetailList);
		model.addAttribute("sale", sale);
		model.addAttribute("consumer", consumer);
		return "/sale/back/add_ref";
	}
	
	@RequestMapping("/list")
	public String list(SearchSaleBackVO vo, Model model) {
		
		int totalCount = saleServiceMgr.searchSaleBackCount(vo, getSessionOper());
		List<SaleBack> saleBackList = saleServiceMgr.searchSaleBack(vo, getSessionOper());
		
		model.addAttribute(saleBackList);
		model.addAttribute("consumer", vo.getConsumer());
		model.addAttribute("saleNo", vo.getSaleNo());
		model.addAttribute("deliverNo", vo.getDeliverNo());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/sale/back/list";
	}
	
	@RequestMapping("/detail/{saleBackId}")
	public String detail(@PathVariable("saleBackId") int saleBackId, Model model) {
		
		SaleBack saleBack = saleServiceMgr.getSaleBackById(saleBackId);
		List<SaleBackDetail> saleBackDetailList = saleServiceMgr.findSaleBackDetailBySaleBackId(saleBackId);
		model.addAttribute("saleBack", saleBack);
		model.addAttribute("saleBackDetailList", saleBackDetailList);
		
		return "/sale/back/detail";
	}

}
