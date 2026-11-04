package pages;

import org.openqa.selenium.By;

public class SignupPage extends BasePage {

    private final By name = By.cssSelector("input[data-qa='signup-name']");
    private final By email = By.cssSelector("input[data-qa='signup-email']");
    private final By signupBtn = By.cssSelector("button[data-qa='signup-button']");
    private final By emailAlreadyExistMessage = By.cssSelector(".signup-form p");

    public void enterName(String userName) {
        type(name, userName);
    }

    public void enterEmail(String userEmail) {
        type(email, userEmail);
    }

    public void clickSignupBtn() {
        click(signupBtn);
    }

    public String getEmailAlreadyExistMessage() {
        return getText(emailAlreadyExistMessage);
    }
}
