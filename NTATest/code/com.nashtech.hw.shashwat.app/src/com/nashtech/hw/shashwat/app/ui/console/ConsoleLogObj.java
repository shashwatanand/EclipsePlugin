package com.nashtech.hw.shashwat.app.ui.console;

/**
 * The Class MessageConsoleLogObj.
 * 
 * @author shashwat.anand
 */
public class ConsoleLogObj {
	
	/** The message type. */
	private MessageType messageType;
	
	/** The log str. */
	private String logStr;
	
	/**
	 * Instantiates a new message console log obj.
	 *
	 * @param messageType the message type
	 * @param logStr the log str
	 */
	public ConsoleLogObj(MessageType messageType, String logStr) {
		super();
		this.messageType = messageType;
		this.logStr = logStr;
	}
	
	/**
	 * Gets the message type.
	 *
	 * @return the message type
	 */
	public MessageType getMessageType() {
		return messageType;
	}
	
	/**
	 * Sets the message type.
	 *
	 * @param messageType the new message type
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	
	/**
	 * Gets the log str.
	 *
	 * @return the log str
	 */
	public String getLogStr() {
		return logStr;
	}
	
	/**
	 * Sets the log str.
	 *
	 * @param logStr the new log str
	 */
	public void setLogStr(String logStr) {
		this.logStr = logStr;
	}
}
