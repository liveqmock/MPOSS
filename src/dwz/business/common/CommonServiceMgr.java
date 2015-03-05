package dwz.business.common;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.persistence.beans.SysLog;

public interface CommonServiceMgr extends BusinessObjectServiceMgr {
	
	String getPaperNo(int orgId, String paperType);
	
	void insertSysLog(SysLog sysLog);

}
