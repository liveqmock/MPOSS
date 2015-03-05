package dwz.business.stock;

public class TakingRptBO {
	
	private Integer no;
	private String providerName;
	private String productModel;
	private String productName;
	private String standard;
	private Integer lockQuantity;
	private Integer canUseQuantity;
	private Integer takingQuantity;
	private Integer changeQuantity;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Integer getLockQuantity() {
		return lockQuantity;
	}
	public void setLockQuantity(Integer lockQuantity) {
		this.lockQuantity = lockQuantity;
	}
	public Integer getCanUseQuantity() {
		return canUseQuantity;
	}
	public void setCanUseQuantity(Integer canUseQuantity) {
		this.canUseQuantity = canUseQuantity;
	}
	public Integer getTakingQuantity() {
		return takingQuantity;
	}
	public void setTakingQuantity(Integer takingQuantity) {
		this.takingQuantity = takingQuantity;
	}
	public Integer getChangeQuantity() {
		return changeQuantity;
	}
	public void setChangeQuantity(Integer changeQuantity) {
		this.changeQuantity = changeQuantity;
	}

}
