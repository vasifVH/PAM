package Pages;

import BasePackage.BaseClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static Hooks.Hooks.prop;

public class Groups {

    WebDriver driver;
    BaseClass base;
    Actions actions;
    JavascriptExecutor js;
    Select dropdown;
    JSONParser jsonParser;

    String groupsPage = prop.getProperty("url") + "PassTrixMain.cc#/Groups";
    int conditionCount = 0;
    int level = 0;
    int level1SubsetCount = 0;
    int level2SubsetCount = 0;

    @FindBy(xpath = "//span[@class = 'icon-resource-group']")
    static WebElement groupsTab;

    @FindBy(xpath = "//div[contains(text() , 'Add Group')]")
    static WebElement addGroupDropdown;

    @FindBy(xpath = "//div[contains(text() , 'Add Group')]/following-sibling::div/child::ul/li/a")
    static List<WebElement> addGroupDropdownList;

    @FindBy(xpath = "//button[@id='searchButtonId']")
    public static WebElement groupSearchIcon;

    @FindBy(xpath = "//em[text() = 'Clear Search']")
    static WebElement groupClearSearchButton;

    @FindBy(xpath = "//input[@columnname='GNAME']")
    static WebElement groupNameSearchTextBox;

    @FindBy(xpath = "//ul[@role = 'menu']/li/a")
    static List<WebElement> groupMenuOptions;

    @FindBy(xpath = "//input[@id = 'group']")
    static WebElement addGroupGroupNameTextBox;

    @FindBy(xpath = "//textarea[@id = 'desc']")
    static WebElement addGroupGroupDescTextBox;

    @FindBy(xpath = "//em[text()='Save']")
    static WebElement groupsSaveButton;

    @FindBy(xpath = "//em[text()='Cancel']")
    static WebElement groupsCancelButton;

    @FindBy(xpath = "//em[text()='Save & Proceed']")
    static WebElement groupsSaveAndProceedButton;

    @FindBy(xpath = "//input[@id = 'shareSearchTextBoxId']")
    static WebElement groupsSearchTextBox;

    @FindBy(xpath = "//input[@sqltype= 'CHAR']")
    static WebElement groupsResourceTableSearchValueBox;

    //Perform Password Reset

    @FindBy(xpath = "//input[@id = 'pwd_to_use']")
    static WebElement PerformPassResetPasswordToUseRadioButton;

    @FindBy(xpath = "//input[@id = 'generate_unique']")
    static WebElement PerformPassResetGenerateUniqueRadioButton;

    @FindBy(xpath = "//input[@name = 'password']")
    static WebElement PerformPassResetPasswordTextBox;

    @FindBy(xpath = "//div[@id = 'GENPASS']")
    static WebElement PerformPassResetGeneratePasswordIcon;

    @FindBy(xpath = "//input[@name = 'password']")
    static WebElement PerformPassResetRemoteResetCheckBox;

    @FindBy(xpath = "//textarea[@id= 'notes']")
    static WebElement sdfdsf;

    public Groups (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.base = new BaseClass(this.driver);
        actions = new Actions(this.driver);
        js = (JavascriptExecutor) this.driver;
    }

    public String dialogCloseIcon(String pageTitle){
        return "//span[contains(text() , '" + pageTitle + "')]/following::button[@title = 'Close']";
    }

    public String pageTitle(String pageTitle){
        return "//span[contains(text() , '" + pageTitle + "')]";
    }

    public String addResourceToGroup(String resourceName){
        return "//span[text()= '" + resourceName + "']/parent::div/following-sibling::div/descendant::span[text() = 'Add to group']";
    }

    public String associateResourcesIcon(String groupName){
        return "//a[text() = '" + groupName +"']/ancestor::*[2]/following-sibling::div/span/a/div";
    }

    public String groupsActionsIcon(String groupName){
        return "//a[text() = '" + groupName +"']/ancestor::*[2]/following-sibling::div/span/div/a/span";
    }

    public String dynamicConditionLabel(int index){
        return "//div[@id = 'allCriteriaBox']/descendant::select[@id = 'label_input'][" + index + "]";
    }

    public String dynamicConditionCriteria(int index){
        return "//div[@id = 'allCriteriaBox']/descendant::select[@id = 'condition_input'][" + index + "]";
    }

    public String dynamicConditionCriteriaValue(int index){
        return "//div[@id = 'allCriteriaBox']/descendant::input[@id = 'user_input'][" + index + "]";
    }

    public String dynamicConditionDeleteCondition(int index){
        return "//div[@id = 'allCriteriaBox']/descendant::span[@id = 'icon-delete'][" + index + "]";
    }

    public String dynamicConditionOperator(int level, int subSetCount){
        return "(//div[@id = 'allCriteriaBox']/descendant::div[@value = 'parent_criteria_group' and @level = '" + level + "']/descendant::span[contains(@class , 'active')][1])[" + subSetCount + "]";
    }

    public String dynamicConditionButtons(int level, String action, int subSetCount){
        return "(//div[@id = 'allCriteriaBox']/descendant::div[@value = 'parent_criteria_group' and @level = '" + level + "']/descendant::em[text() = '" + action + "'][1])[" + subSetCount + "]";
    }

    public void createGroup(String groupType, String groupName, String resources) throws InterruptedException, IOException, ParseException {
        String[] resourcesArray = resources.split(",");
        int index = 0;
        int currentLevelOneCount = 0;
        int currentLevelTwoCount = 0;
        int level = 0;

        base.waitForElementToBeVisible(groupsTab, 10);
        groupsTab.click();
        base.waitForElementToBeVisible(addGroupDropdown, 10);
        addGroupDropdown.click();
        if (groupType.equalsIgnoreCase("static")) {
            base.multipleElements(addGroupDropdownList, "Static Group").click();
            base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Add Static Group"))), 10);
            addGroupGroupNameTextBox.sendKeys(groupName);
            groupsSaveAndProceedButton.click();
            base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Resource Group"))), 10);
            while (index < resourcesArray.length) {
                groupsSearchTextBox.clear();
                groupsSearchTextBox.sendKeys(resourcesArray[index] + Keys.ENTER);
                Thread.sleep(1000);
                addResourceToGroup(resourcesArray[index]);
                index++;
                groupsResourceTableSearchValueBox.clear();
            }
            dialogCloseIcon("Resource Group");
        }
        else {
            base.multipleElements(addGroupDropdownList, "Dynamic Group").click();
            base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Add Dynamic Group"))), 10);
            addGroupGroupNameTextBox.sendKeys(groupName);
            groupsSaveAndProceedButton.click();
            base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Resource Group"))), 10);
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("D:/Personal/Selenium/PAM_Resource_Group_Branch/Source/PAM/pam360_7200_full_automation/src/test/resources/JSON/dynamicGroup.json");
            JSONObject object = (JSONObject) parser.parse(reader);
            if(object.containsKey("TestCase1")) {
                JSONArray array= (JSONArray) object.get("TestCase1");
                int i = 0;
                for(Object condition: array) {
                    i++;
                    conditionCount++;
                    if(i > 1) {
                        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionButtons(level, "Add Condition", 1))));
                        driver.findElement(By.xpath(dynamicConditionButtons(level, "Add Condition", 1))).click();
                    }
                    dynamicGroupCriteria(condition,1);

                }
                groupsSaveButton.click();
            }
            else{
                groupsCancelButton.click();
            }
            base.waitForElementToBeVisible(groupClearSearchButton,10);
            groupClearSearchButton.click();
//            while(index){
//                base.dropDownSelectText(driver.findElement(By.xpath(dynamicConditionLabel(index))),"Resource Name");
//                base.dropDownSelectText(driver.findElement(By.xpath(dynamicConditionCriteria(index))),"Equals");
//                base.dropDownSelectText(driver.findElement(By.xpath(dynamicConditionCriteriaValue(index))),"windows");
//                index++;
//
//            }
        }

    }

    public void dynamicGroupCriteria(Object condition, int subsetLevel) throws IOException, ParseException, InterruptedException {
        JSONObject conditionObject= (JSONObject) condition;
        //System.out.println((String) conditionObject.get("label") + conditionCount);
        if (conditionObject.containsKey("label")) {
            js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionLabel(conditionCount))));
            base.dropDownSelectText(driver.findElement(By.xpath(dynamicConditionLabel(conditionCount))),(String) conditionObject.get("label"));
            js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionCriteria(conditionCount))));
            base.dropDownSelectText(driver.findElement(By.xpath(dynamicConditionCriteria(conditionCount))),(String) conditionObject.get("criteria"));
            js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionCriteriaValue(conditionCount))));
            driver.findElement(By.xpath(dynamicConditionCriteriaValue(conditionCount))).clear();
            driver.findElement(By.xpath(dynamicConditionCriteriaValue(conditionCount))).sendKeys((String) conditionObject.get("criteriaValue"));
        }
        if(conditionObject.containsKey("Subset")){
            level++;
            if(level == 0)
                subsetLevel = 1;
            if(level == 1) {
                level1SubsetCount++;
                subsetLevel = 1;
            }
            if(level == 2) {
                level2SubsetCount++;
                subsetLevel = level1SubsetCount;
            }
            js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionButtons(level-1,"Add Subset", subsetLevel))));
            driver.findElement(By.xpath(dynamicConditionButtons(level-1,"Add Subset", subsetLevel))).click();
            String operator = dynamicConditionOperator(level-1,subsetLevel);
            if(!conditionObject.containsKey("label")){
                js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionDeleteCondition(conditionCount))));
                js.executeScript("arguments[0].click();",driver.findElement(By.xpath(dynamicConditionDeleteCondition(conditionCount))));
                conditionCount--;
            }
            if(conditionObject.containsKey("operator") && (!(driver.findElement(By.xpath(operator)).getText().equalsIgnoreCase((String) conditionObject.get("operator")))))
                driver.findElement(By.xpath(operator)).click();
            JSONArray subsetArray = (JSONArray) conditionObject.get("Subset");
            for (Object subset : subsetArray) {
                JSONObject subsetObject = (JSONObject) subset;
                int i = 0;
                List <String> keyslist= (List<String>) subsetObject.keySet().stream().map(key->(String)key).sorted().collect(Collectors.toList());
                for (Object key : keyslist) {
                    i++;
                    //System.out.println("i " + i);
                    if(i > 1) {
                        if(level == 0)
                            subsetLevel = 1;
                        if(level == 1) {
                            level1SubsetCount++;
                            subsetLevel = 1;
                        }
                        if(level == 2) {
                            level2SubsetCount++;
                            subsetLevel = level1SubsetCount;
                        }
                        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionButtons(level - 1, "Add Subset", subsetLevel))));
                        driver.findElement(By.xpath(dynamicConditionButtons(level - 1, "Add Subset", subsetLevel))).click();
                    }
                    String setName = (String) key;
                    JSONArray setArray = (JSONArray) subsetObject.get(setName);
                    int j=0;
                    for (Object item : setArray) {
                        j++;
                        //System.out.println("j " + j);
                        conditionCount++;
                        if(j > 1) {
                            if(level == 1)
                                subsetLevel = level1SubsetCount;
                            if(level == 2)
                                subsetLevel = level2SubsetCount;
                            js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionButtons(level, "Add Condition", subsetLevel))));
                            driver.findElement(By.xpath(dynamicConditionButtons(level, "Add Condition", subsetLevel))).click();
                        }
                        dynamicGroupCriteria(item, subsetLevel);
                    }
                }
                //System.out.println("test");
                level--;
            }
        }
        else if (conditionObject.containsKey("operator")) {
            String operator = dynamicConditionOperator(level,subsetLevel);
            js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(operator)));
            if(!(driver.findElement(By.xpath(operator)).getText().equalsIgnoreCase((String) conditionObject.get("operator"))))
                driver.findElement(By.xpath(operator)).click();
        }
    }

    public void associateResourcesToDynamicGroup(String groupName) throws InterruptedException, IOException, ParseException {
        base.waitForElementToBeVisible(groupsTab,10);
        groupsTab.click();
        Thread.sleep(1500);
        base.waitForElementToBeVisible(groupSearchIcon,10);
        groupSearchIcon.click();
        base.waitForElementToBeVisible(groupNameSearchTextBox,10);
        groupNameSearchTextBox.sendKeys(groupName + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(associateResourcesIcon(groupName))),10);
        driver.findElement(By.xpath(associateResourcesIcon(groupName))).click();
        base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Add resources"))), 10);
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("D:/Personal/Selenium/PAM_Resource_Group_Branch/Source/PAM/pam360_7200_full_automation/src/test/resources/JSON/dynamicGroup.json");
        JSONObject object = (JSONObject) parser.parse(reader);
        if(object.containsKey("TestCase1")) {
            JSONArray array= (JSONArray) object.get("TestCase1");
            int i = 0;
            for(Object condition: array) {
                i++;
                conditionCount++;
                if(i > 1) {
                    js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(dynamicConditionButtons(level, "Add Condition", 1))));
                    driver.findElement(By.xpath(dynamicConditionButtons(level, "Add Condition", 1))).click();
                }
                dynamicGroupCriteria(condition,1);

            }
            groupsSaveButton.click();
        }
        else{
            groupsCancelButton.click();
        }
        base.waitForElementToBeVisible(groupClearSearchButton,10);
        groupClearSearchButton.click();
    }

    public void associateResourcesToStaticGroup(String groupName, String resourceNames) throws InterruptedException {
        String[] resourceNamesArray = resourceNames.split(",");
        int index = 0;

        base.waitForElementToBeVisible(groupsTab,10);
        groupsTab.click();
        Thread.sleep(1500);
        base.waitForElementToBeVisible(groupSearchIcon,10);
        groupSearchIcon.click();
        base.waitForElementToBeVisible(groupNameSearchTextBox,10);
        groupNameSearchTextBox.sendKeys(groupName + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(associateResourcesIcon(groupName))),10);
        driver.findElement(By.xpath(associateResourcesIcon(groupName))).click();
        base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Add Resources"))), 10);
        base.waitForElementToBeVisible(groupsSearchTextBox,10);
        while (index < resourceNamesArray.length) {
            groupsSearchTextBox.clear();
            groupsSearchTextBox.sendKeys(resourceNamesArray[index] + Keys.ENTER);
            Thread.sleep(1000);
            addResourceToGroup(resourceNamesArray[index]);
            index++;
            groupsResourceTableSearchValueBox.clear();
        }
        dialogCloseIcon("Add Resources");
    }

    public void shareGroupsTo(String groupName, String userNames) throws InterruptedException {
        String[] userNamesArray = userNames.split(",");
        int index = 0;

        base.waitForElementToBeVisible(groupsSearchTextBox,10);
        while(index < userNamesArray.length) {
            groupsSearchTextBox.clear();
            groupsSearchTextBox.sendKeys(userNamesArray[index] + Keys.ENTER);
            Thread.sleep(1000);
            WebElement userGrantButton;
            userGrantButton = driver.findElement(By.xpath("//span[@onmouseover = \"Tip('Login name :" + userNamesArray[index] + "',this);\"]/ancestor::*[2]/following-sibling::div/descendant::span[text() = 'Grant']"));
            userGrantButton.click();
            Thread.sleep(500);
            base.multipleElementsWithoutWait(groupMenuOptions, "View Passwords").click();
            index++;
        }
        base.waitForElementToBeVisible(driver.findElement(By.xpath(dialogCloseIcon("Share"))),10);
        driver.findElement(By.xpath(dialogCloseIcon("Share"))).click();
    }

    public void accountAction(String groupName, String accountAction) throws InterruptedException {
        base.waitForElementToBeVisible(groupsTab,10);
        groupsTab.click();
        Thread.sleep(1500);
        base.waitForElementToBeVisible(groupSearchIcon,10);
        groupSearchIcon.click();
        base.waitForElementToBeVisible(groupNameSearchTextBox,10);
        groupNameSearchTextBox.sendKeys(groupName + Keys.ENTER);
        Thread.sleep(500);
        base.waitForElementToBeVisible(driver.findElement(By.xpath(groupsActionsIcon(groupName))),10);
        driver.findElement(By.xpath(groupsActionsIcon(groupName))).click();
        base.multipleElementsWithoutWait(groupMenuOptions,accountAction).click();
    }

    public void performPasswordReset(String newPassword,String remoteLocalCheckBox){
        base.waitForElementToBeVisible(driver.findElement(By.xpath(pageTitle("Perform Password Reset"))), 10);
        PerformPassResetPasswordToUseRadioButton.click();
        base.waitForElementToBeVisible(PerformPassResetPasswordTextBox,10);
        PerformPassResetPasswordTextBox.sendKeys(newPassword);
        if(remoteLocalCheckBox.equalsIgnoreCase("Local"))
            PerformPassResetRemoteResetCheckBox.click();
        groupsSaveButton.click();
    }
}
