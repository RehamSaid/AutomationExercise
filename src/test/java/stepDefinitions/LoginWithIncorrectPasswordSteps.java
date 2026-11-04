package stepDefinitions;

import io.cucumber.java.en.And;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginWithIncorrectPasswordSteps {

    private final LoginPage loginPage = new LoginPage();

    @And("User enters the registered email in login form")
    public void userEntersTheRegisteredEmailInLoginForm() {
        loginPage.enterEmail(ConfigReader.getUserEmail());
    }
}
