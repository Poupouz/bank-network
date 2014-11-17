package com.ensimag.banknetwork.server.bank;

import com.ensimag.api.bank.IAccount;
import com.ensimag.api.bank.IUser;
import com.ensimag.api.bank.NotEnoughMoneyException;
import java.util.UUID;

public class Account implements IAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5778538615219571623L;
	
	public static int INIT_CASH = 100;
	public static int INIT_ALLOWED_OVERDRAW = 0;
	
	private IUser accountUser;
	private long accountNumber;
	private int total;
	private int allowedOverdraw;
	
	public Account(IUser accountUser) {
		this.accountUser = accountUser;
		this.allowedOverdraw = INIT_ALLOWED_OVERDRAW;
		this.total = INIT_CASH;
		this.accountNumber = UUID.randomUUID().getLeastSignificantBits();
	}

	public IUser getAccountUser() {
		return accountUser;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public int add(int amount) {
		return (total += amount);
	}

	public int remove(int amount) throws NotEnoughMoneyException {
		if (total - amount < allowedOverdraw){
			throw new NotEnoughMoneyException(this);
		} else {
			return (total -= amount);
		}
	}

	public int getTotal() {
		return total;
	}

	public int setAllowedOverdraw(int overdraw) {
		return (allowedOverdraw = overdraw);
	}

	@Override
	public int hashCode() {
	    return (int) (accountNumber % Integer.MAX_VALUE);
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    final IAccount other = (IAccount) obj;
	    if (accountNumber != other.getAccountNumber())
	        return false;
	    return true;
	}
}
