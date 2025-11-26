package SeleniumFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SalesforceAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://capgemini10.my.salesforce.com");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("anandmail2013-yy83@force.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("$Company123$");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

        Thread.sleep(10000);
        driver.findElement(By.xpath("//A[normalize-space(@role)=\"tab\" and @title=\"ABC | Account\" and normalize-space(@class)=\"tabHeader slds-context-bar__label-action\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//SPAN[starts-with(.,'Upload')]")).click();
        Thread.sleep(1000);
        //get text of Proposal:
        String proposalText = driver.findElement(By.xpath("//a[starts-with(.,'Proposal')]")).getText();
        System.out.println("Text is: "+proposalText);





        //        Actions act = new Actions(driver);
//        Thread.sleep(2000);
//        act.moveToElement(driver.findElement(By.xpath("//div[@id='nav-link-accountList']"))).perform();
//        Thread.sleep(2000);
//        WebElement account = driver.findElement(By.xpath("//div[contains(text(),'Your Account')]/..//ul//li[1]"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(account)).click();

    }
}
