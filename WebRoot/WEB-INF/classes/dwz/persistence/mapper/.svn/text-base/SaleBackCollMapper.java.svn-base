package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.rpt.SearchSaleBackCollVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.RptSaleBackColl;

@Repository
public interface SaleBackCollMapper extends BaseMapper<RptSaleBackColl, Integer> {
	
	List<RptSaleBackColl> findByQC(SearchSaleBackCollVO vo);
	
	List<RptSaleBackColl> findDetail(Map<Object, Object> paramMap);
	
}
