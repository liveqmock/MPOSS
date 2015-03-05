package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.rpt.SearchPurchaseCollVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.RptPurchaseColl;

@Repository
public interface PurchaseCollMapper extends BaseMapper<RptPurchaseColl, Integer> {
	
	List<RptPurchaseColl> findByQC(SearchPurchaseCollVO vo);
	
	List<RptPurchaseColl> findDetail(Map<Object, Object> paramMap);

}