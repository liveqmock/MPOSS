package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import dwz.business.sale.SearchFinishDeliverVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.SalDeliver;

public interface DeliverMapper extends BaseMapper<SalDeliver, Integer> {
	
	SalDeliver getDeliverForBak(Map<Object, Object> paramMap);
	
	List<SalDeliver> findDeliverForDeliver(Map<Object, Object> paramMap);
	
	List<SalDeliver> findDeliver(Map<Object, Object> paramMap);
	
	void updateCreateTime(SalDeliver salDeliver);
	
	void cancel(SalDeliver salDeliver);
	
	void autoCancel(SalDeliver salDeliver);
	
	int findDeliverCountForBack(SearchFinishDeliverVO vo);
	
	List<SalDeliver> findDeliverForBack(SearchFinishDeliverVO vo);
	
}
