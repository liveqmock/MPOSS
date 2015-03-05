package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class AccBank extends AbstractDO {
	
	private Integer bankId;
	private String bankName;
	
	
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("BankId",getBankId())
				.append("BankName",getBankName()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getBankId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AccBank == false) return false;
		if(this == obj) return true;
		AccBank other = (AccBank)obj;
		return new EqualsBuilder()
			.append(getBankId(),other.getBankId())
			.isEquals();
	}

}
