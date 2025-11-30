package ObjectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver = null;
    public ProductsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getCreateProductButton() {
        return createProductButton;
    }

    @FindBy(xpath = "//button[@class='btn btn-info']")
    WebElement createProductButton;
}
