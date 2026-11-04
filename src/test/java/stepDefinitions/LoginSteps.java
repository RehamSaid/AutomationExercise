package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @And("User enters valid email and password")
    public void userEntersValidEmailAndPassword() {
        loginPage.enterEmail(ConfigReader.getUserEmail());
        loginPage.enterPassword(ConfigReader.getUserPassword());
    }

    @And("User clicks Login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        Assert.assertEquals(homePage.getLoggedInText(), "Logged in as " + ConfigReader.getUserName());
    }
}
