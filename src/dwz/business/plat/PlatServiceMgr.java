package dwz.business.plat;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface PlatServiceMgr extends BusinessObjectServiceMgr {
	
	List<Pay> searchPay(SessionOper sessionOper);
	
	void insertAssess(Assess assess, SessionOper sessionOper);
	
	void insertSuggest(Suggest suggest, SessionOper sessionOper);

}
