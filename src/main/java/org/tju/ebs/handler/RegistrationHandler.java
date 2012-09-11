package org.tju.ebs.handler;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tju.ebs.entity.Registration;
import org.tju.ebs.entity.User;
import org.tju.ebs.exception.ServiceException;
import org.tju.ebs.service.AccountService;
import org.tju.ebs.utils.PageHeader;

@Controller
@RequestMapping("/registration/")
public class RegistrationHandler extends AbstractHandler{
	

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String view = "register";
		
		Registration registration = new Registration();
		ModelAndView mav = this.getModelAndView(view);
		mav.addObject( "registration", registration);
		mav.setViewName("register/"+view);
		
		return mav;
		
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("registration")Registration registration){
		registration.setApplyDate(Calendar.getInstance().getTime());
		this.accountService.saveRegistration(registration);
		return new ModelAndView("success");
	}
	
	@RequestMapping(value="confirm/{id}/{messageId}", method=RequestMethod.GET)
	public ModelAndView confirm(@PathVariable String id, @PathVariable String messageId){
		String result = "error";
		try {
			//Create user and related information
			User user = this.accountService.register(id, messageId);
			//redirect to change password page.
			result = "password";
			return new ModelAndView(result, "user", user);
		} catch (ServiceException e) {
			//redirect to error page.
			return new ModelAndView(result, "error", e);
		} 
	}
	
	
}
