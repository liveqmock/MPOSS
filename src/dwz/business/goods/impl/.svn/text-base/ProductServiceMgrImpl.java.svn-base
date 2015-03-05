package dwz.business.goods.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.goods.Product;
import dwz.business.goods.ProductServiceMgr;
import dwz.business.sale.SearchProductVO;
import dwz.common.util.Cn2Spell;
import dwz.common.util.StringUtils;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.ProProduct;
import dwz.persistence.mapper.ProductMapper;
import dwz.persistence.mapper.ProviderProductMapper;

@Transactional(rollbackFor = Exception.class)
@Service("productServiceMgr")
public class ProductServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements ProductServiceMgr {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProviderProductMapper providerProductMapper;

	@Override
	public int searchProductCount(SearchProductVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		int count = productMapper.findCountByQC(vo);
		return count;
	}

	@Override
	public List<Product> searchProduct(SearchProductVO vo,
			SessionOper sessionOper) {
		List<Product> bos = new ArrayList<Product>();
		vo.setOrgId(sessionOper.getOrgId());
		List<ProProduct> pos = productMapper.findByQC(vo);
		for (ProProduct po : pos) {
			bos.add(new Product(po));
		}
		return bos;
	}

	@Override
	public void addProduct(Product product, SessionOper sessionOper) {
		ProProduct proProduct = product.getProProduct();
		proProduct.setOrgId(sessionOper.getOrgId());
		proProduct.setEngLetter(Cn2Spell.converterToFirstSpell(proProduct.getProductName()));
		productMapper.insert(proProduct);
	}

	@Override
	public void updPic(int productId, String pic) {
		ProProduct proProduct = new ProProduct();
		proProduct.setProductId(productId);
		proProduct.setPic(pic);
		productMapper.updatePic(proProduct);
		providerProductMapper.updatePic(proProduct);
	}

	@Override
	public Product getProduct(int productId) {
		ProProduct po = productMapper.load(productId);
		return new Product(po);
	}

	@Override
	public void upd(Product product, SessionOper sessionOper) {
		product.setOrgId(sessionOper.getOrgId());
		productMapper.update(product.getProProduct());
		providerProductMapper.updateByProductUpd(product.getProProduct());
	}

	@Override
	public ProProduct getProProduct(ProProduct proProduct,
			SessionOper sessionOper) {
		proProduct.setOrgId(sessionOper.getOrgId());
		return productMapper.getProProduct(proProduct);
	}

	@Override
	public void del(int productId) {
		productMapper.delete(productId);
	}
	
	@Override
	public List<Product> buildProductList(List<String[]> infoList, SessionOper sessionOper) {
		List<Product> productList = new ArrayList<Product>();
		
		Set<String> myset = new HashSet<String>();
		List<String> existProductList = productMapper.findExistProduct(sessionOper.getOrgId());
		
		for (String[] arr : infoList) {
			Product product = new Product();
			String productModel = arr[0];
			String productName = arr[1];
			String productEngName = arr[2];
			String unit = arr[3];
			String packQuantityStr = StringUtils.isBlank(arr[4])?"0":arr[4];
			String packWeightStr = StringUtils.isBlank(arr[5])?"0":arr[5];
			String packVolumeStr = StringUtils.isBlank(arr[6])?"0":arr[6];

			if (StringUtils.isBlank(productModel)
					|| StringUtils.isBlank(productName)
					|| StringUtils.isBlank(unit)) continue;//信息不完整的直接过滤
			
			int packQuantity = 0;
			try {
				packQuantity = Integer.parseInt(packQuantityStr);
			} catch (NumberFormatException e) {
				continue;//信息有误直接过滤
			}
			
			double packWeight = 0;
			try {
				packWeight = Double.parseDouble(packWeightStr);
			} catch (NumberFormatException e) {
				continue;//信息有误直接过滤
			}
			
			double packVolume = 0;
			try {
				packVolume = Double.parseDouble(packVolumeStr);
			} catch (NumberFormatException e) {
				continue;//信息有误直接过滤
			}
			
			String key = productModel+"="+productName;
			
			if(myset.contains(key)){
				continue;//数据重复的直接过滤
			}
			
			if(existProductList.contains(key)){
				continue;//已经存在的直接过滤
			}
			
			product.setProductModel(productModel);
			product.setProductName(productName);
			product.setProductEngName(productEngName);
			product.setUnit(unit);
			product.setPackQuantity(packQuantity);
			product.setPackWeight(packWeight);
			product.setPackVolume(packVolume);
			
			productList.add(product);
			
			myset.add(key);
			
		}
		return productList;
	}

	@Override
	public List<String> findExistProduct(int orgId) {
		return productMapper.findExistProduct(orgId);
	}

	@Override
	public void importData(List<Product> productList, SessionOper sessionOper) {
		List<String> existProductList = productMapper.findExistProduct(sessionOper.getOrgId());
    	for(Product product : productList){
    		if(product.getProductModel()==null) continue;//移除了的直接过滤
			String key = product.getProductModel()+"="+product.getProductName();
			if(existProductList.contains(key)) continue;//已存在的直接过滤
			
			ProProduct proProduct = product.getProProduct();
			proProduct.setOrgId(sessionOper.getOrgId());
			proProduct.setEngLetter(Cn2Spell.converterToFirstSpell(proProduct.getProductName()));
			productMapper.insert(proProduct);
		}
	}

}
