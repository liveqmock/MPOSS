package dwz.business.purchase;

import java.io.Serializable;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.PurPurchasePrice;

public class PurchasePrice extends AbstractBusinessObject {
	
	private PurPurchasePrice purPurchasePrice;
	
	public PurchasePrice(){
		this.purPurchasePrice = new PurPurchasePrice();
	}
	
	public PurchasePrice(PurPurchasePrice purPurchasePrice){
		this.purPurchasePrice = purPurchasePrice;
	}

	public PurPurchasePrice getPurPurchasePrice() {
		return purPurchasePrice;
	}

	public void setPurPurchasePrice(PurPurchasePrice purPurchasePrice) {
		this.purPurchasePrice = purPurchasePrice;
	}

	@Override
	public Serializable getId() {
		return this.purPurchasePrice.getPurchasePriceId();
	}
	
	public Integer getPurchasePriceId() {
		return this.purPurchasePrice.getPurchasePriceId();
	}
	public void setPurchasePriceId(Integer purchasePriceId) {
		this.purPurchasePrice.setPurchasePriceId(purchasePriceId);
	}
	public Integer getProviderProductId() {
		return this.purPurchasePrice.getProviderProductId();
	}
	public void setProviderProductId(Integer providerProductId) {
		this.purPurchasePrice.setProviderProductId(providerProductId);
	}
	public Integer getProviderId() {
		return this.purPurchasePrice.getProviderId();
	}
	public void setProviderId(Integer providerId) {
		this.purPurchasePrice.setProviderId(providerId);
	}
	public Integer getProductId() {
		return this.purPurchasePrice.getProductId();
	}
	public void setProductId(Integer productId) {
		this.purPurchasePrice.setProductId(productId);
	}
	public String getStandard() {
		return this.purPurchasePrice.getStandard();
	}
	public void setStandard(String standard) {
		this.purPurchasePrice.setStandard(standard);
	}
	public Integer getUnitPrice() {
		return this.purPurchasePrice.getUnitPrice();
	}
	public void setUnitPrice(Integer unitPrice) {
		this.purPurchasePrice.setUnitPrice(unitPrice);
	}

}
