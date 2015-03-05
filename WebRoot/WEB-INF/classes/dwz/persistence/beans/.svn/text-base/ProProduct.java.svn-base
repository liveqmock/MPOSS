package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ProProduct extends AbstractDO {
	
	private Integer productId;
	private Integer orgId;
	private String productModel;
	private String productName;
	private String engLetter;
	private String productEngName;
	private String unit;
	private String pic;
	private Integer packQuantity;
	private Double packWeight;
	private Double packVolume;
	
	private String standard;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
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
	public String getEngLetter() {
		return engLetter;
	}
	public void setEngLetter(String engLetter) {
		this.engLetter = engLetter;
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
	
	
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ProductId", getProductId())
				.append("OrgId",getOrgId())
				.append("ProductModel",getProductModel())
				.append("ProductName", getProductName())
				.append("EngLetter", getEngLetter())
				.append("ProductEngName", getProductEngName())
				.append("Unit",getUnit())
				.append("Pic",getPic())
				.append("PackQuantity", getPackQuantity())
				.append("PackWeight",getPackWeight())
				.append("PackVolume",getPackVolume()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProductId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProProduct == false) return false;
		if(this == obj) return true;
		ProProduct other = (ProProduct)obj;
		return new EqualsBuilder()
			.append(getProductId(),other.getProductId())
			.isEquals();
	}

}
