package dwz.business.purchase;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface PurchaseServiceMgr extends BusinessObjectServiceMgr {
	
	void addPurchase(Purchase purchase, SessionOper sessionOper);
	
	List<Purchase> searchPurchaseForArrival(SearchPurchaseVO vo, SessionOper sessionOper);
	
	List<Purchase> searchPurchaseForDo(SessionOper sessionOper, List<String> status);
	
	Purchase getPurchaseById(int purchaseId);
	
	List<PurchaseDetail> findPurchaseDetailByPurchaseId(int purchaseId);
	
	void updatePurchase(Purchase purchase, SessionOper sessionOper);
	
	int searchPurchaseCount(SearchPurchaseVO vo, SessionOper sessionOper);
	
	List<Purchase> searchPurchase(SearchPurchaseVO vo, SessionOper sessionOper);
	
	void addPurchaseArrival(Purchase purchase,Arrival arrival, String arrivalNo, SessionOper sessionOper);
	
	void forceOver(int purchaseId, SessionOper sessionOper);
	
	List<Arrival> searchArrival(SessionOper sessionOper);
	
	Arrival getArrivalById(int arrivalId);
	
	List<ArrivalDetail> findArrivalDetailByArrivalId(int arrivalId);
	
	void doOver(int arrival, int providerId, String providerName, SessionOper sessionOper);
	
	List<Arrival> findArrivalByPurchaseId(int purchaseId);
	
	int getUnArrivalCount(int purchaseId);
	
	int getPurDetailCountForProvProd(int providerProductId);
	
	void addSalePurchase(AddPurchaseVO addPurchaseVO, SessionOper sessionOper);
	
	
}
