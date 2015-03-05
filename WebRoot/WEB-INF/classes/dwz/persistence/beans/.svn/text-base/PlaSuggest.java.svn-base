package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PlaSuggest extends AbstractDO {

	private Integer suggestId;
	private Integer orgId;
	private Integer operId;
	private String phone;
	private Date suggestTime;
	private String suggestContent;

	public Integer getSuggestId() {
		return suggestId;
	}

	public void setSuggestId(Integer suggestId) {
		this.suggestId = suggestId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public Integer getOperId() {
		return operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Date getSuggestTime() {
		return suggestTime;
	}

	public void setSuggestTime(Date suggestTime) {
		this.suggestTime = suggestTime;
	}

	public String getSuggestContent() {
		return suggestContent;
	}

	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("SuggestId", getSuggestId())
				.append("OrgId",getOrgId())
				.append("OperId",getOperId())
				.append("Phone",getPhone())
				.append("SuggestTime", getSuggestTime())
				.append("SuggestContent", getSuggestContent()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSuggestId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PlaSuggest == false) return false;
		if(this == obj) return true;
		PlaSuggest other = (PlaSuggest)obj;
		return new EqualsBuilder()
			.append(getSuggestId(),other.getSuggestId())
			.isEquals();
	}

}
