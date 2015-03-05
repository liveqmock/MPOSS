package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.business.stock.SearchStockTakingVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.StoStockTaking;

@Repository
public interface StockTakingMapper extends BaseMapper<StoStockTaking, Integer> {
	
	int findCountByQC(SearchStockTakingVO vo);
	
	List<StoStockTaking> findByQC(SearchStockTakingVO vo);
	
	int findCountByNo(SearchStockTakingVO vo);
	
	List<StoStockTaking> findByNo(SearchStockTakingVO vo);
	
	List<StoStockTaking> findForConf(StoStockTaking stoStockTaking);
	
}
