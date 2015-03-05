package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.PurPurchaseDetail;

@Repository
public interface PurchaseDetailMapper extends BaseMapper<PurPurchaseDetail, Integer> {
	
	List<PurPurchaseDetail> findPurchaseDetailByPurchaseId(int purchaseId);
	
	void updateByArrival(PurPurchaseDetail purPurchaseDetail);
	
	PurPurchaseDetail findForUpdatePurchaseStatus(int purchaseId);
	
	int getCountForProvProd(int providerProductId);
	
	List<PurPurchaseDetail> findForDecSalePurchase(int purchaseId);
	
	PurPurchaseDetail getExistPurchaseDetail(Map<Object, Object> paramMap);
	
	void incPurchaseQuantity(PurPurchaseDetail purPurchaseDetail);
	
}
