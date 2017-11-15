package nl.ingenico.epayment.controller;

import java.util.HashMap;
import java.util.Map;

import nl.ingenico.epayment.constants.Constants;
import nl.ingenico.epayment.entity.AccountInfo;
import nl.ingenico.epayment.entity.Transfer;
import nl.ingenico.epayment.repository.IAccountRepository;
import nl.ingenico.epayment.repository.ITransferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Controller. All request are handled and routed to desired operations.
 * 
 * 1. Post Operation 2. Get Operation
 * 
 * 
 * @author dillipkumar.vp
 *
 */

@Controller
@RequestMapping("epay")
public class PaymentController {

	@Autowired
	private ITransferRepository transferRepository;
	@Autowired
	private IAccountRepository accountRepository;

	/**
	 * New Account creation. A request body is sent as a parameter 
	 * to the API to create new accounts.  
	 * 
	 * @param account
	 * @param builder
	 * @return Void
	 */
	@PostMapping("account")
	public ResponseEntity<Void> createAccount(@RequestBody AccountInfo account,
			UriComponentsBuilder builder) {
		accountRepository.createAccount(account);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/account/{acnumber}")
				.buildAndExpand(account.getAcnumber()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	/**
	 * Transfer of funds from Source Account to Target account
	 * is passed in the Transfer object.
	 * 
	 * @param transfer
	 * @param builder
	 * @return
	 */
	@PostMapping("maketransfer")
	public ResponseEntity createTransfer(@RequestBody Transfer transfer,
			UriComponentsBuilder builder) {
		AccountInfo sourceAccount = null;
		AccountInfo targetAccount = null;
		//Account availability is checked 
		try {
			sourceAccount = accountRepository.getById(transfer.getSourceAccountId());
			targetAccount = accountRepository.getById(transfer.getTargetAccountId());
		} catch (Exception e) {
			return new ResponseEntity<>(transferReadingError(transfer.getSourceAccountId()),HttpStatus.BAD_REQUEST);
		}
		//Bussiness Rule. When soruce account has less amount than 
		//requested amount then throw a custom exception. 
		if (sourceAccount.getAmount() < transfer.getAmount()) {
			return new ResponseEntity<>(transferCreationError(sourceAccount,targetAccount, transfer), HttpStatus.BAD_REQUEST);
		} 
		else 
		{
			//Adjustments been made to source and target account and saved 
			sourceAccount.setAmount(sourceAccount.getAmount() - transfer.getAmount());
			targetAccount.setAmount(targetAccount.getAmount() + transfer.getAmount());
			accountRepository.updateAccount(sourceAccount);
			accountRepository.updateAccount(targetAccount);
			transferRepository.insert(transfer);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/transfer/{amount}")
				.buildAndExpand(transfer.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	/**
	 * Fetches the account status of the given account number. 
	 * 
	 * @param id
	 * @return AccountInfo
	 */
	@GetMapping("accountinfo/{acnumber}")
	public ResponseEntity<AccountInfo> accountSummary(
			@PathVariable("acnumber") String id) {
		AccountInfo accountInfo = accountRepository.getById(Long.parseLong(id));
		return new ResponseEntity<>(accountInfo, HttpStatus.OK);
	}

	
	/**
	 * Custom Error creation when transfer is not created or done. 
	 * 
	 * @param sourceAccount
	 * @param targetAccount
	 * @param transfer
	 * @return Map<String, Object>
	 */
	private Map<String, Object> transferCreationError(
			final AccountInfo sourceAccount, final AccountInfo targetAccount,
			Transfer transfer) {
		Map<String, Object> objectsInError = new HashMap<>();
		objectsInError.put("sourceAccount", sourceAccount);
		objectsInError.put("targetAccount", targetAccount);
		objectsInError.put(Constants.ERROR_INSUFFICIENT_AMOUNT, transfer);
		return objectsInError;
	}

	
	/**
	 *  Custom Error creation when Account not found for the given input.. 
	 * 
	 * @param accountId
	 * @return Map<String, Object>
	 */
	private Map<String, Object> transferReadingError(final Long accountId) {
		Map<String, Object> objectsInError = new HashMap<>();
		objectsInError.put("accountId", accountId);
		objectsInError.put(Constants.ERROR_ACCOUNT_NOT_FOUND, accountId);
		return objectsInError;
	}
}