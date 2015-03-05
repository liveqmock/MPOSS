package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class RptPurchaseColl extends AbstractDO {
	
	private Integer purchaseCollId;
	private Integer orgId;
	private String purchaseProp;
	private Date transTime;
	private Integer providerId;
	private String providerName;
	private String productModel;
	private String productName;
	private String standard;
	private Integer quantity;
	private Integer price;
	private Integer amount;
	
	private String transDate;
	private Integer sumAmount;
	
	public Integer getPurchaseCollId() {
		return purchaseCollId;
	}

	public void setPurchaseCollId(Integer purchaseCollId) {
		this.purchaseCollId = purchaseCollId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getPurchaseProp() {
		return purchaseProp;
	}

	public void setPurchaseProp(String purchaseProp) {
		this.purchaseProp = purchaseProp;
	}

	public Date getTransTime() {
		return transTime;
	}

	public void setTransTime(Date transTime) {
		this.transTime = transTime;
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
				.append("PurchaseCollId", getPurchaseCollId())
				.append("OrgId",getOrgId())
				.append("PurchaseProp",getPurchaseProp())
				.append("TransTime", getTransTime())
				.append("ProviderId", getProviderId())
				.append("ProviderName",getProviderName())
				.append("ProductModel", getProductModel())
				.append("ProductName", getProductName())
				.append("Standard", getStandard())
				.append("Quantity", getQuantity())
				.append("Price", getPrice())
				.append("Amount", getAmount()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPurchaseCollId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RptPurchaseColl == false) return false;
		if(this == obj) return true;
		RptPurchaseColl other = (RptPurchaseColl)obj;
		return new EqualsBuilder()
			.append(getPurchaseCollId(),other.getPurchaseCollId())
			.isEquals();
	}

}
