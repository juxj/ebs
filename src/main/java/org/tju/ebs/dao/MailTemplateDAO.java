package org.tju.ebs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.MailTemplate;
import org.tju.ebs.entity.MailTemplateExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.MailTemplateMapper;

@Service
public class MailTemplateDAO extends AbstractDAO<MailTemplate, MailTemplateExample>{

	@Autowired
	private MailTemplateMapper mailTemplateMapper;
	
	@Override
	protected AbstractMapper<MailTemplate, MailTemplateExample> getMapper() {
		return this.mailTemplateMapper;
	}
	
	/**
	 * Get mail template by code.
	 * @param code
	 * @return
	 */
	public MailTemplate getMailTemplateByCode(String code) {
		
		MailTemplate result = null;
		MailTemplateExample  example = new MailTemplateExample();
		example.createCriteria().andCodeEqualTo(code);
		List<MailTemplate> list = this.getByExample(example);
		
		if (list.size()>0) result = list.get(0);
		
		return result;
	}

}
