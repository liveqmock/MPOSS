package dwz.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.gson.Gson;

import dwz.business.common.SessionOper;
import dwz.web.editor.DateEditor;
import dwz.web.editor.DoubleEditor;
import dwz.web.editor.IntegerEditor;
import dwz.web.editor.LongEditor;

public abstract class BaseController {
	@Autowired
	protected ResourceBundleMessageSource _res;
	
//	@Autowired
//	protected SpringContextHolder _contextHolder;

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	protected ModelAndView ajaxDone(int statusCode, String message) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		return mav;
	}
	
	protected ModelAndView ajaxDoneSuccess(String message) {
		return ajaxDone(200, message);
	}
	
	protected ModelAndView ajaxDoneError(String message) {
		return ajaxDone(300, message);
	}
	protected String getMessage(String code) {
		return this.getMessage(code, new Object[] {});
	}

	protected String getMessage(String code, Object arg0) {
		return getMessage(code, new Object[] { arg0 });
	}

	protected String getMessage(String code, Object arg0, Object arg1) {
		return getMessage(code, new Object[] { arg0, arg1 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2) {
		return getMessage(code, new Object[] { arg0, arg1, arg2 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2, Object arg3) {
		return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
	}

	protected String getMessage(String code, Object[] args) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);

		return _res.getMessage(code, args, locale);
	}
	
	protected SessionOper getSessionOper(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		return (SessionOper)session.getAttribute("sessionOper");
	}
	
	public void responseJson(Object obj,HttpServletResponse response){
		Gson gson = new Gson();
		String result = "";
		if(null != obj)
			result = gson.toJson(obj);

		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			
		} finally{
			out.flush();
			out.close();
		}
	}
	
}
