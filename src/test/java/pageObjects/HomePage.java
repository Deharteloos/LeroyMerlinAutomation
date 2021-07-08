package pageObjects;

import base.BaseClass;

public class HomePage extends BaseClass {
    public static final String link = "https://leroymerlin.fr";



    public static void goToPage() {
        driver.get(link);
    }
}
