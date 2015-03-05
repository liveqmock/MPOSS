package dwz.business.common.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.CommonServiceMgr;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.SysLog;
import dwz.persistence.beans.SysPaperGen;
import dwz.persistence.mapper.LogMapper;
import dwz.persistence.mapper.PaperGenMapper;

@Transactional(rollbackFor = Exception.class)
@Service("commonServiceMgr")
public class CommonServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements CommonServiceMgr {
	
	@Autowired
	private PaperGenMapper paperGenMapper;
	@Autowired
	private LogMapper logMapper;
	
	private static String getTargetLengthStr(int no,int length){
		String str = String.valueOf(no);
		StringBuffer someZeroStr = new StringBuffer();
		for(int i=0;i<length-str.length();i++){
			someZeroStr.append("0");
		}
		return someZeroStr+str;
	}
	
	public  String buildPaperCode(SysPaperGen sysPaperGen){
		return sysPaperGen.getPaperType()+sysPaperGen.getYear()+sysPaperGen.getMonth()+sysPaperGen.getDay()+getTargetLengthStr(sysPaperGen.getNo(),3);
	}
	
	public void addCodeGen(SysPaperGen sysPaperGen){
		paperGenMapper.insert(sysPaperGen);
	}
    
    public void updateCodeGen(SysPaperGen sysPaperGen){
    	paperGenMapper.update(sysPaperGen);
	}
	
    @Override
	public String getPaperNo(int orgId, String paperType){
		
    	SysPaperGen sysPaperGen = new SysPaperGen();
    	sysPaperGen.setOrgId(orgId);
    	sysPaperGen.setPaperType(paperType);
    	sysPaperGen.setYear(new SimpleDateFormat("yy").format(new Date()));
    	sysPaperGen.setMonth(new SimpleDateFormat("MM").format(new Date()));
    	sysPaperGen.setDay(new SimpleDateFormat("dd").format(new Date()));
    	
		SysPaperGen po = paperGenMapper.getOne(sysPaperGen);
		if(po==null){
			sysPaperGen.setNo(1);
			addCodeGen(sysPaperGen);
			return buildPaperCode(sysPaperGen);
		}else{
			sysPaperGen.setNo(Integer.valueOf(po.getNo().toString())+1);
			updateCodeGen(sysPaperGen);
			return buildPaperCode(sysPaperGen);
		}
	}

	@Override
	public void insertSysLog(SysLog sysLog) {
		logMapper.insert(sysLog);
	}

}
