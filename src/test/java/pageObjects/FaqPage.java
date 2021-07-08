package pageObjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaqPage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"st-faq-root\"]/section/div/div[5]/div/div[2]/div/div[2]/article/h2")
    private static WebElement questionTitle;

    public static String getUrl() {
        return driver.getCurrentUrl();
    }

    public static boolean questionExists() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(questionTitle));
        return !questionTitle.getText().equals("Cette question n'existe pas");
    }
}
