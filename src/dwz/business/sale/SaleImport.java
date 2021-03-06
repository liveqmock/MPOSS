package dwz.business.sale;

import java.io.Serializable;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.SalSaleImport;

public class SaleImport extends AbstractBusinessObject {
	
	private SalSaleImport salSaleImport;
	
	private Integer productId;
	
	public SaleImport(){
		this.salSaleImport = new SalSaleImport();
	}
	
	public SaleImport(SalSaleImport salSaleImport){
		this.salSaleImport = salSaleImport;
	}
	
	public SalSaleImport getSalSaleImport() {
		return salSaleImport;
	}

	public void setSalSaleImport(SalSaleImport salSaleImport) {
		this.salSaleImport = salSaleImport;
	}

	@Override
	public Serializable getId() {
		return this.salSaleImport.getSaleImportId();
	}

	public Integer getSaleImportId() {
		return this.salSaleImport.getSaleImportId();
	}

	public void setSaleImportId(Integer saleImportId) {
		this.salSaleImport.setSaleImportId(saleImportId);
	}

	public Integer getOrgId() {
		return this.salSaleImport.getOrgId();
	}

	public void setOrgId(Integer orgId) {
		this.salSaleImport.setOrgId(orgId);
	}

	public Integer getOperId() {
		return this.salSaleImport.getOperId();
	}

	public void setOperId(Integer operId) {
		this.salSaleImport.setOperId(operId);
	}

	public String getSaleDetailNo() {
		return this.salSaleImport.getSaleDetailNo();
	}

	public void setSaleDetailNo(String saleDetailNo) {
		this.salSaleImport.setSaleDetailNo(saleDetailNo);
	}

	public String getProductModel() {
		return this.salSaleImport.getProductModel();
	}

	public void setProductModel(String productModel) {
		this.salSaleImport.setProductModel(productModel);
	}

	public String getProductName() {
		return this.salSaleImport.getProductName();
	}

	public void setProductName(String productName) {
		this.salSaleImport.setProductName(productName);
	}

	public String getStandard() {
		return this.salSaleImport.getStandard();
	}

	public void setStandard(String standard) {
		this.salSaleImport.setStandard(standard);
	}

	public String getUnit() {
		return this.salSaleImport.getUnit();
	}

	public void setUnit(String unit) {
		this.salSaleImport.setUnit(unit);
	}

	public Integer getSaleQuantity() {
		return this.salSaleImport.getSaleQuantity();
	}

	public void setSaleQuantity(Integer saleQuantity) {
		this.salSaleImport.setSaleQuantity(saleQuantity);
	}

	public Integer getSaleUnitPrice() {
		return this.salSaleImport.getSaleUnitPrice();
	}

	public void setSaleUnitPrice(Integer saleUnitPrice) {
		this.salSaleImport.setSaleUnitPrice(saleUnitPrice);
	}

	public String getSaleDesc() {
		return this.salSaleImport.getSaleDesc();
	}

	public void setSaleDesc(String saleDesc) {
		this.salSaleImport.setSaleDesc(saleDesc);
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
