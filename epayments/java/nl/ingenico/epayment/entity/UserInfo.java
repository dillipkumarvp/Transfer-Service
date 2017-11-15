package nl.ingenico.epayment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User Info details. Used to Authenticate the user 
 * to access the application.
 * 
 * @author dillipkumar.vp
 *
 */


@Entity
@Table(name = "users")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	//User Name
	@Id
	@Column(name = "username")
	private String userName;
	//Password
	@Column(name = "password")
	private String password;
	//Enabled account or disabled
	@Column(name = "enabled")
	private String enabled;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
}
