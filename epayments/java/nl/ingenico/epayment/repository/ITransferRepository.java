package nl.ingenico.epayment.repository;

import java.util.List;

import nl.ingenico.epayment.entity.Transfer;

/**
 * 
 * Interface to hold all transfer operations.
 * [Created for future expansion]
 * 
 * @author dillipkumar.vp
 *
 */
public interface ITransferRepository extends IWriteRepository<Transfer>{
	
	/**
	 * Get a specific transaction based on the source ID.
	 * 
	 * @param sourceAccountId
	 * @return List<Transfer>
	 */
	List<Transfer> getTransfersBySource(Long sourceAccountId);

	/**
	 * Get a specific transaction based on the target ID.
	 * 
	 * @param targetAccountId
	 * @return List<Transfer>
	 */
	List<Transfer> getTransfersByTarget(Long targetAccountId);
	
}
