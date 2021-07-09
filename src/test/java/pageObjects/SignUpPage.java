package pageObjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BaseClass {
    @FindBy(id = "postalCode--982")
    private static WebElement postalCodeField;

    @FindBy(xpath = "//*[@id=\"js-account-creation-form\"]/div[1]/h2[2]")
    private static WebElement storeSection;

    @FindBy(id = "postalCode--982-error")
    private static WebElement postalCodeError;

    public static void insertPostalCode(String value) {
        postalCodeField.sendKeys(value);
        storeSection.click(); //To remove the focus on the postal code field.
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static boolean checkPostalCodeError(String errorMsg) {
        return postalCodeError.isDisplayed() && postalCodeError.getText().equals(errorMsg);
    }
}
