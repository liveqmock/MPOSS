package dwz.business.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.SysResource;

public class Resource extends AbstractBusinessObject {
	
	private SysResource sysResource;
	
	private List<Resource> resourceList = new ArrayList<Resource>();
	
	public Resource(){
		this.sysResource = new SysResource();
	}
	
	public Resource(SysResource sysResource){
		this.sysResource = sysResource;
	}

	@Override
	public Serializable getId() {
		return this.sysResource.getResourceId();
	}

	public SysResource getSysResource() {
		return sysResource;
	}

	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}
	
	public Integer getResourceId() {
		return this.sysResource.getResourceId();
	}
	public void setResourceId(Integer resourceId) {
		this.sysResource.setResourceId(resourceId);
	}
	public String getResourceType() {
		return this.sysResource.getResourceType();
	}
	public void setResourceType(String resourceType) {
		this.sysResource.setResourceType(resourceType);
	}
	public String getResourceName() {
		return this.sysResource.getResourceName();
	}
	public void setResourceName(String resourceName) {
		this.sysResource.setResourceName(resourceName);
	}
	public String getResourceUrl() {
		return this.sysResource.getResourceUrl();
	}
	public void setResourceUrl(String resourceUrl) {
		this.sysResource.setResourceUrl(resourceUrl);
	}
	public String getResourceDesc() {
		return this.sysResource.getResourceDesc();
	}
	public void setResourceDesc(String resourceDesc) {
		this.sysResource.setResourceDesc(resourceDesc);
	}
	public String getRel() {
		return this.sysResource.getRel();
	}
	public void setRel(String rel) {
		this.sysResource.setRel(rel);
	}
	public Integer getParentResourceId() {
		return this.sysResource.getParentResourceId();
	}
	public void setParentResourceId(Integer parentResourceId) {
		this.sysResource.setParentResourceId(parentResourceId);
	}
	public String getInuseFlag() {
		return this.sysResource.getInuseFlag();
	}
	public void setInuseFlag(String inuseFlag) {
		this.sysResource.setInuseFlag(inuseFlag);
	}
	public int getSort() {
		return this.sysResource.getSort();
	}
	public void setSort(int sort) {
		this.sysResource.setSort(sort);
	}

	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

}
