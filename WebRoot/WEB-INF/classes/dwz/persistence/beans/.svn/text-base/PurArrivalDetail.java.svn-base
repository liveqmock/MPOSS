package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PurArrivalDetail extends AbstractDO {
	
	private Integer arrivalDetailId;
	private Integer arrivalId;
	private Integer purchaseDetailId;
	private Integer providerProductId;
	private String standard;
	private String saleNo;
	private Integer saleDetailId;
	private String saleDetailNo;
	private Integer arrivalQuantity;
	private Integer purchaseUnitPrice;
	private Integer arrivalPrice;
	
	private String providerName;
	private String productModel;
	private String productName;
	private String productEngName;
	private String unit;
	private String pic;
	
	public Integer getArrivalDetailId() {
		return arrivalDetailId;
	}
	public void setArrivalDetailId(Integer arrivalDetailId) {
		this.arrivalDetailId = arrivalDetailId;
	}
	public Integer getArrivalId() {
		return arrivalId;
	}
	public void setArrivalId(Integer arrivalId) {
		this.arrivalId = arrivalId;
	}
	public Integer getPurchaseDetailId() {
		return purchaseDetailId;
	}
	public void setPurchaseDetailId(Integer purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
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
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public Integer getSaleDetailId() {
		return saleDetailId;
	}
	public void setSaleDetailId(Integer saleDetailId) {
		this.saleDetailId = saleDetailId;
	}
	public String getSaleDetailNo() {
		return saleDetailNo;
	}
	public void setSaleDetailNo(String saleDetailNo) {
		this.saleDetailNo = saleDetailNo;
	}
	public Integer getArrivalQuantity() {
		return arrivalQuantity;
	}
	public void setArrivalQuantity(Integer arrivalQuantity) {
		this.arrivalQuantity = arrivalQuantity;
	}
	public Integer getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}
	public void setPurchaseUnitPrice(Integer purchaseUnitPrice) {
		this.purchaseUnitPrice = purchaseUnitPrice;
	}
	public Integer getArrivalPrice() {
		return arrivalPrice;
	}
	public void setArrivalPrice(Integer arrivalPrice) {
		this.arrivalPrice = arrivalPrice;
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
				.append("ArrivalDetailId", getArrivalDetailId())
				.append("ArrivalId", getArrivalId())
				.append("PurchaseDetailId", getPurchaseDetailId())
				.append("ProviderProductId", getProviderProductId())
				.append("Standard", getStandard())
				.append("SaleNo", getSaleNo())
				.append("SaleDetailId", getSaleDetailId())
				.append("SaleDetailNo", getSaleDetailNo())
				.append("ArrivalQuantity", getArrivalQuantity())
				.append("PurchaseUnitPrice", getPurchaseUnitPrice())
				.append("ArrivalPrice", getArrivalPrice()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getArrivalDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PurArrivalDetail == false) return false;
		if(this == obj) return true;
		PurArrivalDetail other = (PurArrivalDetail)obj;
		return new EqualsBuilder()
			.append(getArrivalDetailId(),other.getArrivalDetailId())
			.isEquals();
	}

}
