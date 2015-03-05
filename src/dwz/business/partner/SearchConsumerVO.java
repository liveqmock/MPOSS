package dwz.business.partner;

import dwz.persistence.BaseConditionVO;

public class SearchConsumerVO extends BaseConditionVO {
	
	private Integer orgId;
	private String consumerType;
	private Consumer consumer;
	private String orderNo;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getConsumerType() {
		return consumerType;
	}
	public void setConsumerType(String consumerType) {
		this.consumerType = consumerType;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
