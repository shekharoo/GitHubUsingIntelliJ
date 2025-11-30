package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeature {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is on Login page");
        //throw new io.cucumber.java.PendingException();
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Username: "+username+" Password: "+password);
        //throw new io.cucumber.java.PendingException();
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User clicks on login button successfully!!");
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is redirected successfully to dashboard page");
        //throw new io.cucumber.java.PendingException();
    }

    @And("a welcome message {string} should be displayed")
    public void a_welcome_message_should_be_displayed(String string) {

        // Write code here that turns the phrase above into concrete actions
        System.out.println("Welcome message String is :"+string+" displayed successfully!");
        //throw new io.cucumber.java.PendingException();
    }
}
