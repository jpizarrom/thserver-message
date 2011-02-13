package com.jpizarro.th.server.message.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.lib.message.entity.MessageTO;
import com.jpizarro.th.lib.message.entity.UserTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.message.model.entity.Message;
import com.jpizarro.th.server.message.model.entity.User;
import com.jpizarro.th.server.message.model.persistence.accessor.MessageAccessor;
import com.jpizarro.th.server.message.model.persistence.accessor.UserAccessor;
import com.jpizarro.th.server.message.util.MessageUtils;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageAccessor messageAccessor;
	@Autowired
	private UserAccessor userAccessor;
	
	@Override
	@Transactional
	public MessageTO create(MessageTO entity) throws DuplicateInstanceException {
		Message msg = MessageUtils.messageFromMessageTO(entity);
		for(UserTO uto: entity.getReceivers()){
			User u = null;
			try {
				u = userAccessor.find(uto.getUserId());
			} catch (InstanceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				userAccessor.create(new User(uto.getUserId()));
			}
			if (u != null)
				msg.getReceivers().add(u);
		}
		messageAccessor.create(msg);
		return MessageUtils.messageTOFromMessage(msg);
	}

	@Override
	public MessageTO find(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		Message msg = messageAccessor.find(id);
		MessageTO to = MessageUtils.messageTOFromMessage(msg);
		
		return to;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return messageAccessor.exists(id);
	}

	@Override
	@Transactional
	public MessageTO update(MessageTO entity) {
		Message msg = MessageUtils.messageFromMessageTO(entity);
		messageAccessor.update(msg);
		return MessageUtils.messageTOFromMessage(msg);
	}

	@Override
	@Transactional
	public void remove(Long id) throws InstanceNotFoundException {
		messageAccessor.remove(id);
	}

}
