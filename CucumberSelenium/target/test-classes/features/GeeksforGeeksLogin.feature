Feature: User credential validation on GeeksforGeeks
  Scenario Outline: Login to GeeksforGeeks with valid credentials
    Given User navigates to the GeeksforGeeks login page
    When User enters <username> and <password>
    Then User clicks the login button
    And Validate the login attempt

    Examples:
      | username         | password |
      | testuser1@gfg.com| pass123  |
      | testuser2@gfg.com| pass456  |
