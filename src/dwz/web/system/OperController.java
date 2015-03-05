package dwz.web.system;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.common.ZNodes;
import dwz.business.system.Oper;
import dwz.business.system.OperServiceMgr;
import dwz.business.system.Role;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/system/oper")
public class OperController extends BaseController{
	
	@Autowired
	private OperServiceMgr operServiceMgr;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Oper> operList = operServiceMgr.searchOper(getSessionOper());
		model.addAttribute(operList);
		return "/system/oper/list";
	}
	
	@RequestMapping("/findRoleForZTree")
	public ModelAndView findRoleForZTree(HttpServletResponse response){
		
		List<ZNodes> zNodesList = operServiceMgr.findZNodesOfRole(getSessionOper());
		
		this.responseJson(zNodesList, response);
		return null;
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		
		//List<Role> roleList = operServiceMgr.findRoleByOrg(getSessionOper().getOrgId());
		
		//model.addAttribute(roleList);
		
		return "/system/oper/add";
	}
	
	@SystemLog("添加操作员")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Oper oper, String roleIds) {
		if(operServiceMgr.getOper(oper.getUserName(),oper.getRealName(), getSessionOper().getOrgId())!=null){
			return ajaxDoneError("此操作员已经存在，请勿重复添加");
		}else{
			operServiceMgr.addOper(oper, roleIds, getSessionOper());
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}
	}
	
	@SystemLog("删除操作员")
	@RequestMapping("/del/{operId}")
	public ModelAndView del(@PathVariable("operId") int operId) {

		operServiceMgr.del(operId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SystemLog("停用操作员")
	@RequestMapping("/disable/{operId}")
	public ModelAndView disable(@PathVariable("operId") int operId) {

		operServiceMgr.disable(operId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SystemLog("启用操作员")
	@RequestMapping("/enable/{operId}")
	public ModelAndView enable(@PathVariable("operId") int operId) {

		operServiceMgr.enable(operId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/edit/{operId}")
	public String edit(@PathVariable("operId") int operId, Model model) {
		
		Oper oper = operServiceMgr.getOper(operId);
		List<Role> roleList = operServiceMgr.findRoleByOrg(getSessionOper().getOrgId());
		
		model.addAttribute("oper", oper);
		model.addAttribute("roleList", roleList);
		
		return "/system/oper/edit";
	}
	
	@RequestMapping("/findCheckedRoleForZTree/{operId}")
	public ModelAndView findCheckedRoleForZTree(@PathVariable("operId") int operId,HttpServletResponse response){
		
		List<ZNodes> zNodesList = operServiceMgr.findZNodesOfRoleWithChecked(getSessionOper(), operId);
		
		this.responseJson(zNodesList, response);
		return null;
	}
	
	@SystemLog("修改操作员信息")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Oper oper, String roleIds) {
		operServiceMgr.updOper(oper, roleIds);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}

}
