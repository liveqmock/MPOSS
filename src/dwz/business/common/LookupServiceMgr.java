package dwz.business.common;

import java.util.List;

import dwz.business.goods.Product;
import dwz.business.partner.Provider;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface LookupServiceMgr extends BusinessObjectServiceMgr {
	
	List<Product> lookupProduct(SessionOper sessionOper);
	
	List<Provider> lookupProvider(SessionOper sessionOper);

}
