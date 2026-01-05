package TestNGClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

//@Test(enabled = false)
public class TestNGAnnotationsDemo {
    WebDriver driver=null;

    @Test(groups = "Regression")
    @Parameters({"browser"})
    public void initializationStep1(String browser)
    {
        Reporter.log("Initialization Successful for Regression!!",true);
        Reporter.log("Browser value is: "+browser,true);
        //driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf())
    }
    @Test(groups = "Smoke")
    @Parameters({"browser"})
    public void initializationStep(String browser)
    {
        Reporter.log("Initialization Successful for Smoke!!",true);
        Reporter.log("Browser value is: "+browser,true);
        //driver=new ChromeDriver();
    }

//    @Test()
//    public void initializationStep1()
//    {
//        Reporter.log("Initialization Successful!!",true);
//        driver=new ChromeDriver();
//    }

//    @Test(invocationCount = 2)
//    public void sampleTest1()
//    {
//        Reporter.log("This is sample method 1..",true);
//        driver=new ChromeDriver();
//    }
//    @Test(invocationCount = 3)
//    public void sampleTest2()
//    {
//        Reporter.log("This is sample method 2..",true);
//        driver=new ChromeDriver();
//    }
//    @Test(invocationCount = 4)
//    public void sampleTest3()
//    {
//        Reporter.log("This is sample method 3..",true);
//        driver=new ChromeDriver();
//    }

}
