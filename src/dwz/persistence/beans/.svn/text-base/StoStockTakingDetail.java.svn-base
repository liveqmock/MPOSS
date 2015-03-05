package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class StoStockTakingDetail extends AbstractDO {
	
	private Integer stockTakingDetailId;
	private Integer stockTakingId;
	private Integer providerProductId;
	private String standard;
	private Integer totalQuantity;
	private Integer lockQuantity;
	private Integer takingQuantity;
	
	private String providerName;
	private String productModel;
	private String productName;
	private String productEngName;
	
	public Integer getStockTakingDetailId() {
		return stockTakingDetailId;
	}
	public void setStockTakingDetailId(Integer stockTakingDetailId) {
		this.stockTakingDetailId = stockTakingDetailId;
	}
	public Integer getStockTakingId() {
		return stockTakingId;
	}
	public void setStockTakingId(Integer stockTakingId) {
		this.stockTakingId = stockTakingId;
	}
	public Integer getProviderProductId() {
		return providerProductId;
	}
	public void setProviderProductId(Integer providerProductId) {
		this.providerProductId = providerProductId;
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
	public Integer getTakingQuantity() {
		return takingQuantity;
	}
	public void setTakingQuantity(Integer takingQuantity) {
		this.takingQuantity = takingQuantity;
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
				.append("StockTakingDetailId", getStockTakingDetailId())
				.append("StockTakingId", getStockTakingId())
				.append("ProviderProductId", getProviderProductId())
				.append("Standard", getStandard())
				.append("TotalQuantity", getTotalQuantity())
				.append("LockQuantity", getLockQuantity())
				.append("TakingQuantity", getTakingQuantity()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockTakingDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StoStockTakingDetail == false) return false;
		if(this == obj) return true;
		StoStockTakingDetail other = (StoStockTakingDetail)obj;
		return new EqualsBuilder()
			.append(getStockTakingDetailId(),other.getStockTakingDetailId())
			.isEquals();
	}

}
