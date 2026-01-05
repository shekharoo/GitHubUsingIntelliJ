package StepDefinitions;

import genericUtilities.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginFeature{
    WebDriver driver = null;
    @BeforeAll
    public static void before_all(){
 System.out.println("All methods are initialized..");
    }
    @AfterAll
    public static void after_all()
    {
        System.out.println("Running at last and all methods are closed..");
    }
    @Before
    public static void before()
    {
        System.out.println("DB Connection is initialized.");
    }
    @BeforeStep
    public static void before_step()
    {
        System.out.println("Ninza is login successfully!!..");
    }
    @Test
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

    @Test
    @Given("Open Browser")
    public void open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //throw new io.cucumber.java.PendingException();
    }
    //@Test
    @When("User login with {string} and {string}")
    public void user_login_with_and(String string, String string2) {
        driver.get("http://49.249.28.218:8098/");
        driver.findElement(By.id("username")).sendKeys("rmgyantra");
        driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
        //throw new io.cucumber.java.PendingException();
    }
    //@Test
    @Then("Click on Submit button")
    public void click_on_submit_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //throw new io.cucumber.java.PendingException();
    }
}
