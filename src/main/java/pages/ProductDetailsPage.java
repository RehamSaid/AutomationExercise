package pages;

import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    private final By productName = By.cssSelector(".product-information h2");
    private final By category = By.xpath("//div[@class='product-information']/p[contains(.,'Category')]");
    private final By price = By.cssSelector(".product-information span span");
    private final By availability = By.xpath("//div[@class='product-information']//b[contains(.,'Availability')]");
    private final By condition = By.xpath("//div[@class='product-information']//b[contains(.,'Condition')]");
    private final By brand = By.xpath("//div[@class='product-information']//b[contains(.,'Brand')]");

    public String getProductName() {
        return getText(productName);
    }

    public String getCategory() {
        return getText(category);
    }

    public String getPrice() {
        return getText(price);
    }

    public boolean isAvailabilityDisplayed() {
        return isDisplayed(availability);
    }

    public boolean isConditionDisplayed() {
        return isDisplayed(condition);
    }

    public boolean isBrandDisplayed() {
        return isDisplayed(brand);
    }
}
