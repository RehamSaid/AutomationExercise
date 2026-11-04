package pages;

import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage {

    private final By accountCreatedMessage = By.cssSelector("h2[data-qa='account-created']");
    private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");

    public String getAccountCreatedMessage() {
        return getText(accountCreatedMessage);
    }

    public void clickContinue() {
        click(continueBtn);
    }
}
