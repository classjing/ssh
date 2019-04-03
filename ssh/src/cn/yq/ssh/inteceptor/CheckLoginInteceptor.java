package cn.yq.ssh.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CheckLoginInteceptor implements HandlerInterceptor{
	
	/**
	 * 在控制器方法执行之前执行
	 * return ture/放行  false 拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//获取Session中共享的username账号，如果有，说明登录，放行。没有：说明没有登录，跳转到登录页面
		String username = (String) request.getSession().getAttribute("username");
		System.out.println(username);
		if(username == null) {//没有登录：跳转到登录页面
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}else {//登录过：放行
			return true;
		}
		
	}
	
	

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
}
