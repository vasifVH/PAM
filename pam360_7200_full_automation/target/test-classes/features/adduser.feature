Feature: Adding user to the application

  Background:
    #Given User is logged in with username and password
#  Scenario: Validate user is imported and logged in
#    When User is added manually
#    When User is imported from AD
#    Then User is logged in successfully



  Scenario Outline: Validate the access control configuring
    #Given Create the windows resource
    #When Configure Access control for resource in bulk
    #And Share resource to "<username>"
    #And Logout from the current user
    When Login with "<username>" and "<password>"
    When Access control request by user at "<timing>" and <minutes>
    And Logout from the current user
    Given User is logged in with username and password
    And "<Approval>" password access request for this much <approval minutes>
    And Logout from the current user
    When Login with "<username>" and "<password>"
    When password checkout and checkin

    Examples:
      | username  | password  | timing  | minutes | Approval  | approval minutes  |
      | user  | Vbnm@123  | Later | 30  | approve | 20  |