package pages;

import core.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends BasePage {
    public Login(WebDriver driver) { super(driver); }

    @FindBy (css = "[data-testid='goto-signin']")
    private WebElement signinButton;

    @FindBy (id = "email")
    private WebElement inputEmailTextField;

    @FindBy (id = "password")
    private WebElement inputPasswordTextField;

    @FindBy (id = "submit")
    private WebElement submitButton;

    @FindBy (id = "welcome-message")
    private WebElement welcomeMessageText;

    @FindBy (id = "flash")
    private WebElement errorNotification;


    public void login(String email, String password) {

        driver.manage().window().setSize(new Dimension(1920, 1080));

        safeClick(signinButton);

        safeType(inputEmailTextField, email);
        safeType(inputPasswordTextField, password);

        safeClick(submitButton);
    }

    public boolean isUserLoggedInSuccessfully() {
        try {
            waitForElementToBeVisible(welcomeMessageText);
            return welcomeMessageText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(errorNotification));
            return errorNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
