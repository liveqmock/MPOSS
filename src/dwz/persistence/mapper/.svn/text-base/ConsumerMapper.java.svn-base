package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.partner.SearchConsumerVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.ParConsumer;

@Repository
public interface ConsumerMapper extends BaseMapper<ParConsumer, Integer> {
	
	int findCountByQC(SearchConsumerVO vo);
	
	int findCountByOrder(SearchConsumerVO vo);
	
	List<ParConsumer> findByQC(SearchConsumerVO vo);
	
	List<ParConsumer> findByOrder(SearchConsumerVO vo);
	
	List<ParConsumer> loadConsumer(int orgId);
	
	ParConsumer getByConsumerName(ParConsumer parConsumer);
	
	void updateBillFinishTime(Map<Object, Object> paramMap);
	
	List<String> loadConsumerName(int orgId);
	
	List<String> findExistConsumer(int orgId);
	
}
