@SmokeTest
Feature: User Login Functionality

  Scenario: Successful Login with Valid Credentials
    Given the user is on the login page
    When the user enters username "testuser" and password "password123"
    And clicks the login button
    Then the user should be redirected to the dashboard page
    And a welcome message "Welcome, testuser!" should be displayed