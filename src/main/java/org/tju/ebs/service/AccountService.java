package org.tju.ebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tju.ebs.dao.AccountDAO;
import org.tju.ebs.dao.MailTemplateDAO;
import org.tju.ebs.dao.MessageDAO;
import org.tju.ebs.dao.RegistrationDAO;
import org.tju.ebs.entity.Account;
import org.tju.ebs.entity.MailTemplate;
import org.tju.ebs.entity.Message;
import org.tju.ebs.entity.Registration;
import org.tju.ebs.utils.Pagination;
import org.tju.ebs.utils.SysConstants;

@Service
public class AccountService  extends BaseService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private RegistrationDAO registrationDAO;
	
	@Autowired
	private MailTemplateDAO mailTemplateDAO;
	
	@Autowired
	private MessageDAO messageDAO;
	
	public Account getAccountById(String id) {
		return accountDAO.get(id);
	}
	
	public List<Account> getAccountList(int pageNo, int pageSize) {
		Pagination<Account> p = this.accountDAO.getAccountList(1, pageNo, pageSize);
		System.out.println(p.getRecordCount());
		return p.getData();
	}
	
	public void saveAccount(Account account) {
		account = this.accountDAO.save(account);
	}
	
	@Transactional
	public void saveRegistration(Registration registration) {
		registration.setStatus("0");
		registration = this.registrationDAO.save(registration);
		MailTemplate template = 
				mailTemplateDAO.getMailTemplateByCode(SysConstants.MAIL_TEMPLATE_REGISTRATION);
		Message message = new Message();
		message.setReceiver(registration.getEmail());
		message.setTemplateId(template.getId());
		String values = registration.getLastName()
				+registration.getFirstName()+","+registration.getId();
		message.setParameterValues(values);
		messageDAO.save(message);
	}
	
	
}
