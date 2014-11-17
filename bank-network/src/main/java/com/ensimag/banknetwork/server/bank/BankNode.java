package com.ensimag.banknetwork.server.bank;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.security.auth.login.AccountNotFoundException;

import com.ensimag.api.bank.IAccount;
import com.ensimag.api.bank.IBank;
import com.ensimag.api.bank.IBankMessage;
import com.ensimag.api.bank.IBankNode;
import com.ensimag.api.bank.IUser;
import com.ensimag.api.message.IAck;
import com.ensimag.api.message.IResult;
import com.ensimag.api.node.INode;

public class BankNode implements IBankNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4691131469611620207L;

	private long id;
	private IBank bank;
	private List<INode<IBankMessage>> neighboors;

	public BankNode(IBank bank) {
		super();
		this.id = UUID.randomUUID().getLeastSignificantBits();
		this.bank = bank;
		this.neighboors = new ArrayList<INode<IBankMessage>>();
	}

	public List<IAccount> getAccounts() throws RemoteException {
		return bank.getAccounts();
	}

	public IAccount getAccount(long number) throws AccountNotFoundException,
			RemoteException {
		return bank.getAccount(number);
	}

	public IAccount openAccount(IUser user) throws RemoteException {
		return bank.openAccount(user);
	}

	public boolean closeAccount(long number) throws AccountNotFoundException,
			RemoteException {
		return bank.closeAccount(number);
	}

	public long getId() throws RemoteException {
		return id;
	}

	public void onMessage(IBankMessage message) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void onAck(IAck ack) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void removeNeighboor(INode<IBankMessage> neighboor)
			throws RemoteException {
		for (Iterator<INode<IBankMessage>> iterator = neighboors.iterator(); iterator.hasNext();) {
			INode<IBankMessage> node = (INode<IBankMessage>) iterator.next();
			if (node.getId() == neighboor.getId()){
				iterator.remove();					
				return;
			}
		}
	}

	public List<IResult<? extends Serializable>> getResultForMessage(
			long messageId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deliverResult(IResult<Serializable> result)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void addNeighboor(INode<IBankMessage> neighboor) throws RemoteException {
		neighboors.add(neighboor);
	}

}
