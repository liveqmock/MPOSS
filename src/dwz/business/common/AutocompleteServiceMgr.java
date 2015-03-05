package dwz.business.common;

import java.util.List;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.persistence.beans.ParConsumer;
import dwz.persistence.beans.ParProvider;
import dwz.persistence.beans.ProProduct;

public interface AutocompleteServiceMgr extends BusinessObjectServiceMgr {
	
    List<ParConsumer> loadConsumer(SessionOper sessionOper);
    
    List<String> loadProductModel(SessionOper sessionOper);
    
    List<ProProduct> loadProductName(SessionOper sessionOper);
    
    List<ParProvider> loadProvider(SessionOper sessionOper);
    
    List<ProProduct> loadProduct(SessionOper sessionOper);
	
}
