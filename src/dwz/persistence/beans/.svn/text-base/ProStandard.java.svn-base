package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ProStandard extends AbstractDO{
	
	private Integer standardId;
	private Integer productId;
	private String standard;
	
	private String productModel;
	private String productName;
	
	public Integer getStandardId() {
		return standardId;
	}
	public void setStandardId(Integer standardId) {
		this.standardId = standardId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("StandardId",getStandardId())
				.append("ProductId",getProductId())
				.append("Standard", getStandard()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStandardId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProStandard == false) return false;
		if(this == obj) return true;
		ProStandard other = (ProStandard)obj;
		return new EqualsBuilder()
			.append(getStandardId(),other.getStandardId())
			.isEquals();
	}
	

}
