package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class RptProfitColl extends AbstractDO {
	
	private Integer profitCollId;
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
	private Integer realProfitAmount;
	
	private String transDate;
	private Integer sumAmount;
	private Integer sumProfitAmount;
	private Integer sumRealProfitAmount;
	
	public Integer getProfitCollId() {
		return profitCollId;
	}
	public void setProfitCollId(Integer profitCollId) {
		this.profitCollId = profitCollId;
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
	public Integer getRealProfitAmount() {
		return realProfitAmount;
	}
	public void setRealProfitAmount(Integer realProfitAmount) {
		this.realProfitAmount = realProfitAmount;
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
	public Integer getSumRealProfitAmount() {
		return sumRealProfitAmount;
	}
	public void setSumRealProfitAmount(Integer sumRealProfitAmount) {
		this.sumRealProfitAmount = sumRealProfitAmount;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ProfitCollId", getProfitCollId())
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
				.append("ProfitAmount", getProfitAmount())
				.append("RealProfitAmount", getRealProfitAmount()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProfitCollId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RptProfitColl == false) return false;
		if(this == obj) return true;
		RptProfitColl other = (RptProfitColl)obj;
		return new EqualsBuilder()
			.append(getProfitCollId(),other.getProfitCollId())
			.isEquals();
	}

}
