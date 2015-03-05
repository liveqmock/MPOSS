package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysRole;

@Repository
public interface RoleMapper extends BaseMapper<SysRole, Integer> {
	
	List<SysRole> findByOrg(int orgId);
	
	SysRole getByRoleName(SysRole sysRole);
	
	List<SysRole> findByOper(int operId);
	
}
