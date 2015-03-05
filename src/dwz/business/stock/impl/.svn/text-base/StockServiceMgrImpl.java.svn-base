package dwz.business.stock.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.stock.SearchStockChangeVO;
import dwz.business.stock.SearchStockVO;
import dwz.business.stock.Stock;
import dwz.business.stock.StockChange;
import dwz.business.stock.StockLock;
import dwz.business.stock.StockServiceMgr;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.StoStock;
import dwz.persistence.beans.StoStockChange;
import dwz.persistence.beans.StoStockLock;
import dwz.persistence.mapper.StockChangeMapper;
import dwz.persistence.mapper.StockLockMapper;
import dwz.persistence.mapper.StockMapper;

@Transactional(rollbackFor = Exception.class)
@Service("stockServiceMgr")
public class StockServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements StockServiceMgr {
	
	@Autowired
	private StockMapper stockMapper;
	@Autowired
	private StockLockMapper stockLockMapper;
	@Autowired
	private StockChangeMapper stockChangeMapper;
	
	@Override
	public int searchMergeStockCount(SearchStockVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return (Integer)stockMapper.findMergeCountByQC(vo);
	}

	@Override
	public List<Stock> searchMergeStock(SearchStockVO vo, SessionOper sessionOper) {
		List<Stock> bos = new ArrayList<Stock>();
		vo.setOrgId(sessionOper.getOrgId());
		List<StoStock> pos = stockMapper.findMergeByQC(vo);
		for(StoStock po : pos){
			bos.add(new Stock(po));
		}
		return bos;
	}

	@Override
	public int searchStockCountForTaking(SearchStockVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return (Integer)stockMapper.findCountForTakingByQC(vo);
	}

	@Override
	public List<Stock> searchStockForTaking(SearchStockVO vo, SessionOper sessionOper) {
		List<Stock> bos = new ArrayList<Stock>();
		vo.setOrgId(sessionOper.getOrgId());
		List<StoStock> pos = stockMapper.findForTakingByQC(vo);
		for(StoStock po : pos){
			bos.add(new Stock(po));
		}
		return bos;
	}
	
	@Override
	public List<StockLock> searchStockLock(int providerProductId) {
		List<StockLock> bos = new ArrayList<StockLock>();
		List<StoStockLock> pos = stockLockMapper.findByProviderProductId(providerProductId);
		for(StoStockLock po : pos){
			bos.add(new StockLock(po));
		}
		return bos;
	}

	@Override
	public int searchStockChangeCount(SearchStockChangeVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return (Integer)stockChangeMapper.findCountByQC(vo);
	}

	@Override
	public List<StockChange> searchStockChange(SearchStockChangeVO vo, SessionOper sessionOper) {
		List<StockChange> bos = new ArrayList<StockChange>();
		vo.setOrgId(sessionOper.getOrgId());
		List<StoStockChange> pos = stockChangeMapper.findByQC(vo);
		for(StoStockChange po : pos){
			bos.add(new StockChange(po));
		}
		return bos;
	}

	@Override
	public List<Stock> searchStock(int providerProductId) {
		List<Stock> bos = new ArrayList<Stock>();
		List<StoStock> pos = stockMapper.findByProviderProductId(providerProductId);
		for(StoStock po : pos){
			bos.add(new Stock(po));
		}
		return bos;
	}

	@Override
	public int getQuantityForProvProd(int providerProductId) {
		return stockMapper.getQuantityForProvProd(providerProductId);
	}


}
