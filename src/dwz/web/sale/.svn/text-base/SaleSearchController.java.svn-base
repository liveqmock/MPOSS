package dwz.web.sale;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.goods.Product;
import dwz.business.sale.Deliver;
import dwz.business.sale.DeliverDetail;
import dwz.business.sale.DeliverExportUtil;
import dwz.business.sale.Sale;
import dwz.business.sale.SaleDetail;
import dwz.business.sale.SaleExportUtil;
import dwz.business.sale.SaleServiceMgr;
import dwz.business.sale.SearchProductVO;
import dwz.business.sale.SearchSaleVO;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/sale/search")
public class SaleSearchController extends BaseController{
	
	@Autowired
	private SaleServiceMgr saleServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchSaleVO vo, Model model) {
		
		int totalCount = saleServiceMgr.searchSaleCount(vo, getSessionOper());
		List<Sale> saleList = saleServiceMgr.searchSale(vo, getSessionOper());
		
		model.addAttribute(saleList);
		model.addAttribute("consumer", vo.getConsumer());
		model.addAttribute("product",vo.getProduct());
		model.addAttribute("saleNo", vo.getSaleNo());
		model.addAttribute("status", vo.getStatus());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/sale/search/list";
	}
	
	@RequestMapping("/detail/{saleId}/{busiType}/{targetLeafId}")
	public String detail(@PathVariable("saleId") int saleId, @PathVariable("busiType") String busiType, @PathVariable("targetLeafId") int targetLeafId, Model model) {
		
		Sale sale = saleServiceMgr.getSaleById(saleId);
		List<SaleDetail> saleDetailList = saleServiceMgr.findSaleDetailBySaleId(saleId);
		List<Deliver> deliverList = saleServiceMgr.findDeliverForShow(saleId);
		for(Deliver deliver : deliverList){
			List<DeliverDetail> deliverDetailList = saleServiceMgr.findDeliverDetail(deliver.getDeliverId());
			deliver.setDeliverDetailList(deliverDetailList);
		}
		
		model.addAttribute("sale", sale);
		model.addAttribute("saleDetailList", saleDetailList);
		model.addAttribute("deliverList", deliverList);
		model.addAttribute("busiType", busiType);
		model.addAttribute("targetLeafId", targetLeafId);
		
		return "/sale/search/detail";
	}
	
	@RequestMapping("/edit/{saleId}")
	public String edit(@PathVariable("saleId") int saleId, Model model) {
		
		Sale sale = saleServiceMgr.getSaleById(saleId);
		List<SaleDetail> saleDetailList = saleServiceMgr.findSaleDetailBySaleId(saleId);
		
		model.addAttribute("sale", sale);
		model.addAttribute("saleDetailList", saleDetailList);
		
		return "/sale/search/edit";
	}
	
	@RequestMapping("/product")
	public String product(SearchProductVO vo, Model model) {
		
		int totalCount = saleServiceMgr.searchJoinProductCount(vo, getSessionOper());
		List<Product> productList = saleServiceMgr.searchJoinProduct(vo, getSessionOper());
		model.addAttribute(productList);
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		return "/sale/search/product";
	}
	
	@SystemLog("修改销售单")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Sale sale) {
		saleServiceMgr.updateSaleForCustomer(sale, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SystemLog("删除销售单产品")
	@RequestMapping("/del/{saleId}/{saleDetailId}")
	public void del(@PathVariable("saleId") int saleId, @PathVariable("saleDetailId") int saleDetailId, HttpServletResponse response) {
		saleServiceMgr.del(saleId,saleDetailId);
	}
	
	@SystemLog("强制结束销售单")
	@RequestMapping(value = "/forceOver/{saleId}")
	public ModelAndView forceOver(@PathVariable("saleId") int saleId) {
		saleServiceMgr.forceOver(saleId, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SystemLog("导出销售单")
	@RequestMapping(value = "/exportSale/{saleId}")
	public ModelAndView exportSale(@PathVariable("saleId") int saleId ,HttpServletResponse response) {
		
		Sale sale = saleServiceMgr.getSaleById(saleId);
		List<SaleDetail> saleDetailList = saleServiceMgr.findSaleDetailBySaleId(saleId);
		
		SaleExportUtil.exportToExcel(sale, saleDetailList, getSessionOper(), response);
		
		return null;
	}
	
	@SystemLog("导出装箱单")
	@RequestMapping(value = "/exportDeliver/{deliverId}")
	public ModelAndView exportDeliver(@PathVariable("deliverId") int deliverId ,HttpServletResponse response) {
		
		Deliver deliver = saleServiceMgr.getDeliverById(deliverId);
		Sale sale = saleServiceMgr.getSaleById(deliver.getSaleId());
		List<DeliverDetail> deliverDetailList = saleServiceMgr.findDeliverDetail(deliverId);
		
		DeliverExportUtil.exportToExcel(sale, deliver, deliverDetailList, getSessionOper(), response);
		
		return null;
	}
	
}
