package dwz.business.plat;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.PlaAssess;

public class Assess extends AbstractBusinessObject {
	
	private PlaAssess plaAssess;
	
	public Assess(){
		this.plaAssess = new PlaAssess();
	}
	
	public Assess(PlaAssess plaAssess){
		this.plaAssess = plaAssess;
	}

	@Override
	public Serializable getId() {
		return this.plaAssess.getAssessId();
	}
	
	public PlaAssess getPlaAssess() {
		return plaAssess;
	}

	public void setPlaAssess(PlaAssess plaAssess) {
		this.plaAssess = plaAssess;
	}

	public Integer getAssessId() {
		return this.plaAssess.getAssessId();
	}

	public void setAssessId(Integer assessId) {
		this.plaAssess.setAssessId(assessId);
	}

	public Integer getOrgId() {
		return this.plaAssess.getOrgId();
	}

	public void setOrgId(Integer orgId) {
		this.plaAssess.setOrgId(orgId);
	}

	public Integer getOperId() {
		return this.plaAssess.getOperId();
	}

	public void setOperId(Integer operId) {
		this.plaAssess.setOperId(operId);
	}

	public Date getAssessTime() {
		return this.plaAssess.getAssessTime();
	}

	public void setAssessTime(Date assessTime) {
		this.plaAssess.setAssessTime(assessTime);
	}

	public String getAssessContent() {
		return this.plaAssess.getAssessContent();
	}

	public void setAssessContent(String assessContent) {
		this.plaAssess.setAssessContent(assessContent);
	}

}
