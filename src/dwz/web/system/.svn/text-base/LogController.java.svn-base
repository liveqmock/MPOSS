package dwz.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.business.system.Log;
import dwz.business.system.LogServiceMgr;
import dwz.business.system.SearchLogVO;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/system/log")
public class LogController extends BaseController {
	
	@Autowired
	private LogServiceMgr logServiceMgr;

	@RequestMapping("/list")
	public String list(SearchLogVO vo, Model model) {
		
		int totalCount = logServiceMgr.searchLogCount(vo, getSessionOper());
		List<Log> logList = logServiceMgr.searchLog(vo, getSessionOper());
		model.addAttribute(logList);
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		return "/system/log/list";
	}
}
