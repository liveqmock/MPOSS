package dwz.business.goods.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.goods.AddProviderProductVO;
import dwz.business.goods.ProviderProduct;
import dwz.business.goods.ProviderProductServiceMgr;
import dwz.business.goods.ProviderProductVO;
import dwz.business.goods.SearchProviderProductVO;
import dwz.common.util.ParameterUtil;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.ProProduct;
import dwz.persistence.beans.ProProviderProduct;
import dwz.persistence.beans.PurPurchasePrice;
import dwz.persistence.beans.StoStock;
import dwz.persistence.mapper.ProductMapper;
import dwz.persistence.mapper.ProviderProductMapper;
import dwz.persistence.mapper.PurchasePriceMapper;
import dwz.persistence.mapper.StockMapper;

@Transactional(rollbackFor = Exception.class)
@Service("providerProductServiceMgr")
public class ProviderProductServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements ProviderProductServiceMgr {
	
	@Autowired
	private ProviderProductMapper providerProductMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private StockMapper stockMapper;
	@Autowired
	private PurchasePriceMapper purchasePriceMapper;
	
	@Override
	public int searchProviderProductCount(SearchProviderProductVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return (Integer)providerProductMapper.findCountByQC(vo);
	}

	@Override
	public List<ProviderProduct> searchProviderProduct(SearchProviderProductVO vo, SessionOper sessionOper) {
		List<ProviderProduct> bos = new ArrayList<ProviderProduct>();
		vo.setOrgId(sessionOper.getOrgId());
		List<ProProviderProduct> pos = providerProductMapper.findByQC(vo);
		for(ProProviderProduct po : pos){
			bos.add(new ProviderProduct(po));
		}
		return bos;
	}
	
	@Override
	public int searchJoinProviderProductCount(SearchProviderProductVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return (Integer)providerProductMapper.findJoinCountByQC(vo);
	}

	@Override
	public List<ProviderProduct> searchJoinProviderProduct(SearchProviderProductVO vo, SessionOper sessionOper) {
		List<ProviderProduct> bos = new ArrayList<ProviderProduct>();
		vo.setOrgId(sessionOper.getOrgId());
		List<ProProviderProduct> pos = providerProductMapper.findJoinByQC(vo);
		for(ProProviderProduct po : pos){
			bos.add(new ProviderProduct(po));
		}
		return bos;
	}

	@Override
	public void addProviderProduct(AddProviderProductVO vo,
			SessionOper sessionOper) {
		
		for(ProviderProductVO innerVo : vo.getProviderProductVOList()){
			
			if(innerVo.getProductId()==null) continue;
			ProProduct proProduct = productMapper.load(innerVo.getProductId());
			ProProviderProduct proProviderProduct = new ProProviderProduct();
			proProviderProduct.setOrgId(sessionOper.getOrgId());
			proProviderProduct.setProductId(innerVo.getProductId());
			proProviderProduct.setProductModel(proProduct.getProductModel());
			proProviderProduct.setProductName(proProduct.getProductName());
			proProviderProduct.setProductEngName(proProduct.getProductEngName());
			proProviderProduct.setPic(proProduct.getPic());
			proProviderProduct.setUnit(proProduct.getUnit());
			proProviderProduct.setProviderId(innerVo.getProviderId());
			proProviderProduct.setProviderName(innerVo.getProviderName());
			Integer unitPrice = Integer.parseInt(ParameterUtil.fromY2F(innerVo.getInputUnitPrice()));
			proProviderProduct.setUnitPrice(unitPrice);
			
			providerProductMapper.insert(proProviderProduct);
			
			StoStock stoStock = new StoStock();
			stoStock.setOrgId(sessionOper.getOrgId());
			stoStock.setProviderProductId(proProviderProduct.getProviderProductId());
			stoStock.setStandard("");
			stoStock.setTotalQuantity(0);
			stoStock.setLockQuantity(0);
			stoStock.setProviderQuantity(0);
			stockMapper.insert(stoStock);
			
			PurPurchasePrice purPurchasePrice = new PurPurchasePrice();
			purPurchasePrice.setProviderProductId(proProviderProduct.getProviderProductId());
			purPurchasePrice.setProviderId(innerVo.getProviderId());
			purPurchasePrice.setProductId(innerVo.getProductId());
			purPurchasePrice.setStandard("");
			purPurchasePrice.setUnitPrice(unitPrice);
			purchasePriceMapper.insert(purPurchasePrice);
			
		}
	}

	@Override
	public List<String> searchProviderProductForRepeatCheck(
			SessionOper sessionOper) {
		
		List<String> resultList = new ArrayList<String>();
		List<ProProviderProduct> list = providerProductMapper.findForRepeatCheck(sessionOper.getOrgId());
		for(ProProviderProduct po : list){
			resultList.add(po.getProviderId() +"-"+ po.getProductId());
		}
		return resultList;
	}

	@Override
	public ProviderProduct getProviderProduct(int providerProductId) {
		ProProviderProduct po = providerProductMapper.load(providerProductId);
		return new ProviderProduct(po);
	}

	@Override
	public void upd(ProviderProduct providerProduct, SessionOper sessionOper) {
		providerProduct.setOrgId(sessionOper.getOrgId());
		int unitPrice = Integer.parseInt(ParameterUtil.fromY2F(providerProduct.getInputUnitPrice()));
		providerProduct.setUnitPrice(unitPrice);
		providerProductMapper.update(providerProduct.getProProviderProduct());
	}

	@Override
	public int getProviderProductCount(int productId) {
		return providerProductMapper.getProviderProductCount(productId);
	}

	@Override
	public void del(int providerProductId) {
		//删除厂家产品
		providerProductMapper.delete(providerProductId);
		//删除库存
		stockMapper.deleteByProvProd(providerProductId);
		//删除价格数据
		purchasePriceMapper.deleteByProvProd(providerProductId);
	}

}
