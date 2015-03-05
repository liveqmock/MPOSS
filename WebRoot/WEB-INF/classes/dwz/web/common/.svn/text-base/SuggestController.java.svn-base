package dwz.web.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.business.account.Account;
import dwz.business.common.SuggestServiceMgr;
import dwz.business.sale.Sale;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/suggest")
public class SuggestController extends BaseController {
	
	@Autowired
	private SuggestServiceMgr suggestServiceMgr;
	
	@RequestMapping("/suggestAccount")
	public String suggestAccount(Model model) {
		List<Account> accountList = suggestServiceMgr.suggestAccount(getSessionOper());
		model.addAttribute("accountList", accountList);
		return "/suggest/account";
	}
	
	@RequestMapping("/suggestSaleForPur")
	public String suggestSaleForPur(Model model) {
		List<Sale> saleList = suggestServiceMgr.suggestSaleForPur(getSessionOper());
		model.addAttribute("saleList", saleList);
		return "/suggest/sale";
	}
	
	@RequestMapping("/suggestPriceAction")
	public String suggestPriceAction(Model model) {
		return "/suggest/priceAction";
	}
	
	@RequestMapping("/suggestTransItem")
	public String suggestTransItem(Model model) {
		return "/suggest/transItem";
	}
	
	@RequestMapping("/suggestBillType/{priceAction}")
	public String suggestBillType(@PathVariable("priceAction") String priceAction,Model model) {
		List<String> billTypeList = suggestServiceMgr.loadBillType(priceAction);
		model.addAttribute("billTypeList", billTypeList);
		return "/suggest/billType";
	}
	
}
