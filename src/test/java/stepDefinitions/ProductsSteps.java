package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class ProductsSteps {

    private final ProductsPage productsPage = new ProductsPage();
    private final ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Then("All Products page should be displayed")
    public void allProductsPageShouldBeDisplayed() {
        Assert.assertEquals(productsPage.getPageTitle(), "ALL PRODUCTS");
    }

    @And("Products list should be visible")
    public void productsListShouldBeVisible() {
        Assert.assertTrue(productsPage.getProductsCount() > 0, "Products list is empty");
    }

    @When("User clicks first product")
    public void userClicksFirstProduct() {
        productsPage.clickFirstViewProduct();
    }

    @Then("Product details should be displayed")
    public void productDetailsShouldBeDisplayed() {
        Assert.assertTrue(productDetailsPage.getCurrentUrl().contains("product_details"));
        Assert.assertFalse(productDetailsPage.getProductName().isEmpty(), "Product name is empty");
        Assert.assertTrue(productDetailsPage.getCategory().contains("Category"));
        Assert.assertTrue(productDetailsPage.getPrice().contains("Rs."));
        Assert.assertTrue(productDetailsPage.isAvailabilityDisplayed());
        Assert.assertTrue(productDetailsPage.isConditionDisplayed());
        Assert.assertTrue(productDetailsPage.isBrandDisplayed());
    }
}
