package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysLog extends AbstractDO{
	
	private Integer logId;
	private Date logTime;
	private Integer orgId;
	private String orgName;
	private Integer operId;
	private String userName;
	private String logContent;
	
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Integer getOperId() {
		return operId;
	}
	public void setOperId(Integer operId) {
		this.operId = operId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("LogId", getLogId())
				.append("LogTime", getLogTime())
				.append("OrgId", getOrgId())
				.append("OrgName", getOrgName())
				.append("OperId", getOperId())
				.append("UserName", getUserName())
				.append("LogContent", getLogContent()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLogId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysLog == false) return false;
		if(this == obj) return true;
		SysLog other = (SysLog)obj;
		return new EqualsBuilder()
			.append(getLogId(),other.getLogId())
			.isEquals();
	}

}
