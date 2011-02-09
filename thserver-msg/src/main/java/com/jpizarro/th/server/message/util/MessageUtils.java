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
		
		return to;
	}
}
