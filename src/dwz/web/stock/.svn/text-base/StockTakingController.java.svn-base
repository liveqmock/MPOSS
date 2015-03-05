package dwz.web.stock;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.common.CommonServiceMgr;
import dwz.business.stock.SearchStockTakingVO;
import dwz.business.stock.SearchStockVO;
import dwz.business.stock.Stock;
import dwz.business.stock.StockServiceMgr;
import dwz.business.stock.StockTaking;
import dwz.business.stock.StockTakingDetail;
import dwz.business.stock.StockTakingServiceMgr;
import dwz.business.stock.StockTakingTemp;
import dwz.business.stock.StockTakingTempServiceMgr;
import dwz.business.stock.StockTakingTempVO;
import dwz.business.stock.TakingExportUtil;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/stock/taking")
public class StockTakingController extends BaseController {
	
	@Autowired
	private StockTakingServiceMgr stockTakingServiceMgr;
	@Autowired
	private StockServiceMgr stockServiceMgr;
	@Autowired
	private StockTakingTempServiceMgr stockTakingTempServiceMgr;
	@Autowired
	private CommonServiceMgr commonServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchStockTakingVO vo, Model model) {
		
		int totalCount = stockTakingServiceMgr.searchStockTakingCount(vo, getSessionOper());
		List<StockTaking> stockTakingList = stockTakingServiceMgr.searchStockTaking(vo, getSessionOper());
		model.addAttribute(stockTakingList);
		model.addAttribute("provider", vo.getProvider());
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("status", vo.getStatus());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		model.addAttribute("stockTakingNo", vo.getStockTakingNo());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/stock/taking/list";
	}
	
	@RequestMapping("/takingDetail/{stockTakingId}/{busiType}/{targetLeafId}")
	public String takingDetail(@PathVariable("stockTakingId") int stockTakingId, @PathVariable("busiType") String busiType, @PathVariable("targetLeafId") int targetLeafId, Model model) {
		
		StockTaking stockTaking = stockTakingServiceMgr.getStockTakingById(stockTakingId);
		List<StockTakingDetail> stockTakingDetailList = stockTakingServiceMgr.searchStockTakingDetailByStockTakingId(stockTakingId);
		model.addAttribute("stockTaking", stockTaking);
		model.addAttribute("stockTakingDetailList", stockTakingDetailList);
		model.addAttribute("busiType", busiType);
		model.addAttribute("targetLeafId", targetLeafId);
		
		return "/stock/taking/taking_detail";
	}
	
	@RequestMapping("/listReg")
	public String listReg(Model model) {
		List<StockTakingTemp> stockTakingTempList = stockTakingTempServiceMgr.searchStockTakingTemp(getSessionOper());
		model.addAttribute(stockTakingTempList);
		return "/stock/taking/list_reg";
	}
	
	@RequestMapping("/del/{stockTakingTempId}")
	public ModelAndView del(@PathVariable("stockTakingTempId") int stockTakingTempId) {

		stockTakingTempServiceMgr.del(stockTakingTempId);

		return ajaxDoneSuccess("");
	}
	
	@SystemLog("盘库登记")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(StockTaking stockTaking, Model model) {
		stockTaking.setStockTakingNo(commonServiceMgr.getPaperNo(getSessionOper().getOrgId(), "PK"));
		stockTakingServiceMgr.insert(stockTaking, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/insertTemp", method = RequestMethod.POST)
	public ModelAndView insertTemp(StockTakingTempVO vo, Model model) {
		
		stockTakingTempServiceMgr.insertTemp(vo, getSessionOper());
		return ajaxDoneSuccess("盘点数据添加成功！");
	}
	
	@RequestMapping("/listConf")
	public String listConf(Model model) {
		
		List<StockTaking> stockTakingList = stockTakingServiceMgr.searchStockTakingForConf(getSessionOper());
		model.addAttribute(stockTakingList);
		
		return "/stock/taking/list_conf";
	}
	
	@RequestMapping("/conf/{stockTakingId}")
	public String conf(@PathVariable("stockTakingId") int stockTakingId, Model model) {
		
		StockTaking stockTaking = stockTakingServiceMgr.getStockTakingById(stockTakingId);
		List<StockTakingDetail> stockTakingDetailList = stockTakingServiceMgr.searchStockTakingDetailByStockTakingId(stockTakingId);
		model.addAttribute("stockTaking",stockTaking);
		model.addAttribute(stockTakingDetailList);
		
		return "/stock/taking/conf";
	}
	
	@SystemLog("审批盘库单")
	@RequestMapping(value = "/doConf", method = RequestMethod.POST)
	public ModelAndView doConf(StockTaking stockTaking) {
		
		stockTakingServiceMgr.doConf(stockTaking, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listStock")
	public String listStock(SearchStockVO vo, Model model) {
		int totalCount = stockServiceMgr.searchStockCountForTaking(vo, getSessionOper());
		List<Stock> stockList = stockServiceMgr.searchStockForTaking(vo, getSessionOper());
		model.addAttribute(stockList);
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("provider", vo.getProvider());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/stock/taking/list_stock";
	}
	
	@SystemLog("导出盘库单")
	@RequestMapping(value = "/exportTaking/{stockTakingId}")
	public ModelAndView exportTaking(@PathVariable("stockTakingId") int stockTakingId ,HttpServletResponse response) {
		
		StockTaking stockTaking = stockTakingServiceMgr.getStockTakingById(stockTakingId);
		List<StockTakingDetail> stockTakingDetailList = stockTakingServiceMgr.searchStockTakingDetailByStockTakingId(stockTakingId);
		TakingExportUtil.exportToExcel(stockTaking, stockTakingDetailList, getSessionOper(), response);
		
		return null;
	}
	
}
