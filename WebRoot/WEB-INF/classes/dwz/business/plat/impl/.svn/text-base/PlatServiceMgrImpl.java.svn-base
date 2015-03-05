package dwz.business.plat.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.plat.Assess;
import dwz.business.plat.Pay;
import dwz.business.plat.PlatServiceMgr;
import dwz.business.plat.Suggest;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.PlaAssess;
import dwz.persistence.beans.PlaPay;
import dwz.persistence.beans.PlaSuggest;
import dwz.persistence.mapper.PlatAssessMapper;
import dwz.persistence.mapper.PlatPayMapper;
import dwz.persistence.mapper.PlatSuggestMapper;

@Transactional(rollbackFor = Exception.class)
@Service("platServiceMgr")
public class PlatServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements PlatServiceMgr {
	
	@Autowired
	private PlatPayMapper platPayMapper;
	@Autowired
	private PlatAssessMapper platAssessMapper;
	@Autowired
	private PlatSuggestMapper platSuggestMapper;

	@Override
	public List<Pay> searchPay(SessionOper sessionOper) {
		List<Pay> bos = new ArrayList<Pay>();
		List<PlaPay> pos = platPayMapper.findByOrg(sessionOper.getOrgId());
		for(PlaPay po : pos){
			bos.add(new Pay(po));
		}
		return bos;
	}

	@Override
	public void insertAssess(Assess assess, SessionOper sessionOper) {
		PlaAssess plaAssess = assess.getPlaAssess();
		plaAssess.setOrgId(sessionOper.getOrgId());
		plaAssess.setOperId(sessionOper.getOperId());
		plaAssess.setAssessTime(new Date());
		platAssessMapper.insert(plaAssess);
	}

	@Override
	public void insertSuggest(Suggest suggest, SessionOper sessionOper) {
		PlaSuggest plaSuggest = suggest.getPlaSuggest();
		plaSuggest.setOrgId(sessionOper.getOrgId());
		plaSuggest.setOperId(sessionOper.getOperId());
		plaSuggest.setSuggestTime(new Date());
		platSuggestMapper.insert(plaSuggest);
	}

}
