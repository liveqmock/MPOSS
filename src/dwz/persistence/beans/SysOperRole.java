package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysOperRole extends AbstractDO {
	
	private Integer operRoleId;
	private Integer operId;
	private Integer roleId;
	
	public Integer getOperRoleId() {
		return operRoleId;
	}
	public void setOperRoleId(Integer operRoleId) {
		this.operRoleId = operRoleId;
	}
	public Integer getOperId() {
		return operId;
	}
	public void setOperId(Integer operId) {
		this.operId = operId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("OperRoleId", getOperRoleId())
				.append("OperId",getOperId())
				.append("RoleId", getRoleId()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOperId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysOperRole == false) return false;
		if(this == obj) return true;
		SysOperRole other = (SysOperRole)obj;
		return new EqualsBuilder()
			.append(getOperRoleId(),other.getOperRoleId())
			.isEquals();
	}

}
