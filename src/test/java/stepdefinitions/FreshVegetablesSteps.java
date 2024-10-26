package stepdefinitions;

import common.JSONReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Common;
import utils.Hook;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class FreshVegetablesSteps {
    private AppiumDriver driver;
    private JSONReader homeScreenJsonReader;
    private JSONReader freshVegetablesScreenJsonReader;
    private JSONReader xpaths;

    private Common common;

    public FreshVegetablesSteps() {
        this.driver = Hook.getDriver();
        this.homeScreenJsonReader = new JSONReader("src/test/resources/pages/HomeScreen.json");
        this.freshVegetablesScreenJsonReader = new JSONReader("src/test/resources/pages/FreshVegetables.json");
        this.xpaths = new JSONReader("src/test/resources/pages/Xpaths.json");
        this.common = new Common();
    }

    @When("User go to the Fresh Vegetables screen")
    public void userGoToTheFreshVegetablesScreen() {
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("nextButton")));
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("nextButton")));
        common.waitForElementVisibleAndClick(By.id(homeScreenJsonReader.getXPath("getStarted")));
        common.waitForElementVisibleAndClick(By.xpath(homeScreenJsonReader.getXPathWithText("locationDelivery", "All")));
        common.scrollToFindElement(By.xpath(xpaths.getXPathWithText("textView", "Fresh Vagetables")));
        common.waitForElementVisibleAndClick(By.xpath(freshVegetablesScreenJsonReader.getXPath("viewAllFreshProducts")));
    }

    @Then("Verify the number of product {int}")
    public void verifyTheNumberOfProduct(int expectNumber) {
        Set<String> listProductName = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 6; j++) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(freshVegetablesScreenJsonReader.getXPathWithText("getProductName", String.valueOf(j)))));
                System.out.println(element);
                String name = element.getText();
                if (listProductName.add(name)) {
                    System.out.println("Product name: " + name);
                }
            }
            common.scrollUp();
        }
        System.out.println(listProductName);
        System.out.println(listProductName.size());
        Assert.assertEquals(listProductName.size(), expectNumber, "The number of products does not match the expected number.");
    }
}
