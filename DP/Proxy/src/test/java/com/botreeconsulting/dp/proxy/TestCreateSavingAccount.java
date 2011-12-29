package com.botreeconsulting.dp.proxy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.botreeconsulting.dp.ATM;

public class TestCreateSavingAccount {

	private ATM atm;
	
	@Before
	public void setUp() {
		atm = new ATM();
	}
	
	@Test
	public void testSavingAccountCreated() {
		
		int withdrawAmount = 5000;
		
		int balance = atm.withdraw(withdrawAmount);
		
		assertEquals(Account.DEFAULT_BALANCE, balance + withdrawAmount);
		
	}
}
