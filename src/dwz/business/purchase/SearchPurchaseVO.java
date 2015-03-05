package dwz.business.purchase;

import java.util.List;

import dwz.business.goods.Product;
import dwz.business.partner.Provider;
import dwz.persistence.BaseConditionVO;

public class SearchPurchaseVO extends BaseConditionVO {
	
	private Integer orgId;
	private Provider provider;
	private Product product;
	private String saleNo;
	private String status;
	private String purchaseNo;
	private List<String> statusList;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public List<String> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

}
