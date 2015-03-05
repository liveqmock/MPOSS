package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PurPurchasePrice extends AbstractDO{
	
	private Integer purchasePriceId;
	private Integer providerProductId;
	private Integer providerId;
	private Integer productId;
	private String standard;
	private Integer unitPrice;
	
	public Integer getPurchasePriceId() {
		return purchasePriceId;
	}
	public void setPurchasePriceId(Integer purchasePriceId) {
		this.purchasePriceId = purchasePriceId;
	}
	public Integer getProviderProductId() {
		return providerProductId;
	}
	public void setProviderProductId(Integer providerProductId) {
		this.providerProductId = providerProductId;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("PurchasePriceId", getPurchasePriceId())
				.append("ProviderProductId", getProviderProductId())
				.append("ProviderId", getProviderId())
				.append("ProductId", getProductId())
				.append("Standard", getStandard())
				.append("UnitPrice", getUnitPrice()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPurchasePriceId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PurPurchasePrice == false) return false;
		if(this == obj) return true;
		PurPurchasePrice other = (PurPurchasePrice)obj;
		return new EqualsBuilder()
			.append(getPurchasePriceId(),other.getPurchasePriceId())
			.isEquals();
	}

}
