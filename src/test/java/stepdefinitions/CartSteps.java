package stepdefinitions;

import common.JSONReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import utils.Common;
import utils.Hook;

public class CartSteps {

    private AppiumDriver driver;
    private JSONReader homeScreenJsonReader;
    private JSONReader cartJsonReader;
    private JSONReader xpathsJsonReader;
    private JSONReader addressJsonReader;
    private Common common;

    public CartSteps() {
        this.driver = Hook.getDriver();
        this.homeScreenJsonReader = new JSONReader("src/test/resources/pages/HomeScreen.json");
        this.cartJsonReader = new JSONReader("src/test/resources/pages/Cart.json");
        this.xpathsJsonReader = new JSONReader("src/test/resources/pages/Xpaths.json");
        this.addressJsonReader = new JSONReader("src/test/resources/pages/Address.json");
        this.common = new Common();
    }

    @And("User select FastFood option")
    public void userSelectFastFoodOption() {
        common.waitForElementVisibleAndClick(By.xpath(xpathsJsonReader.getXPathWithText("textView", " Fast Food")));
    }

    @And("User Add product {} to cart")
    public void userAddProductToCart(String productName) {
        common.scrollToFindElement(By.xpath(xpathsJsonReader.getXPathWithText("textView", productName)));
    }

    @And("Add to cart with {} of products {}")
    public void addToCartWithOfProducts(int quantity, String productName) {
        common.scrollToFindElement(By.xpath(cartJsonReader.getXPathWithText("buttonAddToCartByNameProduct", productName)));
        common.waitForElementVisibleAndClick(By.xpath(cartJsonReader.getXPathWithText("buttonAddToCartByNameProduct", productName)));
        for(int i = 1; i < quantity; i++) {
            common.waitForElementVisibleAndClick(By.xpath(cartJsonReader.getXPathWithText("buttonAddQuanityByNameProduct", productName)));
        }
    }

    @And("Click into Cart icon on top screen")
    public void clickIntoCartIconOnTopScreen() {
        common.waitForElementVisibleAndClick(By.id(cartJsonReader.getXPath("cartIcon")));
    }

    @And("Select location {}")
    public void selectLocation(String location) {
        common.waitForElementVisibleAndClick(By.xpath(homeScreenJsonReader.getXPathWithText("locationDelivery", location)));
    }

    @Then("Verify detail products with values {} and {} and {} and {} and {}")
    public void verifyDetailProductsWithValuesAndAndAndAnd(String productName, String quantity, String price, String measurement, String totalPrice) {
        common.assertGetValeWithExpected((By.xpath(cartJsonReader.getXPathWithText("priceProdByNameProd", productName))), price);
        common.assertGetValeWithExpected((By.xpath(cartJsonReader.getXPathWithText("totalQuanityByNameProd", productName))), quantity);
        common.assertGetValeWithExpected((By.xpath(cartJsonReader.getXPathWithText("measurementByNameProd", productName))), measurement);
        common.assertGetValeWithExpected((By.xpath(cartJsonReader.getXPathWithText("totalPriceByNameProd", productName))), totalPrice);
        common.verifyElementVisible(By.xpath(cartJsonReader.getXPathWithText("buttonDeleteByNameProd", productName)));
        common.verifyElementVisible(By.xpath(cartJsonReader.getXPathWithText("buttonSaveForLaterByNameProd", productName)));
        common.verifyElementVisible(By.id(cartJsonReader.getXPath("buttonUsePromoCode")));
        common.verifyElementVisible(By.id(cartJsonReader.getXPath("buttonContinue")));
    }

    @And("User select Beverages screen")
    public void userSelectBeveragesScreen() {
        common.waitForElementVisibleAndClick(By.xpath(xpathsJsonReader.getXPathWithText("textView", "Beverages")));
    }

    @And("Click Continue button")
    public void clickContinueButton() {
        common.waitForElementVisibleAndClick(By.id(cartJsonReader.getXPath("buttonContinue")));
    }

    @And("Click button Login")
    public void clickButtonLogin(){
        common.waitForElementVisibleAndClick(By.id(xpathsJsonReader.getXPath("buttonLogin")));
    }

    @And("Click Continue button in select address screen")
    public void clickContinueButtonInSelectAddressScreen() {
        common.waitForElementVisibleAndClick(By.xpath(addressJsonReader.getXPath("buttonContinueAddress")));
    }
}
