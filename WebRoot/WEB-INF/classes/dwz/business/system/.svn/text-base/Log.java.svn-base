package dwz.business.system;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.SysLog;

public class Log extends AbstractBusinessObject{
	
	private SysLog sysLog;
	
	public Log(){
		this.sysLog = new SysLog();
	}
	
	public Log(SysLog sysLog){
		this.sysLog = sysLog;
	}

	public SysLog getSysLog() {
		return sysLog;
	}

	public void setSysLog(SysLog sysLog) {
		this.sysLog = sysLog;
	}

	@Override
	public Serializable getId() {
		return this.sysLog.getLogId();
	}
	
	public Integer getLogId() {
		return this.sysLog.getLogId();
	}
	public void setLogId(Integer logId) {
		this.sysLog.setLogId(logId);
	}
	public Date getLogTime() {
		return this.sysLog.getLogTime();
	}
	public void setLogTime(Date logTime) {
		this.sysLog.setLogTime(logTime);
	}
	public Integer getOrgId() {
		return this.sysLog.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.sysLog.setOrgId(orgId);
	}
	public String getOrgName() {
		return this.sysLog.getOrgName();
	}
	public void setOrgName(String orgName) {
		this.sysLog.setOrgName(orgName);
	}
	public Integer getOperId() {
		return this.sysLog.getOperId();
	}
	public void setOperId(Integer operId) {
		this.sysLog.setOperId(operId);
	}
	public String getUserName() {
		return this.sysLog.getUserName();
	}
	public void setUserName(String userName) {
		this.sysLog.setUserName(userName);
	}
	public String getLogContent() {
		return this.sysLog.getLogContent();
	}
	public void setLogContent(String logContent) {
		this.sysLog.setLogContent(logContent);
	}

}
