package pages;

import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private final By nameOnCard = By.cssSelector("input[data-qa='name-on-card']");
    private final By cardNumber = By.cssSelector("input[data-qa='card-number']");
    private final By cvc = By.cssSelector("input[data-qa='cvc']");
    private final By expiryMonth = By.cssSelector("input[data-qa='expiry-month']");
    private final By expiryYear = By.cssSelector("input[data-qa='expiry-year']");
    private final By payAndConfirmBtn = By.cssSelector("button[data-qa='pay-button']");

    public void enterNameOnCard(String name) {
        type(nameOnCard, name);
    }

    public void enterCardNumber(String card) {
        type(cardNumber, card);
    }

    public void enterCvc(String cvcNumber) {
        type(cvc, cvcNumber);
    }

    public void enterExpiryMonth(String month) {
        type(expiryMonth, month);
    }

    public void enterExpiryYear(String year) {
        type(expiryYear, year);
    }

    public void clickPayAndConfirmOrder() {
        click(payAndConfirmBtn);
    }

    public String getCardNumberValidationMessage() {
        return getValidationMessage(cardNumber);
    }

    public boolean isPayButtonDisplayed() {
        return isDisplayed(payAndConfirmBtn);
    }
}
