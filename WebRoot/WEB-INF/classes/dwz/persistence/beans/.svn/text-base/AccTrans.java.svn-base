package dwz.persistence.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class AccTrans extends AbstractDO {
	
	private Integer transId;
	private String transNo;
	private Integer orgId;
	private Integer accountId;
	private String accountType;
	private Integer bankId;
	private String accountName;
	private String accountNo;
	private String transItem;
	private String billType;
	private Date transTime;
	private Integer transPrice;
	private Integer afterPrice;
	private Integer targetId;
	private String targetName;
	private String transMemo;
	private Integer regOperId;
	private Date regTime;
	
	private String transDate;
	private String transDire;//TRANS_DIRE(1-收入,2-支出)
	private Integer sumTransPrice;
	
	public Integer getTransId() {
		return transId;
	}
	public void setTransId(Integer transId) {
		this.transId = transId;
	}
	public String getTransNo() {
		return transNo;
	}
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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
	public String getTransItem() {
		return transItem;
	}
	public void setTransItem(String transItem) {
		this.transItem = transItem;
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
	public Integer getTransPrice() {
		return transPrice;
	}
	public void setTransPrice(Integer transPrice) {
		this.transPrice = transPrice;
	}
	public Integer getAfterPrice() {
		return afterPrice;
	}
	public void setAfterPrice(Integer afterPrice) {
		this.afterPrice = afterPrice;
	}
	public String getTransMemo() {
		return transMemo;
	}
	public void setTransMemo(String transMemo) {
		this.transMemo = transMemo;
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
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public Integer getTargetId() {
		return targetId;
	}
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getTransDire() {
		return transDire;
	}
	public void setTransDire(String transDire) {
		this.transDire = transDire;
	}
	public Integer getSumTransPrice() {
		return sumTransPrice;
	}
	public void setSumTransPrice(Integer sumTransPrice) {
		this.sumTransPrice = sumTransPrice;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("TransId",getTransId())
			.append("TransNo",getTransNo())
			.append("OrgId",getOrgId())
			.append("AccountId",getAccountId())
			.append("AccountType",getAccountType())
			.append("BankId",getBankId())
			.append("AccountName",getAccountName())
			.append("AccountNo",getAccountNo())
			.append("TransItem", getTransItem())
			.append("BillType", getBillType())
			.append("TransTime",getTransTime())
			.append("TransPrice",getTransPrice())
			.append("AfterPrice",getAfterPrice())
			.append("TargetId",getTargetId())
			.append("TargetName",getTargetName())
			.append("transMemo", getTransMemo())
			.append("RegOperId",getRegOperId())
			.append("RegTime", getRegTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTransId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AccTrans == false) return false;
		if(this == obj) return true;
		AccTrans other = (AccTrans)obj;
		return new EqualsBuilder()
			.append(getTransId(),other.getTransId())
			.isEquals();
	}

}
