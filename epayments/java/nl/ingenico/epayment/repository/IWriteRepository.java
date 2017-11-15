package nl.ingenico.epayment.repository;

/**
 * 
 * Created the interface for Future expansion.
 * 
 * @author dillipkumar.vp
 *
 * @param <T>
 */
public interface IWriteRepository<T> extends IReadOnlyRepository<T> {
	
	/**
	 * Generic Implementation for all Write Operations.
	 * 
	 * @param element
	 */
	void insert(T element);

	/**
	 * Generic Implementation for  Update Operations.
	 * 
	 * @param element
	 */
	void update(T element);

	/**
	 * Generic Implementation for all Delete Operations.
	 * 
	 * @param element
	 */
	void delete(T element);

}