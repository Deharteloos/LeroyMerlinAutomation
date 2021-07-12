package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.AfterSalesServicePage;
import pageObjects.FaqPage;
import pageObjects.TellYouEverythingPage;

public class NonQuestionSteps {
    @Given("User on the page {string}")
    public void user_on_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        AfterSalesServicePage.goToPage();
        AfterSalesServicePage.cookieModalHandler();
        try {
            if(TellYouEverythingPage.getTitle().equals("leroymerlin.fr"))
                TellYouEverythingPage.recaptcha_v2();
        } catch (InterruptedException e) {
            System.out.println("Captcha handle failed. Exception\n\n"+e);
        }
        String actualTitle = AfterSalesServicePage.getTitle();
        Assert.assertEquals(actualTitle, string, "Not the page title expected");
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String arg0) {
        AfterSalesServicePage.clickOnQuestionBlock();
        Assert.assertTrue(AfterSalesServicePage.isAnswerBlockDisplayed());
    }

    @When("Clicks on point relais fermé")
    public void clicks_on_point_relais_fermé() {
        // Write code here that turns the phrase above into concrete actions
        AfterSalesServicePage.navigateToRelayPointClosed();
        Assert.assertTrue(FaqPage.getUrl().contains("foire-aux-questions.html"));
    }

    @When("Clicks on suivi commande Marketplace")
    public void clicks_on_suivi_commande_marketplace() {
        // Write code here that turns the phrase above into concrete actions
        AfterSalesServicePage.navigateToMarketplaceOrderTracking();
        Assert.assertTrue(FaqPage.getUrl().contains("foire-aux-questions.html"));
    }

    @When("Clicks on suivi commande")
    public void clicks_on_suivi_commande() {
        // Write code here that turns the phrase above into concrete actions
        AfterSalesServicePage.navigateToOrderTracking();
        Assert.assertTrue(FaqPage.getUrl().contains("foire-aux-questions.html"));
    }

    @Then("The question should be found")
    public void the_question_should_be_found() {
        Assert.assertTrue(FaqPage.questionExists());
    }

}
