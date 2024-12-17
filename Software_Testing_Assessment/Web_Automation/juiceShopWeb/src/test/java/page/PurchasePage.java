package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchasePage {
    public PurchasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[contains(@aria-label, 'Add')]")
    public WebElement addNewAddressButton;

    @FindBy(xpath = "//*[@id='mat-input-9']")
    public WebElement countryField;

    @FindBy(xpath = "//*[@id='submitButton']")
    public WebElement submitButton;

    @FindBy(xpath = "//mat-cell[contains(@class, 'cdk-column-Selection')]")
    public WebElement selectAddress;

    @FindBy(xpath = "//button[@class='mat-focus-indicator btn btn-next mat-button mat-raised-button mat-button-base mat-primary ng-star-inserted']")
    public WebElement deliveryContinueButton;

    @FindBy(xpath = "//button[@class='mat-focus-indicator btn nextButton mat-button mat-raised-button mat-button-base mat-primary']")
    public WebElement continueButton;

    @FindBy(xpath = "//mat-cell[.//*[@id='mat-radio-44']]")
    public WebElement deliveryOption;

    @FindBy(xpath = "//div[@fxflex='38%']")
    public WebElement walletAmount;

    @FindBy(xpath = "//*[@id='mat-expansion-panel-header-0']")
    public WebElement addNewCard;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement cardNameInput;

    @FindBy(xpath = "//mat-cell[@role='cell']")
    public WebElement selectSavedCard;

    @FindBy(xpath = "//button[contains(@class, 'nextButton')]")
    public WebElement continueButtonFinishPurchase;
}
