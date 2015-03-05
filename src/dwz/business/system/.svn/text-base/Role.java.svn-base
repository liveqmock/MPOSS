package dwz.business.system;

import java.io.Serializable;
import java.util.List;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.SysRole;

public class Role extends AbstractBusinessObject {
	
	private SysRole sysRole;
	private List<Resource> resourceList;
	
	public Role(){
		this.sysRole = new SysRole();
	}
	
	public Role(SysRole sysRole){
		this.sysRole = sysRole;
	}
	
	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	@Override
	public Serializable getId() {
		return this.sysRole.getRoleId();
	}
	
	public Integer getOrgId() {
		return this.sysRole.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.sysRole.setOrgId(orgId);
	}
	public Integer getRoleId() {
		return this.sysRole.getRoleId();
	}
	public void setRoleId(Integer roleId) {
		this.sysRole.setRoleId(roleId);
	}
	public String getRoleName() {
		return this.sysRole.getRoleName();
	}
	public void setRoleName(String roleName) {
		this.sysRole.setRoleName(roleName);
	}
	public String getRoleDesc() {
		return this.sysRole.getRoleDesc();
	}
	public void setRoleDesc(String roleDesc) {
		this.sysRole.setRoleDesc(roleDesc);
	}

	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

}
