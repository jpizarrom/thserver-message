package com.jpizarro.th.server.message.model.persistence.accessor;

import java.util.List;

import com.jpizarro.th.server.generic.model.persistence.accessor.GenericAccessor;
import com.jpizarro.th.server.message.model.entity.Message;
import com.jpizarro.th.server.message.model.entity.User;

public interface MessageAccessor 
extends GenericAccessor<Message, Long> {
	
	public List<Message> findByReceiver(User receiver);

}
