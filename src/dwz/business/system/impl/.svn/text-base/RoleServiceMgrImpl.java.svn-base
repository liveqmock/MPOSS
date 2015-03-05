package dwz.business.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.common.ZNodes;
import dwz.business.system.Role;
import dwz.business.system.RoleServiceMgr;
import dwz.common.util.StringUtils;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.SysResource;
import dwz.persistence.beans.SysRole;
import dwz.persistence.beans.SysRoleResource;
import dwz.persistence.mapper.OperRoleMapper;
import dwz.persistence.mapper.ResourceMapper;
import dwz.persistence.mapper.RoleMapper;
import dwz.persistence.mapper.RoleResourceMapper;

@Transactional(rollbackFor = Exception.class)
@Service("roleServiceMgr")
public class RoleServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements RoleServiceMgr {
	
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleResourceMapper roleResourceMapper;
	@Autowired
	private OperRoleMapper operRoleMapper;
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Role> searchRole(SessionOper sessionOper) {
		List<Role> bos = new ArrayList<Role>();
		List<SysRole> pos = roleMapper.findByOrg(sessionOper.getOrgId());
		for(SysRole po : pos){
			bos.add(new Role(po));
		}
		return bos;
	}

	@Override
	public void addRole(Role role, String resourceIds, SessionOper sessionOper) {
		SysRole sysRole = role.getSysRole();
		sysRole.setOrgId(sessionOper.getOrgId());
		roleMapper.insert(sysRole);
		
		if(StringUtils.isBlank(resourceIds)) return;
		String[] resourceIdArr = resourceIds.split(",");
		
		for(String resourceIdStr : resourceIdArr){
			
			SysRoleResource sysRoleResource = new SysRoleResource();
			sysRoleResource.setRoleId(sysRole.getRoleId());
			sysRoleResource.setResourceId(Integer.parseInt(resourceIdStr));
			roleResourceMapper.insert(sysRoleResource);
		}
		
	}

	@Override
	public Role getRole(String roleName, int orgId) {
		SysRole sysRole = new SysRole();
		sysRole.setOrgId(orgId);
		sysRole.setRoleName(roleName);
		SysRole po = roleMapper.getByRoleName(sysRole);
		if(po == null) return null;
		return new Role(po);
	}

	@Override
	public int findOperCountByRole(int roleId) {
		return operRoleMapper.findCountByRole(roleId);
	}

	@Override
	public void del(int roleId) {
		roleMapper.delete(roleId);
		roleResourceMapper.deleteByRole(roleId);
	}

	@Override
	public Role getRole(int roleId) {
		SysRole po = roleMapper.load(roleId);
		return new Role(po);
	}
	
	@Override
	public void updRole(Role role, String resourceIds) {
		
		roleMapper.update(role.getSysRole());
		
		List<Integer> boResourceIdList = new ArrayList<Integer>();
		List<Integer> poResourceIdList = new ArrayList<Integer>();
		
		if(!StringUtils.isBlank(resourceIds)){
			String[] boResourceIdArr = resourceIds.split(",");
			for(String resourceIdStr : boResourceIdArr){
				boResourceIdList.add(Integer.parseInt(resourceIdStr));
			}
		}
		
		List<SysRoleResource> roleResourceList = roleResourceMapper.findResourceByRole(role.getRoleId());
		if(roleResourceList != null){
			for(SysRoleResource roleResource : roleResourceList){
				poResourceIdList.add(roleResource.getResourceId());
			}
		}
		
		List<Integer> cloneBoResourceIdList = new ArrayList<Integer>();
		cloneBoResourceIdList.addAll(boResourceIdList);
		
		List<Integer> clonePoResourceIdList = new ArrayList<Integer>();
		clonePoResourceIdList.addAll(poResourceIdList);
		
		boResourceIdList.removeAll(poResourceIdList);
		for(int resourceId : boResourceIdList){//insert
			SysRoleResource sysRoleResource = new SysRoleResource();
			sysRoleResource.setRoleId(role.getRoleId());
			sysRoleResource.setResourceId(resourceId);
			roleResourceMapper.insert(sysRoleResource);
		}
		
		clonePoResourceIdList.removeAll(cloneBoResourceIdList);
		for(int resourceId : clonePoResourceIdList){//delete
			SysRoleResource sysRoleResource = new SysRoleResource();
			sysRoleResource.setRoleId(role.getRoleId());
			sysRoleResource.setResourceId(resourceId);
			roleResourceMapper.deleteByRoleAndResource(sysRoleResource);
		}
	}

	@Override
	public List<ZNodes> findZNodesOfResource() {
		
		List<ZNodes> zNodesList = new ArrayList<ZNodes>();
		List<SysResource> pos = resourceMapper.findResourceByResourceType("1");//RESOURCE_TYPE(1-外部)
		for(SysResource po : pos){
			ZNodes zNodes = new ZNodes();
			zNodes.setId(po.getResourceId());
			zNodes.setPId(po.getParentResourceId());
			zNodes.setName(po.getResourceName());
			zNodes.setOpen(true);
			zNodesList.add(zNodes);
		}
		return zNodesList;
	}
	
	@Override
	public List<ZNodes> findZNodesOfResourceWithChecked(int roleId) {
		
		List<ZNodes> zNodesList = new ArrayList<ZNodes>();
		List<SysResource> pos = resourceMapper.findResourceByResourceType("1");//RESOURCE_TYPE(1-外部)
		
		List<Integer> ownResourceIdList = new ArrayList<Integer>();
		List<SysRoleResource> checkedPos = roleResourceMapper.findCheckedResourceByRole(roleId);
		if(checkedPos != null){
			for(SysRoleResource checkedPo : checkedPos){
				ownResourceIdList.add(checkedPo.getResourceId());
			}
		}
		for(SysResource po : pos){
			ZNodes zNodes = new ZNodes();
			zNodes.setId(po.getResourceId());
			zNodes.setPId(po.getParentResourceId());
			zNodes.setName(po.getResourceName());
			zNodes.setOpen(true);
			if(ownResourceIdList.contains(po.getResourceId())){
				zNodes.setChecked(true);
			}
			zNodesList.add(zNodes);
		}
		return zNodesList;
	}

}
