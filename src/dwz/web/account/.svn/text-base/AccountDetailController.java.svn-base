package dwz.web.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.business.account.AccountDetailServiceMgr;
import dwz.business.account.SearchTransVO;
import dwz.business.account.Trans;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/account/detail")
public class AccountDetailController extends BaseController{
	
	@Autowired
	private AccountDetailServiceMgr accountDetailServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchTransVO req, Model model) {
		
		int totalCount = accountDetailServiceMgr.searchTransCount(getSessionOper(), req);
		List<Trans> transList = accountDetailServiceMgr.searchTrans(getSessionOper(),req);
		model.addAttribute("transList", transList);
		
		model.addAttribute("transItem",req.getTransItem());
		model.addAttribute("accountType",req.getAccountType());
		model.addAttribute("accountNo",req.getAccountNo());
		model.addAttribute("startDate", req.getStartDate());
		model.addAttribute("endDate", req.getEndDate());
		model.addAttribute("pageNum", req.getPageNum());
		model.addAttribute("numPerPage", req.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/account/detail/list";
	}
	
	@RequestMapping("/info/{busiPaperId}")
	public String info(@PathVariable("busiPaperId") int busiPaperId,Model model) {
		return "/account/detail/info";
	}

}
