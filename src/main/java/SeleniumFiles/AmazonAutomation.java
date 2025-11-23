package SeleniumFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Actions act = new Actions(driver);
        Thread.sleep(2000);
        act.moveToElement(driver.findElement(By.xpath("//div[@id='nav-link-accountList']"))).perform();
        Thread.sleep(2000);
        WebElement account = driver.findElement(By.xpath("//div[contains(text(),'Your Account')]/..//ul//li[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(account)).click();

    }
}
