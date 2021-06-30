Feature: Validation Bank and Cash New account functionality 

@Scenario2
Scenario Outline: User should be able to login with the valid credentials and Add New Account
   
   Given User is on the Techfios login page                        
	When user should be able to enter the "<userName>" and "<password>"           
	And user should be able to click on signin button    
	When user should be able to land on the Dashboard page  
	Then user clicks on Bank and Cash Button     
	#Then user should be able  to click on the Bank And Cash Button              
	Then user should be able to click on the New Account                
	Then user should fill the form by entering "<AccountTitle>" and "<Description>" and "<InitialBalance>" and "<AccountNumber>" and "<ContactPerson>" and "<Phone>" and "<InternetBankingURL>"               
	Then user should be click on Submitt Button    
	Then validate Accounts  
	
	
	Examples: 
		|userName         |password|AccountTitle   |Description        |InitialBalance |AccountNumber|ContactPerson|Phone       |InternetBankingURL|
		|demo@techfios.com| abc123 |savings Account|My business account|500000         |28965562     |MichFish     |825-456-3156|www.bofa.com      |
		
		