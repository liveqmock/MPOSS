package dwz.business.common.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.AutocompleteServiceMgr;
import dwz.business.common.SessionOper;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.ParConsumer;
import dwz.persistence.beans.ParProvider;
import dwz.persistence.beans.ProProduct;
import dwz.persistence.mapper.ConsumerMapper;
import dwz.persistence.mapper.ProductMapper;
import dwz.persistence.mapper.ProviderMapper;

@Transactional(rollbackFor = Exception.class)
@Service("autocompleteServiceMgr")
public class AutocompleteServiceMgrImpl extends
		AbstractBusinessObjectServiceMgr implements AutocompleteServiceMgr {
	
	@Autowired
	private ConsumerMapper consumerMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProviderMapper providerMapper;

	@Override
	public List<ParConsumer> loadConsumer(SessionOper sessionOper) {
		return consumerMapper.loadConsumer(sessionOper.getOrgId());
	}
	
	@Override
	public List<ParProvider> loadProvider(SessionOper sessionOper) {
		return providerMapper.loadProvider(sessionOper.getOrgId());
	}

	@Override
	public List<String> loadProductModel(SessionOper sessionOper) {
		return productMapper.loadProductModel(sessionOper.getOrgId());
	}
	
	@Override
	public List<ProProduct> loadProductName(SessionOper sessionOper) {
		return productMapper.loadProductName(sessionOper.getOrgId());
	}

	@Override
	public List<ProProduct> loadProduct(SessionOper sessionOper) {
		return productMapper.loadProduct(sessionOper.getOrgId());
	}

}
