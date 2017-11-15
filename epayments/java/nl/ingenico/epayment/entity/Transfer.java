package nl.ingenico.epayment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Transfer details. Place holder of source & Target account 
 * and amount to be transfered.
 * 
 * @author dillipkumar.vp
 *
 */
@Entity
@Table(name = "transfer")
public class Transfer {

	@Id
	private Long id;
	//Source Account ID
	private Long sourceAccountId;
	//Target Account ID
	private Long targetAccountId;
	//Amount to be transfered
	private float amount;
	//Date of the movement
	private Date movementDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Long getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(Long accountId) {
		this.sourceAccountId = accountId;
	}

	public Long getTargetAccountId() {
		return targetAccountId;
	}

	public void setTargetAccountId(Long targetAccountId) {
		this.targetAccountId = targetAccountId;
	}
}