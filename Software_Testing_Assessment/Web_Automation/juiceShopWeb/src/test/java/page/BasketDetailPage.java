package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasketDetailPage {
    public BasketDetailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='checkoutButton']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@id='price']")
    public WebElement totalPrice;

    @FindBy(xpath = "(//button[@class='mat-focus-indicator mat-icon-button mat-button-base ng-star-inserted'])[2]")
    public WebElement increaseProductButton;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-icon-button mat-button-base']")
    public WebElement deleteProductButton;
}
