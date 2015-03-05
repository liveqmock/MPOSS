package dwz.business.sale.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.goods.Product;
import dwz.business.goods.ProviderProduct;
import dwz.business.partner.Consumer;
import dwz.business.partner.Provider;
import dwz.business.purchase.SearchSaleDetailVO;
import dwz.business.sale.Deliver;
import dwz.business.sale.DeliverDetail;
import dwz.business.sale.Sale;
import dwz.business.sale.SaleBack;
import dwz.business.sale.SaleBackDetail;
import dwz.business.sale.SaleDetail;
import dwz.business.sale.SaleImport;
import dwz.business.sale.SaleServiceMgr;
import dwz.business.sale.SearchFinishDeliverVO;
import dwz.business.sale.SearchProductVO;
import dwz.business.sale.SearchSaleBackVO;
import dwz.business.sale.SearchSaleVO;
import dwz.business.stock.Stock;
import dwz.common.util.Cn2Spell;
import dwz.common.util.ParameterUtil;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.BalConsume;
import dwz.persistence.beans.ParConsumer;
import dwz.persistence.beans.ParProvider;
import dwz.persistence.beans.ProProduct;
import dwz.persistence.beans.ProProviderProduct;
import dwz.persistence.beans.ProStandard;
import dwz.persistence.beans.RptSaleBackColl;
import dwz.persistence.beans.RptSaleColl;
import dwz.persistence.beans.SalDeliver;
import dwz.persistence.beans.SalDeliverDetail;
import dwz.persistence.beans.SalSale;
import dwz.persistence.beans.SalSaleBack;
import dwz.persistence.beans.SalSaleBackDetail;
import dwz.persistence.beans.SalSaleDetail;
import dwz.persistence.beans.SalSaleImport;
import dwz.persistence.beans.StoStock;
import dwz.persistence.beans.StoStockChange;
import dwz.persistence.beans.StoStockLock;
import dwz.persistence.mapper.ConsumeMapper;
import dwz.persistence.mapper.ConsumerMapper;
import dwz.persistence.mapper.DeliverDetailMapper;
import dwz.persistence.mapper.DeliverMapper;
import dwz.persistence.mapper.ProductMapper;
import dwz.persistence.mapper.ProviderMapper;
import dwz.persistence.mapper.ProviderProductMapper;
import dwz.persistence.mapper.SaleBackCollMapper;
import dwz.persistence.mapper.SaleBackDetailMapper;
import dwz.persistence.mapper.SaleBackMapper;
import dwz.persistence.mapper.SaleCollMapper;
import dwz.persistence.mapper.SaleDetailMapper;
import dwz.persistence.mapper.SaleImportMapper;
import dwz.persistence.mapper.SaleMapper;
import dwz.persistence.mapper.StandardMapper;
import dwz.persistence.mapper.StockChangeMapper;
import dwz.persistence.mapper.StockLockMapper;
import dwz.persistence.mapper.StockMapper;

@Transactional(rollbackFor = Exception.class)
@Service("saleServiceMgr")
public class SaleServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements SaleServiceMgr {
	
	@Autowired
	private SaleMapper saleMapper;
	@Autowired
	private SaleDetailMapper saleDetailMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private StockMapper stockMapper;
	@Autowired
	private DeliverDetailMapper deliverDetailMapper;
	@Autowired
	private StockLockMapper stockLockMapper;
	@Autowired
	private StockChangeMapper stockChangeMapper;
	@Autowired
	private DeliverMapper deliverMapper;
	@Autowired
	private ConsumeMapper consumeMapper;
	@Autowired
	private ProviderProductMapper providerProductMapper;
	@Autowired
	private ProviderMapper providerMapper;
	@Autowired
	private ConsumerMapper consumerMapper;
	@Autowired
	private SaleCollMapper saleCollMapper;
	@Autowired
	private SaleBackMapper saleBackMapper;
	@Autowired
	private SaleBackDetailMapper saleBackDetailMapper;
	@Autowired
	private SaleBackCollMapper saleBackCollMapper;
	@Autowired
	private SaleImportMapper saleImportMapper;
	@Autowired
	private StandardMapper standardMapper;

	@Override
	public List<Product> searchProduct(SearchProductVO vo,
			SessionOper sessionOper) {
		
		List<Product> bos = new ArrayList<Product>();
		vo.setOrgId(sessionOper.getOrgId());
		List<ProProduct> pos = productMapper.findByQC(vo);
		for(ProProduct po : pos){
			bos.add(new Product(po));
		}
		return bos;
	}

	@Override
	public int searchProductCount(SearchProductVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return productMapper.findCountByQC(vo);
	}

	@Override
	public List<Product> searchJoinProduct(SearchProductVO vo,
			SessionOper sessionOper) {
		
		List<Product> bos = new ArrayList<Product>();
		vo.setOrgId(sessionOper.getOrgId());
		List<ProProduct> pos = productMapper.findJoinByQC(vo);
		for(ProProduct po : pos){
			bos.add(new Product(po));
		}
		return bos;
	}

	@Override
	public int searchJoinProductCount(SearchProductVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return productMapper.findJoinCountByQC(vo);
	}

	@Override
	public void addSale(Sale sale, SessionOper sessionOper) {
		ParConsumer parConsumer = consumerMapper.load(sale.getConsumer().getConsumerId());
		SalSale salSale = sale.getSalSale();
		salSale.setOrgId(sessionOper.getOrgId());
		salSale.setSaleType(parConsumer.getConsumerType());//客户类型转化为订单类型
		salSale.setConsumerId(sale.getConsumer().getConsumerId());
		salSale.setConsumerName(sale.getConsumer().getConsumerName());
		salSale.setReceMen(sale.getConsumer().getLinkMan());
		salSale.setReceAddress(sale.getConsumer().getAddress());
		salSale.setLinkPhone(sale.getConsumer().getPhone());
		Integer totalSalePrice = Integer.parseInt(ParameterUtil.fromY2F(sale.getInputTotalSalePrice()));
		salSale.setTotalSalePrice(totalSalePrice);
		salSale.setCreateOperId(sessionOper.getOperId());
		salSale.setCreateTime(new Date());
		salSale.setPurchaseQuantity(0);
		salSale.setFinishBakFlag("0"); //FINISH_BAK_FLAG(0-未完成备货)
		if("0".equals(sale.getDepositFlag())){ //DEPOSIT_FLAG(是否收取定金：0-否)
			salSale.setStatus("1");//SALE_STATUS(1-待审核)
		} else {
			salSale.setStatus("7");//SALE_STATUS(7-待收取定金)
		}
		saleMapper.insert(salSale);
		
		List<SaleDetail> saleDetailList = sale.getSaleDetailList();
		for(SaleDetail saleDetail : saleDetailList){
			if(saleDetail.getNo() == null) continue;
			SalSaleDetail salSaleDetail = saleDetail.getSalSaleDetail();
			salSaleDetail.setSaleId(salSale.getSaleId());
			Integer saleUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(saleDetail.getInputSaleUnitPrice()));
			salSaleDetail.setSaleUnitPrice(saleUnitPrice);
			Integer salePrice = Integer.parseInt(ParameterUtil.fromY2F(saleDetail.getInputSalePrice()));
			salSaleDetail.setSalePrice(salePrice);
			salSaleDetail.setPurchaseQuantity(0);
			salSaleDetail.setArrivalQuantity(0);
			salSaleDetail.setBakQuantity(0);
			salSaleDetail.setDeliverQuantity(0);
			salSaleDetail.setDeliverCostPrice(0);
			salSaleDetail.setRemainBakQuantity(saleDetail.getSaleQuantity());
			saleDetailMapper.insert(salSaleDetail);
		}
	}
	
	@Override
	public List<Sale> searchSaleForBak(SearchSaleVO vo, SessionOper sessionOper) {
		List<Sale> bos = new ArrayList<Sale>();
		
		vo.setOrgId(sessionOper.getOrgId());
		List<String> statusList = new ArrayList<String>();
		statusList.add("2");
		statusList.add("8");
		vo.setStatusList(statusList);
		
		List<SalSale> pos = null;
		if(!StringUtils.isBlank(vo.getSaleNo())){
			pos = saleMapper.findBakBySaleNo(vo);
		} else if(!StringUtils.isBlank(vo.getPurchaseNo())) {
			pos = saleMapper.findBakByPurchaseNo(vo);
		} else {
			pos = saleMapper.findForBak(vo);
		}
		
		for(SalSale po : pos){
			bos.add(new Sale(po));
		}
		return bos;
	}
	
	@Override
	public List<Sale> searchSaleForDo(SessionOper sessionOper ,List<String> statusList) {
		List<Sale> bos = new ArrayList<Sale>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("statusList", statusList);
		
		List<SalSale> pos = saleMapper.findForDo(paramMap);
		for(SalSale po : pos){
			bos.add(new Sale(po));
		}
		return bos;
	}
	
	@Override
	public Sale getSaleById(int saleId) {
		SalSale po = saleMapper.load(saleId);
		return new Sale(po);
	}

	@Override
	public List<SaleDetail> findSaleDetailBySaleId(int saleId) {
		List<SaleDetail> bos = new ArrayList<SaleDetail>();
		List<SalSaleDetail> pos = saleDetailMapper.findSaleDetailBySaleId(saleId);
		for(SalSaleDetail po : pos){
			bos.add(new SaleDetail(po));
		}
		return bos;
	}
	
	@Override
	public void updateSale(Sale sale, SessionOper sessionOper) {
		SalSale salSale = sale.getSalSale();
		salSale.setConfOperId(sessionOper.getOperId());
		salSale.setConfTime(new Date());
		saleMapper.updateForConf(salSale);
	}

	@Override
	public List<Stock> searchProviderProduct(int productId,
			SessionOper sessionOper) {
		
		List<Stock> bos = new ArrayList<Stock>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("productId", productId);
		
		List<StoStock> pos = stockMapper.findByProductId(paramMap);
		for(StoStock po : pos){
			bos.add(new Stock(po));
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
	public Deliver getDeliverForBak(int saleId, String status) {
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("saleId", saleId);
		paramMap.put("status", status);
		SalDeliver po = deliverMapper.getDeliverForBak(paramMap);
		return new Deliver(po);
	}

	@Override
	public List<Integer> checkBak(Sale sale, SessionOper sessionOper) {
		
		List<Integer> rowNoList = new ArrayList<Integer>();
		
		int i = 0;
		Map<String, Integer> tempMap = new HashMap<String, Integer>();//记录厂家产品同一个规格已验证过的数量
		for(DeliverDetail deliverDetail : sale.getDeliverDetailList()){
			
			if(deliverDetail.getProviderProductId() == null) continue;
			
			int providerProductId = deliverDetail.getProviderProductId();
			String standard = deliverDetail.getStandard();
			
			int canUseQuantity = 0;//可用库存数
			int thisRowCanUseQuantity = 0;
			
			//再统计本厂家产品的库存可用数
			Map<Object, Object> paramMap = new HashMap<Object, Object>();
			paramMap.put("orgId", sessionOper.getOrgId());
			paramMap.put("providerProductId", providerProductId);
			paramMap.put("standard", standard);
			
			StoStock stoStock = stockMapper.getOneStock(paramMap);
			if(stoStock != null){
				canUseQuantity = (stoStock.getTotalQuantity() - stoStock.getProviderQuantity() - stoStock.getLockQuantity());
			}
			
			String key = providerProductId+"-"+standard;
			if(!tempMap.containsKey(key)) {
				 tempMap.put(key, 0);
			}
			
			thisRowCanUseQuantity = canUseQuantity - tempMap.get(key);
			
			//System.out.println("----------------第"+i+"行数据，可用库存数："+thisRowCanUseQuantity+"----------------");
			
			if(thisRowCanUseQuantity < deliverDetail.getBakQuantity()){
				rowNoList.add(i);
				tempMap.put(key, tempMap.get(key) + thisRowCanUseQuantity);
			} else {
				tempMap.put(key, tempMap.get(key) + deliverDetail.getBakQuantity());
			}
			i++;
		}
		
		return rowNoList;
	}

	@Override
	public void saleBak(Sale sale, Deliver deliver, SessionOper sessionOper, boolean createDeliver, String deliverNo) {
		
		Date time = new Date();
		
		int deliverId = 0;
		if(createDeliver){
			SalDeliver salDeliver = new SalDeliver();
			salDeliver.setDeliverNo(deliverNo);
			salDeliver.setSaleId(sale.getSaleId());
			salDeliver.setCreateOperId(sessionOper.getOperId());
			salDeliver.setCreateTime(new Date());
			salDeliver.setStatus("0");//DELIVER_STATUS(0-待发货)
			deliverMapper.insert(salDeliver);
			deliverId = salDeliver.getDeliverId();
		} else {
			deliverId = deliver.getDeliverId();
			
			SalDeliver salDeliver = new SalDeliver();
			salDeliver.setDeliverId(deliverId);
			salDeliver.setCreateOperId(sessionOper.getOperId());
			salDeliver.setCreateTime(new Date());
			deliverMapper.updateCreateTime(salDeliver);
			
		}
		
		for(DeliverDetail deliverDetail : sale.getDeliverDetailList()){
			SalDeliverDetail salDeliverDetail = deliverDetail.getSalDeliverDetail();
			if(salDeliverDetail.getSaleDetailId()==null) continue;
			salDeliverDetail.setDeliverId(deliverId);
			Integer saleUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(deliverDetail.getInputSaleUnitPrice()));
			salDeliverDetail.setSaleUnitPrice(saleUnitPrice);
			Integer costUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(deliverDetail.getInputCostUnitPrice()));
			salDeliverDetail.setCostUnitPrice(costUnitPrice);
			Integer costPrice = Integer.parseInt(ParameterUtil.fromY2F(deliverDetail.getInputCostPrice()));
			salDeliverDetail.setCostPrice(costPrice);
			salDeliverDetail.setBakOperId(sessionOper.getOperId());
			salDeliverDetail.setBakTime(time);
			deliverDetailMapper.insert(salDeliverDetail);
			
			Stock stock = new Stock();
			stock.setOrgId(sessionOper.getOrgId());
			stock.setProviderProductId(deliverDetail.getProviderProductId());
			stock.setStandard(deliverDetail.getStandard());
			stock.setIncTotalQuantity(0);
			stock.setIncLockQuantity(deliverDetail.getBakQuantity());
			stock.setIncProviderQuantity(0);
			this.incStock(stock);//变更库存
			
			//锁定库存
			StoStockLock stoStockLock = new StoStockLock();
			stoStockLock.setOrgId(sessionOper.getOrgId());
			stoStockLock.setProviderProductId(deliverDetail.getProviderProductId());
			stoStockLock.setStandard(deliverDetail.getStandard());
			stoStockLock.setBusiType("04");//BUSI_TYPE(04-装箱单备货)
			stoStockLock.setTopId(sale.getSaleId());
			stoStockLock.setTargetLeafId(salDeliverDetail.getDeliverDetailId());
			stoStockLock.setLockQuantity(salDeliverDetail.getBakQuantity());
			stoStockLock.setLockTime(time);
			stockLockMapper.insert(stoStockLock);
			
			//记录库存锁定日志
			StoStockChange stoStockChange = new StoStockChange();
			stoStockChange.setOrgId(sessionOper.getOrgId());
			stoStockChange.setProviderProductId(deliverDetail.getProviderProductId());
			stoStockChange.setStandard(deliverDetail.getStandard());
			stoStockChange.setChangeTime(time);
			stoStockChange.setChangeQuantity(salDeliverDetail.getBakQuantity());
			stoStockChange.setBusiType("04");//BUSI_TYPE(04-装箱单备货)
			stoStockChange.setTopId(sale.getSaleId());
			stoStockChange.setTargetLeafId(salDeliverDetail.getDeliverDetailId());
			stoStockChange.setChangeAction("3");//STOCK_ACTION(3-锁定)
			stockChangeMapper.insert(stoStockChange);
			
			saleDetailMapper.decRemainBakQuantity(salDeliverDetail);
		}
		
		Map<Object,Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("saleId", sale.getSaleId());
		paramMap.put("finishBakFlag", sale.getFinishBakFlag());
		paramMap.put("status", sale.getStatus());
		saleMapper.finishBak(paramMap);
		
	}
	
	@Override
	public List<Deliver> searchDeliver(SessionOper sessionOper) {
		List<Deliver> bos = new ArrayList<Deliver>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("status", "0");//DELIVER_STATUS (0-待发货)
		
		List<SalDeliver> pos = deliverMapper.findDeliverForDeliver(paramMap);
		for(SalDeliver po : pos){
			bos.add(new Deliver(po));
		}
		return bos;
	}
	
	@Override
	public int searchFinishDeliverCount(SearchFinishDeliverVO vo,
			SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		vo.setStatus("1");//DELIVER_STATUS (1-已发货)
		
		return deliverMapper.findDeliverCountForBack(vo);
	}

	@Override
	public List<Deliver> searchFinishDeliver(SearchFinishDeliverVO vo, SessionOper sessionOper) {
		List<Deliver> bos = new ArrayList<Deliver>();
		
		vo.setOrgId(sessionOper.getOrgId());
		vo.setStatus("1");//DELIVER_STATUS (1-已发货)
		
		List<SalDeliver> pos = deliverMapper.findDeliverForBack(vo);
		for(SalDeliver po : pos){
			bos.add(new Deliver(po));
		}
		return bos;
	}
	
	@Override
	public Deliver getDeliverById(int deliverId) {
		SalDeliver po = deliverMapper.load(deliverId);
		return new Deliver(po);
	}
	
	@Override
	public List<DeliverDetail> findDeliverDetail(int deliverId) {
		List<DeliverDetail> bos = new ArrayList<DeliverDetail>();
		List<SalDeliverDetail> pos = deliverDetailMapper.findDeliverDetail(deliverId);
		for(SalDeliverDetail po : pos){
			bos.add(new DeliverDetail(po));
		}
		return bos;
	}
	
	public void decStock(Stock stock){
		StoStock po = stockMapper.findOneStock(stock);
		stock.setStockId(po.getStockId());
		stockMapper.decStock(stock);
	}

	@Override
	public void doDeliver(int deliverId, int consumerId, String consumerName, SessionOper sessionOper) {
		
		Date time = new Date();
		SalDeliver salDeliver = deliverMapper.load(deliverId);
		salDeliver.setDeliverOperId(sessionOper.getOperId());
		salDeliver.setDeliverTime(time);
		salDeliver.setStatus("1"); //DELIVER_STATUS(1-已发货)
		//更新发货主单状态
		deliverMapper.update(salDeliver);
		
		SalSale salSale = saleMapper.load(salDeliver.getSaleId());
		
		List<SalDeliverDetail> salDeliverDetailList = deliverDetailMapper.findDeliverDetail(deliverId);
		for(SalDeliverDetail salDeliverDetail : salDeliverDetailList){
			int deliverDetailId = salDeliverDetail.getDeliverDetailId();
			int saleDetailId = salDeliverDetail.getSaleDetailId();
			int bakQuantity = salDeliverDetail.getBakQuantity();
			int costPrice = salDeliverDetail.getCostPrice();
			int providerProductId = salDeliverDetail.getProviderProductId();
			
			SalSaleDetail salSaleDetail = saleDetailMapper.load(saleDetailId);
			salSaleDetail.setDeliverQuantity(bakQuantity);
			salSaleDetail.setDeliverCostPrice(costPrice);
			//更新销售明细的数据
			saleDetailMapper.updateByDeliver(salSaleDetail);
			
			BalConsume balConsume = new BalConsume();
			balConsume.setOrgId(sessionOper.getOrgId());
			balConsume.setConsumeTime(time);
			balConsume.setBusiType("05");//BUSI_TYPE(装箱单发货)
			balConsume.setProviderProductId(providerProductId);
			balConsume.setStandard(salDeliverDetail.getStandard());
			balConsume.setQuantity(bakQuantity);
			balConsume.setUnitPrice(salDeliverDetail.getSaleUnitPrice());
			balConsume.setPrice(bakQuantity * salDeliverDetail.getSaleUnitPrice());
			balConsume.setMemo(salSaleDetail.getSaleDesc());
			balConsume.setTargetId(consumerId);
			balConsume.setTargetName(consumerName);
			balConsume.setPaperId(salDeliver.getDeliverId());
			balConsume.setPaperNo(salDeliver.getDeliverNo());
			balConsume.setTargetLeafId(deliverDetailId);
			balConsume.setValidFlag("1");//VALID_FLAG(1-有效)
			//记录消费
			consumeMapper.insert(balConsume);
			
			Stock stock = new Stock();
			stock.setOrgId(sessionOper.getOrgId());
			stock.setProviderProductId(providerProductId);
			stock.setStandard(salDeliverDetail.getStandard());
			stock.setDecTotalQuantity(bakQuantity);
			stock.setDecLockQuantity(bakQuantity);
			stock.setDecProviderQuantity(0);
			//变更库存
			this.decStock(stock);
			
			StoStockLock stoStockLock = new StoStockLock();
			stoStockLock.setOrgId(sessionOper.getOrgId());
			stoStockLock.setBusiType("04");//装箱单备货
			stoStockLock.setTargetLeafId(deliverDetailId);
			//锁定日志删除
			stockLockMapper.delete(stoStockLock);
			
			StoStockChange stoStockChange = new StoStockChange();
			stoStockChange.setOrgId(sessionOper.getOrgId());
			stoStockChange.setProviderProductId(providerProductId);
			stoStockChange.setStandard(salDeliverDetail.getStandard());
			stoStockChange.setChangeTime(time);
			stoStockChange.setChangeQuantity(bakQuantity);
			stoStockChange.setBusiType("05");//BUSI_TYPE(05-装箱单发货)
			stoStockChange.setTopId(salDeliver.getSaleId());
			stoStockChange.setTargetLeafId(deliverDetailId);
			stoStockChange.setChangeAction("2");//STOCK_ACTION(2-减少)
			//记录库存变更日志
			stockChangeMapper.insert(stoStockChange);
			
			//记录销售汇总报表
			RptSaleColl rptSaleColl = new RptSaleColl();
			rptSaleColl.setOrgId(sessionOper.getOrgId());
			rptSaleColl.setSaleType(salSale.getSaleType());
			rptSaleColl.setTransTime(time);
			rptSaleColl.setConsumerId(salSale.getConsumerId());
			rptSaleColl.setConsumerName(salSale.getConsumerName());
			rptSaleColl.setProductModel(salDeliverDetail.getProductModel());
			rptSaleColl.setProductName(salDeliverDetail.getProductName());
			rptSaleColl.setStandard(salDeliverDetail.getStandard());
			rptSaleColl.setQuantity(salDeliverDetail.getBakQuantity());
			rptSaleColl.setPrice(salDeliverDetail.getSaleUnitPrice());
			int amount = salDeliverDetail.getSaleUnitPrice() * salDeliverDetail.getBakQuantity();
			rptSaleColl.setAmount(amount);
			rptSaleColl.setCostPrice(salDeliverDetail.getCostUnitPrice());
			int costAmount = salDeliverDetail.getCostUnitPrice() * salDeliverDetail.getBakQuantity();
			int profitAmount = amount - costAmount;
			rptSaleColl.setProfitAmount(profitAmount);
			saleCollMapper.insert(rptSaleColl);
		}
		
		//可能更新销售单
		SalSaleDetail salSaleDetail = saleDetailMapper.findForUpdateSaleStatus(salDeliver.getSaleId());
		if(salSaleDetail.getTotalDeliverQuantity().equals(salSaleDetail.getTotalSaleQuantity())){
			salSale.setStatus("5");//SALE_STATUS(5-全部发货)
		}
		salSale.setTotalCostPrice(salSaleDetail.getTotalCostPrice());
		saleMapper.updateByDeliver(salSale);
		
	}
	
	@Override
	public int searchSaleCount(SearchSaleVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		if(StringUtils.isBlank(vo.getSaleNo())){
			return (Integer)saleMapper.findCountByQC(vo);
		}else{
			return (Integer)saleMapper.findCountBySaleNo(vo);
		}
	}

	@Override
	public List<Sale> searchSale(SearchSaleVO vo, SessionOper sessionOper) {
		List<Sale> bos = new ArrayList<Sale>();
		vo.setOrgId(sessionOper.getOrgId());
		List<SalSale> pos = null;
		if(StringUtils.isBlank(vo.getSaleNo())){
			pos = saleMapper.findByQC(vo);
		} else {
			pos = saleMapper.findBySaleNo(vo);
		}
		for(SalSale po : pos){
			bos.add(new Sale(po));
		}
		return bos;
	}

	@Override
	public List<Deliver> findDeliverForShow(int saleId) {
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		List<String> statusList = new ArrayList<String>();
		statusList.add("0");//DELIVER_STATUS(0-未发货)
		statusList.add("1");//DELIVER_STATUS(1-已发货)
		
		paramMap.put("saleId", saleId);
		paramMap.put("statusList", statusList);
		
		List<Deliver> bos = new ArrayList<Deliver>();
		List<SalDeliver> pos = deliverMapper.findDeliver(paramMap);
		if(pos != null){
			for(SalDeliver po : pos){
				bos.add(new Deliver(po));
			}
		}
		return bos;
	}
	
	@Override
	public void updateSaleForCustomer(Sale sale, SessionOper sessionOper) {
		
		List<SaleDetail> saleDetailList = sale.getSaleDetailList();
		for(SaleDetail saleDetail : saleDetailList){
			SalSaleDetail salSaleDetail = saleDetail.getSalSaleDetail();
			if(salSaleDetail.getSaleDetailId() == null && salSaleDetail.getNo() == null) continue;//删除了的，略过
			if(salSaleDetail.getSaleDetailId() == null){
				salSaleDetail.setSaleId(sale.getSaleId());
				Integer saleUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(saleDetail.getInputSaleUnitPrice()));
				salSaleDetail.setSaleUnitPrice(saleUnitPrice);
				Integer salePrice = Integer.parseInt(ParameterUtil.fromY2F(saleDetail.getInputSalePrice()));
				salSaleDetail.setSalePrice(salePrice);
				salSaleDetail.setRemainBakQuantity(saleDetail.getSaleQuantity());
				salSaleDetail.setDeliverQuantity(0);
				salSaleDetail.setDeliverCostPrice(0);
				salSaleDetail.setPurchaseQuantity(0);
				saleDetailMapper.insert(salSaleDetail);
			}else{
				Integer saleUnitPrice = null;
				if(saleDetail.getInputSaleUnitPrice() != null){
					saleUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(saleDetail.getInputSaleUnitPrice()));
					salSaleDetail.setSaleUnitPrice(saleUnitPrice);
				}
				Integer salePrice = null;
				if(saleDetail.getInputSaleUnitPrice() != null){
					salePrice = Integer.parseInt(ParameterUtil.fromY2F(saleDetail.getInputSalePrice()));
					salSaleDetail.setSalePrice(salePrice);
				}
				int saleQuantity = saleDetail.getSaleQuantity();
				int beforeSaleQuantity = saleDetail.getBeforeSaleQuantity();
				int remainBakQuantity = saleQuantity - beforeSaleQuantity;//变化了的remainBakQuantity
				salSaleDetail.setRemainBakQuantity(remainBakQuantity);
				saleDetailMapper.updateForCustomer(salSaleDetail);
			}
			
		}
		
		//更新销售主单信息
		SalSale salSale = saleMapper.load(sale.getSaleId());
		SalSaleDetail salSaleDetail = saleDetailMapper.getColumnSum(salSale.getSaleId());
		salSale.setTotalSaleQuantity(salSaleDetail.getTotalSaleQuantity());
		salSale.setTotalSalePrice(salSaleDetail.getTotalSalePrice());
		if(salSaleDetail.getTotalRemainBakQuantity() == 0){//修改订单后，如果全部备货完毕
			salSale.setFinishBakFlag("1");//FINISH_BAK_FLAG(1-已完成备货)
			
			if(salSaleDetail.getTotalDeliverQuantity().equals(salSaleDetail.getTotalSaleQuantity())){//如果全部发货完毕
				salSale.setStatus("6");//SALE_STATUS(6-强制结束)
			}
		}else{//还有未备货完毕的
			if("4".equals(salSale.getStatus())){//如果订单是待发货状态的，那么修改订单状态为备货中
				salSale.setStatus("2");
			}
		}
		
		saleMapper.updateForCustomer(salSale);
	}

	@Override
	public List<SaleDetail> searchSaleDetail(SearchSaleDetailVO vo,int providerId,
			SessionOper sessionOper) {
		
		List<SaleDetail> bos = new ArrayList<SaleDetail>();
		if(vo.getSale() == null || StringUtils.isBlank(vo.getSale().getSaleNo())) return bos;
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("saleNo", vo.getSale().getSaleNo());
		paramMap.put("orgId", sessionOper.getOrgId());
		List<SalSaleDetail> pos = saleDetailMapper.findSaleDetailBySaleNo(paramMap);
		if(pos.isEmpty()) return bos;
		
		Map<Integer, Integer> productId_providerProductId_map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> productId_unitPrice_map = new HashMap<Integer, Integer>();
		List<ProProviderProduct> proProductProviderList = providerProductMapper.findForPurchase(providerId);
		for(ProProviderProduct proProviderProduct : proProductProviderList){
			productId_providerProductId_map.put(proProviderProduct.getProductId(), proProviderProduct.getProviderProductId());
			productId_unitPrice_map.put(proProviderProduct.getProductId(), proProviderProduct.getUnitPrice());
		}
		
		List<Integer> productIdList = new ArrayList<Integer>();
		for(SalSaleDetail po : pos){
			productIdList.add(po.getProductId());
		}
		paramMap = new HashMap<Object, Object>();
		paramMap.put("productIdList", productIdList);
		List<StoStock> stoStockList = stockMapper.findForPur(paramMap);
		Map<String, Integer> stoStockMap = new HashMap<String, Integer>();
		for(StoStock stoStock : stoStockList){
			stoStockMap.put(stoStock.getProductId()+"-"+stoStock.getStandard(), stoStock.getSumCanUseQuantity());
		}
		
		for(SalSaleDetail po : pos){
			SaleDetail bo = new SaleDetail();
			if(stoStockMap.containsKey(po.getProductId()+"-"+po.getStandard())){
				bo.setCanUseQuantity(stoStockMap.get(po.getProductId()+"-"+po.getStandard()));
			}else{
				bo.setCanUseQuantity(0);
			}
			if(productId_providerProductId_map.containsKey(po.getProductId())){
				bo.setPurchaseFlag("1");
				bo.setProviderProductId(productId_providerProductId_map.get(po.getProductId()));
				bo.setPurchaseUnitPrice(productId_unitPrice_map.get(po.getProductId()));
			}else{
				bo.setPurchaseFlag("0");
				bo.setPurchaseUnitPrice(0);
			}
			bo.setSalSaleDetail(po);
			bos.add(bo);
		}
		
		return bos;
	}

	@Override
	public List<Provider> loadProviderForBak(SessionOper sessionOper,
			int productId, String standard) {
		
		List<Provider> bos = new ArrayList<Provider>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("productId", productId);
		paramMap.put("standard", standard);
		
		List<ParProvider> pos = providerMapper.findProviderForBak(paramMap);
		for(ParProvider po : pos){
			bos.add(new Provider(po));
		}
		
		return bos;
	}

	@Override
	public void forceOver(int saleId, SessionOper sessionOper) {
		
		Date time = new Date();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("saleId", saleId);
		paramMap.put("status", "6"); //SALE_STATUS(6-强制结束)
		saleMapper.forceOver(paramMap);
		
		paramMap = new HashMap<Object, Object>();
		paramMap.put("saleId", saleId);
		paramMap.put("status", "0");
		
		//1. 装箱单备货锁定的库存转为可用库存
		List<SalDeliverDetail> salDeliverDetailList = deliverDetailMapper.findForOver(paramMap);
		
		for(SalDeliverDetail salDeliverDetail : salDeliverDetailList){
			
			//1.1. 更新库存： 锁定库存减少，库存总数不变(即将锁定库存转化为可用库存)
			Stock stock = new Stock();
			stock.setOrgId(sessionOper.getOrgId());
			stock.setProviderProductId(salDeliverDetail.getProviderProductId());
			stock.setDecTotalQuantity(0);
			stock.setDecLockQuantity(salDeliverDetail.getBakQuantity());
			stock.setDecProviderQuantity(0);
			this.decStock(stock);
			
			
			//1.2. 记录库存解锁日志
			StoStockChange stoStockChange = new StoStockChange();
			stoStockChange.setOrgId(sessionOper.getOrgId());
			stoStockChange.setProviderProductId(salDeliverDetail.getProviderProductId());
			stoStockChange.setChangeTime(time);
			stoStockChange.setChangeQuantity(salDeliverDetail.getBakQuantity());
			stoStockChange.setBusiType("09");//BUSI_TYPE(04-销售单强制结束)
			stoStockChange.setTargetLeafId(salDeliverDetail.getDeliverDetailId());
			stoStockChange.setTopId(saleId);
			stoStockChange.setChangeAction("4");//STOCK_CHANGE_ACTION(4-解锁)
			stockChangeMapper.insert(stoStockChange);
			
			//1.3. 删除锁定记录
			StoStockLock stoStockLock = new StoStockLock();
			stoStockLock.setOrgId(sessionOper.getOrgId());
			stoStockLock.setBusiType("04");//BUSI_TYPE(04-装箱单备货)
			stoStockLock.setTargetLeafId(salDeliverDetail.getDeliverDetailId());
			stockLockMapper.delete(stoStockLock);
		}
		
	}

	@Override
	public void confDeposit(int saleId) {
		SalSale salSale = new SalSale();
		salSale.setSaleId(saleId);
		salSale.setStatus("1"); //SALE_STATUS (1-新订单)
		saleMapper.updateStatus(salSale);
	}

	@Override
	public int getSaleCountByProduct(int productId) {
		return saleMapper.getSaleCountByProduct(productId);
	}

	@Override
	public void del(int saleId, int saleDetailId) {
		saleDetailMapper.delete(saleDetailId);
		
		SalSale salSale = saleMapper.load(saleId);
		SalSaleDetail salSaleDetail = saleDetailMapper.getColumnSum(saleId);
		if(salSaleDetail == null){
			salSale.setTotalSaleQuantity(0);
			salSale.setTotalSalePrice(0);
			salSale.setStatus("6");//SALE_STATUS(6-强制结束)
		}else{
			salSale.setTotalSaleQuantity(salSaleDetail.getTotalSaleQuantity());
			salSale.setTotalSalePrice(salSaleDetail.getTotalSalePrice());
			if(salSaleDetail.getTotalDeliverQuantity().equals(salSaleDetail.getTotalSaleQuantity())){
				salSale.setStatus("6");//SALE_STATUS(6-强制结束)
			}
		}
		saleMapper.updateByDel(salSale);
	}

	//1.装箱单取消√
	//2.库存解锁√
	//3.锁定记录删除√
	//4.记录解锁日志√
	//5.增加销售明细的剩余待备货数√
	//6.更新销售单状态及是否备货完毕标识√
	@Override
	public void doDeliverCancel(int deliverId, SessionOper sessionOper) {
		
		SalDeliver salDeliver = deliverMapper.load(deliverId);
		salDeliver.setStatus("2");//已取消
		deliverMapper.cancel(salDeliver);
		
		List<SalDeliverDetail> deliverDetailList = deliverDetailMapper.findDeliverDetailForCancel(deliverId);
		for(SalDeliverDetail deliverDetail : deliverDetailList){
			
			//解锁库存
			Stock stock = new Stock();
			stock.setOrgId(sessionOper.getOrgId());
			stock.setProviderProductId(deliverDetail.getProviderProductId());
			stock.setStandard(deliverDetail.getStandard());
			stock.setDecTotalQuantity(0);
			stock.setDecLockQuantity(deliverDetail.getBakQuantity());
			stock.setDecProviderQuantity(0);
			this.decStock(stock);
			
			//删除锁定记录
			StoStockLock stoStockLock = new StoStockLock();
			stoStockLock.setOrgId(sessionOper.getOrgId());
			stoStockLock.setBusiType("04");//BUSI_TYPE(04-装箱单备货)
			stoStockLock.setTargetLeafId(deliverDetail.getDeliverDetailId());
			stockLockMapper.delete(stoStockLock);
			
			//记录库存解锁日志
			StoStockChange stoStockChange = new StoStockChange();
			stoStockChange.setOrgId(sessionOper.getOrgId());
			stoStockChange.setProviderProductId(deliverDetail.getProviderProductId());
			stoStockChange.setStandard(deliverDetail.getStandard());
			stoStockChange.setChangeTime(new Date());
			stoStockChange.setChangeQuantity(deliverDetail.getBakQuantity());
			stoStockChange.setBusiType("13");//BUSI_TYPE(13-装箱单取消)
			stoStockChange.setTopId(salDeliver.getSaleId());
			stoStockChange.setTargetLeafId(deliverDetail.getDeliverDetailId());
			stoStockChange.setChangeAction("4");//STOCK_ACTION(3-解锁)
			stockChangeMapper.insert(stoStockChange);
			
			//增加销售明细的剩余待备货数
			saleDetailMapper.incRemainBakQuantity(deliverDetail);
		}
		
		
		SalSale salSale = saleMapper.load(salDeliver.getSaleId());
		
		Map<Object,Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("saleId", salSale.getSaleId());
		
		paramMap.put("finishBakFlag", "0");
		paramMap.put("status", "2");//SALE_STATUS(2-备货中)
		
		saleMapper.unfinishBak(paramMap);
		
	}

	//1.库存解锁√
	//2.锁定记录删除√
	//3.记录解锁日志√
	//4.增加销售明细的剩余待备货数√
	//5.装箱单产品删除√
	//6.装箱单取消√
	//7.更新销售单状态及是否备货完毕标识√
	@Override
	public void delDeliverDetail(int deliverDetailId, SessionOper sessionOper) {
		
		SalDeliverDetail deliverDetail = deliverDetailMapper.load(deliverDetailId);
		SalDeliver salDeliver = deliverMapper.load(deliverDetail.getDeliverId());
		
		//解锁库存
		Stock stock = new Stock();
		stock.setOrgId(sessionOper.getOrgId());
		stock.setProviderProductId(deliverDetail.getProviderProductId());
		stock.setStandard(deliverDetail.getStandard());
		stock.setDecTotalQuantity(0);
		stock.setDecLockQuantity(deliverDetail.getBakQuantity());
		stock.setDecProviderQuantity(0);
		this.decStock(stock);
		
		//删除锁定记录
		StoStockLock stoStockLock = new StoStockLock();
		stoStockLock.setOrgId(sessionOper.getOrgId());
		stoStockLock.setBusiType("04");//BUSI_TYPE(04-装箱单备货)
		stoStockLock.setTargetLeafId(deliverDetail.getDeliverDetailId());
		stockLockMapper.delete(stoStockLock);
		
		//记录库存解锁日志
		StoStockChange stoStockChange = new StoStockChange();
		stoStockChange.setOrgId(sessionOper.getOrgId());
		stoStockChange.setProviderProductId(deliverDetail.getProviderProductId());
		stoStockChange.setStandard(deliverDetail.getStandard());
		stoStockChange.setChangeTime(new Date());
		stoStockChange.setChangeQuantity(deliverDetail.getBakQuantity());
		stoStockChange.setBusiType("14");//BUSI_TYPE(14-装箱单产品删除)
		stoStockChange.setTopId(salDeliver.getSaleId());
		stoStockChange.setTargetLeafId(deliverDetail.getDeliverDetailId());
		stoStockChange.setChangeAction("4");//STOCK_ACTION(3-解锁)
		stockChangeMapper.insert(stoStockChange);
		
		//增加销售明细的剩余待备货数
		saleDetailMapper.incRemainBakQuantity(deliverDetail);
		
		//装箱单产品删除
		deliverDetailMapper.delete(deliverDetailId);
		
		//装箱单取消
		salDeliver.setStatus("2");//已取消
		deliverMapper.autoCancel(salDeliver);
		
		//更新销售单状态及是否备货完毕标识
		SalSale salSale = saleMapper.load(salDeliver.getSaleId());
		Map<Object,Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("saleId", salSale.getSaleId());
		
		paramMap.put("finishBakFlag", "0");
		paramMap.put("status", "2");//SALE_STATUS(2-备货中)
		saleMapper.unfinishBak(paramMap);
		
	}
	
	@Override
	public void addSaleBack(SaleBack saleBack, SessionOper sessionOper) {
		ParConsumer parConsumer = consumerMapper.load(saleBack.getConsumer().getConsumerId());
		SalSaleBack salSaleBack = saleBack.getSalSaleBack();
		salSaleBack.setOrgId(sessionOper.getOrgId());
		salSaleBack.setSaleBackType(parConsumer.getConsumerType());//客户类型转化为订单类型
		salSaleBack.setConsumerId(parConsumer.getConsumerId());
		salSaleBack.setConsumerName(parConsumer.getConsumerName());
		Integer totalBackPrice = Integer.parseInt(ParameterUtil.fromY2F(saleBack.getInputTotalBackPrice()));
		salSaleBack.setTotalBackPrice(totalBackPrice);
		salSaleBack.setCreateOperId(sessionOper.getOperId());
		salSaleBack.setCreateTime(new Date());
		salSaleBack.setStatus("1");//SALE_STATUS(1-待审核)
		saleBackMapper.insert(salSaleBack);
		
		List<SaleBackDetail> saleBackDetailList = saleBack.getSaleBackDetailList();
		for(SaleBackDetail saleBackDetail : saleBackDetailList){
			if(saleBackDetail.getNo() == null) continue;
			SalSaleBackDetail salSaleBackDetail = saleBackDetail.getSalSaleBackDetail();
			salSaleBackDetail.setSaleBackId(salSaleBack.getSaleBackId());
			Integer backUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(saleBackDetail.getInputBackUnitPrice()));
			salSaleBackDetail.setBackUnitPrice(backUnitPrice);
			Integer backPrice = Integer.parseInt(ParameterUtil.fromY2F(saleBackDetail.getInputBackPrice()));
			salSaleBackDetail.setBackPrice(backPrice);
			saleBackDetailMapper.insert(salSaleBackDetail);
		}
	}
	
	@Override
	public List<SaleBack> searchSaleBackForDo(SessionOper sessionOper ,List<String> statusList) {
		List<SaleBack> bos = new ArrayList<SaleBack>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("statusList", statusList);
		
		List<SalSaleBack> pos = saleBackMapper.findForDo(paramMap);
		for(SalSaleBack po : pos){
			bos.add(new SaleBack(po));
		}
		return bos;
	}
	
	@Override
	public SaleBack getSaleBackById(int saleBackId) {
		SalSaleBack po = saleBackMapper.load(saleBackId);
		return new SaleBack(po);
	}

	@Override
	public List<SaleBackDetail> findSaleBackDetailBySaleBackId(int saleBackId) {
		List<SaleBackDetail> bos = new ArrayList<SaleBackDetail>();
		List<SalSaleBackDetail> pos = saleBackDetailMapper.findSaleBackDetailBySaleBackId(saleBackId);
		for(SalSaleBackDetail po : pos){
			bos.add(new SaleBackDetail(po));
		}
		return bos;
	}

	//1.更新销售退货单
	//2.更新退货明细
	//3.记录消费
	//4.变更库存
	//5.库存变更日志
	//6.销售退货汇总
	@Override
	public void doDeal(SaleBack saleBack, SessionOper sessionOper) {
		Date time = new Date();
		SalSaleBack salSaleBack = saleBackMapper.load(saleBack.getSaleBackId());
		salSaleBack.setConfOperId(sessionOper.getOrgId());
		salSaleBack.setConfTime(time);
		salSaleBack.setConfDesc(saleBack.getConfDesc());
		salSaleBack.setStatus(saleBack.getStatus());
		//更新销售退货单
		saleBackMapper.update(salSaleBack);
		
		if("2".equals(saleBack.getStatus())){//SALE_BACK_STATUS(2-已完成)
			
			List<SaleBackDetail> saleBackDetailList = saleBack.getSaleBackDetailList();
			for(SaleBackDetail boDetail : saleBackDetailList){
				
				SalSaleBackDetail poDetail = saleBackDetailMapper.load(boDetail.getSaleBackDetailId());
				poDetail.setProductModel(boDetail.getProductModel());
				poDetail.setProductName(boDetail.getProductName());
				poDetail.setStockQuantity(boDetail.getStockQuantity());
				poDetail.setProviderQuantity(boDetail.getProviderQuantity());
				poDetail.setDestroyQuantity(boDetail.getDestroyQuantity());
				//更新退货明细
				saleBackDetailMapper.update(poDetail);
				
				BalConsume balConsume = new BalConsume();
				balConsume.setOrgId(sessionOper.getOrgId());
				balConsume.setConsumeTime(time);
				balConsume.setBusiType("15");//BUSI_TYPE(15-销售退货)
				balConsume.setProviderProductId(poDetail.getProviderProductId());
				balConsume.setStandard(poDetail.getStandard());
				balConsume.setQuantity(poDetail.getBackQuantity());
				balConsume.setUnitPrice(poDetail.getBackUnitPrice());
				balConsume.setPrice(0- poDetail.getBackQuantity() * poDetail.getBackUnitPrice());
				balConsume.setMemo(poDetail.getBackDesc());
				balConsume.setTargetId(salSaleBack.getConsumerId());
				balConsume.setTargetName(salSaleBack.getConsumerName());
				balConsume.setPaperId(salSaleBack.getSaleBackId());
				balConsume.setPaperNo(salSaleBack.getSaleBackNo());
				balConsume.setTargetLeafId(poDetail.getSaleBackDetailId());
				balConsume.setValidFlag("1");//VALID_FLAG(1-有效)
				//记录消费
				consumeMapper.insert(balConsume);
				
				Stock stock = new Stock();
				stock.setOrgId(sessionOper.getOrgId());
				stock.setProviderProductId(poDetail.getProviderProductId());
				stock.setStandard(poDetail.getStandard());
				stock.setIncTotalQuantity(poDetail.getStockQuantity() + poDetail.getProviderQuantity());//库存总数增加=转入库存+返厂
				stock.setIncLockQuantity(0);
				stock.setIncProviderQuantity(poDetail.getProviderQuantity());
				this.incStock(stock);//变更库存
				
				if(poDetail.getStockQuantity() > 0){
					StoStockChange stoStockChange = new StoStockChange();
					stoStockChange.setOrgId(sessionOper.getOrgId());
					stoStockChange.setProviderProductId(poDetail.getProviderProductId());
					stoStockChange.setStandard(poDetail.getStandard());
					stoStockChange.setChangeTime(time);
					stoStockChange.setChangeQuantity(poDetail.getStockQuantity());
					stoStockChange.setBusiType("15");//BUSI_TYPE(05-销售退货)
					stoStockChange.setTopId(salSaleBack.getSaleBackId());
					stoStockChange.setTargetLeafId(poDetail.getSaleBackDetailId());
					stoStockChange.setChangeAction("1");//STOCK_ACTION(1-增加)
					//记录库存变更日志
					stockChangeMapper.insert(stoStockChange);
				}
				
				//记录销售退货汇总报表
				RptSaleBackColl rptSaleBackColl = new RptSaleBackColl();
				rptSaleBackColl.setOrgId(sessionOper.getOrgId());
				rptSaleBackColl.setSaleBackType(salSaleBack.getSaleBackType());
				rptSaleBackColl.setTransTime(time);
				rptSaleBackColl.setConsumerId(salSaleBack.getConsumerId());
				rptSaleBackColl.setConsumerName(salSaleBack.getConsumerName());
				rptSaleBackColl.setProductModel(poDetail.getProductModel());
				rptSaleBackColl.setProductName(poDetail.getProductName());
				rptSaleBackColl.setStandard(poDetail.getStandard());
				rptSaleBackColl.setQuantity(poDetail.getBackQuantity());
				rptSaleBackColl.setPrice(poDetail.getBackUnitPrice());
				int amount = poDetail.getBackUnitPrice() * poDetail.getBackQuantity();
				rptSaleBackColl.setAmount(amount);
				saleBackCollMapper.insert(rptSaleBackColl);
			}
			
		}
	}

	@Override
	public int searchSaleBackCount(SearchSaleBackVO vo,
			SessionOper sessionOper) {
		
		vo.setOrgId(sessionOper.getOrgId());
		return saleBackMapper.findCountByQC(vo);
		
	}

	@Override
	public List<SaleBack> searchSaleBack(SearchSaleBackVO vo,
			SessionOper sessionOper) {
		List<SaleBack> bos = new ArrayList<SaleBack>();
		
		vo.setOrgId(sessionOper.getOrgId());
		
		List<SalSaleBack> pos = saleBackMapper.findByQC(vo);
		for(SalSaleBack po : pos){
			bos.add(new SaleBack(po));
		}
		return bos;
	}
	
	/**
	 * 对导入的销售订单进行数据合法性校验
	 * @return 有问题的Excel行号
	 */
	@Override
	public Set<Integer> checkSaleImportData(List<String[]> infoList){
		
		Set<Integer> rowSizeSet = new LinkedHashSet<Integer>();
		int i = 2;
		for (String[] arr : infoList) {
			String saleDetailNo = arr[0];//编号
			String productModel = arr[1];//型号
			String productName = arr[2];//产品名
			//String standard = arr[3];//规格
			String unit = arr[4];//单位
			String saleQuantity = arr[5];//订购数量
			String saleUnitPrice = arr[6];//价格
			//String saleDesc = arr[7];//备注
			
			if(StringUtils.isBlank(saleDetailNo)){
				rowSizeSet.add(i);
			}
			
			if(StringUtils.isBlank(productModel)){
				rowSizeSet.add(i);
			}

			if(StringUtils.isBlank(productName)){
				rowSizeSet.add(i);
			}

			if(StringUtils.isBlank(unit)){
				rowSizeSet.add(i);
			}
			
			if(StringUtils.isBlank(saleQuantity)){
				rowSizeSet.add(i);
			}else{
				try {
					Integer.parseInt(saleQuantity);
				} catch (NumberFormatException e) {
					rowSizeSet.add(i);
				}
			}
			
			if(!StringUtils.isBlank(saleUnitPrice)){
				try {
					Double.parseDouble(saleUnitPrice);
				} catch (NumberFormatException e) {
					rowSizeSet.add(i);
				}
			}
			
			i++;
		}
		
	    return rowSizeSet;	
	}
	
	@Override
	public List<SaleImport> buildSaleImportList(List<String[]> infoList, SessionOper sessionOper) {
		List<SaleImport> saleImportList = new ArrayList<SaleImport>();
		
		for (String[] arr : infoList) {
			
			String saleDetailNo = arr[0];
			String productModel = arr[1];
			String productName = arr[2];
			String standard = arr[3];
			String unit = arr[4];
			String saleQuantity = arr[5];
			String saleUnitPrice = arr[6];
			String saleDesc = arr[7];
			
			SaleImport saleImport = new SaleImport();
			saleImport.setSaleDetailNo(saleDetailNo);
			saleImport.setProductModel(productModel);
			saleImport.setProductName(productName);
			saleImport.setStandard(standard);
			saleImport.setUnit(unit);
			saleImport.setSaleQuantity(Integer.parseInt(saleQuantity));
			if(!StringUtils.isBlank(saleUnitPrice)){
				saleImport.setSaleUnitPrice(Integer.parseInt(ParameterUtil.fromY2F(saleUnitPrice)));
			}
			saleImport.setSaleDesc(saleDesc);
			
			saleImportList.add(saleImport);
		}
		return saleImportList;
	}
	
	@Override
	public void importData(List<SaleImport> saleImportList, SessionOper sessionOper) {
    	for(SaleImport saleImport : saleImportList){
			
    		saleImport.setOrgId(sessionOper.getOrgId());
    		saleImport.setOperId(sessionOper.getOperId());
    		
			saleImportMapper.insert(saleImport.getSalSaleImport());
		}
	}

	@Override
	public List<SaleImport> findSaleImport(SessionOper sessionOper) {
		
		List<SaleImport> bos = new ArrayList<SaleImport>();
		List<SalSaleImport> pos = saleImportMapper.findSaleImport(sessionOper);
		for(SalSaleImport po : pos){
			SaleImport bo = new SaleImport(po);
			
			bo.setProductId(ParameterUtil.getMatchSysProductIdInCache(po.getProductModel(), po.getProductName()));
			bos.add(bo);
		}
		
		return bos;
	}
	
	@Override
	public void delImport(SessionOper sessionOper) {
		saleImportMapper.deleteByOper(sessionOper);
	}

	@Override
	public void addSaleByImport(Sale sale, SessionOper sessionOper) {
		ParConsumer parConsumer = consumerMapper.load(sale.getConsumer().getConsumerId());
		SalSale salSale = sale.getSalSale();
		salSale.setOrgId(sessionOper.getOrgId());
		salSale.setSaleType(parConsumer.getConsumerType());//客户类型转化为订单类型
		salSale.setConsumerId(sale.getConsumer().getConsumerId());
		salSale.setConsumerName(sale.getConsumer().getConsumerName());
		salSale.setReceMen(sale.getConsumer().getLinkMan());
		salSale.setReceAddress(sale.getConsumer().getAddress());
		salSale.setLinkPhone(sale.getConsumer().getPhone());
		Integer totalSalePrice = Integer.parseInt(ParameterUtil.fromY2F(sale.getInputTotalSalePrice()));
		salSale.setTotalSalePrice(totalSalePrice);
		salSale.setCreateOperId(sessionOper.getOperId());
		salSale.setCreateTime(new Date());
		salSale.setFinishBakFlag("0"); //FINISH_BAK_FLAG(0-未完成备货)
		if("0".equals(sale.getDepositFlag())){ //DEPOSIT_FLAG(是否收取定金：0-否)
			salSale.setStatus("1");//SALE_STATUS(1-待审核)
		} else {
			salSale.setStatus("7");//SALE_STATUS(7-待收取定金)
		}
		saleMapper.insert(salSale);
		
		List<SaleDetail> saleDetailList = sale.getSaleDetailList();
		for(SaleDetail saleDetail : saleDetailList){
			if(saleDetail.getNo() == null) continue;
			SalSaleDetail salSaleDetail = saleDetail.getSalSaleDetail();
			salSaleDetail.setSaleId(salSale.getSaleId());
			
			Integer saleUnitPrice = null;
			Integer salePrice = null;
			if(saleDetail.getInputSaleUnitPrice() != null){
				saleUnitPrice = Integer.parseInt(ParameterUtil.fromY2F(saleDetail.getInputSaleUnitPrice()));
				salSaleDetail.setSaleUnitPrice(saleUnitPrice);
				
				salePrice = Integer.parseInt(ParameterUtil.fromY2F(saleDetail.getInputSalePrice()));
				salSaleDetail.setSalePrice(salePrice);
			}
			
			salSaleDetail.setRemainBakQuantity(saleDetail.getSaleQuantity());
			
			ProProduct proProduct = new ProProduct();
			proProduct.setOrgId(sessionOper.getOrgId());
			proProduct.setProductModel(salSaleDetail.getProductModel());
			proProduct.setProductName(salSaleDetail.getProductName());
			proProduct.setEngLetter(Cn2Spell.converterToFirstSpell(salSaleDetail.getProductName()));
			proProduct.setUnit(salSaleDetail.getUnit());
			
			ProProduct poProduct = productMapper.getProProduct(proProduct);
			int productId = 0;
			if(poProduct==null){
				productMapper.insertSimple(proProduct);
				
				productId = proProduct.getProductId();
				
				if(!StringUtils.isBlank(salSaleDetail.getStandard())){
					ProStandard proStandard = new ProStandard();
					proStandard.setProductId(productId);
					proStandard.setStandard(salSaleDetail.getStandard());
					standardMapper.insert(proStandard);
				}
				
			}else{
				
				productId = poProduct.getProductId();
				if(!StringUtils.isBlank(salSaleDetail.getStandard())){
					ProStandard proStandard = new ProStandard();
					proStandard.setProductId(productId);
					proStandard.setStandard(salSaleDetail.getStandard());
					ProStandard po = standardMapper.getProStandard(proStandard);
					if(po==null){
						standardMapper.insert(proStandard);
					}
				}
				
			}
			
			salSaleDetail.setProductId(productId);
			saleDetailMapper.insert(salSaleDetail);
		}
	}
	
	@Override
	public int searchPurSaleCount(SearchSaleVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		List<String> statusList = new ArrayList<String>();
		statusList.add("2");
		statusList.add("8");
		vo.setStatusList(statusList);
		
		if(StringUtils.isBlank(vo.getSaleNo())){
			return (Integer)saleMapper.findCountByQCForPur(vo);
		}else{
			return (Integer)saleMapper.findCountBySaleNoForPur(vo);
		}
	}

	@Override
	public List<Sale> searchPurSale(SearchSaleVO vo, SessionOper sessionOper) {
		List<Sale> bos = new ArrayList<Sale>();
		vo.setOrgId(sessionOper.getOrgId());
		List<String> statusList = new ArrayList<String>();
		statusList.add("2");
		statusList.add("8");
		vo.setStatusList(statusList);
		
		List<SalSale> pos = null;
		if(StringUtils.isBlank(vo.getSaleNo())){
			pos = saleMapper.findByQCForPur(vo);
		} else {
			pos = saleMapper.findBySaleNoForPur(vo);
		}
		for(SalSale po : pos){
			bos.add(new Sale(po));
		}
		return bos;
	}

	@Override
	public SaleDetail getSaleDetailForPur(int saleDetailId) {
		SalSaleDetail salSaleDetail = saleDetailMapper.getSaleDetailForPur(saleDetailId);
		return new SaleDetail(salSaleDetail);
	}

	@Override
	public List<ProviderProduct> findPurchasePlan(SaleDetail saleDetail,
			SessionOper sessionOper) {
		
		List<ProviderProduct> bos = new ArrayList<ProviderProduct>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", sessionOper.getOrgId());
		paramMap.put("productId", saleDetail.getProductId());
		
		List<ProProviderProduct> pos = providerProductMapper.findProviderProductForPur(paramMap);
		for(ProProviderProduct po : pos){
			bos.add(new ProviderProduct(po));
		}
		
		return bos;
	}
	
	@Override
	public List<SaleDetail> findSaleDetailForPur(int saleId) {
		List<SaleDetail> bos = new ArrayList<SaleDetail>();
		List<SalSaleDetail> pos = saleDetailMapper.findSaleDetailBySaleId(saleId);
		
		List<Integer> productIdList = new ArrayList<Integer>();
		for(SalSaleDetail po : pos){
			productIdList.add(po.getProductId());
		}
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("productIdList", productIdList);
		List<StoStock> stoStockList = stockMapper.findForPur(paramMap);
		Map<String, Integer> stoStockMap = new HashMap<String, Integer>();
		for(StoStock stoStock : stoStockList){
			stoStockMap.put(stoStock.getProductId()+"-"+stoStock.getStandard(), stoStock.getSumCanUseQuantity());
		}
		
		for(SalSaleDetail po : pos){
			SaleDetail bo = new SaleDetail();
			if(stoStockMap.containsKey(po.getProductId()+"-"+po.getStandard())){
				bo.setCanUseQuantity(stoStockMap.get(po.getProductId()+"-"+po.getStandard()));
			}else{
				bo.setCanUseQuantity(0);
			}
			bo.setSalSaleDetail(po);
			bos.add(bo);
		}
		
		return bos;
	}

}
