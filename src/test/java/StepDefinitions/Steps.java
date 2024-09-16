package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.Resources;
import pages.Users;
import utility.BrowserDriver;

public class Steps{

    LoginPage loginPage = new LoginPage(BrowserDriver.driver);
    Users users = new Users(BrowserDriver.driver);
    Resources resources = new Resources(BrowserDriver.driver);

    @Given("User is logged in with username {string} and password {string}")
    public void user_is_logged_in_with_username_and_password(String username, String password) throws InterruptedException {
        loginPage.webBrowserLogin(username,password);
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
        throw new io.cucumber.java.PendingException();
    }

    @When("User {string} {string} {string}is imported from ENTRAID")
    public void userIsImportedFromENTRAID(String userNames, String userGroups, String groupName) throws InterruptedException {
        users.addUserFromENTRAID(userNames,userGroups,groupName);
        String out = users.addUserFromLDAP();
        System.out.println(out);
    }

    @Then("User is logged out")
    public void userIsLoggedOut() throws InterruptedException {
        loginPage.webBrowserLogout();
    }

    @When("Resources are imported manually")
    public void resourcesAreImportedManually() {
        //resources.addResourceManually();
    }
}
