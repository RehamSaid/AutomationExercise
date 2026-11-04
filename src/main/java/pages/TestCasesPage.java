package pages;

import org.openqa.selenium.By;

public class TestCasesPage extends BasePage {

    private final By testCasesTitle = By.cssSelector("h2.title.text-center");
    private final By testCaseItems = By.cssSelector(".panel-group .panel-title a");

    public String getTestCasesTitle() {
        return getText(testCasesTitle);
    }

    public int getTestCasesCount() {
        waitForVisible(testCaseItems);
        return driver().findElements(testCaseItems).size();
    }
}
