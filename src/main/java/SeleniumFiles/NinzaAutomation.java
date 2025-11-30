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
        WebDriverUtilities.waitForPageToLoad(driver);
        driver.get(ReadFromJson.readFromJson("url"));
        Thread.sleep(1000);
        LoginPage lp = new LoginPage(driver);
        lp.loginToNinza(ReadFromJson.readFromJson("username"),ReadFromJson.readFromJson("password"));
//        lp.getUname().sendKeys(ReadFromJson.readFromJson("username"));
//        lp.getPswd().sendKeys(ReadFromJson.readFromJson("password"));
//        lp.getSubmit().click();
        System.out.println("Login is Successfull!!");
        //return driver;
    }
    public static void logoutNinZa(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebDriverUtilities.mouseHoverOnWebelemment(driver,hp.getLogOutIcon());
        //WebDriverUtilities.hp.getLogOutIcon();
        //WebElement logOut = driver.findElement(By.xpath("//div[@class='user-icon']"));
        //Actions act = new Actions(driver);
        //act.moveToElement(logOut).perform();
        Thread.sleep(1000);
        hp.getLogOutLink().click();
        //driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
        System.out.println("Log Out is Successfull!!");
    }
    public static String captureCampaignId(WebDriver driver)
    {
        List<WebElement> listCamapigns = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
        String campaignId = listCamapigns.get(0).getText();
        System.out.println("Campaign id is captured successfully!");
        return campaignId;
    }
    public static String captureContactId(WebDriver driver)
    {
        List<WebElement> listContacts = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
        String contactId = listContacts.get(0).getText();
        System.out.println("Contact id is captured successfully!");
        return contactId;
    }

    public static void verifyCampaign(WebDriver driver) throws InterruptedException, IOException {
        Thread.sleep(1000);
        WebElement popUp =createCampPage.getPopUp();
        //WebElement popUp = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div[1]"));
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
                //Thread.sleep(1000);
                String campaignId = NinzaAutomation.captureCampaignId(driver);

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
       // Thread.sleep(2000);
//        //Logout of App
//        NinzaAutomation.logoutNinZa(driver);
//        driver.quit();
    }

    public static void ninzaTC01CreateCampaign() throws Throwable {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Campaign link
        createCampPage.getCampaignLink().click();
        //driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[1]/a")).click();
        //Click on create Campaign button
        hp.getCreateCampaignButton().click();
        //driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        //Fill Campaign Name
        String campName = JavaUtility.generateCampaignName();
        createCampPage.getCampaignName().sendKeys(campName);
        //System.out.println("cName is: "+campName);
        //Thread.sleep(1000);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        WebElement campWebEle = driver.findElement(By.xpath("//input[@name='campaignName']"));
//        jse.executeScript("arguments[0].value='"+campName+"';", campWebEle);
        //driver.findElement(By.xpath("//input[@name='campaignName']")).sendKeys(campName);
        //Fill Target Size
        //driver.findElement(By.xpath("//input[@name='targetSize']")).clear();
        createCampPage.getTargetSize().sendKeys(ExcelUtility.toReadDataFromExcel("Campaigns",1,1));
        //driver.findElement(By.xpath("//input[@name='targetSize']")).sendKeys(ExcelUtility.toReadDataFromExcel("Campaigns",1,1));
        //Enter expected Closed Date
        createCampPage.getExpectedCloseDate().sendKeys(JavaUtility.getCurrentDate());
        //driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(JavaUtility.getCurrentDate());
        //Click Create Campaign button
        createCampPage.getCreateCampaignSubmitButton().click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Create Campaign pop up
        Thread.sleep(2000);
//        WebElement popUp =createCampPage.getPopUp();
//        //WebElement popUp = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div[1]"));
//        //Get text of popup
//        String popUpText = popUp.getText();
//        if(popUp.isDisplayed())
//        {
//            if(popUpText.contains("Successfully Added")) {
//
//                String campaignName=JavaUtility.extractTextFromPopUp(popUp,"Campaigns");
//                //Store Campaign Name in Property File
//                JavaUtility.writeToPropertyFile("CampaignName",campaignName);
//                System.out.println("Campaign name is: "+campaignName);
//                System.out.println("Create Campaign is Successful!!");
//                //Capture Campaign ID
//                Thread.sleep(10000);
//                String campaignId = NinzaAutomation.captureCampaignId(driver);
//
//                System.out.println("CampaignId: "+campaignId);
//                //Store Campaign ID in Property File
//                JavaUtility.writeToPropertyFile("CampaignId",campaignId);
//
//            }
//            else{
//                System.out.println("Create Campaign is not Successful!!");
//            }
//        }
//        else {
//            System.out.println("Create Campaign pop up is not displayed");
//        }
        NinzaAutomation.verifyCampaign(driver);
        //Thread.sleep(2000);
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
        //driver.findElement(By.xpath("//select[@class='form-control']/option[1]")).click();
        //Input Campaign ID
        Thread.sleep(1000);
        //Get Campaign ID from property File
        String campaignId = JavaUtility.getFromPropertyFile("campaignId");
        //Serach for Camapign id inside search box
        selCampPage.getCampaignSearchBox().sendKeys(campaignId);
        //driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(CampaignId);
        //Extract Campaign ID from Table display
        WebElement camID =  selCampPage.getCampaignIdTableDisplay();
        //WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[1]"));
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
        //driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(CampaignName);
        //Extract Campaign Name from Table display
        WebElement camID =selCampPage.getCampaignNameTableDisplay();
        //WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[2]"));
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
        NinzaAutomation.verifyCampaign(driver);
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
        NinzaAutomation.verifyCampaign(driver);
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
        NinzaAutomation.verifyCampaign(driver);
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC04SearchByContactID() throws InterruptedException, IOException, ParseException {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Contact header button
        hp.getContactsLink().click();
        //driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[2]/a")).click();
        Thread.sleep(1000);
        //Select Search by Contact ID
        contPage.getSearchContactByID().click();
        //driver.findElement(By.xpath("//select[@class='form-control']/option[1]")).click();
        //Input Contact ID
        Thread.sleep(1000);
        //Get Contact ID from property File
        String contactId = JavaUtility.getFromPropertyFile("contactId");
        //Serach for Contact id inside search box
        contPage.getContactSearchBox().sendKeys(contactId);
        //driver.findElement(By.xpath("//input[@placeholder='Search by Contact Id']")).sendKeys(contactId);
        //Extract Contact ID from Table display
        WebElement camID = contPage.getContactIdTableDisplay();
        //WebElement camID = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']//tbody/tr/td[1]"));
        if(camID.getText().equalsIgnoreCase(contactId))
        {
            System.out.println("Search Contact by ID is Successful!!");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void ninzaTC05SearchByContactName() throws InterruptedException, IOException, ParseException {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Contact header button
        hp.getContactsLink().click();
        //driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[2]/a")).click();
        Thread.sleep(1000);
        //Select Search by Contact Name
        contPage.getSearchContactByName().click();
        //driver.findElement(By.xpath("//select[@class='form-control']/option[1]")).click();
        //Input Contact Name
        Thread.sleep(1000);
        //Get Contact ID from property File
        String contactName = JavaUtility.getFromPropertyFile("contactName");
        //Serach for Contact id inside search box
        contPage.getContactSearchBox().sendKeys(contactName);
        //driver.findElement(By.xpath("//input[@placeholder='Search by Contact Id']")).sendKeys(contactId);
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


    public static void ninzaTC10CreateContactUsingCampaignID() throws InterruptedException, IOException, ParseException {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Contact link
        hp.getContactsLink().click();
        //createContPage.getContactLink().click();
        //driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[2]/a")).click();
        Thread.sleep(1000);
        //Click on create Contact button
        contPage.getcreateContactButton().click();
        //driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(1000);
        //Store parent window handle
        String parentWh = driver.getWindowHandle();
        //Fill Organization
        createContPage.getOrganizationName().sendKeys(JavaUtility.generateOrganizationName());
        //driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(JavaUtility.generateOrganizationName());
        Thread.sleep(1000);
        //Fill Title
        createContPage.getTitle().sendKeys(JavaUtility.generateRandomStrings());
        //driver.findElement(By.xpath("//input[@name='title']")).sendKeys(JavaUtility.generateRandomStrings());
        Thread.sleep(1000);
        //Fill Contact Name
        createContPage.getContactName().sendKeys(JavaUtility.generateRandomStrings());
        //driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(JavaUtility.generateRandomStrings());
        Thread.sleep(1000);
        //Fill Mobile
        createContPage.getMobile().sendKeys(JavaUtility.generateRandomMobileNo());
        //driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(JavaUtility.generateRandomMobileNo());
        Thread.sleep(1000);
        //Campaign button
        createContPage.getSelectcampaignSubmitButton().click();
        //driver.findElement(By.xpath("//div[@class='form-container']/div[2]/div[4]//button")).click();
        Thread.sleep(1000);
        //Passing window handle to dialogue box
        WebDriverUtilities.switchToWindowByTitle(driver,"Select Campaign");
        Thread.sleep(1000);
        //select campaign id from drop down
        createContPage.getSelectCampaignIdDropDown().click();
        //driver.findElement(By.xpath("//select[@id='search-criteria']/option[1]"));
        //Get Campaign Id from propert file
        String CampaignId = JavaUtility.getFromPropertyFile("CampaignId");
        //Serach for Camapign id inside search box
        createContPage.getSearchCampaignIdSearchBox().sendKeys(CampaignId);
        //driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(CampaignId);
        Thread.sleep(1000);
        //Click on Select Campaign button
        createContPage.getSelectCampaignButtontable().click();
        //driver.findElement(By.xpath("//button[@class='select-btn']")).click();
        Thread.sleep(1000);
        //Switch back to parent window handle
        System.out.println("Switching to parent window");
        WebDriverUtilities.switchToParentWindow(driver,parentWh);
        //driver.switchTo().window(parentWh);
        Thread.sleep(2000);
        System.out.println("Switch to parent window is successful!!");
        //Click on Create Contact button
        createContPage.getCreateContactSubmitButton().click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        //Capture successful create contact pop up
        WebElement popUp = createContPage.getPopUp();
        //WebElement popUp = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div"));
//        if(popUp.isDisplayed())
//        {
//            System.out.println("Create Contact is Successful!!");
//            JavaUtility.writeToPropertyFile("");
//        }
        //Get text of popup
        String popUpText = popUp.getText();
        if(popUp.isDisplayed())
        {
            if(popUpText.contains("Successfully Added")) {

                String contactName=JavaUtility.extractTextFromPopUp(popUp,"Contacts");
                //Store Contact Name in Property File
                JavaUtility.writeToPropertyFile("contactName",contactName);
                System.out.println("Contact name is: "+contactName);
                System.out.println("Create Contact is Successful!!");
                //Capture Contact ID
                Thread.sleep(10000);
                String contactId = NinzaAutomation.captureContactId(driver);
                System.out.println("contactId: "+contactId);
                //Store Contact ID in Property File
                JavaUtility.writeToPropertyFile("contactId",contactId);

            }
            else{
                System.out.println("Create Contact is not Successful!!");
            }
        }
        else {
            System.out.println("Create Contact pop up is not displayed");
        }
        Thread.sleep(1000);
        //Close popUp
        createCampPage.getClosePopUp().click();
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }
    public static void ninzaTC11CreateProduct() throws Throwable {
        //launch Browser
        WebDriver driver= NinzaAutomation.launchBrowser();
        //Login to App
        NinzaAutomation.loginNinza(driver);
        Thread.sleep(2000);
        //Click on Products button
        hp.getProductsLink().click();
        //driver.findElement(By.xpath("//div[@id='navbarNav']/ul/li[5]/a")).click();
        //Click on Add Product button
        pp.getCreateProductButton().click();
        //driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        //Enter Product Name
        createProdPage.getProductName().sendKeys(JavaUtility.generateProductName());
        //driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(JavaUtility.generateProductName());
        Thread.sleep(1000);
        //Select product category
        WebElement selectProduct = createProdPage.getSelectProductCategory();
        //WebElement selectProduct = driver.findElement(By.xpath("//select[@name='productCategory']"));
        WebDriverUtilities.select(selectProduct,1);
        //driver.findElement(By.xpath("//select[@name='productCategory']")).sendKeys(ExcelUtility.toReadDataFromExcel("Products",1,2));
        Thread.sleep(1000);
        //Fill Qunatity
        createProdPage.getFillQty().sendKeys(ExcelUtility.toReadDataFromExcel("Products",1,2));
        //driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(ExcelUtility.toReadDataFromExcel("Products",1,2));
        Thread.sleep(1000);
        //Fill Price per unit
        WebElement ppu = createProdPage.getFillPricePerUnit();
        //WebElement ppu = driver.findElement(By.xpath("//input[@name='price']"));
        ppu.clear();
        ppu.sendKeys(ExcelUtility.toReadDataFromExcel("Products",1,3));
        //driver.findElement(By.xpath("//input[@name='price']")).sendKeys(ExcelUtility.toReadDataFromExcel("Products",1,4));
        Thread.sleep(1000);
        //Select Vendor
        WebElement selectVendor = createProdPage.getSelectVendor();
        //WebElement selectVendor = driver.findElement(By.xpath("//select[@name='vendorId']"));
        WebDriverUtilities.select(selectVendor,3);
        //driver.findElement(By.xpath("//select[@name='vendorId']")).sendKeys(ExcelUtility.toReadDataFromExcel("Products",1,5));
        //Click on Add product button
        createProdPage.getCreateProductSubmitButton().click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Capture successful create product pop up
        Thread.sleep(1000);
        WebElement popUp = createProdPage.getPopUp();
        //WebElement popUp = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div"));
        //Get text of popup
        String popUpText = popUp.getText();
        if(popUp.isDisplayed())
        {
            if(popUpText.contains("Successfully Added")) {

                String productName=JavaUtility.extractTextFromPopUp(popUp,"Products");
                //Store Product Name in Property File
                JavaUtility.writeToPropertyFile("productName",productName);
                System.out.println("Product name is: "+productName);
                System.out.println("Create Product is Successful!!");
                //Capture Product ID
//                Thread.sleep(10000);
//                String contactId = NinzaAutomation.captureContactId(driver);
//                System.out.println("contactId: "+contactId);
//                //Store Contact ID in Property File
//                JavaUtility.writeToPropertyFile("contactId",contactId);

            }
            else{
                System.out.println("Create Product is not Successful!!");
            }
        }
        else {
            System.out.println("Create Product pop up is not displayed");
        }
        Thread.sleep(5000);
        //Logout of App
        NinzaAutomation.logoutNinZa(driver);
        driver.quit();
    }

    public static void main(String[] args) throws Throwable {
        NinzaAutomation na= new NinzaAutomation();
        //NinzaAutomation.ninzaTC01CreateCampaign();
         //NinzaAutomation.ninzaTC02SearchByCampaignID();
        //NinzaAutomation.ninzaTC03SearchByCampaignName();
        //NinzaAutomation.ninzaTC04createCampaignWithMandatoryDetails();
        NinzaAutomation.ninzaTC06createCampaignWithTargetAudience();
        //NinzaAutomation.ninzaTC04SearchByContactID();
        //NinzaAutomation.ninzaTC05SearchByContactName();
        //NinzaAutomation.ninzaTC06CreateLeadUsingCampaignID(driver);
        //NinzaAutomation.ninzaTC07SearchByLeadID(driver);
        //NinzaAutomation.ninzaTC08SearchByLeadName(driver);
        //NinzaAutomation.ninzaTC10CreateContactUsingCampaignID();
        //NinzaAutomation.ninzaTC11CreateProduct();

    }
}
