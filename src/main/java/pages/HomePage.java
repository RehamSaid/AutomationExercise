package pages;

import org.openqa.selenium.By;
import utils.ConfigReader;

public class HomePage extends BasePage {

    private final By signupLoginBtn = By.cssSelector("a[href='/login']");
    private final By logoutBtn = By.cssSelector("a[href='/logout']");
    private final By testCasesBtn = By.cssSelector(".navbar-nav a[href='/test_cases']");
    private final By productsBtn = By.cssSelector("a[href='/products']");
    private final By contactUsBtn = By.cssSelector("a[href='/contact_us']");
    private final By cartBtn = By.cssSelector(".navbar-nav a[href='/view_cart']");
    private final By loggedInText = By.xpath("//a[contains(.,'Logged in as')]");

    public void openHomePage() {
        driver().get(ConfigReader.getBaseUrl());
        removeAds();
    }

    public void clickSignupLoginBtn() {
        clickAndNavigate(signupLoginBtn);
    }

    public void clickLogoutBtn() {
        clickAndNavigate(logoutBtn);
    }

    public void clickTestCasesBtn() {
        clickAndNavigate(testCasesBtn);
    }

    public void clickProductsBtn() {
        clickAndNavigate(productsBtn);
    }

    public void clickContactUsBtn() {
        clickAndNavigate(contactUsBtn);
    }

    public void clickCartBtn() {
        clickAndNavigate(cartBtn);
    }

    public String getLoggedInText() {
        return getText(loggedInText);
    }
}
