package dwz.business.purchase;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.PurPurchase;

public class Purchase extends AbstractBusinessObject {
	
	private PurPurchase purPurchase;
	
	private Double inputTotalPrice;
	
	private List<PurchaseDetail> purchaseDetailList;
	
	private List<ArrivalDetail> arrivalDetailList;
	
	public Purchase(){
		this.purPurchase = new PurPurchase();
	}
	
	public Purchase(PurPurchase purPurchase){
		this.purPurchase = purPurchase;
	}

	public PurPurchase getPurPurchase() {
		return purPurchase;
	}

	public void setPurPurchase(PurPurchase purPurchase) {
		this.purPurchase = purPurchase;
	}

	@Override
	public Serializable getId() {
		return this.purPurchase.getPurchaseId();
	}
	
	public Integer getPurchaseId() {
		return this.purPurchase.getPurchaseId();
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purPurchase.setPurchaseId(purchaseId);
	}
	public String getPurchaseNo() {
		return this.purPurchase.getPurchaseNo();
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purPurchase.setPurchaseNo(purchaseNo);
	}
	public String getPurchaseProp() {
		return this.purPurchase.getPurchaseProp();
	}
	public void setPurchaseProp(String purchaseProp) {
		this.purPurchase.setPurchaseProp(purchaseProp);
	}
	public String getSaleNos() {
		return this.purPurchase.getSaleNos();
	}
	public void setSaleNos(String saleNos) {
		this.purPurchase.setSaleNos(saleNos);
	}
	public Integer getOrgId() {
		return this.purPurchase.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.purPurchase.setOrgId(orgId);
	}
	public Integer getProviderId() {
		return this.purPurchase.getProviderId();
	}
	public void setProviderId(Integer providerId) {
		this.purPurchase.setProviderId(providerId);
	}
	public String getProviderName() {
		return this.purPurchase.getProviderName();
	}
	public void setProviderName(String providerName) {
		this.purPurchase.setProviderName(providerName);
	}
	public String getContractNo() {
		return this.purPurchase.getContractNo();
	}
	public void setContractNo(String contractNo) {
		this.purPurchase.setContractNo(contractNo);
	}
	public Integer getTotalPrice() {
		return this.purPurchase.getTotalPrice();
	}
	public void setTotalPrice(Integer totalPrice) {
		this.purPurchase.setTotalPrice(totalPrice);
	}
	public String getCreateDesc() {
		return this.purPurchase.getCreateDesc();
	}
	public void setCreateDesc(String createDesc) {
		this.purPurchase.setCreateDesc(createDesc);
	}
	public Integer getCreateOperId() {
		return this.purPurchase.getCreateOperId();
	}
	public void setCreateOperId(Integer createOperId) {
		this.purPurchase.setCreateOperId(createOperId);
	}
	public Date getCreateTime() {
		return this.purPurchase.getCreateTime();
	}
	public void setCreateTime(Date createTime) {
		this.purPurchase.setCreateTime(createTime);
	}
	public Integer getConfOperId() {
		return this.purPurchase.getConfOperId();
	}
	public void setConfOperId(Integer confOperId) {
		this.purPurchase.setConfOperId(confOperId);
	}
	public Date getConfTime() {
		return this.purPurchase.getConfTime();
	}
	public void setConfTime(Date confTime) {
		this.purPurchase.setConfTime(confTime);
	}
	public String getConfDesc() {
		return this.purPurchase.getConfDesc();
	}
	public void setConfDesc(String confDesc) {
		this.purPurchase.setConfDesc(confDesc);
	}
	public String getStatus() {
		return this.purPurchase.getStatus();
	}
	public void setStatus(String status) {
		this.purPurchase.setStatus(status);
	}
	public List<PurchaseDetail> getPurchaseDetailList() {
		return purchaseDetailList;
	}
	public void setPurchaseDetailList(List<PurchaseDetail> purchaseDetailList) {
		this.purchaseDetailList = purchaseDetailList;
	}

	public Double getInputTotalPrice() {
		return inputTotalPrice;
	}

	public void setInputTotalPrice(Double inputTotalPrice) {
		this.inputTotalPrice = inputTotalPrice;
	}

	public List<ArrivalDetail> getArrivalDetailList() {
		return arrivalDetailList;
	}

	public void setArrivalDetailList(List<ArrivalDetail> arrivalDetailList) {
		this.arrivalDetailList = arrivalDetailList;
	}


}
