package dwz.business.task;

import dwz.business.common.CacheServiceMgr;
import dwz.framework.sys.business.BusinessFactory;

public class ConstantCacheTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Start ConstantCacheTask...");
		
		CacheServiceMgr cacheMgr = BusinessFactory.getInstance().getService("cacheServiceMgr");
		cacheMgr.cacheConstantData();
		
	}

}
