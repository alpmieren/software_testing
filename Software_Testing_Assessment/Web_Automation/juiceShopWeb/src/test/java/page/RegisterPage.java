package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {
    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='emailControl']")
    public WebElement emailField;

    @FindBy(xpath = "//*[@id='passwordControl']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id='repeatPasswordControl']")
    public WebElement repeatPasswordField;

    @FindBy(xpath = "//div[contains(@class, 'mat-select-arrow-wrapper')]")
    public WebElement securityQuestionField;

    @FindBy(xpath = "//*[@id='securityAnswerControl']")
    public WebElement answerField;

    @FindBy(xpath = "//*[@id='mat-error-2']")
    public WebElement emailTriggerMessage;

    @FindBy(xpath = "//*[@id='mat-error-3']")
    public WebElement passwordTriggerMessage;

    @FindBy(xpath = "//*[@id='mat-error-4']")
    public WebElement repeatPasswordTriggerMessage;

    @FindBy(xpath = "//*[@id='mat-error-5']")
    public WebElement securityQuestionTriggerMessage;

    @FindBy(xpath = "//*[@id='mat-error-6']")
    public WebElement answerTriggerMessage;

    @FindBy(css = "#mat-option-5 span")
    public WebElement selectedSecurityQuestion;

    @FindBy(xpath = "//span[@class='mat-slide-toggle-content']")
    public WebElement showPasswordAdviceButton;

    @FindBy(xpath = "//*[@id='registerButton']")
    public WebElement registerButton;

    @FindBy(xpath = "//*[text()='Registration completed successfully. You can now log in.']")
    public WebElement successfulRegisterMessage;

}
