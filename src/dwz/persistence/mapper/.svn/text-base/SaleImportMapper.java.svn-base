package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.business.common.SessionOper;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.SalSaleImport;

@Repository
public interface SaleImportMapper extends BaseMapper<SalSaleImport, Integer> {
	
	List<SalSaleImport> findSaleImport(SessionOper sessionOper);
	
	void deleteByOper(SessionOper sessionOper);

}
