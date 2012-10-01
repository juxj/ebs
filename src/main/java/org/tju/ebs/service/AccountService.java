package org.tju.ebs.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tju.ebs.dao.AccountDAO;
import org.tju.ebs.dao.CompanyDAO;
import org.tju.ebs.dao.MessageDAO;
import org.tju.ebs.dao.MessageTemplateDAO;
import org.tju.ebs.dao.RegistrationDAO;
import org.tju.ebs.dao.UserDAO;
import org.tju.ebs.entity.Account;
import org.tju.ebs.entity.Company;
import org.tju.ebs.entity.Message;
import org.tju.ebs.entity.MessageTemplate;
import org.tju.ebs.entity.Registration;
import org.tju.ebs.entity.User;
import org.tju.ebs.exception.ServiceException;
import org.tju.ebs.utils.DateUtil;
import org.tju.ebs.utils.ErrorMessage;
import org.tju.ebs.utils.Pagination;
import org.tju.ebs.utils.StringUtil;
import org.tju.ebs.utils.SysConstants;

@Service
public class AccountService  extends BaseService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RegistrationDAO registrationDAO;
	
	@Autowired
	private MessageTemplateDAO messageTemplateDAO;
	
	@Autowired
	private MessageDAO messageDAO;
	
	public Account getAccountById(String id) {
		return accountDAO.get(id);
	}
	
	@Transactional
	public User register(String registrationId, String messageId) throws ServiceException {
		
		User result = null;
		
		List<String> errors = new ArrayList<String>();
		
		Message message = this.messageDAO.get(messageId);
		
		if (message.getExpiredDate().after(DateUtil.getNow())){
			String error = getMessage("err.link.expired");
			errors.add(error);
		}
		try {
			//
			message.setClickTime(DateUtil.getNow());
			messageDAO.save(message);
			//
			Registration registration = registrationDAO.get(registrationId);
			registration.setStatus("1");
			this.registrationDAO.save(registration);
			//
			Company company = new Company();
			company.setShortName(registration.getCompanyName());
			company = companyDAO.save(company);
			//
			User user = new User();
			user.setCompanyId(company.getId());
			user.setEmail(registration.getEmail());
			user.setMobile(registration.getEmail());
			user.setUserName(registration.getLastName()+registration.getFirstName());
			user = userDAO.save(user);
			//
			result = user;
			
		} catch (Exception e) {
			errors.add(e.toString());
		}
		
		if (errors.size()>0) {
			ServiceException e = new ServiceException(errors);
			throw e;
		}
		
		return result;
	}
	

	@Transactional
	public ErrorMessage saveRegistration(Registration registration) {
		ErrorMessage em = null;
		
		registration.setStatus("0");
		registration = this.registrationDAO.save(registration);
		/*
		MessageTemplate template = 
				messageTemplateDAO.getMailTemplateByCode(SysConstants.MAIL_TEMPLATE_REGISTRATION);
		
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
		*/
		return em;
	}
	
	public List<Account> getAccountList(int pageNo, int pageSize) {
		Pagination<Account> p = this.accountDAO.getAccountList(1, pageNo, pageSize);
		System.out.println(p.getRecordCount());
		return p.getData();
	}
	
	public void saveAccount(Account account) {
		account = this.accountDAO.save(account);
	}
	
}
