package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysResource;

@Repository
public interface ResourceMapper extends BaseMapper<SysResource, Integer>{
	
	List<SysResource> findForCache();
	
	List<SysResource> findResourceByRoles(Map<Object, Object> paramMap);
	
	List<SysResource> findResourceByResourceType(String resourceType);
	
}
