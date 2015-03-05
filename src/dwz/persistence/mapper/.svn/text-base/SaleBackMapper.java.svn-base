package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.sale.SearchSaleBackVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.SalSaleBack;

@Repository
public interface SaleBackMapper extends BaseMapper<SalSaleBack, Integer> {
	
	List<SalSaleBack> findForDo(Map<Object, Object> paramMap);
	
	int findCountByQC(SearchSaleBackVO searchSaleBackVO);
	
	List<SalSaleBack> findByQC(SearchSaleBackVO searchSaleBackVO);
	
}
