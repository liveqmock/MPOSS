package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.stock.SearchStockVO;
import dwz.business.stock.Stock;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.StoStock;

@Repository
public interface StockMapper extends BaseMapper<StoStock, Integer> {
	
	int findMergeCountByQC(SearchStockVO vo);
	
	List<StoStock> findMergeByQC(SearchStockVO vo);
	
	int findCountForTakingByQC(SearchStockVO vo);
	
	List<StoStock> findForTakingByQC(SearchStockVO vo);
	
	void updateStockByTaking(Stock stock);
	
	void insertByTaking(Stock stock);
	
	void incStock(Stock stock);
	
	void decStock(Stock stock);
	
	StoStock findOneStock(Stock stock);
	
	List<StoStock> findByProductId(Map<Object, Object> paramMap);
	
	List<StoStock> findForPur(Map<Object, Object> paramMap);
	
	StoStock getOneStock(Map<Object, Object> paramMap);
	
	int getStockCountByProvider(int providerId);
	
	List<StoStock> findByProviderProductId(int providerProductId);
	
	int getQuantityForProvProd(int providerProductId);
	
	void deleteByProvProd(int providerProductId);
	
}
