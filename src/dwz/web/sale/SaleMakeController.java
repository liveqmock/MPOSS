package dwz.web.sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.common.CommonServiceMgr;
import dwz.business.goods.Product;
import dwz.business.sale.Sale;
import dwz.business.sale.SaleDetail;
import dwz.business.sale.SaleImport;
import dwz.business.sale.SaleImportVO;
import dwz.business.sale.SaleServiceMgr;
import dwz.business.sale.SearchProductVO;
import dwz.common.util.ExcelImportUtil;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/sale/make")
public class SaleMakeController extends BaseController{
	
	@Autowired
	private SaleServiceMgr saleServiceMgr;
	@Autowired
	private CommonServiceMgr commonServiceMgr;
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/sale/make/add";
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
		return "/sale/make/product";
	}
	
	@SystemLog("制作销售单")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Sale sale) {
		sale.setSaleNo(commonServiceMgr.getPaperNo(getSessionOper().getOrgId(), "XS"));
		saleServiceMgr.addSale(sale, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listConf")
	public String listConf(Model model) {
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("1");//SALE_STATUS (1-新销售单)
		List<Sale> saleList = saleServiceMgr.searchSaleForDo(getSessionOper(), statusList);
		model.addAttribute(saleList);
		
		return "/sale/make/list_conf";
	}
	
	@RequestMapping("/conf/{saleId}")
	public String conf(@PathVariable("saleId") int saleId, Model model) {
		
		Sale sale = saleServiceMgr.getSaleById(saleId);
		List<SaleDetail> saleDetailList = saleServiceMgr.findSaleDetailBySaleId(saleId);
		model.addAttribute("sale", sale);
		model.addAttribute("saleDetailList", saleDetailList);
		
		return "/sale/make/conf";
	}
	
	@SystemLog("审批销售单")
	@RequestMapping(value = "/doConf", method = RequestMethod.POST)
	public ModelAndView doConf(Sale sale) {
		saleServiceMgr.updateSale(sale, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/listDeposit")
	public String listDeposit(Model model) {
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("7");//SALE_STATUS (1-待定金收取)
		List<Sale> saleList = saleServiceMgr.searchSaleForDo(getSessionOper(), statusList);
		model.addAttribute(saleList);
		
		return "/sale/make/list_deposit";
	}
	
	@SystemLog("定金收取确认")
	@RequestMapping("/confDeposit/{saleId}")
	public ModelAndView confDeposit(@PathVariable("saleId") int saleId, Model model) {
		
		saleServiceMgr.confDeposit(saleId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/importAdd")
	public String importAdd(Model model) {
		
		List<SaleImport> saleImportList = saleServiceMgr.findSaleImport(getSessionOper());
		model.addAttribute("saleImportList", saleImportList);
		saleServiceMgr.delImport(getSessionOper());
		
		return "/sale/make/importAdd";
	}
	
	@RequestMapping("/goImport")
    public String goImport(){
    	return "/sale/make/import";
    }
	
	@RequestMapping(value="/import")
	public String importConsumer(@RequestParam(value="file", required=false) MultipartFile file, Model model) throws Exception {
    	if(file != null){
    		List<String[]> infoList = ExcelImportUtil.read(file.getInputStream(), file.getOriginalFilename(), 8, false);//获取Excel数据
    		
    		Set<Integer> unPassRowSet = saleServiceMgr.checkSaleImportData(infoList);
    		if(unPassRowSet.isEmpty()){
    			List<SaleImport> saleImportList = saleServiceMgr.buildSaleImportList(infoList, getSessionOper());
            	model.addAttribute("saleImportList", saleImportList);
    		}else{
    			
    			StringBuffer sb = new StringBuffer("Excel导入失败，以下表格行的数据有问题：");
    			int i = 0;
    			for(int rowSize : unPassRowSet){
    				if(i>0){
    					sb.append("，"+rowSize);
    				}else{
    					sb.append(rowSize);
    				}
    				i++;
    			}
    			model.addAttribute("message", sb);
    		}
    		
    	}
		return "/sale/make/import";
	}
	
	@SystemLog("导入销售产品")
    @RequestMapping(value="/doImport", method=RequestMethod.POST)
	public ModelAndView doImport(SaleImportVO vo, Model model) {
    	
    	List<SaleImport> saleImportList = vo.getSaleImportList();
		if(saleImportList == null) return ajaxDoneError("没有可以提交的数据！");
		
		saleServiceMgr.importData(saleImportList, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
	@SystemLog("制作销售单")
	@RequestMapping(value = "/insertByImport", method = RequestMethod.POST)
	public ModelAndView insertByImport(Sale sale) {
		sale.setSaleNo(commonServiceMgr.getPaperNo(getSessionOper().getOrgId(), "XS"));
		saleServiceMgr.addSaleByImport(sale, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	

}
