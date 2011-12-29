package com.botreeconsulting.dp.proxy.impl;

import com.botreeconsulting.dp.proxy.Account;

/**
 * Real(Expensive) object
 *
 */
public class SavingAccount implements Account {
	
	@Override
	public int withdraw(int amount) {
		System.out.println("Debited "+amount+" from Saving Account");
		return DEFAULT_BALANCE - amount;
	}

}
