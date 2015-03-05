package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.PurArrivalDetail;

@Repository
public interface ArrivalDetailMapper extends BaseMapper<PurArrivalDetail, Integer> {
	
	List<PurArrivalDetail> findArrivalDetailByArrivalId(int arrivalId);
	
	List<PurArrivalDetail> findArrivalDetailBySaleDetailId(int saleDetailId);
	
	
}
