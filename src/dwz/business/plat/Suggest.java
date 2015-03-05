package dwz.business.plat;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.PlaSuggest;

public class Suggest extends AbstractBusinessObject {
	
	private PlaSuggest plaSuggest;
	
	public Suggest(){
		this.plaSuggest = new PlaSuggest();
	}
	
	public Suggest(PlaSuggest plaSuggest){
		this.plaSuggest = plaSuggest;
	}

	@Override
	public Serializable getId() {
		return this.plaSuggest.getSuggestId();
	}

	public PlaSuggest getPlaSuggest() {
		return plaSuggest;
	}

	public void setPlaSuggest(PlaSuggest plaSuggest) {
		this.plaSuggest = plaSuggest;
	}
	
	public Integer getSuggestId() {
		return this.plaSuggest.getSuggestId();
	}

	public void setSuggestId(Integer suggestId) {
		this.plaSuggest.setSuggestId(suggestId);
	}

	public Integer getOrgId() {
		return this.plaSuggest.getOrgId();
	}

	public void setOrgId(Integer orgId) {
		this.plaSuggest.setOrgId(orgId);
	}

	public Integer getOperId() {
		return this.plaSuggest.getOperId();
	}

	public void setOperId(Integer operId) {
		this.plaSuggest.setOperId(operId);
	}
	
	public String getPhone(){
		return this.plaSuggest.getPhone();
	}
	
	public void setPhone(String phone){
		this.plaSuggest.setPhone(phone);
	}

	public Date getSuggestTime() {
		return this.plaSuggest.getSuggestTime();
	}

	public void setSuggestTime(Date suggestTime) {
		this.plaSuggest.setSuggestTime(suggestTime);
	}

	public String getSuggestContent() {
		return this.plaSuggest.getSuggestContent();
	}

	public void setSuggestContent(String suggestContent) {
		this.plaSuggest.setSuggestContent(suggestContent);
	}

}
