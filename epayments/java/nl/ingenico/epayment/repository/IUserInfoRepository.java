package nl.ingenico.epayment.repository;

import nl.ingenico.epayment.entity.UserInfo;


/**
 * 
 * Interface definition for User authentication to access the application.
 * 
 * @author dillipkumar.vp
 *
 */

@FunctionalInterface
public interface IUserInfoRepository {
	
	/**
	 * Fetch the User Details from in-mem Datbase for the given User Name.
	 * @param userName
	 * @return
	 */
	UserInfo getActiveUser(String userName);
}