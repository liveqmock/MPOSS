package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SalDeliver extends AbstractDO {
	
	private Integer deliverId;
	private String deliverNo;
	private Integer saleId;
	private Integer createOperId;
	private Date createTime;
	private Integer deliverOperId;
	private Date deliverTime;
	private String status;
	
	private String saleNo;
	private String saleType;
	private String consumerName;
	private Integer totalSalePrice;
	private String gotPriceFlag;
	private Integer gotPrice;
	private String receAddress;
	private String receMen;
	private String linkPhone;
	 
	public Integer getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(Integer deliverId) {
		this.deliverId = deliverId;
	}
	public String getDeliverNo() {
		return deliverNo;
	}
	public void setDeliverNo(String deliverNo) {
		this.deliverNo = deliverNo;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getCreateOperId() {
		return createOperId;
	}
	public void setCreateOperId(Integer createOperId) {
		this.createOperId = createOperId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getDeliverOperId() {
		return deliverOperId;
	}
	public void setDeliverOperId(Integer deliverOperId) {
		this.deliverOperId = deliverOperId;
	}
	public Date getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public Integer getTotalSalePrice() {
		return totalSalePrice;
	}
	public void setTotalSalePrice(Integer totalSalePrice) {
		this.totalSalePrice = totalSalePrice;
	}
	public String getGotPriceFlag() {
		return gotPriceFlag;
	}
	public void setGotPriceFlag(String gotPriceFlag) {
		this.gotPriceFlag = gotPriceFlag;
	}
	public Integer getGotPrice() {
		return gotPrice;
	}
	public void setGotPrice(Integer gotPrice) {
		this.gotPrice = gotPrice;
	}
	public String getReceAddress() {
		return receAddress;
	}
	public void setReceAddress(String receAddress) {
		this.receAddress = receAddress;
	}
	public String getReceMen() {
		return receMen;
	}
	public void setReceMen(String receMen) {
		this.receMen = receMen;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("DeliverId", getDeliverId())
				.append("DeliverNo", getDeliverNo())
				.append("SaleId", getSaleId())
				.append("CreateOperId", getCreateOperId())
				.append("CreateTime", getCreateTime())
				.append("DeliverOperId", getDeliverOperId())
				.append("DeliverTime", getDeliverTime())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDeliverId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SalDeliver == false) return false;
		if(this == obj) return true;
		SalDeliver other = (SalDeliver)obj;
		return new EqualsBuilder()
			.append(getDeliverId(),other.getDeliverId())
			.isEquals();
	}

}
