package SeleniumFiles;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingPopUps {
    public void handlePopUp(WebDriver driver) throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String str = alert.getText();
        System.out.println("Alert text message is: "+str);
        alert.accept();
        //Extract text of Alert dialogue box

    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        HandlingPopUps pop = new HandlingPopUps();
        pop.handlePopUp(driver);


    }
}
