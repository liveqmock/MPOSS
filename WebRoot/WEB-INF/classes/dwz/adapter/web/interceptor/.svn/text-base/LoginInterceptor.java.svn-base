package dwz.adapter.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dwz.business.common.SessionOper;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * 免检地址
	 */
	private List<String> uncheckUrls; 

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
//		System.out.println("-------------LoginInterceptor--------------");
		
		String requestUrl = request.getRequestURI(); 
		if(uncheckUrls.contains(requestUrl)){ 
			return true;
		}
		
		if(requestUrl.indexOf("/styles/dwz") != -1){
			return true;
		}
		
		SessionOper sessionOper = (SessionOper)request.getSession().getAttribute("sessionOper");
		if(sessionOper == null){
//			System.out.println("--------------URL:"+requestUrl+"-----------");
			request.getRequestDispatcher("/WEB-INF/jsp/ajaxTimeout.jsp").forward(request, response);
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}
	
}