package dwz.business.account;

import dwz.persistence.BaseConditionVO;


public class SearchTransVO extends BaseConditionVO {
	
	private String transItem;
	private String accountType;
	private String accountNo;
	private Integer orgId;
	
	public String getTransItem() {
		return transItem;
	}
	public void setTransItem(String transItem) {
		this.transItem = transItem;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

}
