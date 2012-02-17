package com.botreeconsulting.dp;

import com.botreeconsulting.dp.proxy.Account;
import com.botreeconsulting.dp.proxy.impl.AccountProxy;

/**
 * 
 * A client to services of proxy and real objects
 * 
 */
public class ATM {
	
	private Account account;
	
	public int withdraw(int amount) {
		
		account = new AccountProxy();
		
		return account.withdraw(amount);
		
	}
}
