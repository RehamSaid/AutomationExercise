package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CartPage;

public class CheckoutWithoutLoginSteps {

    private final CartPage cartPage = new CartPage();

    @Then("Register login message should be displayed")
    public void registerLoginMessageShouldBeDisplayed() {
        Assert.assertEquals(cartPage.getCheckoutLoginMessage(),
                "Register / Login account to proceed on checkout.");
    }
}
