package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class StoStockTaking extends AbstractDO {
	
	private Integer stockTakingId;
	private String stockTakingNo;
	private Integer orgId;
	private Integer regOperId;
	private Date regTime;
	private String regDesc;
	private Integer confOperId;
	private Date confTime;
	private String confDesc;
	private String status;
	
	public Integer getStockTakingId() {
		return stockTakingId;
	}
	public void setStockTakingId(Integer stockTakingId) {
		this.stockTakingId = stockTakingId;
	}
	public String getStockTakingNo() {
		return stockTakingNo;
	}
	public void setStockTakingNo(String stockTakingNo) {
		this.stockTakingNo = stockTakingNo;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getRegOperId() {
		return regOperId;
	}
	public void setRegOperId(Integer regOperId) {
		this.regOperId = regOperId;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public String getRegDesc() {
		return regDesc;
	}
	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc;
	}
	public Integer getConfOperId() {
		return confOperId;
	}
	public void setConfOperId(Integer confOperId) {
		this.confOperId = confOperId;
	}
	public Date getConfTime() {
		return confTime;
	}
	public void setConfTime(Date confTime) {
		this.confTime = confTime;
	}
	public String getConfDesc() {
		return confDesc;
	}
	public void setConfDesc(String confDesc) {
		this.confDesc = confDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("StockTakingId", getStockTakingId())
				.append("StockTakingNo",getStockTakingNo())
				.append("OrgId",getOrgId())
				.append("RegOperId", getRegOperId())
				.append("RegTime", getRegTime())
				.append("RegDesc", getRegDesc())
				.append("ConfOperId", getConfOperId())
				.append("ConfTime", getConfTime())
				.append("ConfDesc", getConfDesc())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockTakingId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StoStockTaking == false) return false;
		if(this == obj) return true;
		StoStockTaking other = (StoStockTaking)obj;
		return new EqualsBuilder()
			.append(getStockTakingId(),other.getStockTakingId())
			.isEquals();
	}

}
