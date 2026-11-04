package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.ConfigReader;

public class AddProductToCartSteps {

    private final ProductsPage productsPage = new ProductsPage();
    private final CartPage cartPage = new CartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    private final PaymentPage paymentPage = new PaymentPage();
    private final OrderPlacedPage orderPlacedPage = new OrderPlacedPage();

    @And("User hovers and adds first product to cart")
    public void userHoversAndAddsFirstProductToCart() {
        productsPage.hoverAndAddFirstProductToCart();
    }

    @Then("Product added message should be displayed")
    public void productAddedMessageShouldBeDisplayed() {
        Assert.assertEquals(productsPage.getAddedMessage(), "Added!");
    }

    @When("User clicks Continue Shopping")
    public void userClicksContinueShopping() {
        productsPage.clickContinueShopping();
    }

    @And("User hovers and adds second product to cart")
    public void userHoversAndAddsSecondProductToCart() {
        productsPage.hoverAndAddSecondProductToCart();
    }

    @And("User views the cart")
    public void userViewsTheCart() {
        productsPage.clickViewCart();
    }

    @Then("Cart should contain {int} products")
    public void cartShouldContainProducts(int expectedCount) {
        Assert.assertEquals(cartPage.getCartProductsCount(), expectedCount);
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage.clickProceedToCheckout();
    }

    @Then("Delivery address should be displayed")
    public void deliveryAddressShouldBeDisplayed() {
        Assert.assertTrue(checkoutPage.isDeliveryAddressDisplayed(), "Delivery address is missing");
        Assert.assertFalse(checkoutPage.getDeliveryName().isEmpty(), "Delivery name is empty");
    }

    @When("User enters order comment")
    public void userEntersOrderComment() {
        checkoutPage.enterComment("Automation testing order - please ignore.");
    }

    @And("User places the order")
    public void userPlacesTheOrder() {
        checkoutPage.clickPlaceOrder();
    }

    @And("User enters valid payment details")
    public void userEntersValidPaymentDetails() {
        paymentPage.enterNameOnCard(ConfigReader.getUserName());
        paymentPage.enterCardNumber("4111111111111111");
        paymentPage.enterCvc("123");
        paymentPage.enterExpiryMonth("12");
        paymentPage.enterExpiryYear("2030");
    }

    @And("User confirms payment")
    public void userConfirmsPayment() {
        paymentPage.clickPayAndConfirmOrder();
    }

    @Then("Order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() {
        Assert.assertEquals(orderPlacedPage.getOrderPlacedTitle(), "ORDER PLACED!");
        Assert.assertEquals(orderPlacedPage.getConfirmationMessage(),
                "Congratulations! Your order has been confirmed!");
    }
}
