package dwz.business.stock;

import dwz.business.goods.Product;
import dwz.business.partner.Provider;
import dwz.persistence.BaseConditionVO;

public class SearchStockVO extends BaseConditionVO {
	
	private Integer orgId;
	private Product product;
	private Provider provider;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

}
