package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );
    }

    public void waitUntilInteractable(WebElement element) {
        wait.until(driver -> element.isDisplayed() && element.isEnabled());
    }

    public void safeClick(WebElement element) {
        waitForElementToBeVisible(element);
        scrollToElement(element);
        waitForElementToBeClickable(element);

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    element
            );
        }
    }

    public void safeType(WebElement element, String text) {
        waitForElementToBeVisible(element);

        scrollToElement(element);

        waitUntilInteractable(element);

        element.clear();
        element.sendKeys(text);
    }
}