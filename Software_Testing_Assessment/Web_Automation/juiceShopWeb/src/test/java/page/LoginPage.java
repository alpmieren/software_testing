package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='#/register']")
    public WebElement notYetCustomerButton;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailField;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id='loginButton']")
    public WebElement loginButton;
}
