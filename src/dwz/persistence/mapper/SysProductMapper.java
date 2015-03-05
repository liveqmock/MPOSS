package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysProduct;

@Repository
public interface SysProductMapper extends BaseMapper<SysProduct, Integer>{
	
	List<SysProduct> findForCache();
	
}
