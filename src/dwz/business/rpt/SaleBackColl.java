package dwz.business.rpt;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.RptSaleBackColl;

public class SaleBackColl extends AbstractBusinessObject {
	
	private RptSaleBackColl rptSaleBackColl;
	
	public SaleBackColl(){
		this.rptSaleBackColl = new RptSaleBackColl();
	}
	
	public SaleBackColl(RptSaleBackColl rptSaleBackColl){
		this.rptSaleBackColl = rptSaleBackColl;
	}

	public RptSaleBackColl getRptSaleBackColl() {
		return rptSaleBackColl;
	}

	public void setRptSaleBackColl(RptSaleBackColl rptSaleBackColl) {
		this.rptSaleBackColl = rptSaleBackColl;
	}

	@Override
	public Serializable getId() {
		return this.rptSaleBackColl.getSaleBackCollId();
	}
	
	public Integer getSaleBackCollId() {
		return this.rptSaleBackColl.getSaleBackCollId();
	}
	public void setSaleBackCollId(Integer saleBackCollId) {
		this.rptSaleBackColl.setSaleBackCollId(saleBackCollId);
	}
	public Integer getOrgId() {
		return this.rptSaleBackColl.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.rptSaleBackColl.setOrgId(orgId);
	}
	public String getSaleBackType() {
		return this.rptSaleBackColl.getSaleBackType();
	}
	public void setSaleBackType(String saleBackType) {
		this.rptSaleBackColl.setSaleBackType(saleBackType);
	}
	public Date getTransTime() {
		return this.rptSaleBackColl.getTransTime();
	}
	public void setTransTime(Date transTime) {
		this.rptSaleBackColl.setTransTime(transTime);
	}
	public Integer getConsumerId() {
		return this.rptSaleBackColl.getConsumerId();
	}
	public void setConsumerId(Integer consumerId) {
		this.rptSaleBackColl.setConsumerId(consumerId);
	}
	public String getConsumerName() {
		return this.rptSaleBackColl.getConsumerName();
	}
	public void setConsumerName(String consumerName) {
		this.rptSaleBackColl.setConsumerName(consumerName);
	}
	public String getProductModel() {
		return this.rptSaleBackColl.getProductModel();
	}
	public void setProductModel(String productModel) {
		this.rptSaleBackColl.setProductModel(productModel);
	}
	public String getProductName() {
		return this.rptSaleBackColl.getProductName();
	}
	public void setProductName(String productName) {
		this.rptSaleBackColl.setProductName(productName);
	}
	public String getStandard() {
		return this.rptSaleBackColl.getStandard();
	}
	public void setStandard(String standard) {
		this.rptSaleBackColl.setStandard(standard);
	}
	public Integer getQuantity() {
		return this.rptSaleBackColl.getQuantity();
	}
	public void setQuantity(Integer quantity) {
		this.rptSaleBackColl.setQuantity(quantity);
	}
	public Integer getPrice() {
		return this.rptSaleBackColl.getPrice();
	}
	public void setPrice(Integer price) {
		this.rptSaleBackColl.setPrice(price);
	}
	public Integer getAmount() {
		return this.rptSaleBackColl.getAmount();
	}
	public void setAmount(Integer amount) {
		this.rptSaleBackColl.setAmount(amount);
	}
	public String getTransDate() {
		return this.rptSaleBackColl.getTransDate();
	}
	public void setTransDate(String transDate) {
		this.rptSaleBackColl.setTransDate(transDate);
	}
	public Integer getSumAmount() {
		return this.rptSaleBackColl.getSumAmount();
	}
	public void setSumAmount(Integer sumAmount) {
		this.rptSaleBackColl.setSumAmount(sumAmount);
	}

}
