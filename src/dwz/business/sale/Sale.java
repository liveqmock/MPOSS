package dwz.business.sale;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dwz.business.partner.Consumer;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.SalSale;

public class Sale extends AbstractBusinessObject {
	
	private SalSale salSale;
	
	private List<SaleDetail> saleDetailList;
	
	private List<DeliverDetail> deliverDetailList;
	
	private Double inputTotalSalePrice;
	
	private Consumer consumer;
	
	public Sale(){
		this.salSale = new SalSale();
	}
	
	public Sale(SalSale salSale){
		this.salSale = salSale;
	}

	public SalSale getSalSale() {
		return salSale;
	}

	public void setSalSale(SalSale salSale) {
		this.salSale = salSale;
	}

	@Override
	public Serializable getId() {
		return this.salSale.getSaleId();
	}
	
	public Integer getSaleId() {
		return this.salSale.getSaleId();
	}
	public void setSaleId(Integer saleId) {
		this.salSale.setSaleId(saleId);
	}
	public String getSaleNo() {
		return this.salSale.getSaleNo();
	}
	public void setSaleNo(String saleNo) {
		this.salSale.setSaleNo(saleNo);
	}
	public String getSaleType() {
		return this.salSale.getSaleType();
	}
	public void setSaleType(String saleType) {
		this.salSale.setSaleType(saleType);
	}
	public Integer getOrgId() {
		return this.salSale.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.salSale.setOrgId(orgId);
	}
	public Integer getConsumerId() {
		return this.salSale.getConsumerId();
	}
	public void setConsumerId(Integer consumerId) {
		this.salSale.setConsumerId(consumerId);
	}
	public String getConsumerName() {
		return this.salSale.getConsumerName();
	}
	public void setConsumerName(String consumerName) {
		this.salSale.setConsumerName(consumerName);
	}
	public Integer getTotalSaleQuantity() {
		return this.salSale.getTotalSaleQuantity();
	}
	public void setTotalSaleQuantity(Integer totalSaleQuantity) {
		this.salSale.setTotalSaleQuantity(totalSaleQuantity);
	}
	public Integer getTotalCostPrice() {
		return this.salSale.getTotalCostPrice();
	}
	public void setTotalCostPrice(Integer totalCostPrice) {
		this.salSale.setTotalCostPrice(totalCostPrice);
	}
	public Integer getTotalSalePrice() {
		return this.salSale.getTotalSalePrice();
	}
	public void setTotalSalePrice(Integer totalSalePrice) {
		this.salSale.setTotalSalePrice(totalSalePrice);
	}
	public String getCreateDesc() {
		return this.salSale.getCreateDesc();
	}
	public void setCreateDesc(String createDesc) {
		this.salSale.setCreateDesc(createDesc);
	}
	public String getArrivalDate() {
		return this.salSale.getArrivalDate();
	}
	public void setArrivalDate(String arrivalDate) {
		this.salSale.setArrivalDate(arrivalDate);
	}
	public Integer getCreateOperId() {
		return this.salSale.getCreateOperId();
	}
	public void setCreateOperId(Integer createOperId) {
		this.salSale.setCreateOperId(createOperId);
	}
	public Date getCreateTime() {
		return this.salSale.getCreateTime();
	}
	public void setCreateTime(Date createTime) {
		this.salSale.setCreateTime(createTime);
	}
	public String getReceAddress() {
		return this.salSale.getReceAddress();
	}
	public void setReceAddress(String receAddress) {
		this.salSale.setReceAddress(receAddress);
	}
	public String getReceMen() {
		return this.salSale.getReceMen();
	}
	public void setReceMen(String receMen) {
		this.salSale.setReceMen(receMen);
	}
	public String getLinkPhone() {
		return this.salSale.getLinkPhone();
	}
	public void setLinkPhone(String linkPhone) {
		this.salSale.setLinkPhone(linkPhone);
	}
	public String getDepositFlag() {
		return this.salSale.getDepositFlag();
	}
	public void setDepositFlag(String depositFlag) {
		this.salSale.setDepositFlag(depositFlag);
	}
	public Integer getConfOperId() {
		return this.salSale.getConfOperId();
	}
	public void setConfOperId(Integer confOperId) {
		this.salSale.setConfOperId(confOperId);
	}
	public Date getConfTime() {
		return this.salSale.getConfTime();
	}
	public void setConfTime(Date confTime) {
		this.salSale.setConfTime(confTime);
	}
	public String getConfDesc() {
		return this.salSale.getConfDesc();
	}
	public void setConfDesc(String confDesc) {
		this.salSale.setConfDesc(confDesc);
	}
	public Integer getPurchaseQuantity() {
		return this.salSale.getPurchaseQuantity();
	}
	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.salSale.setPurchaseQuantity(purchaseQuantity);
	}
	public String getFinishBakFlag() {
		return this.salSale.getFinishBakFlag();
	}
	public void setFinishBakFlag(String finishBakFlag) {
		this.salSale.setFinishBakFlag(finishBakFlag);
	}
	public String getStatus() {
		return this.salSale.getStatus();
	}
	public void setStatus(String status) {
		this.salSale.setStatus(status);
	}

	public List<SaleDetail> getSaleDetailList() {
		return saleDetailList;
	}

	public void setSaleDetailList(List<SaleDetail> saleDetailList) {
		this.saleDetailList = saleDetailList;
	}

	public Double getInputTotalSalePrice() {
		return inputTotalSalePrice;
	}

	public void setInputTotalSalePrice(Double inputTotalSalePrice) {
		this.inputTotalSalePrice = inputTotalSalePrice;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public List<DeliverDetail> getDeliverDetailList() {
		return deliverDetailList;
	}

	public void setDeliverDetailList(List<DeliverDetail> deliverDetailList) {
		this.deliverDetailList = deliverDetailList;
	}

}
