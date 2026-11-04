package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.SignupPage;
import utils.ConfigReader;

public class SignupWithExistingEmailSteps {

    private final SignupPage signupPage = new SignupPage();

    @And("User enters the registered email in signup form")
    public void userEntersTheRegisteredEmailInSignupForm() {
        signupPage.enterEmail(ConfigReader.getUserEmail());
    }

    @Then("Email already exists message should be displayed")
    public void emailAlreadyExistsMessageShouldBeDisplayed() {
        Assert.assertEquals(signupPage.getEmailAlreadyExistMessage(), "Email Address already exist!");
    }
}
