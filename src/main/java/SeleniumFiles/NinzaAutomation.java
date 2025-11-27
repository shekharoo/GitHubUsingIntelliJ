package SeleniumFiles;

import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtilities;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NinzaAutomation {

    public static WebDriver launchBrowser() throws IOException, ParseException {
        WebDriver driver = null;
        String BROWSER = ReadFromJson.readFromJson("browser");
        if(BROWSER.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.password_manager_leak_detection", false);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
            WebDriverUtilities.toMaximize(driver);
        } else if (BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else {
            driver = new FirefoxDriver();
        }
        return driver;
    }


    public static WebDriver loginNinza() throws InterruptedException, IOException, ParseException {

        WebDriver driver =  NinzaAutomation.launchBrowser();
        WebDriverUtilities.waitForPageToLoad(driver);
        //driver.get(ReadFromPropertyFile.readFromPropertyFile("URL"));
        driver.get(ReadFromJson.readFromJson("url"));
        Thread.sleep(1000);
        //driver.findElement(By.id("username")).sendKeys(ReadFromPropertyFile.readFromPropertyFile("Username"));
        //driver.findElement(By.id("inputPassword")).sendKeys(ReadFromPropertyFile.readFromPropertyFile("Password"));

        driver.findElement(By.id("username")).sendKeys(ReadFromJson.readFromJson("username"));
        driver.findElement(By.id("inputPassword")).sendKeys(ReadFromJson.readFromJson("password"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login is Successfull!!");
        return driver;
    }
    public static void logoutNinZa(WebDriver driver) throws InterruptedException {
        WebElement logOut = driver.findElement(By.xpath("//div[@class='user-icon']"));
        Actions act = new Actions(driver);
        act.moveToElement(logOut).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
        System.out.println("Log Out is Successfull!!");
    }
    public static String captureCampaignId(WebDriver driver,String campaignName)
    {
        List<WebElement> listCamapigns = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
        String campaignId = listCamapigns.get(0).getText();
        System.out.println("Campaign id is captured successfully!");
        return campaignId;
    }

    public static void ninzaTC01CreateCampaign() throws Throwable {
        //Login to App
        WebDriver driver = NinzaAutomation.loginNinza();
        Thread.sleep(2000);
        //Click on Campaign button
        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[1]/a")).click();
        //Click on create Campaign button
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        //Fill Campaign Name
        String campName = JavaUtility.generateCampaignName();
        //System.out.println("cName is: "+campName);
        //Thread.sleep(1000);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        WebElement campWebEle = driver.findElement(By.xpath("//input[@name='campaignName']"));
//        jse.executeScript("arguments[0].value='"+campName+"';", campWebEle);
        driver.findElement(By.xpath("//input[@name='campaignName']")).sendKeys(campName);
        //Fill Target Size
        //driver.findElement(By.xpath("//input[@name='targetSize']")).clear();
        driver.findElement(By.xpath("//input[@name='targetSize']")).sendKeys(ExcelUtility.toReadDataFromExcel("Campaigns",1,1));
        //Enter expected Closed Date
        driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(JavaUtility.getCurrentDate());
        //Click Create Campaign button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Create Campaign pop up
        Thread.sleep(2000);
        WebElement popUp = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div[1]"));
        //Get text of popup
        String popUpText = popUp.getText();
        if(popUp.isDisplayed())
        {
            if(popUpText.contains("Successfully Added")) {

                String campaignName=JavaUtility.extractTextFromPopUp(popUp,"Campaigns");
                //Store Campaign Name in Property File
                JavaUtility.writeToPropertyFile("CampaignName",campaignName);
                System.out.println("Campaign name is: "+campaignName);
                System.out.println("Create Campaign is Successful!!");
                //Capture Campaign ID
                Thread.sleep(10000);
                String campaignId = NinzaAutomation.captureCampaignId(driver, campaignName);
                System.out.println("CampaignId: "+campaignId);
                //Store Campaign ID in Property File
                JavaUtility.writeToPropertyFile("CampaignId",campaignId);

            }
            else{
                System.out.println("Create Campaign is not Successful!!");
            }
        }
        else {
            System.out.println("Create Campaign pop up is not displayed");
        }
        Thread.sleep(2000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC02SearchByCampaignID() throws InterruptedException, IOException, ParseException {
        //Login to App
        WebDriver driver = NinzaAutomation.loginNinza();
        Thread.sleep(2000);
        //Select Search by Campaign ID
        driver.findElement(By.xpath("//select[@class='form-control']/option[1]")).click();
        //Input Campaign ID
        Thread.sleep(1000);
        //Get Campaign ID from property File
        String CampaignId = JavaUtility.getFromPropertyFile("CampaignId");
        //Serach for Camapign id inside search box
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(CampaignId);
        //Extract Campaign ID from Table display
        WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[1]"));
        if(camID.getText().equalsIgnoreCase(CampaignId))
        {
            System.out.println("Search Campaign by ID is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC03SearchByCampaignName() throws InterruptedException, IOException, ParseException {
        //Login to App
        WebDriver driver = NinzaAutomation.loginNinza();
        Thread.sleep(2000);
        //Select Search by Campaign Name
        driver.findElement(By.xpath("//select[@class='form-control']/option[2]")).click();
        //Get Campaign Name from property File
        String CampaignName = JavaUtility.getFromPropertyFile("CampaignName");
        Thread.sleep(1000);
        //Search for Camapign name inside search box
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(CampaignName);
        //Extract Campaign ID from Table display
        WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[2]"));
        if(camID.getText().equalsIgnoreCase(CampaignName))
        {
            System.out.println("Search Campaign by Name is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        //Close browser
        Thread.sleep(2000);
        driver.quit();
    }

    public static void ninzaTC04SearchByContactID(WebDriver driver) throws InterruptedException, IOException, ParseException {
        //Login to App
        //NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Contact header button
        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[2]/a")).click();
        Thread.sleep(1000);
        //Select Search by Contact ID
        driver.findElement(By.xpath("//select[@class='form-control']/option[1]")).click();
        //Input Contact ID
        Thread.sleep(1000);
        //Serach for Contact id inside search box //Contact ID: CON00039, Contact Name: QSP
        driver.findElement(By.xpath("//input[@placeholder='Search by Contact Id']")).sendKeys("CON00039");
        //Extract Contact ID from Table display
        WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[1]"));
        if(camID.getText().equalsIgnoreCase("CON00039"))
        {
            System.out.println("Search Contact by ID is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC05SearchByContactName(WebDriver driver) throws InterruptedException, IOException, ParseException {
        //Login to App
        //NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[2]/a")).click();
        Thread.sleep(1000);
        //Select Search by Contact Name
        driver.findElement(By.xpath("//select[@class='form-control']/option[2]")).click();
        //Input Campaign ID
        Thread.sleep(1000);
        //Serach for Contact name inside search box //Contact ID: CAM00444, Contac Name: QSP
        driver.findElement(By.xpath("//input[@placeholder='Search by Contact Name']")).sendKeys("QSP");
        //Extract Contact Name from Table display
        WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[2]"));
        if(camID.getText().equalsIgnoreCase("QSP"))
        {
            System.out.println("Search Contact by Name is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        //Close browser
        Thread.sleep(2000);
        driver.quit();
    }

    public static void ninzaTC06CreateLeadUsingCampaignID(WebDriver driver) throws InterruptedException, IOException, ParseException {
        //Login to App
        //NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Lead button
        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[3]/a")).click();
        Thread.sleep(1000);
        //Click on create Lead button
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(1000);
        //Store parent window handle
        String parentWh = driver.getWindowHandle();
        //Fill Lead Name
//        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(NinzaAutomation.generateRandomStrings());
//        Thread.sleep(1000);
//        //Fill Company
//        driver.findElement(By.xpath("//input[@name='company']")).sendKeys(NinzaAutomation.generateRandomStrings());
//        Thread.sleep(1000);
//        //Fill Lead Source
//        driver.findElement(By.xpath("//input[@name='leadSource']")).sendKeys(NinzaAutomation.generateRandomStrings());
//        Thread.sleep(1000);
//        //Fill Industry
//        driver.findElement(By.xpath("//input[@name='industry']")).sendKeys(NinzaAutomation.generateRandomStrings());
//        Thread.sleep(1000);
//        //Fill Phone
//        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(NinzaAutomation.generateRandomMobileNo());
//        Thread.sleep(1000);
//        //Fill Lead Status
//        driver.findElement(By.xpath("//input[@name='leadStatus']")).sendKeys(NinzaAutomation.generateRandomStrings());
        Thread.sleep(1000);
        //Campaign button
        driver.findElement(By.xpath("//div[@class='form-container']/div[2]/div[9]//button")).click();
        Thread.sleep(1000);
        //Passing window handle to dialogue box
        Set<String> windowHndleSet = driver.getWindowHandles();
        System.out.println("Window handle size: "+windowHndleSet.size());
        //Switch window handle to Dialogue box
        for(String whs:windowHndleSet)
        {
            driver.switchTo().window(whs);
            if(driver.getTitle().equalsIgnoreCase("Select Campaign"))
            {
                System.out.println("Switch to Dialogue box window successful");
                //windowHndleSet.remove(whs);
                //driver.switchTo().window(whs);
            }
        }
        Thread.sleep(1000);
        //select campaign id from drop down
        driver.findElement(By.xpath("//select[@id='search-criteria']/option[1]"));
        //Serach for Camapign id inside search box //Campign ID: CAM00444, Campaign Name: DEMOQSelenium
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("CAM00444");
        Thread.sleep(1000);
        //Click on Select Campaign button
        driver.findElement(By.xpath("//button[@class='select-btn']")).click();
        Thread.sleep(1000);
        //Switch back to parent window handle
        System.out.println("Switching to parent window");

        driver.switchTo().window(parentWh);
        Thread.sleep(2000);
        System.out.println("Switch to parent window is successful!!");
        //Click on Create Contact button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        //Capture successful create contact pop up
        WebElement popUp = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div"));
        if(popUp.isDisplayed())
        {
            System.out.println("Create Lead is Successful!!");
        }
        Thread.sleep(10000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC07SearchByLeadID(WebDriver driver) throws InterruptedException, IOException, ParseException {
        //Login to App
        //NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Lead header button
        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[3]/a")).click();
        Thread.sleep(1000);
        //Select Search by Lead ID
        driver.findElement(By.xpath("//select[@class='form-control']/option[1]")).click();
        //Input Lead ID
        Thread.sleep(1000);
        //Serach for Lead id inside search box //Lead ID: LEAD00032, Lead Name: QspidersSelenium
        driver.findElement(By.xpath("//input[@placeholder='Search by Lead Id']")).sendKeys("LEAD00032");
        //Extract Lead ID from Table display
        WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[1]"));
        if(camID.getText().equalsIgnoreCase("LEAD00032"))
        {
            System.out.println("Search Lead by ID is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC08SearchByLeadName(WebDriver driver) throws InterruptedException, IOException, ParseException {
        //Login to App
       // NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Lead header button
        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[3]/a")).click();
        Thread.sleep(1000);
        //Select Search by Lead Name
        driver.findElement(By.xpath("//select[@class='form-control']/option[2]")).click();
        //Input Lead Name
        Thread.sleep(1000);
        //Serach for Lead name inside search box //Lead ID: LEAD00032, Lead Name: QspidersSelenium
        driver.findElement(By.xpath("//input[@placeholder='Search by Lead Name']")).sendKeys("QspidersSelenium");
        //Extract Lead Name from Table display
        WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[2]"));
        if(camID.getText().equalsIgnoreCase("QspidersSelenium"))
        {
            System.out.println("Search Lead by Name is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        //Close browser
        Thread.sleep(2000);
        driver.quit();
    }


    public static void ninzaTC10CreateContactUsingCampaignID() throws InterruptedException, IOException, ParseException {
        //Login to App
        //NinzaAutomation.loginNinza(driver);
        WebDriver driver = NinzaAutomation.launchBrowser();
        WebDriverUtilities.waitForPageToLoad(driver);
        WebDriverUtilities.toMaximize(driver);
        Thread.sleep(2000);
        //Click on Contact button
        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[2]/a")).click();
        Thread.sleep(1000);
        //Click on create Contact button
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(1000);
        //Store parent window handle
        String parentWh = driver.getWindowHandle();
        //Fill Organization
//        driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(NinzaAutomation.generateRandomStrings());
//        Thread.sleep(1000);
//        //Fill Title
//        driver.findElement(By.xpath("//input[@name='title']")).sendKeys(NinzaAutomation.generateRandomStrings());
//        Thread.sleep(1000);
//        //Fill Contact Name
//        driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(NinzaAutomation.generateRandomStrings());
//        Thread.sleep(1000);
//        //Fill Mobile
//        driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(NinzaAutomation.generateRandomMobileNo());
        Thread.sleep(1000);
        //Campaign button
        driver.findElement(By.xpath("//div[@class='form-container']/div[2]/div[4]//button")).click();
        Thread.sleep(1000);
        //Passing window handle to dialogue box
        Set<String> windowHndleSet = driver.getWindowHandles();
        System.out.println("Window handle size: "+windowHndleSet.size());
        //Switch window handle to Dialogue box
        for(String whs:windowHndleSet)
        {
            driver.switchTo().window(whs);
            if(driver.getTitle().equalsIgnoreCase("Select Campaign"))
            {
                System.out.println("Switch to Dialogue box window successful");
                //windowHndleSet.remove(whs);
                //driver.switchTo().window(whs);
            }
        }
        Thread.sleep(1000);
        //select campaign id from drop down
        driver.findElement(By.xpath("//select[@id='search-criteria']/option[1]"));
        //Serach for Camapign id inside search box //Campign ID: CAM00444, Campaign Name: DEMOQSelenium
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("CAM00444");
        Thread.sleep(1000);
        //Click on Select Campaign button
        driver.findElement(By.xpath("//button[@class='select-btn']")).click();
        Thread.sleep(1000);
        //Switch back to parent window handle
        System.out.println("Switching to parent window");

        driver.switchTo().window(parentWh);
        Thread.sleep(2000);
        System.out.println("Switch to parent window is successful!!");
        //Click on Create Contact button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        //Capture successful create contact pop up
        WebElement popUp = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div"));
        if(popUp.isDisplayed())
        {
            System.out.println("Create Contact is Successful!!");
        }
        Thread.sleep(10000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void main(String[] args) throws Throwable {

        //NinzaAutomation.ninzaTC01CreateCampaign();
         //NinzaAutomation.ninzaTC02SearchByCampaignID();
        NinzaAutomation.ninzaTC03SearchByCampaignName();
        //NinzaAutomation.ninzaTC04SearchByContactID(driver);
        //NinzaAutomation.ninzaTC05SearchByContactName(driver);
        //NinzaAutomation.ninzaTC06CreateLeadUsingCampaignID(driver);
        //NinzaAutomation.ninzaTC07SearchByLeadID(driver);
        //NinzaAutomation.ninzaTC08SearchByLeadName(driver);
        //NinzaAutomation.ninzaTC10CreateContactUsingCampaignID(driver);

    }
}
