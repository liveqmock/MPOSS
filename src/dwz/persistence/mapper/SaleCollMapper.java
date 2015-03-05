package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.rpt.SearchSaleCollVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.RptSaleColl;

@Repository
public interface SaleCollMapper extends BaseMapper<RptSaleColl, Integer> {
	
	List<RptSaleColl> findByQC(SearchSaleCollVO vo);
	
	List<RptSaleColl> findDetail(Map<Object, Object> paramMap);

}
