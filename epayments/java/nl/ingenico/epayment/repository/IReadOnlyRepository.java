package nl.ingenico.epayment.repository;

/**
 * Base interface for all Read only Operations
 * 
 * @author lycph11
 *
 * @param <T>
 */

@FunctionalInterface
public interface IReadOnlyRepository<T> {
	
	/**
	 * Return the Account details based on the ID
	 * 
	 * @param id
	 * @return T
	 */
	T getById(Long id);

}
