Feature: Sanity Testing

  Scenario: Test Setup
    When set the build for testing

  Scenario: Add Users
    Given User is logged in with username and password
    When User is added manually
    When User is imported from AD
    When User is imported from LDAP
    When User is imported from ENTRA ID "direct"
    And Logout from the current user

  Scenario Outline: Add Resources
    Given User is logged in with username and password
    Given Create a "<resourceType>" resource
    When Edit following "<fieldNames>" with "<fieldValues>" in the Resource
    When Discover Domain resources
    And Logout from the current user

    Examples:
      | resourceType  | fieldNames  | fieldValues  |
      | Windows | DNS Name / IP Address,Resource Type,Domain Name,Description,Department,Resource URL,Location,Password Policy,Restrict RDP Using Local Accounts ,VNC Port for Auto Logon,SSH Port for Auto Logon,RDP Port for Auto Logon  | DNSNAME,Windows,test desc,testdomainname,depart,https://www.google.com,locate,Medium,true,5800,24,3389  |

  Scenario Outline: Login with ad user
    Given User is logged in with username and password
    And enable "<user>" authentication
    And Logout from the current user
    When Login to "<user>" user
    And Logout from the current user

    Examples:
      | user |
      | ad   |

  Scenario Outline: Login with ldap user
    Given User is logged in with username and password
    And enable "<user>" authentication
    And Logout from the current user
    When Login to "<user>" user
    And Logout from the current user

    Examples:
      | user |
      | ldap   |

  Scenario Outline: Login with entraID user
    Given User is logged in with username and password
    And enable "<user>" authentication
    And Logout from the current user
    When Login to "<user>" user
    And Logout from the current user

    Examples:
      | user |
      | entraID   |

  Scenario Outline: Validate the access control configuring for local user
    Given User is logged in with username and password
    When Configure Access control for resource in bulk
    And Share resource to "<user>"
    And enable "<user>" authentication
    And Logout from the current user
    When Login to "<user>" user
    When Access control request by user at "<timing>" and <minutes>
    And Logout from the current user
    Given User is logged in with username and password
    And "<Approval>" password access request for this much <approval minutes>
    And Logout from the current user
    When Login to "<user>" user
    When password checkout and checkin
    And Logout from the current user

    Examples:
      | timing  | minutes | Approval  | approval minutes  | user  |
      | Later   | 30      | approve   | 20                | local |
