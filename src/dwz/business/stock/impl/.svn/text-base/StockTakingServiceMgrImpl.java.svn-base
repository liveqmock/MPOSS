package dwz.business.stock.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.stock.SearchStockTakingVO;
import dwz.business.stock.Stock;
import dwz.business.stock.StockTaking;
import dwz.business.stock.StockTakingDetail;
import dwz.business.stock.StockTakingServiceMgr;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.ProProviderProduct;
import dwz.persistence.beans.PurPurchasePrice;
import dwz.persistence.beans.StoStock;
import dwz.persistence.beans.StoStockChange;
import dwz.persistence.beans.StoStockTaking;
import dwz.persistence.beans.StoStockTakingDetail;
import dwz.persistence.mapper.OrgMapper;
import dwz.persistence.mapper.ProviderProductMapper;
import dwz.persistence.mapper.PurchasePriceMapper;
import dwz.persistence.mapper.StockChangeMapper;
import dwz.persistence.mapper.StockMapper;
import dwz.persistence.mapper.StockTakingDetailMapper;
import dwz.persistence.mapper.StockTakingMapper;
import dwz.persistence.mapper.StockTakingTempMapper;

@Transactional(rollbackFor = Exception.class)
@Service("stockTakingServiceMgr")
public class StockTakingServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements StockTakingServiceMgr {
	
	@Autowired
	private StockTakingMapper stockTakingMapper;
	@Autowired
	private StockTakingDetailMapper stockTakingDetailMapper;
	@Autowired
	private StockMapper stockMapper;
	@Autowired
	private StockChangeMapper stockChangeMapper;
	@Autowired
	private StockTakingTempMapper stockTakingTempMapper;
	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private ProviderProductMapper providerProductMapper;
	@Autowired
	private PurchasePriceMapper purchasePriceMapper;
	
	@Override
	public int searchStockTakingCount(SearchStockTakingVO vo,
			SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		
		if(StringUtils.isBlank(vo.getStockTakingNo())){
			return (Integer)stockTakingMapper.findCountByQC(vo);
		}else{
			return (Integer)stockTakingMapper.findCountByNo(vo);
		}
	}

	@Override
	public List<StockTaking> searchStockTaking(SearchStockTakingVO vo,
			SessionOper sessionOper) {
		List<StockTaking> bos = new ArrayList<StockTaking>();
		vo.setOrgId(sessionOper.getOrgId());
		
		List<StoStockTaking> pos = null;
		if(StringUtils.isBlank(vo.getStockTakingNo())){
			pos = stockTakingMapper.findByQC(vo);
		}else{
			pos = stockTakingMapper.findByNo(vo);
		}
		for(StoStockTaking po : pos){
			bos.add(new StockTaking(po));
		}
		
		return bos;
	}

	@Override
	public List<StockTakingDetail> searchStockTakingDetailByStockTakingId(
			int stockTakingId) {
		
		
		List<StockTakingDetail> bos = new ArrayList<StockTakingDetail>();
		
		List<StoStockTakingDetail> pos = stockTakingDetailMapper.findByStockTakingIdForShow(stockTakingId);
		for(StoStockTakingDetail po : pos){
			bos.add(new StockTakingDetail(po));
		}
		
		return bos;
		
	}

	@Override
	public List<StockTaking> searchStockTakingForConf(SessionOper sessionOper) {
		
		StoStockTaking stoStockTaking = new StoStockTaking();
		stoStockTaking.setOrgId(sessionOper.getOrgId());
		stoStockTaking.setStatus("1"); //STOCK_TAKING_STATUS (1-新盘点单)
		
		List<StockTaking> bos = new ArrayList<StockTaking>();
		
		List<StoStockTaking> pos = stockTakingMapper.findForConf(stoStockTaking);
		for(StoStockTaking po : pos){
			bos.add(new StockTaking(po));
		}
		
		return bos;
	}

	@Override
	public StockTaking getStockTakingById(int stockTakingId) {
		StoStockTaking po = stockTakingMapper.load(stockTakingId);
		return new StockTaking(po);
	}

	@Override
	public void doConf(StockTaking stockTaking, SessionOper sessionOper) {
		StoStockTaking stoStockTaking = stockTaking.getStoStockTaking();
		stoStockTaking.setOrgId(sessionOper.getOrgId());
		stoStockTaking.setConfOperId(sessionOper.getOperId());
		stoStockTaking.setConfTime(new Date());
		stockTakingMapper.update(stoStockTaking);//更新变更单状态
		
		if("2".equals(stockTaking.getStatus())){ //STOCK_TAKING_STATUS (2-盘库成功)
			List<StoStockTakingDetail> detailList = stockTakingDetailMapper.findByStockTakingId(stockTaking.getStockTakingId());
			for(StoStockTakingDetail detail : detailList) {
				int providerProductId = detail.getProviderProductId();
				int beforeTakingQuantity = detail.getTotalQuantity() - detail.getLockQuantity();
				int afterTakingQuantity = detail.getTakingQuantity();
				
				if(beforeTakingQuantity == afterTakingQuantity) continue; //盘点前和盘点后数量一致的，就不盘点了。实际上由前面盘点登记业务把关，这种情况也不会记录下来的。这里谨慎一些，还是判断一下
				
				int changeQuantity = afterTakingQuantity - beforeTakingQuantity;
				
				//start 更新库存
				Stock stock = new Stock();
				stock.setOrgId(sessionOper.getOrgId());
				stock.setProviderProductId(providerProductId);
				stock.setStandard(detail.getStandard());
				stock.setChangeQuantity(changeQuantity);
				
				StoStock stoStock = stockMapper.findOneStock(stock);
				if(stoStock == null){//盘的是库存不存在的厂家产品,
					//插入库存
					stockMapper.insertByTaking(stock); 
					
					//同时记录本厂家产品末次采购价格(忽略规格，直接记录为配置价格)
					ProProviderProduct proProviderProduct = providerProductMapper.load(providerProductId);
					PurPurchasePrice purPurchasePrice = new PurPurchasePrice();
					purPurchasePrice.setProviderProductId(providerProductId);
					purPurchasePrice.setProviderId(proProviderProduct.getProviderId());
					purPurchasePrice.setProductId(proProviderProduct.getProductId());
					purPurchasePrice.setStandard(detail.getStandard());
					purPurchasePrice.setUnitPrice(proProviderProduct.getUnitPrice());
					purchasePriceMapper.insert(purPurchasePrice);
				}else{
					stockMapper.updateStockByTaking(stock);//更新库存
				}
				
				//end 更新库存
				
				// start 记录库存变更日志
				StoStockChange stoStockChange = new StoStockChange();
				stoStockChange.setOrgId(sessionOper.getOrgId());
				stoStockChange.setProviderProductId(providerProductId);
				stoStockChange.setStandard(detail.getStandard());
				stoStockChange.setChangeTime(new Date());
				String changeAction = "";
				if(afterTakingQuantity - beforeTakingQuantity > 0){
					changeAction = "1"; // STOCK_CHANGE_ACTION (1-增加)
				} else {
					changeAction = "2"; // STOCK_CHANGE_ACTION (2-减少)
				}
				stoStockChange.setChangeAction(changeAction);
				stoStockChange.setChangeQuantity(Math.abs(changeQuantity));
				stoStockChange.setBusiType("02"); // BUSI_TYPE (02-库存盘点)
				stoStockChange.setTopId(stoStockTaking.getStockTakingId());
				stoStockChange.setTargetLeafId(detail.getStockTakingDetailId());
				
				stockChangeMapper.insert(stoStockChange);
				//end 记录库存变更日志
				
			}
		}
		
		//最后检查是否需要关闭盘库开关
		orgMapper.closeTakingSwitch(sessionOper.getOrgId());
	}

	@Override
	public void insert(StockTaking stockTaking, SessionOper sessionOper) {
		
		StoStockTaking stoStockTaking = stockTaking.getStoStockTaking();
		stoStockTaking.setOrgId(sessionOper.getOrgId());
		stoStockTaking.setRegOperId(sessionOper.getOperId());
		stoStockTaking.setRegTime(new Date());
		stoStockTaking.setStatus("1"); //STOCK_TAKING_STATUS (1-新创建)
		
		stockTakingMapper.insert(stoStockTaking);
		
		List<StockTakingDetail> stockTakingDetailList = stockTaking.getStockTakingDetailList();
		for(StockTakingDetail detail : stockTakingDetailList){
			
			StoStockTakingDetail stoStockTakingDetail = detail.getStoStockTakingDetail();
			stoStockTakingDetail.setStockTakingId(stoStockTaking.getStockTakingId());
			stockTakingDetailMapper.insert(stoStockTakingDetail);
			
		}
		
		stockTakingTempMapper.deleteByOrg(sessionOper.getOrgId());
	}

}
