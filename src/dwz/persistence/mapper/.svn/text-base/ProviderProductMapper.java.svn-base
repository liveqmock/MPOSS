package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.goods.SearchProviderProductVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.ProProduct;
import dwz.persistence.beans.ProProviderProduct;

@Repository
public interface ProviderProductMapper extends BaseMapper<ProProviderProduct, Integer> {
	
	int findCountByQC(SearchProviderProductVO vo);
	
	List<ProProviderProduct> findByQC(SearchProviderProductVO vo);
	
	int findJoinCountByQC(SearchProviderProductVO vo);
	
	List<ProProviderProduct> findJoinByQC(SearchProviderProductVO vo);
	
	List<ProProviderProduct> findForRepeatCheck(int orgId);
	
	List<ProProviderProduct> findForPurchase(int providerId);
	
	int getProviderProductCount(int productId);
	
	void updateByProductUpd(ProProduct proProduct);
	
	void updatePic(ProProduct proProduct);
	
	List<ProProviderProduct> findProviderProductForPur(Map<Object, Object> paramMap);
	
}
