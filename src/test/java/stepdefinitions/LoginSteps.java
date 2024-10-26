package stepdefinitions;

import common.JSONReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import utils.Common;
import utils.Hook;

public class LoginSteps {
    private AppiumDriver driver;
    private JSONReader loginScreenJsonReader;
    private JSONReader xpathsJsonReader;
    private Common common;

    public LoginSteps() {
        this.driver = Hook.getDriver();
        this.loginScreenJsonReader = new JSONReader("src/test/resources/pages/Login.json");
        this.xpathsJsonReader = new JSONReader("src/test/resources/pages/Xpaths.json");
        this.common = new Common();
    }

    @And("Click to Profile on footer menu")
    public void clickToProfileOnFooterMenu() {
        common.waitForElementVisibleAndClick(By.id(xpathsJsonReader.getXPath("buttonProfile")));
    }

    @And("Click to Welcome Guest")
    public void clickToWelcomeGuest() {
        common.waitForElementVisibleAndClick(By.id(xpathsJsonReader.getXPath("welcomeGuest")));
    }

    @Then("Verify login screen displayed")
    public void verifyLoginScreenDisplayed() {
        common.verifyElementVisible(By.id(loginScreenJsonReader.getXPath("textboxMobile")));
        common.verifyElementVisible(By.id(loginScreenJsonReader.getXPath("textboxPassword")));
        common.verifyElementVisible(By.id(loginScreenJsonReader.getXPath("buttonLoginPage")));
        common.verifyElementVisible(By.id(loginScreenJsonReader.getXPath("buttonForgotPassword")));
        common.verifyElementVisible(By.id(loginScreenJsonReader.getXPath("buttonSignUp")));
    }
}
