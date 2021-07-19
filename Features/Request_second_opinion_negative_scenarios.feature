Feature: Test  Request a Second Opinion negative functionality
#User must click on the Request a Second Opinion  and navigated to Request a Second Opinion page
  Scenario: Validate that the user is navigated to Welcome page
    Given Browser opens and opens the URL
    And clicks on the 'Welcome login' button

  Scenario: Validate that the user is able to Login with valid data
    When user enters the valid phonenumber and password
    Then clicks on 'login' button

  Scenario: Validate that the user is able to click on 'Request for a Second opinion' button
    When clicks on 'Request for second opinion' button
    Then navigated to the second opinion page

  Scenario: Validate that the 'Proceed' button is disabled when unchecked the check box self and I agree to DocPanels terms and condition
    When unchecked  the check box 'self and I agree to DocPanels terms and condition'
    Then 'Proceed' button is disabled

  Scenario: Validate the validation message on clicking "Continue to add clinical details" button without uploading "Upload your scan page"
    When clicks on 'Continue to add clinical details' button
    Then validation message is displayed without clicking on'upload my scans'

  Scenario: Validate the validation message on clicking "Continue to add clinical details" button when the check box "I don not have a doctor's reports" is unchecked
    When unchecked the check box 'I do not have a doctors reports'
    And clicks on 'Continue to add clinical details'
    Then Validation message is displayed

  Scenario: Validate not allowed to  click on "Continue to add clinical details" without "upload my reports"
    When click on the 'Continue to add clinical details' button
    Then validation message is displayed without clicking on 'upload my reports'

  Scenario: Validate  not allowed to leave  check box 'other'  unchecked
    When not allowed to uncheck the other check box

  Scenario: Validate that the user is not allowed to proceed when 'First name' and 'Last name' fields are blank
    When 'First name' and 'Last name' fields are blank
    Then validation message is displayed under 'First name' and 'Last name' fields

  Scenario: Validate that the user is not allowed leave blank 'First name' field
    When 'First name' field are blank
    Then validation message is displayed under 'First name' field

  Scenario: Validate that the user is not allowed leave blank 'Last name' field
    When 'Last name' field are blank
    Then validation message is displayed under 'Last name' field

  Scenario: Validate that the user should get a validation message on entering invalid 'First name'  and 'Last name'
    When 'First name' and 'Last name' fields are invalid
    Then validation message is display

  Scenario: Validate that the user is not allowed to Proceed with invalid 'First name' and valid 'Last name'
    When invalid 'First name' and valid 'Last name'
    Then validation message is displayed under 'First name'

  Scenario: Validate that the user is not allowed to Proceed with valid 'First name' and invalid 'Last name'
    When valid 'First name' and invalid 'Last name'
    Then validation message is displayed under 'Last name'

  Scenario: Validate that the "Proceed" button is disabled when  unchecked  the check box 'I agree to DocPanels terms and condition'
    When unchecked the check box 'I agree to DocPanels terms and condition'
    Then not allowed to Proceed

  Scenario: Validate that the "Proceed" button is disabled when unchecked  the check box 'I am the legal guardian or have the necessary consents to order this second opinion'
    When unchecked the check box 'I am the legal guardian or have the necessary consents to order this second opinion'
    Then unable to clicks on 'Proceed' button
