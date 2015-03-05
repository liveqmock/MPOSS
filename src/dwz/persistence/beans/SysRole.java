package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysRole extends AbstractDO {
	
	private Integer roleId;
	private Integer orgId;
	private String roleName;
	private String roleDesc;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("RoleId", getRoleId())
				.append("OrgId",getOrgId())
				.append("RoleName",getRoleName())
				.append("RoleDesc", getRoleDesc()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRoleId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysRole == false) return false;
		if(this == obj) return true;
		SysRole other = (SysRole)obj;
		return new EqualsBuilder()
			.append(getRoleId(),other.getRoleId())
			.isEquals();
	}

}
