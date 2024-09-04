Feature: Adding user to the application
  Scenario Outline: Validate user is imported and logged in
    Given User is logged in with username "<username>" and password "<password>"
    When User is added manually
    When User is imported from AD
    Then User is logged in successfully

    Examples:
    | username | password |
    | admin    | Test@123 |