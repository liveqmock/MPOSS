package dwz.business.task;

import dwz.business.common.CacheServiceMgr;
import dwz.framework.sys.business.BusinessFactory;

public class ColumnCacheTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Start ColumnCacheTask...");
		
		CacheServiceMgr cacheMgr = BusinessFactory.getInstance().getService("cacheServiceMgr");
		cacheMgr.cacheColumnData();
		
	}

}
