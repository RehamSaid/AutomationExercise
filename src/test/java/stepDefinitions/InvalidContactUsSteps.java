package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ContactUsPage;

public class InvalidContactUsSteps {

    private final ContactUsPage contactUsPage = new ContactUsPage();

    @Then("Email validation message should be displayed")
    public void emailValidationMessageShouldBeDisplayed() {
        Assert.assertFalse(contactUsPage.getEmailValidationMessage().isEmpty(),
                "Browser did not show a validation message for the empty email");
    }

    @And("User should remain on Contact Us page")
    public void userShouldRemainOnContactUsPage() {
        Assert.assertTrue(contactUsPage.isStillOnContactUsPage());
    }
}
