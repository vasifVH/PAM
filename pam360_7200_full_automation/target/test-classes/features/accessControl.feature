Feature: Adding user to the application

    #Given User is logged in with username and password
#  Scenario: Validate user is imported and logged in
#    When User is added manually
#    When User is imported from AD
#    Then User is logged in successfully

  Scenario: Add Bulk data, Configure Access Control and setup
    Given User is logged in with username and password
    Given Create Resource in bulk
    Given Create User in bulk
    Given Create Resource along with an Account
    Given Add Account to Resources
    When Configure access control for resources from csv
    And Share resource "-res1-" to user "passuser2;passuser4" with access "View Passwords"
    And Share resource "-res2-" to user "passuser2;passuser4" with access "Modify Passwords"
    And Share resource "-res3-" to user "passuser2;passuser4" with access "View Passwords"

  Scenario Outline: Validate the access control for single approval case
    When Login a "local" with "<username>" and "<password>"
    When Access control request by user for resource "<resource name>" account "<account name>" at "<timing>" and <minutes>
    And Logout from the current user
    Given Login a "local" with "<Approvaladmin>" and "<password>"
    And "<Approval>" password access request of resource "<resource name>" account "<account name>" at "<Approval timing>" and "<approval minutes>"
    And Logout from the current user

    Examples:
      | username  | password  | timing  | minutes | Approval  | Approvaladmin   | Approval timing | approval minutes  | resource name | account name  |
      | passuser2 | Test@123  | Later   | 20      | approve   | approvaladmin1  | Later           | 25                | -res1-        | acc1          |
      | passuser4 | Test@123  | Later   | 120      | approve   | approvaladmin1  | Later           | 0                 | -res3-        | acc1          |
      | passuser2 | Test@123  | Later   | 220      | Reject    | approvaladmin1  | Later           | 0                 | -res1-        | acc2          |
      | passuser2 | Test@123  | Now     | 0       | approve   | approvaladmin1  | Now             | 0                 | -res3-        | acc2          |
      | passuser2 | Test@123  | Now     | 0       | approve   | approvaladmin1  | Later           | 20                | -res1-        | acc1          |

    Scenario Outline: Validate the access control for multi approval case
      When Login a "local" with "<username>" and "<password>"
      When Access control request by user for resource "<resource name>" account "<account name>" at "<timing>" and <minutes>
      And Logout from the current user
      Given Login a "local" with "<Approvaladmin1>" and "<password>"
      And "<Approval>" password access request of resource "<resource name>" account "<account name>" at "<Approval timing>" and "<approval minutes>"
      And Logout from the current user
      Given Login a "local" with "<Approvaladmin2>" and "<password>"
      And "<Approval>" password access request of resource "<resource name>" account "<account name>"
      And Logout from the current user
      When Login a "local" with "<username>" and "<password>"
      When password checkout and checkin of resource "<resource name>" account "<account name>"

      Examples:
        | username  | password  | timing  | minutes | Approval  | Approvaladmin1   | Approvaladmin2  | Approval timing | approval minutes  | resource name | account name  |
        | passuser2 | Test@123  | Later   | 20      | approve   | approvaladmin1   | approvaladmin2  | Later           | 25                | -res1-        | acc1          |
        | passuser4 | Test@123  | Later   | 20      | approve   | approvaladmin1   | approvaladmin2  | Later           | 0                 | -res3-        | acc1          |
