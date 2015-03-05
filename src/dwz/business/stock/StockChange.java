package dwz.business.stock;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.StoStockChange;

public class StockChange extends AbstractBusinessObject {
	
	private StoStockChange stoStockChange;
	
	public StockChange(){
		this.stoStockChange = new StoStockChange();
	}
	
	public StockChange(StoStockChange stoStockChange){
		this.stoStockChange = stoStockChange;
	}

	public StoStockChange getStoStockChange() {
		return stoStockChange;
	}

	public void setStoStockChange(StoStockChange stoStockChange) {
		this.stoStockChange = stoStockChange;
	}

	@Override
	public Serializable getId() {
		return this.stoStockChange.getStockChangeId();
	}
	
	public Integer getStockChangeId() {
		return this.stoStockChange.getStockChangeId();
	}
	public void setStockChangeId(Integer stockChangeId) {
		this.stoStockChange.setStockChangeId(stockChangeId);
	}
	public Integer getOrgId() {
		return this.stoStockChange.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.stoStockChange.setOrgId(orgId);
	}
	public Integer getProviderProductId() {
		return this.stoStockChange.getProviderProductId();
	}
	public void setProviderProductId(Integer providerProductId) {
		this.stoStockChange.setProviderProductId(providerProductId);
	}
	public String getStandard() {
		return this.stoStockChange.getStandard();
	}
	public void setStandard(String standard) {
		this.stoStockChange.setStandard(standard);
	}
	public Date getChangeTime() {
		return this.stoStockChange.getChangeTime();
	}
	public void setChangeTime(Date changeTime) {
		this.stoStockChange.setChangeTime(changeTime);
	}
	public String getChangeAction() {
		return this.stoStockChange.getChangeAction();
	}
	public void setChangeAction(String changeAction) {
		this.stoStockChange.setChangeAction(changeAction);
	}
	public Integer getChangeQuantity() {
		return this.stoStockChange.getChangeQuantity();
	}
	public void setChangeQuantity(Integer changeQuantity) {
		this.stoStockChange.setChangeQuantity(changeQuantity);
	}
	public String getBusiType() {
		return this.stoStockChange.getBusiType();
	}
	public void setBusiType(String busiType) {
		this.stoStockChange.setBusiType(busiType);
	}
	public Integer getTopId() {
		return this.stoStockChange.getTopId();
	}
	public void setTopId(Integer topId) {
		this.stoStockChange.setTopId(topId);
	}
	public Integer getTargetLeafId() {
		return this.stoStockChange.getTargetLeafId();
	}
	public void setTargetLeafId(Integer targetLeafId) {
		this.stoStockChange.setTargetLeafId(targetLeafId);
	}
	public String getProviderName() {
		return this.stoStockChange.getProviderName();
	}
	public void setProviderName(String providerName) {
		this.stoStockChange.setProviderName(providerName);
	}
	public String getProductModel() {
		return this.stoStockChange.getProductModel();
	}
	public void setProductModel(String productModel) {
		this.stoStockChange.setProductModel(productModel);
	}
	public String getProductName() {
		return this.stoStockChange.getProductName();
	}
	public void setProductName(String productName) {
		this.stoStockChange.setProductName(productName);
	}
	public String getProductEngName() {
		return this.stoStockChange.getProductEngName();
	}
	public void setProductEngName(String productEngName) {
		this.stoStockChange.setProductEngName(productEngName);
	}

}
