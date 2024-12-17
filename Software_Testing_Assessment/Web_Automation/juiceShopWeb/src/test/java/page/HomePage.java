package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "button[aria-label^='Close']")
    public WebElement dismissButton;

    @FindBy(linkText = "Me want it!")
    public WebElement meWantItButton;

    @FindBy(xpath = "//div[@class='mat-select-trigger ng-tns-c30-10']")
    public WebElement itemsPerPage;

    @FindBy(xpath = "//div[@class='heading mat-elevation-z6']")
    public WebElement pageClick;

    @FindBy(xpath = "(//div[@role='listbox']//mat-option[@role='option'])[last()]")
    public WebElement lastOptionOnPerPage;

    @FindBy(xpath = "//div[@class='mat-paginator-range-label']")
    public WebElement allItemCount;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane']")
    public WebElement popupAppear;

    @FindBy(xpath = "//*[text()=' Apple Juice (1000ml) ']")
    public WebElement appleJuiceProduct;

    @FindBy(xpath = "//img[@class='img-thumbnail']")
    public WebElement appleJuiceImage;

    @FindBy(xpath = "//mat-panel-title")
    public WebElement numberOfReview;

    @FindBy(xpath = "//button[@aria-label='Close Dialog']")
    public WebElement closeButton;

    @FindBy(xpath = "//*[@id='navbarAccount']")
    public WebElement accountButton;

    @FindBy(xpath = "//*[@id='navbarLoginButton']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@aria-label='Add to Basket']")
    public WebElement addToBasketAppleJuice;

    @FindBy(xpath = "//*[text()='Placed DSOMM & Juice Shop User Day Ticket into basket.']")
    public WebElement successPopupMessageAddToBasket;

    @FindBy(css = "span[class*='fa-layers-top-right']")
    public WebElement cartNumber;

    @FindBy(xpath = "//button[@routerlink='/basket']")
    public WebElement basketButton;
}
