package dwz.business.account;

import java.util.List;
import java.util.Map;

import dwz.business.common.SessionOper;
import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface PriceServiceMgr extends BusinessObjectServiceMgr {
	
	List<Account> searchAccount(SessionOper sessionOper);
	
	Map<String,String> loadAccountType();
	
	Map<String,String> loadBank();
	
	void addAccount(Account account,SessionOper sessionOper);
	
	void disableAccount(int accountId);
	
	void enableAccount(int accountId);
	
	Account getAccount(int accountId);
	
	void addBatchTrans(AddBatchTrans addBatchTrans, SessionOper sessionOper, String transNo) throws Exception;

}
