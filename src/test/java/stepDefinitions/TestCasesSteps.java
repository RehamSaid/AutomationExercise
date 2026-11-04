package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasesSteps {

    private final HomePage homePage = new HomePage();
    private final TestCasesPage testCasesPage = new TestCasesPage();

    @When("User clicks Test Cases button")
    public void userClicksTestCasesButton() {
        homePage.clickTestCasesBtn();
    }

    @Then("Test Cases page should be displayed")
    public void testCasesPageShouldBeDisplayed() {
        Assert.assertTrue(testCasesPage.getCurrentUrl().contains("test_cases"));
        Assert.assertEquals(testCasesPage.getTestCasesTitle(), "TEST CASES");
        Assert.assertTrue(testCasesPage.getTestCasesCount() > 0, "No test cases are listed");
    }
}
