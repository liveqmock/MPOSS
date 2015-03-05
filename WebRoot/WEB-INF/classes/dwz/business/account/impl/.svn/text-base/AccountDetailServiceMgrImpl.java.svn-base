package dwz.business.account.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.account.AccountDetailServiceMgr;
import dwz.business.account.SearchTransVO;
import dwz.business.account.Trans;
import dwz.business.common.SessionOper;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.AccTrans;
import dwz.persistence.mapper.TransMapper;

@Transactional(rollbackFor = Exception.class)
@Service("accountDetailServiceMgr")
public class AccountDetailServiceMgrImpl extends
		AbstractBusinessObjectServiceMgr implements AccountDetailServiceMgr {
	
	@Autowired
	private TransMapper transMapper;
	
	@Override
	public int searchTransCount(SessionOper sessionOper, SearchTransVO req) {
		req.setOrgId(sessionOper.getOrgId());
		return (Integer)transMapper.findCountByQC(req);
	}

	@Override
	public List<Trans> searchTrans(SessionOper sessionOper, SearchTransVO req) {
		req.setOrgId(sessionOper.getOrgId());
		List<Trans> bos = new ArrayList<Trans>();
		List<AccTrans> pos = (List<AccTrans>)transMapper.findByQC(req);
		for(AccTrans po : pos){
			bos.add(new Trans(po));
		}
		return bos;
	}

}