package dwz.common.tags;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import dwz.business.common.SessionOper;
import dwz.common.util.StringUtils;


public class LinkTag extends TagSupport {
	
	private static Logger log = Logger.getLogger(LinkTag.class);
	
	private String id;
	private String name;
	private String className;
	private String href;
	private String rel;
	private String title;
	private String target;
	private String desc;
	private String belong;

	public int doStartTag() throws JspException {

		try {
			StringBuffer sb = new StringBuffer();
			
			if(StringUtils.isBlank(belong)){//没有具体归属，则可以显示给任何角色
				sb.append("<a class=\""+className+"\" href=\""+href+"\" rel=\""+rel+"\" title=\""+title+"\" target=\""+target+"\"><span>"+desc+"</span></a>");
			}else{//有具体归属，则只能显示给管理员
				HttpSession session = pageContext.getSession();
				SessionOper sessionOper = (SessionOper)session.getAttribute("sessionOper");
				if(sessionOper.isSuperAdmin()){
					sb.append("<a class=\""+className+"\" href=\""+href+"\" rel=\""+rel+"\" title=\""+title+"\" target=\""+target+"\"><span>"+desc+"</span></a>");
				}
			}
			
			pageContext.getOut().print(sb.toString());
		} catch (IOException e) {
			log.error("输出<tag:link/>出错", e);
		}

		return EVAL_PAGE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}


}
