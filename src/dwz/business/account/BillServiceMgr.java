package dwz.business.account;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.business.partner.SearchConsumeVO;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface BillServiceMgr extends BusinessObjectServiceMgr {
	
	List<BillBusiBO> searchSaleBillBusi(SessionOper sessionOper);
	
	List<Consume> findConsumeForSaleBill(int targetId, SessionOper sessionOper);
	
	List<Trans> findSaleHisTrans(int targetId, SessionOper sessionOper);
	
	void saleBillOver(int targetId, SessionOper sessionOper);
	
	List<BillBusiBO> searchPurchaseBillBusi(SessionOper sessionOper);
	
	List<Consume> findConsumeForPurchaseBill(int targetId, SessionOper sessionOper);
	
	List<Trans> findPurchaseHisTrans(int targetId, SessionOper sessionOper);
	
	void purchaseBillOver(int targetId, SessionOper sessionOper);
	
	int findConsumeCountForConsumer(SearchConsumeVO vo, int targetId, SessionOper sessionOper);
	
	List<Consume> findConsumeForConsumer(SearchConsumeVO vo, int targetId, SessionOper sessionOper);
	
	int findConsumeCountForProvider(SearchConsumeVO vo, int targetId, SessionOper sessionOper);
	
	List<Consume> findConsumeForProvider(SearchConsumeVO vo, int targetId, SessionOper sessionOper);
	
}
