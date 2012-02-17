package com.botreeconsulting.aop;

public class Broadcaster{
	
	protected SecretMessage secretMessage;
		
	public SecretMessage getSecretMessage() {
		return secretMessage;
	}

	public void setSecretMessage(SecretMessage secretMessage) {
		this.secretMessage = secretMessage;
	}

	public void broadcast(){
		System.out.println(secretMessage.getMessage());
	}
}
