package dwz.business.common.impl;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.CacheServiceMgr;
import dwz.common.util.ParameterUtil;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.AccBank;
import dwz.persistence.beans.SysOper;
import dwz.persistence.beans.SysProduct;
import dwz.persistence.beans.SysResource;
import dwz.persistence.mapper.BankMapper;
import dwz.persistence.mapper.OperMapper;
import dwz.persistence.mapper.ResourceMapper;
import dwz.persistence.mapper.SysProductMapper;

@Transactional(rollbackFor = Exception.class)
@Service("cacheServiceMgr")
public class CacheServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements CacheServiceMgr {
	
	@Autowired
	private BankMapper bankMapper;
	@Autowired
	private OperMapper operMapper;
	@Autowired
	private ResourceMapper resourceMapper;
	@Autowired
	private SysProductMapper sysProductMapper;
	
	public void cacheAll(){
		cacheBank();
		cacheOper();
		cacheResource();
	}
	
	public void cacheBank(){
		List<AccBank> pos = bankMapper.findForCache();
		for(AccBank po : pos){
			ParameterUtil.cacheColumnData("ACC_BANK.BANK_NAME", String.valueOf(po.getBankId()), po.getBankName());
		}
	}
	
	public void cacheOper(){
		List<SysOper> pos = operMapper.findForCache();
		for(SysOper po : pos){
			ParameterUtil.cacheColumnData("SYS_OPER.REAL_NAME", String.valueOf(po.getOperId()), po.getRealName());
		}
	}
	
	public void cacheResource(){
		List<SysResource> pos = resourceMapper.findForCache();
		for(SysResource po : pos){
			ParameterUtil.cacheColumnData("SYS_RESOURCE.RESOURCE_NAME", String.valueOf(po.getResourceId()), po.getResourceName());
			ParameterUtil.cacheResourceUrl(po.getResourceUrl());
			if("1".equals(po.getResourceType())){ //RESOURCE_TYPE(1-外部资源)
				ParameterUtil.cacheOuterResourceData(po.getParentResourceId(), po.getResourceId());
			}
		}
	}

	@Override
	public void cacheColumnData() {
		cacheAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void cacheConstantData() {
		
		Map<String, Map<String, String>> constantCache = ParameterUtil.getConstantCache();
		constantCache.clear();
		
		String constantFilePath = (CacheServiceMgrImpl.class.getResource("/").getPath()).replace("classes/", "")+"etc/conf/constant.xml";
		try {
			Document doc = new SAXReader().read(constantFilePath);
			Element rootEle = doc.getRootElement();
			List<Element> constantEleList = rootEle.elements();
			for(Element constantEle : constantEleList){
				String constantDef = constantEle.attributeValue("constantDef");
				List<Element> constantNameEleList = constantEle.elements();
				
				for(Element constantNameEle : constantNameEleList){
					String constantValue = constantNameEle.attributeValue("value");
					String constantName = constantNameEle.getText();
					
					ParameterUtil.cacheConstantData(constantDef, constantValue, constantName);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cacheSysProductData() {
		List<SysProduct> pos = sysProductMapper.findForCache();
		for(SysProduct po : pos){
			ParameterUtil.cacheMatchSysProductData(po.getProductId(), po.getProductModel(), po.getProductName());
			ParameterUtil.cacheSysProductData(po);
		}
	}
	
}
