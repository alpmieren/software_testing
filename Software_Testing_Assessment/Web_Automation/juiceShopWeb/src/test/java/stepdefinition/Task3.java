package stepdefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import page.HomePage;
import page.LoginPage;
import page.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Task3 {
    private WebDriver driver;
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    String email = faker.name().username();

    @And("Click account button")
    public void click_account_button() {
        homePage.accountButton.click();
    }

    @And("Click Login button")
    public void click_login_button() {
        homePage.loginButton.click();
    }

    @And("Click not yet a customer? button")
    public void click_not_yet_a_customer_button() {
        loginPage.notYetCustomerButton.click();
    }

    @Given("Click on all fields without adding any values")
    public void click_on_all_fields_without_adding_any_values() {
        registerPage.emailField.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB). sendKeys(Keys.TAB).perform();   }

    @Then("You should see a validation messages for all fields")
    public void you_should_see_a_validation_messages_for_all_fields() {
        Assert.assertTrue(registerPage.emailTriggerMessage.isDisplayed());
        Assert.assertTrue(registerPage.passwordTriggerMessage.isDisplayed());
        Assert.assertTrue(registerPage.repeatPasswordTriggerMessage.isDisplayed());
        Assert.assertTrue(registerPage.securityQuestionTriggerMessage.isDisplayed());
        Assert.assertTrue(registerPage.answerTriggerMessage.isDisplayed());

    }

    @Given("Fill registration form fields with required data")
    public void fillRegistrationFormFieldsWithRequiredData() {
        registerPage.emailField.sendKeys(email + "@gmail.com");
        registerPage.passwordField.sendKeys(ConfigReader.getProperty("registerPassword"));
        registerPage.repeatPasswordField.sendKeys(ConfigReader.getProperty("registerPassword"));
        registerPage.securityQuestionField.click();
        registerPage.selectedSecurityQuestion.click();
        registerPage.answerField.sendKeys(ConfigReader.getProperty("securityAnswer"));
    }

    @When("Click show password advice")
    public void clickShowPasswordAdvice() {
        registerPage.showPasswordAdviceButton.click();
    }

    @When("Click Register button")
    public void clickRegisterButton() {
        registerPage.registerButton.click();
    }

    @Then("You should see successful message of registration")
    public void youShouldSeeSuccessfulMessageOfRegistration() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(registerPage.successfulRegisterMessage).perform();
        Assert.assertTrue(registerPage.successfulRegisterMessage.isDisplayed());
    }

    @When("Login to web application with generated information")
    public void loginToWebApplicationWithGeneratedInformation() {
        loginPage.emailField.sendKeys(email + "@gmail.com");
        loginPage.passwordField.sendKeys(ConfigReader.getProperty("registerPassword"));
        loginPage.loginButton.click();
    }
}