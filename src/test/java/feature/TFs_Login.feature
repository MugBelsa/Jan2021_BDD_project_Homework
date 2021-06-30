Feature: validate Techfios login functionality 
       
@Scenario1
Scenario Outline: User should be able to login with the valid credentials 
    Given User is on the Techfios login page       
	When user should be able to enter the "<userName>" and "<password>"           
	And user should be able to click on signin button    
	Then user should be able to land on the Dashboard page  
	Then user clicks on Bank and Cash Button  
      
	
Examples:

|userName         |password|
|demo@techfios.com|abc123  |         
