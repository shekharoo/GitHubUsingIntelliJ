Feature: This is demo of Ninza test run

  Scenario: Successful Login with Valid Credentials
    Given the user is on the login page
    When the user enters username "testuser" and password "password123"
    And clicks the login button
    Then the user should be redirected to the dashboard page
    And a welcome message "Welcome, testuser!" should be displayed

  Scenario: This is 1st scenario
    Given Open Browser
    When  User login with "email" and "password"
    Then  Click on Submit button
