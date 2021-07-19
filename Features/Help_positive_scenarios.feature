Feature: Validation on Help Page

  #User must click on the help and nagivated to Frequently asked questions page
  Scenario: Validate that the Frequently asked questions title  should be present in  Help page
    Given site is available
    When clicks on Help tab
    Then verify the Frequently asked questions title

  Scenario: Validate that the Second Opinions title  should be present  and able to see description
    When clicks on Second Opinions title
    Then verify the Second Opinions description is displayed

  Scenario: Validate that the Award Points title  should be present  and able to see description
    When clicks on Award Points title
    Then verify the Award Points description is displayed

  Scenario: Validate that the Referral title  should be present  and able to see description
    When clicks on Referral title
    Then verify the Referral description is displayed

  Scenario: Validate that the Profile title  should be present  and able to see description
    When clicks on Profile title
    Then verify the Profile description is displayed

  Scenario: Validate that the Payments  title  should be present  and able to see description
    When clicks on Payments  title
    Then verify the Payments description is displayed

  Scenario: Validate that the  Add coverage  title  should be present  and able to see description
    When clicks on Add coverage  title
    Then verify the Add coverage description is displayed
