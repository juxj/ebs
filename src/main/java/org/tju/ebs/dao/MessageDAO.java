package org.tju.ebs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.Message;
import org.tju.ebs.entity.MessageExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.MessageMapper;


@Service
public class MessageDAO extends AbstractDAO<Message, MessageExample> {

	@Autowired
	private MessageMapper messageMapper;

	@Override
	protected AbstractMapper<Message, MessageExample> getMapper() {
		return this.messageMapper;
	}

	
	
}
