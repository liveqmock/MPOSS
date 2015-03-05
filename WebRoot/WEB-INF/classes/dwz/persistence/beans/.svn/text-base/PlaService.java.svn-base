package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class PlaService extends AbstractDO {
	
	private Integer platServiceId;
	private String platServiceType;
	private Integer needPrice;
	
	public Integer getPlatServiceId() {
		return platServiceId;
	}
	public void setPlatServiceId(Integer platServiceId) {
		this.platServiceId = platServiceId;
	}
	public String getPlatServiceType() {
		return platServiceType;
	}
	public void setPlatServiceType(String platServiceType) {
		this.platServiceType = platServiceType;
	}
	public Integer getNeedPrice() {
		return needPrice;
	}
	public void setNeedPrice(Integer needPrice) {
		this.needPrice = needPrice;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("PlatServiceId", getPlatServiceId())
				.append("PlatServiceType",getPlatServiceType())
				.append("NeedPrice", getNeedPrice()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPlatServiceId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PlaService == false) return false;
		if(this == obj) return true;
		PlaService other = (PlaService)obj;
		return new EqualsBuilder()
			.append(getPlatServiceId(),other.getPlatServiceId())
			.isEquals();
	}

}
