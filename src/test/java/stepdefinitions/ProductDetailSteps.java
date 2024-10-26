package stepdefinitions;

import common.JSONReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.Common;
import utils.Hook;

public class ProductDetailSteps {
    private AppiumDriver driver;
    private JSONReader homeScreenJsonReader;
    private JSONReader xpathsJsonReader;
    private JSONReader productDetailScreenJsonReader;
    private Common common;

    public ProductDetailSteps() {
        this.driver = Hook.getDriver();
        this.homeScreenJsonReader = new JSONReader("src/test/resources/pages/HomeScreen.json");
        this.xpathsJsonReader = new JSONReader("src/test/resources/pages/Xpaths.json");
        this.productDetailScreenJsonReader = new JSONReader("src/test/resources/pages/ProductDetails.json");
        this.common = new Common();
    }


    @When("User go to the dashboard")
    public void userGoToTheDashboard() {
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("nextButton")));
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("nextButton")));
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("getStarted")));
        common.waitForElementVisibleAndClick(By.xpath(homeScreenJsonReader.getXPathWithText("locationDelivery", "All")));
    }

    @And("User go into Coffee screen")
    public void userGoIntoCoffeeScreen() {
        common.scrollToFindElement(By.xpath(xpathsJsonReader.getXPath("viewAllCoffeeScreen")));
        common.waitForElementVisibleAndClick(By.xpath(xpathsJsonReader.getXPath("viewAllCoffeeScreen")));
    }

    @And("User select product to view detail {}")
    public void userSelectProductToViewDetail(String productName) {
        common.scrollToFindElement(By.xpath(xpathsJsonReader.getXPathWithText("textView",productName)));
        common.waitForElementVisibleAndClick(By.xpath(xpathsJsonReader.getXPathWithText("textView",productName)));
    }

    @Then("Verify product information {} and {}")
    public void verifyProductInformationAnd(String productName, String productPrice) {
        common.verifyElementVisible(By.xpath(productDetailScreenJsonReader.getXPathWithText("xpathProductWithText", productName)));
        common.verifyElementVisible(By.xpath(productDetailScreenJsonReader.getXPathWithText("xpathProductWithText", productPrice)));
    }

    @When("User click Add to cart button")
    public void userClickAddToCartButton() {
        common.waitForElementVisibleAndClick(By.xpath(productDetailScreenJsonReader.getXPathWithText("buttonProductDetailWithText","Add to Cart")));
    }

    @And("User click Go to cart button")
    public void userClickGoToCartButton() {
        common.waitForElementVisibleAndClick(By.id(productDetailScreenJsonReader.getXPath("buttonGoToCart")));
    }

    @Then("Verify {} in cart")
    public void verifyInCart(String productName) {
        common.waitForElementVisibleAndClick(By.xpath(homeScreenJsonReader.getXPathWithText("locationDelivery", "370405")));
        common.verifyElementVisible(By.xpath(productDetailScreenJsonReader.getXPathWithText("xpathProductInCartScreenWithText", productName)));
    }
}
