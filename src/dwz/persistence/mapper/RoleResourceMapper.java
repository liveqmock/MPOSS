package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysRoleResource;

@Repository
public interface RoleResourceMapper extends BaseMapper<SysRoleResource, Integer> {
	
	void deleteByRole(int roleId);
	
	List<SysRoleResource> findResourceByRole(int roleId);
	
	void deleteByRoleAndResource(SysRoleResource sysRoleResource);
	
	List<SysRoleResource> findCheckedResourceByRole(int roleId);
	
}
