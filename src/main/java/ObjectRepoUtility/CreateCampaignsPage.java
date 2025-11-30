package ObjectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {
    WebDriver driver=null;
    public CreateCampaignsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@id='navbarNav']/ul/li[1]/a")
    WebElement campaignLink;

    @FindBy(name="campaignName")
    WebElement campaignName;

    @FindBy(name="targetSize")
    WebElement targetSize;
    @FindBy(name="expectedCloseDate")
    WebElement expectedCloseDate;

    @FindBy(xpath="//div[@class='Toastify']/div/div/div[1]")
    WebElement popUp;
    @FindBy(xpath="//button[@type='submit']")
    WebElement createCampaignSubmitButton;
    public WebElement getCampaignLink() {
        return campaignLink;
    }

    public WebElement getCampaignName() {
        return campaignName;
    }

    public WebElement getTargetSize() {
        return targetSize;
    }

    public WebElement getExpectedCloseDate() {
        return expectedCloseDate;
    }

    public WebElement getPopUp() {
        return popUp;
    }
    public WebElement getCreateCampaignSubmitButton() {
        return createCampaignSubmitButton;
    }


}
