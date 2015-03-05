package dwz.web.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.account.Account;
import dwz.business.account.AddBatchTrans;
import dwz.business.account.PriceServiceMgr;
import dwz.business.common.CommonServiceMgr;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/account/price")
public class PriceController extends BaseController{
	
	@Autowired
	private PriceServiceMgr priceServiceMgr;
	@Autowired
	private CommonServiceMgr commonServiceMgr;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Account> accountList = priceServiceMgr.searchAccount(getSessionOper());
		model.addAttribute(accountList);
		return "/account/price/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/account/price/add";
	}
	
	@SystemLog("添加银行卡账户")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Account account) {
		priceServiceMgr.addAccount(account,getSessionOper());
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SystemLog("停用银行卡账户")
	@RequestMapping("/disable/{accountId}")
	public ModelAndView disable(@PathVariable("accountId") int accountId) {

		priceServiceMgr.disableAccount(accountId);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SystemLog("启用银行卡账户")
	@RequestMapping("/enable/{accountId}")
	public ModelAndView enable(@PathVariable("accountId") int accountId) {

		priceServiceMgr.enableAccount(accountId);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/batchEdit")
	public String batchEdit(Model model) {
		return "/account/price/batchEdit";
	}
	
	@SystemLog("收支录入")
	@RequestMapping(value = "/insertBatchTrans", method = RequestMethod.POST)
	public ModelAndView insertBatchTrans(AddBatchTrans addBatchTrans) throws Exception{
		if(addBatchTrans.getTransList() == null){
			return ajaxDoneError("没有可以提交的数据！");
		}
		String transNo = commonServiceMgr.getPaperNo(getSessionOper().getOrgId(), "JY");
		priceServiceMgr.addBatchTrans(addBatchTrans,getSessionOper(), transNo);
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
}
