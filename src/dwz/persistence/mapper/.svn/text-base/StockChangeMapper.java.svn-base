package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.business.stock.SearchStockChangeVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.StoStockChange;

@Repository
public interface StockChangeMapper extends BaseMapper<StoStockChange, Integer> {
	
	int findCountByQC(SearchStockChangeVO vo);
	
	List<StoStockChange> findByQC(SearchStockChangeVO vo);
	
}
