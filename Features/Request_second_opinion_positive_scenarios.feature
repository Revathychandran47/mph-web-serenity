Feature: Test  Request a Second Opinion positive functionality

  #User must click on the Request a Second Opinion  and navigated to Request a Second Opinion page
  Scenario: Validate that user must be able to view Request for a second opinion under Home page
    When home page is open
    Then clicks on 'Request a Second Opinion' button
    And navigated to Request a Second Opinion page

  Scenario: Validate that user must be able to view the texts on the landing page
    Then able to view texts on the page

  Scenario: Validate that user can able to view  box  with  additional information at the bottom of page
    Then able to view the informations

  Scenario: Validate that the user should navigated to Upload Scans page when Proceed button is clicked
    When clicks on 'proceed' button
    Then navigated to Upload Scans page

  Scenario: Validate that user should be able to view the bar and links are working or not
    Then Able to view the bar and links

  Scenario: Validate that the user should be able to upload scans by clicking on 'Upload my scans' button
    When clicks on the 'Upload my scans' button
    Then Able to upload scans

  Scenario: Validate that the user should be able to upload reports by clicking on 'Upload my reports' button
    When clicks on the 'Upload my reports' button
    Then Able to upload reports

  Scenario: Validate that the user should be able to view the dialogue box when I do not have a doctors report checkbox
    When Checkbox 'I do not have a doctors report' is check
    Then Able to view the Upload scans page

  Scenario: Validate that the user should navigated to Upload Scans page by checking Other check box and by entering details
    When checks other check box and enters details
    Then navigated to upload scans page
