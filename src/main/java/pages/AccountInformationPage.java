package pages;

import org.openqa.selenium.By;

public class AccountInformationPage extends BasePage {

    private final By titleMrs = By.id("id_gender2");
    private final By password = By.id("password");
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");
    private final By newsletter = By.id("newsletter");
    private final By specialOffers = By.id("optin");
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address = By.id("address1");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipCode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By createAccountBtn = By.cssSelector("button[data-qa='create-account']");

    public void selectMrs() {
        click(titleMrs);
    }

    public void enterPassword(String userPassword) {
        type(password, userPassword);
    }

    public void selectDay(String day) {
        selectByVisibleText(days, day);
    }

    public void selectMonth(String month) {
        selectByVisibleText(months, month);
    }

    public void selectYear(String year) {
        selectByVisibleText(years, year);
    }

    public void clickNewsletter() {
        click(newsletter);
    }

    public void clickSpecialOffers() {
        click(specialOffers);
    }

    public void enterFirstName(String fName) {
        type(firstName, fName);
    }

    public void enterLastName(String lName) {
        type(lastName, lName);
    }

    public void enterCompany(String companyName) {
        type(company, companyName);
    }

    public void enterAddress(String userAddress) {
        type(address, userAddress);
    }

    public void selectCountry(String countryName) {
        selectByVisibleText(country, countryName);
    }

    public void enterState(String userState) {
        type(state, userState);
    }

    public void enterCity(String userCity) {
        type(city, userCity);
    }

    public void enterZipCode(String zip) {
        type(zipCode, zip);
    }

    public void enterMobileNumber(String mobile) {
        type(mobileNumber, mobile);
    }

    public void clickCreateAccount() {
        click(createAccountBtn);
    }
}
