package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;

public class MsgErrorSteps {
    @Given("User on the homepage")
    public void user_on_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        HomePage.goToPage();
        HomePage.cookieModalHandler();
    }
    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
