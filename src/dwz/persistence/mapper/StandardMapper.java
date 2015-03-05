package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.goods.SearchStandardVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.ProStandard;

@Repository
public interface StandardMapper extends BaseMapper<ProStandard, Integer> {
	
	int findCountByQC(SearchStandardVO vo);
	
	List<ProStandard> findByQC(SearchStandardVO vo);
	
	ProStandard getStandardForCheck(Map<Object, Object> paramMap);
	
	ProStandard getProStandard(ProStandard proStandard);
	
}
