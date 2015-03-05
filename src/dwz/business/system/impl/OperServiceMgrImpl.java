package dwz.business.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.common.ZNodes;
import dwz.business.system.Oper;
import dwz.business.system.OperServiceMgr;
import dwz.business.system.Role;
import dwz.common.util.StringUtils;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.AccAccount;
import dwz.persistence.beans.SysOper;
import dwz.persistence.beans.SysOperRole;
import dwz.persistence.beans.SysResource;
import dwz.persistence.beans.SysRole;
import dwz.persistence.mapper.OperMapper;
import dwz.persistence.mapper.OperRoleMapper;
import dwz.persistence.mapper.RoleMapper;

@Transactional(rollbackFor = Exception.class)
@Service("operServiceMgr")
public class OperServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements OperServiceMgr {
	
	@Autowired
	private OperMapper operMapper;
	@Autowired
	private OperRoleMapper operRoleMapper;
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public boolean checkPasswd(Oper oper) {
		SysOper sysOper = operMapper.load(oper.getOperId());
		if(sysOper.getPasswd().equals(oper.getPasswd())){
			return true;
		}
		return false;
	}
	
	

	@Override
	public void upd(Oper oper) {
		operMapper.update(oper.getSysOper());
	}



	@Override
	public void updPwd(Oper oper) {
		operMapper.updatePwd(oper);
	}

	@Override
	public List<Oper> searchOper(SessionOper sessionOper) {
		List<Oper> bos = new ArrayList<Oper>();
		List<SysOper> pos = operMapper.findByOrg(sessionOper.getOrgId());
		for(SysOper po : pos){
			bos.add(new Oper(po));
		}
		return bos;
	}

	@Override
	public void addOper(Oper oper, String roleIds, SessionOper sessionOper) {
		SysOper sysOper = oper.getSysOper();
		sysOper.setOrgId(sessionOper.getOrgId());
		sysOper.setCreateTime(new Date());
		sysOper.setStatus("1");//OPER_STATUS(1-可用)
		operMapper.insert(sysOper);
		
		if(StringUtils.isBlank(roleIds)) return;
		String[] roleIdArr = roleIds.split(",");
		
		for(String roleIdStr : roleIdArr){
			
			SysOperRole sysOperRole = new SysOperRole();
			sysOperRole.setOperId(sysOper.getOperId());
			sysOperRole.setRoleId(Integer.parseInt(roleIdStr));
			operRoleMapper.insert(sysOperRole);
		}
	}

	@Override
	public Oper getOper(String userName, String realName, int orgId) {
		SysOper sysOper = new SysOper();
		sysOper.setOrgId(orgId);
		sysOper.setUserName(userName);
		sysOper.setRealName(realName);
		SysOper po = operMapper.getByUserNameOrRealName(sysOper);
		if(po == null) return null;
		return new Oper(po);
	}

	@Override
	public void del(int operId) {
		operMapper.delete(operId);
		operRoleMapper.deleteByOper(operId);
	}
	
	public void disable(int operId) {
		SysOper po = new SysOper();
		po.setOperId(operId);
		po.setStatus("0");//ACCOUNT_STATUS(0-停用)
		operMapper.updateStatus(po);
	}
	
	public void enable(int operId) {
		SysOper po = new SysOper();
		po.setOperId(operId);
		po.setStatus("1");//ACCOUNT_STATUS(1-启用)
		operMapper.updateStatus(po);
	}

	@Override
	public Oper getOper(int operId) {
		SysOper po = operMapper.load(operId);
		return new Oper(po);
	}

	@Override
	public void updOper(Oper oper, String roleIds) {
		
		operMapper.update(oper.getSysOper());
		
		List<Integer> boRoleIdList = new ArrayList<Integer>();
		List<Integer> poRoleIdList = new ArrayList<Integer>();
		
		if(!StringUtils.isBlank(roleIds)){
			String[] roleIdArr = roleIds.split(",");
			for(String roleIdStr : roleIdArr){
				boRoleIdList.add(Integer.parseInt(roleIdStr));
			}
		}
		
		List<SysOperRole> operRoleList = operRoleMapper.findRoleByOper(oper.getOperId());
		if(operRoleList != null){
			for(SysOperRole operRole : operRoleList){
				poRoleIdList.add(operRole.getRoleId());
			}
		}
		
		List<Integer> cloneBoRoleIdList = new ArrayList<Integer>();
		cloneBoRoleIdList.addAll(boRoleIdList);
		
		List<Integer> clonePoRoleIdList = new ArrayList<Integer>();
		clonePoRoleIdList.addAll(poRoleIdList);
		
		boRoleIdList.removeAll(poRoleIdList);
		for(int roleId : boRoleIdList){//insert
			SysOperRole sysOperRole = new SysOperRole();
			sysOperRole.setOperId(oper.getOperId());
			sysOperRole.setRoleId(roleId);
			operRoleMapper.insert(sysOperRole);
		}
		
		clonePoRoleIdList.removeAll(cloneBoRoleIdList);
		for(int roleId : clonePoRoleIdList){//delete
			SysOperRole sysOperRole = new SysOperRole();
			sysOperRole.setOperId(oper.getOperId());
			sysOperRole.setRoleId(roleId);
			operRoleMapper.deleteByOperAndRole(sysOperRole);
		}
	}

	@Override
	public List<Role> findRoleByOrg(int orgId) {
		List<Role> bos = new ArrayList<Role>();
		List<SysRole> pos = roleMapper.findByOrg(orgId);
		for(SysRole po : pos){
			bos.add(new Role(po));
		}
		return bos;
	}

	@Override
	public List<ZNodes> findZNodesOfRole(SessionOper sessionOper) {
		List<ZNodes> zNodesList = new ArrayList<ZNodes>();
		List<SysRole> pos = roleMapper.findByOrg(sessionOper.getOrgId());
		int i = 0;
		for(SysRole po : pos){
			i++;
			if(i == 1) continue;//过滤掉超级管理员
			ZNodes zNodes = new ZNodes();
			zNodes.setId(po.getRoleId());
			zNodes.setName(po.getRoleName());
			zNodesList.add(zNodes);
		}
		return zNodesList;
	}
	
	@Override
	public List<ZNodes> findZNodesOfRoleWithChecked(SessionOper sessionOper, int operId) {
		
		List<ZNodes> zNodesList = new ArrayList<ZNodes>();
		List<SysRole> pos = roleMapper.findByOrg(sessionOper.getOrgId());
		
		List<Integer> ownRoleIdList = new ArrayList<Integer>();
		List<SysOperRole> checkedPos = operRoleMapper.findCheckedRoleByOper(operId);
		if(checkedPos != null){
			for(SysOperRole checkedPo : checkedPos){
				ownRoleIdList.add(checkedPo.getRoleId());
			}
		}
		
		int i = 0;
		for(SysRole po : pos){
			i++;
			if(i == 1) continue;//过滤掉超级管理员
			ZNodes zNodes = new ZNodes();
			zNodes.setId(po.getRoleId());
			zNodes.setName(po.getRoleName());
			if(ownRoleIdList.contains(po.getRoleId())){
				zNodes.setChecked(true);
			}
			zNodesList.add(zNodes);
		}
		return zNodesList;
	}

}
