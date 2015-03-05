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

import dwz.business.account.BillBusiBO;
import dwz.business.account.BillServiceMgr;
import dwz.business.account.Consume;
import dwz.business.account.Trans;
import dwz.business.common.SessionOper;
import dwz.business.partner.SearchConsumeVO;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.AccTrans;
import dwz.persistence.beans.BalConsume;
import dwz.persistence.beans.ParConsumer;
import dwz.persistence.beans.ParProvider;
import dwz.persistence.mapper.ConsumeMapper;
import dwz.persistence.mapper.ConsumerMapper;
import dwz.persistence.mapper.ProviderMapper;
import dwz.persistence.mapper.TransMapper;

@Transactional(rollbackFor = Exception.class)
@Service("billServiceMgr")
public class BillServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements BillServiceMgr {
	
	@Autowired
	private ConsumeMapper consumeMapper;
	@Autowired
	private ConsumerMapper consumerMapper;
	@Autowired
	private ProviderMapper providerMapper;
	@Autowired
	private TransMapper transMapper;

	@Override
	public List<BillBusiBO> searchSaleBillBusi(SessionOper sessionOper) {
		
		List<BillBusiBO> billBusiBOList = new ArrayList<BillBusiBO>();
		
		Map<Object, Object> paramMap1 = new HashMap<Object, Object>();
		List<String> busiTypeList = new ArrayList<String>();
		busiTypeList.add("05");//BUSI_TYPE(05-装箱单发货)
		busiTypeList.add("15");//BUSI_TYPE(15-销售退货)
		paramMap1.put("orgId", sessionOper.getOrgId());
		paramMap1.put("validFlag", "1");
		paramMap1.put("busiTypeList", busiTypeList);
		List<BalConsume> balConsumeList = consumeMapper.findForSaleBill(paramMap1);
		
		Map<Object, Object> paramMap2 = new HashMap<Object, Object>();
		List<String> billTypeList = new ArrayList<String>();
		billTypeList.add("1");//1-销售收款
		billTypeList.add("3");//3-定金收款
		billTypeList.add("4");//4-销售退货退款
		paramMap2.put("orgId", sessionOper.getOrgId());
		paramMap2.put("billTypeList", billTypeList);
		List<AccTrans> accTransList = transMapper.findForSaleBill(paramMap2);
		
		for(BalConsume balConsume : balConsumeList){
			int consumerId = balConsume.getConsumerId();
			String consumerName = balConsume.getConsumerName();
			if(balConsume.getTotalBusiPrice() == null) continue;
			int totalBusiPrice = balConsume.getTotalBusiPrice();
			
			BillBusiBO billBusiBO = new BillBusiBO();
			billBusiBO.setTargetId(consumerId);
			billBusiBO.setTargetName(consumerName);
			billBusiBO.setTotalBusiPrice(totalBusiPrice);//销售额
			billBusiBO.setTotalPayPrice(0);//已收货款
			billBusiBO.setWaitPayPrice(totalBusiPrice - 0);//未收货款
			
			for(AccTrans accTrans : accTransList){
				
				int thisTargetId = accTrans.getTargetId();
				if(consumerId == thisTargetId){
					
					int totalPayPrice = accTrans.getSumTransPrice();
					billBusiBO.setTotalPayPrice(totalPayPrice);//已收货款
					if(totalBusiPrice>0){
						billBusiBO.setWaitPayPrice(totalBusiPrice - totalPayPrice);//未收货款
					}else{
						billBusiBO.setWaitPayPrice(totalBusiPrice);
					}
					
					break;
					
				}
				
			}
			billBusiBOList.add(billBusiBO);
		}
		
		return billBusiBOList;
	}
	
	@Override
	public List<BillBusiBO> searchPurchaseBillBusi(SessionOper sessionOper) {
		
		List<BillBusiBO> billBusiBOList = new ArrayList<BillBusiBO>();
		
		Map<Object, Object> paramMap1 = new HashMap<Object, Object>();
		List<String> busiTypeList = new ArrayList<String>();
		busiTypeList.add("03");//BUSI_TYPE(03-采购到货)
		busiTypeList.add("16");//BUSI_TYPE(16-返厂)
		paramMap1.put("orgId", sessionOper.getOrgId());
		paramMap1.put("validFlag", "1");
		paramMap1.put("busiTypeList", busiTypeList);
		List<BalConsume> balConsumeList = consumeMapper.findForPurchaseBill(paramMap1);
		
		Map<Object, Object> paramMap2 = new HashMap<Object, Object>();
		List<String> billTypeList = new ArrayList<String>();
		billTypeList.add("2");//BILL_TYPE(2-采购付款)
		billTypeList.add("5");//BILL_TYPE(5-返厂回款)
		paramMap2.put("orgId", sessionOper.getOrgId());
		paramMap2.put("billTypeList", billTypeList);
		List<AccTrans> accTransList = transMapper.findForPurchaseBill(paramMap2);
		
		for(BalConsume balConsume : balConsumeList){
			int providerId = balConsume.getProviderId();
			String providerName = balConsume.getProviderName();
			if(balConsume.getTotalBusiPrice() == null) continue;
			int totalBusiPrice = balConsume.getTotalBusiPrice();
			
			BillBusiBO billBusiBO = new BillBusiBO();
			billBusiBO.setTargetId(providerId);
			billBusiBO.setTargetName(providerName);
			billBusiBO.setTotalBusiPrice(totalBusiPrice);
			billBusiBO.setTotalPayPrice(0);
			billBusiBO.setWaitPayPrice(totalBusiPrice - 0);
			
			for(AccTrans accTrans : accTransList){
				
				int thisTargetId = accTrans.getTargetId();
				if(providerId == thisTargetId){
					
					int totalPayPrice = accTrans.getSumTransPrice();
					billBusiBO.setTotalPayPrice(totalPayPrice);
					if(totalBusiPrice>0){
						billBusiBO.setWaitPayPrice(totalBusiPrice - totalPayPrice);
					}else{
						billBusiBO.setWaitPayPrice(totalBusiPrice);
					}
					
					break;
					
				}
				
			}
			billBusiBOList.add(billBusiBO);
		}
		
		return billBusiBOList;
	}

	@Override
	public List<Consume> findConsumeForSaleBill(int targetId,
			SessionOper sessionOper) {
		
		ParConsumer parConsumer = consumerMapper.load(targetId);
		List<Consume> bos = new ArrayList<Consume>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		List<String> busiTypeList = new ArrayList<String>();
		busiTypeList.add("05");
		busiTypeList.add("15");
		
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("targetId", targetId);
		paramMap.put("busiTypeList", busiTypeList);
		paramMap.put("billFinishTime", parConsumer.getBillFinishTime());
		paramMap.put("validFlag", "1");
		List<BalConsume> pos = consumeMapper.findDetailForBill(paramMap);
		for(BalConsume po : pos){
			bos.add(new Consume(po));
		}
		
		return bos;
	}
	
	@Override
	public int findConsumeCountForConsumer(SearchConsumeVO vo, int targetId,
			SessionOper sessionOper) {
		
		List<String> busiTypeList = new ArrayList<String>();
		busiTypeList.add("05");
		busiTypeList.add("15");
		vo.setOrgId(sessionOper.getOrgId());
		vo.setTargetId(targetId);
		vo.setBusiTypeList(busiTypeList);
		vo.setValidFlag("1");
		
		return consumeMapper.findDetailCountForPartner(vo);
		
	}
	
	@Override
	public List<Consume> findConsumeForConsumer(SearchConsumeVO vo, int targetId,
			SessionOper sessionOper) {
		
		List<Consume> bos = new ArrayList<Consume>();
		
		List<String> busiTypeList = new ArrayList<String>();
		busiTypeList.add("05");
		busiTypeList.add("15");
		vo.setOrgId(sessionOper.getOrgId());
		vo.setTargetId(targetId);
		vo.setBusiTypeList(busiTypeList);
		vo.setValidFlag("1");
		
		List<BalConsume> pos = consumeMapper.findDetailForPartner(vo);
		for(BalConsume po : pos){
			bos.add(new Consume(po));
		}
		
		return bos;
	}
	
	@Override
	public List<Consume> findConsumeForPurchaseBill(int targetId,
			SessionOper sessionOper) {
		
		ParProvider parProvider = providerMapper.load(targetId);
		List<Consume> bos = new ArrayList<Consume>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		List<String> busiTypeList = new ArrayList<String>();
		busiTypeList.add("03");//BUSI_TYPE(03-采购到货)
		busiTypeList.add("16");//BUSI_TYPE(16-返厂)
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("targetId", targetId);
		paramMap.put("busiTypeList", busiTypeList);
		paramMap.put("billFinishTime", parProvider.getBillFinishTime());
		paramMap.put("validFlag", "1");
		List<BalConsume> pos = consumeMapper.findDetailForBill(paramMap);
		for(BalConsume po : pos){
			bos.add(new Consume(po));
		}
		
		return bos;
	}
	
	@Override
	public int findConsumeCountForProvider(SearchConsumeVO vo, int targetId,
			SessionOper sessionOper) {
		
		List<String> busiTypeList = new ArrayList<String>();
		busiTypeList.add("03");//BUSI_TYPE(03-采购到货)
		busiTypeList.add("16");//BUSI_TYPE(16-返厂)
		
		vo.setOrgId(sessionOper.getOrgId());
		vo.setTargetId(targetId);
        vo.setBusiTypeList(busiTypeList);
        vo.setValidFlag("1");
		return consumeMapper.findDetailCountForPartner(vo);
		
	}
	
	@Override
	public List<Consume> findConsumeForProvider(SearchConsumeVO vo, int targetId,
			SessionOper sessionOper) {
		
		List<Consume> bos = new ArrayList<Consume>();
		List<String> busiTypeList = new ArrayList<String>();
		busiTypeList.add("03");//BUSI_TYPE(03-采购到货)
		busiTypeList.add("16");//BUSI_TYPE(16-返厂)
		
		vo.setOrgId(sessionOper.getOrgId());
		vo.setTargetId(targetId);
        vo.setBusiTypeList(busiTypeList);
        vo.setValidFlag("1");
		List<BalConsume> pos = consumeMapper.findDetailForPartner(vo);
		for(BalConsume po : pos){
			bos.add(new Consume(po));
		}
		
		return bos;
	}

	@Override
	public List<Trans> findSaleHisTrans(int targetId, SessionOper sessionOper) {
		ParConsumer parConsumer = consumerMapper.load(targetId);
		
		List<Trans> bos = new ArrayList<Trans>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		List<String> billTypeList = new ArrayList<String>();
		billTypeList.add("1");//(1-销售收款)
		billTypeList.add("3");//(3-定金收款)
		billTypeList.add("4");//(4-销售退货退款)
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("targetId", targetId);
		paramMap.put("billTypeList", billTypeList);
		paramMap.put("billFinishTime", parConsumer.getBillFinishTime());
		List<AccTrans> pos = transMapper.findHisTrans(paramMap);
		for(AccTrans po : pos){
			bos.add(new Trans(po));
		}
		
		return bos;
	}
	
	@Override
	public List<Trans> findPurchaseHisTrans(int targetId, SessionOper sessionOper) {
		ParProvider parProvider = providerMapper.load(targetId);
		
		List<Trans> bos = new ArrayList<Trans>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		List<String> billTypeList = new ArrayList<String>();
		billTypeList.add("2");//BILL_TYPE(2-采购货款)
		billTypeList.add("5");//BILL_TYPE(5-返厂回款)
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("targetId", targetId);
		paramMap.put("billTypeList", billTypeList);//BILL_TYPE(1-采购付款)
		paramMap.put("billFinishTime", parProvider.getBillFinishTime());
		List<AccTrans> pos = transMapper.findHisTrans(paramMap);
		for(AccTrans po : pos){
			bos.add(new Trans(po));
		}
		
		return bos;
	}

	@Override
	public void saleBillOver(int targetId, SessionOper sessionOper) {
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("consumerId", targetId);
		paramMap.put("billFinishTime", new Date());
		consumerMapper.updateBillFinishTime(paramMap);
	}
	
	@Override
	public void purchaseBillOver(int targetId, SessionOper sessionOper) {
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("providerId", targetId);
		paramMap.put("billFinishTime", new Date());
		providerMapper.updateBillFinishTime(paramMap);
	}

}
