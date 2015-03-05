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

import dwz.business.goods.AddStandard;
import dwz.business.goods.ProductStandardServiceMgr;
import dwz.business.goods.SearchStandardVO;
import dwz.business.goods.Standard;
import dwz.common.util.StringUtils;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/goods/standard")
public class ProductStandardController extends BaseController {
	
	@Autowired
	private ProductStandardServiceMgr productStandardServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchStandardVO vo, Model model) {
		
		int totalCount = productStandardServiceMgr.searchProductStandardCount(vo, getSessionOper());
		List<Standard> standardList = productStandardServiceMgr.searchProductStandard(vo, getSessionOper());
		model.addAttribute(standardList);
		model.addAttribute("product", vo.getProduct());
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		
		return "/goods/standard/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/goods/standard/add";
	}
	
	@SystemLog("添加产品规格")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(AddStandard addStandard) {
		
		List<Standard> standardList = addStandard.getStandardList();
		if(standardList == null) return ajaxDoneError("没有可以提交的数据！");
		
		List<String> someStandardStrList = new ArrayList<String>();
		
		boolean emptyProduct = false;
		boolean emptyStandard = false;
		boolean localRepeat = false;
		for(Standard standard : standardList){
			
			if(standard.getProductId()==null && standard.getStandard()==null) continue;
			
			if(standard.getProductId()==null){
				emptyProduct = true;
				break;
			}
			
			if(StringUtils.isBlank(standard.getStandard())){
				 emptyStandard = true;
				 break;
			}
			String ele =  standard.getProductId() +"-"+ standard.getStandard();
			if(someStandardStrList.contains(ele)) {
				localRepeat = true;
				break;
			}else{
				someStandardStrList.add(ele);
			}
		}
		
		if(emptyProduct){
			return ajaxDoneError("提交失败：部分表格行未指定产品！");
		}
		
		if(emptyStandard){
			return ajaxDoneError("提交失败：部分规格数据未输入！");
		}
		
		if(localRepeat){
			return ajaxDoneError("提交失败：列表中存在重复的产品规格！");
		}
		
		List<Integer> rowNoList = productStandardServiceMgr.checkStandard(addStandard);
		if(rowNoList.size()>0) {
			
			StringBuffer sb = new StringBuffer();
			for(int rowNo : rowNoList){
				if(sb.length() == 0){
					sb.append(rowNo);
				}else{
					sb.append(","+rowNo);
				}
			}
			return ajaxDoneError("提交失败，某些产品规格数据已存在！#"+sb);
		}
		productStandardServiceMgr.addStandard(addStandard);
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SystemLog("删除产品规格")
	@RequestMapping("/del/{standardId}")
	public ModelAndView del(@PathVariable("standardId") int standardId, Model model) {
		
		productStandardServiceMgr.del(standardId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
}
