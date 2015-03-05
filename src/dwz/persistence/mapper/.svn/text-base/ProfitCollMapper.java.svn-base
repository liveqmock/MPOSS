package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.rpt.SearchProfitCollVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.RptProfitColl;

@Repository
public interface ProfitCollMapper extends BaseMapper<RptProfitColl, Integer> {
	
	List<RptProfitColl> findByQC(SearchProfitCollVO vo);
	
	List<RptProfitColl> findDetail(Map<Object, Object> paramMap);

}
