package dwz.business.plat;

import java.io.Serializable;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.PlaService;

public class Service extends AbstractBusinessObject {
	
	private PlaService plaService;
	
	public Service(){
		this.plaService = new PlaService();
	}
	
	public Service(PlaService plaService){
		this.plaService = plaService;
	}

	@Override
	public Serializable getId() {
		return this.plaService.getPlatServiceId();
	}
	
	public PlaService getPlaService() {
		return plaService;
	}

	public void setPlaService(PlaService plaService) {
		this.plaService = plaService;
	}

	public Integer getPlatServiceId() {
		return this.plaService.getPlatServiceId();
	}
	public void setPlatServiceId(Integer platServiceId) {
		this.plaService.setPlatServiceId(platServiceId);
	}
	public String getPlatServiceType() {
		return this.plaService.getPlatServiceType();
	}
	public void setPlatServiceType(String platServiceType) {
		this.plaService.setPlatServiceType(platServiceType);
	}
	public Integer getNeedPrice() {
		return this.plaService.getNeedPrice();
	}
	public void setNeedPrice(Integer needPrice) {
		this.plaService.setNeedPrice(needPrice);
	}

}
