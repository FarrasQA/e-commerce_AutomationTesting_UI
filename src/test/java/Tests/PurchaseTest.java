package Tests;

import core.BaseTest;
import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Login;
import pages.Payment;
import pages.Product;
import pages.Profile;

public class PurchaseTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test(priority = 1, groups = {"smoke"}, description = "user purchase success")
    public void testPurchase() {
        Login login = new Login(DriverManager.getDriver());
        Profile profile = new Profile(DriverManager.getDriver());
        Product product = new Product(DriverManager.getDriver());
        Payment payment = new Payment(DriverManager.getDriver());

        login.login(config.getProperty("email"), config.getProperty("password"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(login.isUserLoggedInSuccessfully(),
                "User should see welcome message");


        softAssert.assertFalse(login.isErrorMessageDisplayed(),
                "User should not see any error message after successful login");

        profile.goToProductPage();

        product.checkoutProduct();

        payment.fillFormPayment(config.getProperty("nameBilling"),
                (config.getProperty("addressBilling")),
                (config.getProperty("cardName")),
                (config.getProperty("cardNumber")),
                (config.getProperty("cardExpiryMonth")),
                (config.getProperty("cardExpiryYear")),
                (config.getProperty("cardCvc")));

        payment.clickPurchase();

        softAssert.assertTrue(payment.successPayment(),
                "User should see success purchase text and delete order button");

        softAssert.assertAll();
    }

}
