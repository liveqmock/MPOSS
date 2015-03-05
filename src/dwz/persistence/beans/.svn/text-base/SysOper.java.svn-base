package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysOper extends AbstractDO {
	
	private Integer operId;
	private String userName;
	private String passwd;
	private String realName;
	private String sex;
	private Integer age;
	private String phone;
	private String email;
	private String qq;
	private String weixin;
	private String address;
	private Integer orgId;
	private Date createTime;
	private String status;
	
	public Integer getOperId() {
		return operId;
	}
	public void setOperId(Integer operId) {
		this.operId = operId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("OperId", getOperId())
				.append("UserName",getUserName())
				.append("Passwd",getPasswd())
				.append("RealName", getRealName())
				.append("Weixin", getWeixin())
				.append("Sex", getSex())
				.append("Age",getAge())
				.append("Phone",getPhone())
				.append("Email", getEmail())
				.append("Qq", getQq())
				.append("Address",getAddress())
				.append("OrgId", getOrgId())
				.append("CreateTime", getCreateTime())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOperId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysOper == false) return false;
		if(this == obj) return true;
		SysOper other = (SysOper)obj;
		return new EqualsBuilder()
			.append(getOperId(),other.getOperId())
			.isEquals();
	}

}
