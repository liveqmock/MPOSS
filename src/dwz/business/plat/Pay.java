package dwz.business.plat;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.PlaPay;

public class Pay extends AbstractBusinessObject {
	
	private PlaPay plaPay;
	
	public Pay(){
		this.plaPay = new PlaPay();
	}
	
	public Pay(PlaPay plaPay){
		this.plaPay = plaPay;
	}

	@Override
	public Serializable getId() {
		return this.plaPay.getPlatPayId();
	}
	
	public PlaPay getPlaPay() {
		return plaPay;
	}

	public void setPlaPay(PlaPay plaPay) {
		this.plaPay = plaPay;
	}

	public Integer getPlatPayId() {
		return this.plaPay.getPlatPayId();
	}
	public void setPlatPayId(Integer platPayId) {
		this.plaPay.setPlatPayId(platPayId);
	}
	public Integer getOrgId() {
		return this.plaPay.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.plaPay.setOrgId(orgId);
	}
	public Date getPayTime() {
		return this.plaPay.getPayTime();
	}
	public void setPayTime(Date payTime) {
		this.plaPay.setPayTime(payTime);
	}
	public String getPlatServiceType() {
		return this.plaPay.getPlatServiceType();
	}
	public void setPlatServiceType(String platServiceType) {
		this.plaPay.setPlatServiceType(platServiceType);
	}
	public Integer getPayPrice() {
		return this.plaPay.getPayPrice();
	}
	public void setPayPrice(Integer payPrice) {
		this.plaPay.setPayPrice(payPrice);
	}
	public String getPayWay() {
		return this.plaPay.getPayWay();
	}
	public void setPayWay(String payWay) {
		this.plaPay.setPayWay(payWay);
	}
	public String getPaperNo() {
		return this.plaPay.getPaperNo();
	}
	public void setPaperNo(String paperNo) {
		this.plaPay.setPaperNo(paperNo);
	}
	public Integer getBankId() {
		return this.plaPay.getBankId();
	}
	public void setBankId(Integer bankId) {
		this.plaPay.setBankId(bankId);
	}
	public String getBankCardNo() {
		return this.plaPay.getBankCardNo();
	}
	public void setBankCardNo(String bankCardNo) {
		this.plaPay.setBankCardNo(bankCardNo);
	}
	public String getStartDate() {
		return this.plaPay.getStartDate();
	}
	public void setStartDate(String startDate) {
		this.plaPay.setStartDate(startDate);
	}
	public String getEndDate() {
		return this.plaPay.getEndDate();
	}
	public void setEndDate(String endDate) {
		this.plaPay.setEndDate(endDate);
	}

}
