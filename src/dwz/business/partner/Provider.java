package dwz.business.partner;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.ParProvider;

public class Provider extends AbstractBusinessObject{
	
	private static final long serialVersionUID = 1L;
	private ParProvider parProvider;
	
	public Provider(){
		this.parProvider = new ParProvider();
	}
	
	public Provider(ParProvider parProvider){
		this.parProvider = parProvider;
	}

	public ParProvider getParProvider() {
		return parProvider;
	}

	public void setParProvider(ParProvider parProvider) {
		this.parProvider = parProvider;
	}

	@Override
	public Serializable getId() {
		return this.parProvider.getProviderId();
	}
	
	public Integer getProviderId() {
		return this.parProvider.getProviderId();
	}
	public void setProviderId(Integer providerId) {
		this.parProvider.setProviderId(providerId);
	}
	public String getProviderType() {
		return this.parProvider.getProviderType();
	}
	public void setProviderType(String providerType) {
		this.parProvider.setProviderType(providerType);
	}
	public String getProviderProp() {
		return this.parProvider.getProviderProp();
	}
	public void setProviderProp(String providerProp) {
		this.parProvider.setProviderProp(providerProp);
	}
	public String getProviderName() {
		return this.parProvider.getProviderName();
	}
	public void setProviderName(String providerName) {
		this.parProvider.setProviderName(providerName);
	}
	public String getEngLetter(){
		return this.parProvider.getEngLetter();
	}
	public void setEngLetter(String engLetter){
		this.parProvider.setEngLetter(engLetter);
	}
	public String getLinkMan() {
		return this.parProvider.getLinkMan();
	}
	public void setLinkMan(String linkMan) {
		this.parProvider.setLinkMan(linkMan);
	}
	public String getPhone() {
		return this.parProvider.getPhone();
	}
	public void setPhone(String phone) {
		this.parProvider.setPhone(phone);
	}
	public String getAddress() {
		return this.parProvider.getAddress();
	}
	public void setAddress(String address) {
		this.parProvider.setAddress(address);
	}
	public String getEmail(){
		return this.parProvider.getEmail();
	}
	public void setEmail(String email){
		this.parProvider.setEmail(email);
	}
	public String getQq(){
		return this.parProvider.getQq();
	}
	public void setQq(String qq){
		this.parProvider.setQq(qq);
	}
	public String getMsn(){
		return this.parProvider.getMsn();
	}
	public void setMsn(String msn){
		this.parProvider.setMsn(msn);
	}
	public Integer getOverTimes() {
		return this.parProvider.getOverTimes();
	}
	public void setOverTimes(Integer overTimes) {
		this.parProvider.setOverTimes(overTimes);
	}
	public Date getCreateTime() {
		return this.parProvider.getCreateTime();
	}
	public void setCreateTime(Date createTime) {
		this.parProvider.setCreateTime(createTime);
	}
	public Integer getOrgId(){
		return this.parProvider.getOrgId();
	}
	public void setOrgId(Integer orgId){
		this.parProvider.setOrgId(orgId);
	}
	public Date getBillFinishTime() {
		return this.parProvider.getBillFinishTime();
	}
	public void setBillFinishTime(Date billFinishTime) {
		this.parProvider.setBillFinishTime(billFinishTime);
	}
	public String getStatus() {
		return this.parProvider.getStatus();
	}
	public void setStatus(String status) {
		this.parProvider.setStatus(status);
	}
	public Integer getProviderProductId() {
		return this.parProvider.getProviderProductId();
	}
	public void setProviderProductId(Integer providerProductId) {
		this.parProvider.setProviderProductId(providerProductId);
	}
	public Integer getUnitPrice() {
		return this.parProvider.getUnitPrice();
	}
	public void setUnitPrice(Integer unitPrice) {
		this.parProvider.setUnitPrice(unitPrice);
	}
	public Integer getPackQuantity() {
		return this.parProvider.getPackQuantity();
	}
	public void setPackQuantity(Integer packQuantity) {
		this.parProvider.setPackQuantity(packQuantity);
	}
	public Double getPackWeight() {
		return this.parProvider.getPackWeight();
	}
	public void setPackWeight(Double packWeight) {
		this.parProvider.setPackWeight(packWeight);
	}
	public Double getPackVolume() {
		return this.parProvider.getPackVolume();
	}
	public void setPackVolume(Double packVolume) {
		this.parProvider.setPackVolume(packVolume);
	}

}
