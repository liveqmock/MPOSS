package dwz.persistence.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.AccAccount;

@Repository
public interface AccAccountMapper extends BaseMapper<AccAccount, Integer> {
	
	List<AccAccount> findByOrg(int orgId);
	
	void updateStatus(AccAccount accAccount);
	
	List<String> findAccountNoForCombox(AccAccount accAccount);
	
	List<AccAccount> loadAccount(Map<Object, Object> paramMap);
	
	void inc(Map<Object, Object> paramMap);
	
	void dec(Map<Object, Object> paramMap);
	
	AccAccount getAccount(AccAccount param);
	
}
