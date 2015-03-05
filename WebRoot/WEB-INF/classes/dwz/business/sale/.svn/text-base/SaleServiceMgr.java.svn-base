package dwz.business.sale;

import java.util.List;
import java.util.Set;

import dwz.business.common.SessionOper;
import dwz.business.goods.Product;
import dwz.business.goods.ProviderProduct;
import dwz.business.partner.Consumer;
import dwz.business.partner.Provider;
import dwz.business.purchase.SearchSaleDetailVO;
import dwz.business.stock.Stock;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface SaleServiceMgr extends BusinessObjectServiceMgr {
	
	int searchProductCount(SearchProductVO vo, SessionOper sessionOper);
	
	List<Product> searchProduct(SearchProductVO vo, SessionOper sessionOper);
	
	int searchJoinProductCount(SearchProductVO vo, SessionOper sessionOper);
	
	List<Product> searchJoinProduct(SearchProductVO vo, SessionOper sessionOper);
	
	void addSale(Sale sale, SessionOper sessionOper);
	
	List<Sale> searchSaleForBak(SearchSaleVO vo, SessionOper sessionOper);
	
	List<Sale> searchSaleForDo(SessionOper sessionOper, List<String> status);
	
	Sale getSaleById(int saleId);
	
	List<SaleDetail> findSaleDetailBySaleId(int saleId);
	
	void updateSale(Sale sale, SessionOper sessionOper);
	
	List<Stock> searchProviderProduct(int productId,SessionOper sessionOper);
	
	Deliver getDeliverForBak(int saleId, String status);
	
	void saleBak(Sale sale, Deliver deliver, SessionOper sessionOper, boolean createDeliver, String deliverNo);
	
	List<Deliver> searchDeliver(SessionOper sessionOper);
	
	int searchFinishDeliverCount(SearchFinishDeliverVO vo, SessionOper sessionOper);
	
	List<Deliver> searchFinishDeliver(SearchFinishDeliverVO vo, SessionOper sessionOper);
	
	List<DeliverDetail> findDeliverDetail(int deliverId);
	
	Deliver getDeliverById(int deliverId);
	
	void doDeliver(int deliverId, int consumerId, String consumerName, SessionOper sessionOper);
	
	int searchSaleCount(SearchSaleVO vo, SessionOper sessionOper);
	
	List<Sale> searchSale(SearchSaleVO vo, SessionOper sessionOper);
	
	List<Deliver> findDeliverForShow(int saleId);
	
	void updateSaleForCustomer(Sale sale, SessionOper sessionOper);
	
	List<SaleDetail> searchSaleDetail(SearchSaleDetailVO vo, int provider, SessionOper sessionOper);
	
	List<Provider> loadProviderForBak(SessionOper sessionOper ,int productId, String standard);
	
	void forceOver(int saleId, SessionOper sessionOper);
	
	List<Integer> checkBak(Sale sale, SessionOper sessionOper);
	
	void confDeposit(int saleId);
	
	int getSaleCountByProduct(int productId);
	
	void del(int saleId, int saleDetailId);
	
	void doDeliverCancel(int deliverId, SessionOper sessionOper);
	
	void delDeliverDetail(int deliverDetailId, SessionOper sessionOper);
	
	void addSaleBack(SaleBack saleBack, SessionOper sessionOper);
	
	List<SaleBack> searchSaleBackForDo(SessionOper sessionOper, List<String> status);
	
	SaleBack getSaleBackById(int saleBackId);
	
	List<SaleBackDetail> findSaleBackDetailBySaleBackId(int saleBackId);
	
	void doDeal(SaleBack saleBack, SessionOper sessionOper);
	
	int searchSaleBackCount(SearchSaleBackVO vo, SessionOper sessionOper);
	
	List<SaleBack> searchSaleBack(SearchSaleBackVO vo, SessionOper sessionOper);
	
	Set<Integer> checkSaleImportData(List<String[]> infoList);
	
	List<SaleImport> buildSaleImportList(List<String[]> infoList, SessionOper sessionOper);
	
	void importData(List<SaleImport> saleImportList, SessionOper sessionOper);
	
	List<SaleImport> findSaleImport(SessionOper sessionOper);
	
	void delImport(SessionOper sessionOper);
	
	void addSaleByImport(Sale sale, SessionOper sessionOper);
	
	int searchPurSaleCount(SearchSaleVO vo, SessionOper sessionOper);
	
	List<Sale> searchPurSale(SearchSaleVO vo, SessionOper sessionOper);
	
	SaleDetail getSaleDetailForPur(int saleDetailId);
	
	List<ProviderProduct> findPurchasePlan(SaleDetail saleDetail, SessionOper sessionOper);
	
	List<SaleDetail> findSaleDetailForPur(int saleId);
	
}
