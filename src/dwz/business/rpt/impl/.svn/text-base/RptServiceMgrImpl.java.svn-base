package dwz.business.rpt.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.account.Trans;
import dwz.business.common.SessionOper;
import dwz.business.rpt.ProfitColl;
import dwz.business.rpt.PurchaseColl;
import dwz.business.rpt.RptServiceMgr;
import dwz.business.rpt.SaleBackColl;
import dwz.business.rpt.SaleColl;
import dwz.business.rpt.SearchCostCollVO;
import dwz.business.rpt.SearchProfitCollVO;
import dwz.business.rpt.SearchPurchaseCollVO;
import dwz.business.rpt.SearchSaleBackCollVO;
import dwz.business.rpt.SearchSaleCollVO;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.AccTrans;
import dwz.persistence.beans.RptProfitColl;
import dwz.persistence.beans.RptPurchaseColl;
import dwz.persistence.beans.RptSaleBackColl;
import dwz.persistence.beans.RptSaleColl;
import dwz.persistence.mapper.ProfitCollMapper;
import dwz.persistence.mapper.PurchaseCollMapper;
import dwz.persistence.mapper.SaleBackCollMapper;
import dwz.persistence.mapper.SaleCollMapper;
import dwz.persistence.mapper.TransMapper;

@Transactional(rollbackFor = Exception.class)
@Service("rptServiceMgr")
public class RptServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements RptServiceMgr {
	
	@Autowired
	private SaleCollMapper saleCollMapper;
	@Autowired
	private PurchaseCollMapper purchaseCollMapper;
	@Autowired
	private TransMapper transMapper;
	@Autowired
	private ProfitCollMapper profitCollMapper;
	@Autowired
	private SaleBackCollMapper saleBackCollMapper;

	@Override
	public List<SaleColl> searchSaleColl(SearchSaleCollVO vo,
			SessionOper sessionOper) {
		
		vo.setOrgId(sessionOper.getOrgId());
		List<SaleColl> bos = new ArrayList<SaleColl>();
		List<RptSaleColl> pos = saleCollMapper.findByQC(vo);
		for(RptSaleColl po : pos){
			bos.add(new SaleColl(po));
		}
		return bos;
	}

	@Override
	public List<SaleColl> searchSaleCollDetail(int orgId, String transDate,
			int consumerId) {
		
		List<SaleColl> bos = new ArrayList<SaleColl>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", orgId);
		paramMap.put("transDate", transDate);
		paramMap.put("consumerId", consumerId);
		List<RptSaleColl> pos = saleCollMapper.findDetail(paramMap);
		for(RptSaleColl po : pos){
			bos.add(new SaleColl(po));
		}
		return bos;
	}

	@Override
	public List<PurchaseColl> searchPurchaseColl(SearchPurchaseCollVO vo,
			SessionOper sessionOper) {
		
		vo.setOrgId(sessionOper.getOrgId());
		List<PurchaseColl> bos = new ArrayList<PurchaseColl>();
		List<RptPurchaseColl> pos = purchaseCollMapper.findByQC(vo);
		for(RptPurchaseColl po : pos){
			bos.add(new PurchaseColl(po));
		}
		return bos;
	}
	
	@Override
	public List<PurchaseColl> searchPurchaseCollDetail(int orgId, String transDate,
			int providerId) {
		
		List<PurchaseColl> bos = new ArrayList<PurchaseColl>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", orgId);
		paramMap.put("transDate", transDate);
		paramMap.put("providerId", providerId);
		List<RptPurchaseColl> pos = purchaseCollMapper.findDetail(paramMap);
		for(RptPurchaseColl po : pos){
			bos.add(new PurchaseColl(po));
		}
		return bos;
	}

	@Override
	public List<Trans> searchCostColl(SearchCostCollVO vo,
			SessionOper sessionOper) {
		
		vo.setOrgId(sessionOper.getOrgId());
		List<Trans> bos = new ArrayList<Trans>();
		List<AccTrans> pos = transMapper.findCostColl(vo);
		for(AccTrans po : pos){
			bos.add(new Trans(po));
		}
		
		return bos;
	}

	@Override
	public List<Trans> searchCostCollDetail(int orgId, String transDate,
			String transItem, String transDire) {
		
		List<Trans> bos = new ArrayList<Trans>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", orgId);
		paramMap.put("busiType", "12");
		paramMap.put("transDate", transDate);
		paramMap.put("transItem", transItem);
		paramMap.put("transDire", transDire);
		List<AccTrans> pos = transMapper.findCostCollDetail(paramMap);
		for(AccTrans po : pos){
			bos.add(new Trans(po));
		}
		
		return bos;
	}
	
	@Override
	public List<ProfitColl> searchProfitColl(SearchProfitCollVO vo,
			SessionOper sessionOper) {
		
		vo.setOrgId(sessionOper.getOrgId());
		List<ProfitColl> bos = new ArrayList<ProfitColl>();
		List<RptProfitColl> pos = profitCollMapper.findByQC(vo);
		for(RptProfitColl po : pos){
			bos.add(new ProfitColl(po));
		}
		return bos;
	}
	
	@Override
	public List<ProfitColl> searchProfitCollDetail(int orgId, String transDate,
			int consumerId) {
		
		List<ProfitColl> bos = new ArrayList<ProfitColl>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", orgId);
		paramMap.put("transDate", transDate);
		paramMap.put("consumerId", consumerId);
		List<RptProfitColl> pos = profitCollMapper.findDetail(paramMap);
		for(RptProfitColl po : pos){
			bos.add(new ProfitColl(po));
		}
		return bos;
	}

	@Override
	public List<SaleBackColl> searchSaleBackColl(SearchSaleBackCollVO vo,
			SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		List<SaleBackColl> bos = new ArrayList<SaleBackColl>();
		List<RptSaleBackColl> pos = saleBackCollMapper.findByQC(vo);
		for(RptSaleBackColl po : pos){
			bos.add(new SaleBackColl(po));
		}
		return bos;
	}

	@Override
	public List<SaleBackColl> searchSaleBackCollDetail(int orgId,
			String transDate, int consumerId) {
		List<SaleBackColl> bos = new ArrayList<SaleBackColl>();
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("orgId", orgId);
		paramMap.put("transDate", transDate);
		paramMap.put("consumerId", consumerId);
		List<RptSaleBackColl> pos = saleBackCollMapper.findDetail(paramMap);
		for(RptSaleBackColl po : pos){
			bos.add(new SaleBackColl(po));
		}
		return bos;
	}

}
