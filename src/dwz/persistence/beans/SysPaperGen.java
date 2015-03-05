package dwz.persistence.beans;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysPaperGen extends AbstractDO {

	private Integer orgId;
	private String paperType;
	private String year;
	private String month;
	private String day;
	private Integer no;

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("OrgId", getOrgId())
				.append("PaperType",getPaperType())
				.append("Year",getYear())
				.append("Month", getMonth())
				.append("Day", getDay())
				.append("No", getNo()).toString();
	}
	

}
