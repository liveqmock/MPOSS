package dwz.business.partner;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ProviderServiceMgr extends BusinessObjectServiceMgr {
	
	int searchProviderCount(SessionOper sessionOper, SearchProviderVO vo);
	
	List<Provider> searchProvider(SessionOper sessionOper, SearchProviderVO vo);
	
	void addProvider(Provider provider, SessionOper sessionOper);
	
	Provider getProvider(int providerId);
	
	Provider getProvider(String providerName, int orgId);
	
	void updProvider(Provider provider, SessionOper sessionOper);
	
	int getPurchaseCountByProvider(int providerId);
	
	int getStockCountByProvider(int providerId);
	
	void del(int providerId);
	
	List<Provider> buildProviderList(List<String[]> infoList, SessionOper sessionOper);
	
	void importData(List<Provider> consumerList, SessionOper sessionOper);

}
