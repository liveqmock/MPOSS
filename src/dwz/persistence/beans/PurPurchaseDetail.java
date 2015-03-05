package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PurPurchaseDetail extends AbstractDO{
	
	private Integer purchaseDetailId;
	private Integer purchaseId;
	private Integer providerProductId;
	private Integer purchaseQuantity;
	private Integer purchaseUnitPrice;
	private Integer purchasePrice;
	private String standard;
	private String saleNo;
	private Integer saleDetailId;
	private String saleDetailNo;
	private Integer arrivalQuantity;
	private Integer arrivalPrice;
	
	private String productModel;
	private String productName;
	private String unit;
	private String pic;
	private Integer totalPurchaseQuantity;
	private Integer totalArrivalQuantity;
	
	public Integer getPurchaseDetailId() {
		return purchaseDetailId;
	}
	public void setPurchaseDetailId(Integer purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
	}
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Integer getProviderProductId() {
		return providerProductId;
	}
	public void setProviderProductId(Integer providerProductId) {
		this.providerProductId = providerProductId;
	}
	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public Integer getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}
	public void setPurchaseUnitPrice(Integer purchaseUnitPrice) {
		this.purchaseUnitPrice = purchaseUnitPrice;
	}
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
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
	public Integer getArrivalPrice() {
		return arrivalPrice;
	}
	public void setArrivalPrice(Integer arrivalPrice) {
		this.arrivalPrice = arrivalPrice;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getTotalPurchaseQuantity() {
		return totalPurchaseQuantity;
	}
	public void setTotalPurchaseQuantity(Integer totalPurchaseQuantity) {
		this.totalPurchaseQuantity = totalPurchaseQuantity;
	}
	public Integer getTotalArrivalQuantity() {
		return totalArrivalQuantity;
	}
	public void setTotalArrivalQuantity(Integer totalArrivalQuantity) {
		this.totalArrivalQuantity = totalArrivalQuantity;
	}
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("PurchaseDetailId", getPurchaseDetailId())
				.append("PurchaseId",getPurchaseId())
				.append("ProviderProductId",getProviderProductId())
				.append("PurchaseQuantity", getPurchaseQuantity())
				.append("PurchaseUnitPrice", getPurchaseUnitPrice())
				.append("PurchasePrice", getPurchasePrice())
				.append("Standard", getStandard())
				.append("SaleNo", getSaleNo())
				.append("SaleDetailId", getSaleDetailId())
				.append("SaleDetailNo", getSaleDetailNo())
				.append("ArrivalQuantity", getArrivalQuantity())
				.append("ArrivalPrice", getArrivalPrice()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPurchaseDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PurPurchaseDetail == false) return false;
		if(this == obj) return true;
		PurPurchaseDetail other = (PurPurchaseDetail)obj;
		return new EqualsBuilder()
			.append(getPurchaseDetailId(),other.getPurchaseDetailId())
			.isEquals();
	}

}
