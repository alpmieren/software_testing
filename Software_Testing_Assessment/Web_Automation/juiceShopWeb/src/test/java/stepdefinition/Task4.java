package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import page.BasketDetailPage;
import page.HomePage;
import page.LoginPage;
import page.PurchasePage;
import utilities.ConfigReader;
import utilities.Driver;


public class Task4 {
    private WebDriver driver;
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BasketDetailPage basketDetailPage = new BasketDetailPage();
    PurchasePage purchasePage = new PurchasePage();

    @And("Add five different products")
    public void add_five_different_products() {
        homePage.addToBasketAppleJuice.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER,Keys.TAB,Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER).perform();
    }
    @Then("You should see successful popup message")
    public void you_should_see_successful_popup_message(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.successPopupMessageAddToBasket).perform();
        Assert.assertTrue(homePage.successPopupMessageAddToBasket.isDisplayed());
    }

    @Then("You should see cart number changed to five")
    public void youShouldSeeCartNumberChangedToFive() {
        Assert.assertEquals("5",homePage.cartNumber.getText());
    }

    @When("Go to your basket")
    public void goToYourBasket() {
        homePage.basketButton.click();
    }

    @When("Increase number of any product then delete it from basket")
    public void increaseNumberOfAnyProductThenDeleteItFromBasket() throws InterruptedException {
        String currentPrice = basketDetailPage.totalPrice.getText();
        basketDetailPage.increaseProductButton.click();
        Thread.sleep(1000);
        basketDetailPage.deleteProductButton.click();
        Assert.assertNotEquals(currentPrice,basketDetailPage.totalPrice.getText());
    }

    @When("Click Checkout button")
    public void clickCheckoutButton() {
        basketDetailPage.checkoutButton.click();
    }

    @When("Add to address information")
    public void addToAddressInformation() {
        purchasePage.addNewAddressButton.click();
        purchasePage.countryField.sendKeys("Türkiye");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB,"alperen",Keys.TAB,"5070803511",Keys.TAB,"35000",Keys.TAB,"Karşıyaka",Keys.TAB,"İzmir",Keys.TAB,"İzmir").perform();
        purchasePage.submitButton.click();
        purchasePage.selectAddress.click();
    }

    @And("Click continue button")
    public void clickContinueButton() {
        purchasePage.deliveryContinueButton.click();
    }

    @When("Select delivery method and click continue button")
    public void selectDeliveryMethodAndClickContinueButton() {
        purchasePage.deliveryOption.click();
        purchasePage.continueButton.click();
    }

    @When("Add new card and select it")
    public void addNewCardAndSelectIt() {
        purchasePage.addNewCard.click();
        purchasePage.cardNameInput.sendKeys("Alperen");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB,"4111 1111 1111 1111",Keys.TAB,"1",Keys.TAB,"2").perform();
        purchasePage.submitButton.click();
        purchasePage.selectSavedCard.click();
    }

    @And("Finish purchase process")
    public void finishPurchaseProcess() {
        purchasePage.continueButtonFinishPurchase.click();
    }
}
