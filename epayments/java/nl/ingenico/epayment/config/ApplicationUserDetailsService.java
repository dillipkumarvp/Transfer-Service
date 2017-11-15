package nl.ingenico.epayment.config;

import java.util.Arrays;

import nl.ingenico.epayment.entity.UserInfo;
import nl.ingenico.epayment.repository.IUserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Check the Authorizations for the given user from the database.
 * Here UserInfo Repository is invoked to know whether User is enabled or not.
 * 
 * @author dillipkumar.vp
 *
 */

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserInfoRepository userInfoDAO;
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) {
		UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getEnabled());
		return new User(activeUserInfo.getUserName(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
	}
}

