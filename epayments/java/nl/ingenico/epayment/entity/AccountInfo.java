package nl.ingenico.epayment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Account Details Place holder.
 * 
 * @author dillipkumar.vp
 *
 */

@Entity
@Table(name = "accountinfo")
public class AccountInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	//Account Number
	@Id
	@Column(name = "acnumber")
	private String acnumber;
	//Customer Name
	@Column(name = "name")
	private String name;
	//Available Balance
	@Column(name = "amount")
	private float amount;
	
	public String getAcnumber() {
		return acnumber;
	}
	public void setAcnumber(String acnumber) {
		this.acnumber = acnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
