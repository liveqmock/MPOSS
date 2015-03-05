package dwz.business.partner;

import java.util.List;

import dwz.persistence.BaseConditionVO;

public class SearchConsumeVO extends BaseConditionVO {
	
	private Integer orgId;
	private Integer targetId;
	private List<String> busiTypeList;
	private String validFlag;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getTargetId() {
		return targetId;
	}
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}
	public List<String> getBusiTypeList() {
		return busiTypeList;
	}
	public void setBusiTypeList(List<String> busiTypeList) {
		this.busiTypeList = busiTypeList;
	}
	public String getValidFlag() {
		return validFlag;
	}
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}
