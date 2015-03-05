package dwz.business.partner;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ConsumerServiceMgr extends BusinessObjectServiceMgr {
	
	int searchConsumerCount(SessionOper sessionOper, SearchConsumerVO vo);
	
	List<Consumer> searchConsumer(SessionOper sessionOper, SearchConsumerVO vo);
	
	void addConsumer(Consumer consumer, SessionOper sessionOper);
	
	Consumer getConsumer(int consumerId);
	
	Consumer getConsumer(String consumerName, int orgId);
	
	void updConsumer(Consumer consumer, SessionOper sessionOper);
	
	int getSaleCountByConsumer(int consumerId);
	
	void del(int consumerId);
	
	List<Consumer> buildConsumerList(List<String[]> infoList, SessionOper sessionOper);
	
	void importData(List<Consumer> consumerList, SessionOper sessionOper);

}
