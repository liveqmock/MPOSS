package dwz.business.account;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.AccAccount;

public class Account extends AbstractBusinessObject {

	private static final long serialVersionUID = 1L;
	private AccAccount accAccount;
	private Double inputPrice;
	private String adjustMemo;
	private String adjustItem;
	
	public Account(){
		this.accAccount = new AccAccount();
	}
	
	public Account(AccAccount accAccount){
		this.accAccount = accAccount;
	}
	
	public AccAccount getAccAccount(){
		return this.accAccount;
	}
	
	public void setAccAccount(AccAccount accAccount) {
		this.accAccount = accAccount;
	}
	
	@Override
	public Integer getId() {
		return this.accAccount.getAccountId();
	}

	public Integer getAccountId() {
		return this.accAccount.getAccountId();
	}

	public void setAccountId(Integer accountId) {
		this.accAccount.setAccountId(accountId);
	}
	
	public Integer getOrgId() {
		return this.accAccount.getOrgId();
	}

	public void setOrgId(Integer orgId) {
		this.accAccount.setOrgId(orgId);
	}

	public String getAccountType() {
		return this.accAccount.getAccountType();
	}

	public void setAccountType(String accountType) {
		this.accAccount.setAccountType(accountType);
	}

	public Integer getBankId() {
		return this.accAccount.getBankId();
	}

	public void setBankId(Integer bankId) {
		this.accAccount.setBankId(bankId);
	}

	public String getOpenNet() {
		return this.accAccount.getOpenNet();
	}

	public void setOpenNet(String openNet) {
		this.accAccount.setOpenNet(openNet);
	}

	public String getAccountName() {
		return this.accAccount.getAccountName();
	}

	public void setAccountName(String accountName) {
		this.accAccount.setAccountName(accountName);
	}

	public String getAccountNo() {
		return this.accAccount.getAccountNo();
	}

	public void setAccountNo(String accountNo) {
		this.accAccount.setAccountNo(accountNo);
	}

	public Integer getPrice() {
		return this.accAccount.getPrice();
	}

	public void setPrice(Integer price) {
		this.accAccount.setPrice(price);
	}
	
	public String getStatus(){
		return this.accAccount.getStatus();
	}
	
	public void setStatus(String status){
		this.accAccount.setStatus(status);
	}

	public Double getInputPrice(){
		return this.inputPrice;
	}
	
	public void setInputPrice(Double inputPrice){
		this.inputPrice = inputPrice;
	}
	
	public String getAdjustMemo() {
		return adjustMemo;
	}

	public void setAdjustMemo(String adjustMemo) {
		this.adjustMemo = adjustMemo;
	}

	public String getAdjustItem() {
		return adjustItem;
	}

	public void setAdjustItem(String adjustItem) {
		this.adjustItem = adjustItem;
	}

}
