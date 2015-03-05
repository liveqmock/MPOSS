package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysProduct extends AbstractDO {
	
	private Integer sysProductId;
	private Integer productId;
	private String productModel;
	private String productName;
	private String engLetter;
	private String productEngName;
	private String unit;
	
	public Integer getSysProductId() {
		return sysProductId;
	}

	public void setSysProductId(Integer sysProductId) {
		this.sysProductId = sysProductId;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("SysProductId", getSysProductId())
				.append("ProductId", getProductId())
				.append("ProductModel",getProductModel())
				.append("ProductName", getProductName())
				.append("EngLetter", getEngLetter())
				.append("ProductEngName", getProductEngName())
				.append("Unit", getUnit()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSysProductId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysProduct == false) return false;
		if(this == obj) return true;
		SysProduct other = (SysProduct)obj;
		return new EqualsBuilder()
			.append(getSysProductId(),other.getSysProductId())
			.isEquals();
	}

}
