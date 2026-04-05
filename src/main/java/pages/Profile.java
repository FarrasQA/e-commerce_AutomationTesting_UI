package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends BasePage {
    public Profile(WebDriver driver) { super(driver); }

    @FindBy (xpath = "//*[@id=\"core\"]/div/div/nav[2]/div/a[1]")
    private WebElement navbarButton;

    public void goToProductPage() {
        safeClick(navbarButton);
    }
}
