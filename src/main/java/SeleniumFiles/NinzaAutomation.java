package SeleniumFiles;

import ObjectRepoUtility.*;
import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtilities;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NinzaAutomation extends WebDriverUtilities{
    public static ContactsPage contPage = null;
    public static CreateCampaignsPage createCampPage = null;
    public static CreateContactsPage createContPage = null;
    public static CreateProductsPage createProdPage = null;
    public static HomePage hp = null;
    public static LoginPage lp = null;
    public static ProductsPage pp = null;
    public static SelectCampaignsPage selCampPage = null;

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


    public static void loginNinza(WebDriver driver) throws InterruptedException, IOException, ParseException {

        //WebDriver driver =  NinzaAutomation.launchBrowser();
        //WebDriverUtilities.waitForPageToLoad(driver);
        driver.get(ReadFromJson.readFromJson("url"));
        Thread.sleep(1000);
        LoginPage lp = new LoginPage(driver);
        lp.loginToNinza(ReadFromJson.readFromJson("username"),ReadFromJson.readFromJson("password"));
        System.out.println("Login is Successfull!!");
    }
    public static void logoutNinZa(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebDriverUtilities.mouseHoverOnWebelemment(driver,hp.getLogOutIcon());
        Thread.sleep(1000);
        hp.getLogOutLink().click();
        System.out.println("Log Out is Successfull!!");
    }
    public static String flowId(WebDriver driver,String flowNameId)
    {
        List<WebElement> listFLows = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
        String flowId = listFLows.get(0).getText();
        System.out.println(flowNameId+"Id is captured successfully!");
        return flowId;
    }

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
                String flowNameId = NinzaAutomation.flowId(driver,flowName);

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

    public static void ninzaTC01CreateCampaign() throws Throwable {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Campaign link
        createCampPage.getCampaignLink().click();
        //Click on create Campaign button
        hp.getCreateCampaignButton().click();
        //Fill Campaign Name
        String campName = JavaUtility.generateCampaignName();
        createCampPage.getCampaignName().sendKeys(campName);
        //Fill Target Size
        createCampPage.getTargetSize().sendKeys(ExcelUtility.toReadDataFromExcel("Campaigns",1,1));
        //Enter expected Closed Date
        createCampPage.getExpectedCloseDate().sendKeys(JavaUtility.getCurrentDate());
        //Click Create Campaign button
        createCampPage.getCreateCampaignSubmitButton().click();
        //Verify campaign pop up and campaign creation
        Thread.sleep(2000);
        NinzaAutomation.verifyPopUpAndCreation(driver,"campaign");
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC02SearchByCampaignID() throws InterruptedException, IOException, ParseException {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Select Search by Campaign ID
        selCampPage.getSearchByCampaignId().click();
        //Input Campaign ID
        Thread.sleep(1000);
        //Get Campaign ID from property File
        String campaignId = JavaUtility.getFromPropertyFile("campaignId");
        //Search for Camapign id inside search box
        selCampPage.getCampaignSearchBox().sendKeys(campaignId);
        //Extract Campaign ID from Table display
        WebElement camID =  selCampPage.getCampaignIdTableDisplay();
        if(camID.getText().equalsIgnoreCase(campaignId))
        {
            System.out.println("Search Campaign by ID is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC03SearchByCampaignName() throws InterruptedException, IOException, ParseException {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Select Search by Campaign Name
        selCampPage.getSearchByCampaignName().click();
        //driver.findElement(By.xpath("//select[@class='form-control']/option[2]")).click();
        //Get Campaign Name from property File
        String campaignName = JavaUtility.getFromPropertyFile("campaignName");
        Thread.sleep(1000);
        //Search for Camapign name inside search box
        selCampPage.getCampaignSearchBox().sendKeys(campaignName);
        //Extract Campaign Name from Table display
        WebElement camID =selCampPage.getCampaignNameTableDisplay();
        if(camID.getText().equalsIgnoreCase(campaignName))
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
    public static void ninzaTC04createCampaignWithMandatoryDetails() throws Throwable {
        WebDriver driver=NinzaAutomation.launchBrowser();
        NinzaAutomation.loginNinza(driver);
        hp.getCreateCampaignButton().click();
        createCampPage.createCampaignWithMandatoryDetails(JavaUtility.generateCampaignName(),ExcelUtility.toReadDataFromExcel("Campaigns",1,1));
        NinzaAutomation.verifyPopUpAndCreation(driver,"campaign");
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }
    public static void ninzaTC05createCampaignWithClosingDate() throws Throwable {
        WebDriver driver=NinzaAutomation.launchBrowser();
        NinzaAutomation.loginNinza(driver);
        hp.getCreateCampaignButton().click();
        createCampPage.createCampaignWithClosingDate(JavaUtility.generateCampaignName(),ExcelUtility.toReadDataFromExcel("Campaigns",1,1),JavaUtility.getCurrentDate());
        NinzaAutomation.verifyPopUpAndCreation(driver,"campaign");
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }
    public static void ninzaTC06createCampaignWithTargetAudience() throws Throwable {
        WebDriver driver=NinzaAutomation.launchBrowser();
        NinzaAutomation.loginNinza(driver);
        hp.getCreateCampaignButton().click();
        String campaignName = JavaUtility.generateCampaignName();
        String trgtSize = ExcelUtility.toReadDataFromExcel("Campaigns", 1, 1);
        String trgtAudience = JavaUtility.getFromPropertyFile("targetAudience");
        String desc = JavaUtility.getFromPropertyFile("description");
        createCampPage.createCampaignWithTargetAudience(campaignName,trgtSize,trgtAudience,desc);
        NinzaAutomation.verifyPopUpAndCreation(driver,"campaign");
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC07SearchByContactID() throws InterruptedException, IOException, ParseException {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Contact header button
        hp.getContactsLink().click();
        Thread.sleep(1000);
        //Select Search by Contact ID
        contPage.getSearchContactByID().click();
        //Input Contact ID
        Thread.sleep(1000);
        //Get Contact ID from property File
        String contactId = JavaUtility.getFromPropertyFile("contactId");
        //Serach for Contact id inside search box
        contPage.getContactSearchBox().sendKeys(contactId);
        //Extract Contact ID from Table display
        WebElement camID = contPage.getContactIdTableDisplay();
        if(camID.getText().equalsIgnoreCase(contactId))
        {
            System.out.println("Search Contact by ID is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC08SearchByContactName() throws Throwable {
        //public static void ninzaTC08SearchByContactName() throws InterruptedException, IOException, ParseException {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Contact header button
        hp.getContactsLink().click();
        Thread.sleep(1000);
        //Select Search by Contact Name
        contPage.getSearchContactByName().click();
        //Input Contact Name
        Thread.sleep(1000);
        //Get Contact ID from property File
        String contactName = JavaUtility.getFromPropertyFile("contactName");
        //Serach for Contact id inside search box
        contPage.getContactSearchBox().sendKeys(contactName);
        //Extract Contact ID from Table display
        WebElement camID = contPage.getContactNameTableDisplay();
        if(camID.getText().equalsIgnoreCase(contactName))
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

//    public static void ninzaTC06CreateLeadUsingCampaignID(WebDriver driver) throws InterruptedException, IOException, ParseException {
//        //Login to App
//        //NinzaAutomation.loginNinza(driver);
//        Thread.sleep(2000);
//        //Click on Lead button
//        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[3]/a")).click();
//        Thread.sleep(1000);
//        //Click on create Lead button
//        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
//        Thread.sleep(1000);
//        //Store parent window handle
//        String parentWh = driver.getWindowHandle();
//        //Fill Lead Name
////        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(NinzaAutomation.generateRandomStrings());
////        Thread.sleep(1000);
////        //Fill Company
////        driver.findElement(By.xpath("//input[@name='company']")).sendKeys(NinzaAutomation.generateRandomStrings());
////        Thread.sleep(1000);
////        //Fill Lead Source
////        driver.findElement(By.xpath("//input[@name='leadSource']")).sendKeys(NinzaAutomation.generateRandomStrings());
////        Thread.sleep(1000);
////        //Fill Industry
////        driver.findElement(By.xpath("//input[@name='industry']")).sendKeys(NinzaAutomation.generateRandomStrings());
////        Thread.sleep(1000);
////        //Fill Phone
////        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(NinzaAutomation.generateRandomMobileNo());
////        Thread.sleep(1000);
////        //Fill Lead Status
////        driver.findElement(By.xpath("//input[@name='leadStatus']")).sendKeys(NinzaAutomation.generateRandomStrings());
//        Thread.sleep(1000);
//        //Campaign button
//        driver.findElement(By.xpath("//div[@class='form-container']/div[2]/div[9]//button")).click();
//        Thread.sleep(1000);
//        //Passing window handle to dialogue box
//        Set<String> windowHndleSet = driver.getWindowHandles();
//        System.out.println("Window handle size: "+windowHndleSet.size());
//        //Switch window handle to Dialogue box
//        for(String whs:windowHndleSet)
//        {
//            driver.switchTo().window(whs);
//            if(driver.getTitle().equalsIgnoreCase("Select Campaign"))
//            {
//                System.out.println("Switch to Dialogue box window successful");
//                //windowHndleSet.remove(whs);
//                //driver.switchTo().window(whs);
//            }
//        }
//        Thread.sleep(1000);
//        //select campaign id from drop down
//        driver.findElement(By.xpath("//select[@id='search-criteria']/option[1]"));
//        //Serach for Camapign id inside search box //Campign ID: CAM00444, Campaign Name: DEMOQSelenium
//        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("CAM00444");
//        Thread.sleep(1000);
//        //Click on Select Campaign button
//        driver.findElement(By.xpath("//button[@class='select-btn']")).click();
//        Thread.sleep(1000);
//        //Switch back to parent window handle
//        System.out.println("Switching to parent window");
//
//        driver.switchTo().window(parentWh);
//        Thread.sleep(2000);
//        System.out.println("Switch to parent window is successful!!");
//        //Click on Create Contact button
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        Thread.sleep(1000);
//        //Capture successful create contact pop up
//        WebElement popUp = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div"));
//        if(popUp.isDisplayed())
//        {
//            System.out.println("Create Lead is Successful!!");
//        }
//        Thread.sleep(10000);
//        //Logout of App
//        NinzaAutomation.logoutNinZa(driver);
//        driver.quit();
//    }

//    public static void ninzaTC07SearchByLeadID(WebDriver driver) throws InterruptedException, IOException, ParseException {
//        //Login to App
//        //NinzaAutomation.loginNinza(driver);
//        Thread.sleep(2000);
//        //Click on Lead header button
//        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[3]/a")).click();
//        Thread.sleep(1000);
//        //Select Search by Lead ID
//        driver.findElement(By.xpath("//select[@class='form-control']/option[1]")).click();
//        //Input Lead ID
//        Thread.sleep(1000);
//        //Serach for Lead id inside search box //Lead ID: LEAD00032, Lead Name: QspidersSelenium
//        driver.findElement(By.xpath("//input[@placeholder='Search by Lead Id']")).sendKeys("LEAD00032");
//        //Extract Lead ID from Table display
//        WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[1]"));
//        if(camID.getText().equalsIgnoreCase("LEAD00032"))
//        {
//            System.out.println("Search Lead by ID is Successful!!");
//        }
//        Thread.sleep(5000);
//        //Logout of App
//        NinzaAutomation.logoutNinZa(driver);
//        driver.quit();
//    }
//
//    public static void ninzaTC08SearchByLeadName(WebDriver driver) throws InterruptedException, IOException, ParseException {
//        //Login to App
//       // NinzaAutomation.loginNinza(driver);
//        Thread.sleep(2000);
//        //Click on Lead header button
//        driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[3]/a")).click();
//        Thread.sleep(1000);
//        //Select Search by Lead Name
//        driver.findElement(By.xpath("//select[@class='form-control']/option[2]")).click();
//        //Input Lead Name
//        Thread.sleep(1000);
//        //Serach for Lead name inside search box //Lead ID: LEAD00032, Lead Name: QspidersSelenium
//        driver.findElement(By.xpath("//input[@placeholder='Search by Lead Name']")).sendKeys("QspidersSelenium");
//        //Extract Lead Name from Table display
//        WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[2]"));
//        if(camID.getText().equalsIgnoreCase("QspidersSelenium"))
//        {
//            System.out.println("Search Lead by Name is Successful!!");
//        }
//        Thread.sleep(5000);
//        //Logout of App
//        NinzaAutomation.logoutNinZa(driver);
//        //Close browser
//        Thread.sleep(2000);
//        driver.quit();
//    }


    public static void ninzaTC09CreateContactUsingCampaignID() throws InterruptedException, IOException, ParseException {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Contact link
        hp.getContactsLink().click();
        Thread.sleep(1000);
        //Click on create Contact button
        contPage.getcreateContactButton().click();
        //driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(1000);
        //Store parent window handle
        String parentWh = driver.getWindowHandle();
        //Fill Organization
        createContPage.getOrganizationName().sendKeys(JavaUtility.generateOrganizationName());
        Thread.sleep(1000);
        //Fill Title
        createContPage.getTitle().sendKeys(JavaUtility.generateRandomStrings());
        Thread.sleep(1000);
        //Fill Contact Name
        createContPage.getContactName().sendKeys(JavaUtility.generateRandomStrings());
        Thread.sleep(1000);
        //Fill Mobile
        createContPage.getMobile().sendKeys(JavaUtility.generateRandomMobileNo());
        Thread.sleep(1000);
        //Campaign button
        createContPage.getSelectcampaignSubmitButton().click();
        Thread.sleep(1000);
        //Passing window handle to dialogue box
        WebDriverUtilities.switchToWindowByTitle(driver,"Select Campaign");
        Thread.sleep(1000);
        //select campaign id from drop down
        createContPage.getSelectCampaignIdDropDown().click();
        //Get Campaign Id from propert file
        String campaignId = JavaUtility.getFromPropertyFile("campaignId");
        //Serach for Camapign id inside search box
        createContPage.getSearchCampaignIdSearchBox().sendKeys(campaignId);
        Thread.sleep(1000);
        //Click on Select Campaign button
        createContPage.getSelectCampaignButtontable().click();
        Thread.sleep(1000);
        //Switch back to parent window handle
        System.out.println("Switching to parent window");
        WebDriverUtilities.switchToParentWindow(driver,parentWh);
        Thread.sleep(2000);
        System.out.println("Switch to parent window is successful!!");
        //Click on Create Contact button
        createContPage.getCreateContactSubmitButton().click();
        Thread.sleep(1000);
        //Verify contact pop up and contact creation
        NinzaAutomation.verifyPopUpAndCreation(driver,"contact");
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }
    public static void ninzaTC10CreateProduct() throws Throwable {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Products button
        hp.getProductsLink().click();
        //Click on Add Product button
        pp.getCreateProductButton().click();
        //Enter Product Name
        createProdPage.getProductName().sendKeys(JavaUtility.generateProductName());
        Thread.sleep(1000);
        //Select product category
        WebElement selectProduct = createProdPage.getSelectProductCategory();
        WebDriverUtilities.select(selectProduct,1);
        Thread.sleep(1000);
        //Fill Qunatity
        createProdPage.getFillQty().sendKeys(ExcelUtility.toReadDataFromExcel("Products",1,2));
        Thread.sleep(1000);
        //Fill Price per unit
        WebElement ppu = createProdPage.getFillPricePerUnit();
        ppu.clear();
        ppu.sendKeys(ExcelUtility.toReadDataFromExcel("Products",1,3));
        Thread.sleep(1000);
        //Select Vendor
        WebElement selectVendor = createProdPage.getSelectVendor();
        WebDriverUtilities.select(selectVendor,3);
        //Click on Add product button
        createProdPage.getCreateProductSubmitButton().click();
       //Verify product pop up and product creation
        NinzaAutomation.verifyPopUpAndCreation(driver,"product");
        //Thread.sleep(5000);
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void main(String[] args) throws Throwable {
        NinzaAutomation na= new NinzaAutomation();
        //NinzaAutomation.ninzaTC01CreateCampaign();
         //NinzaAutomation.ninzaTC02SearchByCampaignID();
        //NinzaAutomation.ninzaTC03SearchByCampaignName();
        NinzaAutomation.ninzaTC04createCampaignWithMandatoryDetails();
        //NinzaAutomation.ninzaTC05createCampaignWithClosingDate();
        //NinzaAutomation.ninzaTC06createCampaignWithTargetAudience();
        //NinzaAutomation.ninzaTC07SearchByContactID();
        //NinzaAutomation.ninzaTC08SearchByContactName();
        //NinzaAutomation.ninzaTC09CreateContactUsingCampaignID();
        NinzaAutomation.ninzaTC10CreateProduct();
        //NinzaAutomation.ninzaTC09CreateLeadUsingCampaignID(driver);
        //NinzaAutomation.ninzaTC07SearchByLeadID(driver);
        //NinzaAutomation.ninzaTC08SearchByLeadName(driver);

    }
}
