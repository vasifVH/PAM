Feature: Validate the rdp session opening
  Scenario: Validate the rdp session opening
    Given User is establishing the rdp session for a resource
    And Check the rdp opened or not
    Then Close the rdp session