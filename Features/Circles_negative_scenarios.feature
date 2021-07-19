Feature: Test Circle negative functionality

  Scenario: Validate that Proceed button is disabled and do not select a provider from the drop down
    Given User is on landing page
    When  Drop down list is clicked and No selection is made
    Then Proceed to next page
    
    Scenario: Validate login when Username and Password fields are blank
    	When Enter Username and password blank
		Then Validate the error message on text fields
    
    Scenario: Validate invalid Username  and Password in the Login Page
    	When Enter incorrect Username and Password
		Then verify error message for incorrect username and password
    	
		Scenario: Validate when Username field is blank
			When Enter Username field as blank and valid password
			Then Validate the error message when username is blank
		
		Scenario: Validate when Password field is blank
			When Enter the password as blank
			Then Validate message when Password field is blank
			
		Scenario: Validate the login with valid Usename and invalid Password
			When  login with valid Username and invalid Password
			Then Validation message invalid password
			
		Scenario: Validate that the user is not allowed to login with invalid Usename and valid Password
			When login with invalid Username and valid Password
			Then Validation message invalid username