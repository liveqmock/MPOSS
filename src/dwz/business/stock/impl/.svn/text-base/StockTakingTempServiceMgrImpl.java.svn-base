package dwz.business.stock.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.stock.StockTakingTemp;
import dwz.business.stock.StockTakingTempServiceMgr;
import dwz.business.stock.StockTakingTempVO;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.StoStockTakingTemp;
import dwz.persistence.mapper.OrgMapper;
import dwz.persistence.mapper.StockTakingTempMapper;

@Transactional(rollbackFor = Exception.class)
@Service("stockTakingTempServiceMgr")
public class StockTakingTempServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements StockTakingTempServiceMgr {
	
	@Autowired
	private StockTakingTempMapper stockTakingTempMapper;
	@Autowired
	private OrgMapper orgMapper;
	
	@Override
	public void insertTemp(StockTakingTempVO vo, SessionOper sessionOper) {
		
		List<Integer> providerProductIdList = stockTakingTempMapper.findProviderProductId(sessionOper.getOrgId());
		
		for(StockTakingTemp stockTakingTemp : vo.getStockTakingTempList()){
			int canUseQuantity = stockTakingTemp.getTotalQuantity() - stockTakingTemp.getLockQuantity();
			if(stockTakingTemp.getTakingQuantity() == null) continue;
			int takingQuantity = stockTakingTemp.getTakingQuantity();
			if(canUseQuantity == takingQuantity) continue; //没盘点的过滤掉
			
			StoStockTakingTemp stoStockTakingTemp = stockTakingTemp.getStoStockTakingTemp();
			stoStockTakingTemp.setOrgId(sessionOper.getOrgId());
			
			if(providerProductIdList.contains(stockTakingTemp.getProviderProductId())){ //已在盘点临时表的，则进行更新
				stockTakingTempMapper.update(stoStockTakingTemp);
			}else{//否则进行插入
				stockTakingTempMapper.insert(stoStockTakingTemp);
			}
			
		}
		
		orgMapper.openTakingSwitch(sessionOper.getOrgId());
		
	}

	@Override
	public List<StockTakingTemp> searchStockTakingTemp(SessionOper sessionOper) {
		
		List<StockTakingTemp> bos = new ArrayList<StockTakingTemp>();
		List<StoStockTakingTemp> pos = stockTakingTempMapper.findByOrg(sessionOper.getOrgId());
		for(StoStockTakingTemp po : pos){
			bos.add(new StockTakingTemp(po));
		}
		return bos;
	}

	@Override
	public void del(int stockTakingTempId) {
		stockTakingTempMapper.delete(stockTakingTempId);
	}
	
}
