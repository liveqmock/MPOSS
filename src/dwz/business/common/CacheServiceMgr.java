package dwz.business.common;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface CacheServiceMgr extends BusinessObjectServiceMgr {
	
	void cacheColumnData();
	
	void cacheConstantData();
	
	void cacheSysProductData();

}
