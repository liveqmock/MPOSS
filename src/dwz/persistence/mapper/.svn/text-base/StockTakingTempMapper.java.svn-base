package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.StoStockTakingTemp;

@Repository
public interface StockTakingTempMapper extends BaseMapper<StoStockTakingTemp, Integer> {
	
	List<Integer> findProviderProductId(int orgId);
	
	List<StoStockTakingTemp> findByOrg(int orgId);
	
	void deleteByOrg(int orgId);

}
