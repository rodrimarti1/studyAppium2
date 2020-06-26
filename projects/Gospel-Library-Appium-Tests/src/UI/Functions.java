package UI;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

import static UI.EnvironmentConfig.*;
import static org.junit.jupiter.api.Assertions.fail;

public class Functions {

    private static final String gospelLibraryBuild = "alpha";
    private static final String APP = "/Users/crossfitpt/qa-gospellibrary-android/APK/gospel-library-" + gospelLibraryBuild + ".apk";
    private static final String APPIUM = "http://localhost:4723/wd/hub";
    private AndroidDriver driver;

    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Android SDK built for x86");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("app", APP);
        driver = new AndroidDriver(new URL(APPIUM), caps);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Test Functions
    public void splashScreenWait() throws Exception {
        try {
            Thread.sleep((milliseconds_1 / 2));
            Boolean isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
            while (isPresent) {
                Thread.sleep(milliseconds_1 / 2);
                isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
            }
        }
        catch (Exception ign) {}
    }

    public void skipTips() throws Exception {
        splashScreenWait();
        driver.findElement(By.id("org.lds.ldssa." + gospelLibraryBuild + ":id/skip")).click();
        Thread.sleep(milliseconds_1);
    }

    public void skipLogin() throws Exception {
        skipTips();
        driver.findElementById("org.lds.ldssa." + gospelLibraryBuild + ":id/done").click();
        Thread.sleep(milliseconds_1);
    }

    public void downloadAllInCollection(String collection) throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByText(collection, false));
        ClickUIElementByText(collection, false);
        Thread.sleep(milliseconds_1);
        assertMoreOptionsMenu("Collection Menu", false);
        assertElementExistsBy(WebElementsByText("Download All", false));
        //ClickUIElementByText("Download All", false);
    }

    public void openCollection(String collection, String work, String book, String chapter, String verse) throws Exception {

        assertElementExistsBy(WebElementsByText(collection, false));
        ClickUIElementByText(collection, false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByText(work, false);
        Thread.sleep(milliseconds_1);

        if (book != "") {
            scrollDownTo(book);
            ClickUIElementByText(book, false);
            Thread.sleep(milliseconds_2);
            if (chapter != "") {
                scrollDownTo(chapter);
                ClickUIElementByText(chapter, false);
                Thread.sleep(milliseconds_1);
            }
            if (verse != "") {
                Thread.sleep(milliseconds_1);
                System.out.println("Scrolling to p" + verse);
                scrollToByResourceId("p" + verse);
            }
        }
    }

    public void goToSettings() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
    }

    public void goToLanguage() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Language", false));
        ClickUIElementByText("Language", false);
    }

    public void changeLanguage() throws Exception {
        goToLanguage();
        assertElementExistsBy(WebElementsByText("Afrikaans", false));
        ClickUIElementByText("Afrikaans", false);
    }

    // Navigation Functions
    public void scrollDownTo(String text) {
        Boolean isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")).size() <= 0;
        int i = 0;
        while ((isNotPresent)) {
            if (i == 15) {
                fail("The item was not found on the screen within " + i + " downward scrolls");
                break;
            }
            System.out.println("" + text + " isn't on the screen... Scrolling to find");
            System.out.println("Scroll " + i + " of 15");
            scrollDown();
            isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).size() <= 0;
            i = i + 1;
        }
    }

    public void swipeDown() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 6, screenWidth / 2, screenHeight / 10 * 5, 2000);
        System.out.println("Scrolling Down...");

    }

    public void scrollDown() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 9, screenWidth / 2, screenHeight / 10 * 3, 2000);
        System.out.println("Scrolling Down...");

    }

    public void scrollToByResourceId(String id) throws Exception {
        System.out.println("Scrolling to: " + id);
        WebElement idIsPresent = WebElementByResourceId(id);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = idIsPresent.getLocation().getY();
        System.out.println("Screen Height is " + screenHeight + "");
        System.out.println("upper Y is " + upperY + "");
        while (upperY >= screenHeight / 2) {
            System.out.println("scrolling down y '" + upperY + "' is >= " + screenHeight / 2 + "");
            scrollDown();
            upperY = idIsPresent.getLocation().getY();
        }
        while (upperY <= screenHeight / 7) {
            System.out.println("scrolling up y '" + upperY + "' is <= " + screenHeight / 8 + "");
            scrollUp();
            upperY = idIsPresent.getLocation().getY();
        }
    }

    public void scrollUp() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 2, screenWidth / 2, screenHeight / 10 * 8, 2000);
        System.out.println("Scrolling Up...");
    }

    public void ClickUIElementByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with TextView");
        Thread.sleep(milliseconds_1);
    }

    public void ClickUIElementByAccessibilityID(String elementAccessibilityID) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId(elementAccessibilityID));
        WebElement itemToClick = driver.findElementByAccessibilityId(elementAccessibilityID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementAccessibilityID + "' by Accessibility ID");
        Thread.sleep(milliseconds_1);
    }

    public void dismissDialog(WebElement dialogBox) throws Exception {
        int dialogYLocation = (dialogBox.getLocation().getY());
        int dialogXLocation = (dialogBox.getLocation().getX());
        int dialogHeight = (dialogBox.getSize().height);
        int dialogWidth = (dialogBox.getSize().width);
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();
        int yTapPoint = (screenHeight / 2);
        int xTapPoint = (screenWidth / 2);
        if (dialogYLocation + dialogHeight + 10 < screenHeight) {
            yTapPoint = ((screenHeight - (dialogYLocation + dialogHeight)) / 2 + (dialogYLocation + dialogHeight));
        } else if (dialogYLocation - 10 > 1) {
            yTapPoint = (dialogYLocation / 2);
        } else if (dialogXLocation - 10 > 1) {
            xTapPoint = (dialogXLocation / 2);
        } else if (dialogXLocation + dialogWidth + 10 < screenWidth) {
            xTapPoint = ((screenWidth - (dialogXLocation + dialogWidth)) / 2 + (dialogXLocation + dialogWidth));
        }
        System.out.println("Screen Height is: " + screenHeight);
        System.out.println("Y Tap Point is:   " + yTapPoint);
        System.out.println("Screen Width is: " + screenWidth);
        System.out.println("X Tap Point is:  " + xTapPoint);
        TouchAction action = new TouchAction(driver);
        action.tap(xTapPoint, yTapPoint).perform();
        Thread.sleep(1000);
    }

    // Assert and WebElement Functions
    public void assertElementExistsBy(List webElementsBy) {
        Boolean tempElement = webElementsBy.size() > 0;
        System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + webElementsBy.toString() + "");
        if (tempElement == false) {
            System.out.println("Found " + webElementsBy.size() + ". List of Elements Found: " + webElementsBy);
        }
        assert tempElement == true;
    }

    public List WebElementsByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElements(By.xpath(xPathofText));
            if (tempElement.size() < 1) {
                System.out.println("\n" + text + " was not found on the screen. xpath was: " + xPathofText);
            }
        }
        return tempElement;
    }

    public String isAllCaps(String text) throws Exception {
        if (AndroidVersion > 6) {
            text = text.toUpperCase();
        }
        System.out.println(text);
        return text;
    }

    public WebElement WebElementByXpath(String text) throws Exception {
        WebElement tempElement = driver.findElementByXPath(text);
        return tempElement;
    }

    public WebElement WebElementByResourceId(String id) throws Exception {
        WebElement tempElement = WebElementByXpath("//*[@resource-id='" + id + "']");
        return tempElement;
    }

    public void assertMoreOptionsMenu(String screen, Boolean close) throws Exception {

        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        if (screen == "Library") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Custom Collections", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Collection Menu") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText(" ", false));
            assertElementExistsBy(WebElementsByText("Remove All", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Book Menu") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Download Audio", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Content Menu") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Related Content", false));
            assertElementExistsBy(WebElementsByText("Share", false));
            assertElementExistsBy(WebElementsByText("Play Audio", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Note") {
            assertElementExistsBy(WebElementsByText("Add to Notebook", false));
            assertElementExistsBy(WebElementsByText("Delete Note", false));
            assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        } else if (screen == "Note No Highlight") {
            assertElementExistsBy(WebElementsByText("Delete Note", false));
            assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        } else if (screen == "Notes") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Restore Journal", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Notebooks") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Screens") {
            assertElementExistsBy(WebElementsByText("Screen Settings", false));
            assertElementExistsBy(WebElementsByText("Close All Screens", false));
        } else if (screen == "History") {
            assertElementExistsBy(WebElementsByText("Clear History", false));
        } else if (screen == "DownloadsByItem") {
            assertElementExistsBy(WebElementsByText("Current Downloads", false));
        } else if (screen == "DownloadsBySize") {
            assertElementExistsBy(WebElementsByText("Current Downloads", false));
        } else {
            fail(screen + " is not a valid option for assertMoreOptionsMenu." +
                    "Available screens are:" +
                    "Library" +
                    "Collection Menu" +
                    "Book Menu" +
                    "Content Menu" +
                    "Note" +
                    "Note No Highlight" +
                    "Notes" +
                    "Notebooks" +
                    "Screens" +
                    "History" +
                    "DownloadsByItem" +
                    "DownloadsBySize");
        }
        if (close) {
            dismissDialog(WebElementByXpath("*//android.widget.FrameLayout"));
            assertElementNotPresentBy(WebElementsByTextWebview("New Screen", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Custom Collections", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Download All", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Remove All", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Download Audio", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Related Content", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Share", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Play Audio", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Restore Journal", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Language", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Settings", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Screen Settings", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Close All Screens", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Clear History", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Sort by Size", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Sort by Item", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Current Downloads", false));
        }
    }

    public List WebElementsByAccessibilityId(String id) throws Exception {
        List tempElement = driver.findElementsByAccessibilityId(id);
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElementsByAccessibilityId(id);
            if (tempElement.size() < 1) {
                System.out.println("\n" + id + " was not found on the screen.");
            }
        }
        return tempElement;
    }

    public void assertElementNotPresentBy(List webElementsBy) {
        Boolean tempElement = webElementsBy.size() > 0;
        System.out.println("assert element is not present. Expected: false [] Actual: " + tempElement + " " + webElementsBy.toString() + "");
        assert tempElement == false;
    }

    public List WebElementsByTextWebview(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            System.out.println("\n" + text + " was not found on the screen. xpath was: " + xPathofText);
        }
        return tempElement;
    }


















}
