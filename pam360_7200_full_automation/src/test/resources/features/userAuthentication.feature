Feature: User Authentication

  Background:
    Given User is logged in with username and password
  Scenario Outline: Add Users in admin login
    When User is added manually
    When User is imported from AD
    When User is imported from LDAP
    When User is imported from ENTRA ID "<userNames>" "<userGroups>" "<groupNames>"
    And Login to "<userType>" user

    Examples:
      | userNames | userGroups  | groupNames  | userType  |
      | pmptest | | | local |