package pages;

import org.openqa.selenium.By;

public class OrderPlacedPage extends BasePage {

    private final By orderPlacedTitle = By.cssSelector("h2[data-qa='order-placed']");
    private final By confirmationMessage = By.xpath("//h2[@data-qa='order-placed']/following-sibling::p");

    public String getOrderPlacedTitle() {
        return getText(orderPlacedTitle);
    }

    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
}
