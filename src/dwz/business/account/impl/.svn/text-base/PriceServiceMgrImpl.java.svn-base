package dwz.business.account.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.SimpleDateFormat;

import dwz.business.account.Account;
import dwz.business.account.AddBatchTrans;
import dwz.business.account.PriceServiceMgr;
import dwz.business.account.Trans;
import dwz.business.common.SessionOper;
import dwz.common.util.ParameterUtil;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.AccAccount;
import dwz.persistence.beans.AccTrans;
import dwz.persistence.beans.ParConsumer;
import dwz.persistence.beans.ParProvider;
import dwz.persistence.mapper.AccAccountMapper;
import dwz.persistence.mapper.ConsumeMapper;
import dwz.persistence.mapper.ConsumerMapper;
import dwz.persistence.mapper.ProviderMapper;
import dwz.persistence.mapper.TransMapper;

@Transactional(rollbackFor = Exception.class)
@Service("accountPriceServiceMgr")
public class PriceServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements PriceServiceMgr {
	
	@Autowired
	private AccAccountMapper accountMapper;
	@Autowired
	private TransMapper transMapper;
	@Autowired
	private ConsumerMapper consumerMapper;
	@Autowired
	private ConsumeMapper consumeMapper;
	@Autowired
	private ProviderMapper providerMapper;

	public List<Account> searchAccount(SessionOper sessionOper) {
		
		List<Account> bos = new ArrayList<Account>();
		List<AccAccount> pos = accountMapper.findByOrg(sessionOper.getOrgId());
		for(AccAccount po : pos){
			bos.add(new Account(po));
		}
		return bos;
	}

	public Map<String, String> loadAccountType() {
		return ParameterUtil.getConstantMap("ACCOUNT_TYPE");
	}

	public Map<String, String> loadBank() {
		return ParameterUtil.getColumnMapByColumnDef("ACC_BANK.BANK_NAME");
	}
	
	public void addAccount(Account account, SessionOper sessionOper) {
		AccAccount po = account.getAccAccount();
		Integer price = Integer.parseInt(ParameterUtil.fromY2F(account.getInputPrice()));
		po.setPrice(price);
		po.setOrgId(sessionOper.getOrgId());
		po.setStatus("1"); //ACCOUNT_STATUS(1-可用)
		accountMapper.insert(po);
	}

	public void disableAccount(int accountId) {
		AccAccount po = new AccAccount();
		po.setAccountId(accountId);
		po.setStatus("0");//ACCOUNT_STATUS(0-停用)
		accountMapper.updateStatus(po);
	}
	
	public void enableAccount(int accountId) {
		AccAccount po = new AccAccount();
		po.setAccountId(accountId);
		po.setStatus("1");//ACCOUNT_STATUS(0-启用)
		accountMapper.updateStatus(po);
	}

	public Account getAccount(int accountId) {
		AccAccount accAccount = accountMapper.load(accountId);
		return new Account(accAccount);
	}
	
	public void updateConsumerBillFinishTime(List<Integer> consumerIdList, SessionOper sessionOper){
		for(Integer consumerId : consumerIdList){
			ParConsumer parConsumer = consumerMapper.load(consumerId);
			
			Map<Object, Object> paramMap1 = new HashMap<Object, Object>();
			List<String> busiTypeList = new ArrayList<String>();
			busiTypeList.add("05");//BUSI_TYPE(05-装箱单发货)
			busiTypeList.add("15");//BUSI_TYPE(15-销售退货)
			paramMap1.put("orgId", sessionOper.getOrgId());
			paramMap1.put("targetId", consumerId);
			paramMap1.put("busiTypeList", busiTypeList);
			paramMap1.put("billFinishTime", parConsumer.getBillFinishTime());
			paramMap1.put("validFlag", "1");
			
			int totalBusiPrice = consumeMapper.getTotalBusiPrice(paramMap1);
			
			Map<Object, Object> paramMap2 = new HashMap<Object, Object>();
			List<String> billTypeList = new ArrayList<String>();
			billTypeList.add("1");//BILL_TYPE(1-销售收款)
			billTypeList.add("3");//BILL_TYPE(3-销售定金)
			billTypeList.add("4");//BILL_TYPE(4-销售退货款)
			paramMap2.put("orgId", sessionOper.getOrgId());
			paramMap2.put("targetId", consumerId);
			paramMap2.put("billTypeList", billTypeList);
			paramMap2.put("billFinishTime", parConsumer.getBillFinishTime());
			int totalPayPrice = transMapper.getTotalPayPrice(paramMap2);
			
			//销售占主导，并且已经收款完毕
			//退货占主导，并且已经返款完毕
			if((totalBusiPrice >= 0 && totalPayPrice >= totalBusiPrice) || (totalBusiPrice < 0 && totalPayPrice <= totalBusiPrice)){
				Map<Object, Object> paramMap3 = new HashMap<Object, Object>();
				paramMap3.put("consumerId", parConsumer.getConsumerId());
				paramMap3.put("billFinishTime", new Date());
				consumerMapper.updateBillFinishTime(paramMap3);
			}
		}
	}
	
	public void updateProviderBillFinishTime(List<Integer> providerIdList, SessionOper sessionOper){
		for(Integer providerId : providerIdList){
			ParProvider parProvider = providerMapper.load(providerId);
			
			Map<Object, Object> paramMap1 = new HashMap<Object, Object>();
			List<String> busiTypeList = new ArrayList<String>();
			busiTypeList.add("03");//BUSI_TYPE(03-采购到货)
			busiTypeList.add("16");//BUSI_TYPE(16-返厂)
			paramMap1.put("orgId", sessionOper.getOrgId());
			paramMap1.put("targetId", providerId);
			paramMap1.put("busiTypeList", busiTypeList);
			paramMap1.put("billFinishTime", parProvider.getBillFinishTime());
			paramMap1.put("validFlag", "1");
			
			int totalBusiPrice = consumeMapper.getTotalBusiPrice(paramMap1);
			
			Map<Object, Object> paramMap2 = new HashMap<Object, Object>();
			List<String> billTypeList = new ArrayList<String>();
			billTypeList.add("2");//BILL_TYPE(2-采购付款)
			billTypeList.add("5");//BILL_TYPE(5-返厂回款)
			paramMap2.put("orgId", sessionOper.getOrgId());
			paramMap2.put("targetId", providerId);
			paramMap2.put("billTypeList", billTypeList);
			paramMap2.put("billFinishTime", parProvider.getBillFinishTime());
			int totalPayPrice = transMapper.getTotalPayPrice(paramMap2);
			
			//采购占主导，并且已经付款完毕
			//退货占主导，并且已经回款完毕
			if((totalBusiPrice < 0 && totalPayPrice <= totalBusiPrice) || (totalBusiPrice >= 0 && totalPayPrice >= totalBusiPrice)){
				Map<Object, Object> paramMap3 = new HashMap<Object, Object>();
				paramMap3.put("providerId", parProvider.getProviderId());
				paramMap3.put("billFinishTime", new Date());
				providerMapper.updateBillFinishTime(paramMap3);
			}
		}
	}
	
	//1.修改账户资金ACC_ACCTION
	//2.记录交易日志ACC_TRANS
	//3.货款类添加结账记录ACC_BILL
	//4.货款类识别是否对账完毕
	@Override
	public void addBatchTrans(AddBatchTrans addBatchTrans,
			SessionOper sessionOper, String transNo) throws Exception{
		
		Date time = new Date();
		
		List<Integer> consumerIdList = new ArrayList<Integer>();
		List<Integer> providerIdList = new ArrayList<Integer>();
		
		for(Trans trans : addBatchTrans.getTransList()){
			if(trans == null) continue;
			if(trans.getPriceAction()==null) continue;
			
			AccAccount param = new AccAccount();
			param.setOrgId(sessionOper.getOrgId());
			param.setAccountType(trans.getAccountType());
			param.setAccountNo(trans.getAccountNo());
			AccAccount accAccount = accountMapper.getAccount(param);
			int beforePrice = accAccount.getPrice();
			int afterPrice = 0;
			
			Map<Object, Object> paramMap = new HashMap<Object, Object>();
			paramMap.put("accountId", accAccount.getAccountId());
			Integer transPrice = Integer.parseInt(ParameterUtil.fromY2F(trans.getInputTransPrice()));
			if("1".equals(trans.getPriceAction())){//PRICE_ACTION(1-收入)
				paramMap.put("incPrice", transPrice);
				accountMapper.inc(paramMap);
				afterPrice = beforePrice + transPrice;
			}else{
				paramMap.put("decPrice", transPrice);
				accountMapper.dec(paramMap);
				afterPrice = beforePrice - transPrice;
			}
			
			AccTrans traTrans = trans.getTraTrans();
			traTrans.setTransNo(transNo);
			traTrans.setOrgId(sessionOper.getOrgId());
			traTrans.setTargetId(traTrans.getTargetId());
			traTrans.setTargetName(traTrans.getTargetName());
			traTrans.setAccountId(accAccount.getAccountId());
			traTrans.setBankId(accAccount.getBankId());
			traTrans.setAccountName(accAccount.getAccountName());
			traTrans.setTransItem(trans.getTransItem());
			Date transTime = new SimpleDateFormat("yyyy-MM-dd").parse(trans.getTransDate());
			traTrans.setTransTime(transTime);
			if("1".equals(trans.getPriceAction())){//PRICE_ACTION(1-收入)
				traTrans.setTransPrice(transPrice);
			}else{
				traTrans.setTransPrice(0-transPrice);
			}
			traTrans.setAfterPrice(afterPrice);
			traTrans.setTransMemo(trans.getTransMemo());
			traTrans.setRegOperId(sessionOper.getOperId());
			traTrans.setRegTime(time);
			transMapper.insert(traTrans);
			
			if("09".equals(traTrans.getTransItem())){//货款类收支
				
				if("1".equals(traTrans.getBillType()) || "3".equals(traTrans.getBillType()) || "4".equals(traTrans.getBillType())){//BILL_TYPE(1-销售货款,3-销售定金,4-销售退货退款)
					consumerIdList.add(traTrans.getTargetId());
				}else{//BILL_TYPE(2-采购货款,5-返厂回款)
					providerIdList.add(traTrans.getTargetId());
				}
			}
		}
		
		updateConsumerBillFinishTime(consumerIdList, sessionOper);
		updateProviderBillFinishTime(providerIdList, sessionOper);
		
	}

}
