package dwz.business.rpt;

import dwz.business.partner.Consumer;
import dwz.persistence.BaseConditionVO;

public class SearchSaleBackCollVO extends BaseConditionVO {
	
	private Integer orgId;
	private String saleBackType;
	private Consumer consumer;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getSaleBackType() {
		return saleBackType;
	}
	public void setSaleBackType(String saleBackType) {
		this.saleBackType = saleBackType;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	

}
