Feature: Adding user to the application
  Scenario Outline: Validate user is imported and logged in
    Given User is logged in with username "<username>" and password "<password>"
    When User is added manually
    When User is imported from AD
    When User "<userNames>" "<userGroups>" "<groupName>"is imported from ENTRAID
    When Resources are imported manually
    Then User is logged out

    Examples:
    | username | password | userNames | userGroups |  groupName |
    | admin    | Test@123 |           |          |  JeraldGroup |