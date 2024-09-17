package test.StepDefinitions;


import io.cucumber.java.en.And;
import test.DriverManager.driverManagerClass;
import test.Hooks.hooks;
import test.basePackage.baseClass;
import test.pages.LoginPage;
import test.pages.Users;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import test.pages.resourcesTab;


public class Steps  {

    static LoginPage loginPage;
    static Users users ;
    resourcesTab rdp;
    @Given("User is logged in with username {string} and password {string}")
    public void user_is_logged_in_with_username_and_password(String username, String password) throws InterruptedException {
      //  loadPropertiesFile();
       // driverManagerClass.launchBrowser();
         loginPage = new LoginPage(hooks.getDriver());
         users = new Users(hooks.getDriver());
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
      //  throw new io.cucumber.java.PendingException();
    }
//--------------------------------------------------------------------
@Given("User is establishing the rdp session for a resource")
public void user_is_logged_in_with_username_and_password() throws InterruptedException {
    //   loginPage = new LoginPage(hooks.getDriver());
    //   loginPage.webBrowserLogin("admin","Test@123");

    rdp = new resourcesTab(hooks.getDriver());
    rdp.takeRdp();
        /*users = new Users(driverManagerClass.getDriver());
        loginPage.webBrowserLogin(username,password);*/
}
    @And("Check the rdp opened or not")
    public void Check_the_rdp_opened_or_not() throws InterruptedException {
        //   users.addUserManually();
    }



    @Then("Close the rdp session")
    public void Close_the_rdp_session() {
        // Write code here that turns the phrase above into concrete actions
        //  throw new io.cucumber.java.PendingException();
    }


}
