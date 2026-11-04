package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

public class InvalidLoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @And("User enters login email {string}")
    public void userEntersLoginEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("User enters login password {string}")
    public void userEntersLoginPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("Incorrect login message should be displayed")
    public void incorrectLoginMessageShouldBeDisplayed() {
        Assert.assertEquals(loginPage.getErrorMessage(), "Your email or password is incorrect!");
    }
}
