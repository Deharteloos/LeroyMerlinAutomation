package stepDefinitions;

import pageObjects.TellYouEverythingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class DuplicateArticleSteps {
    @Given("User on the page {string}")
    public void user_on_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        TellYouEverythingPage.goToPage();
        try {
            if(TellYouEverythingPage.getTitle().equals("leroymerlin.fr"))
                TellYouEverythingPage.recaptcha_v2();
        } catch (InterruptedException e) {
            System.out.println("Captcha handle failed. Exception\n\n"+e);
        }
        String expectedTitle = "Tout vous dire | Leroy Merlin";
        String actualTitle = TellYouEverythingPage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Not the page title expected");
    }
    @Then("Verify whether first article has a duplicate among the following articles")
    public void verify_whether_first_article_has_a_duplicate_among_the_following_articles() {
        // Write code here that turns the phrase above into concrete actions
        TellYouEverythingPage tellYouEverythingPage = new TellYouEverythingPage();
        Assert.assertFalse(TellYouEverythingPage.checkDuplicates());
    }
}
