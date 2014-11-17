package com.ensimag.banknetwork.server.bank;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.security.auth.login.AccountNotFoundException;

import com.ensimag.api.bank.IAccount;
import com.ensimag.api.bank.IBank;
import com.ensimag.api.bank.IUser;

public class Bank implements IBank {

	private List<IAccount> accounts;
	private long bankId;
	
	public Bank() {
		this.accounts = new ArrayList<IAccount>();
		this.bankId = UUID.randomUUID().getLeastSignificantBits();
	}

	public List<IAccount> getAccounts() throws RemoteException {
		return accounts;
	}

	public IAccount getAccount(long number) throws AccountNotFoundException,
			RemoteException {
		for (Iterator<IAccount> iterator = accounts.iterator(); iterator.hasNext();) {
			IAccount account = (IAccount) iterator.next();
			if (account.getAccountNumber() == number)
				return account;
		}
		throw new AccountNotFoundException();
	}

	public IAccount openAccount(IUser user) throws RemoteException {
		IAccount account = new Account(user);
		accounts.add(account);
		return account;
	}

	public boolean closeAccount(long number) throws AccountNotFoundException,
			RemoteException {
		for (Iterator<IAccount> iterator = accounts.iterator(); iterator.hasNext();) {
			IAccount account = (IAccount) iterator.next();
			if (account.getAccountNumber() == number){
				try {
					iterator.remove();					
					return true;
				} catch (UnsupportedOperationException e){
					return false;
				}
			}
		}
		throw new AccountNotFoundException();
	}

	public long getBankId() {
		return bankId;
	}

}
