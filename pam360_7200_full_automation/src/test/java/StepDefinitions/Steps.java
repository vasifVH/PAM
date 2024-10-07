package StepDefinitions;

import Pages.Admin;
import Pages.LoginPage;
import Pages.Resources;
import Pages.Users;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps  {

    LoginPage loginPage = new LoginPage(Hooks.Hooks.getDriver());
    Users users = new Users(Hooks.Hooks.getDriver());;
    Resources resources = new Resources(Hooks.Hooks.getDriver());
    Admin admins = new Admin(Hooks.Hooks.getDriver());
    @Given("User is logged in with username and password")
    public void user_is_logged_in_with_username_and_password() throws InterruptedException {
        loginPage.webBrowserLogin();
    }
      @When("User is added manually")
    public void user_is_added_manually() throws InterruptedException {
        users.addUserManually();
    }

    @When("User is imported from AD")
    public void user_is_imported_from_ad() throws InterruptedException {
        users.addUserFromAD();
    }

    @Then("User is logged in successfully")
    public void user_is_logged_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }
//--------------------------------------------------------------------
    @And("Check the rdp opened or not")
    public void Check_the_rdp_opened_or_not() throws InterruptedException {
        //   users.addUserManually();
    }



    @Then("Close the rdp session")
    public void Close_the_rdp_session() {
        // Write code here that turns the phrase above into concrete actions
        //  throw new io.cucumber.java.PendingException();
    }


    @When("Configure Access control for resource in bulk")
    public void configureAccessControlForResourceInBulk() throws InterruptedException {
        resources.configureAccessControl();
    }

    @Given("Create the windows resource")
    public void createTheWindowsResource() throws InterruptedException {
        resources.addResourceManually();
        resources.addAccountManually();
    }

    @When("Login with {string} and {string}")
    public void loginWithAnd(String username, String password) throws InterruptedException {
        loginPage.webBrowserLogin(username,password);
    }

    @And("Logout from the current user")
    public void logoutFromTheCurrentUser() throws InterruptedException {
        loginPage.webBrowserLogout();
    }

    @And("Share resource to {string}")
    public void shareResourceTo(String userName) throws InterruptedException {
        resources.shareResourceTo(userName);
    }

    @When("Access control request by user at {string} and {int}")
    public void accessControlRequestByUserAt(String timing , int minutes) throws InterruptedException {
        resources.requestPasswordAccess(timing , minutes);
    }

    @And("{string} password access request for this much {int}")
    public void passwordAccessRequestForThisMuch(String approval, int approvalminutes) throws InterruptedException {
        admins.approvePasswordRequest(approval , approvalminutes);
    }

    @When("password checkout and checkin")
    public void passwordCheckoutAndCheckin() throws InterruptedException {
        resources.passCheckout();
        resources.passCheckin();
    }
}
