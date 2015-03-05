package dwz.business.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.LookupServiceMgr;
import dwz.business.common.SessionOper;
import dwz.business.goods.Product;
import dwz.business.partner.Provider;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.ParProvider;
import dwz.persistence.beans.ProProduct;
import dwz.persistence.mapper.ProductMapper;
import dwz.persistence.mapper.ProviderMapper;

@Transactional(rollbackFor = Exception.class)
@Service("lookupServiceMgr")
public class LookupServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements LookupServiceMgr {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProviderMapper providerMapper;

	@Override
	public List<Product> lookupProduct(SessionOper sessionOper) {
		List<Product> bos = new ArrayList<Product>();
		List<ProProduct> pos = productMapper.loadProduct(sessionOper.getOrgId());
		for(ProProduct po : pos){
			bos.add(new Product(po));
		}
		return bos;
	}
	
	@Override
	public List<Provider> lookupProvider(SessionOper sessionOper) {
		List<Provider> bos = new ArrayList<Provider>();
		List<ParProvider> pos = providerMapper.loadProvider(sessionOper.getOrgId());
		for(ParProvider po : pos){
			bos.add(new Provider(po));
		}
		return bos;
	}

}
