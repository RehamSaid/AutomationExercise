package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LogoutSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @When("User clicks Logout button")
    public void userClicksLogoutButton() {
        homePage.clickLogoutBtn();
    }

    @Then("User should be redirected to the Login page")
    public void userShouldBeRedirectedToTheLoginPage() {
        Assert.assertTrue(loginPage.getCurrentUrl().contains("/login"), "URL is not the login page");
        Assert.assertTrue(loginPage.isLoginTitleDisplayed(), "'Login to your account' is not displayed");
    }
}
