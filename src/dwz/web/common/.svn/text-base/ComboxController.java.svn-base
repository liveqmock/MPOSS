package dwz.web.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.business.common.ComboxServiceMgr;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/combox")
public class ComboxController extends BaseController {
	
	@Autowired
	private ComboxServiceMgr comboxServiceMgr;
	
	@RequestMapping("/loadAccountNo/{accountType}")
	public String loadAccountNo(@PathVariable("accountType") String accountType,Model model) {
		List<String> accountNoList = comboxServiceMgr.loadAccountNo(getSessionOper(),accountType);
		model.addAttribute("accountNoList", accountNoList);
		return "/combox/accountNo";
	}
	
	@RequestMapping("/loadAccountNo")
	public String loadAccountNoForBlank(Model model) {
		List<String> accountNoList = comboxServiceMgr.loadAccountNo(getSessionOper(),"");
		model.addAttribute("accountNoList", accountNoList);
		return "/combox/accountNo";
	}
	
	@RequestMapping("/loadTransItem")
	public String loadTransItem(Model model) {
		List<String> transItemList = comboxServiceMgr.loadTransItem();
		model.addAttribute("transItemList", transItemList);
		return "/combox/transItem";
	}
	
	@RequestMapping("/loadBillType/{transItem}")
	public String loadBillType(@PathVariable("transItem") String transItem,Model model) {
		List<String> billTypeList = comboxServiceMgr.loadBillType(transItem);
		model.addAttribute("billTypeList", billTypeList);
		return "/combox/billType";
	}
	
	@RequestMapping("/loadBillType")
	public String loadBillTypeForBlank(Model model) {
		List<String> billTypeList = comboxServiceMgr.loadBillType("");
		model.addAttribute("billTypeList", billTypeList);
		return "/combox/billType";
	}
	
}
