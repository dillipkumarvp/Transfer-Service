package nl.ingenico.epayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to initiate the Spring context
 * 
 * @author dillipkumar.vp
 *
 */

@SpringBootApplication
public class MyApplication {

	/**
	 * Main Method to load the Spring Context
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
}