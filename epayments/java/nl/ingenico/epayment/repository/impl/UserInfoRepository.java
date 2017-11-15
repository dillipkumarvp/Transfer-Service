package nl.ingenico.epayment.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.ingenico.epayment.entity.UserInfo;
import nl.ingenico.epayment.repository.IUserInfoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Implementation class to fetch the USER INFO details.
 * 
 * @author dillipkumar.vp
 *
 */

@Repository
@Transactional
public class UserInfoRepository implements IUserInfoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * @see nl.ingenico.epayment.repository.IUserInfoRepository#getActiveUser(java.lang.String)
	 */
	
	@Override
	public UserInfo getActiveUser(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		String enabled = "ROLE_Y";
		List<?> list = entityManager
				.createQuery(
						"SELECT u FROM UserInfo u WHERE userName=? and enabled=?")
				.setParameter(1, userName).setParameter(2, enabled)
				.getResultList();
		if (!list.isEmpty()) {
			activeUserInfo = (UserInfo) list.get(0);
		}
		return activeUserInfo;
	}
}