package pageObjects;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterSalesServicePage extends BaseClass {
    private static final String link = "https://www.leroymerlin.fr/services/service-client/service-apres-vente/";

    @FindBy(xpath = "//*[@id=\"component-serviceslanding\"]/div[3]/section[2]/div/div/div[4]/label")
    private static WebElement questionBlock;

    @FindBy(xpath = "//*[@id=\"faq3__content\"]/p[2]/a")
    private static WebElement relayPointClosed;

    @FindBy(xpath = "//*[@id=\"faq3__content\"]/p[4]/a")
    private static WebElement marketplaceOrderTracking;

    @FindBy(xpath = "//*[@id=\"faq3__content\"]/p[5]/a")
    private static WebElement orderTracking;

    @FindBy(xpath = "//*[@id=\"faq3__content\"]")
    private static WebElement collapsedAnswer;

    public static String getTitle() {
        return driver.getTitle();
    }

    public static void goToPage() {
        driver.get(link);
    }

    public static void clickOnQuestionBlock() {
        questionBlock.click();
    }

    public static void navigateToRelayPointClosed(){
        navigateTo(relayPointClosed);
    }

    public static void navigateToMarketplaceOrderTracking(){
        navigateTo(marketplaceOrderTracking);
    }

    public static void navigateToOrderTracking(){
        navigateTo(orderTracking);
    }

    public static boolean isAnswerBlockDisplayed() {
        return collapsedAnswer.isDisplayed();
    }

}
