package pages;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BasePage {

    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    protected WebDriver driver() {
        return Driver.getDriver();
    }

    protected WebDriverWait waitFor() {
        return new WebDriverWait(driver(), TIMEOUT);
    }

    protected WebElement waitForVisible(By locator) {
        return waitFor().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        removeAds();
        WebElement element = waitFor().until(ExpectedConditions.elementToBeClickable(locator));
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            removeAds();
            jsClick(element);
        }
    }


    protected void clickAndNavigate(By locator) {
        click(locator);
        closeGoogleVignetteIfShown();
    }

    protected void jsClick(WebElement element) {
        ((JavascriptExecutor) driver()).executeScript("arguments[0].click();", element);
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisible(locator).getText().trim();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void selectByVisibleText(By locator, String text) {
        new Select(waitForVisible(locator)).selectByVisibleText(text);
    }

    protected void hover(By locator) {
        WebElement element = waitForVisible(locator);
        ((JavascriptExecutor) driver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element);
        new Actions(driver()).moveToElement(element).perform();
    }

    protected String getValidationMessage(By locator) {
        Object message = ((JavascriptExecutor) driver())
                .executeScript("return arguments[0].validationMessage;", driver().findElement(locator));
        return message == null ? "" : message.toString();
    }

    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }

    /** Removes Google ad iframes / blocks that can cover page elements. */
    protected void removeAds() {
        try {
            ((JavascriptExecutor) driver()).executeScript(
                    "document.querySelectorAll(\"iframe[id^='aswift'], ins.adsbygoogle, "
                            + "iframe[src*='googleads'], #ad_position_box\")"
                            + ".forEach(e => e.remove());");
        } catch (Exception ignored) {
            // ads are optional; never fail a test because of them
        }
    }

    /** If a full-page Google vignette ad opened, go back to the real page. */
    protected void closeGoogleVignetteIfShown() {
        try {
            if (driver().getCurrentUrl().contains("#google_vignette")) {
                driver().navigate().refresh();
            }
        } catch (Exception ignored) {
            // nothing to close
        }
    }
}
