package nl.ingenico.epayment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration class for Security model. 
 * For the given application context /user/** all HTTP entry points are validated against 
 * the ROLE.
 * 
 * @author dillipkumar.vp
 *
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ApplicationUserDetailsService myAppUserDetailsService;
	@Autowired
	private ApplicationAuthenticationEntryPoint appAuthenticationEntryPoint;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/epay/**")
				.access("hasRole('ROLE_Y') or hasRole('ROLE_N')").and()
				.httpBasic().realmName("Auth_Allow")
				.authenticationEntryPoint(appAuthenticationEntryPoint);
	}

	/**
	 * Adding user details to the Authenticaton Manager in order to validate the user.
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myAppUserDetailsService);
	}
}