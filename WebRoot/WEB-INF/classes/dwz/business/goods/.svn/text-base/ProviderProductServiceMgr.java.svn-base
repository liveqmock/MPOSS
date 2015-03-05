package dwz.business.goods;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ProviderProductServiceMgr extends BusinessObjectServiceMgr {
	
	int searchProviderProductCount(SearchProviderProductVO vo, SessionOper sessionOper);
	
	List<ProviderProduct> searchProviderProduct(SearchProviderProductVO vo, SessionOper sessionOper);
	
	int searchJoinProviderProductCount(SearchProviderProductVO vo, SessionOper sessionOper);
	
	List<ProviderProduct> searchJoinProviderProduct(SearchProviderProductVO vo, SessionOper sessionOper);
	
	void addProviderProduct(AddProviderProductVO vo, SessionOper sessionOper);
	
	List<String> searchProviderProductForRepeatCheck(SessionOper sessionOper);
	
	ProviderProduct getProviderProduct(int providerProductId);
	
	void upd(ProviderProduct providerProduct, SessionOper sessionOper);
	
	int getProviderProductCount(int productId);
	
	void del(int providerProductId);

}
