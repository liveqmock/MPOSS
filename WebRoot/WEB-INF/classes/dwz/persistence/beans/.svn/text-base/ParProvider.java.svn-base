package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ParProvider extends AbstractDO {
	
	private Integer providerId;
	private String providerType;
	private String providerProp;
	private String providerName;
	private String engLetter;
	private String linkMan;
	private String phone;
	private String address;
	private String email;
	private String qq;
	private String msn;
	private Integer overTimes;
	private Date createTime;
	private Integer orgId;
	private Date billFinishTime;
	private String status;
	
	private Integer providerProductId;
	private Integer unitPrice;
	private Integer packQuantity;
	private Double packWeight;
	private Double packVolume;
	
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public String getProviderType() {
		return providerType;
	}
	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderProp() {
		return providerProp;
	}
	public void setProviderProp(String providerProp) {
		this.providerProp = providerProp;
	}
	public String getEngLetter() {
		return engLetter;
	}
	public void setEngLetter(String engLetter) {
		this.engLetter = engLetter;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public Integer getOverTimes() {
		return overTimes;
	}
	public void setOverTimes(Integer overTimes) {
		this.overTimes = overTimes;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Date getBillFinishTime() {
		return billFinishTime;
	}
	public void setBillFinishTime(Date billFinishTime) {
		this.billFinishTime = billFinishTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getProviderProductId() {
		return providerProductId;
	}
	public void setProviderProductId(Integer providerProductId) {
		this.providerProductId = providerProductId;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getPackQuantity() {
		return packQuantity;
	}
	public void setPackQuantity(Integer packQuantity) {
		this.packQuantity = packQuantity;
	}
	public Double getPackWeight() {
		return packWeight;
	}
	public void setPackWeight(Double packWeight) {
		this.packWeight = packWeight;
	}
	public Double getPackVolume() {
		return packVolume;
	}
	public void setPackVolume(Double packVolume) {
		this.packVolume = packVolume;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ProviderId", getProviderId())
				.append("ProviderType",getProviderType())
				.append("ProviderProp",getProviderProp())
				.append("ProviderName",getProviderName())
				.append("EngLetter",getEngLetter())
				.append("LinkMan", getLinkMan())
				.append("Phone",getPhone())
				.append("Address", getAddress())
				.append("Email", getEmail())
				.append("Qq", getQq())
				.append("Msn", getMsn())
				.append("OverTimes", getOverTimes())
				.append("CreateTime", getCreateTime())
				.append("OrgId", getOrgId())
				.append("BillFinishTime", getBillFinishTime())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProviderId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ParProvider == false) return false;
		if(this == obj) return true;
		ParProvider other = (ParProvider)obj;
		return new EqualsBuilder()
			.append(getProviderId(),other.getProviderId())
			.isEquals();
	}

}
