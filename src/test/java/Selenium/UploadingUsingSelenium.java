package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UploadingUsingSelenium {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement uploadEle = driver.findElement(By.id("uploadFile"));
        //scroll browser untill element is visible
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].scrollIntoView(true)",uploadEle);
        Thread.sleep(10000);
        //jse.executeScript("arguments[0].click();",uploadEle);
        //uploadEle.click();
        System.out.println("Element is clicked successfully!!");
        String filePath="C:\\Users\\Shekhar\\OneDrive\\Desktop\\A1.JPG";
        uploadEle.sendKeys(filePath);

    }
}
