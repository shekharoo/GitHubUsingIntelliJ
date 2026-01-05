package DockerClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DockerDemo_Firefox {
//    @Test
//    public void launchChromeBrowserDocker() throws MalformedURLException {
//        ChromeOptions options= new ChromeOptions();
//        URL url = new URL("http://localhost:4444/wd/hub");
//        options.addArguments("--start-maximized");
//        RemoteWebDriver driver = new RemoteWebDriver(url,options);
//        //driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://demowebshop.tricentis.com/");
//        driver.findElement(By.linkText("Register")).click();
//
//    }
//
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
    @Test
    public void launchFirefoxBrowserDocker() throws MalformedURLException {
        ChromeOptions options= new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        URL url = new URL("http://localhost:4444/wd/hub");
        options.addArguments("--start-maximized");
        options.setCapability("se:name", "RegisterTest_ValidRegisterClick");
        WebDriver driver = new RemoteWebDriver(url,options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.linkText("Register")).click();
        driver.quit();

    }
}
