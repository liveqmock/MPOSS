package dwz.business.stock;

import dwz.business.goods.Product;
import dwz.business.partner.Provider;
import dwz.persistence.BaseConditionVO;

public class SearchStockChangeVO extends BaseConditionVO {
	
	private Integer orgId;
	private Provider provider;
	private Product product;
	private String changeAction;
	
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
	public String getChangeAction() {
		return changeAction;
	}
	public void setChangeAction(String changeAction) {
		this.changeAction = changeAction;
	}

}
