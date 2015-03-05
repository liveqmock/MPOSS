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
import dwz.business.partner.Consumer;
import dwz.business.partner.ConsumerServiceMgr;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/account/sale")
public class SaleAccountController extends BaseController{
	
	@Autowired
	private BillServiceMgr billServiceMgr;
	@Autowired
	private ConsumerServiceMgr consumerServiceMgr;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<BillBusiBO> billBusiBOList = billServiceMgr.searchSaleBillBusi(getSessionOper());
		model.addAttribute(billBusiBOList);
		return "/account/sale/list";
	}
	
	@RequestMapping("/consumeDetail/{targetId}")
	public String consumeDetail(@PathVariable("targetId") int targetId, Model model) {
		Consumer consumer = consumerServiceMgr.getConsumer(targetId);
		List<Consume> consumeList = billServiceMgr.findConsumeForSaleBill(targetId, getSessionOper());
		model.addAttribute("consumeList", consumeList);
		model.addAttribute("targetName", consumer.getConsumerName());
		return "/account/sale/consumeList";
	}
	
	@RequestMapping("/payDetail/{targetId}")
	public String payDetail(@PathVariable("targetId") int targetId, Model model) {
		List<Trans> transList = billServiceMgr.findSaleHisTrans(targetId, getSessionOper());
		model.addAttribute("transList", transList);
		return "/account/sale/transList";
	}
	
	@SystemLog("结束收款")
	@RequestMapping("/over/{targetId}")
	public ModelAndView over(@PathVariable("targetId") int targetId, Model model) {
		
		billServiceMgr.saleBillOver(targetId, getSessionOper());
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
}
