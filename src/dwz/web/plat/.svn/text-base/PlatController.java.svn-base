package dwz.web.plat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.plat.Assess;
import dwz.business.plat.Pay;
import dwz.business.plat.PlatServiceMgr;
import dwz.business.plat.Suggest;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/plat")
public class PlatController extends BaseController{
	
	@Autowired
	private PlatServiceMgr platServiceMgr;
	
	@RequestMapping("/listPay")
	public String listPay(Model model) {
		List<Pay> payList = platServiceMgr.searchPay(getSessionOper());
		model.addAttribute(payList);
		return "/plat/list_pay";
	}
	
	@RequestMapping("/addAssess")
	public String addAssess(Model model) {
		return "/plat/add_assess";
	}
	
	@RequestMapping(value = "/insertAssess", method = RequestMethod.POST)
	public ModelAndView insertAssess(Assess assess) {
		platServiceMgr.insertAssess(assess,getSessionOper());
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/addSuggest")
	public String addSuggest(Model model) {
		return "/plat/add_suggest";
	}
	
	@RequestMapping(value = "/insertSuggest", method = RequestMethod.POST)
	public ModelAndView insertSuggest(Suggest suggest) {
		platServiceMgr.insertSuggest(suggest,getSessionOper());
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

}
