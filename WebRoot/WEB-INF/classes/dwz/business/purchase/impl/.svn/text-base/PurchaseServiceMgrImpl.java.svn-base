package dwz.business.purchase.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.SimpleDateFormat;

import dwz.business.common.SessionOper;
import dwz.business.purchase.AddPurchaseVO;
import dwz.business.purchase.Arrival;
import dwz.business.purchase.ArrivalDetail;
import dwz.business.purchase.Purchase;
import dwz.business.purchase.PurchaseDetail;
import dwz.business.purchase.PurchaseServiceMgr;
import dwz.business.purchase.SearchPurchaseVO;
import dwz.business.stock.Stock;
import dwz.common.util.ParameterUtil;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.BalConsume;
import dwz.persistence.beans.ProProviderProduct;
import dwz.persistence.beans.PurArrival;
import dwz.persistence.beans.PurArrivalDetail;
import dwz.persistence.beans.PurPurchase;
import dwz.persistence.beans.PurPurchaseDetail;
import dwz.persistence.beans.PurPurchasePrice;
import dwz.persistence.beans.RptPurchaseColl;
import dwz.persistence.beans.SalSale;
import dwz.persistence.beans.SalSaleDetail;
import dwz.persistence.beans.StoStock;
import dwz.persistence.beans.StoStockChange;
import dwz.persistence.beans.SysPaperGen;
import dwz.persistence.mapper.ArrivalDetailMapper;
import dwz.persistence.mapper.ArrivalMapper;
import dwz.persistence.mapper.ConsumeMapper;
import dwz.persistence.mapper.PaperGenMapper;
import dwz.persistence.mapper.ProviderProductMapper;
import dwz.persistence.mapper.PurchaseCollMapper;
import dwz.persistence.mapper.PurchaseDetailMapper;
import dwz.persistence.mapper.PurchaseMapper;
import dwz.persistence.mapper.PurchasePriceMapper;
import dwz.persistence.mapper.SaleDetailMapper;
import dwz.persistence.mapper.SaleMapper;
import dwz.persistence.mapper.StockChangeMapper;
import dwz.persistence.mapper.StockMapper;

@Transactional(rollbackFor = Exception.class)//readOnly = false, propagation=Propagation.REQUIRED
@Service("purchaseServiceMgr")
public class PurchaseServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements PurchaseServiceMgr {
	
	@Autowired
	private PurchaseMapper purchaseMapper;
	@Autowired
	private PurchaseDetailMapper purchaseDetailMapper;
	@Autowired
	private ArrivalDetailMapper arrivalDetailMapper;
	@Autowired
	private StockMapper stockMapper;
	@Autowired
	private StockChangeMapper stockChangeMapper;
	@Autowired
	private ConsumeMapper consumeMapper;
	@Autowired
	private ArrivalMapper arrivalMapper;
	@Autowired
	private SaleDetailMapper saleDetailMapper;
	@Autowired
	private SaleMapper saleMapper;
	@Autowired
	private ProviderProductMapper providerProductMapper;
	@Autowired
	private PurchasePriceMapper purchasePriceMapper;
	@Autowired
	private PurchaseCollMapper purchaseCollMapper;
	@Autowired
	private PaperGenMapper paperGenMapper;

	@Override
	public void addPurchase(Purchase purchase, SessionOper sessionOper) {
		
		PurPurchase purPurchase = purchase.getPurPurchase();
		purPurchase.setOrgId(sessionOper.getOrgId());
		Integer totalPrice = Integer.parseInt(ParameterUtil.fromY2F(purchase.getInputTotalPrice()));
		purPurchase.setTotalPrice(totalPrice);
		purPurchase.setCreateOperId(sessionOper.getOperId());
		purPurchase.setCreateTime(new Date());
		purPurchase.setStatus("1"); //PURCHASE_STATUS (1-新订单)
		
		//添加采购主单
		purchaseMapper.insert(purPurchase);
		
		StringBuffer saleNos = new StringBuffer();
		List<String> saleNoList = new ArrayList<String>();
		
		for(PurchaseDetail purchaseDetail : purchase.getPurchaseDetailList()){
			PurPurchaseDetail purPurchaseDetail = purchaseDetail.getPurPurchaseDetail();
			if(purPurchaseDetail.getProviderProductId() == null) continue;
			
			purPurchaseDetail.setPurchaseId(purPurchase.getPurchaseId());
			
			Integer purchaseUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(purchaseDetail.getInputPurchaseUnitPrice()));
			purPurchaseDetail.setPurchaseUnitPrice(purchaseUnitPrice);
			
			Integer purchasePrice = Integer.parseInt(ParameterUtil.fromY2F(purchaseDetail.getInputPurchasePrice()));
			purPurchaseDetail.setPurchasePrice(purchasePrice);
			
			//添加采购明细
			purchaseDetailMapper.insert(purPurchaseDetail);
			
			if("1".equals(purchase.getPurchaseProp())){
				
				SalSaleDetail salSaleDetail = new SalSaleDetail();
				salSaleDetail.setSaleDetailId(purchaseDetail.getSaleDetailId());
				salSaleDetail.setPurchaseQuantity(purchaseDetail.getPurchaseQuantity());
				saleDetailMapper.incPurchaseQuantity(salSaleDetail);
				
				SalSale salSale = new SalSale();
				salSale.setOrgId(sessionOper.getOrgId());
				salSale.setSaleNo(purchaseDetail.getSaleNo());
				salSale.setPurchaseQuantity(purchaseDetail.getPurchaseQuantity());
				saleMapper.incPurchaseQuantity(salSale);
				
				String saleNo = purchaseDetail.getSaleNo();
				String consumerName = purchaseDetail.getConsumerName();
				if(saleNoList.contains(saleNo)) continue;
				
				if(StringUtils.isBlank(saleNos.toString())){
					saleNos.append(saleNo+"【"+consumerName+"】");
				}else{
					saleNos.append(","+saleNo+"【"+consumerName+"】");
				}
				saleNoList.add(saleNo);
			}
			
		}
		
		if("1".equals(purchase.getPurchaseProp())){
			purPurchase.setSaleNos(saleNos.toString());
			purchaseMapper.updateSaleNos(purPurchase);
		}
		
	}
	
	private static String getTargetLengthStr(int no,int length){
		String str = String.valueOf(no);
		StringBuffer someZeroStr = new StringBuffer();
		for(int i=0;i<length-str.length();i++){
			someZeroStr.append("0");
		}
		return someZeroStr+str;
	}
	
	public  String buildPaperCode(SysPaperGen sysPaperGen){
		return sysPaperGen.getPaperType()+sysPaperGen.getYear()+sysPaperGen.getMonth()+sysPaperGen.getDay()+getTargetLengthStr(sysPaperGen.getNo(),3);
	}
	
	public void addCodeGen(SysPaperGen sysPaperGen){
		paperGenMapper.insert(sysPaperGen);
	}
    
    public void updateCodeGen(SysPaperGen sysPaperGen){
    	paperGenMapper.update(sysPaperGen);
	}
	
	public String getPaperNo(int orgId, String paperType){
		
    	SysPaperGen sysPaperGen = new SysPaperGen();
    	sysPaperGen.setOrgId(orgId);
    	sysPaperGen.setPaperType(paperType);
    	sysPaperGen.setYear(new SimpleDateFormat("yy").format(new Date()));
    	sysPaperGen.setMonth(new SimpleDateFormat("MM").format(new Date()));
    	sysPaperGen.setDay(new SimpleDateFormat("dd").format(new Date()));
    	
		SysPaperGen po = paperGenMapper.getOne(sysPaperGen);
		if(po==null){
			sysPaperGen.setNo(1);
			addCodeGen(sysPaperGen);
			return buildPaperCode(sysPaperGen);
		}else{
			sysPaperGen.setNo(Integer.valueOf(po.getNo().toString())+1);
			updateCodeGen(sysPaperGen);
			return buildPaperCode(sysPaperGen);
		}
	}
	
	@Override
	public void addSalePurchase(AddPurchaseVO addPurchaseVO,
			SessionOper sessionOper) {
		
		for(PurchaseDetail purchaseDetail : addPurchaseVO.getPurchaseDetailList()){
			
			if(purchaseDetail.getPurchaseQuantity() == null || purchaseDetail.getPurchaseQuantity()==0) continue;
			Purchase purchase = purchaseDetail.getPurchase();
			Map<Object, Object> paramMap = new HashMap<Object, Object>();
			paramMap.put("orgId", sessionOper.getOrgId());
			paramMap.put("purchaseProp", purchase.getPurchaseProp());
			paramMap.put("providerId", purchase.getProviderId());
			paramMap.put("status", "1");//待审核
			
			PurPurchase po_purPurchase = purchaseMapper.getPurchase(paramMap);
			
			Integer purchaseUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(purchaseDetail.getInputPurchaseUnitPrice()));
			Integer purchasePrice = purchaseUnitPrice * purchaseDetail.getPurchaseQuantity();
			
			PurPurchase purPurchase = null;
			if(po_purPurchase==null){//不存在销售采购单
				purPurchase = purchase.getPurPurchase();
				purPurchase.setPurchaseNo(getPaperNo(sessionOper.getOrgId(), "CG"));
				purPurchase.setOrgId(sessionOper.getOrgId());
				purPurchase.setTotalPrice(purchasePrice);
				purPurchase.setCreateOperId(sessionOper.getOperId());
				purPurchase.setCreateTime(new Date());
				purPurchase.setStatus("1"); //PURCHASE_STATUS (1-新订单)
				
				String saleNo = purchaseDetail.getSaleNo();
				String consumerName = purchaseDetail.getConsumerName();
				purPurchase.setSaleNos(saleNo+"【"+consumerName+"】");
				
				//添加采购主单
				purchaseMapper.insert(purPurchase);
				
				PurPurchaseDetail purPurchaseDetail = purchaseDetail.getPurPurchaseDetail();
				
				purPurchaseDetail.setPurchaseId(purPurchase.getPurchaseId());
				purPurchaseDetail.setPurchaseUnitPrice(purchaseUnitPrice);
				purPurchaseDetail.setPurchasePrice(purchasePrice);
				
				//添加采购明细
				purchaseDetailMapper.insert(purPurchaseDetail);
				
			} else {//已存在销售采购单
				
				paramMap = new HashMap<Object, Object>();
				paramMap.put("purchaseId", po_purPurchase.getPurchaseId());
				paramMap.put("providerProductId", purchaseDetail.getProviderProductId());
				paramMap.put("standard", purchaseDetail.getStandard());
				paramMap.put("purchaseUnitPrice", purchaseUnitPrice);
				paramMap.put("saleDetailId", purchaseDetail.getSaleDetailId());
				PurPurchaseDetail exist_purPurchaseDetail = purchaseDetailMapper.getExistPurchaseDetail(paramMap);
				if(exist_purPurchaseDetail==null){
					PurPurchaseDetail purPurchaseDetail = purchaseDetail.getPurPurchaseDetail();
					
					purPurchaseDetail.setPurchaseId(po_purPurchase.getPurchaseId());
					purPurchaseDetail.setPurchaseUnitPrice(purchaseUnitPrice);
					purPurchaseDetail.setPurchasePrice(purchasePrice);
					
					//添加采购明细
					purchaseDetailMapper.insert(purPurchaseDetail);
					
				}else{
					
					exist_purPurchaseDetail.setPurchaseQuantity(purchaseDetail.getPurchaseQuantity());
					exist_purPurchaseDetail.setPurchasePrice(purchasePrice);
					purchaseDetailMapper.incPurchaseQuantity(exist_purPurchaseDetail);//增加采购明细的采购数量
					
				}
				
				//增加采购总额,更新SALE_NOS
				po_purPurchase.setTotalPrice(purchasePrice);
				purchaseMapper.updateByContinuePur(po_purPurchase);
				
			}
			
			SalSaleDetail salSaleDetail = new SalSaleDetail();
			salSaleDetail.setSaleDetailId(purchaseDetail.getSaleDetailId());
			salSaleDetail.setPurchaseQuantity(purchaseDetail.getPurchaseQuantity());
			saleDetailMapper.incPurchaseQuantity(salSaleDetail);
			
			SalSale salSale = new SalSale();
			salSale.setOrgId(sessionOper.getOrgId());
			salSale.setSaleNo(purchaseDetail.getSaleNo());
			salSale.setPurchaseQuantity(purchaseDetail.getPurchaseQuantity());
			saleMapper.incPurchaseQuantity(salSale);
			
		}
		
	}
	
	@Override
	public List<Purchase> searchPurchaseForArrival(SearchPurchaseVO vo, SessionOper sessionOper) {
		List<Purchase> bos = new ArrayList<Purchase>();
		
		vo.setOrgId(sessionOper.getOrgId());
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("2");//PURCHASE_STATUS (2-待到货)
		statusList.add("4");//PURCHASE_STATUS (4-部分到货)
		vo.setStatusList(statusList);
		
		List<PurPurchase> pos = null;
		if(!StringUtils.isBlank(vo.getPurchaseNo())){
			pos = purchaseMapper.findArrivalByPurchaseNo(vo);
		} else {
			pos = purchaseMapper.findForArrival(vo);
		}
		
		for(PurPurchase po : pos){
			bos.add(new Purchase(po));
		}
		return bos;
	}

	@Override
	public List<Purchase> searchPurchaseForDo(SessionOper sessionOper ,List<String> statusList) {
		List<Purchase> bos = new ArrayList<Purchase>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("statusList", statusList);
		
		List<PurPurchase> pos = purchaseMapper.findForDo(paramMap);
		for(PurPurchase po : pos){
			bos.add(new Purchase(po));
		}
		return bos;
	}
	
	@Override
	public Purchase getPurchaseById(int purchaseId) {
		PurPurchase po = purchaseMapper.load(purchaseId);
		return new Purchase(po);
	}

	@Override
	public List<PurchaseDetail> findPurchaseDetailByPurchaseId(int purchaseId) {
		List<PurchaseDetail> bos = new ArrayList<PurchaseDetail>();
		List<PurPurchaseDetail> pos = purchaseDetailMapper.findPurchaseDetailByPurchaseId(purchaseId);
		for(PurPurchaseDetail po : pos){
			bos.add(new PurchaseDetail(po));
		}
		return bos;
	}

	@Override
	public void updatePurchase(Purchase purchase, SessionOper sessionOper) {
		purchaseMapper.updateForConf(purchase.getPurPurchase());
		if("1".equals(purchase.getPurchaseProp()) && "3".equals(purchase.getStatus())){//销售单采购 并且是 审核退回
			//把销售明细的已采购数减少回去
			
			for(PurchaseDetail purchaseDetail : purchase.getPurchaseDetailList()){
				SalSaleDetail salSaleDetail = new SalSaleDetail();
				salSaleDetail.setSaleDetailId(purchaseDetail.getSaleDetailId());
				salSaleDetail.setPurchaseQuantity(purchaseDetail.getPurchaseQuantity());
				saleDetailMapper.decPurchaseQuantity(salSaleDetail);
				
				SalSale salSale = new SalSale();
				salSale.setOrgId(sessionOper.getOrgId());
				salSale.setSaleNo(purchaseDetail.getSaleNo());
				salSale.setPurchaseQuantity(purchaseDetail.getPurchaseQuantity());
				saleMapper.decPurchaseQuantity(salSale);
			}
			
		}
	}
	
	@Override
	public int searchPurchaseCount(SearchPurchaseVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		if(StringUtils.isBlank(vo.getSaleNo())){
			return (Integer)purchaseMapper.findCountByQC(vo);
		}else{
			return (Integer)purchaseMapper.findCountBySaleNo(vo);
		}
	}

	@Override
	public List<Purchase> searchPurchase(SearchPurchaseVO vo,
			SessionOper sessionOper) {
		List<Purchase> bos = new ArrayList<Purchase>();
		vo.setOrgId(sessionOper.getOrgId());
		List<PurPurchase> pos = null;
		if(StringUtils.isBlank(vo.getSaleNo())){
			pos = purchaseMapper.findByQC(vo);
		} else {
			pos = purchaseMapper.findBySaleNo(vo);
		}
		for(PurPurchase po : pos){
			bos.add(new Purchase(po));
		}
		return bos;
	}
	
	public void incStock(Stock stock){
		StoStock po = stockMapper.findOneStock(stock);
		if(po == null){
			StoStock stoStock = stock.getStoStock();
			stoStock.setTotalQuantity(stock.getIncTotalQuantity());
			stoStock.setLockQuantity(stock.getIncLockQuantity());
			stoStock.setProviderQuantity(stock.getIncProviderQuantity());
			stockMapper.insert(stoStock);
		}else{
			stock.setStockId(po.getStockId());
			stockMapper.incStock(stock);
		}
	}

	@Override
	public void addPurchaseArrival(Purchase purchase, Arrival arrival, String arrivalNo, SessionOper sessionOper) {
		
		Date time = new Date();
		
		PurArrival purArrival = arrival.getPurArrival();
		purArrival.setArrivalNo(arrivalNo);
		purArrival.setPurchaseId(purchase.getPurchaseId());
		purArrival.setRegOperId(sessionOper.getOperId());
		purArrival.setRegTime(time);
		purArrival.setStatus("0");//ARRIVAL_STATUS(0-待收货确认)
		arrivalMapper.insert(purArrival);
		
		List<ArrivalDetail> arrivalDetailList = purchase.getArrivalDetailList();
		for(ArrivalDetail arrivalDetail : arrivalDetailList){
			PurArrivalDetail purArrivalDetail = arrivalDetail.getPurArrivalDetail();
			
			if(arrivalDetail.getArrivalQuantity() == null || arrivalDetail.getArrivalQuantity() == 0) continue;
			
			purArrivalDetail.setArrivalId(purArrival.getArrivalId());
			
			int purchaseUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(arrivalDetail.getInputPurchaseUnitPrice()));
			purArrivalDetail.setPurchaseUnitPrice(purchaseUnitPrice);
			
			int arrivalPrice = purchaseUnitPrice * arrivalDetail.getArrivalQuantity();
			purArrivalDetail.setArrivalPrice(arrivalPrice);
			
			arrivalDetailMapper.insert(purArrivalDetail);
			
			/**
			 * 更新或添加此厂家产品的采购价
			 */
			ProProviderProduct proProviderProduct = providerProductMapper.load(purArrivalDetail.getProviderProductId());
			
			PurPurchasePrice purPurchasePrice = new PurPurchasePrice();
			purPurchasePrice.setProviderProductId(proProviderProduct.getProviderProductId());
			purPurchasePrice.setProviderId(proProviderProduct.getProviderId());
			purPurchasePrice.setProductId(proProviderProduct.getProductId());
			purPurchasePrice.setStandard(purArrivalDetail.getStandard());
			purPurchasePrice.setUnitPrice(purArrivalDetail.getPurchaseUnitPrice());
			
			purchasePriceMapper.insertOrUpdatePrice(purPurchasePrice);
			
		}
		
	}

	@Override
	public void forceOver(int purchaseId, SessionOper sessionOper) {
		
		PurPurchase purPurchase = purchaseMapper.load(purchaseId);
		purPurchase.setStatus("6");//PURCHASE_STATUS(6-强制结束)
		purchaseMapper.updateStatus(purPurchase);
		
		Set<String> saleNoSet = new HashSet<String>();
		if("1".equals(purPurchase.getPurchaseProp())){
			//若是销售单采购，可能还需要减少对应销售单的已采购数
			List<PurPurchaseDetail> purPurchaseDetailList = purchaseDetailMapper.findForDecSalePurchase(purchaseId);
			for(PurPurchaseDetail purPurchaseDetail : purPurchaseDetailList){
				int purchaseQuantity = purPurchaseDetail.getPurchaseQuantity();
				int arrivalQuantity = purPurchaseDetail.getArrivalQuantity();
				int decQuantity = purchaseQuantity - arrivalQuantity;
				if(decQuantity > 0){
					SalSaleDetail salSaleDetail = new SalSaleDetail();
					salSaleDetail.setSaleDetailId(purPurchaseDetail.getSaleDetailId());
					salSaleDetail.setPurchaseQuantity(decQuantity);
					saleDetailMapper.decPurchaseQuantity(salSaleDetail);
					saleNoSet.add(purPurchaseDetail.getSaleNo());
				}
			}
		}
		
		for(String saleNo : saleNoSet){
			SalSale salSale = new SalSale();
			salSale.setOrgId(sessionOper.getOrgId());
			salSale.setSaleNo(saleNo);
			saleMapper.countPurchaseQuantity(salSale);
		}
	}

	@Override
	public List<Arrival> searchArrival(SessionOper sessionOper) {
		List<Arrival> bos = new ArrayList<Arrival>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("status", "0");//ARRIVAL_STATUS (0-待收货确认)
		
		List<PurArrival> pos = arrivalMapper.findArrivalForConf(paramMap);
		for(PurArrival po : pos){
			bos.add(new Arrival(po));
		}
		return bos;
	}

	@Override
	public Arrival getArrivalById(int arrivalId) {
		PurArrival po = arrivalMapper.load(arrivalId);
		return new Arrival(po);
	}

	@Override
	public List<ArrivalDetail> findArrivalDetailByArrivalId(int arrivalId) {
		List<ArrivalDetail> bos = new ArrayList<ArrivalDetail>();
		List<PurArrivalDetail> pos = arrivalDetailMapper.findArrivalDetailByArrivalId(arrivalId);
		for(PurArrivalDetail po : pos){
			bos.add(new ArrivalDetail(po));
		}
		return bos;
	}

	@Override
	/**
	 * 1.更新到货主单为已到货  √
	 * 2.更新采购明细的到货数和到货金额 √
	 * 3.更新销售明细的到货数
	 * 4.更新采购单状态为部分到货或全部到货√
	 * 5.记录产品消费√
	 * 6.变更库存√
	 * 7.记录库存变更日志√
	 */
	public void doOver(int arrivalId, int providerId, String providerName,
			SessionOper sessionOper) {
		
		Date time = new Date();
		PurArrival purArrival = arrivalMapper.load(arrivalId);
		purArrival.setArrivalOperId(sessionOper.getOperId());
		purArrival.setArrivalTime(time);
		purArrival.setStatus("1"); //ARRIVAL_STATUS(1-已收货)
		//更新收货主单状态
		arrivalMapper.update(purArrival);
		
		
		PurPurchase purPurchase = purchaseMapper.load(purArrival.getPurchaseId());
		
		List<PurArrivalDetail> purArrivalDetailList = arrivalDetailMapper.findArrivalDetailByArrivalId(arrivalId);
		for(PurArrivalDetail purArrivalDetail : purArrivalDetailList){
			PurPurchaseDetail purPurchaseDetail = purchaseDetailMapper.load(purArrivalDetail.getPurchaseDetailId());
			purPurchaseDetail.setArrivalQuantity(purArrivalDetail.getArrivalQuantity());
			purPurchaseDetail.setArrivalPrice(purArrivalDetail.getArrivalPrice());
			purchaseDetailMapper.updateByArrival(purPurchaseDetail);
			
			if("1".equals(purPurchase.getPurchaseProp())){
				Map<Object, Object> paramMap = new HashMap<Object, Object>();
				paramMap.put("saleDetailId", purArrivalDetail.getSaleDetailId());
				paramMap.put("arrivalQuantity", purArrivalDetail.getArrivalQuantity());
				saleDetailMapper.updateArrivalQuantity(paramMap);
			}
			
			BalConsume balConsume = new BalConsume();
			balConsume.setOrgId(sessionOper.getOrgId());
			balConsume.setConsumeTime(time);
			balConsume.setBusiType("03");//BUSI_TYPE(采购到货)
			balConsume.setProviderProductId(purPurchaseDetail.getProviderProductId());
			balConsume.setStandard(purPurchaseDetail.getStandard());
			balConsume.setQuantity(purPurchaseDetail.getArrivalQuantity());
			balConsume.setUnitPrice(purPurchaseDetail.getPurchaseUnitPrice());
			balConsume.setPrice(0- purPurchaseDetail.getArrivalQuantity() * purPurchaseDetail.getPurchaseUnitPrice());
			balConsume.setMemo("");//...
			balConsume.setTargetId(providerId);
			balConsume.setTargetName(providerName);
			balConsume.setPaperId(purArrival.getArrivalId());
			balConsume.setPaperNo(purArrival.getArrivalNo());
			balConsume.setTargetLeafId(purArrivalDetail.getArrivalDetailId());
			balConsume.setValidFlag("1");//VALID_FLAG(1-有效)
			//记录消费
			consumeMapper.insert(balConsume);
			
			Stock stock = new Stock();
			stock.setOrgId(sessionOper.getOrgId());
			stock.setProviderProductId(purArrivalDetail.getProviderProductId());
			stock.setStandard(purArrivalDetail.getStandard());
			stock.setIncTotalQuantity(purArrivalDetail.getArrivalQuantity());
			stock.setIncLockQuantity(0);
			stock.setIncProviderQuantity(0);
			this.incStock(stock);//增加库存
			
			//记录库存增加日志
			StoStockChange stoStockChange = new StoStockChange();
			stoStockChange.setOrgId(sessionOper.getOrgId());
			stoStockChange.setProviderProductId(purArrivalDetail.getProviderProductId());
			stoStockChange.setStandard(purArrivalDetail.getStandard());
			stoStockChange.setChangeTime(time);
			stoStockChange.setChangeQuantity(purArrivalDetail.getArrivalQuantity());
			stoStockChange.setBusiType("03");//BUSI_TYPE(03-采购到货)
			stoStockChange.setTopId(purArrival.getPurchaseId());
			stoStockChange.setTargetLeafId(purArrivalDetail.getArrivalDetailId());
			stoStockChange.setChangeAction("1");//STOCK_ACTION(1-增加)
			stockChangeMapper.insert(stoStockChange);
			
			//记录采购汇总报表
			RptPurchaseColl rptPurchaseColl = new RptPurchaseColl();
			rptPurchaseColl.setOrgId(sessionOper.getOrgId());
			rptPurchaseColl.setPurchaseProp(purPurchase.getPurchaseProp());
			rptPurchaseColl.setTransTime(time);
			rptPurchaseColl.setProviderId(purPurchase.getProviderId());
			rptPurchaseColl.setProviderName(purPurchase.getProviderName());
			rptPurchaseColl.setProductModel(purArrivalDetail.getProductModel());
			rptPurchaseColl.setProductName(purArrivalDetail.getProductName());
			rptPurchaseColl.setStandard(purArrivalDetail.getStandard());
			rptPurchaseColl.setQuantity(purArrivalDetail.getArrivalQuantity());
			rptPurchaseColl.setPrice(purArrivalDetail.getPurchaseUnitPrice());
			int amount = purArrivalDetail.getPurchaseUnitPrice() * purArrivalDetail.getArrivalQuantity();
			rptPurchaseColl.setAmount(amount);
			purchaseCollMapper.insert(rptPurchaseColl);
			
		}
		
		//可能更新采购单
		PurPurchaseDetail purPurchaseDetail = purchaseDetailMapper.findForUpdatePurchaseStatus(purArrival.getPurchaseId());
		if(purPurchaseDetail.getTotalArrivalQuantity().equals(purPurchaseDetail.getTotalPurchaseQuantity())){
			purPurchase.setStatus("5");//PURCHASE_STATUS(5-已全部收货)
		}else{
			purPurchase.setStatus("4");//PURCHASE_STATUS(4-已部分收货)
		}
		purchaseMapper.updateStatus(purPurchase);
		
	}

	@Override
	public List<Arrival> findArrivalByPurchaseId(int saleId) {
		List<Arrival> bos = new ArrayList<Arrival>();
		List<PurArrival> pos = arrivalMapper.findArrivalByPurchaseId(saleId);
		if(pos != null){
			for(PurArrival po : pos){
				bos.add(new Arrival(po));
			}
		}
		return bos;
	}

	@Override
	public int getUnArrivalCount(int purchaseId) {
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("purchaseId", purchaseId);
		paramMap.put("status", "0"); // ARRIVAL_STATUS(0-待收货确认)
		return arrivalMapper.getUnArrivalCount(paramMap);
	}

	@Override
	public int getPurDetailCountForProvProd(int providerProductId) {
		return purchaseDetailMapper.getCountForProvProd(providerProductId);
	}


}
