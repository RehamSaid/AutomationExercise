package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {

    private final By getInTouchTitle = By.xpath("//h2[text()='Get In Touch']");
    private final By name = By.cssSelector("input[data-qa='name']");
    private final By email = By.cssSelector("input[data-qa='email']");
    private final By subject = By.cssSelector("input[data-qa='subject']");
    private final By message = By.cssSelector("textarea[data-qa='message']");
    private final By uploadFile = By.name("upload_file");
    private final By submitBtn = By.cssSelector("input[data-qa='submit-button']");
    private final By successMessage = By.cssSelector("#contact-page .status.alert-success");

    public boolean isGetInTouchDisplayed() {
        return isDisplayed(getInTouchTitle);
    }

    public void enterName(String userName) {
        type(name, userName);
    }

    public void enterEmail(String userEmail) {
        type(email, userEmail);
    }

    public void enterSubject(String userSubject) {
        type(subject, userSubject);
    }

    public void enterMessage(String userMessage) {
        type(message, userMessage);
    }

    public void uploadFile(String absoluteFilePath) {
        driver().findElement(uploadFile).sendKeys(absoluteFilePath);
    }

    public void clickSubmit() {
        click(submitBtn);
    }

    public void acceptAlert() {
        waitFor().until(ExpectedConditions.alertIsPresent()).accept();
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public String getEmailValidationMessage() {
        return getValidationMessage(email);
    }

    public boolean isStillOnContactUsPage() {
        return getCurrentUrl().contains("contact_us");
    }
}
