package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.business.system.Oper;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysOper;

@Repository
public interface OperMapper extends BaseMapper<SysOper, Integer>{
	
	void updatePwd(Oper oper);
	
	List<SysOper> findForCache();
	
	List<SysOper> findByOrg(int orgId);
	
	SysOper getByUserNameOrRealName(SysOper sysOper);
	
	void updateStatus(SysOper sysOper);
	
	SysOper findOperByLogin(SysOper sysOper);
	
}
