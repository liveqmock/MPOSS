package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.sale.SearchProductVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.ProProduct;

@Repository
public interface ProductMapper extends BaseMapper<ProProduct, Integer> {
	
	List<ProProduct> findByOrg(int orgId);
	
	List<ProProduct> loadProduct(int orgId);
	
	List<String> loadProductModel(int orgId);
	
	List<ProProduct> loadProductName(int orgId);
	
	List<ProProduct> findByQC(SearchProductVO vo);
	
	int findCountByQC(SearchProductVO vo);
	
	void updatePic(ProProduct proProduct);
	
	ProProduct getProProduct(ProProduct proProduct);
	
	List<ProProduct> findJoinByQC(SearchProductVO vo);
	
	int findJoinCountByQC(SearchProductVO vo);
	
	List<String> findExistProduct(int orgId);
	
	void insertSimple(ProProduct proProduct);
	
}
