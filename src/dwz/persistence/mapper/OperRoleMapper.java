package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysOperRole;

@Repository
public interface OperRoleMapper extends BaseMapper<SysOperRole, Integer> {
	
	int findCountByRole(int roleId);
	
	void deleteByOper(int operId);
	
	List<SysOperRole> findRoleByOper(int operId);
	
	void deleteByOperAndRole(SysOperRole sysOperRole);
	
	List<SysOperRole> findCheckedRoleByOper(int operId);
	
}
