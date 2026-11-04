package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ContactUsPage;

import java.nio.file.Paths;

public class ContactUsSteps {

    private static final String UPLOAD_FILE =
            Paths.get("src", "test", "resources", "files", "upload-test.txt").toAbsolutePath().toString();

    private final ContactUsPage contactUsPage = new ContactUsPage();

    @Then("Get In Touch section should be displayed")
    public void getInTouchSectionShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.isGetInTouchDisplayed());
    }

    @And("User enters name")
    public void userEntersName() {
        contactUsPage.enterName("Reham");
    }

    @And("User enters email")
    public void userEntersEmail() {
        contactUsPage.enterEmail("rehamsaid221@gmail.com");
    }

    @And("User enters subject")
    public void userEntersSubject() {
        contactUsPage.enterSubject("Automation Testing");
    }

    @And("User enters message")
    public void userEntersMessage() {
        contactUsPage.enterMessage("This message was sent by an automated test.");
    }

    @And("User uploads a file")
    public void userUploadsAFile() {
        contactUsPage.uploadFile(UPLOAD_FILE);
    }

    @And("User clicks Submit button")
    public void userClicksSubmitButton() {
        contactUsPage.clickSubmit();
    }

    @And("User accepts the alert")
    public void userAcceptsTheAlert() {
        contactUsPage.acceptAlert();
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        Assert.assertEquals(contactUsPage.getSuccessMessage(),
                "Success! Your details have been submitted successfully.");
    }
}
