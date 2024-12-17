package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import page.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Task1 {
    private WebDriver driver;
    HomePage homePage = new HomePage();

    @Given("Go to juice shop page")
    public void go_to_juice_shop_page(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.dismissButton.click();
        homePage.meWantItButton.click();
    }

    @When("Scroll down to end of the page")
    public void scrollDownToEndOfThePage() {
        homePage.pageClick.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
    }

    @When("Change items per page to max number")
    public void changeItemsPerPageToMaxNumber() {
        homePage.itemsPerPage.click();
        homePage.lastOptionOnPerPage.click();
    }

    @Then("We should see all items on home page")
    public void weShouldSeeAllItemsOnHomePage() {
        Assert.assertEquals("1 – 37 of 37",homePage.allItemCount.getText());
    }
}
