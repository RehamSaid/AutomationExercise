package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By cartRows = By.cssSelector("#cart_info_table tbody tr");
    private final By proceedToCheckoutBtn = By.cssSelector("a.check_out");
    private final By emptyCartMessage = By.cssSelector("#empty_cart p");
    private final By checkoutLoginMessage = By.cssSelector("#checkoutModal .modal-body p");

    public int getCartProductsCount() {
        waitForVisible(cartRows);
        return driver().findElements(cartRows).size();
    }

    public void clickProceedToCheckout() {
        click(proceedToCheckoutBtn);
    }

    public String getEmptyCartMessage() {
        return getText(emptyCartMessage);
    }

    public boolean isProceedToCheckoutDisplayed() {
        return !driver().findElements(proceedToCheckoutBtn).isEmpty()
                && driver().findElement(proceedToCheckoutBtn).isDisplayed();
    }

    public String getCheckoutLoginMessage() {
        return getText(checkoutLoginMessage);
    }
}
