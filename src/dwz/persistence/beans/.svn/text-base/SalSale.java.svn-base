package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SalSale extends AbstractDO {
	
	private Integer saleId;
	private String saleNo;
	private String saleType;
	private Integer orgId;
	private Integer consumerId;
	private String consumerName;
	private Integer totalSaleQuantity;
	private Integer totalCostPrice;
	private Integer totalSalePrice;
	private String receAddress;
	private String receMen;
	private String linkPhone;
	private String depositFlag;
	private Integer createOperId;
	private Date createTime;
	private String createDesc;
	private String arrivalDate;
	private Integer confOperId;
	private Date confTime;
	private String confDesc;
	private Integer purchaseQuantity;
	private String finishBakFlag;
	private String status;
	
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
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
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public Integer getTotalSaleQuantity() {
		return totalSaleQuantity;
	}
	public void setTotalSaleQuantity(Integer totalSaleQuantity) {
		this.totalSaleQuantity = totalSaleQuantity;
	}
	public Integer getTotalCostPrice() {
		return totalCostPrice;
	}
	public void setTotalCostPrice(Integer totalCostPrice) {
		this.totalCostPrice = totalCostPrice;
	}
	public Integer getTotalSalePrice() {
		return totalSalePrice;
	}
	public void setTotalSalePrice(Integer totalSalePrice) {
		this.totalSalePrice = totalSalePrice;
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
	public String getCreateDesc() {
		return createDesc;
	}
	public void setCreateDesc(String createDesc) {
		this.createDesc = createDesc;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
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
	public String getDepositFlag() {
		return depositFlag;
	}
	public void setDepositFlag(String depositFlag) {
		this.depositFlag = depositFlag;
	}
	public Integer getConfOperId() {
		return confOperId;
	}
	public void setConfOperId(Integer confOperId) {
		this.confOperId = confOperId;
	}
	public Date getConfTime() {
		return confTime;
	}
	public void setConfTime(Date confTime) {
		this.confTime = confTime;
	}
	public String getConfDesc() {
		return confDesc;
	}
	public void setConfDesc(String confDesc) {
		this.confDesc = confDesc;
	}
	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public String getFinishBakFlag() {
		return finishBakFlag;
	}
	public void setFinishBakFlag(String finishBakFlag) {
		this.finishBakFlag = finishBakFlag;
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
				.append("SaleId", getSaleId())
				.append("SaleNo",getSaleNo())
				.append("SaleType",getSaleType())
				.append("OrgId",getOrgId())
				.append("ConsumerId", getConsumerId())
				.append("ConsumerName", getConsumerName())
				.append("TotalSaleQuantity", getTotalSaleQuantity())
				.append("TotalCostPrice", getTotalCostPrice())
				.append("TotalSalePrice", getTotalSalePrice())
				.append("ReceAddress", getReceAddress())
				.append("ReceMen", getReceMen())
				.append("LinkPhone", getLinkPhone())
				.append("DepositFlag", getDepositFlag())
				.append("CreateOperId", getCreateOperId())
				.append("CreateTime", getCreateTime())
				.append("CreateDesc", getCreateDesc())
				.append("ArrivalDate", getArrivalDate())
				.append("ConfOperId", getConfOperId())
				.append("ConfTime", getConfTime())
				.append("ConfDesc", getConfDesc())
				.append("PurchaseQuantity", getPurchaseQuantity())
				.append("FinishBakFlag",getFinishBakFlag())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSaleId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SalSale == false) return false;
		if(this == obj) return true;
		SalSale other = (SalSale)obj;
		return new EqualsBuilder()
			.append(getSaleId(),other.getSaleId())
			.isEquals();
	}

}
