------------------------------------------------------------
Ingenico (Transfer Service)
-------------------------------------------------------------

Technical approach / Best Practises:
-------------------------------------

1. 5-10-20 rule followed (5 classes in a package, 10 Methods in a class, 20 Lines per Method)
2. Interface to hide the service agreements.
3. Custom exception thrown by wrapping the original exception 
4. Code is ran through SonarLint, to ensure no major deviations from coding principles.
5. Adopted SPR principles.

Technology Stack:
------------------

1. Basic JAVA 7 features.
2. Spring Boot.(1.5.3)
3. Spring Web Services
4. Spring WS Security
5. Spring JPA
6. HSQL Database
7. Maven
8. Poster plugin (Used to test REST API)


Table Details:
------------------------

1.AccountInfo (Account related information)
2.Transfer (Transfer specific Information)
3.UserInfo (To authenticate the application users)

User Role Specific details:
--------------------------

a). ROLE_Y (Enabled User)

User Name : dillip
password  : dillip


b). ROLE_N (Disabled User)

User Name : kumar
password  : kumar

How to Build the application:
------------------------------

Pre-requistive. (As mentioned in Technology stack above)

From the root project folder issue the following command.

mvn clean package


How to Run the Program:
------------------------

1.  Copy the jar to any folder. (from  :  <Project Folder>\epayments\target\epayments-0.0.1-SNAPSHOT.jar)
2.  Issue the following command from the windows command prompt. 

	a). To start the following  
		1.	Tomcat Server
		2.	In Memory Database (HSQL)
		3. 	Load and execute the database with Default data
		
	Command to issue from the Project Root Folder.	
		
	mvn spring-boot:run 


How to test the application: (User SOUP UI/Poster..)
--------------------------------

Response/request type : application/json

1). To add Accounts: (Add n number of accounts needed with different JSON request)

http://localhost:8080/epay/account

Sample JSON request:
{
"acnumber":"1",
"name":"myaccount",
"amount":"2000"
}

2).To transfer money 

http://localhost:8080/epay/maketransfer

Sample JSON request:
{
"id":"101",
"sourceAccountId":"2",
"targetAccountId":"1",
"amount":"100",
"movementDate":"01012017"
}

3). To access account information

http://localhost:8080/epay/accountinfo/1

				
Requirement FullfillMent / Future improvements:
----------------------------------------------------

Skipped the following which is part of best practises (Due to time constraints)

1. Junit testcases are not written as part of the time constraints
2. Logging is not handled. 
3. Service layer should be introduced between Controller and DAO/Repository layer.Which is always a good practise. 
4. Primary key/ID (Account ID, Transfer ID) are now manual. This should be auto generated. 

