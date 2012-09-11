package org.tju.ebs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.MessageTemplate;
import org.tju.ebs.entity.MessageTemplateExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.MessageTemplateMapper;

@Service
public class MessageTemplateDAO extends AbstractDAO<MessageTemplate, MessageTemplateExample>{

	@Autowired
	private MessageTemplateMapper messageTemplateMapper;
	
	@Override
	protected AbstractMapper<MessageTemplate, MessageTemplateExample> getMapper() {
		return this.messageTemplateMapper;
	}
	
	/**
	 * Get mail template by code.
	 * @param code
	 * @return
	 */
	public MessageTemplate getMailTemplateByCode(String code) {
		
		MessageTemplate result = null;
		MessageTemplateExample  example = new MessageTemplateExample();
		example.createCriteria().andCodeEqualTo(code);
		List<MessageTemplate> list = this.getByExample(example);
		
		if (list.size()>0) result = list.get(0);
		
		return result;
	}

}
