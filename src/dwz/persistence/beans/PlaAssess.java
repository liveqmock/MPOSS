package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PlaAssess extends AbstractDO {

	private Integer assessId;
	private Integer orgId;
	private Integer operId;
	private Date assessTime;
	private String assessContent;

	public Integer getAssessId() {
		return assessId;
	}

	public void setAssessId(Integer assessId) {
		this.assessId = assessId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Date getAssessTime() {
		return assessTime;
	}

	public void setAssessTime(Date assessTime) {
		this.assessTime = assessTime;
	}

	public Integer getOperId() {
		return operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}

	public String getAssessContent() {
		return assessContent;
	}

	public void setAssessContent(String assessContent) {
		this.assessContent = assessContent;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("AssessId", getAssessId())
				.append("OrgId",getOrgId())
				.append("OperId",getOperId())
				.append("AssessTime", getAssessTime())
				.append("AssessContent", getAssessContent()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAssessId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PlaAssess == false) return false;
		if(this == obj) return true;
		PlaAssess other = (PlaAssess)obj;
		return new EqualsBuilder()
			.append(getAssessId(),other.getAssessId())
			.isEquals();
	}

}
