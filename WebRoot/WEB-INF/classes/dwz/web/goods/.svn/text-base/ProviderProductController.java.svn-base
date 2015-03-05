package dwz.web.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.goods.AddProviderProductVO;
import dwz.business.goods.ProviderProduct;
import dwz.business.goods.ProviderProductServiceMgr;
import dwz.business.goods.ProviderProductVO;
import dwz.business.goods.SearchProviderProductVO;
import dwz.business.purchase.PurchaseServiceMgr;
import dwz.business.stock.StockServiceMgr;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/goods/providerProduct")
public class ProviderProductController extends BaseController {
	
	@Autowired
	private ProviderProductServiceMgr providerProductServiceMgr;
	@Autowired
	private PurchaseServiceMgr purchaseServiceMgr;
	@Autowired
	private StockServiceMgr stockServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchProviderProductVO vo, Model model) {
		
		int totalCount = providerProductServiceMgr.searchProviderProductCount(vo, getSessionOper());
		List<ProviderProduct> providerProductList = providerProductServiceMgr.searchProviderProduct(vo, getSessionOper());
		model.addAttribute(providerProductList);
		model.addAttribute("provider",vo.getProvider());
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/goods/providerProduct/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/goods/providerProduct/add";
	}
	
	@SystemLog("添加厂家产品")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(AddProviderProductVO vo) {
		
		List<ProviderProductVO> innerVOList = vo.getProviderProductVOList();
		
		if(innerVOList == null) return ajaxDoneError("没有可以提交的数据！");
		
		List<String> someProviderProductStrList = new ArrayList<String>();
		
		boolean emptyProduct = false;
		boolean emptyPrice = false;
		boolean localRepeat = false;
		for(ProviderProductVO innerVO : innerVOList){
			if(innerVO.getProviderId() == null) continue;
			
			if(innerVO.getProductId()==null){
				emptyProduct = true;
				 break;
			}
			
			if(innerVO.getInputUnitPrice()==null){
				 emptyPrice = true;
				 break;
			}
			String ele =  innerVO.getProviderId() +"-"+ innerVO.getProductId();
			if(someProviderProductStrList.contains(ele)) {
				localRepeat = true;
				break;
			}else{
				someProviderProductStrList.add(ele);
			}
		}
		
		if(emptyProduct){
			return ajaxDoneError("提交失败：部分表格行未指定产品！");
		}
		
		if(emptyPrice){
			return ajaxDoneError("提交失败：部分厂家价格未输入！");
		}
		
		if(localRepeat){
			return ajaxDoneError("提交失败：列表中存在重复的厂家产品！");
		}
		
		List<String> someProviderProductStrList2 = providerProductServiceMgr.searchProviderProductForRepeatCheck(getSessionOper());
		List<String> tempList = new ArrayList<String>();
		tempList.addAll(someProviderProductStrList);
		tempList.retainAll(someProviderProductStrList2);
		if(tempList.size()>0){
			StringBuffer sb = new StringBuffer();
			
			for(String str : tempList){
				if(sb.length() == 0){
					sb.append(someProviderProductStrList.indexOf(str));
				}else{
					sb.append(","+someProviderProductStrList.indexOf(str));
				}
			}
			return ajaxDoneError("提交失败：某些厂家产品数据已存在于系统！#"+sb);
		}
		
		providerProductServiceMgr.addProviderProduct(vo,getSessionOper());
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/edit/{providerProductId}")
	public String edit(@PathVariable("providerProductId") int providerProductId, Model model) {
		ProviderProduct providerProduct = providerProductServiceMgr.getProviderProduct(providerProductId);
		model.addAttribute("providerProduct", providerProduct);
		return "/goods/providerProduct/edit";
	}
	
	@SystemLog("删除厂家产品")
	@RequestMapping("/del/{providerProductId}")
	public ModelAndView del(@PathVariable("providerProductId") int providerProductId) {
		int purchaseCount = purchaseServiceMgr.getPurDetailCountForProvProd(providerProductId);
		if(purchaseCount > 0){
			return ajaxDoneError("此厂家产品存在历史采购数据，为保证数据完整性，拒绝删除！");
		}
		int stockCount = stockServiceMgr.getQuantityForProvProd(providerProductId);
		if(stockCount > 0){
			return ajaxDoneError("此厂家产品存在库存数据，为保证数据完整性，拒绝删除！");
		}
		providerProductServiceMgr.del(providerProductId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
	@SystemLog("修改厂家产品")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(ProviderProduct providerProduct) {
		providerProductServiceMgr.upd(providerProduct,getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
}
