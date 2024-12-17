package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.HomePage;


public class Task2 {

    private WebDriver driver;
    HomePage homePage = new HomePage();

    @When("Click first product")
    public void click_first_product() {
        homePage.appleJuiceProduct.click();
    }
    @Then("User should see product popup and product image")
    public void user_should_see_product_popup_and_product_image() {
        Assert.assertTrue(homePage.popupAppear.isDisplayed());
        Assert.assertTrue(homePage.appleJuiceImage.isDisplayed());
    }

    @When("Expand the product's review if it exists")
    public void expandTheProductSReviewIfItExists(){
        if (!(homePage.numberOfReview.getText().contains("0"))) {
            homePage.numberOfReview.click();
        }
    }

    @When("Wait couple of second")
    public void waitCoupleOfSecond() throws InterruptedException {
        Thread.sleep(3000);
    }

    @And("Close product form")
    public void closeProductForm() {
        homePage.closeButton.click();
    }
}
