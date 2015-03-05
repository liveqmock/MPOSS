package dwz.business.partner.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.partner.Provider;
import dwz.business.partner.ProviderServiceMgr;
import dwz.business.partner.SearchProviderVO;
import dwz.common.util.Cn2Spell;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.ParProvider;
import dwz.persistence.mapper.ProviderMapper;
import dwz.persistence.mapper.PurchaseMapper;
import dwz.persistence.mapper.StockMapper;

@Transactional(rollbackFor = Exception.class)
@Service("providerServiceMgr")
public class ProviderServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements ProviderServiceMgr {
	
	@Autowired
	private ProviderMapper providerMapper;
	@Autowired
	private PurchaseMapper purchaseMapper;
	@Autowired
	private StockMapper stockMapper;
	
	public int searchProviderCount(SessionOper sessionOper, SearchProviderVO vo) {
		vo.setOrgId(sessionOper.getOrgId());
		if(!StringUtils.isBlank(vo.getOrderNo())){
			return (Integer)providerMapper.findCountByOrder(vo);
		}else{
			return (Integer)providerMapper.findCountByQC(vo);
		}
	}

	public List<Provider> searchProvider(SessionOper sessionOper, SearchProviderVO vo) {
		vo.setOrgId(sessionOper.getOrgId());
		List<Provider> bos = new ArrayList<Provider>();
		List<ParProvider> pos = null;
		if(!StringUtils.isBlank(vo.getOrderNo())){
			pos = providerMapper.findByOrder(vo);
		}else{
			pos = providerMapper.findByQC(vo);
		}
		for(ParProvider po : pos){
			bos.add(new Provider(po));
		}
		return bos;
	}
	
	@Override
	public void addProvider(Provider provider, SessionOper sessionOper) {
		provider.setOrgId(sessionOper.getOrgId());
		ParProvider po = provider.getParProvider();
		
		po.setEngLetter(Cn2Spell.converterToFirstSpell(provider.getProviderName()));
		po.setOverTimes(0);
		po.setCreateTime(new Date());
		
		po.setBillFinishTime(new Date());
		
		po.setStatus("1"); //PROVIDER_STATUS(1-可用)
		providerMapper.insert(po);
	}

	@Override
	public Provider getProvider(int providerId) {
		ParProvider po = providerMapper.load(providerId);
		return new Provider(po);
	}

	@Override
	public Provider getProvider(String providerName, int orgId) {
		ParProvider parProvider = new ParProvider();
		parProvider.setProviderName(providerName);
		parProvider.setOrgId(orgId);
		ParProvider po = providerMapper.getByProviderName(parProvider);
		if(po == null) return null;
		return new Provider(po);
	}

	@Override
	public void updProvider(Provider provider, SessionOper sessionOper) {
		ParProvider po = provider.getParProvider();
		providerMapper.update(po);
	}

	@Override
	public int getPurchaseCountByProvider(int providerId) {
		return purchaseMapper.getPurchaseCountByProvider(providerId);
	}

	@Override
	public int getStockCountByProvider(int providerId) {
		return stockMapper.getStockCountByProvider(providerId);
	}
	
	@Override
	public void del(int providerId) {
		providerMapper.delete(providerId);
	}
	
	@Override
	public List<Provider> buildProviderList(List<String[]> infoList, SessionOper sessionOper) {
		List<Provider> providerList = new ArrayList<Provider>();
		
		Set<String> myset = new HashSet<String>();
		List<String> existList = providerMapper.findExistProvider(sessionOper.getOrgId());
		
		for (String[] arr : infoList) {
			
			String providerType = arr[0];
			String providerProp = arr[1];
			String providerName = arr[2];
			String linkMan = arr[3];
			String phone = arr[4];
			String address = arr[5];
			String email = arr[6];
			String qq = arr[7];
			String msn = arr[8];

			if (StringUtils.isBlank(providerType)
					|| StringUtils.isBlank(providerProp)
					|| StringUtils.isBlank(providerName)
					|| StringUtils.isBlank(linkMan)) continue;//信息不完整的直接过滤
			
			if("异地供应商".equals(providerType)){
				providerType = "1";
			}else if("市场供应商".equals(providerType)){
				providerType = "2";
			}else{
				continue;//信息有误直接过滤
			}
			
			if("个人".equals(providerProp)){
				providerProp = "1";
			}else if("单位".equals(providerProp)){
				providerProp = "2";
			}else{
				continue;//信息有误直接过滤
			}
			
			if(myset.contains(providerName)){
				continue;//数据重复的直接过滤
			}
			
			if(existList.contains(providerName)){
				continue;//已经存在的直接过滤
			}
			
			Provider provider = new Provider();
			provider.setProviderType(providerType);
			provider.setProviderProp(providerProp);
			provider.setProviderName(providerName);
			provider.setLinkMan(linkMan);
			provider.setPhone(phone);
			provider.setAddress(address);
			provider.setEmail(email);
			provider.setQq(qq);
			provider.setMsn(msn);
			
			providerList.add(provider);
			
			myset.add(providerName);
			
		}
		return providerList;
	}
	
	@Override
	public void importData(List<Provider> providerList, SessionOper sessionOper) {
		List<String> existList = providerMapper.findExistProvider(sessionOper.getOrgId());
    	for(Provider provider : providerList){
    		if(provider.getProviderType() == null) continue;//移除了的直接过滤
			if(existList.contains(provider.getProviderName())) continue;//已存在的直接过滤
			
			ParProvider parProvider = provider.getParProvider();
			parProvider.setOrgId(sessionOper.getOrgId());
			
			parProvider.setEngLetter(Cn2Spell.converterToFirstSpell(provider.getProviderName()));
			parProvider.setOverTimes(0);
			parProvider.setCreateTime(new Date());
			
	        parProvider.setBillFinishTime(new Date());
	        parProvider.setStatus("1");
			providerMapper.insert(parProvider);//CONSUMER_STATUS(1-可用)
		}
	}
	
}
