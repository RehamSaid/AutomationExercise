package runner;

import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;
import utils.TestAccount;

import java.nio.file.Paths;


public class TestRunner {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final SignupPage signupPage = new SignupPage();
    private final AccountInformationPage accountInformationPage = new AccountInformationPage();
    private final AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
    private final TestCasesPage testCasesPage = new TestCasesPage();
    private final ProductsPage productsPage = new ProductsPage();
    private final ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    private final ContactUsPage contactUsPage = new ContactUsPage();
    private final CartPage cartPage = new CartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    private final PaymentPage paymentPage = new PaymentPage();
    private final OrderPlacedPage orderPlacedPage = new OrderPlacedPage();

    @BeforeMethod
    public void setUp() {
        TestAccount.ensureExists();
        Driver.setupDriver();
        homePage.openHomePage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    // ---------- helpers ----------

    private void loginWithValidUser() {
        homePage.clickSignupLoginBtn();
        loginPage.login(ConfigReader.getUserEmail(), ConfigReader.getUserPassword());
    }

    private void addFirstProductAndOpenCheckout() {
        homePage.clickProductsBtn();
        productsPage.hoverAndAddFirstProductToCart();
        productsPage.clickViewCart();
        cartPage.clickProceedToCheckout();
    }

    // ---------- positive scenarios ----------

    @Test(priority = 1, description = "Scenario 1: Register new user")
    public void registerUserTest() {
        homePage.clickSignupLoginBtn();
        signupPage.enterName("Reham");
        signupPage.enterEmail("reham" + System.currentTimeMillis() + "@test.com");
        signupPage.clickSignupBtn();

        accountInformationPage.selectMrs();
        accountInformationPage.enterPassword("Reham@12345");
        accountInformationPage.selectDay("15");
        accountInformationPage.selectMonth("June");
        accountInformationPage.selectYear("2001");
        accountInformationPage.clickNewsletter();
        accountInformationPage.clickSpecialOffers();
        accountInformationPage.enterFirstName("Reham");
        accountInformationPage.enterLastName("Elshakra");
        accountInformationPage.enterCompany("QA Testing");
        accountInformationPage.enterAddress("Smouha, Alexandria");
        accountInformationPage.selectCountry("Canada");
        accountInformationPage.enterState("Alexandria");
        accountInformationPage.enterCity("Alexandria");
        accountInformationPage.enterZipCode("21500");
        accountInformationPage.enterMobileNumber("01012345678");
        accountInformationPage.clickCreateAccount();

        Assert.assertEquals(accountCreatedPage.getAccountCreatedMessage(), "ACCOUNT CREATED!");
    }

    @Test(priority = 2, description = "Scenario 2: Valid login")
    public void validLoginTest() {
        loginWithValidUser();
        Assert.assertEquals(homePage.getLoggedInText(), "Logged in as " + ConfigReader.getUserName());
    }

    @Test(priority = 3, description = "Scenario 3: Add products to cart and checkout")
    public void addProductToCartAndCheckoutTest() {
        loginWithValidUser();
        homePage.clickProductsBtn();
        productsPage.hoverAndAddFirstProductToCart();
        Assert.assertEquals(productsPage.getAddedMessage(), "Added!");
        productsPage.clickContinueShopping();
        productsPage.hoverAndAddSecondProductToCart();
        productsPage.clickViewCart();
        Assert.assertEquals(cartPage.getCartProductsCount(), 2);

        cartPage.clickProceedToCheckout();
        Assert.assertTrue(checkoutPage.isDeliveryAddressDisplayed());
        checkoutPage.enterComment("Automation testing order - please ignore.");
        checkoutPage.clickPlaceOrder();

        paymentPage.enterNameOnCard(ConfigReader.getUserName());
        paymentPage.enterCardNumber("4111111111111111");
        paymentPage.enterCvc("123");
        paymentPage.enterExpiryMonth("12");
        paymentPage.enterExpiryYear("2030");
        paymentPage.clickPayAndConfirmOrder();

        Assert.assertEquals(orderPlacedPage.getOrderPlacedTitle(), "ORDER PLACED!");
    }

    @Test(priority = 4, description = "Scenario 4: Contact Us form")
    public void contactUsTest() {
        homePage.clickContactUsBtn();
        contactUsPage.enterName("Reham");
        contactUsPage.enterEmail("rehamsaid221@gmail.com");
        contactUsPage.enterSubject("Automation Testing");
        contactUsPage.enterMessage("This message was sent by an automated test.");
        contactUsPage.uploadFile(Paths.get("src", "test", "resources", "files", "upload-test.txt")
                .toAbsolutePath().toString());
        contactUsPage.clickSubmit();
        contactUsPage.acceptAlert();

        Assert.assertEquals(contactUsPage.getSuccessMessage(),
                "Success! Your details have been submitted successfully.");
    }

    @Test(priority = 5, description = "Scenario 5: Test Cases page")
    public void testCasesPageTest() {
        homePage.clickTestCasesBtn();
        Assert.assertEquals(testCasesPage.getTestCasesTitle(), "TEST CASES");
    }

    @Test(priority = 6, description = "Scenario 6: All products and product details")
    public void productsAndProductDetailsTest() {
        homePage.clickProductsBtn();
        Assert.assertEquals(productsPage.getPageTitle(), "ALL PRODUCTS");
        Assert.assertTrue(productsPage.getProductsCount() > 0);
        productsPage.clickFirstViewProduct();
        Assert.assertFalse(productDetailsPage.getProductName().isEmpty());
        Assert.assertTrue(productDetailsPage.getCategory().contains("Category"));
    }

    @Test(priority = 7, description = "Scenario 7: Logout")
    public void logoutTest() {
        loginWithValidUser();
        homePage.clickLogoutBtn();
        Assert.assertTrue(loginPage.getCurrentUrl().contains("/login"));
        Assert.assertTrue(loginPage.isLoginTitleDisplayed());
    }

    @Test(priority = 8, description = "Scenario 8: Login with incorrect data")
    public void invalidLoginTest() {
        homePage.clickSignupLoginBtn();
        loginPage.login("not.registered.user.123@test.com", "WrongPassword123");
        Assert.assertEquals(loginPage.getErrorMessage(), "Your email or password is incorrect!");
    }

    // ---------- negative scenarios ----------

    @Test(priority = 9, description = "Negative: Signup with existing email")
    public void signupWithExistingEmailTest() {
        homePage.clickSignupLoginBtn();
        signupPage.enterName("Reham");
        signupPage.enterEmail(ConfigReader.getUserEmail());
        signupPage.clickSignupBtn();
        Assert.assertEquals(signupPage.getEmailAlreadyExistMessage(), "Email Address already exist!");
    }

    @Test(priority = 10, description = "Negative: Login with incorrect password")
    public void loginWithIncorrectPasswordTest() {
        homePage.clickSignupLoginBtn();
        loginPage.login(ConfigReader.getUserEmail(), "WrongPassword123");
        Assert.assertEquals(loginPage.getErrorMessage(), "Your email or password is incorrect!");
    }

    @Test(priority = 11, description = "Negative: Checkout with empty cart")
    public void checkoutWithEmptyCartTest() {
        homePage.clickCartBtn();
        Assert.assertTrue(cartPage.getEmptyCartMessage().contains("Cart is empty!"));
        Assert.assertFalse(cartPage.isProceedToCheckoutDisplayed());
    }

    @Test(priority = 12, description = "Negative: Invalid Contact Us submission")
    public void invalidContactUsSubmissionTest() {
        homePage.clickContactUsBtn();
        contactUsPage.enterName("Reham");
        contactUsPage.enterSubject("Automation Testing");
        contactUsPage.enterMessage("Message without email.");
        contactUsPage.clickSubmit();
        Assert.assertFalse(contactUsPage.getEmailValidationMessage().isEmpty());
        Assert.assertTrue(contactUsPage.isStillOnContactUsPage());
    }

    @Test(priority = 13, description = "Negative: Invalid search text")
    public void searchForNonExistingProductTest() {
        homePage.clickProductsBtn();
        productsPage.enterSearchText("abcdef123456");
        productsPage.clickSearchBtn();
        Assert.assertEquals(productsPage.getPageTitle(), "SEARCHED PRODUCTS");
        Assert.assertEquals(productsPage.getSearchResultsCount(), 0);
    }

    @Test(priority = 14, description = "Negative: Invalid payment info")
    public void invalidPaymentInfoTest() {
        loginWithValidUser();
        addFirstProductAndOpenCheckout();
        checkoutPage.enterComment("Invalid payment test");
        checkoutPage.clickPlaceOrder();

        paymentPage.enterNameOnCard("Reham");
        paymentPage.enterCvc("1");
        paymentPage.enterExpiryMonth("99");
        paymentPage.enterExpiryYear("2000");
        paymentPage.clickPayAndConfirmOrder();

        Assert.assertFalse(paymentPage.getCardNumberValidationMessage().isEmpty());
        Assert.assertTrue(paymentPage.getCurrentUrl().endsWith("/payment"));
    }

    @Test(priority = 15, description = "Negative: Checkout without login")
    public void attemptCheckoutWithoutLoginTest() {
        addFirstProductAndOpenCheckout();
        Assert.assertEquals(cartPage.getCheckoutLoginMessage(),
                "Register / Login account to proceed on checkout.");
    }
}
