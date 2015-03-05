package dwz.business.account;

import java.io.Serializable;
import java.util.Date;

import dwz.common.util.StringUtils;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.AccTrans;

public class Trans extends AbstractBusinessObject {

	private static final long serialVersionUID = 1L;
	
	private AccTrans traTrans;
	
	private String priceAction;
	private Double inputTransPrice;
	
	public Trans(){
		this.traTrans = new AccTrans();
	}
	
	public Trans(AccTrans traTrans){
		this.traTrans = traTrans;
	}

	@Override
	public Serializable getId() {
		return this.traTrans.getTransId();
	}
	
	public AccTrans getTraTrans(){
		return this.traTrans;
	}
	public void setTraTrans(AccTrans traTrans) {
		this.traTrans = traTrans;
	}
	
	public Integer getTransId() {
		return this.traTrans.getTransId();
	}
	public void setTransId(Integer transId) {
		this.traTrans.setTransId(transId);
	}
	public String getTransNo() {
		return this.traTrans.getTransNo();
	}
	public void setTransNo(String transNo) {
		this.traTrans.setTransNo(transNo);
	}
	public Integer getOrgId() {
		return this.traTrans.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.traTrans.setOrgId(orgId);
	}
	public Integer getAccountId() {
		return this.traTrans.getAccountId();
	}
	public void setAccountId(Integer accountId) {
		this.traTrans.setAccountId(accountId);
	}
	public String getAccountType() {
		return this.traTrans.getAccountType();
	}
	public void setAccountType(String accountType) {
		this.traTrans.setAccountType(accountType);
	}
	public Integer getBankId() {
		return traTrans.getBankId();
	}
	public void setBankId(Integer bankId) {
		this.traTrans.setBankId(bankId);
	}
	public String getAccountName() {
		return this.traTrans.getAccountName();
	}
	public void setAccountName(String accountName) {
		this.traTrans.setAccountName(accountName);
	}
	public String getAccountNo() {
		return this.traTrans.getAccountNo();
	}
	public void setAccountNo(String accountNo) {
		this.traTrans.setAccountNo(accountNo);
	}
	public String getTransItem() {
		return this.traTrans.getTransItem();
	}
	public void setTransItem(String transItem) {
		this.traTrans.setTransItem(transItem);
	}
	public String getBillType() {
		return this.traTrans.getBillType();
	}
	public void setBillType(String billType) {
		this.traTrans.setBillType(billType);
	}
	public Integer getTargetId() {
		return this.traTrans.getTargetId();
	}
	public void setTargetId(Integer targetId) {
		this.traTrans.setTargetId(targetId);
	}
	public String getTargetName() {
		return this.traTrans.getTargetName();
	}
	public void setTargetName(String targetName) {
		this.traTrans.setTargetName(targetName);
	}
	public Date getTransTime() {
		return this.traTrans.getTransTime();
	}
	public void setTransTime(Date transTime) {
		this.traTrans.setTransTime(transTime);
	}
	public Integer getTransPrice() {
		return this.traTrans.getTransPrice();
	}
	public void setTransPrice(Integer transPrice) {
		this.traTrans.setTransPrice(transPrice);
	}
	public Integer getAfterPrice() {
		return this.traTrans.getAfterPrice();
	}
	public void setAfterPrice(Integer afterPrice) {
		this.traTrans.setAfterPrice(afterPrice);
	}
	public String getTransMemo() {
		return this.traTrans.getTransMemo();
	}
	public void setTransMemo(String transMemo) {
		this.traTrans.setTransMemo(transMemo);
	}
	public Integer getRegOperId() {
		return this.traTrans.getRegOperId();
	}
	public void setRegOperId(Integer regOperId) {
		this.traTrans.setRegOperId(regOperId);
	}
	public Date getRegTime() {
		return this.traTrans.getRegTime();
	}
	public void setRegTime(Date regTime) {
		this.traTrans.setRegTime(regTime);
	}
	public String getTransDate() {
		return this.traTrans.getTransDate();
	}
	public void setTransDate(String transDate) {
		this.traTrans.setTransDate(transDate);
	}
	public String getTransDire() {
		return this.traTrans.getTransDire();
	}
	public void setTransDire(String transDire) {
		this.traTrans.setTransDire(transDire);
	}
	public Integer getSumTransPrice() {
		return this.traTrans.getSumTransPrice();
	}
	public void setSumTransPrice(Integer sumTransPrice) {
		this.traTrans.setSumTransPrice(sumTransPrice);
	}

	public String getPriceAction() {
		return priceAction;
	}

	public void setPriceAction(String priceAction) {
		this.priceAction = priceAction;
	}

	public Double getInputTransPrice() {
		return inputTransPrice;
	}

	public void setInputTransPrice(Double inputTransPrice) {
		this.inputTransPrice = inputTransPrice;
	}

}
