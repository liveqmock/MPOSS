package dwz.business.goods;

import java.util.List;

import dwz.business.common.SessionOper;
import dwz.business.sale.SearchProductVO;
import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.persistence.beans.ProProduct;

public interface ProductServiceMgr extends BusinessObjectServiceMgr {
	
	int searchProductCount(SearchProductVO vo, SessionOper sessionOper);
	
	List<Product> searchProduct(SearchProductVO vo, SessionOper sessionOper);
	
	void addProduct(Product product, SessionOper sessionOper);
	
	void updPic(int productId, String pic);
	
	Product getProduct(int productId);
	
	void upd(Product product, SessionOper sessionOper);
	
	ProProduct getProProduct(ProProduct proProduct, SessionOper sessionOper);	
	
	void del(int productId);
	
	List<Product> buildProductList(List<String[]> infoList, SessionOper sessionOper);
	
	List<String> findExistProduct(int orgId);
	
	void importData(List<Product> productList, SessionOper sessionOper);
	
}
