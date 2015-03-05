package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ProProviderProduct extends AbstractDO {
	
	private Integer providerProductId;
	private Integer orgId;
	private Integer productId;
	private String productModel;
	private String productName;
	private String productEngName;
	private String unit;
	private String pic;
	private Integer providerId;
	private String providerName;
	private Integer unitPrice;
	
	private String standard;
	
	public Integer getProviderProductId() {
		return providerProductId;
	}
	public void setProviderProductId(Integer providerProductId) {
		this.providerProductId = providerProductId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
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
	public String getProductEngName() {
		return productEngName;
	}
	public void setProductEngName(String productEngName) {
		this.productEngName = productEngName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ProviderProductId", getProviderProductId())
				.append("OrgId",getOrgId())
				.append("ProductId",getProductId())
				.append("ProductModel",getProductModel())
				.append("ProductName",getProductName())
				.append("ProductEngName",getProductEngName())
				.append("Unit",getUnit())
				.append("Pic", getPic())
				.append("ProviderId", getProviderId())
				.append("ProviderName", getProviderName())
				.append("UnitPrice", getUnitPrice()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProviderProductId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProProviderProduct == false) return false;
		if(this == obj) return true;
		ProProviderProduct other = (ProProviderProduct)obj;
		return new EqualsBuilder()
			.append(getProviderProductId(),other.getProviderProductId())
			.isEquals();
	}

}
