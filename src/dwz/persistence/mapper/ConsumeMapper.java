package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.business.partner.SearchConsumeVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.BalConsume;

@Repository
public interface ConsumeMapper extends BaseMapper<BalConsume, Integer> {
	
	List<BalConsume> findForSaleBill(Map<Object, Object> paramMap);
	
	List<BalConsume> findDetailForBill(Map<Object, Object> paramMap);
	
	Integer getTotalBusiPrice(Map<Object, Object> paramMap);
	
	List<BalConsume> findForPurchaseBill(Map<Object, Object> paramMap);
	
	List<BalConsume> findDetailForPartner(SearchConsumeVO vo);
	
	int findDetailCountForPartner(SearchConsumeVO vo);
	
}
