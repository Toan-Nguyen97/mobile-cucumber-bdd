package stepdefinitions;

import common.JSONReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Common;
import utils.Hook;

public class HomeSteps {
//    private WebDriver driver;
    private AppiumDriver driver;
    private JSONReader jsonReader;
    private Common common;

    public HomeSteps() {
        this.driver = Hook.getDriver();
        this.jsonReader = new JSONReader("src/test/resources/pages/HomeScreen.json");
        this.common = new Common();
    }

    @Given("User open application")
    public void userOpenApplication() throws InterruptedException{
        Thread.sleep(5);
        System.out.println("===== Application opening... =====");
    }

    @When("Open successfully")
    public void openSuccessfully() {
        System.out.println("===== Application opened! =====");
    }

    @Then("Verify home screen")
    public void verifyHomeScreen() throws InterruptedException {
        common.verifyElementVisible(By.id(jsonReader.getXPath("skippButton")));
        common.verifyElementVisible(By.id(jsonReader.getXPath("nextButton")));
        common.verifyElementVisible(By.id(jsonReader.getXPath("messageText")));
    }

    @And("Select with location all")
    public void selectWithLocationAll() throws InterruptedException{
//        Thread.sleep(5);
        common.verifyElementVisible(By.xpath(jsonReader.getXPathWithText("locationDelivery", "All")));
        common.waitForElementVisibleAndClick(By.xpath(jsonReader.getXPathWithText("locationDelivery", "All")));
    }
}
