package dwz.business.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.system.Log;
import dwz.business.system.LogServiceMgr;
import dwz.business.system.SearchLogVO;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.SysLog;
import dwz.persistence.mapper.LogMapper;

@Transactional(rollbackFor = Exception.class)
@Service("logServiceMgr")
public class LogServiceMgrImpl extends AbstractBusinessObjectServiceMgr  implements LogServiceMgr {
    
	@Autowired
	private LogMapper logMapper;

	@Override
	public int searchLogCount(SearchLogVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return logMapper.findCountByQC(vo);
	}

	@Override
	public List<Log> searchLog(SearchLogVO vo, SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		List<Log> bos = new ArrayList<Log>();
		List<SysLog> pos = logMapper.findByQC(vo);
		for(SysLog po : pos){
			bos.add(new Log(po));
		}
		
		return bos;
	}

}
