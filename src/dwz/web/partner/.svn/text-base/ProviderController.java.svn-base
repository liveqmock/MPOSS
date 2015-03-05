package dwz.web.partner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.account.BillServiceMgr;
import dwz.business.account.Consume;
import dwz.business.partner.Provider;
import dwz.business.partner.ProviderImportVO;
import dwz.business.partner.ProviderServiceMgr;
import dwz.business.partner.SearchConsumeVO;
import dwz.business.partner.SearchProviderVO;
import dwz.common.util.ExcelImportUtil;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/partner/provider")
public class ProviderController extends BaseController {
	
	@Autowired
	private ProviderServiceMgr providerServiceMgr;
	@Autowired
	private BillServiceMgr billServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchProviderVO searchProviderVO, Model model) {
		
		int totalCount = providerServiceMgr.searchProviderCount(getSessionOper(), searchProviderVO);
		List<Provider> providerList = providerServiceMgr.searchProvider(getSessionOper(), searchProviderVO);
		model.addAttribute(providerList);
		
		model.addAttribute("providerType",searchProviderVO.getProviderType());
		model.addAttribute("provider",searchProviderVO.getProvider());
		model.addAttribute("orderNo",searchProviderVO.getOrderNo());
		model.addAttribute("pageNum", searchProviderVO.getPageNum());
		model.addAttribute("numPerPage", searchProviderVO.getPageSize());
		model.addAttribute("totalCount", totalCount);
		return "/partner/provider/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/partner/provider/add";
	}
	
	@SystemLog("添加厂家")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Provider provider) {
		
		if(providerServiceMgr.getProvider(provider.getProviderName(), getSessionOper().getOrgId())!=null){
			return ajaxDoneError("此厂家已经存在，无法重复添加");
		}else{
			providerServiceMgr.addProvider(provider,getSessionOper());
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}
		
	}
	
	@RequestMapping("/edit/{providerId}")
	public String edit(@PathVariable("providerId") int providerId, Model model) {
		Provider provider = providerServiceMgr.getProvider(providerId);
		model.addAttribute("provider", provider);
		return "/partner/provider/edit";
	}
	
	@SystemLog("修改厂家")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Provider provider) {
		providerServiceMgr.updProvider(provider, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
	@SystemLog("删除厂家")
	@RequestMapping("/del/{providerId}")
	public ModelAndView del(@PathVariable("providerId") int providerId, Model model) {
		int purchaseCount = providerServiceMgr.getPurchaseCountByProvider(providerId);
		if(purchaseCount > 0){
			return ajaxDoneError("本厂家已存在采购数据，为保证数据完整性，拒绝删除！");
		}
		int stockCount = providerServiceMgr.getStockCountByProvider(providerId);
		if(stockCount > 0){
			return ajaxDoneError("本厂家存在库存数据，为保证数据完整性，拒绝删除！");
		}
		providerServiceMgr.del(providerId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
	@RequestMapping("/consumeDetail/{providerId}")
	public String consumeDetail(SearchConsumeVO vo, @PathVariable("providerId") int providerId, Model model) {
		int totalCount = billServiceMgr.findConsumeCountForProvider(vo, providerId, getSessionOper());
		List<Consume> consumeList = billServiceMgr.findConsumeForProvider(vo, providerId, getSessionOper());
		model.addAttribute("providerId", providerId);
		model.addAttribute("consumeList", consumeList);
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		return "/partner/provider/consumeList";
	}
	
	@RequestMapping("/goImport")
    public String goImport(){
    	return "/partner/provider/import";
    }
	
	@RequestMapping(value="/import")
	public String importProvider(@RequestParam(value="file", required=false) MultipartFile file, Model model) throws Exception {
    	if(file != null){
    		List<String[]> infoList = ExcelImportUtil.read(file.getInputStream(), file.getOriginalFilename(), 9, false);
        	List<Provider> providerList = providerServiceMgr.buildProviderList(infoList, getSessionOper());
        	model.addAttribute("providerList", providerList);
    	}
		return "/partner/provider/import";
	}
    
	@SystemLog("导入厂家信息")
    @RequestMapping(value="/doImport", method=RequestMethod.POST)
	public ModelAndView doImport(ProviderImportVO vo, Model model) {
    	
    	List<Provider> providerList = vo.getProviderList();
		if(providerList == null) return ajaxDoneError("没有可以提交的数据！");
		
		providerServiceMgr.importData(providerList, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
}
