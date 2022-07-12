package com.crmly.step_definitions;

import com.crmly.pages.AppreciationPage;
import com.crmly.pages.Dashboard;
import com.crmly.pages.LoginPage;
import com.crmly.utilities.BrowserUtils;
import com.crmly.utilities.ConfigurationReader;
import com.crmly.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppreciationStepDefs {

    Dashboard dashboard = new Dashboard();
    BrowserUtils browserUtils = new BrowserUtils();
    AppreciationPage appreciationPage = new AppreciationPage();
    String videoID="";

    @Given("The user logged in")
    public void theUserLoggedIn() {
        Driver.get().get(ConfigurationReader.get("url"));
        String username= ConfigurationReader.get("hr_username");
        String password= ConfigurationReader.get("hr_password");
        new LoginPage().login(username,password);
    }

    @When("User clicks Appreciation subheading from More tab")
    public void user_clicks_Appreciation_subheading_from_More_tab(){
        browserUtils.waitFor(1);
        dashboard.More.click();
        browserUtils.waitFor(1);
        dashboard.Appreciation.click();
        appreciationPage.DeleteAllContactButton.click();
    }

    @And("User click Upload files and images after clicking upload file icon")
    public void userClickUploadFilesAndImagesAfterClickingUploadFileIcon() {
        browserUtils.waitFor(1);
        dashboard.UploadFile.click();
    }

    @And("User upload {string} file")
    public void userUploadFile(String fileName) {
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/"+fileName;
        String fullPath = projectPath+"/"+filePath;
        dashboard.UploadFilesAndImages.sendKeys(fullPath);
        browserUtils.waitFor(6);
        //browserUtils.waitForPageToLoad(5);

    }

    @Then("System display the uploaded {string} file under the Attached files and images section")
    public void systemDisplayTheUploadedFileUnderTheAttachedFilesAndImagesSection(String fileName) {

        Assert.assertTrue(Driver.get().findElement(By.xpath("//*[text()='"+fileName+"']")).isDisplayed());
        dashboard.delButton.click();
    }

    @And("Click X button on the right side of uploaded file to delete")
    public void clickXButtonOnTheRightSideOfUploadedFileToDelete() {
        dashboard.delButton.click();
    }

    @Then("System shouldn't display the uploaded file under the Attached files and images section")
    public void systemShouldnTDisplayTheUploadedFileUnderTheAttachedFilesAndImagesSection() {
        Dimension dimension = Driver.get().findElement(By.xpath("//div[@id='feed-add-post-content-message']//tbody[@class='diskuf-placeholder-tbody']")).getSize();
        int expectedValue = 0;
        int actualValue = dimension.getHeight();
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Then("System display the name of uploaded file as {string}")
    public void systemDisplayTheNameOfUploadedFileAs(String expectedFileName) {
        String actualFileName= Driver.get().findElement(By.xpath("//div[@id='feed-add-post-content-message']//tbody[@class='diskuf-placeholder-tbody']//span[@class='f-wrap']")).getText();
        Assert.assertEquals(expectedFileName,actualFileName);
        dashboard.delButton.click();
    }

    @And("User clicks Employees and departments Tab after clicking Add More")
    public void userClicksEmployeesAndDepartmentsTabAfterClickingAddMore() {

        appreciationPage.AddMore.click();
        appreciationPage.EmployeesAndDepartments.click();

    }

    @Then("User should be able to see selected contacts in To: input box")
    public void userShouldBeAbleToSeeSelectedContactsInToInputBox(List<String> ContactNames) {
        int expectedDisplay = ContactNames.size();
        int actualDisplay= 0;

        for(int i = 0; i<appreciationPage.contactNames.size();i++){

            for(int j =0;j<ContactNames.size();j++){
                if(appreciationPage.contactNames.get(i).getText().equals(ContactNames.get(j))){
                    actualDisplay++;
                }
            }

        }

        Assert.assertEquals(expectedDisplay,actualDisplay);

    }

    @And("User select the multiple contacts from list")
    public void userSelectTheMultipleContactsFromList(List<String> ContactNames) {

        for (String ContactName: ContactNames) {
            browserUtils.waitFor(1);
            Driver.get().findElement(By.xpath("//div[@class='bx-finder-company-department-employee-info']//div[text()='"+ContactName+"']")).click();
        }

    }

    @And("User clicks link icon")
    public void userClicksLinkIcon() {
        dashboard.Link.click();
    }

    @And("User enters link text {string} and link URL {string}")
    public void userEntersLinkTextAndLinkURL(String text, String URL) {
        browserUtils.waitFor(3);
        appreciationPage.LinkText.sendKeys(text);
        appreciationPage.LinkURL.sendKeys(URL);

    }

    @And("User clicks Save button")
    public void userClicksSaveButton() {
        appreciationPage.SaveButton.click();
    }

    @Then("User should see attached link which has only Link URL or LinkText and URL {string} {string}")
    public void userShouldSeeAttachedLinkWhichHasOnlyLinkURLOrLinkTextAndURL(String text, String url) {
        browserUtils.waitFor(2);
        Driver.get().switchTo().frame(0);
        if(text.isEmpty()){
            Assert.assertTrue(Driver.get().findElement(By.linkText(url)).isDisplayed());
        }else {
            Assert.assertTrue(Driver.get().findElement(By.linkText(text)).isDisplayed());
        }

    }

    @Then("Verify that user shouldn't be able to attach link {string} without link URL")
    public void verifyThatUserShouldnTBeAbleToAttachLinkWithoutLinkURL(String text) {
        browserUtils.waitFor(2);
        Driver.get().switchTo().frame(0);

        Assert.assertFalse(Driver.get().findElement(By.linkText(text)).isDisplayed());
    }

    @And("User clicks insert video icon")
    public void userClicksInsertVideoIcon() {
        appreciationPage.InsertVideoButton.click();
    }

    @And("User enters {string}")
    public void userEnters(String videoURL) {
        browserUtils.waitFor(1);
        appreciationPage.VideoURL.sendKeys(videoURL);
        browserUtils.waitFor(13);


    }

    @And("User click Save button")
    public void userClickSaveButton() {
        appreciationPage.VideoSaveButton.click();
    }

    @Then("User should be able to see inserted video {string}")
    public void userShouldBeAbleToSeeInsertedVideo(String videoUrlLink) {

                int size = Driver.get().findElements(By.tagName("iframe")).size();

                //  for(int i=0; i<=size; i++){
                //  Driver.get().switchTo().frame(i);
                //  int total=Driver.get().findElements(By.xpath("//link[@href='"+videoUrlLink+"']")).size();
                //  System.out.println(total);
                //  Driver.get().switchTo().defaultContent();}

                browserUtils.waitFor(2);
                Driver.get().switchTo().frame((size-1));
                browserUtils.waitFor(2);
                Assert.assertTrue("User should see the inserted videos",Driver.get().findElement(By.xpath("//link[@href='"+videoUrlLink+"']")).isEnabled());
                appreciationPage.DeleteVideo.click();

    }

    @And("User enters invalid video URL {string}")
    public void userEntersInvalidVideoURL(String invalidVideoURL) {
        browserUtils.waitFor(1);
        appreciationPage.VideoURL.sendKeys(invalidVideoURL);
        browserUtils.waitFor(2);
    }

    @Then("User should see the warning Incorrect URL")

    public void userShouldSeeTheWarningIncorrectURL() {
        Assert.assertTrue(Driver.get().findElement(By.xpath("//span[contains(text(),'Incorrect UR')]")).isDisplayed());
    }

    @And("Write {string} as a content in Appreciation")
    public void writeAsAContentInAppreciation(String content) {

        Driver.get().switchTo().frame((0));

        appreciationPage.Content.sendKeys(content);

        Driver.get().switchTo().defaultContent();

    }

    @And("Add {string} contact by clicking to Add more")
    public void addContactByClickingToAddMore(String ContactName) {

        browserUtils.waitFor(1);
        appreciationPage.AddMore.click();
        browserUtils.waitFor(1);
        appreciationPage.EmployeesAndDepartments.click();
        browserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//div[@class='bx-finder-company-department-employee-info']//div[text()='"+ContactName+"']")).click();
        Driver.get().findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();
    }

    @And("User clicks send")
    public void userClicksSend() {
        browserUtils.waitFor(2);
        appreciationPage.SendButton.click();
        browserUtils.waitFor(3);

    }


    @Then("User should be able to see sent Appreciation {string} on the top of the Active Stream")
    public void userShouldBeAbleToSeeSentAppreciationOnTheTopOfTheActiveStream(String content) {

        Assert.assertTrue(Driver.get().findElement(By.xpath("//div[(@class='feed-post-text-block-inner-inner' and text()='"+content+"')]")).isDisplayed());

        browserUtils.waitFor(2);
        dashboard.ActiveMore.click();
        browserUtils.waitFor(1);
        dashboard.ActiveDelete.click();
        browserUtils.waitFor(1);
        Alert alert = Driver.get().switchTo().alert();
        browserUtils.waitFor(1);
        alert.accept();
        browserUtils.waitFor(1);


    }

    @Then("User should see the warning of message is not specified")
    public void userShouldSeeTheWarningOfMessageIsNotSpecified() {

        Assert.assertTrue(Driver.get().findElement(By.xpath("//span[text()='The message title is not specified']")).isDisplayed());

    }

    @Then("User should see the warning of specify at least one person")
    public void userShouldSeeTheWarningOfSpecifyAtLeastOnePerson() {

        Assert.assertTrue(Driver.get().findElement(By.xpath("//span[text()='Please specify at least one person.']")).isDisplayed());

    }



}
