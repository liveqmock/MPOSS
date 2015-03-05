package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class StoStock extends AbstractDO {
	
	private Integer stockId;
	private Integer orgId;
	private Integer providerProductId;
	private String standard;
	private Integer totalQuantity;
	private Integer lockQuantity;
	private Integer providerQuantity;
	
	private String providerName;
	private String productModel;
	private String productName;
	private String productEngName;
	private String pic;
	private Integer unitPrice;
	private Integer packQuantity;
	private Double packWeight;
	private Double packVolume;
	
	private Integer productId;
	private Integer sumCanUseQuantity;
	
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Integer getLockQuantity() {
		return lockQuantity;
	}
	public void setLockQuantity(Integer lockQuantity) {
		this.lockQuantity = lockQuantity;
	}
	public Integer getProviderQuantity() {
		return providerQuantity;
	}
	public void setProviderQuantity(Integer providerQuantity) {
		this.providerQuantity = providerQuantity;
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
	public String getProductEngName() {
		return productEngName;
	}
	public void setProductEngName(String productEngName) {
		this.productEngName = productEngName;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getProviderProductId() {
		return providerProductId;
	}
	public void setProviderProductId(Integer providerProductId) {
		this.providerProductId = providerProductId;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getPackQuantity() {
		return packQuantity;
	}
	public void setPackQuantity(Integer packQuantity) {
		this.packQuantity = packQuantity;
	}
	public Double getPackWeight() {
		return packWeight;
	}
	public void setPackWeight(Double packWeight) {
		this.packWeight = packWeight;
	}
	public Double getPackVolume() {
		return packVolume;
	}
	public void setPackVolume(Double packVolume) {
		this.packVolume = packVolume;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getSumCanUseQuantity() {
		return sumCanUseQuantity;
	}
	public void setSumCanUseQuantity(Integer sumCanUseQuantity) {
		this.sumCanUseQuantity = sumCanUseQuantity;
	}
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("StockId", getStockId())
				.append("OrgId",getOrgId())
				.append("Standard",getStandard())
				.append("ProviderProductId",getProviderProductId())
				.append("TotalQuantity", getTotalQuantity())
				.append("LockQuantity", getLockQuantity())
				.append("ProviderQuantity", getProviderQuantity()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StoStock == false) return false;
		if(this == obj) return true;
		StoStock other = (StoStock)obj;
		return new EqualsBuilder()
			.append(getStockId(),other.getStockId())
			.isEquals();
	}

}
