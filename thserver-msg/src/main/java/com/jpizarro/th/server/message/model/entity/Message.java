package com.jpizarro.th.server.message.model.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message {
	private long messageId;
	private String messageBody;
	private Calendar date;
	private User sender = null;
	private User receiver = null;
	private boolean readed = false;
	private int type;
	
	public Message() {
		super();
	}
	
	public Message(long messageId, String messageBody, Calendar date,
			User sender, User receiver, boolean readed, int type) {
		super();
		this.messageId = messageId;
		this.messageBody = messageBody;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
		this.readed = readed;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
            generator="MessageIdGenerator")
    @SequenceGenerator(             // It only takes effect for
            name="MessageIdGenerator", // databases providing identifier
            sequenceName="MessageSeq") // generators.
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
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "senderId")
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiverId")
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public boolean isReaded() {
		return readed;
	}
	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Message [messageId=" + messageId +", date=" + date + ", messageBody="
				+ messageBody + ", readed="
				+ readed + ", receiver=" + receiver + ", sender=" + sender
				+ ", type=" + type + "]";
	}
	
	

}
