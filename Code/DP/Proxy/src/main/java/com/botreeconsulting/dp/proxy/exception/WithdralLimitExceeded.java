package com.botreeconsulting.dp.proxy.exception;

@SuppressWarnings("serial")
public class WithdralLimitExceeded extends RuntimeException {
	public WithdralLimitExceeded() {
		super("You cannot withdraw more than 20000");
	}
}
