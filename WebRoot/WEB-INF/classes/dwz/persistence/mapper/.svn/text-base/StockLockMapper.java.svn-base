package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.StoStockLock;

@Repository
public interface StockLockMapper extends BaseMapper<StoStockLock, Integer> {
	
	List<StoStockLock> findByProviderProductId(int providerProductId);
	
	void delete(StoStockLock stoStockLock);
	
	StoStockLock getByArrivalDetail(Map<Object, Object> paramMap);
	
	void deleteByPK(int stockLockId);
	
    void updateLockQuantity(Map<Object, Object> paramMap);
	
}
