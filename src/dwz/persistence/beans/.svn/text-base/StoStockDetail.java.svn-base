package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class StoStockDetail extends AbstractDO {
	
	private Integer stockDetailId;
	private Integer stockId;
	private Integer providerProductId;
	private Integer totalQuantity;
	private Integer lockQuantity;
	
	private String providerName;
	private String productModel;
	private String productName;
	private String productEngName;
	
	public Integer getStockDetailId() {
		return stockDetailId;
	}
	public void setStockDetailId(Integer stockDetailId) {
		this.stockDetailId = stockDetailId;
	}
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public Integer getProviderProductId() {
		return providerProductId;
	}
	public void setProviderProductId(Integer providerProductId) {
		this.providerProductId = providerProductId;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("StockDetailId", getStockDetailId())
				.append("StockId",getStockId())
				.append("ProviderProductId",getProviderProductId())
				.append("TotalQuantity", getTotalQuantity())
				.append("LockQuantity", getLockQuantity()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StoStockDetail == false) return false;
		if(this == obj) return true;
		StoStockDetail other = (StoStockDetail)obj;
		return new EqualsBuilder()
			.append(getStockDetailId(),other.getStockDetailId())
			.isEquals();
	}

}
