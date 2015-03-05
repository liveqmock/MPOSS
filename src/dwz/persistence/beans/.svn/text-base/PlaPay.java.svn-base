package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PlaPay extends AbstractDO {
	
	private Integer platPayId;
	private Integer orgId;
	private Date payTime;
	private String platServiceType;
	private Integer payPrice;
	private String payWay;
	private String paperNo;
	private Integer bankId;
	private String bankCardNo;
	private String startDate;
	private String endDate;
	
	public Integer getPlatPayId() {
		return platPayId;
	}
	public void setPlatPayId(Integer platPayId) {
		this.platPayId = platPayId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getPlatServiceType() {
		return platServiceType;
	}
	public void setPlatServiceType(String platServiceType) {
		this.platServiceType = platServiceType;
	}
	public Integer getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(Integer payPrice) {
		this.payPrice = payPrice;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getPaperNo() {
		return paperNo;
	}
	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("PlatPayId", getPlatPayId())
				.append("OrgId",getOrgId())
				.append("PayTime",getPayTime())
				.append("PlatServiceType", getPlatServiceType())
				.append("PayPrice", getPayPrice())
				.append("PayWay", getPayWay())
				.append("PaperNo", getPaperNo())
				.append("BankId", getBankId())
				.append("BankCardNo", getBankCardNo())
				.append("StartDate", getStartDate())
				.append("EndDate", getEndDate()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPlatPayId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PlaPay == false) return false;
		if(this == obj) return true;
		PlaPay other = (PlaPay)obj;
		return new EqualsBuilder()
			.append(getPlatPayId(),other.getPlatPayId())
			.isEquals();
	}

}
