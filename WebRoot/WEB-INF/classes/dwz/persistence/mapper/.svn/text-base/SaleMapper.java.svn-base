package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.sale.SearchSaleVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.SalSale;

@Repository
public interface SaleMapper extends BaseMapper<SalSale, Integer> {
	
	List<SalSale> findForDo(Map<Object, Object> paramMap);
	
	List<SalSale> findForBak(SearchSaleVO vo);
	
	List<SalSale> findBakBySaleNo(SearchSaleVO vo);
	
	List<SalSale> findBakByPurchaseNo(SearchSaleVO vo);
	
	void updateForConf(SalSale salSale);
	
	void finishBak(Map<Object, Object> paramMap);
	
	void unfinishBak(Map<Object, Object> paramMap);
	
	void updateByDeliver(SalSale salSale);
	
	int findCountByQC(SearchSaleVO vo);
	
	int findCountBySaleNo(SearchSaleVO vo);
	
	List<SalSale> findByQC(SearchSaleVO vo);
	
	List<SalSale> findBySaleNo(SearchSaleVO vo);
	
	void updateForCustomer(SalSale salSale);
	
	List<SalSale> loadSaleForPur(Map<Object, Object> paramMap);
	
	void forceOver(Map<Object, Object> paramMap);
	
	void updateStatus(SalSale salSale);
	
	void incPurchaseQuantity(SalSale salSale);
	
	void decPurchaseQuantity(SalSale salSale);
	
	int getSaleCountByConsumer(int consumerId);
	
	int getSaleCountByProduct(int productId);
	
	void updateByDel(SalSale salSale);
	
	void countPurchaseQuantity(SalSale salSale);
	
	int findCountByQCForPur(SearchSaleVO vo);
	
	int findCountBySaleNoForPur(SearchSaleVO vo);
	
	List<SalSale> findByQCForPur(SearchSaleVO vo);
	
	List<SalSale> findBySaleNoForPur(SearchSaleVO vo);
}
