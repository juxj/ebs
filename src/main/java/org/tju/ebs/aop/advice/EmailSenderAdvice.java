package org.tju.ebs.aop.advice;

import java.lang.reflect.Method;
import java.util.Calendar;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.tju.ebs.dao.MessageDAO;
import org.tju.ebs.dao.MessageTemplateDAO;
import org.tju.ebs.entity.Message;
import org.tju.ebs.entity.MessageTemplate;
import org.tju.ebs.entity.Registration;
import org.tju.ebs.service.AccountService;
import org.tju.ebs.utils.DateUtil;
import org.tju.ebs.utils.StringUtil;
import org.tju.ebs.utils.SysConstants;

public class EmailSenderAdvice implements AfterReturningAdvice {

	@Autowired
	private MessageTemplateDAO  messageTemplateDAO;
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		
		Registration registration = (Registration) args[0];
		@SuppressWarnings("static-access")
		String emailTemplate = ((AccountService) target).EMAIL_TEMPLATE;
		MessageTemplate template = 
				messageTemplateDAO.getMailTemplateByCode(emailTemplate);
		
		Message message = new Message();
		String messageId = StringUtil.getUUID();
		message.setId(messageId);
		message.setReceiver(registration.getEmail());
		message.setSubject(template.getSubject());
		message.setBody(String.format(template.getBody(),
				registration.getLastName()+registration.getFirstName(), 
				SysConstants.BASE_PATH,
				registration.getId(), messageId));
		message.setExpiredDate(DateUtil.getDate(Calendar.HOUR_OF_DAY, template.getExpiredHours()));
		messageDAO.insert(message);
		System.out.println("email has been sent out.");
	}

}
