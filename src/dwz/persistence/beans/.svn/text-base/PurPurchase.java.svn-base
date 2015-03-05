package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PurPurchase extends AbstractDO {
	
	private Integer purchaseId;
	private String purchaseNo;
	private String purchaseProp;
	private String saleNos;
	private Integer orgId;
	private Integer providerId;
	private String providerName;
	private String contractNo;
	private Integer totalPrice;
	private String createDesc;
	private Integer createOperId;
	private Date createTime;
	private Integer confOperId;
	private Date confTime;
	private String confDesc;
	private String status;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getPurchaseProp() {
		return purchaseProp;
	}
	public void setPurchaseProp(String purchaseProp) {
		this.purchaseProp = purchaseProp;
	}
	public String getSaleNos() {
		return saleNos;
	}
	public void setSaleNos(String saleNos) {
		this.saleNos = saleNos;
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
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCreateDesc() {
		return createDesc;
	}
	public void setCreateDesc(String createDesc) {
		this.createDesc = createDesc;
	}
	public Integer getCreateOperId() {
		return createOperId;
	}
	public void setCreateOperId(Integer createOperId) {
		this.createOperId = createOperId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getConfOperId() {
		return confOperId;
	}
	public void setConfOperId(Integer confOperId) {
		this.confOperId = confOperId;
	}
	public Date getConfTime() {
		return confTime;
	}
	public void setConfTime(Date confTime) {
		this.confTime = confTime;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getConfDesc() {
		return confDesc;
	}
	public void setConfDesc(String confDesc) {
		this.confDesc = confDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("PurchaseId", getPurchaseId())
				.append("PurchaseNo",getPurchaseNo())
				.append("PurchaseProp",getPurchaseProp())
				.append("SaleNos",getSaleNos())
				.append("OrgId",getOrgId())
				.append("ProviderId", getProviderId())
				.append("ProviderName", getProviderName())
				.append("contractNo", getContractNo())
				.append("TotalPrice", getTotalPrice())
				.append("CreateDesc", getCreateDesc())
				.append("CreateOperId", getCreateOperId())
				.append("CreateTime", getCreateTime())
				.append("ConfOperId", getConfOperId())
				.append("ConfTime", getConfTime())
				.append("ConfDesc", getConfDesc())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPurchaseId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PurPurchase == false) return false;
		if(this == obj) return true;
		PurPurchase other = (PurPurchase)obj;
		return new EqualsBuilder()
			.append(getPurchaseId(),other.getPurchaseId())
			.isEquals();
	}

}
