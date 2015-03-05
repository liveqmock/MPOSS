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
import dwz.business.partner.Consumer;
import dwz.business.partner.ConsumerImportVO;
import dwz.business.partner.ConsumerServiceMgr;
import dwz.business.partner.SearchConsumeVO;
import dwz.business.partner.SearchConsumerVO;
import dwz.common.util.ExcelImportUtil;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/partner/consumer")
public class ConsumerController extends BaseController {
	
	@Autowired
	private ConsumerServiceMgr consumerServiceMgr;
	@Autowired
	private BillServiceMgr billServiceMgr;
	
	@RequestMapping("/list")
	public String list(SearchConsumerVO searchConsumerVO, Model model) {
		
		int totalCount = consumerServiceMgr.searchConsumerCount(getSessionOper(), searchConsumerVO);
		List<Consumer> consumerList = consumerServiceMgr.searchConsumer(getSessionOper(), searchConsumerVO);
		model.addAttribute(consumerList);
		
		model.addAttribute("consumerType",searchConsumerVO.getConsumerType());
		model.addAttribute("consumer",searchConsumerVO.getConsumer());
		model.addAttribute("orderNo",searchConsumerVO.getOrderNo());
		model.addAttribute("pageNum", searchConsumerVO.getPageNum());
		model.addAttribute("numPerPage", searchConsumerVO.getPageSize());
		model.addAttribute("totalCount", totalCount);
		return "/partner/consumer/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		return "/partner/consumer/add";
	}
	
	@SystemLog("添加客户")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Consumer consumer) {
		if(consumerServiceMgr.getConsumer(consumer.getConsumerName(), getSessionOper().getOrgId())!=null){
			return ajaxDoneError("此客户已经存在，无法重复添加");
		}else{
			consumerServiceMgr.addConsumer(consumer,getSessionOper());
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}
	}
	
	@RequestMapping("/edit/{consumerId}")
	public String edit(@PathVariable("consumerId") int consumerId, Model model) {
		Consumer consumer = consumerServiceMgr.getConsumer(consumerId);
		model.addAttribute("consumer", consumer);
		return "/partner/consumer/edit";
	}
	
	@SystemLog("修改客户信息")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Consumer consumer) {
		consumerServiceMgr.updConsumer(consumer,getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
	@SystemLog("删除客户")
	@RequestMapping("/del/{consumerId}")
	public ModelAndView update(@PathVariable("consumerId") int consumerId, Model model) {
		int saleCount = consumerServiceMgr.getSaleCountByConsumer(consumerId);
		if(saleCount > 0){
			return ajaxDoneError("本客户已存在销售数据，为保证数据完整性，拒绝删除。");
		}
		consumerServiceMgr.del(consumerId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
	@RequestMapping("/consumeDetail/{consumerId}")
	public String consumeDetail(SearchConsumeVO vo, @PathVariable("consumerId") int consumerId, Model model) {
		
		int totalCount = billServiceMgr.findConsumeCountForConsumer(vo, consumerId, getSessionOper());
		List<Consume> consumeList = billServiceMgr.findConsumeForConsumer(vo, consumerId, getSessionOper());
		model.addAttribute("consumerId", consumerId);
		model.addAttribute("consumeList", consumeList);
		model.addAttribute("pageNum", vo.getPageNum());
		model.addAttribute("numPerPage", vo.getPageSize());
		model.addAttribute("totalCount", totalCount);
		return "/partner/consumer/consumeList";
	}
	
	@RequestMapping("/goImport")
    public String goImport(){
    	return "/partner/consumer/import";
    }
	
	@RequestMapping(value="/import")
	public String importConsumer(@RequestParam(value="file", required=false) MultipartFile file, Model model) throws Exception {
    	if(file != null){
    		List<String[]> infoList = ExcelImportUtil.read(file.getInputStream(), file.getOriginalFilename(), 9, false);
        	List<Consumer> consumerList = consumerServiceMgr.buildConsumerList(infoList, getSessionOper());
        	model.addAttribute("consumerList", consumerList);
    	}
		return "/partner/consumer/import";
	}
    
	@SystemLog("导入客户信息")
    @RequestMapping(value="/doImport", method=RequestMethod.POST)
	public ModelAndView doImport(ConsumerImportVO vo, Model model) {
    	
    	List<Consumer> consumerList = vo.getConsumerList();
		if(consumerList == null) return ajaxDoneError("没有可以提交的数据！");
		
		consumerServiceMgr.importData(consumerList, getSessionOper());
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}
	
}
