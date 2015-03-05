package dwz.business.task;

import dwz.business.common.CacheServiceMgr;
import dwz.framework.sys.business.BusinessFactory;

public class SysProductCacheTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Start SysProductCacheTask...");
		
		CacheServiceMgr cacheMgr = BusinessFactory.getInstance().getService("cacheServiceMgr");
		cacheMgr.cacheSysProductData();
		
	}

}
