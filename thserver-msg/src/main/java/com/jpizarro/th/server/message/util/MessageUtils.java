package com.jpizarro.th.server.message.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jpizarro.th.lib.message.entity.MessageTO;
import com.jpizarro.th.lib.message.entity.UserTO;
import com.jpizarro.th.server.message.model.entity.Message;
import com.jpizarro.th.server.message.model.entity.User;

public class MessageUtils {

	public static MessageTO messageTOFromMessage(Message msg) {
		Set<UserTO> receivers = new HashSet<UserTO>();
		for (User user : msg.getReceivers()) {
			receivers.add(new UserTO(user.getUserId()));
		}
		MessageTO to = new MessageTO(
				msg.getSender().getUserId(),
				receivers,
				msg.getMessageBody(),
				msg.getType());
		to.setMessageId(msg.getMessageId());
		
		return to;
	}
	public static Message messageFromMessageTO(MessageTO to) {
		Message msg = new Message();
		
		msg.setMessageId(to.getMessageId());
		msg.setMessageBody(to.getMessageBody());
		msg.setReaded(to.isReaded());
		msg.setType(to.getType());
		
		msg.setSender(new User(to.getSender()));
		for(UserTO uto: to.getReceivers()){
			msg.getReceivers().add(new User(uto.getUserId()));
		}

		return msg;
		
	}
}
