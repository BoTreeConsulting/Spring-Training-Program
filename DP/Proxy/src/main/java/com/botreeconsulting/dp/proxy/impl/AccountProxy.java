package com.botreeconsulting.dp.proxy.impl;

import com.botreeconsulting.dp.proxy.Account;
import com.botreeconsulting.dp.proxy.exception.WithdralLimitExceed;

/**
 *
 * This is virtual proxy which is a placeholder for “expensive to create” objects({@link SavingAccount}).
 * 
 *
 */
public class AccountProxy implements Account {
	 
	private Account account;
	
	@Override
	public int withdraw(int amount) {
		
		// Validate prior to forwarding the expensive request
		if(amount > 20000) {
			
			System.out.println("ATM will not get connected to Bank Server");
			
			throw new WithdralLimitExceed();
			
		} else {
			
			System.out.println("Connect to Bank Server and update account balance");
			
			// Save expensive object in cache to handle future calls
			if(account == null)
				account = new SavingAccount();
			
			return account.withdraw(amount);
			
		}
			
	}

}
