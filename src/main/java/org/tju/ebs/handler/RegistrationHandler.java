package org.tju.ebs.handler;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tju.ebs.entity.Registration;
import org.tju.ebs.service.AccountService;

@Controller
@RequestMapping("/registration/")
public class RegistrationHandler extends AbstractHandler{

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView register(){
		Registration registration = new Registration();
		return new ModelAndView("register", "registration", registration);
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("registration")Registration registration){
		registration.setApplyDate(Calendar.getInstance().getTime());
		this.accountService.saveRegistration(registration);
		return new ModelAndView("success");
	}
	
	
}
