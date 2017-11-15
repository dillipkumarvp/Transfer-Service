package nl.ingenico.epayment.repository;

import nl.ingenico.epayment.entity.AccountInfo;

/**
 * Interface to hold operations related to Account details.
 * 
 * @author dillipkumar.vp
 *
 */

public interface IAccountRepository extends IReadOnlyRepository<AccountInfo>{

	/**
	 * Operation to create master account
	 * @param account
	 */
	public void createAccount(AccountInfo account);
	
	/**
	 * Operations to update master account
	 * @param account
	 */
	public void updateAccount(AccountInfo account);
	
	/*
	 * (non-Javadoc)
	 * @see nl.ingenico.epayment.repository.IReadOnlyRepository#getById(java.lang.Long)
	 */
	@Override
	public AccountInfo getById(Long id);
	
}
