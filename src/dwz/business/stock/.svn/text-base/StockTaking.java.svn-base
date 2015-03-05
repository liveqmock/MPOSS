package dwz.business.stock;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.StoStockTaking;

public class StockTaking extends AbstractBusinessObject {
	
	private StoStockTaking stoStockTaking;
	private List<StockTakingDetail> stockTakingDetailList;
	
	public StockTaking(){
		this.stoStockTaking = new StoStockTaking();
	}
	
	public StockTaking(StoStockTaking stoStockTaking) {
		this.stoStockTaking = stoStockTaking;
	}

	public StoStockTaking getStoStockTaking() {
		return stoStockTaking;
	}

	public void setStoStockTaking(StoStockTaking stoStockTaking) {
		this.stoStockTaking = stoStockTaking;
	}

	@Override
	public Serializable getId() {
		return this.stoStockTaking.getStockTakingId();
	}
	
	public Integer getStockTakingId() {
		return this.stoStockTaking.getStockTakingId();
	}
	public void setStockTakingId(Integer stockTakingId) {
		this.stoStockTaking.setStockTakingId(stockTakingId);
	}
	public String getStockTakingNo() {
		return this.stoStockTaking.getStockTakingNo();
	}
	public void setStockTakingNo(String stockTakingNo) {
		this.stoStockTaking.setStockTakingNo(stockTakingNo);
	}
	public Integer getOrgId() {
		return this.stoStockTaking.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.stoStockTaking.setOrgId(orgId);
	}
	public Integer getRegOperId() {
		return this.stoStockTaking.getRegOperId();
	}
	public void setRegOperId(Integer regOperId) {
		this.stoStockTaking.setRegOperId(regOperId);
	}
	public Date getRegTime() {
		return this.stoStockTaking.getRegTime();
	}
	public void setRegTime(Date regTime) {
		this.stoStockTaking.setRegTime(regTime);
	}
	public String getRegDesc() {
		return this.stoStockTaking.getRegDesc();
	}
	public void setRegDesc(String regDesc) {
		this.stoStockTaking.setRegDesc(regDesc);
	}
	public Integer getConfOperId() {
		return this.stoStockTaking.getConfOperId();
	}
	public void setConfOperId(Integer confOperId) {
		this.stoStockTaking.setConfOperId(confOperId);
	}
	public Date getConfTime() {
		return this.stoStockTaking.getConfTime();
	}
	public void setConfTime(Date confTime) {
		this.stoStockTaking.setConfTime(confTime);
	}
	public String getConfDesc() {
		return this.stoStockTaking.getConfDesc();
	}
	public void setConfDesc(String confDesc) {
		this.stoStockTaking.setConfDesc(confDesc);
	}
	public String getStatus() {
		return this.stoStockTaking.getStatus();
	}
	public void setStatus(String status) {
		this.stoStockTaking.setStatus(status);
	}

	public List<StockTakingDetail> getStockTakingDetailList() {
		return stockTakingDetailList;
	}

	public void setStockTakingDetailList(
			List<StockTakingDetail> stockTakingDetailList) {
		this.stockTakingDetailList = stockTakingDetailList;
	}


}
