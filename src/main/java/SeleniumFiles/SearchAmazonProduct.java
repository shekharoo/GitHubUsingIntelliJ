package SeleniumFiles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class SearchAmazonProduct {
    //WebDriver driver = null;
    public void captureScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot scnshot = (TakesScreenshot)driver;
        File src = scnshot.getScreenshotAs(OutputType.FILE);
        //File dsc = new File(".\\SeleniumDemo\\screenshot\\amazon.png");
        File dsc = new File("./screenshot/amazon.png");
        FileUtils.copyFile(src,dsc);
    }
    public static void main(String[] args) throws IOException {
        WebDriver driver= new ChromeDriver();
        System.out.println("Driver address is: "+driver);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        SearchAmazonProduct sap = new SearchAmazonProduct();
        sap.captureScreenshot(driver);

    }
}
