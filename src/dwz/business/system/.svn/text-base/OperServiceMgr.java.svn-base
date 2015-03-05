package dwz.business.system;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.business.common.ZNodes;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface OperServiceMgr extends BusinessObjectServiceMgr {
	
	boolean checkPasswd(Oper oper);
	
	void updPwd(Oper oper);
	
	List<Oper> searchOper(SessionOper sessionOper);
	
	void addOper(Oper oper, String roleIds, SessionOper sessionOper);
	
	Oper getOper(String userName, String realName, int orgId);
	
	Oper getOper(int operId);
	
	void updOper(Oper oper, String roleIds);
	
	List<Role> findRoleByOrg(int orgId);
	
	public void del(int operId);
	
	void disable(int operId);
	
	void enable(int operId);
	
	List<ZNodes> findZNodesOfRole(SessionOper sessionOper);
	
	List<ZNodes> findZNodesOfRoleWithChecked(SessionOper sessionOper, int operId);
	
	void upd(Oper oper);
}
