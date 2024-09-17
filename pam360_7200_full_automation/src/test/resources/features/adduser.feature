Feature: Adding user to the application

  Background:
    Given User is logged in with username "admin" and password "Test@123"
  Scenario: Validate user is imported and logged in
    When User is added manually
    When User is imported from AD
    Then User is logged in successfully



  Scenario: Validate the rdp session opening
    Given User is establishing the rdp session for a resource
    And Check the rdp opened or not
    Then Close the rdp session