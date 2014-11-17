package com.ensimag.banknetwork.server.bank;

import com.ensimag.api.bank.IBankAction;
import com.ensimag.api.bank.IBankMessage;
import com.ensimag.api.message.EnumMessageType;

public class BankMessage implements IBankMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3358254077460299290L;
	
	private long messageId;
	private long originalBankSenderId;
	private long senderId;
	private long destinationBankId;
	private EnumMessageType messageType;
	private IBankAction action;
		
	public BankMessage(long messageId, long originalBankSenderId,
			long senderId, long destinationBankId, EnumMessageType messageType,
			IBankAction action) {
		super();
		this.messageId = messageId;
		this.originalBankSenderId = originalBankSenderId;
		this.senderId = senderId;
		this.destinationBankId = destinationBankId;
		this.messageType = messageType;
		this.action = action;
	}

	public long getMessageId() {
		return messageId;
	}

	public long getOriginalBankSenderId() {
		return originalBankSenderId;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;		
	}

	public long getDestinationBankId() {
		return destinationBankId;
	}

	public EnumMessageType getMessageType() {
		return messageType;
	}

	public IBankAction getAction() {
		return action;
	}

	public BankMessage clone() {
		return new BankMessage(messageId, originalBankSenderId, 
				originalBankSenderId, destinationBankId, messageType, action);
	}

}
