package dwz.business.goods;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ProductStandardServiceMgr extends BusinessObjectServiceMgr {
	
	int searchProductStandardCount(SearchStandardVO vo, SessionOper sessionOper);
	
	List<Standard> searchProductStandard(SearchStandardVO vo, SessionOper sessionOper);
	
	List<Integer> checkStandard(AddStandard addStandard);
	
	void addStandard(AddStandard addStandard);
	
	void del(int standardId);
	
}
