package dwz.business.system;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.business.common.ZNodes;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface RoleServiceMgr extends BusinessObjectServiceMgr {
	
	List<Role> searchRole(SessionOper sessionOper);
	
	void addRole(Role role, String resourceIds, SessionOper sessionOper);
	
	Role getRole(String roleName, int orgId);
	
	int findOperCountByRole(int roleId);
	
	void del(int roleId);
	
	Role getRole(int roleId);
	
	void updRole(Role role, String resourceIds);
	
	List<ZNodes> findZNodesOfResource();
	
	List<ZNodes> findZNodesOfResourceWithChecked(int roleId);
	
}
