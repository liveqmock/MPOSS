package dwz.adapter.web.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dwz.common.util.ParameterUtil;

public class VisitInterceptor extends HandlerInterceptorAdapter {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
//		System.out.println("-------------VisitInterceptor--------------");
		
		String requestUrl = request.getRequestURI(); 
		
		Set<String> resourceUrlSet = ParameterUtil.getResurceUrlSet();
		
		if(!resourceUrlSet.contains(requestUrl)) return true;//非系统菜单，就不检查权限了
		
		
		Set<String> myResourceUrlSet =  (HashSet<String>)request.getSession().getAttribute("resourceUrlSet");
		if(myResourceUrlSet.contains(requestUrl)){//自己拥有这个菜单权限
			return true;
		}
		
//		System.out.println("--------------URL:"+requestUrl+"-----------");
		
		request.getRequestDispatcher("/WEB-INF/jsp/noVisit.html").forward(request, response);
		return false;

	}

}