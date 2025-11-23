package SeleniumFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);
        //Find total no of frames in a page
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Integer noOfFrames = Integer.parseInt(jse.executeScript("return window.length").toString()) ;
        System.out.println("No of frames are: "+noOfFrames);

        //Switch to 1st frame using id
        driver.switchTo().frame("frame1");
        System.out.println("Switch to Frame1 is successful!!");
        String text = driver.findElement(By.xpath("(//h1[@id='sampleHeading'])")).getText();
        System.out.println("Frame text is: "+text);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        System.out.println("Switch to Frame2" +
                " is successful!!");
        String text1 = driver.findElement(By.xpath("(//h1[@id='sampleHeading'])")).getText();
        System.out.println("Frame text is: "+text1);

    }
}
