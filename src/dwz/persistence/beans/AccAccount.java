package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class AccAccount extends AbstractDO {

	private Integer accountId;
	private Integer orgId;
	private String accountType;
	private Integer bankId;
	private String openNet;
	private String accountName;
	private String accountNo;
	private Integer price;
	private String status;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getOpenNet() {
		return openNet;
	}

	public void setOpenNet(String openNet) {
		this.openNet = openNet;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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
				.append("AccountId", getAccountId())
				.append("OrgId",getOrgId())
				.append("AccountType",getAccountType())
				.append("BankId", getBankId())
				.append("OpenBank", getOpenNet())
				.append("AccountName",getAccountName())
				.append("AccountNo", getAccountNo())
				.append("Price", getPrice())
				.append("Status", getStatus()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAccountId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AccAccount == false) return false;
		if(this == obj) return true;
		AccAccount other = (AccAccount)obj;
		return new EqualsBuilder()
			.append(getAccountId(),other.getAccountId())
			.isEquals();
	}

}
