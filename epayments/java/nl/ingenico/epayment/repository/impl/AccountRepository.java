package nl.ingenico.epayment.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.ingenico.epayment.entity.AccountInfo;
import nl.ingenico.epayment.repository.IAccountRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO layer to handle all Account specific CRUD Operations.
 * 
 * @author dillipkumar.vp
 *
 */

@Transactional
@Repository
public class AccountRepository implements IAccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * @see nl.ingenico.epayment.repository.IAccountRepository#getById(java.lang.Long)
	 */
	@Override
	public AccountInfo getById(Long id) {
		return entityManager.find(AccountInfo.class, String.valueOf(id));
	}

	/*
	 * (non-Javadoc)
	 * @see nl.ingenico.epayment.repository.IAccountRepository#createAccount(nl.ingenico.epayment.entity.AccountInfo)
	 */
	@Override
	public void createAccount(AccountInfo account) {
		entityManager.persist(account);
	}

	/*
	 * (non-Javadoc)
	 * @see nl.ingenico.epayment.repository.IAccountRepository#updateAccount(nl.ingenico.epayment.entity.AccountInfo)
	 */
	@Override
	public void updateAccount(AccountInfo account) {
		AccountInfo accountInfo = getById(Long.parseLong(account.getAcnumber()));
		accountInfo.setAmount(account.getAmount());
		entityManager.flush();
	}
}
