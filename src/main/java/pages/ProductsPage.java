package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private final By pageTitle = By.cssSelector(".features_items h2.title");
    private final By productCards = By.cssSelector(".features_items .product-image-wrapper");
    private final By firstViewProductLink = By.cssSelector("a[href='/product_details/1']");

    private final By firstProductCard = By.xpath("(//div[@class='product-image-wrapper'])[1]");
    private final By secondProductCard = By.xpath("(//div[@class='product-image-wrapper'])[2]");
    private final By firstAddToCartBtn = By.cssSelector(".productinfo a[data-product-id='1']");
    private final By secondAddToCartBtn = By.cssSelector(".productinfo a[data-product-id='2']");

    private final By cartModal = By.id("cartModal");
    private final By addedMessage = By.cssSelector("#cartModal .modal-title");
    private final By viewCartBtn = By.cssSelector("#cartModal a[href='/view_cart']");
    private final By continueShoppingBtn = By.cssSelector("#cartModal .close-modal");

    private final By searchBox = By.id("search_product");
    private final By searchBtn = By.id("submit_search");

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public int getProductsCount() {
        waitForVisible(productCards);
        return driver().findElements(productCards).size();
    }

    public void clickFirstViewProduct() {
        clickAndNavigate(firstViewProductLink);
    }

    public void hoverAndAddFirstProductToCart() {
        removeAds();
        hover(firstProductCard);
        click(firstAddToCartBtn);
    }

    public void hoverAndAddSecondProductToCart() {
        removeAds();
        hover(secondProductCard);
        click(secondAddToCartBtn);
    }

    public String getAddedMessage() {
        return getText(addedMessage);
    }

    public void clickContinueShopping() {
        click(continueShoppingBtn);
        waitFor().until(ExpectedConditions.invisibilityOfElementLocated(cartModal));
    }

    public void clickViewCart() {
        clickAndNavigate(viewCartBtn);
    }

    public void enterSearchText(String product) {
        type(searchBox, product);
    }

    public void clickSearchBtn() {
        click(searchBtn);
    }

    public int getSearchResultsCount() {
        waitForVisible(pageTitle);
        return driver().findElements(productCards).size();
    }
}
