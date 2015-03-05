package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.SalDeliverDetail;

@Repository
public interface DeliverDetailMapper extends BaseMapper<SalDeliverDetail, Integer> {
	
	List<SalDeliverDetail> findDeliverDetail(int deliverId);
	
	List<SalDeliverDetail> findForOver(Map<Object, Object> paramMap);
	
	List<SalDeliverDetail> findDeliverDetailForCancel(int deliverId);
	
}
