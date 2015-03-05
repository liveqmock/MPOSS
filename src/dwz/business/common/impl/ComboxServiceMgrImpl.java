package dwz.business.common.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.ComboxServiceMgr;
import dwz.business.common.SessionOper;
import dwz.common.util.ParameterUtil;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.AccAccount;
import dwz.persistence.mapper.AccAccountMapper;

@Transactional(rollbackFor = Exception.class)
@Service("comboxServiceMgr")
public class ComboxServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements ComboxServiceMgr {
	
	@Autowired
	private AccAccountMapper accountMapper;

	@Override
	public Map<String, String> loadBusiType() {
		return ParameterUtil.getConstantMap("BUSI_TYPE");
	}

	@Override
	public List<String> loadAccountNo(SessionOper sessionOper,
			String accountType) {
		if("1".equals(accountType)){ //ACCOUNT_TYPE(1-现金)
			return new ArrayList<String>();
		}else{
			AccAccount po = new AccAccount();
			po.setOrgId(sessionOper.getOrgId());
			po.setAccountType(accountType);
			return accountMapper.findAccountNoForCombox(po);
		}
	}
	
	@Override
	public List<String> loadTransItem() {
		List<String> transItemList = new ArrayList<String>();
		for(Map.Entry<String, String> entry : ParameterUtil.getConstantMap("TRANS_ITEM").entrySet()){
			transItemList.add(entry.getKey());
		}
		return transItemList;
	}

	@Override
	public List<String> loadBillType(String transItem) {
		List<String> billTypeList = new ArrayList<String>();
		if("09".equals(transItem)){//TRANS_ITEM(09-货款)
			billTypeList.add("1");//BILL_TYPE(1-销售货款)
			billTypeList.add("2");//BILL_TYPE(2-采购货款)
			billTypeList.add("3");//BILL_TYPE(3-销售定金)
			billTypeList.add("4");//BILL_TYPE(4-销售退货退款)
			billTypeList.add("5");//BILL_TYPE(1-返厂回款)
		}
		return billTypeList;
	}

}
