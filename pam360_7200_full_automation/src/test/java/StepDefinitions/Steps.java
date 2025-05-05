package StepDefinitions;

import Hooks.CSVDataReader;
import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static Hooks.CSVDataReader.readSection;
import static Hooks.Hooks.prop;


public class Steps  {

    private static final Logger log = LoggerFactory.getLogger(Steps.class);
    LoginPage loginPage = new LoginPage(Hooks.Hooks.getDriver());
    Users users = new Users(Hooks.Hooks.getDriver());;
    Resources resources = new Resources(Hooks.Hooks.getDriver());
    Admin admins = new Admin(Hooks.Hooks.getDriver());
    Groups groups = new Groups(Hooks.Hooks.getDriver());


    //Login Related Steps

    @Given("User is logged in with username and password")
    public void user_is_logged_in_with_username_and_password() throws InterruptedException {
        loginPage.webBrowserLogin();
    }

    @And("Login to {string} user")
    public void loginToUser(String userType) throws InterruptedException {
        switch (userType){
            case "local":
                loginPage.webBrowserLogin(prop.getProperty("localUser"), prop.getProperty("userPassword"),"Local Authentication");
                break;
            case "local non-Ascii":
                loginPage.webBrowserLogin(prop.getProperty("nonAsciiLocalUser"), prop.getProperty("userPassword"), "Local Authentication");
                break;
            case "ad":
                loginPage.webBrowserLogin(prop.getProperty("aduser"), prop.getProperty("userPassword"), "PMP2019");
                break;
            case "ldap":
                loginPage.webBrowserLogin(prop.getProperty("ldapuser"), prop.getProperty("userPassword"), "pmp2019.com");
                break;
            case "entraID":
                loginPage.webBrowserLogin(prop.getProperty("entraIDuser"), prop.getProperty("userPassword"), "MARKETPLACEZOHOOUTLOOK.ONMICROSOFT.COM");
                break;
            default:
                break;
        }
    }

    @When("Login a {string} with {string} and {string}")
    public void loginAWithAnd(String domainName, String userName, String password) throws InterruptedException {
        loginPage.webBrowserLogin(userName, password, prop.getProperty(domainName));
    }

    @And("Logout from the current user")
    public void logoutFromTheCurrentUser() throws InterruptedException {
        loginPage.webBrowserLogout();
    }
    //----------------------------------------------------------------------------------------------------------------------

//    @When("User\\/s imported from {string}")
//    public void userSImportedFrom(String userType) throws InterruptedException {
//        switch (userType){
//            case "local":
//                users.addUserManually(prop.getProperty("localUser"), prop.getProperty("userPassword"));
//                break;
//            case "local non-Ascii":
//                users.addUserManually(prop.getProperty("nonAsciiLocalUser"), prop.getProperty("userPassword"));
//                break;
//            case "ad":
//                loginPage.webBrowserLogin(prop.getProperty("aduser"), prop.getProperty("userPassword"), "PMP2019");
//                break;
//            case "ad non-Ascii":
//                loginPage.webBrowserLogin(prop.getProperty("aduser"), prop.getProperty("userPassword"), "PMP2019");
//                break;
//            case "ldap":
//                loginPage.webBrowserLogin(prop.getProperty("ldapuser"), prop.getProperty("userPassword"), "pmp2019.com");
//                break;
//            case "entraID":
//                loginPage.webBrowserLogin(prop.getProperty("entraIDuser"), prop.getProperty("userPassword"), "MARKETPLACEZOHOOUTLOOK.ONMICROSOFT.COM");
//                break;
//            default:
//                break;
//        }
//    }

    @Given("Create User in bulk")
    public void createUserInBulk() {
        try{
            List<String[]> data = readSection("src/test/resources/CSVFiles/Data.csv", "User Data");
            for(String[] row : data) {
                System.out.println(Arrays.toString(row));
                users.addUserManually(row[0],row[1],row[2],row[3],row[4],row[5],row[6]);
            }
        } catch (Exception e) {
            System.out.println("Fetching data from csv failed" + e);
        }
    }

    @When("User is imported from AD")
    public void user_is_imported_from_ad() throws InterruptedException {
        users.addUserFromAD();
    }

    @When("User is imported from LDAP")
    public void userIsImportedFromLDAP() {
        users.addUserFromLDAP();
    }

    @When("User is imported from ENTRA ID {string}")
    public void userIsImportedFromENTRAID(String importType) throws InterruptedException {
        users.addUserFromENTRAID(importType);
    }
    //------------------------------------------------------------------------------------------------------------------
    @And("Check the rdp opened or not")
    public void Check_the_rdp_opened_or_not() throws InterruptedException {
        //   users.addUserManually();
    }

    @Given("Create {string} Resource in bulk")
    public void createResourceInBulk(String resourceType) {
        try{
            List<String[]> data = readSection("src/test/resources/CSVFiles/Data.csv", "Resources");
            for(String[] row : data) {
                if(row[2].equalsIgnoreCase(resourceType)) {
                    System.out.println(Arrays.toString(row));
                    resources.addResourceManually(row[0], row[1], row[2], "with Account");
                }
            }
        } catch (Exception e) {
            System.out.println("Fetching data from csv failed" + e);
        }
    }

    @Given("Create Resource in bulk")
    public void createResourceInBulk() {
        try{
            List<String[]> data = readSection("src/test/resources/CSVFiles/Data.csv", "Resources");
            for(String[] row : data) {
                System.out.println(Arrays.toString(row));
                resources.addResourceManually(row[0], row[1], row[2], "without Account");
            }
        } catch (Exception e) {
            System.out.println("Fetching data from csv failed" + e);
        }
    }

    @Given("Create Resource along with an Account")
    public void createResourceAlongWithAnAccount() {
        try{
            List<String[]> data = readSection("src/test/resources/CSVFiles/Data.csv",
                    "Resource with Account Details");
            for(String[] row : data) {
                System.out.println(Arrays.toString(row));
                resources.addResourceManually(row[0], row[1], row[2], "without Account");
                resources.accountPage(row[0]);
                resources.addAccountManually(row[3], row[4], row[5], row[2], "without Account");
            }
        } catch (Exception e) {
            System.out.println("Fetching data from csv failed" + e);
        }
    }

    @Given("Add Account to Resources")
    public void addAccountToResources() {
        try{
            List<String[]> data = readSection("src/test/resources/CSVFiles/Data.csv",
                    "Accounts");
            for(String[] row : data) {
                resources.accountPage(row[0]);
                resources.addAccountManually(row[2], row[3], row[4], row[1], "without Account");
            }
        } catch (Exception e) {
            System.out.println("Fetching data from csv failed" + e);
        }
    }

    @And("Share resource {string} to user {string} with access {string}")
    public void shareResourceToUserWithAccess(String resourceName, String userName, String shareAccess) throws InterruptedException {
        resources.shareResourceToUser(resourceName, userName, shareAccess);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Access Control related Steps:

    @When("Access control request by user for resource {string} account {string} at {string} and {int}")
    public void accessControlRequestByUserForResourceAccountAt(String resourceName, String accountName, String timing , int minutes) throws InterruptedException {
        resources.requestPasswordAccess(resourceName, accountName, timing , minutes);
    }

    @When("Access control request by user for resource {string} account {string} for {string}")
    public void accessControlRequestByUserForResourceAccountFor(String resourceName, String accountName, String timing) throws InterruptedException {
        resources.requestPasswordAccess(resourceName, accountName, timing , 0);
    }

    @And("{string} password access request of resource {string} account {string}")
    public void passwordAccessRequestOfResourceAccount(String approval, String resourceName, String accountName) throws InterruptedException {
        admins.approvePasswordRequest(approval,resourceName, accountName, "",0);
    }

//    @And("{string} password access request at {string} and {String}")
//    public void passwordAccessRequestForThisMuch(String approval, String approvalTiming, String approvalMinutes) throws InterruptedException {
//        admins.approvePasswordRequest(approval, prop.getProperty("resourceName"), prop.getProperty("accountName"), approvalTiming, Integer.parseInt(approvalMinutes));
//    }

    @And("{string} password access request of resource {string} account {string} at {string} and {string}")
    public void passwordAccessRequestOfResourceAccountAtAnd(String approval, String resourceName, String accountName, String approvalTiming, String approvalMinutes) throws InterruptedException {
        admins.approvePasswordRequest(approval,resourceName, accountName, approvalTiming, Integer.parseInt(approvalMinutes));
    }

    @When("password checkout and checkin of resource {string} account {string}")
    public void passwordCheckoutAndCheckinOfResourceAccount(String resourceName, String accountName) throws InterruptedException {
        resources.passCheckout(resourceName, accountName);
        resources.passCheckin(resourceName, accountName);
    }

    @When("Configure Access control for bulk resources")
    public void configureAccessControlForBulkResources() throws InterruptedException {
        //resources.configureAccessControlInBulk();
    }

    @When("Configure access control for resources from csv")
    public void configureAccessControlForResourcesFromCsv() throws InterruptedException {

        try{
            List<String[]> data = readSection("src/test/resources/CSVFiles/Data.csv",
                    "Configure Access Control");
            for(String[] row : data) {
                System.out.println(Arrays.toString(row));
                resources.configureAccessControl(row);
            }
        } catch (Exception e) {
            System.out.println("Fetching data from csv failed" + e);
        }
    }

    //------------------------------------------------------------------------------------------------------------------


    @When("Edit following {string} with {string} in the Resource")
    public void editFollowingWithInTheResource(String fieldNames, String fieldValues) throws InterruptedException {
        resources.editResourceManually(fieldNames,fieldValues);
    }

    @When("Discover Domain resources")
    public void discoverDomainResources() throws InterruptedException {
        resources.discoverResources();
    }

    @And("enable {string} authentication")
    public void enableAuthentication(String userType) {
        switch (userType){
            case "ad":
                admins.enableActiveDirectoryAuthentication();
                break;
            case "ldap":
                admins.enableLDAPAuthentication();
                break;
            case "entraID":
                admins.enableMicrosoftEntraIDAuthentication();
                break;
            default:
                break;
        }
    }

    @When("set the build for testing")
    public void setTheBuildForTesting() throws InterruptedException {
        //loginPage.setupLogin();
        loginPage.webBrowserLogin();
        admins.configureMailServerSettings();
    }

    @When("{string} the agent for the resource {string}")
    public void theAgentForTheResource(String agentAction, String resourceName) throws InterruptedException {
        admins.manageAgent(agentAction,resourceName);
    }

    @When("Change password for the {string} of the {string} with {string} {string} for {string} resource")
    public void changePasswordForTheOfTheWith(String accountName, String resourceName, String passwordType, String newPassword, String remoteLocalCheckBox) throws InterruptedException {
        resources.accountPage(resourceName);
        resources.changePassword(accountName, passwordType, newPassword, remoteLocalCheckBox);
    }

    @When("create {string} resource group {string}")
    public void createResourceGroup(String groupType, String groupName) throws IOException, ParseException, InterruptedException {
        groups.associateResourcesToDynamicGroup(groupName);
        //groups.createGroup(groupType, groupName, "");
    }

    @When("perform bulk password reset for the resources {string} whose common string {string} with {string} in {string}")
    public void performBulkPasswordResetForTheResourcesWhoseCommonStringWithIn(String resourceNames, String searchName, String newPassword, String remoteLocalCheckBox) throws InterruptedException {
        resources.resourceBulkSelection(searchName, resourceNames);
        resources.bulkResetPassword(newPassword, remoteLocalCheckBox);
    }

    @When("configure remote password reset for resource {string} with {string} account {string}")
    public void configureRemotePasswordResetForResourceWithAccount(String resourceName, String resource, String accountName) throws InterruptedException {
        String[] accountNames = accountName.split("\\\\");
        String accountPart1 = accountNames.length > 1 ? accountNames[0] : "";
        String accountPart2 = accountNames.length > 1 ? accountNames[1] : accountNames[0];
        String resourceType = resources.resourceAction(resourceName, "Configure", "Remote Password Reset");
        System.out.println(resourceType);
        resources.configureRemotePasswordReset(resourceType, resource, accountPart1, accountPart2);
    }

    @When("Transfer Owner of the resource {string} to user {string}")
    public void transferOwnerOfTheResourceToUser(String resourceName, String userName) throws InterruptedException {
        resources.resourceAction(resourceName, "", "Transfer Resource Ownership");
        resources.transferResourceOwnership(userName);
    }

}
