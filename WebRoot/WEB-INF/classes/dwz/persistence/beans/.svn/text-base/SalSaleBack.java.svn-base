package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SalSaleBack extends AbstractDO {
	
	private Integer saleBackId;
	private String saleBackNo;
	private String saleBackType;
	private String saleNo;
	private String deliverNo;
	private Integer orgId;
	private Integer consumerId;
	private String consumerName;
	private Integer totalBackQuantity;
	private Integer totalBackPrice;
	private Integer createOperId;
	private Date createTime;
	private String createDesc;
	private Integer confOperId;
	private Date confTime;
	private String confDesc;
	private String status;
	
	public Integer getSaleBackId() {
		return saleBackId;
	}
	public void setSaleBackId(Integer saleBackId) {
		this.saleBackId = saleBackId;
	}
	public String getSaleBackNo() {
		return saleBackNo;
	}
	public void setSaleBackNo(String saleBackNo) {
		this.saleBackNo = saleBackNo;
	}
	public String getSaleBackType() {
		return saleBackType;
	}
	public void setSaleBackType(String saleBackType) {
		this.saleBackType = saleBackType;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public String getDeliverNo() {
		return deliverNo;
	}
	public void setDeliverNo(String deliverNo) {
		this.deliverNo = deliverNo;
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
	public Integer getTotalBackQuantity() {
		return totalBackQuantity;
	}
	public void setTotalBackQuantity(Integer totalBackQuantity) {
		this.totalBackQuantity = totalBackQuantity;
	}
	public Integer getTotalBackPrice() {
		return totalBackPrice;
	}
	public void setTotalBackPrice(Integer totalBackPrice) {
		this.totalBackPrice = totalBackPrice;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("SaleBackId", getSaleBackId())
				.append("SaleBackNo",getSaleBackNo())
				.append("SaleBackType",getSaleBackType())
				.append("OrgId",getOrgId())
				.append("ConsumerId", getConsumerId())
				.append("ConsumerName", getConsumerName())
				.append("TotalBackQuantity", getTotalBackQuantity())
				.append("TotalBackPrice", getTotalBackPrice())
				.append("CreateOperId", getCreateOperId())
				.append("CreateTime", getCreateTime())
				.append("CreateDesc", getCreateDesc())
				.append("ConfOperId", getConfOperId())
				.append("ConfTime", getConfTime())
				.append("ConfDesc", getConfDesc())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSaleBackId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SalSaleBack == false) return false;
		if(this == obj) return true;
		SalSaleBack other = (SalSaleBack)obj;
		return new EqualsBuilder()
			.append(getSaleBackId(),other.getSaleBackId())
			.isEquals();
	}

}
