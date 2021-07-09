package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;
import pageObjects.TellYouEverythingPage;

public class MsgErrorSteps {
    @Given("User on the homepage")
    public void user_on_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        HomePage.goToPage();
        HomePage.cookieModalHandler();
    }
    @And("User clicks on the connection button in the navbar")
    public void user_clicks_on_the_connection_button_in_the_navbar() {
        // Write code here that turns the phrase above into concrete actions
        HomePage.clickOnConnection();
        String expectedTitle = "Login";
        String actualTitle = LoginPage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Not the page title expected");
    }
    @And("User clicks on sign up button")
    public void user_clicks_on_sign_up_button() {
        // Write code here that turns the phrase above into concrete actions
        LoginPage.clickOnSignUp();
        String expectedTitle = "Je crée mon compte | Leroy Merlin";
        String actualTitle = SignUpPage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Not the page title expected");
    }
    @When("User enters {int} in postal code field")
    public void user_enters_in_postal_code_field(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        SignUpPage.insertPostalCode(int1.toString());
    }
    @Then("The error message shown should not be {string}")
    public void the_error_message_shown_should_not_be(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertFalse(SignUpPage.checkPostalCodeError(arg0));
    }
}
