package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PurArrival extends AbstractDO {
	
	private Integer arrivalId;
	private String arrivalNo;
	private Integer purchaseId;
	private Integer arrivalQuantity;
	private Integer regOperId;
	private Date regTime;
	private String regDesc;
	private Integer arrivalOperId;
	private Date arrivalTime;
	private String status;
	
	private String purchaseNo;
	private String purchaseProp;
	private Integer providerId;
	private String providerName;
	private Double totalPrice;
	private String payPriceFlag;
	private String payPrice;
	
	public Integer getArrivalId() {
		return arrivalId;
	}
	public void setArrivalId(Integer arrivalId) {
		this.arrivalId = arrivalId;
	}
	public String getArrivalNo() {
		return arrivalNo;
	}
	public void setArrivalNo(String arrivalNo) {
		this.arrivalNo = arrivalNo;
	}
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Integer getArrivalQuantity() {
		return arrivalQuantity;
	}
	public void setArrivalQuantity(Integer arrivalQuantity) {
		this.arrivalQuantity = arrivalQuantity;
	}
	public Integer getArrivalOperId() {
		return arrivalOperId;
	}
	public void setArrivalOperId(Integer arrivalOperId) {
		this.arrivalOperId = arrivalOperId;
	}
	public Integer getRegOperId() {
		return regOperId;
	}
	public void setRegOperId(Integer regOperId) {
		this.regOperId = regOperId;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public String getRegDesc() {
		return regDesc;
	}
	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getPurchaseProp() {
		return purchaseProp;
	}
	public void setPurchaseProp(String purchaseProp) {
		this.purchaseProp = purchaseProp;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPayPriceFlag() {
		return payPriceFlag;
	}
	public void setPayPriceFlag(String payPriceFlag) {
		this.payPriceFlag = payPriceFlag;
	}
	public String getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ArrivalId", getArrivalId())
				.append("ArrivalNo", getArrivalNo())
				.append("PurchaseId", getPurchaseId())
				.append("ArrivalQuantity", getArrivalQuantity())
				.append("RegOperId", getRegOperId())
				.append("RegTime", getRegTime())
				.append("RegDesc", getRegDesc())
				.append("ArrivalOperId", getArrivalOperId())
				.append("ArrivalTime", getArrivalTime())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getArrivalId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PurArrival == false) return false;
		if(this == obj) return true;
		PurArrival other = (PurArrival)obj;
		return new EqualsBuilder()
			.append(getArrivalId(),other.getArrivalId())
			.isEquals();
	}

}
