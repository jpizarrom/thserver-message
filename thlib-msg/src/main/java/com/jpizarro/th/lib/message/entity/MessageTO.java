package com.jpizarro.th.lib.message.entity;

import java.io.Serializable;

public class MessageTO implements Serializable{
	private long messageId;
	private long senderLogin;
	private long receiverLogin;
	private String messageBody;
	private int type;
	
//	public MessageTO(Message message) {
//		this.messageId = message.getMessageId();
//		this.type = message.getType();
//		
//		if (message.getSender() == null)
//			this.senderLogin = null;
//		else
//			this.senderLogin = message.getSender().getUsername();
//		if (message.getReceiver() == null)
//			this.receiverLogin = null;
//		else
//			this.receiverLogin = message.getReceiver().getUsername();
//		
//		this.messageBody = message.getMessageBody();	
//	}
	
	public MessageTO(long senderLogin, long receiverLogin,
			String messageBody, int type) {
		super();
		this.setSenderLogin(senderLogin);
		this.setReceiverLogin(receiverLogin);
		this.messageBody = messageBody;
		this.type = type;
	}
	public MessageTO() {
		super();
	}
	public MessageTO(long messageId, long senderLogin, long receiverLogin,
			String messageBody, int type) {
		super();
		this.messageId = messageId;
		this.setSenderLogin(senderLogin);
		this.setReceiverLogin(receiverLogin);
		this.messageBody = messageBody;
		this.type = type;
	}
	public MessageTO(long messageId, String senderLogin, String receiverLogin,
			String messageBody, int type) {
		super();
		this.messageId = messageId;
		this.setSenderLogin(Long.parseLong(senderLogin));
		this.setReceiverLogin(Long.parseLong(receiverLogin));
		this.messageBody = messageBody;
		this.type = type;
	}
	public MessageTO(String senderLogin, String receiverLogin, String messageBody,
			int type) {
		this.setSenderLogin(Long.parseLong(senderLogin));
		this.setReceiverLogin(Long.parseLong(receiverLogin));
		this.messageBody = messageBody;
		this.type = type;
	}
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setSenderLogin(long senderLogin) {
		this.senderLogin = senderLogin;
	}
	public long getSenderLogin() {
		return senderLogin;
	}
	public void setReceiverLogin(long receiverLogin) {
		this.receiverLogin = receiverLogin;
	}
	public long getReceiverLogin() {
		return receiverLogin;
	}
	
}
