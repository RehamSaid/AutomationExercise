package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CartPage;

public class EmptyCartSteps {

    private final CartPage cartPage = new CartPage();

    @Then("Empty cart message should be displayed")
    public void emptyCartMessageShouldBeDisplayed() {
        Assert.assertTrue(cartPage.getEmptyCartMessage().contains("Cart is empty!"));
    }

    @And("Proceed To Checkout button should not be displayed")
    public void proceedToCheckoutButtonShouldNotBeDisplayed() {
        Assert.assertFalse(cartPage.isProceedToCheckoutDisplayed());
    }
}
