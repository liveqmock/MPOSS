package dwz.business.goods;

import java.io.Serializable;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.ProProduct;

public class Product extends AbstractBusinessObject {
	
	private ProProduct proProduct;
	
	private String productShow;
	
	public Product(){
		this.proProduct = new ProProduct();
	}
	
	public Product(ProProduct proProduct) {
		this.proProduct = proProduct;
	}

	public ProProduct getProProduct() {
		return proProduct;
	}

	public void setProProduct(ProProduct proProduct) {
		this.proProduct = proProduct;
	}

	@Override
	public Serializable getId() {
		return this.proProduct.getProductId();
	}
	
	public Integer getProductId() {
		return this.proProduct.getProductId();
	}
	public void setProductId(Integer productId) {
		this.proProduct.setProductId(productId);
	}
	public Integer getOrgId() {
		return this.proProduct.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.proProduct.setOrgId(orgId);
	}
	public String getProductModel() {
		return this.proProduct.getProductModel();
	}
	public void setProductModel(String productModel) {
		this.proProduct.setProductModel(productModel);
	}
	public String getProductName() {
		return this.proProduct.getProductName();
	}
	public void setProductName(String productName) {
		this.proProduct.setProductName(productName);
	}
	public String getEngLetter() {
		return this.proProduct.getEngLetter();
	}
	public void setEngLetter(String engLetter) {
		this.proProduct.setEngLetter(engLetter);
	}
	public String getProductEngName() {
		return this.proProduct.getProductEngName();
	}
	public void setProductEngName(String productEngName) {
		this.proProduct.setProductEngName(productEngName);
	}
	public String getUnit() {
		return this.proProduct.getUnit();
	}
	public void setUnit(String unit) {
		this.proProduct.setUnit(unit);
	}
	public String getPic() {
		return this.proProduct.getPic();
	}
	public void setPic(String pic) {
		this.proProduct.setPic(pic);
	}
	public Integer getPackQuantity() {
		return this.proProduct.getPackQuantity();
	}
	public void setPackQuantity(Integer packQuantity) {
		this.proProduct.setPackQuantity(packQuantity);
	}
	public Double getPackWeight() {
		return this.proProduct.getPackWeight();
	}
	public void setPackWeight(Double packWeight) {
		this.proProduct.setPackWeight(packWeight);
	}
	public Double getPackVolume() {
		return this.proProduct.getPackVolume();
	}
	public void setPackVolume(Double packVolume) {
		this.proProduct.setPackVolume(packVolume);
	}
	
	public String getStandard() {
		return this.proProduct.getStandard();
	}
	public void setStandard(String standard) {
		this.proProduct.setStandard(standard);
	}
	public String getPicImg() {
		return "/styles/theme/img/product/"+this.proProduct.getPic();
	}
	public String getProductSuggestShow(){
		return this.proProduct.getProductModel()+"-"+this.proProduct.getProductName();
	}

	public String getProductShow() {
		return productShow;
	}

	public void setProductShow(String productShow) {
		this.productShow = productShow;
	}
	
}
