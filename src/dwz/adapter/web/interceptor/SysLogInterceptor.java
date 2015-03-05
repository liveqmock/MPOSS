package dwz.adapter.web.interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dwz.business.common.CommonServiceMgr;
import dwz.business.common.SessionOper;
import dwz.persistence.beans.SysLog;
import dwz.web.SystemLog;

public class SysLogInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private CommonServiceMgr commonServiceMgr;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		SessionOper sessionOper = (SessionOper)request.getSession().getAttribute("sessionOper");
		HandlerMethod handlerMethod = null;
		try {
			handlerMethod = (HandlerMethod) handler;
		} catch (Exception e) {
			return true;
		}
        Method method = handlerMethod.getMethod();
        SystemLog annotation = method.getAnnotation(SystemLog.class);
        if (annotation != null) {
        	SysLog sysLog = new SysLog();
        	sysLog.setLogTime(new Date());
        	sysLog.setOrgId(sessionOper.getOrgId());
        	sysLog.setOrgName(sessionOper.getOrgName());
        	sysLog.setOperId(sessionOper.getOperId());
        	sysLog.setUserName(sessionOper.getUserName());
        	sysLog.setLogContent(annotation.value());
        	commonServiceMgr.insertSysLog(sysLog);
        }
		
		return true;
	}

}
