package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class RptSaleColl extends AbstractDO {
	
	private Integer saleCollId;
	private Integer orgId;
	private String saleType;
	private Date transTime;
	private Integer consumerId;
	private String consumerName;
	private String productModel;
	private String productName;
	private String standard;
	private Integer quantity;
	private Integer price;
	private Integer amount;
	private Integer costPrice;
	private Integer profitAmount;
	
	private String transDate;
	private Integer sumAmount;
	private Integer sumProfitAmount;
	
	public Integer getSaleCollId() {
		return saleCollId;
	}
	public void setSaleCollId(Integer saleCollId) {
		this.saleCollId = saleCollId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
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
	public Integer getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
	public Integer getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(Integer profitAmount) {
		this.profitAmount = profitAmount;
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
	public Integer getSumProfitAmount() {
		return sumProfitAmount;
	}
	public void setSumProfitAmount(Integer sumProfitAmount) {
		this.sumProfitAmount = sumProfitAmount;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("SaleCollId", getSaleCollId())
				.append("OrgId",getOrgId())
				.append("SaleType",getSaleType())
				.append("TransTime", getTransTime())
				.append("ConsumerId", getConsumerId())
				.append("ConsumerName",getConsumerName())
				.append("ProductModel", getProductModel())
				.append("ProductName", getProductName())
				.append("Standard", getStandard())
				.append("Quantity", getQuantity())
				.append("Price", getPrice())
				.append("Amount", getAmount())
				.append("CostPrice", getCostPrice())
				.append("ProfitAmount", getProfitAmount()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSaleCollId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RptSaleColl == false) return false;
		if(this == obj) return true;
		RptSaleColl other = (RptSaleColl)obj;
		return new EqualsBuilder()
			.append(getSaleCollId(),other.getSaleCollId())
			.isEquals();
	}

}
