package nl.ingenico.epayment.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.ingenico.epayment.entity.Transfer;
import nl.ingenico.epayment.repository.ITransferRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO layer to handle all Transfer specific Operations.
 * 
 * @author dillipkumar.vp
 *
 */

@Transactional
@Repository
public class TransferRepository implements ITransferRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.ingenico.epayment.repository.IReadOnlyRepository#getById(java.lang
	 * .Long)
	 */
	@Override
	public Transfer getById(Long id) {
		return entityManager.find(Transfer.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.ingenico.epayment.repository.ITransferRepository#getTransfersBySource
	 * (java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Transfer> getTransfersBySource(Long sourceAccountId) {
		String hql = "FROM Transfer as trans where trans.sourceAccountId =?";
		return (List<Transfer>) entityManager.createQuery(hql)
				.setParameter(1, sourceAccountId).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.ingenico.epayment.repository.ITransferRepository#getTransfersByTarget
	 * (java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Transfer> getTransfersByTarget(Long targetAccountId) {
		String hql = "FROM Transfer as trans where trans.targetAccountId =?";
		return (List<Transfer>) entityManager.createQuery(hql)
				.setParameter(1, targetAccountId).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.ingenico.epayment.repository.IWriteRepository#insert(java.lang.Object)
	 */
	@Override
	public void insert(Transfer element) {
		entityManager.persist(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.ingenico.epayment.repository.IWriteRepository#update(java.lang.Object)
	 */
	@Override
	public void update(Transfer element) {
		Transfer transfer = getById(element.getId());
		transfer.setAmount(element.getAmount());
		transfer.setMovementDate(element.getMovementDate());
		transfer.setSourceAccountId(element.getSourceAccountId());
		transfer.setTargetAccountId(element.getTargetAccountId());
		entityManager.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.ingenico.epayment.repository.IWriteRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Transfer element) {
		entityManager.remove(getById(element.getId()));
	}

}
