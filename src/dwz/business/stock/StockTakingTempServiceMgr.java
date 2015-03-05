package dwz.business.stock;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface StockTakingTempServiceMgr extends BusinessObjectServiceMgr {
	
void insertTemp(StockTakingTempVO vo, SessionOper sessionOper);
	
	List<StockTakingTemp> searchStockTakingTemp(SessionOper sessionOper);
	
	void del(int stockTakingTempId);

}
