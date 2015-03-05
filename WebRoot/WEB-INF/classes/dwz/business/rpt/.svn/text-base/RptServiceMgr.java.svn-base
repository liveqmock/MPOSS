package dwz.business.rpt;

import java.util.List;

import dwz.business.account.Trans;
import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface RptServiceMgr extends BusinessObjectServiceMgr {
	
	List<SaleColl> searchSaleColl(SearchSaleCollVO vo, SessionOper sessionOper);
	
	List<SaleColl> searchSaleCollDetail(int orgId, String transDate, int consumerId);
	
	List<PurchaseColl> searchPurchaseColl(SearchPurchaseCollVO vo, SessionOper sessionOper);
	
	List<PurchaseColl> searchPurchaseCollDetail(int orgId, String transDate, int providerId);
	
	List<Trans> searchCostColl(SearchCostCollVO vo, SessionOper sessionOper);
	
	List<Trans> searchCostCollDetail(int orgId, String transDate, String transItem, String transDire);
	
	List<ProfitColl> searchProfitColl(SearchProfitCollVO vo, SessionOper sessionOper);
	
	List<ProfitColl> searchProfitCollDetail(int orgId, String transDate, int consumerId);
	
	List<SaleBackColl> searchSaleBackColl(SearchSaleBackCollVO vo, SessionOper sessionOper);
	
	List<SaleBackColl> searchSaleBackCollDetail(int orgId, String transDate, int consumerId);

}
