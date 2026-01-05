package SeleniumFiles;

import ObjectRepoUtility.*;
import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtilities;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestNGHelperDemo {
    public static ContactsPage contPage = null;
    public static CreateCampaignsPage createCampPage = null;
    public static CreateContactsPage createContPage = null;
    public static CreateProductsPage createProdPage = null;
    public static HomePage hp = null;
    public static LoginPage lp = null;
    public static ProductsPage pp = null;
    public static SelectCampaignsPage selCampPage = null;

    //Run All
    @Test(enabled = false)
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

    @DataProvider
    public Object[][] loginDetails() throws IOException {
        FileInputStream fis = new FileInputStream("./src\\main\\resources\\NinzaTestData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Login");
        int row = sh.getLastRowNum();
        int cell = sh.getRow(row).getLastCellNum();
        Object[][] data = new Object[row][cell];
        for (int i = 0; i < row; i++) {
            //sh.getRow(i).get
            for (int j = 0; j < cell; j++) {
                data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();

            }

            //cell=sh.getRow(i).getCell(i+1);
        }
        return data;
    }
    @Test(dataProvider = "loginDetails",enabled = false)
    public static void loginToApp(String url, String username, String password) throws IOException, ParseException {
        WebDriver driver = NinzaAutomation.launchBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("inputPassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.quit();
    }
    @Test(dataProvider = "loginDetails",enabled = false)
    public static void loginNinza(WebDriver driver) throws InterruptedException, IOException, ParseException {

        //WebDriver driver =  NinzaAutomation.launchBrowser();
        //WebDriverUtilities.waitForPageToLoad(driver);
        driver.get(ReadFromJson.readFromJson("url"));
        Thread.sleep(1000);
        LoginPage lp = new LoginPage(driver);
        lp.loginToNinza(ReadFromJson.readFromJson("username"),ReadFromJson.readFromJson("password"));
        System.out.println("Login is Successfull!!");
    }
    @Test(enabled = false)
    public static void logoutNinZa(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebDriverUtilities.mouseHoverOnWebelemment(driver,hp.getLogOutIcon());
        Thread.sleep(1000);
        hp.getLogOutLink().click();
        System.out.println("Log Out is Successfull!!");
    }
    @Test(enabled = false)
    public static String flowId(WebDriver driver,String flowNameId)
    {
        List<WebElement> listFLows = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
        String flowId = listFLows.get(0).getText();
        System.out.println(flowNameId+"Id is captured successfully!");
        return flowId;
    }
    @Test(enabled = false)
    public static void verifyPopUpAndCreation(WebDriver driver,String flowName) throws InterruptedException, IOException {
        Thread.sleep(1000);
        WebElement popUp =createCampPage.getPopUp();
        //Get text of popup
        String popUpText = popUp.getText();
        if(popUp.isDisplayed())
        {
            if(popUpText.contains("Successfully Added")) {

                popUpText=JavaUtility.extractTextFromPopUp(popUp,flowName);
                //Store flow Name in Property File
                JavaUtility.writeToPropertyFile(flowName+"Name",popUpText);
                System.out.println(flowName+" name is: "+popUpText);
                System.out.println("Create "+flowName+" is Successful!!");
                //Capture flow ID
                String flowNameId = NinzaAutomation_TestNG.flowId(driver,flowName);

                System.out.println(flowName+"Id: "+flowNameId);
                //Store flow ID in Property File
                JavaUtility.writeToPropertyFile(flowName+"Id",flowNameId);

            }
            else{
                System.out.println("Create "+flowName+" is not Successful!!");
            }
        }
        else {
            System.out.println("Create "+flowName+" pop up is not displayed");
        }

    }
    @Test(priority = 0)
    public static void ninzaTC04createCampaignWithMandatoryDetails() throws Throwable {
        WebDriver driver= NinzaAutomation_TestNG.launchBrowser();
        NinzaAutomation_TestNG.loginNinza(driver);
        hp.getCreateCampaignButton().click();
        createCampPage.createCampaignWithMandatoryDetails(JavaUtility.generateCampaignName(), ExcelUtility.toReadDataFromExcel("Campaigns",1,1));
        NinzaAutomation_TestNG.verifyPopUpAndCreation(driver,"campaign");
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation_TestNG.logoutNinZa(driver);
        driver.quit();
    }
    @Test(priority = 1)
    public static void ninzaTC05createCampaignWithClosingDate() throws Throwable {
        WebDriver driver= NinzaAutomation_TestNG.launchBrowser();
        NinzaAutomation_TestNG.loginNinza(driver);
        hp.getCreateCampaignButton().click();
        createCampPage.createCampaignWithClosingDate(JavaUtility.generateCampaignName(),ExcelUtility.toReadDataFromExcel("Campaigns",1,1),JavaUtility.getCurrentDate());
        NinzaAutomation_TestNG.verifyPopUpAndCreation(driver,"campaign");
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation_TestNG.logoutNinZa(driver);
        driver.quit();
    }
}
