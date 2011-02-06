package com.jpizarro.th.server.message.util;

import java.util.ArrayList;
import java.util.List;

import com.jpizarro.th.lib.message.entity.MessageTO;
import com.jpizarro.th.server.message.model.entity.Message;

public class MessageUtils {

	public static MessageTO messageTOFromMessage(Message msg) {
		MessageTO to = new MessageTO(
				msg.getSender().getUserId(),
				msg.getReceiver().getUserId(),
				msg.getMessageBody(),
				msg.getType());
		
		return to;
	}
}
