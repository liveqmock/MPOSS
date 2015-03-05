package dwz.business.stock;

import java.io.Serializable;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.StoStock;

public class Stock extends AbstractBusinessObject {
	
	private StoStock stoStock;
	
	private Integer changeQuantity;
	
	private Integer incTotalQuantity;
	private Integer incLockQuantity;
	private Integer incProviderQuantity;
	private Integer decTotalQuantity;
	private Integer decLockQuantity;
	private Integer decProviderQuantity;
	
	public Stock(){
		this.stoStock = new StoStock();
	}
	
	public Stock(StoStock stoStock){
		this.stoStock = stoStock;
	}

	public StoStock getStoStock() {
		return stoStock;
	}

	public void setStoStock(StoStock stoStock) {
		this.stoStock = stoStock;
	}

	@Override
	public Serializable getId() {
		return this.stoStock.getStockId();
	}
	
	public Integer getStockId() {
		return this.stoStock.getStockId();
	}
	public void setStockId(Integer stockId) {
		this.stoStock.setStockId(stockId);
	}
	public Integer getOrgId() {
		return this.stoStock.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.stoStock.setOrgId(orgId);
	}
	public Integer getProviderProductId() {
		return this.stoStock.getProviderProductId();
	}
	public void setProviderProductId(Integer providerProductId) {
		this.stoStock.setProviderProductId(providerProductId);
	}
	public String getStandard() {
		return this.stoStock.getStandard();
	}
	public void setStandard(String standard) {
		this.stoStock.setStandard(standard);
	}
	public Integer getTotalQuantity() {
		return this.stoStock.getTotalQuantity();
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.stoStock.setTotalQuantity(totalQuantity);
	}
	public Integer getLockQuantity() {
		return this.stoStock.getLockQuantity();
	}
	public void setLockQuantity(Integer lockQuantity) {
		this.stoStock.setLockQuantity(lockQuantity);
	}
	public Integer getProviderQuantity() {
		return this.stoStock.getProviderQuantity();
	}
	public void setProviderQuantity(Integer providerQuantity) {
		this.stoStock.setProviderQuantity(providerQuantity);
	}
	
	public String getProviderName(){
		return this.stoStock.getProviderName();
	}
	public void setProviderName(String providerName){
		this.stoStock.setProviderName(providerName);
	}
	public String getProductModel() {
		return this.stoStock.getProductModel();
	}
	public void setProductModel(String productModel) {
		this.stoStock.setProductModel(productModel);
	}
	public String getProductName() {
		return this.stoStock.getProductName();
	}
	public void setProductName(String productName) {
		this.stoStock.setProductName(productName);
	}
	public String getProductEngName() {
		return this.stoStock.getProductEngName();
	}
	public void setProductEngName(String productEngName) {
		this.stoStock.setProductEngName(productEngName);
	}
	public String getPic() {
		return this.stoStock.getPic();
	}
	public void setPic(String pic) {
		this.stoStock.setPic(pic);
	}
	public String getPicImg() {
		return "/styles/theme/img/product/"+this.stoStock.getPic();
	}
	public Integer getUnitPrice() {
		return this.stoStock.getUnitPrice();
	}
	public void setUnitPrice(Integer unitPrice) {
		this.stoStock.setUnitPrice(unitPrice);
	}
	public void setChangeQuantity(Integer changeQuantity){
		this.changeQuantity = changeQuantity;
	}
	public Integer getChangeQuantity(){
		return this.changeQuantity;
	}

	public Integer getIncTotalQuantity() {
		return incTotalQuantity;
	}

	public void setIncTotalQuantity(Integer incTotalQuantity) {
		this.incTotalQuantity = incTotalQuantity;
	}

	public Integer getIncLockQuantity() {
		return incLockQuantity;
	}

	public Integer getDecTotalQuantity() {
		return decTotalQuantity;
	}

	public void setDecTotalQuantity(Integer decTotalQuantity) {
		this.decTotalQuantity = decTotalQuantity;
	}

	public Integer getDecLockQuantity() {
		return decLockQuantity;
	}

	public void setDecLockQuantity(Integer decLockQuantity) {
		this.decLockQuantity = decLockQuantity;
	}

	public void setIncLockQuantity(Integer incLockQuantity) {
		this.incLockQuantity = incLockQuantity;
	}
	public Integer getPackQuantity() {
		return this.stoStock.getPackQuantity();
	}
	public void setPackQuantity(Integer packQuantity) {
		this.stoStock.setPackQuantity(packQuantity);
	}
	public Double getPackWeight() {
		return this.stoStock.getPackWeight();
	}
	public void setPackWeight(Double packWeight) {
		this.stoStock.setPackWeight(packWeight);
	}
	public Double getPackVolume() {
		return this.stoStock.getPackVolume();
	}
	public void setPackVolume(Double packVolume) {
		this.stoStock.setPackVolume(packVolume);
	}

	public Integer getIncProviderQuantity() {
		return incProviderQuantity;
	}

	public void setIncProviderQuantity(Integer incProviderQuantity) {
		this.incProviderQuantity = incProviderQuantity;
	}

	public Integer getDecProviderQuantity() {
		return decProviderQuantity;
	}

	public void setDecProviderQuantity(Integer decProviderQuantity) {
		this.decProviderQuantity = decProviderQuantity;
	}

}
