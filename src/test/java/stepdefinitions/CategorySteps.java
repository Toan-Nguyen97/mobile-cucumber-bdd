package stepdefinitions;

import common.JSONReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Common;
import utils.Hook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategorySteps {
//    private WebDriver driver;
    private AppiumDriver driver;
    private JSONReader homeScreenJsonReader;
    private JSONReader categoryScreenJsonReader;
    private Common common;

    public CategorySteps() {
        this.driver = Hook.getDriver();
        this.homeScreenJsonReader = new JSONReader("src/test/resources/pages/HomeScreen.json");
        this.categoryScreenJsonReader = new JSONReader("src/test/resources/pages/Category.json");
        this.common = new Common();
    }
    @Given("User open application on devices")
    public void userOpenApplicationOnDevices() throws InterruptedException{
        Thread.sleep(5);
        System.out.println("===== Application opening... =====");
    }

    @When("User go to the Category screen")
    public void userGoToTheCategoryScreen() {
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("nextButton")));
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("nextButton")));
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("getStarted")));
        common.verifyElementVisible(By.id(homeScreenJsonReader.getXPath("textboxSearchPin")));
        common.verifyElementVisible(By.id(homeScreenJsonReader.getXPath("btnSearch")));
        List<String> items = new ArrayList<>(Arrays.asList("All", "370405", "841301", "800001", "370465", "370001"));
        for(String x : items){
            common.verifyElementVisible(By.xpath(homeScreenJsonReader.getXPathWithText("locationDelivery", x)));
        }
        common.waitForElementVisibleAndClick(By.xpath(homeScreenJsonReader.getXPathWithText("locationDelivery", "All")));
        System.out.println("User click into view detail category");
        common.scrollToFindElement(By.id(categoryScreenJsonReader.getXPath("viewAllCategory")));
        common.waitForElementVisibleAndClick(By.id(categoryScreenJsonReader.getXPath("viewAllCategory")));
    }

    @Then("Verify items in Category screen")
    public void verifyItemsInCategoryScreen() throws InterruptedException{
        List<String> items = new ArrayList<>(Arrays.asList("Coffee Product", " Fast Food", " Home Supplies, Utilities & Stationery", "Beverages", " Baby Need's", "Vegetables"));
        for(String x: items){
            System.out.println("Verifying text: " + x);
            common.verifyElementVisibleByText(x);
        }
        Thread.sleep(10000);
    }

    @And("User go into Category screen")
    public void userGoIntoCategoryScreen() {
        common.scrollToFindElement(By.id(categoryScreenJsonReader.getXPath("viewAllCategory")));
        common.waitForElementVisibleAndClick(By.id(categoryScreenJsonReader.getXPath("viewAllCategory")));
    }
}
