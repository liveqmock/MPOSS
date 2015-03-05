package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysOrg extends AbstractDO{
	
	private Integer orgId;
	private String orgName;
	private String engName;
	private String tel;
	private String fax;
	private String address;
	private String engAddress;
	private String currPlatServiceType;
	private String serviceEndDate;
	private String inTakingFlag;
	private String logo;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEngAddress() {
		return engAddress;
	}
	public void setEngAddress(String engAddress) {
		this.engAddress = engAddress;
	}
	public String getCurrPlatServiceType() {
		return currPlatServiceType;
	}
	public void setCurrPlatServiceType(String currPlatServiceType) {
		this.currPlatServiceType = currPlatServiceType;
	}
	public String getServiceEndDate() {
		return serviceEndDate;
	}
	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}
	public String getInTakingFlag() {
		return inTakingFlag;
	}
	public void setInTakingFlag(String inTakingFlag) {
		this.inTakingFlag = inTakingFlag;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLogoImg() {
		return "/styles/theme/img/logo/"+logo;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("OrgId", getOrgId())
				.append("OrgName", getOrgName())
				.append("EngName", getEngName())
				.append("Tel", getTel())
				.append("Fax", getFax())
				.append("Address", getAddress())
				.append("EngAddress", getEngAddress())
				.append("CurrPlatServiceType", getCurrPlatServiceType())
				.append("ServiceEngDate", getServiceEndDate())
				.append("InTakingFlag", getInTakingFlag())
				.append("Logo", getLogo()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOrgId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysOrg == false) return false;
		if(this == obj) return true;
		SysOrg other = (SysOrg)obj;
		return new EqualsBuilder()
			.append(getOrgId(),other.getOrgId())
			.isEquals();
	}

}
