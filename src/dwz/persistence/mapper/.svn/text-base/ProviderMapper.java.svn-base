package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.partner.SearchProviderVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.ParProvider;

@Repository
public interface ProviderMapper extends BaseMapper<ParProvider, Integer> {
	
	int findCountByQC(SearchProviderVO vo);
	
	int findCountByOrder(SearchProviderVO vo);
	
	List<ParProvider> findByQC(SearchProviderVO vo);
	
	List<ParProvider> findByOrder(SearchProviderVO vo);
	
	List<ParProvider> loadProvider(int orgId);
	
	List<ParProvider> loadUsableProvider(int orgId);
	
	ParProvider getByProviderName(ParProvider parProvider);
	
	void updateBillFinishTime(Map<Object, Object> paramMap);
	
	List<ParProvider> findProviderForBak(Map<Object, Object> paramMap);
	
	List<String> loadProviderName(int orgId);
	
	List<String> findExistProvider(int orgId);
	
}
