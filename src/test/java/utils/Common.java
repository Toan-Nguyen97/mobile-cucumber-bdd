package utils;

import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.server.handler.W3CActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Common {
    public static final int timeout = 10;
//    private WebDriver driver;

    private AppiumDriver driver;
    public Common() {
        this.driver = Hook.getDriver();
    }

    public void verifyElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Assert.assertTrue("Element is not displayed: " + locator, element.isDisplayed());

        } catch (Exception e) {
            System.out.println("Could not found element: " + locator);
            Assert.fail("Element not found: " + locator);
        }
    }

    public void verifyElementVisibleByText(String text){
        String xpath = String.format("//android.widget.TextView[@text=\"%s\"]", text);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Assert.assertTrue("Element is not displayed: " + xpath, element.isDisplayed());

        } catch (Exception e) {
            System.out.println("Could not found element: " + xpath);
            Assert.fail("Element not found: " + xpath);
        }
    }

    public void waitForElementVisibleAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click();
        } catch (Exception e) {
            System.out.println("Could not found element to click: " + locator);
            Assert.fail("Element not found to click: " + locator);
        }
    }

    public void waitForElementVisibleAndInput(By locator, String inputText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(inputText);
        } catch (Exception e) {
            System.out.println("Could not found element to click: " + locator);
            Assert.fail("Element not found to click: " + locator);
        }
    }

    public void scrollUp(){
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int startY = (int)(height*0.8);
        int endY = (int)(height*0.2);
        int x = width/2;
        System.out.println("starty = " + startY + " ,endy = " + endY + " , x = " + x);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // Thực hiện scroll
        driver.perform(Arrays.asList(swipe));
    }

    public void scrollDown(){
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int startY = (int) (height * 0.2);
        int endY = (int) (height * 0.8);
        int x = width / 2;
        System.out.println("startY = " + startY + ", endY = " + endY + ", x = " + x);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // Thực hiện scroll
        driver.perform(Arrays.asList(swipe));
    }

    public void scrollToFindElement(By locator) {
        int maxScrolls = 10;
        int scrollCountActual = 0;
        while (scrollCountActual < maxScrolls) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                if (element.isDisplayed()) {
                    System.out.println("Element found: " + locator);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Element not found, scrolling down...");
                scrollUp();
            }
            scrollCountActual++;
        }
    }

    public void swipeRightToLeft(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            int startX = element.getLocation().getX() + element.getSize().getHeight();
            int endX = element.getLocation().getX() + 10;
            int y = element.getLocation().getY() + (element.getSize().getHeight() / 2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(java.util.Collections.singletonList(swipe));
        } catch (Exception e) {
            System.out.println("Could not swipe on element: " + locator);
            Assert.fail("Failed to swipe on element: " + locator);
        }
    }

    public int countElementExistsByLocators(By locator){
        Set<String> listItems = new HashSet<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            while (true) {
//                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//                List<WebElement> products = element.findElements(By.xpath(locator.toString()));
                List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
                boolean isNewFound = false;
                for (WebElement product : products) {
                    String productName = product.getText();
                    if (listItems.add(productName)) {
                        isNewFound = true;
                    }
                }
                if (!isNewFound) {
                    break;
                }
                scrollUp();
            }
        } catch (Exception e) {
            System.out.println("Could not found element by locator: " + locator);
            Assert.fail("Element not found by locator: " + locator);
        }
        System.out.println("List product are: " + listItems);
//        return listItems.size();
        return 0;
    }

    public void assertGetValeWithExpected(By locator, String expectedValue){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String actualValue = element.getText();
            System.out.println("Actual Value: " + actualValue);
            Assert.assertEquals("The actual value does not match the expected value!", expectedValue, actualValue);
        } catch (Exception e) {
            System.out.println("Error: Could not find the element with locator: " + locator);
            Assert.fail("Failed to get value from element: " + locator);
        }
    }

    public String getTextByLocator(By locator){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String text = element.getText();
            return text;
        } catch (Exception e) {
            System.out.println("Failed to retrieve text for locator: " + locator);
            throw new RuntimeException("Element not found: " + locator, e);
        }
    }
}
