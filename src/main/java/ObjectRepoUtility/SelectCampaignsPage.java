package ObjectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCampaignsPage {
    WebDriver driver=null;
    public SelectCampaignsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//select[@class='form-control']/option[1]")
    WebElement searchByCampaignId;
    @FindBy(xpath="//select[@class='form-control']/option[2]")
    WebElement searchByCampaignName;

    @FindBy(xpath="//input[@class='form-control']")
    WebElement campaignSearchBox;
    @FindBy(xpath="//table[@class='table table-striped table-hover']//tbody/tr/td[1]")
    WebElement campaignIdTableDisplay;
    @FindBy(xpath="//table[@class='table table-striped table-hover']//tbody/tr/td[2]")
    WebElement campaignNameTableDisplay;
    public WebElement getSearchByCampaignId() {
        return searchByCampaignId;
    }

    public WebElement getSearchByCampaignName() {
        return searchByCampaignName;
    }

    public WebElement getCampaignSearchBox() {
        return campaignSearchBox;
    }

    public WebElement getCampaignIdTableDisplay() {
        return campaignIdTableDisplay;
    }

    public WebElement getCampaignNameTableDisplay() {
        return campaignNameTableDisplay;
    }




}
