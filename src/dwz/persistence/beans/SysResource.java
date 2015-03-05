package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysResource extends AbstractDO {
	
	private Integer resourceId;
	private String resourceType;
	private String resourceName;
	private String resourceUrl;
	private String resourceDesc;
	private String rel;
	private Integer parentResourceId;
	private String inuseFlag;
	private int sort;
	
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	public String getResourceDesc() {
		return resourceDesc;
	}
	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public Integer getParentResourceId() {
		return parentResourceId;
	}
	public void setParentResourceId(Integer parentResourceId) {
		this.parentResourceId = parentResourceId;
	}
	public String getInuseFlag() {
		return inuseFlag;
	}
	public void setInuseFlag(String inuseFlag) {
		this.inuseFlag = inuseFlag;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ResourceId", getResourceId())
				.append("ResourceType",getResourceType())
				.append("ResourceName",getResourceName())
				.append("ResourceUrl",getResourceUrl())
				.append("ResourceDesc", getResourceDesc())
				.append("Rel", getRel())
				.append("ParentResourceId", getParentResourceId())
				.append("InuseFlag", getInuseFlag())
				.append("Sort", getSort()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getResourceId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysResource == false) return false;
		if(this == obj) return true;
		SysResource other = (SysResource)obj;
		return new EqualsBuilder()
			.append(getResourceId(),other.getResourceId())
			.isEquals();
	}

}
