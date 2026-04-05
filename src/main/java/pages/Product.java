package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product extends BasePage {
    public Product(WebDriver driver) { super(driver); }

    @FindBy(css = "[data-testid='cart-67410b8c6cb6226060a20da4']")
    private WebElement addToCartButton;

    @FindBy (css = ".badge.bg-danger")
    private WebElement cartButton;

    @FindBy (css = "[data-testid='checkout']")
    private WebElement proceedToCheckoutButton;

    public void checkoutProduct() {

        safeClick(addToCartButton);

        waitForElementToBeVisible(cartButton);
        safeClick(cartButton);

        safeClick(proceedToCheckoutButton);
    }
}
