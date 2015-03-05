package dwz.business.rpt;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.RptPurchaseColl;

public class PurchaseColl extends AbstractBusinessObject {
	
	private RptPurchaseColl rptPurchaseColl;
	
	public PurchaseColl(){
		this.rptPurchaseColl = new RptPurchaseColl();
	}
	
	public PurchaseColl(RptPurchaseColl rptPurchaseColl){
		this.rptPurchaseColl = rptPurchaseColl;
	}

	public RptPurchaseColl getRptPurchaseColl() {
		return rptPurchaseColl;
	}

	public void setRptPurchaseColl(RptPurchaseColl rptPurchaseColl) {
		this.rptPurchaseColl = rptPurchaseColl;
	}

	@Override
	public Serializable getId() {
		return this.rptPurchaseColl.getPurchaseCollId();
	}

	public Integer getPurchaseCollId() {
		return this.rptPurchaseColl.getPurchaseCollId();
	}

	public void setPurchaseCollId(Integer purchaseCollId) {
		this.rptPurchaseColl.setPurchaseCollId(purchaseCollId);
	}

	public Integer getOrgId() {
		return this.rptPurchaseColl.getOrgId();
	}

	public void setOrgId(Integer orgId) {
		this.rptPurchaseColl.setOrgId(orgId);
	}

	public String getPurchaseProp() {
		return this.rptPurchaseColl.getPurchaseProp();
	}

	public void setPurchaseProp(String purchaseProp) {
		this.rptPurchaseColl.setPurchaseProp(purchaseProp);
	}

	public Date getTransTime() {
		return this.rptPurchaseColl.getTransTime();
	}

	public void setTransTime(Date transTime) {
		this.rptPurchaseColl.setTransTime(transTime);
	}

	public Integer getProviderId() {
		return this.rptPurchaseColl.getProviderId();
	}

	public void setProviderId(Integer providerId) {
		this.rptPurchaseColl.setProviderId(providerId);
	}

	public String getProviderName() {
		return this.rptPurchaseColl.getProviderName();
	}

	public void setProviderName(String providerName) {
		this.rptPurchaseColl.setProviderName(providerName);
	}

	public String getProductModel() {
		return this.rptPurchaseColl.getProductModel();
	}

	public void setProductModel(String productModel) {
		this.rptPurchaseColl.setProductModel(productModel);
	}

	public String getProductName() {
		return this.rptPurchaseColl.getProductName();
	}

	public void setProductName(String productName) {
		this.rptPurchaseColl.setProductName(productName);
	}

	public String getStandard() {
		return this.rptPurchaseColl.getStandard();
	}

	public void setStandard(String standard) {
		this.rptPurchaseColl.setStandard(standard);
	}

	public Integer getQuantity() {
		return this.rptPurchaseColl.getQuantity();
	}

	public void setQuantity(Integer quantity) {
		this.rptPurchaseColl.setQuantity(quantity);
	}

	public Integer getPrice() {
		return this.rptPurchaseColl.getPrice();
	}

	public void setPrice(Integer price) {
		this.rptPurchaseColl.setPrice(price);
	}

	public Integer getAmount() {
		return this.rptPurchaseColl.getAmount();
	}

	public void setAmount(Integer amount) {
		this.rptPurchaseColl.setAmount(amount);
	}
	
	public String getTransDate() {
		return this.rptPurchaseColl.getTransDate();
	}

	public void setTransDate(String transDate) {
		this.rptPurchaseColl.setTransDate(transDate);
	}

	public Integer getSumAmount() {
		return this.rptPurchaseColl.getSumAmount();
	}

	public void setSumAmount(Integer sumAmount) {
		this.rptPurchaseColl.setSumAmount(sumAmount);
	}
}
