package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.PaymentPage;

public class InvalidPaymentSteps {

    private final PaymentPage paymentPage = new PaymentPage();

    /** Card number is left empty, CVC / expiry are invalid. */
    @And("User enters invalid payment details")
    public void userEntersInvalidPaymentDetails() {
        paymentPage.enterNameOnCard("Reham");
        paymentPage.enterCvc("1");
        paymentPage.enterExpiryMonth("99");
        paymentPage.enterExpiryYear("2000");
    }

    @Then("Card number validation message should be displayed")
    public void cardNumberValidationMessageShouldBeDisplayed() {
        Assert.assertFalse(paymentPage.getCardNumberValidationMessage().isEmpty(),
                "No validation message on empty card number");
    }

    @And("User should remain on payment page")
    public void userShouldRemainOnPaymentPage() {
        Assert.assertTrue(paymentPage.getCurrentUrl().endsWith("/payment"),
                "User left the payment page: " + paymentPage.getCurrentUrl());
        Assert.assertTrue(paymentPage.isPayButtonDisplayed());
    }
}
