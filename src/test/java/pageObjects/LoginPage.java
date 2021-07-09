package pageObjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"js-signup-url\"]")
    private static WebElement signUpBtn;

    public static String getTitle() {
        return driver.getTitle();
    }
    public static void clickOnSignUp() {
        signUpBtn.click();
    }
}
