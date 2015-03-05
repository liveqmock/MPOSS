package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.PurArrival;

@Repository
public interface ArrivalMapper extends BaseMapper<PurArrival, Integer> {
	
	List<PurArrival> findArrivalForConf(Map<Object, Object> paramMap);
	
	List<PurArrival> findArrivalByPurchaseId(int purchaseId);
	
	int getUnArrivalCount(Map<Object, Object> paramMap);
	
	
}
