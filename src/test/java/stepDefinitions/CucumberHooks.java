package stepDefinitions;

import base.BaseClass;
import pageObjects.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CucumberHooks extends BaseClass {
    @Before
    public void setup(){
        setUpDriver();
        PageFactory.initElements(driver, TellYouEverythingPage.class);
        PageFactory.initElements(driver, AfterSalesServicePage.class);
        PageFactory.initElements(driver, FaqPage.class);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, SignUpPage.class);
    }
    @After
    public void teardown() throws IOException {
        closeDriver(driver);

        /*
          Live the following block commented until all tests are being executed correctly
          */
        /*
        SendMail sendMail = new SendMail();
        sendMail.sendEmail("gabitendong@gmail.com", "gabi2017", "gtendong@gmail.com");
        sendMail.sendEmail("gabitendong@gmail.com", "gabi2017", "fokourou@zenity.fr");
         */
    }

}

