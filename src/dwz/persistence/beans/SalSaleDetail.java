package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SalSaleDetail extends AbstractDO {
	
	private Integer saleDetailId;
	private Integer no;
	private String saleDetailNo;
	private Integer saleId;
	private Integer productId;
	private String standard;
	private Integer saleQuantity;
	private Integer saleUnitPrice;
	private String saleDesc;
	private Integer salePrice;
	private Integer purchaseQuantity;
	private Integer arrivalQuantity;
	private Integer bakQuantity;
	private Integer packAmount;
	private Integer deliverQuantity;
	private String providerDesc;
	private Integer deliverCostPrice;
	private Integer remainBakQuantity;
	
	private String saleNo;
	private String consumerName;
	private String productModel;
	private String productName;
	private String pic;
	private String unit;
	private Integer packQuantity;
	private Double packWeight;
	private Double packVolume;
	private Integer totalSaleQuantity;
	private Integer totalSalePrice;
	private Integer totalDeliverQuantity;
	private Integer totalRemainBakQuantity;
	private Integer totalCostPrice;
	
	
	public Integer getSaleDetailId() {
		return saleDetailId;
	}
	public void setSaleDetailId(Integer saleDetailId) {
		this.saleDetailId = saleDetailId;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getSaleDetailNo() {
		return saleDetailNo;
	}
	public void setSaleDetailNo(String saleDetailNo) {
		this.saleDetailNo = saleDetailNo;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getSaleQuantity() {
		return saleQuantity;
	}
	public void setSaleQuantity(Integer saleQuantity) {
		this.saleQuantity = saleQuantity;
	}
	public Integer getSaleUnitPrice() {
		return saleUnitPrice;
	}
	public void setSaleUnitPrice(Integer saleUnitPrice) {
		this.saleUnitPrice = saleUnitPrice;
	}
	public Integer getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}
	public Integer getDeliverQuantity() {
		return deliverQuantity;
	}
	public void setDeliverQuantity(Integer deliverQuantity) {
		this.deliverQuantity = deliverQuantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public String getSaleDesc() {
		return saleDesc;
	}
	public void setSaleDesc(String saleDesc) {
		this.saleDesc = saleDesc;
	}
	public Integer getArrivalQuantity() {
		return arrivalQuantity;
	}
	public void setArrivalQuantity(Integer arrivalQuantity) {
		this.arrivalQuantity = arrivalQuantity;
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
	public String getProviderDesc() {
		return providerDesc;
	}
	public void setProviderDesc(String providerDesc) {
		this.providerDesc = providerDesc;
	}
	public Integer getDeliverCostPrice() {
		return deliverCostPrice;
	}
	public void setDeliverCostPrice(Integer deliverCostPrice) {
		this.deliverCostPrice = deliverCostPrice;
	}
	public Integer getRemainBakQuantity() {
		return remainBakQuantity;
	}
	public void setRemainBakQuantity(Integer remainBakQuantity) {
		this.remainBakQuantity = remainBakQuantity;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	public Integer getTotalSaleQuantity() {
		return totalSaleQuantity;
	}
	public void setTotalSaleQuantity(Integer totalSaleQuantity) {
		this.totalSaleQuantity = totalSaleQuantity;
	}
	public Integer getTotalSalePrice() {
		return totalSalePrice;
	}
	public void setTotalSalePrice(Integer totalSalePrice) {
		this.totalSalePrice = totalSalePrice;
	}
	public Integer getTotalDeliverQuantity() {
		return totalDeliverQuantity;
	}
	public void setTotalDeliverQuantity(Integer totalDeliverQuantity) {
		this.totalDeliverQuantity = totalDeliverQuantity;
	}
	public Integer getTotalCostPrice() {
		return totalCostPrice;
	}
	public void setTotalCostPrice(Integer totalCostPrice) {
		this.totalCostPrice = totalCostPrice;
	}
	
	public Integer getTotalRemainBakQuantity() {
		return totalRemainBakQuantity;
	}
	public void setTotalRemainBakQuantity(Integer totalRemainBakQuantity) {
		this.totalRemainBakQuantity = totalRemainBakQuantity;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("SaleDetailId", getSaleDetailId())
				.append("No", getNo())
				.append("SaleDetailNo", getSaleDetailNo())
				.append("SaleId",getSaleId())
				.append("ProductId",getProductId())
				.append("SaleQuantity", getSaleQuantity())
				.append("SaleDesc", getSaleDesc())
				.append("SaleUnitPrice", getSaleUnitPrice())
				.append("SalePrice",getSalePrice())
				.append("Standard",getStandard())
				.append("PurchaseQuantity", getPurchaseQuantity())
				.append("ArrivalQuantity", getArrivalQuantity())
				.append("BakQuantity", getBakQuantity())
				.append("PackAmount", getPackAmount())
				.append("DeliverQuantity", getDeliverQuantity())
				.append("ProviderDesc", getProviderDesc())
				.append("DeliverCostPrice", getDeliverCostPrice())
				.append("RemainBakQuantity", getRemainBakQuantity()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSaleDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SalSaleDetail == false) return false;
		if(this == obj) return true;
		SalSaleDetail other = (SalSaleDetail)obj;
		return new EqualsBuilder()
			.append(getSaleDetailId(),other.getSaleDetailId())
			.isEquals();
	}
}
