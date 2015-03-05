package dwz.persistence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

public class BaseConditionVO {
	public final static int PAGE_SHOW_COUNT = 20;
	private int pageNum = 1;
	private int pageSize = 0;
	private String orderField;
	private String orderDirection;
	private String keywords;
	private String startDate;
	private String endDate;
	//private Date startDate;
	//private Date endDate;
	
	/*public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}*/
	public String getStartDate() {
		
		GregorianCalendar calendar= new GregorianCalendar(); 
        calendar.add(GregorianCalendar.DATE,-30); 
        Date date=calendar.getTime(); 
        
		if(StringUtils.isBlank(startDate)){
			startDate = new SimpleDateFormat("yyyy-MM-01").format(date);
		}
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		if(StringUtils.isBlank(endDate)){
			endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		}
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize > 0 ? pageSize : PAGE_SHOW_COUNT;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public int getStartIndex() {
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		return pageNum * this.getPageSize();
	}
}
