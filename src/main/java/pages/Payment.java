package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Payment extends BasePage {
    public Payment(WebDriver driver) { super(driver); }

    @FindBy(id = "name")
    private WebElement inputNameBillingTextField;

    @FindBy (id = "address")
    private WebElement inputAddressBillingTextField;

    @FindBy (id = "card-name")
    private WebElement inputCardNameTextField;

    @FindBy (id = "card-number")
    private WebElement inputCardNumberTextField;

    @FindBy (id = "card-expiry-month")
    private WebElement inputCardExpiryMonthTextField;

    @FindBy (id = "card-expiry-year")
    private WebElement inputCardExpiryYearTextField;

    @FindBy (id = "card-cvc")
    private WebElement inputCardCvcTextField;

    @FindBy (css = "[data-testid='purchase']")
    private WebElement purchaseButton;

    @FindBy (id = "flash")
    private WebElement successPurchaseText;

    @FindBy (id = "deleteOrdersBtn")
    private WebElement deleteOrdersButton;

    public void fillFormPayment(
            String nameBilling,
            String addressBilling,
            String cardName,
            String cardNumber,
            String cardExpiryMonth,
            String cardExpiryYear,
            String cardCvc) {

        safeType(inputNameBillingTextField, nameBilling);
        safeType(inputAddressBillingTextField, addressBilling);
        safeType(inputCardNameTextField, cardName);
        safeType(inputCardNumberTextField, cardNumber);
        safeType(inputCardExpiryMonthTextField, cardExpiryMonth);
        safeType(inputCardExpiryYearTextField, cardExpiryYear);
        safeType(inputCardCvcTextField, cardCvc);
    }

    public void clickPurchase() {
        safeClick(purchaseButton);
    }

    public boolean successPayment() {

        waitForElementToBeVisible(successPurchaseText);
        waitForElementToBeVisible(deleteOrdersButton);

        return successPurchaseText.isDisplayed() && deleteOrdersButton.isDisplayed();
    }
}
