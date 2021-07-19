Feature: Validation Services Pages

  #User should click on the Services tab and  navigates to Services page
  Scenario: Verify the scenario when login with valid credentials
    Given Open the Browser
    When clicks on the 'Login' 
    Then Navigate to the login page

  Scenario: Verify the scenario when clicking on the Services tab
    When clicks on the 'Services' tab
    Then Navigate to the Services pages

  Scenario: Verify the scenario when clicking on the grid tiles
    When click on all the grid tiles
