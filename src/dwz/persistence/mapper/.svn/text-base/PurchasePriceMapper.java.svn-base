package dwz.persistence.mapper;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.PurPurchasePrice;

@Repository
public interface PurchasePriceMapper extends
		BaseMapper<PurPurchasePrice, Integer> {
	
	void deleteByProvProd(int providerProductId);
	
	void insertOrUpdatePrice(PurPurchasePrice purPurchasePrice);

}
