package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By deliveryAddress = By.id("address_delivery");
    private final By deliveryName = By.cssSelector("#address_delivery .address_firstname");
    private final By commentBox = By.cssSelector("textarea[name='message']");
    private final By placeOrderBtn = By.cssSelector("a[href='/payment']");

    public boolean isDeliveryAddressDisplayed() {
        return isDisplayed(deliveryAddress);
    }

    public String getDeliveryName() {
        return getText(deliveryName);
    }

    public void enterComment(String comment) {
        type(commentBox, comment);
    }

    public void clickPlaceOrder() {
        click(placeOrderBtn);
    }
}
