package pageObjects;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TellYouEverythingPage extends BaseClass {
    private static final String link = "https://www.leroymerlin.fr/bienvenue-chez-nous/tout-vous-dire/";

    @FindBy(xpath = "//*[@class='mt-heading mt-heading--s mt-heading--regular col-12 article-entry__title']")
    private static List<WebElement> articlesTitles;

    public static String getTitle() {
        return driver.getTitle();
    }

    public static void goToPage() {
        driver.get(link);
    }

    /**
     * Check whether articles are duplicates
     * @return true if there are duplicates articles
     */
    public static boolean checkDuplicates() {
        boolean isThereDuplicates = false;
        Set<String> titles = new HashSet<String>();
        for (WebElement articleTitle : articlesTitles)
            if (!titles.add(articleTitle.getText())) {
                isThereDuplicates = true;
                break;
            }
        return isThereDuplicates;
    }

    /**
     * Handle Captcha
     */
    public static void recaptcha_v2() throws InterruptedException {
        //--------- get captcha frame -------------------------------
        WebElement iFrameDoc = driver.findElement(By.xpath("/html/body/iframe"));
        driver.switchTo().frame(iFrameDoc);
        WebElement iFrame = driver.findElement(By.xpath("//*[@id=\"captcha-submit\"]/div/div/iframe"));
        driver.switchTo().frame(iFrame);
        Thread.sleep(2000);
        //--------- captcha checkbox --------------------------------
        WebElement iFrame_checkbox = driver.findElement(By.xpath("//*[@id='recaptcha-anchor']"));
        iFrame_checkbox.click();
        Thread.sleep(3000);
        //--------- get back to our default frame -------------------
        driver.switchTo().defaultContent();

        // 1 - open new tab >>>> new_tab
        ((JavascriptExecutor) driver).executeScript("window.open()");
        // 2 - handle new_tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        try {
            driver.switchTo().window(tabs.get(0));
            driver.switchTo().frame(iFrameDoc);
            driver.switchTo().frame(2);
            Thread.sleep(3000);
            driver.findElement(By.cssSelector(".help-button-holder")).click();
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(10000);
            driver.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        try{
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(10000);
            driver.close();
        }catch (Exception e){
            System.out.println(e);
        }
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
    }

}
