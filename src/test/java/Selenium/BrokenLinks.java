package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://demoqa.com");
        URL url=new URL("https://demoqa.com");
        HttpURLConnection con=(HttpURLConnection)url.openConnection();
        con.getResponseCode();
        //con.
    }
}
