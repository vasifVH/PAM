Feature: "Mac Agent" Testing

  Background:
    Given User is logged in with username and password
  Scenario: change password for one account
    When Change password for the "user1" of the "pam-mac-10 - Agent1" with "generate password" "" for "local" resource
    When Change password for the "user3" of the "pam-mac-10 - Agent1" with "generate password" "" for "remote" resource

  Scenario: change password using bulk action for multiple accounts of a resource
    When perform bulk password reset for the resources "pam-mac-10 - Agent1" whose common string "pam-mac-10 - Agent1" with "Qazxssdgagdf#4535" in "remote"

  Scenario:configure remote password reset
    When configure remote password reset for resource "pam-mac-10 - Agent1" with "local" account "test"

  Scenario: Transfer ownership
    When Transfer Owner of the resource "pam-mac-10 - Agent1" to user "user1 - user 1"
    And Logout from the current user
    And Login to "local" user
    When Change password for the "user3" of the "pam-mac-10 - Agent1" with "given password" "Qwiljghsdgf@12423" for "remote" resource

