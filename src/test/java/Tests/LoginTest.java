package Tests;

import core.BaseTest;
import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Login;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test(priority = 1, groups = {"smoke"}, description = "user login success")
    public void testLogin() {
        Login login = new Login(DriverManager.getDriver());
        login.login(config.getProperty("email"), config.getProperty("password"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(login.isUserLoggedInSuccessfully(),
                "User should see welcome message");


        softAssert.assertFalse(login.isErrorMessageDisplayed(),
                "User should not see any error message after successful login");

        softAssert.assertAll();
    }
}
