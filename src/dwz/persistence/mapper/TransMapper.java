package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import dwz.business.account.SearchTransVO;
import dwz.business.rpt.SearchCostCollVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.AccTrans;

public interface TransMapper extends BaseMapper<AccTrans, Integer> {
	
	int findCountByQC(SearchTransVO req);
	
	List<AccTrans> findByQC(SearchTransVO req);
	
	List<AccTrans> findCostColl(SearchCostCollVO vo);
	
	List<AccTrans> findCostCollDetail(Map<Object, Object> paramMap);
	
	List<AccTrans> findForSaleBill(Map<Object, Object> paramMap);
	
	List<AccTrans> findForPurchaseBill(Map<Object, Object> paramMap);
	
	List<AccTrans> findHisTrans(Map<Object, Object> paramMap);
	
	Integer getTotalPayPrice(Map<Object, Object> paramMap);

}
