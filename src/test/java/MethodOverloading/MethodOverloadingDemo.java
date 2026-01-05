package MethodOverloading;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MethodOverloadingDemo {
    WebDriver driver=null;
    By locator=null;
    WebElement element = null;
    String xpath=null;
    @Test(priority = 1)
    public void initializeChrome()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://49.249.28.218:8098/");
        xpath="//button[@type='submit']";
        locator=By.xpath(xpath);
        element=driver.findElement(By.xpath(xpath));
        System.out.println("Finished initialization() run");
    }
    @Test(priority = 2)
    public void clickDemo()
    {
        //using 1st type click()
//        clickOnElement(driver,xpath);
//        System.out.println("Called clickedDemo()");
        //using 2nd type click()
//        clickOnElement(driver,locator);
//        System.out.println("Called clickedDemo()");
        //using 3rd type click()
        clickOnElement(driver,element);
        System.out.println("Called clickedDemo()");
    }

    //@Test
    public void clickOnElement(WebDriver driver,String xpath)
    {
        By locator=By.xpath(xpath);
        driver.findElement(locator).click();
    }
    //@Test
    public void clickOnElement(WebDriver driver,By Locator)
    {
        driver.findElement(locator).click();
    }
    //@Test
    public void clickOnElement(WebDriver driver,WebElement element)
    {
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",element);

    }

}
