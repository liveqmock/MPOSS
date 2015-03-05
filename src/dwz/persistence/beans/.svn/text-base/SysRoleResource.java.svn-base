package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysRoleResource extends AbstractDO {
	
	private Integer roleResourceId;
	private Integer roleId;
	private Integer resourceId;
	
	public Integer getRoleResourceId() {
		return roleResourceId;
	}

	public void setRoleResourceId(Integer roleResourceId) {
		this.roleResourceId = roleResourceId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("RoleResourceId", getRoleResourceId())
				.append("RoleId",getRoleId())
				.append("ResourceId", getResourceId()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRoleId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysRoleResource == false) return false;
		if(this == obj) return true;
		SysRoleResource other = (SysRoleResource)obj;
		return new EqualsBuilder()
			.append(getRoleResourceId(),other.getRoleResourceId())
			.isEquals();
	}

}
