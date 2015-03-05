package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.StoStockTakingDetail;

@Repository
public interface StockTakingDetailMapper extends BaseMapper<StoStockTakingDetail, Integer> {
	
	List<StoStockTakingDetail> findByStockTakingIdForShow(int stockTakingId);
	
	List<StoStockTakingDetail> findByStockTakingId(int stockTakingId);
	
}
