package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SalSaleImport extends AbstractDO {
	
	private Integer saleImportId;
	private Integer orgId;
	private Integer operId;
	private String saleDetailNo;
	private String productModel;
	private String productName;
	private String standard;
	private String unit;
	private Integer saleQuantity;
	private Integer saleUnitPrice;
	private String saleDesc;
	
	public Integer getSaleImportId() {
		return saleImportId;
	}

	public void setSaleImportId(Integer saleImportId) {
		this.saleImportId = saleImportId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getOperId() {
		return operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}

	public String getSaleDetailNo() {
		return saleDetailNo;
	}

	public void setSaleDetailNo(String saleDetailNo) {
		this.saleDetailNo = saleDetailNo;
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

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public String getSaleDesc() {
		return saleDesc;
	}

	public void setSaleDesc(String saleDesc) {
		this.saleDesc = saleDesc;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("SaleImportId", getSaleImportId())
				.append("OrgId", getOrgId())
				.append("OperId", getOperId())
				.append("SaleDetailNo", getSaleDetailNo())
				.append("ProductModel",getProductModel())
				.append("ProductName", getProductName())
				.append("Standard",getStandard())
				.append("Unit",getUnit())
				.append("SaleQuantity", getSaleQuantity())
				.append("SaleUnitPrice", getSaleUnitPrice())
				.append("SaleDesc", getSaleDesc()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSaleImportId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SalSaleImport == false) return false;
		if(this == obj) return true;
		SalSaleImport other = (SalSaleImport)obj;
		return new EqualsBuilder()
			.append(getSaleImportId(),other.getSaleImportId())
			.isEquals();
	}
}
