package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.sale.SaleDetail;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.SalDeliverDetail;
import dwz.persistence.beans.SalSaleDetail;

@Repository
public interface SaleDetailMapper extends BaseMapper<SalSaleDetail, Integer> {
	
	List<SalSaleDetail> findSaleForPurchase(Map<Object, Object> paramMap);
	
	void decRemainBakQuantityOfSaleDetail(SaleDetail saleDetail);
	
	void incRemainBakQuantityOfSaleDetail(SaleDetail saleDetail);
	
	List<SalSaleDetail> findSaleDetailBySaleId(int saleId);
	
	void decRemainBakQuantity(SalDeliverDetail deliverDetail);
	
	void incRemainBakQuantity(SalDeliverDetail deliverDetail);
	
	void updateByDeliver(SalSaleDetail salSaleDetail);
	
	SalSaleDetail findForUpdateSaleStatus(int saleId);
	
	void updateForCustomer(SalSaleDetail salSaleDetail);
	
	SalSaleDetail getColumnSum(int saleId);
	
	List<SalSaleDetail> findSaleDetailBySaleNo(Map<Object, Object> paramMap);
	
	void incPurchaseQuantity(SalSaleDetail salSaleDetail);
	
	void decPurchaseQuantity(SalSaleDetail salSaleDetail);
	
	SalSaleDetail getSaleDetailForPur(int saleDetailId);
	
	void updateArrivalQuantity(Map<Object, Object> paramMap);

}
