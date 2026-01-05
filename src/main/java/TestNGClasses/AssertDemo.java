package TestNGClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AssertDemo {
    @Test
    public void AssertDemo()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="Demo Web Shops";
        //Soft Assert
        SoftAssert asserts = new SoftAssert();//in case of soft assert line#26 will print
        asserts.assertEquals(actualTitle,expectedTitle,"Test");
        //Hard Assert
        Assert.assertEquals(actualTitle,expectedTitle);//in case of hard assert line#26 will not print
        System.out.println("Navigated to homepage successfully!!");
        asserts.assertAll();


    }
}
