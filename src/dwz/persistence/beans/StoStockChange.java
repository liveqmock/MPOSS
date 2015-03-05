package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class StoStockChange extends AbstractDO {
	
	private Integer stockChangeId;
	private Integer orgId;
	private Integer providerProductId;
	private String standard;
	private Date changeTime;
	private String changeAction;
	private Integer changeQuantity;
	private String busiType;
	private Integer topId;
	private Integer targetLeafId;
	
	private String providerName;
	private String productModel;
	private String productName;
	private String productEngName;
	
	public Integer getStockChangeId() {
		return stockChangeId;
	}
	public void setStockChangeId(Integer stockChangeId) {
		this.stockChangeId = stockChangeId;
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
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	public String getChangeAction() {
		return changeAction;
	}
	public void setChangeAction(String changeAction) {
		this.changeAction = changeAction;
	}
	public Integer getChangeQuantity() {
		return changeQuantity;
	}
	public void setChangeQuantity(Integer changeQuantity) {
		this.changeQuantity = changeQuantity;
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
				.append("StockChangeId", getStockChangeId())
				.append("OrgId",getOrgId())
				.append("ProviderProductId", getProviderProductId())
				.append("Standard", getStandard())
				.append("ChangeTime", getChangeTime())
				.append("ChangeAction", getChangeAction())
				.append("ChangeQuantity", getChangeQuantity())
				.append("BusiType", getBusiType())
				.append("topId", getTopId())
				.append("TargetLeafId", getTargetLeafId()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockChangeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StoStockChange == false) return false;
		if(this == obj) return true;
		StoStockChange other = (StoStockChange)obj;
		return new EqualsBuilder()
			.append(getStockChangeId(),other.getStockChangeId())
			.isEquals();
	}

}
