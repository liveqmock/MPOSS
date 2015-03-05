package dwz.web.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.account.BillBusiBO;
import dwz.business.account.BillServiceMgr;
import dwz.business.account.Consume;
import dwz.business.account.Trans;
import dwz.business.partner.Provider;
import dwz.business.partner.ProviderServiceMgr;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/account/purchase")
public class PurchaseAccountController extends BaseController{
	
	@Autowired
	private BillServiceMgr billServiceMgr;
	@Autowired
	private ProviderServiceMgr providerServiceMgr;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<BillBusiBO> billBusiBOList = billServiceMgr.searchPurchaseBillBusi(getSessionOper());
		model.addAttribute(billBusiBOList);
		return "/account/purchase/list";
	}
	
	@RequestMapping("/consumeDetail/{targetId}")
	public String consumeDetail(@PathVariable("targetId") int targetId, Model model) {
		Provider provider = providerServiceMgr.getProvider(targetId);
		List<Consume> consumeList = billServiceMgr.findConsumeForPurchaseBill(targetId, getSessionOper());
		model.addAttribute("consumeList", consumeList);
		model.addAttribute("targetName", provider.getProviderName());
		return "/account/purchase/consumeList";
	}
	
	@RequestMapping("/payDetail/{targetId}")
	public String payDetail(@PathVariable("targetId") int targetId, Model model) {
		List<Trans> transList = billServiceMgr.findPurchaseHisTrans(targetId, getSessionOper());
		model.addAttribute("transList", transList);
		return "/account/purchase/transList";
	}
	
	@SystemLog("结束付款")
	@RequestMapping("/over/{targetId}")
	public ModelAndView over(@PathVariable("targetId") int targetId, Model model) {
		
		billServiceMgr.purchaseBillOver(targetId, getSessionOper());
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
}
