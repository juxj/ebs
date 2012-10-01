package org.tju.ebs.interceptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MaintenanceInterceptor extends HandlerInterceptorAdapter {
	
	private String startTime;
	private String endTime;
	private String maintenancePage;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception{
		System.out.println(this.getClass().getName()+"::preHandle");
		
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		
		if (now.after(sdf.parse(startTime)) && now.before(sdf.parse(endTime))){
			request.setAttribute("start_time", startTime);
			request.setAttribute("end_time", endTime);
			response.sendRedirect(this.maintenancePage);
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}
	
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setMaintenancePage(String maintenancePage) {
		this.maintenancePage = maintenancePage;
	}
	 
	
}
