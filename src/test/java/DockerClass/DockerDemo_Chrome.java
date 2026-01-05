package DockerClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.URL;
import java.util.Map;

public class DockerDemo_Chrome {
//    @Test
//    public void launchChromeBrowserDocker() throws MalformedURLException {
//        ChromeOptions options= new ChromeOptions();
//        URL url = new URL("http://localhost:4444/wd/hub");
//        options.addArguments("--start-maximized");
//        options.setCapability("se:name", "RegisterTest_ValidRegisterClick");
//        Map<String, Object> map = options.asMap();
//        System.out.println("All values of chrome options: "+map);
//        WebDriver driver = new RemoteWebDriver(url,options);
//        //driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://demowebshop.tricentis.com/");
//        driver.findElement(By.linkText("Register")).click();
//        driver.quit();
//
//    }

//    @Test
//    public void launchEdgeBrowserDocker() throws MalformedURLException {
//        EdgeOptions options= new EdgeOptions();
//        URL url = new URL("http://localhost:4444/wd/hub");
//        options.addArguments("--start-maximized");
//        RemoteWebDriver driver = new RemoteWebDriver(url,options);
//        //driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://demowebshop.tricentis.com/");
//        driver.findElement(By.linkText("Register")).click();
//
//    }
//    @Test
//    public void launchFirefoxBrowserDocker() throws MalformedURLException {
//        FirefoxOptions options = new FirefoxOptions();
//        URL url = new URL("http://localhost:4444/wd/hub");
//        options.addArguments("--start-maximized");
//        RemoteWebDriver driver = new RemoteWebDriver(url,options);
//        //driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://demowebshop.tricentis.com/");
//        driver.findElement(By.linkText("Register")).click();
//
//    }

    @Test
    public void launchBrowserStack() throws MalformedURLException {


        MutableCapabilities options = new MutableCapabilities();
        options.setCapability("browserName", "Chrome");
        options.setCapability("browserVersion", "latest");

        MutableCapabilities bstackOptions = new MutableCapabilities();
        bstackOptions.setCapability("os", "Windows");
        bstackOptions.setCapability("osVersion", "11");
        bstackOptions.setCapability("sessionName", "Login Test");

        options.setCapability("bstack:options", bstackOptions);

        WebDriver driver = new RemoteWebDriver(
                new URL("https://shekharanand_HYBnsf:158StVBXjq5Hv5mMCxTq@hub.browserstack.com/wd/hub"),
                options
        );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.linkText("Register")).click();
        driver.quit();
    }
}
