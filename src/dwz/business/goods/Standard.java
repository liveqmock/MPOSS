package dwz.business.goods;

import java.io.Serializable;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.ProStandard;

public class Standard extends AbstractBusinessObject {
	
	private ProStandard proStandard;
	
	public Standard(){
		this.proStandard = new ProStandard();
	}
	
	public Standard(ProStandard proStandard){
		this.proStandard = proStandard;
	}

	public ProStandard getProStandard() {
		return proStandard;
	}

	public void setProStandard(ProStandard proStandard) {
		this.proStandard = proStandard;
	}

	@Override
	public Serializable getId() {
		return this.proStandard.getStandardId();
	}
	
	public Integer getStandardId() {
		return this.proStandard.getStandardId();
	}
	public void setStandardId(Integer standardId) {
		this.proStandard.setStandardId(standardId);
	}
	public Integer getProductId() {
		return this.proStandard.getProductId();
	}
	public void setProductId(Integer productId) {
		this.proStandard.setProductId(productId);
	}
	public String getProductModel() {
		return this.proStandard.getProductModel();
	}
	public void setProductModel(String productModel) {
		this.proStandard.setProductModel(productModel);
	}
	public String getProductName() {
		return this.proStandard.getProductName();
	}
	public void setProductName(String productName) {
		this.proStandard.setProductName(productName);
	}
	public String getStandard() {
		return this.proStandard.getStandard();
	}
	public void setStandard(String standard) {
		this.proStandard.setStandard(standard);
	}

}
