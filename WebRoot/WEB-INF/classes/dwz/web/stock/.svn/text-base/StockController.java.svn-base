package dwz.web.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dwz.business.stock.SearchStockChangeVO;
import dwz.business.stock.SearchStockVO;
import dwz.business.stock.Stock;
import dwz.business.stock.StockChange;
import dwz.business.stock.StockLock;
import dwz.business.stock.StockServiceMgr;
import dwz.web.BaseController;

@Controller
@RequestMapping(value="/stock")
public class StockController extends BaseController {
	
	@Autowired
	private StockServiceMgr stockServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchStockVO vo, Model model) {
		
		int totalCount = stockServiceMgr.searchMergeStockCount(vo, getSessionOper());
		List<Stock> stockList = stockServiceMgr.searchMergeStock(vo, getSessionOper());
		model.addAttribute(stockList);
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("provider", vo.getProvider());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/stock/list";
	}
	
	@RequestMapping("/listChange")
	public String listChange(SearchStockChangeVO vo, Model model) {
		
		int totalCount = stockServiceMgr.searchStockChangeCount(vo, getSessionOper());
		List<StockChange> stockChangeList = stockServiceMgr.searchStockChange(vo, getSessionOper());
		model.addAttribute(stockChangeList);
		model.addAttribute("provider", vo.getProvider());
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("changeAction", vo.getChangeAction());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/stock/list_change";
	}
	
	@RequestMapping("/lockInfo/{providerProductId}")
	public String lockInfo(@PathVariable("providerProductId") int providerProductId, Model model) {
		
		List<StockLock> stockLockList = stockServiceMgr.searchStockLock(providerProductId);
		model.addAttribute(stockLockList);
		return "/stock/lockInfo";
	}
	
	@RequestMapping("/canUseInfo/{providerProductId}")
	public String canUseInfo(@PathVariable("providerProductId") int providerProductId, Model model) {
		
		List<Stock> stockList = stockServiceMgr.searchStock(providerProductId);
		model.addAttribute(stockList);
		return "/stock/canUseInfo";
	}
	
	@RequestMapping("/totalInfo/{providerProductId}")
	public String totalInfo(@PathVariable("providerProductId") int providerProductId, Model model) {
		
		List<Stock> stockList = stockServiceMgr.searchStock(providerProductId);
		model.addAttribute(stockList);
		return "/stock/totalInfo";
	}
	
	@RequestMapping("/providerInfo/{providerProductId}")
	public String providerInfo(@PathVariable("providerProductId") int providerProductId, Model model) {
		
		List<Stock> stockList = stockServiceMgr.searchStock(providerProductId);
		model.addAttribute(stockList);
		return "/stock/providerInfo";
	}
	
}
