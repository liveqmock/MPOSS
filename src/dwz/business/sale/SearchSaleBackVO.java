package dwz.business.sale;

import dwz.business.partner.Consumer;
import dwz.persistence.BaseConditionVO;

public class SearchSaleBackVO extends BaseConditionVO {
	
	private Integer orgId;
	private Consumer consumer;
	private String saleNo;
	private String deliverNo;
	private String status;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public String getDeliverNo() {
		return deliverNo;
	}
	public void setDeliverNo(String deliverNo) {
		this.deliverNo = deliverNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
