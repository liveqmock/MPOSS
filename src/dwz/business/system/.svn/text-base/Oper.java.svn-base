package dwz.business.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.SysOper;

public class Oper extends AbstractBusinessObject {
	
	private String kaptcha;
	
	private SysOper sysOper;
	
	private List<Role> roleList;
	
	private String newPasswd;
	
	public Oper(){
		this.sysOper = new SysOper();
	}
	
	public Oper(SysOper sysOper){
		this.sysOper = sysOper;
	}
	
	public SysOper getSysOper() {
		return sysOper;
	}

	public void setSysOper(SysOper sysOper) {
		this.sysOper = sysOper;
	}

	@Override
	public Serializable getId() {
		return this.sysOper.getOperId();
	}
	
	public Integer getOperId() {
		return this.sysOper.getOperId();
	}
	public void setOperId(Integer operId) {
		this.sysOper.setOperId(operId);
	}
	public String getUserName() {
		return this.sysOper.getUserName();
	}
	public void setUserName(String userName) {
		this.sysOper.setUserName(userName);
	}
	public String getPasswd() {
		return this.sysOper.getPasswd();
	}
	public void setPasswd(String passwd) {
		this.sysOper.setPasswd(passwd);
	}
	public String getRealName() {
		return this.sysOper.getRealName();
	}
	public void setRealName(String realName) {
		this.sysOper.setRealName(realName);
	}
	public String getSex() {
		return this.sysOper.getSex();
	}
	public void setSex(String sex) {
		this.sysOper.setSex(sex);
	}
	public Integer getAge() {
		return this.sysOper.getAge();
	}
	public void setAge(Integer age) {
		this.sysOper.setAge(age);
	}
	public String getPhone() {
		return this.sysOper.getPhone();
	}
	public void setPhone(String phone) {
		this.sysOper.setPhone(phone);
	}
	public String getEmail() {
		return this.sysOper.getEmail();
	}
	public void setEmail(String email) {
		this.sysOper.setEmail(email);
	}
	public String getQq() {
		return this.sysOper.getQq();
	}
	public void setQq(String qq) {
		this.sysOper.setQq(qq);
	}
	public String getWeixin() {
		return this.sysOper.getWeixin();
	}
	public void setWeixin(String weixin) {
		this.sysOper.setWeixin(weixin);
	}
	public String getAddress() {
		return this.sysOper.getAddress();
	}
	public void setAddress(String address) {
		this.sysOper.setAddress(address);
	}
	public Integer getOrgId() {
		return this.sysOper.getOrgId();
	}
	public void setOrgId(Integer orgId) {
		this.sysOper.setOrgId(orgId);
	}
	public Date getCreateTime() {
		return this.sysOper.getCreateTime();
	}
	public void setCreateTime(Date createTime) {
		this.sysOper.setCreateTime(createTime);
	}
	public String getStatus() {
		return this.sysOper.getStatus();
	}
	public void setStatus(String status) {
		this.sysOper.setStatus(status);
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getKaptcha() {
		return kaptcha;
	}

	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}

	public String getNewPasswd() {
		return newPasswd;
	}

	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}

}
