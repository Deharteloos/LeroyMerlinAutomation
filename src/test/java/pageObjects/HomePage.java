package pageObjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {
    public static final String link = "https://leroymerlin.fr";

    @FindBy(xpath = "//*[@id=\"header\"]/div[9]/div[3]/a")
    private static WebElement connectionBtn;

    public static void goToPage() {
        driver.get(link);
    }

    public static void clickOnConnection() {
        connectionBtn.click();
    }
}
