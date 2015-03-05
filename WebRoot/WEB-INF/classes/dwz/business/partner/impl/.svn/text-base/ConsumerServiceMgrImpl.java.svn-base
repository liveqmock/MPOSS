package dwz.business.partner.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.partner.Consumer;
import dwz.business.partner.ConsumerServiceMgr;
import dwz.business.partner.SearchConsumerVO;
import dwz.common.util.Cn2Spell;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.ParConsumer;
import dwz.persistence.mapper.ConsumerMapper;
import dwz.persistence.mapper.SaleMapper;

@Transactional(rollbackFor = Exception.class)
@Service("consumerServiceMgr")
public class ConsumerServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements ConsumerServiceMgr {
	
	@Autowired
	private ConsumerMapper consumerMapper;
	@Autowired
	private SaleMapper saleMapper;
	
	public int searchConsumerCount(SessionOper sessionOper, SearchConsumerVO vo) {
		vo.setOrgId(sessionOper.getOrgId());
		if(!StringUtils.isBlank(vo.getOrderNo())){
			return (Integer)consumerMapper.findCountByOrder(vo);
		}else{
			return (Integer)consumerMapper.findCountByQC(vo);
		}
	}

	public List<Consumer> searchConsumer(SessionOper sessionOper, SearchConsumerVO vo) {
		vo.setOrgId(sessionOper.getOrgId());
		List<Consumer> bos = new ArrayList<Consumer>();
		List<ParConsumer> pos = null;
		if(!StringUtils.isBlank(vo.getOrderNo())){
			pos = consumerMapper.findByOrder(vo);
		}else{
			pos = consumerMapper.findByQC(vo);
		}
		for(ParConsumer po : pos){
			bos.add(new Consumer(po));
		}
		return bos;
	}
	
	@Override
	public void addConsumer(Consumer consumer, SessionOper sessionOper) {
		consumer.setOrgId(sessionOper.getOrgId());
		ParConsumer po = consumer.getParConsumer();
		
		po.setEngLetter(Cn2Spell.converterToFirstSpell(consumer.getConsumerName()));
		po.setOverTimes(0);
		po.setCreateTime(new Date());
		
		po.setBillFinishTime(new Date());
		
		po.setStatus("1"); //CONSUMER_STATUS(1-可用)
		consumerMapper.insert(po);
	}

	@Override
	public Consumer getConsumer(int consumerId) {
		ParConsumer po = consumerMapper.load(consumerId);
		return new Consumer(po);
	}

	@Override
	public Consumer getConsumer(String consumerName, int orgId) {
		ParConsumer parConsumer = new ParConsumer();
		parConsumer.setConsumerName(consumerName);
		parConsumer.setOrgId(orgId);
		ParConsumer po = consumerMapper.getByConsumerName(parConsumer);
		if(po == null) return null;
		return new Consumer(po);
	}

	@Override
	public void updConsumer(Consumer consumer, SessionOper sessionOper) {
		ParConsumer po = consumer.getParConsumer();
		consumerMapper.update(po);
	}

	@Override
	public int getSaleCountByConsumer(int consumerId) {
		return saleMapper.getSaleCountByConsumer(consumerId);
	}
	
	@Override
	public void del(int consumerId) {
		consumerMapper.delete(consumerId);
	}
	
	@Override
	public List<Consumer> buildConsumerList(List<String[]> infoList, SessionOper sessionOper) {
		List<Consumer> consumerList = new ArrayList<Consumer>();
		
		Set<String> myset = new HashSet<String>();
		List<String> existList = consumerMapper.findExistConsumer(sessionOper.getOrgId());
		
		for (String[] arr : infoList) {
			Consumer consumer = new Consumer();
			String consumerType = arr[0];
			String consumerProp = arr[1];
			String consumerName = arr[2];
			String linkMan = arr[3];
			String phone = arr[4];
			String address = arr[5];
			String email = arr[6];
			String qq = arr[7];
			String msn = arr[8];

			if (StringUtils.isBlank(consumerType)
					|| StringUtils.isBlank(consumerProp)
					|| StringUtils.isBlank(consumerName)
					|| StringUtils.isBlank(linkMan)
					|| StringUtils.isBlank(phone)
					|| StringUtils.isBlank(address)) continue;//信息不完整的直接过滤
			
			if("外贸客户".equals(consumerType)){
				consumerType = "1";
			}else if("市场客户".equals(consumerType)){
				consumerType = "2";
			}else if("外地发货".equals(consumerType)){
				consumerType = "3";
			}else if("其他客户".equals(consumerType)){
				consumerType = "4";
			}else{
				continue;//信息有误直接过滤
			}
			
			if("个人客户".equals(consumerProp)){
				consumerProp = "1";
			}else if("单位客户".equals(consumerProp)){
				consumerProp = "2";
			}else{
				continue;//信息有误直接过滤
			}
			
			if(myset.contains(consumerName)){
				continue;//数据重复的直接过滤
			}
			
			if(existList.contains(consumerName)){
				continue;//已经存在的直接过滤
			}
			
			consumer.setConsumerType(consumerType);
			consumer.setConsumerProp(consumerProp);
			consumer.setConsumerName(consumerName);
			consumer.setLinkMan(linkMan);
			consumer.setPhone(phone);
			consumer.setAddress(address);
			consumer.setEmail(email);
			consumer.setQq(qq);
			consumer.setMsn(msn);
			
			consumerList.add(consumer);
			
			myset.add(consumerName);
			
		}
		return consumerList;
	}
	
	@Override
	public void importData(List<Consumer> consumerList, SessionOper sessionOper) {
		List<String> existList = consumerMapper.findExistConsumer(sessionOper.getOrgId());
    	for(Consumer consumer : consumerList){
    		if(consumer.getConsumerType() == null) continue;//移除了的直接过滤
			if(existList.contains(consumer.getConsumerName())) continue;//已存在的直接过滤
			
			ParConsumer parConsumer = consumer.getParConsumer();
			parConsumer.setOrgId(sessionOper.getOrgId());
			
			parConsumer.setEngLetter(Cn2Spell.converterToFirstSpell(consumer.getConsumerName()));
			parConsumer.setOverTimes(0);
			parConsumer.setCreateTime(new Date());
			
	        parConsumer.setBillFinishTime(new Date());
	        parConsumer.setStatus("1");
			consumerMapper.insert(parConsumer);//CONSUMER_STATUS(1-可用)
		}
	}
	
}
