package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class StoStockLock extends AbstractDO {
	
	private Integer stockLockId;
	private Date lockTime;
	private Integer orgId;
	private Integer providerProductId;
	private String standard;
	private String busiType;
	private Integer topId;
	private Integer targetLeafId;
	private Integer lockQuantity;
	
	private String providerName;
	private String productModel;
	private String productName;
	private String productEngName;
	private String unit;
	private String pic;
	
	public Integer getStockLockId() {
		return stockLockId;
	}
	public void setStockLockId(Integer stockLockId) {
		this.stockLockId = stockLockId;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
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
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public Integer getTopId() {
		return topId;
	}
	public void setTopId(Integer topId) {
		this.topId = topId;
	}
	public Integer getTargetLeafId() {
		return targetLeafId;
	}
	public void setTargetLeafId(Integer targetLeafId) {
		this.targetLeafId = targetLeafId;
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
				.append("StockLockId", getStockLockId())
				.append("LockTime",getLockTime())
				.append("OrgId",getOrgId())
				.append("ProviderProductId", getProviderProductId())
				.append("Standard", getStandard())
				.append("BusiType", getBusiType())
				.append("TopId", getTopId())
				.append("PaperId", getTargetLeafId())
				.append("LockQuantity", getLockQuantity()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockLockId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StoStockLock == false) return false;
		if(this == obj) return true;
		StoStockLock other = (StoStockLock)obj;
		return new EqualsBuilder()
			.append(getStockLockId(),other.getStockLockId())
			.isEquals();
	}

}
