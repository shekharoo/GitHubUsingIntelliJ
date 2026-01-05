package TestNGClasses;

import ObjectRepoUtility.*;
import SeleniumFiles.NinzaAutomation;
import SeleniumFiles.NinzaAutomation_TestNG;
import SeleniumFiles.ReadFromJson;
import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtilities;
import genericUtilities.BaseClass;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TC01createCampaignWithMandatoryDetails extends BaseClass{
    public WebDriver driver=null;
    public static ContactsPage contPage = null;
    public static CreateCampaignsPage createCampPage = null;
    public static CreateContactsPage createContPage = null;
    public static CreateProductsPage createProdPage = null;
    public static HomePage hp = null;
    public static LoginPage lp = null;
    public static ProductsPage pp = null;
    public static SelectCampaignsPage selCampPage = null;

    public static String flowId(WebDriver driver,String flowNameId)
    {
        List<WebElement> listFLows = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
        String flowId = listFLows.get(0).getText();
        System.out.println(flowNameId+"Id is captured successfully!");
        return flowId;
    }

    public void verifyPopUpAndCreation(WebDriver driver,String flowName) throws InterruptedException, IOException {
        Thread.sleep(1000);
        WebElement popUp =createCampPage.getPopUp();
        //Get text of popup
        String popUpText = popUp.getText();
        if(popUp.isDisplayed())
        {
            if(popUpText.contains("Successfully Added")) {

                popUpText= JavaUtility.extractTextFromPopUp(popUp,flowName);
                //Store flow Name in Property File
                JavaUtility.writeToPropertyFile(flowName+"Name",popUpText);
                Reporter.log(flowName+" name is: "+popUpText,true);
                Reporter.log("Create "+flowName+" is Successful!!",true);
                //Capture flow ID
                String flowNameId = NinzaAutomation.flowId(driver,flowName);

                Reporter.log(flowName+"Id: "+flowNameId,true);
                //Store flow ID in Property File
                JavaUtility.writeToPropertyFile(flowName+"Id",flowNameId);

            }
            else{
                Reporter.log("Create "+flowName+" is not Successful!!",true);
            }
        }
        else {
            Reporter.log("Create "+flowName+" pop up is not displayed",true);
        }

    }
    //Launch Browser
    @BeforeClass
    public WebDriver launchBrowser() throws IOException, ParseException {
        //WebDriver driver = null;
        String BROWSER = ReadFromJson.readFromJson("browser");
        if(BROWSER.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.password_manager_leak_detection", false);
            options.setExperimentalOption("prefs", prefs);
            this.driver = new ChromeDriver(options);
            WebDriverUtilities.toMaximize(driver);
            Reporter.log("Browser is launched successfully!!", true);
            contPage = new ContactsPage(driver);
            createCampPage = new CreateCampaignsPage(driver);
            createContPage = new CreateContactsPage(driver);
            createProdPage = new CreateProductsPage(driver);
            lp = new LoginPage(driver);
            pp = new ProductsPage(driver);
            selCampPage = new SelectCampaignsPage(driver);
            hp = new HomePage(driver);
        } else if (BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    @AfterClass
    public void AfterClass() {
        Reporter.log("Browser is closed successfully!!", true);
        driver.quit();
    }

    @BeforeMethod
    public void loginNinza() throws InterruptedException, IOException, ParseException {

        //WebDriver driver =  NinzaAutomation.launchBrowser();
        WebDriverUtilities.waitForPageToLoad(driver);
        driver.get(ReadFromJson.readFromJson("url"));
        Thread.sleep(1000);
        LoginPage lp = new LoginPage(driver);
        lp.loginToNinza(ReadFromJson.readFromJson("username"),ReadFromJson.readFromJson("password"));
        Reporter.log("Login is Successfull!!",true);
    }

    @Test
    public void createCampaignWithMandatoryDetails() throws Throwable {
        hp.getCreateCampaignButton().click();
        createCampPage.createCampaignWithMandatoryDetails(JavaUtility.generateCampaignName(), ExcelUtility.toReadDataFromExcel("Campaigns",1,1));
        verifyPopUpAndCreation(driver,"campaign");
        //Close popUp
        createCampPage.getClosePopUp().click();
    }
    @AfterMethod
    public void logoutNinZa() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverUtilities.mouseHoverOnWebelemment(driver,hp.getLogOutIcon());
        Thread.sleep(1000);
        hp.getLogOutLink().click();
        Reporter.log("Log out is Successfull!!",true);
    }

}
