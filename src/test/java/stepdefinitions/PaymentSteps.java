package stepdefinitions;

import common.JSONReader;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.By;
import utils.Common;
import utils.Hook;

public class PaymentSteps {
    private AppiumDriver driver;
    private JSONReader paymentJsonReader;
    private Common common;

    public PaymentSteps() {
        this.driver = Hook.getDriver();
        this.paymentJsonReader = new JSONReader("src/test/resources/pages/Payment.json");
        this.common = new Common();
    }

    @Then("Verify detail Payment screen with {} and {} and {} and {} and {} and {} and {} and {}")
    public void verifyDetailPaymentScreenWithAndAndAndAndAndAndAnd(String product,
                                                                String totalPrice, String subtotal,
                                                                String deliveryCharge, String youSaved, String location,
                                                                String grandTotal, String productPayment) {
        String address = common.getTextByLocator(By.id(paymentJsonReader.getXPath("textAddress")));
        String pinCode = address.substring(address.length() - 6);
        Assert.assertEquals("The actual value does not match the expected value!", location, pinCode);
        common.assertGetValeWithExpected((By.id(paymentJsonReader.getXPath("grandTotal"))), grandTotal);
        common.assertGetValeWithExpected((By.id(paymentJsonReader.getXPath("orderSummaryNameProd"))), productPayment);
        common.assertGetValeWithExpected((By.id(paymentJsonReader.getXPath("deliveryCharge"))), deliveryCharge);
        common.assertGetValeWithExpected((By.id(paymentJsonReader.getXPath("youSaved"))), youSaved);
        common.scrollUp();
//        common.assertGetValeWithExpected((By.xpath(paymentJsonReader.getXPathWithText("totalPrice",product))), totalPrice);
        common.assertGetValeWithExpected((By.id(paymentJsonReader.getXPath("subTotal"))), subtotal);
        System.out.println("Verify done");
    }
}
