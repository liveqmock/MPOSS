package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class RptSaleBackColl extends AbstractDO {
	
	private Integer saleBackCollId;
	private Integer orgId;
	private String saleBackType;
	private Date transTime;
	private Integer consumerId;
	private String consumerName;
	private String productModel;
	private String productName;
	private String standard;
	private Integer quantity;
	private Integer price;
	private Integer amount;
	
	private String transDate;
	private Integer sumAmount;
	
	public Integer getSaleBackCollId() {
		return saleBackCollId;
	}
	public void setSaleBackCollId(Integer saleBackCollId) {
		this.saleBackCollId = saleBackCollId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getSaleBackType() {
		return saleBackType;
	}
	public void setSaleBackType(String saleBackType) {
		this.saleBackType = saleBackType;
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
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
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public Integer getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(Integer sumAmount) {
		this.sumAmount = sumAmount;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("SaleBackCollId", getSaleBackCollId())
				.append("OrgId",getOrgId())
				.append("SaleBackType",getSaleBackType())
				.append("TransTime", getTransTime())
				.append("ConsumerId", getConsumerId())
				.append("ConsumerName",getConsumerName())
				.append("ProductModel", getProductModel())
				.append("ProductName", getProductName())
				.append("Standard", getStandard())
				.append("Quantity", getQuantity())
				.append("Price", getPrice())
				.append("Amount", getAmount()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSaleBackCollId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RptSaleBackColl == false) return false;
		if(this == obj) return true;
		RptSaleBackColl other = (RptSaleBackColl)obj;
		return new EqualsBuilder()
			.append(getSaleBackCollId(),other.getSaleBackCollId())
			.isEquals();
	}

}
