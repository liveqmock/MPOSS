package dwz.business.account;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.AccBank;

public class Bank extends AbstractBusinessObject {
	
	private static final long serialVersionUID = 1L;
	private AccBank accBank;
	
	public Bank(){
		this.accBank = new AccBank();
	}
	
	public Bank(AccBank accBank){
		this.accBank = accBank;
	}
	
	public AccBank getAccBank(){
		return this.accBank;
	}

	@Override
	public Integer getId() {
		return this.accBank.getBankId();
	}
	
	public Integer getBankId(){
		return this.accBank.getBankId();
	}
	
	public void setBankId(Integer bankId){
		this.accBank.setBankId(bankId);
	}
	
	public String getBankName(){
		return this.accBank.getBankName();
	}
	
	public void setBankName(String bankName){
		this.accBank.setBankName(bankName);
	}

}
