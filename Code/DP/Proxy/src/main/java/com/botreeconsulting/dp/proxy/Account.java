package com.botreeconsulting.dp.proxy;

import com.botreeconsulting.dp.proxy.impl.AccountProxy;
import com.botreeconsulting.dp.proxy.impl.SavingAccount;

/**
 * This interface is implemented by both proxy({@link AccountProxy}) and real object({@link SavingAccount}) 
 *
 */
public interface Account {
	
	int DEFAULT_BALANCE = 25000;
	
	/**
	 * Deduct <code>amount</code> from {@link Account#DEFAULT_BALANCE}
	 * 
	 * @param amount to be debited from Account
	 * 
	 * @return
	 */
	public int withdraw(int amount);
	
}
