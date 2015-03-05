package dwz.web.sale;

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
import dwz.business.partner.Provider;
import dwz.business.sale.Deliver;
import dwz.business.sale.DeliverDetail;
import dwz.business.sale.Sale;
import dwz.business.sale.SaleDetail;
import dwz.business.sale.SaleServiceMgr;
import dwz.business.sale.SearchSaleVO;
import dwz.business.stock.Stock;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/sale/deliver")
public class SaleDeliverController extends BaseController{
	
	@Autowired
	private SaleServiceMgr saleServiceMgr;
	@Autowired
	private CommonServiceMgr commonServiceMgr;
	
	@RequestMapping("/listBak")
	public String listBak(SearchSaleVO vo, Model model) {
		
		List<Sale> saleList = saleServiceMgr.searchSaleForBak(vo, getSessionOper());
		model.addAttribute(saleList);
		model.addAttribute("consumer", vo.getConsumer());
		model.addAttribute("saleNo", vo.getSaleNo());
		model.addAttribute("purchaseNo", vo.getPurchaseNo());
		
		return "/sale/deliver/list_bak";
	}
	
	@RequestMapping("/bak/{saleId}")
	public String bak(@PathVariable("saleId") int saleId, Model model) {
		
		Sale sale = saleServiceMgr.getSaleById(saleId);
		List<SaleDetail> saleDetailList = saleServiceMgr.findSaleDetailBySaleId(saleId);
		model.addAttribute("sale", sale);
		model.addAttribute("saleDetailList", saleDetailList);
		
		return "/sale/deliver/bak";
	}
	
	@RequestMapping("/goods")
	public String goods(int productId, Model model) {
		
		List<Stock> stockList = saleServiceMgr.searchProviderProduct(productId, getSessionOper());
		model.addAttribute(stockList);
		
		return "/sale/deliver/goods";
		
	}
	
	@SystemLog("备货登记")
	@RequestMapping(value = "/doBak", method = RequestMethod.POST)
	public ModelAndView doBak(Sale sale) {
		
		List<Integer> rowNoList = saleServiceMgr.checkBak(sale, getSessionOper());
		if(rowNoList.size()>0) {
			
			StringBuffer sb = new StringBuffer();
			for(int rowNo : rowNoList){
				if(sb.length() == 0){
					sb.append(rowNo);
				}else{
					sb.append(","+rowNo);
				}
			}
			return ajaxDoneError("提交失败，可用库存不足！#"+sb);
		}
		
		Deliver deliver = saleServiceMgr.getDeliverForBak(sale.getSaleId(),"0");
		boolean createDeliver = false;
		String deliverNo = "";
		if(deliver.getSalDeliver() == null){
			createDeliver = true;
			deliverNo = commonServiceMgr.getPaperNo(getSessionOper().getOrgId(), "ZX");
		} 
		saleServiceMgr.saleBak(sale, deliver, getSessionOper(), createDeliver, deliverNo);
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listBakEdit")
	public String listBakEdit(Model model) {
		
		List<Deliver> deliverList = saleServiceMgr.searchDeliver(getSessionOper());
		model.addAttribute(deliverList);
		
		return "/sale/deliver/list_bakEdit";
	}
	
	@RequestMapping("/listDeliver")
	public String listDeliver(Model model) {
		
		List<Deliver> deliverList = saleServiceMgr.searchDeliver(getSessionOper());
		model.addAttribute(deliverList);
		
		return "/sale/deliver/list_deliver";
	}
	
	@RequestMapping("/deliver/{deliverId}")
	public String deliver(@PathVariable("deliverId") int deliverId, Model model) {
		
		Deliver deliver = saleServiceMgr.getDeliverById(deliverId);
		Sale sale = saleServiceMgr.getSaleById(deliver.getSaleId());
		List<DeliverDetail> deliverDetailList = saleServiceMgr.findDeliverDetail(deliverId);
		model.addAttribute("sale", sale);
		model.addAttribute("deliver",deliver);
		model.addAttribute("deliverDetailList", deliverDetailList);
		
		return "/sale/deliver/deliver";
	}
	
	@SystemLog("发货确认")
	@RequestMapping(value = "/doDeliver", method = RequestMethod.POST)
	public ModelAndView doDeliver(int deliverId, int consumerId, String consumerName) {
		
		Deliver deliver = saleServiceMgr.getDeliverById(deliverId);
		if("1".equals(deliver.getStatus())){
			return ajaxDoneError("操作失败，此装箱单已被发货。");
		}
		if("2".equals(deliver.getStatus())){
			return ajaxDoneError("操作失败，此装箱单已被取消。");
		}
		saleServiceMgr.doDeliver(deliverId, consumerId, consumerName, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/loadProviderForBak")
	public String loadProviderForBak(int productId,String standard,Model model) {
		List<Provider> providerList = saleServiceMgr.loadProviderForBak(getSessionOper(),productId,standard);
		model.addAttribute("providerList", providerList);
		return "/sale/deliver/select_provider";
	}
	
	@RequestMapping("/edit/{deliverId}")
	public String edit(@PathVariable("deliverId") int deliverId, Model model) {
		
		Deliver deliver = saleServiceMgr.getDeliverById(deliverId);
		Sale sale = saleServiceMgr.getSaleById(deliver.getSaleId());
		List<DeliverDetail> deliverDetailList = saleServiceMgr.findDeliverDetail(deliverId);
		model.addAttribute("sale", sale);
		model.addAttribute("deliver",deliver);
		model.addAttribute("deliverDetailList", deliverDetailList);
		
		return "/sale/deliver/edit_deliver";
	}
	
	@SystemLog("装箱单取消")
	@RequestMapping(value = "/doCancel", method = RequestMethod.POST)
	public ModelAndView doCancel(int deliverId) {
		
		saleServiceMgr.doDeliverCancel(deliverId, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SystemLog("装箱单产品删除 ")
	@RequestMapping("/del/{deliverDetailId}")
	public void del(@PathVariable("deliverDetailId") int deliverDetailId, HttpServletResponse response) {
		saleServiceMgr.delDeliverDetail(deliverDetailId, getSessionOper());
	}
	
}
