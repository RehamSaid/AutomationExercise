package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ProductsPage;

public class SearchProductSteps {

    private final ProductsPage productsPage = new ProductsPage();

    @And("User searches for product {string}")
    public void userSearchesForProduct(String product) {
        productsPage.enterSearchText(product);
    }

    @And("User clicks Search button")
    public void userClicksSearchButton() {
        productsPage.clickSearchBtn();
    }

    @Then("Searched Products title should be displayed")
    public void searchedProductsTitleShouldBeDisplayed() {
        Assert.assertEquals(productsPage.getPageTitle(), "SEARCHED PRODUCTS");
    }

    @And("No products should be found")
    public void noProductsShouldBeFound() {
        Assert.assertEquals(productsPage.getSearchResultsCount(), 0);
    }
}
