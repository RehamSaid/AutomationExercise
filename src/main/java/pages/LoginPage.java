package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By loginTitle = By.xpath("//h2[text()='Login to your account']");
    private final By email = By.cssSelector("input[data-qa='login-email']");
    private final By password = By.cssSelector("input[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("button[data-qa='login-button']");
    private final By errorMessage = By.cssSelector(".login-form p");

    public void enterEmail(String userEmail) {
        type(email, userEmail);
    }

    public void enterPassword(String userPassword) {
        type(password, userPassword);
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }

    public void login(String userEmail, String userPassword) {
        enterEmail(userEmail);
        enterPassword(userPassword);
        clickLoginBtn();
    }

    public boolean isLoginTitleDisplayed() {
        return isDisplayed(loginTitle);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
