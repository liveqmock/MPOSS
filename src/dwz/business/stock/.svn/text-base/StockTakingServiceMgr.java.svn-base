package dwz.business.stock;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface StockTakingServiceMgr extends BusinessObjectServiceMgr {
	
	int searchStockTakingCount(SearchStockTakingVO vo, SessionOper sessionOper);
	
	List<StockTaking> searchStockTaking(SearchStockTakingVO vo, SessionOper sessionOper);
	
	List<StockTakingDetail> searchStockTakingDetailByStockTakingId(int stockTakingId);
	
	List<StockTaking> searchStockTakingForConf(SessionOper sessionOper);
	
	void doConf(StockTaking stockTaking, SessionOper sessionOper);
	
	StockTaking getStockTakingById(int stockTakingId);
	
	void insert(StockTaking stockTaking, SessionOper sessionOper);
	
}
