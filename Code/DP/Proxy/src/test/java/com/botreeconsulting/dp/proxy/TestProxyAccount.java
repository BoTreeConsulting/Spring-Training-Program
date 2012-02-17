package com.botreeconsulting.dp.proxy;

import org.junit.Before;
import org.junit.Test;

import com.botreeconsulting.dp.ATM;
import com.botreeconsulting.dp.proxy.exception.WithdralLimitExceeded;

public class TestProxyAccount {

	private ATM atm;
	
	@Before
	public void setUp() {
		atm = new ATM();
	}
	
	@Test(expected=WithdralLimitExceeded.class)
	public void testAccountProxyDoesNotCreateSavingAccount() {
		atm.withdraw(25000);
	}
	
}
