package dwz.business.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.IndexServiceMgr;
import dwz.business.system.Oper;
import dwz.business.system.Org;
import dwz.business.system.Resource;
import dwz.business.system.Role;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.SysOper;
import dwz.persistence.beans.SysOperRole;
import dwz.persistence.beans.SysOrg;
import dwz.persistence.beans.SysResource;
import dwz.persistence.beans.SysRole;
import dwz.persistence.mapper.OperMapper;
import dwz.persistence.mapper.OperRoleMapper;
import dwz.persistence.mapper.OrgMapper;
import dwz.persistence.mapper.ResourceMapper;
import dwz.persistence.mapper.RoleMapper;

@Transactional(rollbackFor = Exception.class)
@Service("indexServiceMgr")
public class IndexServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements IndexServiceMgr {
	
	@Autowired
	private OperMapper operMapper;
	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private ResourceMapper resourceMapper;
	@Autowired
	private OperRoleMapper operRoleMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public Oper getOperByLogin(Oper oper) {
		SysOper po = operMapper.findOperByLogin(oper.getSysOper());
		return new Oper(po);
	}

	@Override
	public Org getOrg(int orgId) {
		SysOrg po = orgMapper.load(orgId);
		return new Org(po);
	}

	@Override
	public List<Resource> findResourceByOperId(int operId) {
		
		List<Resource> bos = new ArrayList<Resource>();
		
		List<Integer> roleIdList = new ArrayList<Integer>();
		
		List<SysOperRole> tempList = operRoleMapper.findRoleByOper(operId);
		if(tempList != null){
			for(SysOperRole sysOperRole : tempList){
				roleIdList.add(sysOperRole.getRoleId());
			}
		}
		
		if(roleIdList.isEmpty()){
			return bos;
		}
		
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("roleIdList", roleIdList);
		List<SysResource> pos = resourceMapper.findResourceByRoles(paramMap);
		for(SysResource po : pos){
			bos.add(new Resource(po));
		}
		return bos;
	}

	@Override
	public List<Role> findRoleByOperId(int operId) {
		
		List<Role> bos = new ArrayList<Role>();
		List<SysRole> pos = roleMapper.findByOper(operId);
		for(SysRole po : pos){
			bos.add(new Role(po));
		}
		return bos;
	}

}
