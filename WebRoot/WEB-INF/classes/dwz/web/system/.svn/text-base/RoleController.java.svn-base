package dwz.web.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.common.ZNodes;
import dwz.business.system.Resource;
import dwz.business.system.Role;
import dwz.business.system.RoleServiceMgr;
import dwz.common.util.ParameterUtil;
import dwz.web.BaseController;
import dwz.web.SystemLog;

@Controller
@RequestMapping(value="/system/role")
public class RoleController extends BaseController{
	
	@Autowired
	private RoleServiceMgr roleServiceMgr;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Role> roleList = roleServiceMgr.searchRole(getSessionOper());
		model.addAttribute(roleList);
		return "/system/role/list";
	}
	
	public void makeChildrenResourceList(List<Resource> resourceList){
		Map<Integer, List<Integer>> outerResourceCache = ParameterUtil.getOuterResourceMap();
		
		for(Resource resource : resourceList){
			int resourceId = resource.getResourceId();
			if(outerResourceCache.containsKey(resourceId)){
				List<Resource> childrenList = new ArrayList<Resource>();
				List<Integer> childrenIds = outerResourceCache.get(resourceId);
				for(Integer id : childrenIds){
					Resource childResource = new Resource();
					childResource.setResourceId(id);
					childResource.setResourceName(ParameterUtil.getColumnValue("SYS_RESOURCE.RESOURCE_NAME", String.valueOf(id)));
					childrenList.add(childResource);
					
					makeChildrenResourceList(childrenList);
				}
				resource.setResourceList(childrenList);
			}
		}
	}
	
	public List<Resource> getResourceList(){
		List<Resource> resourceList = new ArrayList<Resource>();
		List<Integer> resourceIds  = ParameterUtil.getOuterResourceMap().get(0);
		for(Integer resourceId : resourceIds){
			Resource resource = new Resource();
			resource.setResourceId(resourceId);
			resource.setResourceName(ParameterUtil.getColumnValue("SYS_RESOURCE.RESOURCE_NAME", String.valueOf(resourceId)));
			resourceList.add(resource);
		}
		return resourceList;
	}
	
	@RequestMapping("/findResourceForZTree")
	public ModelAndView findResourceForZTree(String resourceBelong,HttpServletResponse response){
		
		List<ZNodes> zNodesList = roleServiceMgr.findZNodesOfResource();
		
		this.responseJson(zNodesList, response);
		return null;
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		
		return "/system/role/add";
	}
	
	@SystemLog("添加角色")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Role role, String resourceIds) {
		if(roleServiceMgr.getRole(role.getRoleName(), getSessionOper().getOrgId())!=null){
			return ajaxDoneError("此角色已经存在，请勿重复添加");
		}else{
			roleServiceMgr.addRole(role, resourceIds, getSessionOper());
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}
	}
	
	@SystemLog("删除角色")
	@RequestMapping("/del/{roleId}")
	public ModelAndView del(@PathVariable("roleId") int roleId) {

		int operCount = roleServiceMgr.findOperCountByRole(roleId);
		if(operCount > 0){
			return ajaxDoneError("有操作员使用了此角色，无法删除。");
		}else{
			roleServiceMgr.del(roleId);
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		}
	}
	
	@RequestMapping("/findCheckedResourceForZTree/{roleId}")
	public ModelAndView findCheckedResourceForZTree(@PathVariable("roleId") int roleId,HttpServletResponse response){
		
		List<ZNodes> zNodesList = roleServiceMgr.findZNodesOfResourceWithChecked(roleId);
		
		this.responseJson(zNodesList, response);
		return null;
	}
	
	@RequestMapping("/edit/{roleId}")
	public String edit(@PathVariable("roleId") int roleId, Model model) {
		Role role = roleServiceMgr.getRole(roleId);
		
		model.addAttribute("role", role);
		
		return "/system/role/edit";
	}
	
	@SystemLog("修改角色信息")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Role role, String resourceIds) {
		roleServiceMgr.updRole(role, resourceIds);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));

	}

}
