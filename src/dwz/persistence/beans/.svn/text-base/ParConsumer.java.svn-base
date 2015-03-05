package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ParConsumer extends AbstractDO {
	
	private Integer consumerId;
	private String consumerType;
	private String consumerName;
	private String consumerProp;
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
	
	public Integer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerType() {
		return consumerType;
	}
	public void setConsumerType(String consumerType) {
		this.consumerType = consumerType;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getConsumerProp() {
		return consumerProp;
	}
	public void setConsumerProp(String consumerProp) {
		this.consumerProp = consumerProp;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ConsumerId", getConsumerId())
				.append("ConsumerType",getConsumerType())
				.append("ConsumerName",getConsumerName())
				.append("ConsumerProp", getConsumerProp())
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
			.append(getConsumerId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ParConsumer == false) return false;
		if(this == obj) return true;
		ParConsumer other = (ParConsumer)obj;
		return new EqualsBuilder()
			.append(getConsumerId(),other.getConsumerId())
			.isEquals();
	}

}
