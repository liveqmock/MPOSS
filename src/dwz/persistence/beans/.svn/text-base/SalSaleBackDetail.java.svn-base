package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SalSaleBackDetail extends AbstractDO {
	
	private Integer saleBackDetailId;
	private Integer no;
	private String saleBackDetailNo;
	private Integer saleBackId;
	private Integer providerProductId;
	private String standard;
	private Integer backQuantity;
	private Integer backUnitPrice;
	private String backDesc;
	private Integer backPrice;
	private Integer stockQuantity;
	private Integer providerQuantity;
	private Integer destroyQuantity;
	
	private String providerName;
	private String productModel;
	private String productName;
	private String pic;
	private String unit;
	
	public Integer getSaleBackDetailId() {
		return saleBackDetailId;
	}
	public void setSaleBackDetailId(Integer saleBackDetailId) {
		this.saleBackDetailId = saleBackDetailId;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getSaleBackDetailNo() {
		return saleBackDetailNo;
	}
	public void setSaleBackDetailNo(String saleBackDetailNo) {
		this.saleBackDetailNo = saleBackDetailNo;
	}
	public Integer getSaleBackId() {
		return saleBackId;
	}
	public void setSaleBackId(Integer saleBackId) {
		this.saleBackId = saleBackId;
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
	public Integer getBackQuantity() {
		return backQuantity;
	}
	public void setBackQuantity(Integer backQuantity) {
		this.backQuantity = backQuantity;
	}
	public Integer getBackUnitPrice() {
		return backUnitPrice;
	}
	public void setBackUnitPrice(Integer backUnitPrice) {
		this.backUnitPrice = backUnitPrice;
	}
	public String getBackDesc() {
		return backDesc;
	}
	public void setBackDesc(String backDesc) {
		this.backDesc = backDesc;
	}
	public Integer getBackPrice() {
		return backPrice;
	}
	public void setBackPrice(Integer backPrice) {
		this.backPrice = backPrice;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Integer getProviderQuantity() {
		return providerQuantity;
	}
	public void setProviderQuantity(Integer providerQuantity) {
		this.providerQuantity = providerQuantity;
	}
	public Integer getDestroyQuantity() {
		return destroyQuantity;
	}
	public void setDestroyQuantity(Integer destroyQuantity) {
		this.destroyQuantity = destroyQuantity;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("SaleBackDetailId", getSaleBackDetailId())
				.append("No", getNo())
				.append("SaleBackDetailNo", getSaleBackDetailNo())
				.append("SaleBackId",getSaleBackId())
				.append("ProviderProductId",getProviderProductId())
				.append("BackQuantity", getBackQuantity())
				.append("BackDesc", getBackDesc())
				.append("BackUnitPrice", getBackUnitPrice())
				.append("BackPrice",getBackPrice())
				.append("Standard",getStandard()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSaleBackDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SalSaleBackDetail == false) return false;
		if(this == obj) return true;
		SalSaleBackDetail other = (SalSaleBackDetail)obj;
		return new EqualsBuilder()
			.append(getSaleBackDetailId(),other.getSaleBackDetailId())
			.isEquals();
	}
}
