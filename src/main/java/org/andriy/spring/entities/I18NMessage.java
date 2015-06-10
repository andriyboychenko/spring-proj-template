package org.andriy.spring.entities;

public class I18NMessage {
	
	private int id;
	private String messageCode; 
	private String messageRU;
	private String messagePT;
	private String messageEN;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageRU() {
		return messageRU;
	}
	public void setMessageRU(String messageRU) {
		this.messageRU = messageRU;
	}
	public String getMessagePT() {
		return messagePT;
	}
	public void setMessagePT(String messagePT) {
		this.messagePT = messagePT;
	}
	public String getMessageEN() {
		return messageEN;
	}
	public void setMessageEN(String messageEN) {
		this.messageEN = messageEN;
	}
	
}
