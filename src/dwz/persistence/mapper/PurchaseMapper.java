package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.purchase.SearchPurchaseVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.PurPurchase;

@Repository
public interface PurchaseMapper extends BaseMapper<PurPurchase, Integer> {
	
	List<PurPurchase> findArrivalByPurchaseNo(SearchPurchaseVO vo);
	
	List<PurPurchase> findForArrival(SearchPurchaseVO vo);
	
	List<PurPurchase> findForDo(Map<Object, Object> paramMap);
	
	void updateForConf(PurPurchase purPurchase);
	
	int findCountByQC(SearchPurchaseVO vo);
	
	List<PurPurchase> findByQC(SearchPurchaseVO vo);
	
	int findCountBySaleNo(SearchPurchaseVO vo);
	
	List<PurPurchase> findBySaleNo(SearchPurchaseVO vo);
	
	void updateStatus(PurPurchase purPurchase);
	
	void updateSaleNos(PurPurchase purPurchase);
	
	int getPurchaseCountByProvider(int providerId);
	
	PurPurchase getPurchase(Map<Object, Object> paramMap);
	
	void updateByContinuePur(PurPurchase purPurchase);
	
}
