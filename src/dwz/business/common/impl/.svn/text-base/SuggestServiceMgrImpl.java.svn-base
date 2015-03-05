package dwz.business.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.account.Account;
import dwz.business.common.SessionOper;
import dwz.business.common.SuggestServiceMgr;
import dwz.business.sale.Sale;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.AccAccount;
import dwz.persistence.beans.SalSale;
import dwz.persistence.mapper.AccAccountMapper;
import dwz.persistence.mapper.SaleMapper;

@Transactional(rollbackFor = Exception.class)
@Service("suggestServiceMgr")
public class SuggestServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements SuggestServiceMgr {
	
	@Autowired
	private AccAccountMapper accountMapper;
	@Autowired
	private SaleMapper saleMapper;

	@Override
	public List<Account> suggestAccount(SessionOper sessionOper) {
		List<Account> bos = new ArrayList<Account>();
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("status", "1");
		List<AccAccount> pos = accountMapper.loadAccount(paramMap);
		for(AccAccount po : pos){
			bos.add(new Account(po));
		}
		return bos;
	}

	@Override
	public List<Sale> suggestSaleForPur(SessionOper sessionOper) {
		List<Sale> bos = new ArrayList<Sale>();
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		List<String> statusList = new ArrayList<String>();
		statusList.add("2");
		statusList.add("8");
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("statusList", statusList);
		List<SalSale> pos = saleMapper.loadSaleForPur(paramMap);
		for(SalSale po : pos){
			bos.add(new Sale(po));
		}
		return bos;
	}
	
	@Override
	public List<String> loadBillType(String priceAction) {
		List<String> billTypeList = new ArrayList<String>();
		if("1".equals(priceAction)){//PRICE_ACTION(1-收入)
			billTypeList.add("1");//BILL_TYPE(1-销售货款)
			billTypeList.add("3");//BILL_TYPE(3-销售定金)
			billTypeList.add("5");//BILL_TYPE(1-返厂回款)
		}else if("2".equals(priceAction)){//PRICE_ACTION(2-支出)
			billTypeList.add("2");//BILL_TYPE(2-采购货款)
			billTypeList.add("4");//BILL_TYPE(4-销售退货退款)
		}
		return billTypeList;
	}
	
}
