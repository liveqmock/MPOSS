package dwz.business.stock;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface StockServiceMgr extends BusinessObjectServiceMgr {
	
	int searchMergeStockCount(SearchStockVO vo, SessionOper sessionOper);
	
	List<Stock> searchMergeStock(SearchStockVO vo, SessionOper sessionOper);
	
	int searchStockCountForTaking(SearchStockVO vo, SessionOper sessionOper);
	
	List<Stock> searchStockForTaking(SearchStockVO vo, SessionOper sessionOper);
	
	List<StockLock> searchStockLock(int providerProductId);
	
	int searchStockChangeCount(SearchStockChangeVO vo, SessionOper sessionOper);
	
	List<StockChange> searchStockChange(SearchStockChangeVO vo, SessionOper sessionOper);
	
	List<Stock> searchStock(int providerProductId);
	
	int getQuantityForProvProd(int providerProductId);
	
	
}
