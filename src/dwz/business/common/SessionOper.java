package dwz.business.common;

import java.io.Serializable;
import java.util.List;

public class SessionOper implements Serializable{
	
	private Integer orgId;
	private String orgName;
	private String engName;
	private String tel;
	private String fax;
	private String address;
	private String engAddress;
	private String logo;
	private Integer operId;
	private String userName;
	private boolean superAdmin;
	private List<String> resourceUrlList;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getOperId() {
		return operId;
	}
	public void setOperId(Integer operId) {
		this.operId = operId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getEngAddress() {
		return engAddress;
	}
	public void setEngAddress(String engAddress) {
		this.engAddress = engAddress;
	}
	public String getLogoImg() {
		return "/styles/theme/img/logo/"+logo;
	}
	public List<String> getResourceUrlList() {
		return resourceUrlList;
	}
	public void setResourceUrlList(List<String> resourceUrlList) {
		this.resourceUrlList = resourceUrlList;
	}
	public boolean isSuperAdmin() {
		return superAdmin;
	}
	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

}
