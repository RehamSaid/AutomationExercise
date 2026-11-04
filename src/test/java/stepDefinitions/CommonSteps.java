package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

/** Steps shared by many feature files. */
public class CommonSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Given("User opens the Automation Exercise website")
    public void userOpensTheAutomationExerciseWebsite() {
        homePage.openHomePage();
    }

    @When("User clicks on Signup Login button")
    public void userClicksOnSignupLoginButton() {
        homePage.clickSignupLoginBtn();
    }

    @When("User clicks Products button")
    public void userClicksProductsButton() {
        homePage.clickProductsBtn();
    }

    @When("User clicks Cart button")
    public void userClicksCartButton() {
        homePage.clickCartBtn();
    }

    @When("User clicks on Contact Us button")
    public void userClicksOnContactUsButton() {
        homePage.clickContactUsBtn();
    }

    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        homePage.clickSignupLoginBtn();
        loginPage.login(ConfigReader.getUserEmail(), ConfigReader.getUserPassword());
    }
}
