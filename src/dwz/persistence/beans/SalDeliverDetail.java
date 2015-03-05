package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SalDeliverDetail extends AbstractDO {
	
	private Integer deliverDetailId;
	private Integer deliverId;
	private String saleNo;
	private Integer saleDetailId;
	private String saleDetailNo;
	private Integer providerProductId;
	private String standard;
	private Integer saleUnitPrice;
	private Integer bakQuantity;
	private Integer packAmount;
	private String packNumber;
	private Integer costUnitPrice;
	private Integer costPrice;
	private Double bakWeight;
	private Double bakVolume;
	private Integer bakOperId;
	private Date bakTime;
	
	private String providerName;
	private String productModel;
	private String productName;
	private String productEngName;
	private String unit;
	private String pic;
	
	public Integer getDeliverDetailId() {
		return deliverDetailId;
	}
	public void setDeliverDetailId(Integer deliverDetailId) {
		this.deliverDetailId = deliverDetailId;
	}
	public Integer getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(Integer deliverId) {
		this.deliverId = deliverId;
	}
	public Integer getSaleDetailId() {
		return saleDetailId;
	}
	public void setSaleDetailId(Integer saleDetailId) {
		this.saleDetailId = saleDetailId;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public String getSaleDetailNo() {
		return saleDetailNo;
	}
	public void setSaleDetailNo(String saleDetailNo) {
		this.saleDetailNo = saleDetailNo;
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
	public Integer getSaleUnitPrice() {
		return saleUnitPrice;
	}
	public void setSaleUnitPrice(Integer saleUnitPrice) {
		this.saleUnitPrice = saleUnitPrice;
	}
	public Integer getBakQuantity() {
		return bakQuantity;
	}
	public void setBakQuantity(Integer bakQuantity) {
		this.bakQuantity = bakQuantity;
	}
	public Integer getPackAmount() {
		return packAmount;
	}
	public void setPackAmount(Integer packAmount) {
		this.packAmount = packAmount;
	}
	public String getPackNumber() {
		return packNumber;
	}
	public void setPackNumber(String packNumber) {
		this.packNumber = packNumber;
	}
	public Integer getCostUnitPrice() {
		return costUnitPrice;
	}
	public void setCostUnitPrice(Integer costUnitPrice) {
		this.costUnitPrice = costUnitPrice;
	}
	public Integer getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
	public Double getBakWeight() {
		return bakWeight;
	}
	public void setBakWeight(Double bakWeight) {
		this.bakWeight = bakWeight;
	}
	public Double getBakVolume() {
		return bakVolume;
	}
	public void setBakVolume(Double bakVolume) {
		this.bakVolume = bakVolume;
	}
	public Integer getBakOperId() {
		return bakOperId;
	}
	public void setBakOperId(Integer bakOperId) {
		this.bakOperId = bakOperId;
	}
	public Date getBakTime() {
		return bakTime;
	}
	public void setBakTime(Date bakTime) {
		this.bakTime = bakTime;
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
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("DeliverDetailId", getDeliverDetailId())
				.append("DeliverId", getDeliverId())
				.append("SaleDetailId", getSaleDetailId())
				.append("SaleDetailNo", getSaleDetailNo())
				.append("ProviderProductId", getProviderProductId())
				.append("Standard", getStandard())
				.append("BakQuantity", getBakQuantity())
				.append("PackAmount", getPackAmount())
				.append("PackNumber", getPackNumber())
				.append("SaleUnitPrice", getSaleUnitPrice())
				.append("CostUnitPrice", getCostUnitPrice())
				.append("CostPrice", getCostPrice())
				.append("BakWeight", getBakWeight())
				.append("BakVolume", getBakVolume())
				.append("BakOperId", getBakOperId())
				.append("BakTime", getBakTime()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDeliverDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SalDeliverDetail == false) return false;
		if(this == obj) return true;
		SalDeliverDetail other = (SalDeliverDetail)obj;
		return new EqualsBuilder()
			.append(getDeliverDetailId(),other.getDeliverDetailId())
			.isEquals();
	}

}
