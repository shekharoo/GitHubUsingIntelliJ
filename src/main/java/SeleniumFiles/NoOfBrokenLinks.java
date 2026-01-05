package SeleniumFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class NoOfBrokenLinks {
    public static void countBrokenLinks(WebDriver driver,String link) throws IOException {
        int noOfWorkingLinks=0;
        int noOfBrokenLinks=0;
        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement w:links)
        {
          String hrefText=w.getAttribute("href");
            System.out.println("Text is: "+hrefText);
            if(con.getResponseCode()==200)
            {
                noOfWorkingLinks++;
            }
            else {
                noOfBrokenLinks++;
            }
        }
        System.out.println("No of working Links: "+noOfWorkingLinks);
        System.out.println("No of Broken Links: "+noOfBrokenLinks);

    }

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        String url="https://www.magadhonline.com/";
        driver.get(url);
        NoOfBrokenLinks.countBrokenLinks(driver,url);
    }
}
