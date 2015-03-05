package dwz.business.purchase;

import dwz.business.sale.Sale;
import dwz.persistence.BaseConditionVO;

public class SearchSaleDetailVO extends BaseConditionVO {
	
	private Sale sale;

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

}
