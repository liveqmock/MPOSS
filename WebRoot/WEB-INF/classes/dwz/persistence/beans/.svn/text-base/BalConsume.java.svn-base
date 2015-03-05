package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class BalConsume extends AbstractDO {

	private Integer consumeId;
	private Integer orgId;
	private Date consumeTime;
	private String busiType;
	private Integer providerProductId;
	private String standard;
	private Integer quantity;
	private Integer unitPrice;
	private Integer price;
	private String memo;
	private Integer targetId;
	private String targetName;
	private Integer paperId;
	private String paperNo;
	private Integer targetLeafId;
	private String validFlag;
	
	private Integer balancePrice;
	private String productModel;
	private String productName;
	private String unit;
	
	private Integer consumerId;
	private String consumerName;
	private Integer providerId;
	private String providerName;
	private Integer totalBusiPrice;
	private Integer totalBackPrice;

	public Integer getConsumeId() {
		return consumeId;
	}

	public void setConsumeId(Integer consumeId) {
		this.consumeId = consumeId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Date getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public String getPaperNo() {
		return paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	public Integer getTargetLeafId() {
		return targetLeafId;
	}

	public void setTargetLeafId(Integer targetLeafId) {
		this.targetLeafId = targetLeafId;
	}

	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public Integer getBalancePrice() {
		return balancePrice;
	}

	public void setBalancePrice(Integer balancePrice) {
		this.balancePrice = balancePrice;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public Integer getTotalBusiPrice() {
		return totalBusiPrice;
	}

	public void setTotalBusiPrice(Integer totalBusiPrice) {
		this.totalBusiPrice = totalBusiPrice;
	}

	public Integer getTotalBackPrice() {
		return totalBackPrice;
	}

	public void setTotalBackPrice(Integer totalBackPrice) {
		this.totalBackPrice = totalBackPrice;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ConsumeId", getConsumeId())
				.append("OrgId",getOrgId())
				.append("ConsumeTime", getConsumeTime())
				.append("BusiType", getBusiType())
				.append("ProviderProductId", getProviderProductId())
				.append("Standard", getStandard())
				.append("Quantity", getQuantity())
				.append("UnitPrice", getUnitPrice())
				.append("Price", getPrice())
				.append("Memo", getMemo())
				.append("TargetId", getTargetId())
				.append("TargetName", getTargetName())
				.append("PaperId", getPaperId())
				.append("PaperNo", getPaperNo())
				.append("TargetLeafId", getTargetLeafId())
				.append("ValidFlag", getValidFlag()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getConsumeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BalConsume == false) return false;
		if(this == obj) return true;
		BalConsume other = (BalConsume)obj;
		return new EqualsBuilder()
			.append(getConsumeId(),other.getConsumeId())
			.isEquals();
	}

}
