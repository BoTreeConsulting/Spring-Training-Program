package com.botreeconsulting.dp.proxy.exception;

@SuppressWarnings("serial")
public class WithdralLimitExceed extends RuntimeException {
	public WithdralLimitExceed() {
		super("You cannot withdraw more than 20000");
	}
}
