package com.jpizarro.th.server.message.model.persistence.accessor;

import java.util.List;

import com.jpizarro.th.server.generic.model.persistence.accessor.GenericAccessorHibernate;
import com.jpizarro.th.server.message.model.entity.Message;


public class MessageAccessorHibernate 
extends GenericAccessorHibernate<Message, Long> 
implements MessageAccessor {

	@Override
	public List<Message> findByReceiver(
			com.jpizarro.th.server.message.model.entity.User receiver) {
		// TODO Auto-generated method stub
		return null;
	}

}
