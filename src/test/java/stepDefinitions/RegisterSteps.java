package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AccountCreatedPage;
import pages.AccountInformationPage;
import pages.SignupPage;

public class RegisterSteps {

    private final SignupPage signupPage = new SignupPage();
    private final AccountInformationPage accountInformationPage = new AccountInformationPage();
    private final AccountCreatedPage accountCreatedPage = new AccountCreatedPage();

    @And("User enters signup name {string}")
    public void userEntersSignupName(String name) {
        signupPage.enterName(name);
    }

    @And("User enters a new unique signup email")
    public void userEntersANewUniqueSignupEmail() {
        String uniqueEmail = "reham" + System.currentTimeMillis() + "@test.com";
        signupPage.enterEmail(uniqueEmail);
    }

    @And("User clicks Signup button")
    public void userClicksSignupButton() {
        signupPage.clickSignupBtn();
    }

    @And("User fills account information")
    public void userFillsAccountInformation() {
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
    }

    @And("User clicks Create Account")
    public void userClicksCreateAccount() {
        accountInformationPage.clickCreateAccount();
    }

    @Then("Account should be created successfully")
    public void accountShouldBeCreatedSuccessfully() {
        Assert.assertEquals(accountCreatedPage.getAccountCreatedMessage(), "ACCOUNT CREATED!");
    }
}
