package ObjectRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage {
    WebDriver driver=null;
    public CreateProductsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@id='navbarNav']/ul/li[5]/a")
    WebElement productsLink;


    @FindBy(name="productName")
    WebElement productName;

    @FindBy(xpath="//select[@name='productCategory']")
    WebElement selectProductCategory;
    @FindBy(name="quantity")
    WebElement fillQty;
    @FindBy(name="price")
    WebElement fillPricePerUnit;
    @FindBy(name="vendorId")
    WebElement selectVendor;

    @FindBy(xpath="//div[@class='Toastify']/div/div/div")
    WebElement popUp;
    @FindBy(xpath="//button[@type='submit']")
    WebElement createProductSubmitButton;
    public WebElement getProductsLink() {
        return productsLink;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getSelectProductCategory() {
        return selectProductCategory;
    }

    public WebElement getFillQty() {
        return fillQty;
    }

    public WebElement getFillPricePerUnit() {
        return fillPricePerUnit;
    }

    public WebElement getSelectVendor() {
        return selectVendor;
    }

    public WebElement getPopUp() {
        return popUp;
    }

    public WebElement getCreateProductSubmitButton() {
        return createProductSubmitButton;
    }

}
