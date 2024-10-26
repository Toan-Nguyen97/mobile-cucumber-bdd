package stepdefinitions;

import common.JSONReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import utils.Common;
import utils.Hook;

public class ProfileSteps {
    private AppiumDriver driver;
    private JSONReader profileScreenJsonReader;
//    private JSONReader cartJsonReader;
    private JSONReader xpathsJsonReader;
//    private JSONReader addressJsonReader;
    private Common common;

    public ProfileSteps() {
        this.driver = Hook.getDriver();
        this.profileScreenJsonReader = new JSONReader("src/test/resources/pages/Profile.json");
//        this.cartJsonReader = new JSONReader("src/test/resources/pages/Cart.json");
        this.xpathsJsonReader = new JSONReader("src/test/resources/pages/Xpaths.json");
//        this.addressJsonReader = new JSONReader("src/test/resources/pages/Address.json");
        this.common = new Common();
    }
    @Then("Verify Profile screen displayed")
    public void verifyProfileScreenDisplayed() {
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuHome")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuCart")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuNoti")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuOrders")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuWalletHistory")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuTransactionHistory")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuChangePass")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuManageAddress")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuReferEarn")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuContactUs")));
        common.scrollToFindElement(By.id(profileScreenJsonReader.getXPath("buttonMenuAboutUs")));
        common.scrollToFindElement(By.id(profileScreenJsonReader.getXPath("buttonMenuRateUs")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuShareApp")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuFAQ")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuTermCondition")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuPrivacyPolicy")));
        common.verifyElementVisible(By.id(profileScreenJsonReader.getXPath("buttonMenuLogout")));
    }
}
