Feature: Edit Resource to the application

  Background:
    Given User is logged in with username and password
#  Scenario: Validate user is imported and logged in
#    When User is added manually
#    When User is imported from AD
#    Then User is logged in successfully



  Scenario Outline: Validate Edit Resource functionality
    #Given Create the windows resource
    When Edit following "<fieldNames>" with "<fieldValues>" in the Resource

    Examples:
      | fieldNames  | fieldValues  |
      | DNS Name / IP Address,Resource Type,Domain Name,Description,Department,Resource URL,Location,Password Policy,Restrict RDP Using Local Accounts ,VNC Port for Auto Logon,SSH Port for Auto Logon,RDP Port for Auto Logon  | DNSNAME,Windows,test desc,testdomainname,depart,https://www.google.com,locate,Medium,true,5800,24,3389  |