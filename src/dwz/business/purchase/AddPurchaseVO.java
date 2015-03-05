package dwz.business.purchase;

import java.util.List;

public class AddPurchaseVO {
	
	private List<PurchaseDetail> purchaseDetailList;

	public List<PurchaseDetail> getPurchaseDetailList() {
		return purchaseDetailList;
	}

	public void setPurchaseDetailList(List<PurchaseDetail> purchaseDetailList) {
		this.purchaseDetailList = purchaseDetailList;
	}

}
