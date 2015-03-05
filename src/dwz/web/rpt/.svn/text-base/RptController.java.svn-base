package dwz.web.rpt;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.business.account.Trans;
import dwz.business.partner.Consumer;
import dwz.business.partner.ConsumerServiceMgr;
import dwz.business.partner.Provider;
import dwz.business.partner.ProviderServiceMgr;
import dwz.business.rpt.ProfitColl;
import dwz.business.rpt.PurchaseColl;
import dwz.business.rpt.RptServiceMgr;
import dwz.business.rpt.SaleBackColl;
import dwz.business.rpt.SaleColl;
import dwz.business.rpt.SearchCostCollVO;
import dwz.business.rpt.SearchProfitCollVO;
import dwz.business.rpt.SearchPurchaseCollVO;
import dwz.business.rpt.SearchSaleBackCollVO;
import dwz.business.rpt.SearchSaleCollVO;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/rpt")
public class RptController extends BaseController {
	
	@Autowired
	private RptServiceMgr rptServiceMgr;
	@Autowired
    private ConsumerServiceMgr consumerServiceMgr;
	@Autowired
	private ProviderServiceMgr providerServiceMgr;
	
	@RequestMapping("/listSaleColl")
	public String listSaleColl(SearchSaleCollVO vo, Model model) {
		
		List<SaleColl> saleCollList = rptServiceMgr.searchSaleColl(vo, getSessionOper());
		model.addAttribute(saleCollList);
		model.addAttribute("saleType", vo.getSaleType());
		model.addAttribute("consumer", vo.getConsumer());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		
		return "/rpt/sale_coll";
	}
	
	@RequestMapping("/findSaleCollDetail/{transDate}/{consumerId}")
	public String findSaleCollDetail(@PathVariable("transDate") String transDate, @PathVariable("consumerId") int consumerId, Model model) {
		
		Consumer consumer = consumerServiceMgr.getConsumer(consumerId);
		List<SaleColl> saleCollList = rptServiceMgr.searchSaleCollDetail(getSessionOper().getOrgId(), transDate, consumerId);
		model.addAttribute("consumerName", consumer.getConsumerName());
		model.addAttribute("transDate", transDate);
		model.addAttribute(saleCollList);
		return "/rpt/sale_coll_detail";
		
	}
	
	@RequestMapping("/listPurchaseColl")
	public String listPurchaseColl(SearchPurchaseCollVO vo, Model model) {
		
		List<PurchaseColl> purchaseCollList = rptServiceMgr.searchPurchaseColl(vo, getSessionOper());
		model.addAttribute(purchaseCollList);
		model.addAttribute("purchaseProp", vo.getPurchaseProp());
		model.addAttribute("provider", vo.getProvider());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		
		return "/rpt/purchase_coll";
	}
	
	@RequestMapping("/findPurchaseCollDetail/{transDate}/{providerId}")
	public String findPurchaseCollDetail(@PathVariable("transDate") String transDate, @PathVariable("providerId") int providerId, Model model) {
		
		Provider provider = providerServiceMgr.getProvider(providerId);
		List<PurchaseColl> purchaseCollList = rptServiceMgr.searchPurchaseCollDetail(getSessionOper().getOrgId(), transDate, providerId);
		model.addAttribute("providerName", provider.getProviderName());
		model.addAttribute("transDate", transDate);
		model.addAttribute(purchaseCollList);
		return "/rpt/purchase_coll_detail";
		
	}
	
	@RequestMapping("/listCostColl")
	public String listCostColl(SearchCostCollVO vo, Model model) {
		
		List<Trans> transList = rptServiceMgr.searchCostColl(vo, getSessionOper());
		
		Set<String> dateSet = new LinkedHashSet<String>();
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		for(Trans trans : transList){
			dateSet.add(trans.getTransDate());
			String key = trans.getTransDate()+"#"+trans.getTransItem()+"#"+trans.getTransDire();
			Integer value = trans.getSumTransPrice();
			dataMap.put(key, value);
		}
		
		model.addAttribute("dateSet", dateSet);
		model.addAttribute("dataMap", dataMap);
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		
		return "/rpt/cost_coll";
	}
	
	@RequestMapping("/findCostCollDetail/{transDate}/{transItem}/{transDire}")
	public String findCostCollDetail(@PathVariable("transDate") String transDate, @PathVariable("transItem") String transItem, @PathVariable("transDire") String transDire, Model model) {
		
		List<Trans> transList = rptServiceMgr.searchCostCollDetail(getSessionOper().getOrgId(), transDate, transItem, transDire);
		model.addAttribute("transDate", transDate);
		model.addAttribute("transItem", transItem);
		model.addAttribute("transDire", transDire);
		model.addAttribute(transList);
		return "/rpt/cost_coll_detail";
		
	}
	
	@RequestMapping("/listProfitColl")
	public String listProfitColl(SearchProfitCollVO vo, Model model) {
		
		List<ProfitColl> profitCollList = rptServiceMgr.searchProfitColl(vo, getSessionOper());
		model.addAttribute(profitCollList);
		model.addAttribute("saleType", vo.getSaleType());
		model.addAttribute("consumer", vo.getConsumer());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		
		return "/rpt/profit_coll";
	}
	
	@RequestMapping("/findProfitCollDetail/{transDate}/{consumerId}")
	public String findProfitCollDetail(@PathVariable("transDate") String transDate, @PathVariable("consumerId") int consumerId, Model model) {
		
		Consumer consumer = consumerServiceMgr.getConsumer(consumerId);
		List<ProfitColl> profitCollList = rptServiceMgr.searchProfitCollDetail(getSessionOper().getOrgId(), transDate, consumerId);
		model.addAttribute("consumerName", consumer.getConsumerName());
		model.addAttribute("transDate", transDate);
		model.addAttribute(profitCollList);
		return "/rpt/profit_coll_detail";
		
	}
	
	@RequestMapping("/listSaleBackColl")
	public String listSaleBackColl(SearchSaleBackCollVO vo, Model model) {
		
		List<SaleBackColl> saleBackCollList = rptServiceMgr.searchSaleBackColl(vo, getSessionOper());
		model.addAttribute(saleBackCollList);
		model.addAttribute("saleBackType", vo.getSaleBackType());
		model.addAttribute("consumer", vo.getConsumer());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		
		return "/rpt/saleBack_coll";
	}
	
	@RequestMapping("/findSaleBackCollDetail/{transDate}/{consumerId}")
	public String findSaleBackCollDetail(@PathVariable("transDate") String transDate, @PathVariable("consumerId") int consumerId, Model model) {
		
		Consumer consumer = consumerServiceMgr.getConsumer(consumerId);
		List<SaleBackColl> saleBackCollList = rptServiceMgr.searchSaleBackCollDetail(getSessionOper().getOrgId(), transDate, consumerId);
		model.addAttribute("consumerName", consumer.getConsumerName());
		model.addAttribute("transDate", transDate);
		model.addAttribute(saleBackCollList);
		return "/rpt/saleBack_coll_detail";
		
	}

}
