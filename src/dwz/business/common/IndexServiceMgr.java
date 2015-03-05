package dwz.business.common;

import java.util.List;

import dwz.business.system.Oper;
import dwz.business.system.Org;
import dwz.business.system.Resource;
import dwz.business.system.Role;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface IndexServiceMgr extends BusinessObjectServiceMgr {
	
	Oper getOperByLogin(Oper oper);
	
	Org getOrg(int orgId);
	
	List<Resource> findResourceByOperId(int operId);
	
	List<Role> findRoleByOperId(int operId);

}
