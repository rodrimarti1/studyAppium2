package UI;

        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.TouchAction;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.AndroidKeyCode;
        import io.appium.java_client.android.AndroidKeyMetastate;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebElement;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Set;

        import static UI.EnvironmentConfig.*;
        import static UI.Strings.*;
        import static java.lang.Integer.parseInt;
        import static org.junit.jupiter.api.Assertions.fail;


public class mainFunctions {

    public AppiumDriver driver;
    GospelForKids gfk = new GospelForKids();
    public static int countTestCases = 0;
    public static int testsPassed = 0;
    public static int testsFailed = 0;

    //********************************************** Functions **********************************************

    //creates app specific id (String)
    public String AppId(String id) throws Exception {
        String theNewId = Org + AppName + "." + BuildType + ":id/" + id;
        return theNewId;
    }

    //creates log (String)
    public void log(String theStringToLog) throws Exception {
        System.out.println(theStringToLog);
    }

    //creates android specific id (String)
    public String AndroidId(String id) throws Exception {
        String theNewId = AndroidName + ":id/" + id;
        return theNewId;
    }

    //Replaces letters with dots (String)
    public String hidePassword(String password) throws Exception {
        String passwordDotted = "";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion > 6) {
            int passwordLength = password.length();
            for (int i = 0; i < passwordLength; i++) {
                passwordDotted = passwordDotted.concat("•");
            }
        }
        return passwordDotted;
    }

    //Changes text to caps if on android 7 or higher (String)
    public String isAllCaps(String text) throws Exception {
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion > 6) {
            text = text.toUpperCase();
        }
        System.out.println("Print text in all caps:" + " " + text);
        return text;
    }

    //Get Android Version (String)
    public String isAndroidVersion(String androidSixAndBelow, String androidSevenAndUp){
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion > 6){
            return androidSevenAndUp;
        }else{
            return androidSixAndBelow;
        }
    }

    //Get Element by text (String)
    public String FindElementByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        //System.out.println("Xpath is: '"+xPathofText+"");
        return xPathofText;
    }

    //Get Element by id (String)
    public String FindElementByID(String id) throws Exception {
        String xPathofId = "//*[@id=\\\"\" + id + \"\\\"]";
        //System.out.println("Xpath is: '"+xPathofId+"");
        return xPathofId;
    }

    //Get Element by xpath (WebElement)
    public WebElement FindElementByXpath(String id) throws Exception {
        WebElement xPathofId = driver.findElementByXPath(id);
        //System.out.println("Xpath is: '"+xPathofId+"");
        return xPathofId;
    }

    //Get Element by text contains (String)
    public String FindElementByContainsText(String text) throws Exception {
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        //System.out.println("Xpath is: '"+xPathofText+"'");
        return xPathofText;
    }

    //Create WebElement by text (WebElement)
    public WebElement WebElementByText(String elementClass, String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//" + elementClass + "[@text='" + text + "']";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion < 6) {
            xPathofText = "//" + elementClass + "[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElement by button text (WebElement)
    public WebElement WebElementByButtonText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.Button[@text='" + text + "']";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.Button[contains(@text, '" + text + "')]";
        }
        System.out.println("Xpath of current item is: "+xPathofText+"");
        Thread.sleep(1000);
        WebElement testText = driver.findElement(By.xpath(xPathofText));
        System.out.println("Get text by Xpath: "+testText+"");
        Thread.sleep(1000);
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElement by text view.View (WebElement)
    public WebElement WebElementByTextViewView(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.view.View[@text='" + text + "']";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion < 6) {
            xPathofText = "//android.view.View[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElement by CheckedTextView (WebElement)
    public WebElement WebElementByCheckedText(String text) throws Exception {
        String xPathofText = "//android.widget.CheckedTextView[@text='" + text + "']";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.CheckedTextView[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElements by text (list)
    public List WebElementsByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
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

    //Create WebElements by text in a webview (List) (doesn't swipe if no element is found on the screen)
    public List WebElementsByTextWebview(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
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

    //Create WebElements by text contains (List)
    public List WebElementsByTextContains(String text) throws Exception {
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
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

    //Create WebElements by text contains (List)
    public List WebElementsByClassTextContains(String elementClass, String text, String options) throws Exception {
        String xPathofText = "//" + elementClass + "[contains(@text, '" + text + "')]";
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

    //Create WebElements by Checked text (List)
    public List WebElementsByCheckedText(String CheckedText, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            CheckedText = isAllCaps(CheckedText);
        }
        String xPathofText = "//android.widget.CheckedTextView[@text='" + CheckedText + "']";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.CheckedTextView[contains(@text, '" + CheckedText + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElements(By.xpath(xPathofText));
            if (tempElement.size() < 1) {
                System.out.println("\n" + CheckedText + " was not found on the screen. xpath was: " + xPathofText);
            }
        }
        return tempElement;
    }

    //Create WebElements by id (List)
    public List WebElementsById(String id) throws Exception {
        List tempElement = driver.findElementsById(id);
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElementsById(id);
            if (tempElement.size() < 1) {
                System.out.println("\n" + id + " was not found on the screen.");
            }
        }
        return tempElement;
    }

    //Create WebElements by id (List)
    public List WebElementsByIdExpectFalse(String id) throws Exception {
        List tempElement = driver.findElementsById(id);
        if (tempElement.size() < 1) {
            System.out.println("\n" + id + " was not found on the screen.");
        }
        return tempElement;
    }

    //Create WebElements by resource-id (List)
    public List WebElementsByResourceId(String id) throws Exception {
        List tempElement = WebElementsByXpath("//*[@resource-id=\""+id+"\"]");
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = WebElementsByXpath("//*[@resource-id=\"" + id + "\"]");
            if (tempElement.size() < 1) {
                System.out.println("\n" + id + " was not found on the screen.");
            }
        }
        return tempElement;
    }

    //Create WebElements by accessibility id (List)
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

    //Create WebElements by xpath (List)
    public List WebElementsByXpath(String xpath) throws Exception {
        String xPathofText = xpath;
        System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElements(By.xpath(xPathofText));
            if (tempElement.size() < 1) {
                System.out.println("\n" + xpath + " was not found on the screen. xpath was: " + xPathofText);
            }
        }
        return tempElement;
    }

    //Create WebElements by xpath in webview (List)
    public List WebElementsByXpathWebview(String xpath) throws Exception {
        String xPathofText = xpath;
        System.out.println("Xpath of current item is: " + xPathofText + "");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            System.out.println("\n" + xpath + " was not found on the screen. xpath was: " + xPathofText);
        }
        return tempElement;
    }

    //Create WebElement by id (WebElement)
    public WebElement WebElementById(String id) throws Exception {
        WebElement tempElement = driver.findElementById(id);
        return tempElement;
    }

    //Create WebElement by resource-id (WebElement)
    public WebElement WebElementByResourceId(String id) throws Exception{
        WebElement tempElement = WebElementByXpath("//*[@resource-id='"+id+"']");
        return tempElement;
    }

    //Create WebElement by AccessibilityId (WebElement)
    public WebElement WebElementByAccessibilityId(String accessibilityid) throws Exception {
        WebElement tempElement = driver.findElementByAccessibilityId(accessibilityid);
        return tempElement;
    }

    //Create WebElement for settings Switch by text (WebElement)
    public WebElement WebElementSettingSwitchByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        WebElement tempElement = driver.findElementByXPath("//android.widget.TextView[@text='" + text + "']/../../android.widget.LinearLayout/android.widget.Switch");
        return tempElement;
    }

    //Create WebElement by text contains (WebElement)
    public WebElement WebElementByTextContains(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Click Element in Webview (String)
    public void ClickUIElementInWebviewByXPath(String xPath) throws Exception{
        driver.context("WEBVIEW_org.lds." + AppName + "." + BuildType + "");
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        for (String window: windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: "+ window);
        }

        ClickUIElementByXpath(xPath);
        driver.context("NATIVE_APP");
    }

    //Click Element by Text (String)
    public void ClickUIElementByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with TextView");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Text of Xpath view.view (String)
    public void ClickUIElementByViewText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.view.View[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with TextView");
        Thread.sleep(milliseconds_1);
    }

    //Click Element by Text (String)
    public void ClickUIElementByTextContains(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with TextView");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Text view.View (String)
    public void ClickUIElementByTextViewView(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.view.View[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with view.View");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Checked Text (String)
    public void ClickUIElementByCheckedText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.CheckedTextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with CheckedTextView");
        Thread.sleep(milliseconds_2);
    }

    //Create WebElement by xPath (WebElement)
    public WebElement WebElementByXpath(String text) throws Exception {
        WebElement tempElement = driver.findElementByXPath(text);
        return tempElement;
    }

    //Click Element by 2 text items (String))
    public void ClickUIElementBy2TextStrings(String book, String number) throws Exception {
        String xPathofText = "//android.widget.TextView[contains(@text, '" + book + "')][contains(@text, '" + number + "')]";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        System.out.println("Clicking: '" + book + " " + number + "' using 2 text contains by xPath");
        itemToClick.click();
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Accessibility ID (String)
    public void ClickUIElementByAccessibilityID(String elementAccessibilityID) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId(elementAccessibilityID));
        WebElement itemToClick = driver.findElementByAccessibilityId(elementAccessibilityID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementAccessibilityID + "' by Accessibility ID");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by ID (String)
    public void ClickUIElementByID(String elementID) throws Exception {
        assertElementExistsBy(WebElementsById(elementID));
        WebElement itemToClick = driver.findElementById(elementID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementID + "' by ID");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by ResourceID (String)
    public void ClickUIElementByResourceID(String elementID) throws Exception {
        assertElementExistsBy(WebElementsByResourceId(elementID));
        WebElement itemToClick = WebElementByResourceId(elementID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementID + "' by ResourceID");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Xpath (String)
    public void ClickUIElementByXpath(String xpath) throws Exception {
        assertElementExistsBy(WebElementsByXpath(xpath));
        WebElement itemToClick = driver.findElementByXPath(xpath);
        itemToClick.click();
        System.out.println("Clicking: '" + xpath + "' by xPath");
        Thread.sleep(milliseconds_2);
    }

    //Tap in the center of the screen
    public void TapCenterScreen() throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        TouchAction action = new TouchAction(driver);
        action.tap(screenWidth / 2, screenHeight / 2).perform();
        System.out.println("Tapping center of screen");
    }

    //Tap the screen by coordinates
    public void Tap(int tapX, int tapY) throws Exception {
        TouchAction action = new TouchAction(driver);
        action.tap(tapX, tapY).perform();
        System.out.println("Tapping the screen by coordinates");
    }

    //Tap and drag
    public void TapAndDrag(WebElement startPoint, WebElement endPoint) throws Exception {
        int tapX = startPoint.getLocation().getX();
        int tapY = startPoint.getLocation().getY();
        int tapElementWidth = startPoint.getSize().getWidth();
        int tapElementHeight = startPoint.getSize().getHeight();
        int startX = tapX + (tapElementWidth / 2);
        int startY = tapY + (tapElementHeight / 2);

        tapX = endPoint.getLocation().getX();
        tapY = endPoint.getLocation().getY();
        tapElementWidth = endPoint.getSize().getWidth();
        tapElementHeight = endPoint.getSize().getHeight();
        int endX = tapX + (tapElementWidth / 2);
        int endY = tapY;

        TouchAction action = new TouchAction(driver);

        action
                .longPress(startX, startY)
                .moveTo(endX, endY)
                .release()
                .perform();


        driver.getPageSource();
    }

    //Enter Text to a field by ID
    //click field, clear field, enter text
    public void sendText(String elementID, String text) throws Exception {
        WebElement textfield = driver.findElementById(elementID);
        textfield.clear();
        textfield.sendKeys(text);
        System.out.println("Sending Text: '" + text + "'");
        Thread.sleep(milliseconds_1);
    }

    //Enter Text to a field by ID
    //click field, enter text
    public void sendTextWithoutclear(String elementID, String text) throws Exception {
        WebElement textfield = driver.findElementById(elementID);
        textfield.sendKeys(text);
        System.out.println("Sending Text: '" + text + "'");
        Thread.sleep(milliseconds_1);
    }

    //Convert String into keyboard keys
    public void sendTextFromKeyboard(String elementID, String text, Boolean clickOnElement) throws Exception {
        if (clickOnElement) {
            ClickUIElementByID(elementID);
        }
        int i = 0;
        Character currentChar = text.charAt(i);
        while (i < text.length()) {
            currentChar = text.charAt(i);
            switch (currentChar) {
                case 'a':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A);
                    break;
                case 'b':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_B);
                    break;
                case 'c':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_C);
                    break;
                case 'd':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_D);
                    break;
                case 'e':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_E);
                    break;
                case 'f':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_F);
                    break;
                case 'g':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_G);
                    break;
                case 'h':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_H);
                    break;
                case 'i':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_I);
                    break;
                case 'j':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_J);
                    break;
                case 'k':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_K);
                    break;
                case 'l':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_L);
                    break;
                case 'm':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_M);
                    break;
                case 'n':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_N);
                    break;
                case 'o':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_O);
                    break;
                case 'p':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_P);
                    break;
                case 'q':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Q);
                    break;
                case 'r':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_R);
                    break;
                case 's':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_S);
                    break;
                case 't':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
                    break;
                case 'u':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_U);
                    break;
                case 'v':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_V);
                    break;
                case 'w':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_W);
                    break;
                case 'x':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_X);
                    break;
                case 'y':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Y);
                    break;
                case 'z':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Z);
                    break;
                case 'A':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'B':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_B, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'C':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_C, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'D':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_D, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'E':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_E, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'F':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_F, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'G':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_G, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'H':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_H, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'I':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_I, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'J':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_J, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'K':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_K, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'L':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_L, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'M':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_M, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'N':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_N, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'O':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_O, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'P':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_P, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'Q':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Q, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'R':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_R, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'S':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_S, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'T':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_T, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'U':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_U, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'V':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_V, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'W':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_W, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'X':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_X, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'Y':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Y, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'Z':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Z, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case ' ':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SPACE);
                    break;
                case '.':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_PERIOD);
                    break;
                case ',':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_COMMA);
                    break;
                case '¶':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
                    break;
                case '0':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0);
                    break;
                case '1':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
                    break;
                case '2':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_2);
                    break;
                case '3':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_3);
                    break;
                case '4':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_4);
                    break;
                case '5':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_5);
                    break;
                case '6':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_6);
                    break;
                case '7':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_7);
                    break;
                case '8':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_8);
                    break;
                case '9':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_9);
                    break;

            }

            i = i + 1;
        }
    }

    //Scroll down the page
    public void scrollDown() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 9, screenWidth / 2, screenHeight / 10 * 3, 2000);
        System.out.println("Scrolling Down...");

    }

    //Scroll down the page
    public void swipeDown() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 6, screenWidth / 2, screenHeight / 10 * 5, 2000);
        System.out.println("Swiping Down...");

    }

    //Scroll up the page
    public void scrollUp() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 2, screenWidth / 2, screenHeight / 10 * 8, 2000);
        System.out.println("Scrolling Up...");

    }

    //Swipe right
    public void swipeRight() throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 20 * 18, screenHeight / 2, screenWidth / 20 * 2, screenHeight / 2, 300);
        System.out.println("Swiping right...");
        Thread.sleep(milliseconds_1);
    }

    //Swipe left
    public void swipeLeft() throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 20 * 3, screenHeight / 2, screenWidth / 20 * 19, screenHeight / 2, 300);
        System.out.println("Swiping left...");
        Thread.sleep(milliseconds_1);
    }

    //Dismiss Dialog
    public void dismissDialog(WebElement dialogBox) throws Exception {
        int dialogYLocation = (dialogBox.getLocation().getY());
        int dialogXLocation = (dialogBox.getLocation().getX());
        int dialogHeight = (dialogBox.getSize().height);
        int dialogWidth = (dialogBox.getSize().width);
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();
        int yTapPoint = (screenHeight / 2);
        int xTapPoint = (screenWidth / 2);
        if (dialogYLocation + dialogHeight +10 < screenHeight){
            yTapPoint = ((screenHeight - (dialogYLocation + dialogHeight)) / 2 + (dialogYLocation + dialogHeight));
        } else if (dialogYLocation - 10 > 1){
            yTapPoint = (dialogYLocation / 2);
        } else if (dialogXLocation -10 > 1){
            xTapPoint = (dialogXLocation / 2);
        } else if (dialogXLocation + dialogWidth +10 < screenWidth){
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

    //Click on a set position on the Seek bar
    public void ClickSeekBarAt(WebElement webelement, int positionOf7) throws Exception {
        int upperY = webelement.getLocation().getY();
        int upperX = webelement.getLocation().getX();
        int seekbarWidth = webelement.getSize().getWidth();
        int seekbarHeight = webelement.getSize().getHeight();
        int TapTarget = (upperY + (seekbarHeight / 2));
        //Seekbar positions
        int setting1 = (upperX + (seekbarWidth / 20));
        int setting2 = (int) (upperX + (seekbarWidth / 7) * 1.16);
        int setting3 = (int) (upperX + (seekbarWidth / 7) * 2.33);
        int setting4 = (upperX + (seekbarWidth / 2));
        int setting5 = (int) (upperX + ((seekbarWidth / 7) * 4.66));
        int setting6 = (int) (upperX + ((seekbarWidth / 7) * 5.84));
        int setting7 = (upperX + ((seekbarWidth / 20) * 19));


        if (positionOf7 == 1) {
            //12px
            driver.tap(1, setting1, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 2) {
            //18px
            driver.tap(1, setting2, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 3) {
            //21px
            driver.tap(1, setting3, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 4) {
            driver.tap(1, setting4, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 5) {
            driver.tap(1, setting5, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 6) {
            driver.tap(1, setting6, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 7) {
            driver.tap(1, setting7, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else {
            driver.tap(1, setting3, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        }
    }

    //Increase playback time
    public String addTimetoPlaybackTime (String time, int secondsToAdd, int minutesToAdd){
        if (time.length() < 6){
            time = "00:" + time;
        } else if (time.length() < 8) {
            time = "0" + time;
        }
        System.out.println(time);
        int seconds = parseInt(time.substring(6,8));
        int minutes = parseInt(time.substring(3,5));
        int hours = parseInt(time.substring(0,2));
        System.out.println(seconds);
        System.out.println(minutes);
        System.out.println(hours);
        seconds = seconds + secondsToAdd;
        System.out.println(seconds);
        minutes = minutes + minutesToAdd;
        System.out.println(minutes);

        if (seconds >= 60){
            seconds = (seconds - 60);
            minutes = (minutes + 1);
        }
        if (minutes >= 60){
            minutes = (minutes - 60);
            hours = (hours + 1);
        }
        String nSeconds = "";
        String nMinutes = "";
        String nHours = String.valueOf(hours);
        if (seconds < 10){
            nSeconds = "0" + String.valueOf(seconds);
        } else {
            nSeconds = String.valueOf(seconds);
        }
        if (minutes < 10){
            nMinutes = "0" + String.valueOf(minutes);
        } else {
            nMinutes = String.valueOf(minutes);
        }

        String nTime = nHours + ":" + nMinutes + ":" + nSeconds;
        if (parseInt(String.valueOf(nTime.charAt(0))) == 0){
            nTime = nTime.substring(2,7);
        }
        return nTime;
    }

    //assert Audio Player
    public void assertAudioPlayerUI(String title, String subtitle, String startTime, String endTime, boolean isFirstItem, boolean isLastItem) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("miniPlaybackControls")));
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds." + AppName + "." + BuildType + ":id/mediaPlaybackToolbar']/android.widget.TextView[1]"));
        verifyText(title, WebElementByXpath("//android.view.ViewGroup[@resource-id='org.lds." + AppName + "." + BuildType + ":id/mediaPlaybackToolbar']/android.widget.TextView[1]"), false);
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds." + AppName + "." + BuildType + ":id/mediaPlaybackToolbar']/android.widget.TextView[2]"));
        verifyText(subtitle, WebElementByXpath("//android.view.ViewGroup[@resource-id='org.lds." + AppName + "." + BuildType + ":id/mediaPlaybackToolbar']/android.widget.TextView[2]"), false);
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds." + AppName + "." + BuildType + ":id/mediaPlaybackToolbar']/android.widget.ImageButton"));
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds." + AppName + "." + BuildType + ":id/mediaPlaybackToolbar']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ImageView[@content-desc=\"More options\"]"));
        assertElementExistsBy(WebElementsById(AppId("controlsLayout")));
        if (!isFirstItem) {
            assertElementExistsBy(WebElementsById(AppId("previousButton")));
        }
        assertElementExistsBy(WebElementsById(AppId("replayButton")));
        assertElementExistsBy(WebElementsById(AppId("playPauseButton")));
        assertElementExistsBy(WebElementsById(AppId("forwardButton")));
        if (!isLastItem) {
            assertElementExistsBy(WebElementsById(AppId("nextButton")));
        }
        assertElementExistsBy(WebElementsById(AppId("progressLayout")));
        assertElementExistsBy(WebElementsById(AppId("seekBar")));
        assertElementExistsBy(WebElementsById(AppId("currentPositionTextView")));
        verifyText(startTime, WebElementById(AppId("currentPositionTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("durationTextView")));
        verifyText(endTime, WebElementById(AppId("durationTextView")), false);
        //Can't run these because back and forward 10 seconds doesn't work correctly when paused
//        ClickUIElementByID(AppId("forwardButton");
//        //add 10 to startTime
//        startTime = addTimetoPlaybackTime(startTime,10,0);
//        verifyText(startTime, WebElementById(AppId("currentPositionTextView"));
//        ClickUIElementByID(AppId("forwardButton");
//        ClickUIElementByID(AppId("forwardButton");
//        //add another 10 to startTime
//        startTime = addTimetoPlaybackTime(startTime,10,0);
//        verifyText(startTime,WebElementById(AppId("currentPositionTextView"));
//        ClickUIElementByID(AppId("replayButton");
//        //minus 10 from startTime
//        startTime = addTimetoPlaybackTime(startTime,-10,0);
//        verifyText(startTime,WebElementById(AppId("currentPositionTextView"));
    }

    //assert the Nav bar
    public void assertNavBar(String appTitle, String title1, String title2, String title3, String title4, String title5, String title6, Boolean close) throws Exception{

        //Click  Toolbar
        ClickUIElementByID(Org + AppName + "." + BuildType + ":id/ToolbarTitleTextView");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText(appTitle, false));
        if (title1 != ""){
            assertElementExistsBy(WebElementsByText(title1, false));
            if (title2 != ""){
                assertElementExistsBy(WebElementsByText(title2, false));
                if (title3 != ""){
                    assertElementExistsBy(WebElementsByText(title3, false));
                    if (title4 != ""){
                        assertElementExistsBy(WebElementsByText(title4, false));
                        if (title5 != ""){
                            assertElementExistsBy(WebElementsByText(title5, false));
                            if (title6 != ""){
                                assertElementExistsBy(WebElementsByText(title6, false));
                            }
                        }
                    }
                }
            }
        }

        if (close) {
            //Dismiss the toolbar
            ClickUIElementByID(Org + AppName + "." + BuildType + ":id/ToolbarTitleTextView");
            Thread.sleep(milliseconds_1);
        }
    }

    //assert JustServe  menu
    public void assertJustServeMenu (String screen, Boolean close) throws Exception {

        if (screen == "JustServe") {
            assertElementExistsBy(WebElementsById(AppId("bottomNavigation")));

            assertElementExistsBy(WebElementsByText("Projects",false));
            ClickUIElementByText("Projects", false);
            assertElementExistsBy(WebElementsById(AppId("projects_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Projects", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Organizations",false));
            ClickUIElementByText("Organizations", false);
            assertElementExistsBy(WebElementsById(AppId("organizations_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Organizations", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Volunteered",false));
            ClickUIElementByText("Volunteered", false);
            assertElementExistsBy(WebElementsById(AppId("volunteered_projects_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Volunteered", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Favorites",false));
            ClickUIElementByText("Favorites", false);
            assertElementExistsBy(WebElementsById(AppId("favoritesFragment")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Favorites", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Profile",false));
            ClickUIElementByText("Profile", false);
            assertElementExistsBy(WebElementsById(AppId("profile_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Profile", WebElementById(AppId("largeLabel")),false);
        }  else {
            fail(screen + " is not a valid option for assertJustServeMenu." +
                    "Available screens are:" +
                    "Projects" +
                    "Organizations" +
                    "Volunteered" +
                    "Favorites" +
                    "Profile");
        }
    }

    //assert GospelForKids  menu
    public void assertGospelForKidsMenu (String screen, Boolean close) throws Exception {

        if (screen == "GospelForKids") {
            assertElementExistsBy(WebElementsById(AppId("bottomNavigation")));

            assertElementExistsBy(WebElementsByText("Projects",false));
            ClickUIElementByText("Projects", false);
            assertElementExistsBy(WebElementsById(AppId("projects_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Projects", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Organizations",false));
            ClickUIElementByText("Organizations", false);
            assertElementExistsBy(WebElementsById(AppId("organizations_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Organizations", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Volunteered",false));
            ClickUIElementByText("Volunteered", false);
            assertElementExistsBy(WebElementsById(AppId("volunteered_projects_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Volunteered", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Favorites",false));
            ClickUIElementByText("Favorites", false);
            assertElementExistsBy(WebElementsById(AppId("favoritesFragment")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Favorites", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Profile",false));
            ClickUIElementByText("Profile", false);
            assertElementExistsBy(WebElementsById(AppId("profile_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Profile", WebElementById(AppId("largeLabel")),false);
        }  else {
            fail(screen + " is not a valid option for assertJustServeMenu." +
                    "Available screens are:" +
                    "Projects" +
                    "Organizations" +
                    "Volunteered" +
                    "Favorites" +
                    "Profile");
        }
    }

    //assert FIR  menu
    public void assertFIRMenu (String screen, Boolean close) throws Exception {

        if (screen == "FIR") {
            assertElementExistsBy(WebElementsById(AppId("bottomNavigation")));

            assertElementExistsBy(WebElementsByText("Projects",false));
            ClickUIElementByText("Projects", false);
            assertElementExistsBy(WebElementsById(AppId("projects_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Projects", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Organizations",false));
            ClickUIElementByText("Organizations", false);
            assertElementExistsBy(WebElementsById(AppId("organizations_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Organizations", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Volunteered",false));
            ClickUIElementByText("Volunteered", false);
            assertElementExistsBy(WebElementsById(AppId("volunteered_projects_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Volunteered", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Favorites",false));
            ClickUIElementByText("Favorites", false);
            assertElementExistsBy(WebElementsById(AppId("favoritesFragment")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Favorites", WebElementById(AppId("largeLabel")),false);

            assertElementExistsBy(WebElementsByText("Profile",false));
            ClickUIElementByText("Profile", false);
            assertElementExistsBy(WebElementsById(AppId("profile_nav")));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/icon"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/labelGroup"));
            assertElementExistsBy(WebElementsById(AppId("largeLabel")));
            verifyText("Profile", WebElementById(AppId("largeLabel")),false);
        }  else {
            fail(screen + " is not a valid option for assertJustServeMenu." +
                    "Available screens are:" +
                    "Projects" +
                    "Organizations" +
                    "Volunteered" +
                    "Favorites" +
                    "Profile");
        }
    }

    //assert Projects screen
    public void assertProjectsScreen(boolean empty)throws Exception{
        assertElementExistsBy(WebElementsByText("Projects",false));
        ClickUIElementByText("Projects", false);
        //Top elements
        assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
        assertElementExistsBy(WebElementsById("android:id/content"));
        assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("Toolbar")));
        assertElementExistsBy(WebElementsById(AppId("appBarContent")));
        assertElementExistsBy(WebElementsById(AppId("toolbar")));
        assertElementExistsBy(WebElementsById(AppId("jsLogo")));
        assertElementExistsBy(WebElementsById(AppId("searchTermsBar")));
        assertElementExistsBy(WebElementsById(AppId("searchCardView")));
        assertElementExistsBy(WebElementsById(AppId("searchCardConstraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("searchHintLabel")));
        verifyText("Search Organizations", WebElementById(AppId("searchHintLabel")),false);
        assertElementExistsBy(WebElementsById(AppId("searchSummaryLabel")));
        assertElementExistsBy(WebElementsById(AppId("searchIcon")));

        // elements
        assertElementExistsBy(WebElementsById(AppId("navHostFragmentContainer")));
        assertElementExistsBy(WebElementsById(AppId("contentCoordinatorLayout")));
        assertElementExistsBy(WebElementsById(AppId("filtersAppBarLayout")));
        assertElementExistsBy(WebElementsById(AppId("pullRefreshLayout")));
        assertElementExistsBy(WebElementsById(AppId("contentConstraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("projectsRecyclerView")));

        if (empty) {
            assertElementExistsBy(WebElementsById(AppId("emptyStateView")));
            assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
            verifyText("Project Search", WebElementById(AppId("emptyStateTitleTextView")),false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
            verifyText("Search for projects close to you or use the search option above", WebElementById(AppId("emptyStateSubTitleTextView")),false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateButton")));
            verifyText("SEARCH NEARBY", WebElementById(AppId("emptyStateButton")),true);
        }
        assertElementExistsBy(WebElementsById(AppId("bottomNavigation")));
    }

    //assert Organizations screen
    public void assertOrganizationsScreen(boolean empty)throws Exception{
        assertElementExistsBy(WebElementsByText("Organizations",false));
        ClickUIElementByText("Organizations", false);
        //Top elements
        assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
        assertElementExistsBy(WebElementsById("android:id/content"));
        assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("Toolbar")));
        assertElementExistsBy(WebElementsById(AppId("appBarContent")));
        assertElementExistsBy(WebElementsById(AppId("toolbar")));
        assertElementExistsBy(WebElementsById(AppId("jsLogo")));
        assertElementExistsBy(WebElementsById(AppId("searchTermsBar")));
        assertElementExistsBy(WebElementsById(AppId("searchCardView")));
        assertElementExistsBy(WebElementsById(AppId("searchCardConstraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("searchHintLabel")));
        verifyText("Search Organizations", WebElementById(AppId("searchHintLabel")),false);
        assertElementExistsBy(WebElementsById(AppId("searchSummaryLabel")));
        assertElementExistsBy(WebElementsById(AppId("searchIcon")));

        // elements
        assertElementExistsBy(WebElementsByResourceId(AppId("navHostFragmentContainer")));
        assertElementExistsBy(WebElementsById(AppId("contentCoordinatorLayout")));
        assertElementExistsBy(WebElementsById(AppId("filtersAppBarLayout")));
        assertElementExistsBy(WebElementsById(AppId("pullRefreshLayout")));
        assertElementExistsBy(WebElementsById(AppId("contentConstraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("organizationsRecyclerView")));

        if (empty) {
            assertElementExistsBy(WebElementsById(AppId("emptyStateView")));
            assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
            verifyText("Organization Search", WebElementById(AppId("emptyStateTitleTextView")),false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
            verifyText("Search for organizations close to you or use the search option above", WebElementById(AppId("emptyStateSubTitleTextView")),false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateButton")));
            verifyText("SEARCH NEARBY", WebElementById(AppId("emptyStateButton")),true);
        }
        assertElementExistsBy(WebElementsById(AppId("bottomNavigation")));
    }

    //assert Volunteered screen
    public void assertVolunteeredScreen(boolean empty)throws Exception{
        assertElementExistsBy(WebElementsByText("Volunteered",false));
        ClickUIElementByText("Volunteered", false);
        //Top elements
        assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
        assertElementExistsBy(WebElementsById("android:id/content"));
        assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("Toolbar")));
        assertElementExistsBy(WebElementsById(AppId("appBarContent")));
        assertElementExistsBy(WebElementsById(AppId("toolbar")));
        assertElementExistsBy(WebElementsById(AppId("jsLogo")));

        // elements
        assertElementExistsBy(WebElementsByResourceId(AppId("navHostFragmentContainer")));
        assertElementExistsBy(WebElementsByResourceId(AppId("constraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("swipeRefreshLayout")));
        assertElementExistsBy(WebElementsById(AppId("recyclerView")));

        if (empty) {
            assertElementExistsBy(WebElementsById(AppId("emptyStateScrollView")));
            assertElementExistsBy(WebElementsById(AppId("emptyStateView")));
            assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
            verifyText("Please Sign In", WebElementById(AppId("emptyStateTitleTextView")),false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
            verifyText("Sign in to see your volunteered projects.", WebElementById(AppId("emptyStateSubTitleTextView")),false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateButton")));
            verifyText("SIGN IN", WebElementById(AppId("emptyStateButton")),true);
        }
        assertElementExistsBy(WebElementsById(AppId("bottomNavigation")));
    }

    //assert Favorites screen
    public void assertFavoritesScreen(boolean empty)throws Exception{
        assertElementExistsBy(WebElementsByText("Favorites",false));
        ClickUIElementByText("Favorites", false);
        //Top elements
        assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
        assertElementExistsBy(WebElementsById("android:id/content"));
        assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("Toolbar")));
        assertElementExistsBy(WebElementsById(AppId("appBarContent")));
        assertElementExistsBy(WebElementsById(AppId("toolbar")));
        assertElementExistsBy(WebElementsById(AppId("jsLogo")));

        ///Tabs elements
        assertElementExistsBy(WebElementsByResourceId(AppId("navHostFragmentContainer")));
        assertElementExistsBy(WebElementsById(AppId("favoritesSectionsTabLayout")));
        //Projects tab
        assertElementExistsBy(WebElementsByXpath("//android.widget.LinearLayout[@content-desc=\"Projects\"]"));
        assertElementExistsBy(WebElementsByXpath("//android.widget.LinearLayout[@content-desc=\"Projects\"]/android.widget.TextView"));
        verifyText("PROJECTS", WebElementByXpath("//android.widget.LinearLayout[@content-desc=\"Projects\"]/android.widget.TextView"),true);
        //Organizations tab
        assertElementExistsBy(WebElementsByXpath("//android.widget.LinearLayout[@content-desc=\"Organizations\"]"));
        assertElementExistsBy(WebElementsByXpath("//android.widget.LinearLayout[@content-desc=\"Organizations\"]/android.widget.TextView"));
        verifyText("ORGANIZATIONS", WebElementByXpath("//android.widget.LinearLayout[@content-desc=\"Organizations\"]/android.widget.TextView"),true);

        // elements
        assertElementExistsBy(WebElementsById(AppId("viewPager")));
        assertElementExistsBy(WebElementsById(AppId("swipeRefreshLayout")));
        assertElementExistsBy(WebElementsById(AppId("recyclerView")));

        if (empty) {
            assertElementExistsBy(WebElementsById(AppId("emptyStateView")));
            assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
            verifyText("Please Sign In", WebElementById(AppId("emptyStateTitleTextView")),false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
            verifyText("Sign in to see your favorite projects.", WebElementById(AppId("emptyStateSubTitleTextView")),false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateButton")));
            verifyText("SIGN IN", WebElementById(AppId("emptyStateButton")),true);
        }
        assertElementExistsBy(WebElementsById(AppId("bottomNavigation")));
    }

    //assert JustServe Profile screen
    public void assertProfileMenu(String screen, String themeOption) throws Exception {
        assertElementExistsBy(WebElementsByText("Profile",false));
        ClickUIElementByText("Profile", false);
        //Top elements
        assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
        assertElementExistsBy(WebElementsById(AndroidId("content")));
        assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("mainToolbar")));
        assertElementExistsBy(WebElementsById(AppId("appBarContent")));
        assertElementExistsBy(WebElementsById(AppId("toolbar")));
        assertElementExistsBy(WebElementsById(AppId("jsLogo")));
        assertElementExistsBy(WebElementsById(AppId("menu_item_sign_in_out")));
        verifyText("SIGN IN", WebElementById(AppId("menu_item_sign_in_out")),true);

        // elements
        assertElementExistsBy(WebElementsById("element[attribute='65270b6b-08a5-4d8d-b279-65b60b25f7b4']"));
        assertElementExistsBy(WebElementsById("element[attribute='b203fecc-a3f8-4c75-9754-51fbd003730e']"));
        assertElementExistsBy(WebElementsByResourceId(AppId(String.valueOf("navHostFragmentContainer".indexOf(1)))));
        assertElementExistsBy(WebElementsByResourceId(AppId(String.valueOf("navHostFragmentContainer".indexOf(0)))));
        assertElementExistsBy(WebElementsByResourceId(AppId("navHostFragmentContainer")));
        assertElementExistsBy(WebElementsById(AndroidId("list_container")));
        assertElementExistsBy(WebElementsById(AppId("recycler_view")));

        //Display menu
        assertElementExistsBy(WebElementsByTextContains("Display"));
        verifyText("Display",  WebElementByTextContains("Display", false), false);
        assertElementExistsBy(WebElementsById("element[attribute='f7ab3e2d-3534-4104-b241-3e841c21680a']"));
        verifyText("Display", (WebElement) WebElementsById("element[attribute='f7ab3e2d-3534-4104-b241-3e841c21680a']"), false);
        //Display options
        assertElementExistsBy(WebElementsByTextContains("Theme"));
        verifyText("Theme", WebElementByTextContains("Theme", false), false);
        //Theme sub text
        switch (themeOption) {
            case "System Default":
                assertElementExistsBy(WebElementsByTextContains(themeOption));
                verifyText("System Default", WebElementByTextContains(themeOption, false), false);
                break;
            case "Light":
                assertElementExistsBy(WebElementsByTextContains(themeOption));
                verifyText("Light", WebElementByTextContains(themeOption, false), false);
                break;
            case "Dark":
                assertElementExistsBy(WebElementsByTextContains(themeOption));
                verifyText("Dark", WebElementByTextContains(themeOption, false), false);
                break;
        }

        //About menu
        assertElementExistsBy(WebElementsByTextContains("About"));
        verifyText("About",  WebElementByTextContains("About", false), false);
        //About options
        //About JustServe option
        assertElementExistsBy(WebElementsByTextContains("About JustServe"));
        verifyText("About JustServe",  WebElementByTextContains("About GospelForKids", false), false);
        //About Send Feedback option
        assertElementExistsBy(WebElementsByTextContains("Send Feedback"));
        verifyText("Send Feedback",  WebElementByTextContains("Send Feedback", false), false);

        assertElementExistsBy(WebElementsById(AppId("bottomNavigation")));
    }

    //assert GospelForKids Settings screen
    public void assertGospelForKidsSettingsMenu(String screen, String themeOption) throws Exception {
        assertElementExistsBy(WebElementsByText("Settings",false));
        ClickUIElementByText("Settings", false);
        //Top elements
        assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
        assertElementExistsBy(WebElementsById(AndroidId("content")));
        assertElementExistsBy(WebElementsById(AppId("toolbar")));
        assertElementExistsBy(WebElementsByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
        assertElementExistsBy(WebElementsByAccessibilityId(AppId("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")));
        verifyText("About", (WebElement) WebElementsByAccessibilityId("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"),true);
        assertElementExistsBy(WebElementsById(AppId("about_info")));

        // elements
        assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
        assertElementExistsBy(WebElementsById(AppId("aboutRecyclerView")));

        //Additional Info menu
        assertElementExistsBy(WebElementsByTextContains("Additional Info"));
        verifyText("Additional Info",  WebElementByTextContains("Additional Info", false), false);
        //Featured Apps option
        assertElementExistsBy(WebElementsByTextContains("Featured Apps"));
        verifyText("Featured Apps",  WebElementByTextContains("Featured Apps", false), false);
        //About option
        assertElementExistsBy(WebElementsByTextContains("About"));
        verifyText("About",  WebElementByTextContains("About GospelForKids", false), false);
        //Version text
        assertElementExistsBy(WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[11]/android.widget.RelativeLayout/android.widget.TextView[2]"));
        verifyText(versionNumber,  WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[11]/android.widget.RelativeLayout/android.widget.TextView[2]"), false);
    }

    //assert FIR Settings screen
    public void assertFIRSettingsMenu(String screen, String themeOption) throws Exception {
        assertElementExistsBy(WebElementsByText("Settings",false));
        ClickUIElementByText("Settings", false);
        //Top elements
        assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
        assertElementExistsBy(WebElementsById(AndroidId("content")));
        assertElementExistsBy(WebElementsById(AppId("parentView")));
        assertElementExistsBy(WebElementsById(AppId("appbar")));
        assertElementExistsBy(WebElementsById(AppId("mainToolbar")));
        assertElementExistsBy(WebElementsByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
        assertElementExistsBy(WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
        verifyText("Settings", (WebElement) WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"),true);

        // elements
        assertElementExistsBy(WebElementsByResourceId(AppId("fragmentFrameLayout")));
        assertElementExistsBy(WebElementsById(AndroidId("list_container")));
        assertElementExistsBy(WebElementsById(AppId("recycler_view")));

        //Account menu
        assertElementExistsBy(WebElementsByTextContains("Account"));
        verifyText("Account",  WebElementByTextContains("Account", false), false);
        //Username option
        //TODO get username by database query
        assertElementExistsBy(WebElementsByTextContains(testUser1UserName));
        verifyText(testUser1UserName,  WebElementByTextContains(testUser1UserName, false), false);

        //Issue Options menu
        assertElementExistsBy(WebElementsByTextContains("Issue Options"));
        verifyText("Issue Options", WebElementByTextContains("Issue Options", false), false);
        //Closed Issue History option
        assertElementExistsBy(WebElementsByTextContains("Closed Issue History"));
        verifyText("Closed Issue History", WebElementByTextContains("Closed Issue History", false), false);
        //Notifications option
        assertElementExistsBy(WebElementsByTextContains("Notifications"));
        verifyText("Notifications", WebElementByTextContains("Notifications", false), false);

        //Help menu
        assertElementExistsBy(WebElementsByTextContains("Help"));
        verifyText("Help", WebElementByTextContains("Help", false), false);
        //Contact Us option
        assertElementExistsBy(WebElementsByTextContains("Contact Us"));
        verifyText("Contact Us", WebElementByTextContains("Contact Us", false), false);
        //Send Feedback option
        assertElementExistsBy(WebElementsByTextContains("Send Feedback"));
        verifyText("Send Feedback", WebElementByTextContains("Send Feedback", false), false);

        //Additional Info menu
        assertElementExistsBy(WebElementsByTextContains("Additional Info"));
        verifyText("Additional Info",  WebElementByTextContains("Additional Info", false), false);
        //Featured Apps option
        assertElementExistsBy(WebElementsByTextContains("Featured Apps"));
        verifyText("Featured Apps",  WebElementByTextContains("Featured Apps", false), false);
        //About option
        assertElementExistsBy(WebElementsByTextContains("About"));
        verifyText("About",  WebElementByTextContains("About GospelForKids", false), false);
        //Version text
        assertElementExistsBy(WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[11]/android.widget.RelativeLayout/android.widget.TextView[2]"));
        verifyText(versionNumber,  WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[11]/android.widget.RelativeLayout/android.widget.TextView[2]"), false);
    }

    //assert Theme Options menu
    public void assertThemeOptions(String screen, Boolean close) throws Exception {
        assertElementExistsBy(WebElementsByText("Profile",false));
        ClickUIElementByText("Profile", false);
        scrollDownTo("Theme");
        assertElementExistsBy(WebElementsByText("Theme", false));
        ClickUIElementByText("Theme", false);
        //Top elements
        assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
        assertElementExistsBy(WebElementsById("android:id/content"));
        assertElementExistsBy(WebElementsById(AppId("parentPanel")));
        assertElementExistsBy(WebElementsById(AppId("topPanel")));
        assertElementExistsBy(WebElementsById(AppId("title_template")));
        assertElementExistsBy(WebElementsById(AppId("alertTitle")));
        verifyText("Theme", WebElementById(AppId("alertTitle")),false);
        assertElementExistsBy(WebElementsById(AppId("titleDividerNoCustom")));
        //Content panel elements
        assertElementExistsBy(WebElementsById(AppId("contentPanel")));
        assertElementExistsBy(WebElementsById(AppId("select_dialog_listview")));
        assertElementExistsBy(WebElementsByText("System Default", false));
        verifyText("System Default", WebElementByTextContains("System Default", false), false);
        assertElementExistsBy(WebElementsByText("Light", false));
        verifyText("Light", WebElementByTextContains("Light", false), false);
        assertElementExistsBy(WebElementsByText("Dark", false));
        verifyText("Dark", WebElementByTextContains("Dark", false), false);
        //Button panel elements
        assertElementExistsBy(WebElementsById(AppId("buttonPanel")));
        assertElementExistsBy(WebElementsById("android:id/button2"));
        verifyText("Theme", WebElementById("android:id/button2"), true);
    }

    //assert JustServe Profile/About menu
    public void assertJustServeAboutMenu(String screen, Boolean close) throws Exception {
        //Launch profile screen
        assertElementExistsBy(WebElementsByText("Profile",false));
        ClickUIElementByText("Profile", false);
        //Launch JustServe Profile/About screen
        assertElementExistsBy(WebElementsByAccessibilityId("About JustServe"));
        ClickUIElementByAccessibilityID("About JustServe");

        if (screen == "About JustServe") {
            //Top elements
            assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
            assertElementExistsBy(WebElementsById("android:id/content"));
            assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
            assertElementExistsBy(WebElementsById(AppId("Toolbar")));
            assertElementExistsBy(WebElementsById(AppId("appBarContent")));
            assertElementExistsBy(WebElementsById(AppId("toolbar")));
            assertElementExistsBy(WebElementsByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
            assertElementExistsBy(WebElementsById(AppId("jsLogo")));
            assertElementExistsBy(WebElementsById(AppId("menu_item_sign_in_out")));
            verifyText("SIGN IN", WebElementById(AppId("menu_item_sign_in_out")),true);

            // elements
            assertElementExistsBy(WebElementsByResourceId(AppId("navHostFragmentContainer")));
            assertElementExistsBy(WebElementsById("android:id/list_container"));
            assertElementExistsBy(WebElementsById(AppId("recycler_view")));

            //Display menu
            assertElementExistsBy(WebElementsByText("Success Stories", false));
            assertElementExistsBy(WebElementsByText("Privacy Policy", false));
            assertElementExistsBy(WebElementsByText("Updated May 20, 2021", false));
            assertElementExistsBy(WebElementsByText("Terms Of Use", false));
            assertElementExistsBy(WebElementsByText("Updated April 14, 2021", false));
            assertElementExistsBy(WebElementsByText("Acknowledgements", false));
            assertElementExistsBy(WebElementsByText("Learn more about JustServe", false));
            assertElementExistsBy(WebElementsByText("Version", false));
            assertElementExistsBy(WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[6]/android.view.ViewGroup/android.widget.TextView[2]"));
            assertElementExistsBy(WebElementsById(AppId("logo")));
            assertElementExistsBy(WebElementsById(AppId("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")));
            verifyText("© 2021 by Intellectual Reserve, Inc. All rights reserved.", WebElementById(AppId("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")),true);
        } else {
            fail(screen + " is not a valid option for assertMoreOptionsMenu." +
                    "Available options are:" +
                    "Back Button" +
                    "Info Button" +
                    "Success Stories" +
                    "Privacy Policy" +
                    "Terms Of Use" +
                    "Acknowledgements" +
                    "Learn more about JustServe");
        }
    }

    //assert GospelForKids Settings/About menu
    public void assertGospelForKidsAboutMenu(String screen, Boolean close) throws Exception {
        //Launch profile screen
        assertElementExistsBy(WebElementsByText("Settings",false));
        ClickUIElementByText("Settings", false);
        //Launch GospelForKids Settings/About screen
        assertElementExistsBy(WebElementsByAccessibilityId("About"));
        ClickUIElementByAccessibilityID("About");

        if (screen == "About") {
            //Top elements
            assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
            assertElementExistsBy(WebElementsById(AndroidId("content")));
            assertElementExistsBy(WebElementsById(AppId("toolbar")));
            assertElementExistsBy(WebElementsByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
            assertElementExistsBy(WebElementsByAccessibilityId(AppId("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")));
            verifyText("About", (WebElement) WebElementsByAccessibilityId("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"),true);
            assertElementExistsBy(WebElementsById(AppId("about_info")));

            // elements
            assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
            assertElementExistsBy(WebElementsById(AppId("aboutRecyclerView")));

            //Display menu
            assertElementExistsBy(WebElementsByText("Terms Of Use", false));
            assertElementExistsBy(WebElementsByText("Updated 2021-04-13", false));
            assertElementExistsBy(WebElementsByText("Privacy Notice", false));
            assertElementExistsBy(WebElementsByText("Updated 2021-04-06", false));
            assertElementExistsBy(WebElementsByText("Acknowledgements", false));
            assertElementExistsBy(WebElementsById(AppId("aboutLogo")));
            assertElementExistsBy(WebElementsById(AppId("aboutCopyright")));
            verifyText("© 2021 by Intellectual Reserve, Inc. All rights reserved.", WebElementById(AppId("aboutCopyright")),true);

        } else {
            fail(screen + " is not a valid option for assertMoreOptionsMenu." +
                    "Available options are:" +
                    "Back Button" +
                    "Info Button" +
                    "Terms Of Use" +
                    "Privacy Notice" +
                    "Acknowledgements");
        }
    }

    //assert FIR Settings/About menu
    public void assertFIRAboutMenu(String screen, Boolean close) throws Exception {
        //Launch profile screen
        assertElementExistsBy(WebElementsByText("Settings",false));
        ClickUIElementByText("Settings", false);
        //Launch FIR Settings/About screen
        assertElementExistsBy(WebElementsByAccessibilityId("About"));
        ClickUIElementByAccessibilityID("About");

        if (screen == "About") {
            assertElementExistsBy(WebElementsById(AppId("action_bar_root")));
            assertElementExistsBy(WebElementsById(AndroidId("content")));
            assertElementExistsBy(WebElementsById(AppId("parentView")));
            assertElementExistsBy(WebElementsById(AppId("appbar")));
            assertElementExistsBy(WebElementsById(AppId("mainToolbar")));
            assertElementExistsBy(WebElementsByXpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
            assertElementExistsBy(WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
            verifyText("About", (WebElement) WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"),true);
            assertElementExistsBy(WebElementsById(AppId("about_info")));

            // elements
            assertElementExistsBy(WebElementsById(AppId("fragmentFrameLayout")));
            assertElementExistsBy(WebElementsById(AppId("constraintLayout")));
            assertElementExistsBy(WebElementsById(AppId("aboutRecyclerView")));

            //Display menu
            assertElementExistsBy(WebElementsByText("Terms Of Use", false));
            assertElementExistsBy(WebElementsByText("Updated 2021-04-13", false));
            assertElementExistsBy(WebElementsByText("Privacy Notice", false));
            assertElementExistsBy(WebElementsByText("Updated 2021-04-06", false));
            assertElementExistsBy(WebElementsByText("Acknowledgements", false));
            assertElementExistsBy(WebElementsById(AppId("aboutLogo")));
            assertElementExistsBy(WebElementsById(AppId("aboutCopyright")));
            verifyText("© 2021 by Intellectual Reserve, Inc. All rights reserved.", WebElementById(AppId("aboutCopyright")),true);
        } else {
            fail(screen + " is not a valid option for assertMoreOptionsMenu." +
                    "Available options are:" +
                    "Back Button" +
                    "Info Button" +
                    "Terms Of Use" +
                    "Privacy Notice" +
                    "Acknowledgements");
        }
    }

    //assert screen item options
    public void assertScreenItemOptions(String title, Boolean close) throws Exception {
        ClickUIElementByXpath("//android.widget.TextView[@text=\""+ title +"\"]/../../android.widget.ImageButton");
        assertElementExistsBy(WebElementsByText("Rename", false));
        assertElementExistsBy(WebElementsByText("Duplicate", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        if (close) {
            dismissDialog(WebElementByXpath("*//android.widget.FrameLayout"));
        }
    }

    //Change Text Size
    public void ChangeTextSize(String item, int sizeOneThroughSeven) throws Exception {
        assertElementExistsBy(WebElementsById(AppId(item)));
        ClickUIElementByID(AppId(item));
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Text Size");
        assertElementExistsBy(WebElementsByText("Text Size", false));
        ClickUIElementByText("Text Size", false);
        assertElementExistsBy(WebElementsById(Org + AppName + "." + BuildType + ":id/md_title"));
        verifyText("Text Size", WebElementById(Org + AppName + "." + BuildType + ":id/md_title"),false);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId(Org + AppName + "." + BuildType + ":id/sampleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/textSizeSeekbar"));
        ClickSeekBarAt(WebElementByResourceId(Org + AppName + "." + BuildType + ":id/textSizeSeekbar"), sizeOneThroughSeven);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/md_buttonDefaultNegative"));
        verifyText("Cancel", WebElementById(Org + AppName + "." + BuildType + ":id/md_buttonDefaultNegative"),true);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/md_buttonDefaultPositive"));
        verifyText("OK", WebElementById(Org + AppName + "." + BuildType + ":id/md_buttonDefaultPositive"),false);
        ClickUIElementByID(Org + AppName + "." + BuildType + ":id/md_buttonDefaultPositive");
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_2);
        driver.getPageSource();
    }

    //Change Theme
    public void ChangeTheme(String item, String Theme) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("item")));
        ClickUIElementByID(AppId("item"));
        scrollDownTo("Theme");
        assertElementExistsBy(WebElementsByText("Theme", false));
        ClickUIElementByText("Theme", false);
        assertElementExistsBy(WebElementsById(Org + AppName + "." + BuildType + ":id/alertTitle"));
        verifyText("Theme", WebElementById(Org + AppName + "." + BuildType + ":id/alertTitle"),false);
        assertElementExistsBy(WebElementsByCheckedText(Theme, false));
        ClickUIElementByCheckedText(Theme, false);
        ClickUIElementByText("Theme", false);

        Boolean ThemeSystemDefault = Boolean.parseBoolean(WebElementByCheckedText("System Default").getAttribute("checked"));
        Boolean ThemeLight = Boolean.parseBoolean(WebElementByCheckedText("Light").getAttribute("checked"));
        Boolean ThemeDark = Boolean.parseBoolean(WebElementByCheckedText("Dark").getAttribute("checked"));
        switch (Theme.toLowerCase()) {
            case "system default":
                assert ThemeSystemDefault;
                assert ThemeLight;
                assert ThemeDark;
                break;
            case "light":
                assert ThemeSystemDefault;
                assert ThemeLight;
                assert ThemeDark;
                break;
            case "dark":
                assert ThemeSystemDefault;
                assert ThemeLight;
                assert ThemeDark;
                break;
        }

        ClickUIElementByCheckedText(Theme, false);
        ClickUIElementByID("android:id/button2");
    }

    //assert downloads screen
    public void assertDownloadScreen(boolean empty) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("ToolbarTitleTextView")));
        verifyText("Downloaded Media", WebElementById(AppId("ToolbarTitleTextView")), false);
        if (empty) {
            assertElementExistsBy(WebElementsById(AppId("emptyStateImageView")));
            assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
            verifyText("No Downloaded Media", WebElementById(AppId("emptyStateTitleTextView")), false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
            verifyText("Download audio or video for offline access.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        }
    }

    //Assert Download Audio Popup
    public void assertDownloadAudioPopup(String title, Boolean download) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_icon_title")));
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Download Audio", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText(title, WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Download", WebElementById(AppId("md_button_positive")), true);
        if (download) {
            ClickUIElementByID(AppId("md_button_positive"));
        } else {
            ClickUIElementByID(AppId("md_button_negative"));
        }
    }

    //Hide on screen keyboard
    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    //Scroll to
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

    //Scroll to
    public void scrollDownToWithMaxScroll(String text, int MaxScroll) {
        Boolean isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")).size() <= 0;
        int i = 0;
        while ((isNotPresent)) {
            if (i == MaxScroll) {
                fail("The item was not found on the screen within " + i + " downward scrolls");
                break;
            }
            System.out.println("" + text + " isn't on the screen... Scrolling to find");
            System.out.println("Scroll " + i + " of " + MaxScroll);
            scrollDown();
            isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).size() <= 0;
            i = i + 1;
        }
    }

    //Scroll to by Resource id
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

    //Scroll to by id
    public void scrollToById(String id) throws Exception {
        System.out.println("Scrolling to: " + id);
        WebElement idIsPresent = WebElementById(id);
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

    //Scroll to by
    public void scrollToBy(WebElement TempElement) {
        System.out.println(TempElement);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = TempElement.getLocation().getY();
        System.out.println("Screen Height is " + screenHeight + "");
        System.out.println("upper Y is " + upperY + "");
        while (upperY >= screenHeight / 2) {
            System.out.println("scrolling down y '" + upperY + "' is >= " + screenHeight / 2 + "");
            scrollDown();
            upperY = TempElement.getLocation().getY();
        }
        while (upperY <= screenHeight / 8) {
            System.out.println("scrolling up y '" + upperY + "' is <= " + screenHeight / 8 + "");
            scrollUp();
            upperY = TempElement.getLocation().getY();
        }
    }

    //Swipe to by coordinates
    public void swipeByCoordinates(int fromX, int fromY, int toX, int toY) throws Exception {

        TouchAction action = new TouchAction(driver);
        System.out.println("Scrolling to: Bottom");Thread.sleep(10000);
//        action.longPress(550,1900).moveTo(550,1300).release();
        action.longPress(fromX, fromY)
//        .waitAction(new WaitOptions().withDuration(ofMillis(3000)))
                .moveTo(toX, toY)
                .release()
                .perform();
    }

    //Swipe left to by coordinates
    public void SwipeLeftByCoordinates(int fromX, int fromY, int toX, int toY) throws Exception {

        TouchAction action = new TouchAction(driver);
        System.out.println("Swiping left...");Thread.sleep(10000);
        action.longPress(fromX, fromY)
                .moveTo(toX, toY)
                .release()
                .perform();
    }

    //Swipe right to by coordinates
    public void SwipeRightByCoordinates(int fromX, int fromY, int toX, int toY) throws Exception {

        TouchAction action = new TouchAction(driver);
        System.out.println("Swiping right...");Thread.sleep(10000);
        action.longPress(fromX, fromY)
                .moveTo(toX, toY)
                .release()
                .perform();
    }

    //Swipe to by id
    public void swipeToById(String id) throws Exception {
        System.out.println("Swiping to: " + id);Thread.sleep(10000);
        WebElement idIsPresent = WebElementById(id);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = idIsPresent.getLocation().getY();
        System.out.println("Swiping Height is " + screenHeight + "");
        System.out.println("upper Y is " + upperY + "");
        if (upperY >= screenHeight / 2) {
            System.out.println("swiping down y '" + upperY + "' is >= " + screenHeight / 2 + "");
            swipeDown();
        }
    }

    //Swipe to by xpath
    public void swipeToByXpath(String xpath) throws Exception {
        System.out.println("Swiping to: " + xpath);Thread.sleep(10000);
        WebElement idIsPresent = WebElementByXpath(xpath);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = idIsPresent.getLocation().getY();
        System.out.println("Swiping Height is " + screenHeight + "");
        System.out.println("upper Y is " + upperY + "");
        if (upperY >= screenHeight / 2) {
            System.out.println("swiping down y '" + upperY + "' is >= " + screenHeight / 2 + "");
            swipeDown();
        }
    }

    //Verify Text
    public void verifyText(String expectedText, WebElement webelementActual, boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            expectedText = isAllCaps(expectedText);
        }
        String webelementActualAsText = webelementActual.getText();
        System.out.println("Validating text Expected: '" + expectedText + "' Actual: '" + webelementActualAsText + "'");
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        if (AndroidVersion < 6) {
            System.out.println("Android version is less than Android 6. Verifying that element contains expected text instead of verifying exact string.");
            Assert.assertTrue(webelementActualAsText.contains(expectedText));
        } else {
            Assert.assertEquals(expectedText, webelementActualAsText);
        }
    }

    //Verify Text Contains
    public void verifyTextContains(String expectedText, WebElement webelementActual, boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            expectedText = isAllCaps(expectedText);
        }
        String webelementActualAsText = webelementActual.getText();
        System.out.println("Validating text Expected: '" + expectedText + "' Actual: '" + webelementActualAsText + "'");
        Object AndroidVersionString = driver.getCapabilities().getCapability("platformVersion");
        AndroidVersion = Integer.parseInt((String) AndroidVersionString);
        try {
            if (AndroidVersion < 6) {
                System.out.println("Android version is less than Android 6. Verifying that element contains expected text instead of verifying exact string.");
                Assert.assertTrue(webelementActualAsText.contains(expectedText));
            } else {
                Assert.assertEquals(expectedText, webelementActualAsText);
            }
        } catch (Exception e) {
            System.out.println("Validating text Expected: \033[31mFailed\033[0m " + e);
        }
    }

    //Verify Attribute With Boolean
    public void verifyAttributeWithBoolean(WebElement theElement, String theAttributeToCheck, Boolean theValue) throws Exception {
        Boolean theActualValue = Boolean.valueOf(theElement.getAttribute(theAttributeToCheck));
        String strElementActual = "";
        String strElementValue = "";
        if (theActualValue == true)
        {
            strElementActual = "\033[32mtrue\033[0m";
        }
        else
        {
            strElementActual = "\033[31mfalse\033[0m";
        }
        if (theValue == true)
        {
            strElementValue = "\033[32mtrue\033[0m";
        }
        else
        {
            strElementValue = "\033[31mfalse\033[0m";
        }
        System.out.println("Checking the value of " + theAttributeToCheck + ". Expected: " + strElementValue + ", Actual: " + strElementActual);
        assert theActualValue == theValue;
    }

    //Verify Object Exists Using WebElementBy (String)
    public void assertElementExistsBy(String webElementBy) {
        Boolean tempElement = webElementBy.length() > 0;
        String strElementActual = "";
        if (tempElement == true)
        {
            strElementActual = "\033[32mtrue\033[0m";
        }
        else
        {
            strElementActual = "\033[31mfalse\033[0m";
        }
        System.out.println("Assert element is present. Expected: \033[32mtrue\033[0m [] Actual: " + strElementActual + " -" + " Element: " + webElementBy.toString() + "");
        if (tempElement == false) {
            System.out.println("Found " + webElementBy.length() + ". List of Elements Found: " + webElementBy);
        }
        assert tempElement == true;
    }

    //Verify Object Exists Using WebElementBy (WebElement)
    public void assertElementExistsByWebElement(WebElement webElementBy) {
        Boolean tempElement = webElementBy.isDisplayed();
        String strElementActual = "";
        if (tempElement == true)
        {
            strElementActual = "\033[32mtrue\033[0m";
        }
        else
        {
            strElementActual = "\033[31mfalse\033[0m";
        }
        System.out.println("Assert element is present. Expected: \033[32mtrue\033[0m [] Actual: " + strElementActual + " -" + " Element: " + webElementBy.toString() + "");
        if (tempElement == false) {
            System.out.println("Found " + webElementBy.isDisplayed() + ". List of Elements Found: " + webElementBy);
        }
        assert tempElement == true;
    }

    //Verify Object Exists Using WebElementsBy (List)
    public void assertElementExistsBy(List webElementsBy) {
        Boolean tempElement = webElementsBy.size() > 0;
        String strElementActual = "";
        if (tempElement == true)
        {
            strElementActual = "\033[32mtrue\033[0m";
        }
        else
        {
            strElementActual = "\033[31mfalse\033[0m";
        }
        System.out.println("Assert element is present. Expected: \033[32mtrue\033[0m [] Actual: " + strElementActual + " -" + " Element: " + webElementsBy.toString() + "");
        if (tempElement == false) {
            System.out.println("Found " + webElementsBy.size() + ". List of Elements Found: " + webElementsBy);
        }
        assert tempElement == true;
    }

//    //Verify Object Exists and scroll to it
//    public void assertAndScrollToElementExistsBy(List webElementsBy, WebElement webElementBy){
//        scrollToBy(webElementBy);
//        Boolean tempElement = webElementsBy.size() > 0;
//        System.out.println(""+webElementsBy.toString()+" "+tempElement+"");
//        assert tempElement == true;
//
//    }

    //Verify Object Does Not Exist Using WebElementsBy
    public void assertElementNotPresentBy(List webElementsBy) {
        Boolean tempElement = webElementsBy.size() > 0;
        System.out.println("assert element is not present. Expected: false [] Actual: " + tempElement + " " + webElementsBy.toString() + "");
        assert tempElement == false;
    }

    //Assert Settings Switch and toggle
    public void assertSettingsSwitchExpectedStateAndToggle(String SwitchTitle, Boolean ExpectedState) throws Exception {
        scrollDownTo(SwitchTitle);
        assertElementExistsBy(WebElementsByText(SwitchTitle, false));
        // Toggle on and off verification (doesn't check that the settings work, just checks that the toggle works
        // toggle verification is currently by xpath because no other identifier is available
        WebElement CurrentSettingsSwitch = WebElementSettingSwitchByText(SwitchTitle, false);
        Boolean CurrentSettingSwitchBool = Boolean.parseBoolean(CurrentSettingsSwitch.getAttribute("checked"));
        if (ExpectedState) {
            verifyText("ON", CurrentSettingsSwitch,false);
            assert CurrentSettingSwitchBool;
            CurrentSettingsSwitch.click();
            verifyText("OFF", CurrentSettingsSwitch,false);
            CurrentSettingSwitchBool = Boolean.parseBoolean(CurrentSettingsSwitch.getAttribute("checked"));
            assert !CurrentSettingSwitchBool;
        } else {
            verifyText("OFF", CurrentSettingsSwitch,false);
            assert CurrentSettingSwitchBool == false;
            CurrentSettingsSwitch.click();
            verifyText("ON", CurrentSettingsSwitch,false);
            CurrentSettingSwitchBool = Boolean.parseBoolean(CurrentSettingsSwitch.getAttribute("checked"));
            assert CurrentSettingSwitchBool == true;
        }
    }


    //Assert Settings Switch Persists
    public void assertSettingsSwitchExpectedStateAndTogglePersists(String SwitchTitle, Boolean ExpectedState) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        if (ExpectedState) {
            assertSettingsSwitchExpectedStateAndToggle(SwitchTitle, true);
            ClickUIElementByAccessibilityID("Navigate up");
            assertElementExistsBy(WebElementsByAccessibilityId("More options"));
            ClickUIElementByAccessibilityID("More options");
            assertElementExistsBy(WebElementsByText("Settings", false));
            ClickUIElementByText("Settings", false);
            assertSettingsSwitchExpectedStateAndToggle(SwitchTitle, false);
        } else {
            assertSettingsSwitchExpectedStateAndToggle(SwitchTitle, false);
            ClickUIElementByAccessibilityID("Navigate up");
            assertElementExistsBy(WebElementsByAccessibilityId("More options"));
            ClickUIElementByAccessibilityID("More options");
            assertElementExistsBy(WebElementsByText("Settings", false));
            ClickUIElementByText("Settings", false);
            assertSettingsSwitchExpectedStateAndToggle(SwitchTitle, true);
        }
    }

    //Assert Element In Webview Exact Count
    public void assertElementInWebviewExactCount(String xPath, int itemCount) throws Exception {
        driver.context("WEBVIEW_org.lds." + AppName + "." + BuildType + "");
        Set<java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        Boolean tempElement = false;

        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
            try {
                System.out.println("Count of elements in current window handle: " + WebElementsByXpath(xPath).size());
                Boolean webElementCount = (WebElementsByXpath(xPath).size() == itemCount);
                if (webElementCount) {
                    tempElement = true;
                    System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
                    break;
                } else {
                    System.out.println("WebElement not found in this context");
                    System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
                }
            } catch (Exception e) {
                System.out.println("Exception Occured");
            }
        }
        assert tempElement;
        driver.context("NATIVE_APP");
    }

    //Assert Element In Webview Exists By
    public void assertElementInWebviewExistsBy(String xPath) throws Exception {
        driver.context("WEBVIEW_org.lds." + AppName + "." + BuildType + "");
        Set<java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        Boolean tempElement = false;

        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
            try {
                System.out.println(WebElementsByXpath(xPath).size());
                Boolean webElementList = WebElementsByXpath(xPath).size() > 0;
                if (webElementList) {
                    tempElement = true;
                    System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
                } else {
                    System.out.println("WebElement not found in this context");
                    System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
                }
            } catch (Exception e) {
                System.out.println("Exception Occured");
                System.out.println("WebElement not found in this context");
                System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
            }

        }
        assert tempElement;
        log("Setting driver context back to NATIVE_APP");
        driver.context("NATIVE_APP");
    }

    //Assert Element In Webview Does Not Exist By
    public void assertElementInWebviewDoesNotExistBy(String xPath) throws Exception {
        driver.context("WEBVIEW_org.lds." + AppName + "." + BuildType + "");
        Set<java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
        }

        Boolean tempElement = WebElementsByXpathWebview(xPath).size() == 0;
        System.out.println("assert element is not present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
        assert tempElement;
        driver.context("NATIVE_APP");
    }

    //Verify Sign In Page
    public void signInPage(String LoginUserName, String LoginPassword, String button, Boolean validLogin)throws Exception{
        //Username field
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/ldsaccount_login_username_layout"));
        verifyText("Username",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/ldsaccount_login_username_layout"),false);
        assertElementExistsBy(WebElementsById(Org + AppName + "." + BuildType + ":id/usernameEditText"));
        //Password field
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/ldsaccount_login_password_layout"));
        verifyText("Password",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/ldsaccount_login_password_layout"),false);
        assertElementExistsBy(WebElementsById(Org + AppName + "." + BuildType + ":id/passwordEditText"));
        //Password visibility
        assertElementExistsBy(WebElementsByAccessibilityId("Toggle password visibility"));
        //Sign in Button
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/ldsAccountSignInButton"));
        verifyText("Sign In",WebElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/ldsAccountSignInButton\"]/android.widget.TextView"),true);
        //Having Trouble Signing In
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/ldsAccountLoginForgotCredentialsButton"));
        verifyText("Having Trouble Signing In?",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/ldsAccountLoginForgotCredentialsButton"),true);
        //Create LDS Account
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/ldsAccountLoginCreateAccountButton"));
        verifyText("Create LDS Account", WebElementByResourceId(Org + AppName + "." + BuildType + ":id/ldsAccountLoginCreateAccountButton"),true);



        sendText(Org + AppName + "." + BuildType + ":id/usernameEditText", LoginUserName);
        sendText(Org + AppName + "." + BuildType + ":id/passwordEditText", LoginPassword);
        boolean passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert !passwordVisibility;
        verifyText(hidePassword(LoginPassword), WebElementById(Org + AppName + "." + BuildType + ":id/passwordEditText"),false);
        ClickUIElementByAccessibilityID("Toggle password visibility");
        Thread.sleep(milliseconds_1);
        passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert passwordVisibility;
        verifyText(LoginPassword, WebElementById(Org + AppName + "." + BuildType + ":id/passwordEditText"),false);
        if (button == "Sign In"){
            if (validLogin){
                ClickUIElementByID(Org + AppName + "." + BuildType + ":id/ldsAccountSignInButton");
            } else {
                sendText(Org + AppName + "." + BuildType + ":id/passwordEditText", "MabelWasHere");
                ClickUIElementByID(Org + AppName + "." + BuildType + ":id/ldsAccountSignInButton");
                //appium can't validate ! if Username not entered and SignIn clicked
                Thread.sleep(milliseconds_1);
                verifyText("Error", WebElementByText("android.widget.TextView","Error", false),false);
                ClickUIElementByText("OK", false);
                sendText(Org + AppName + "." + BuildType + ":id/passwordEditText", LoginPassword);
                ClickUIElementByID(Org + AppName + "." + BuildType + ":id/ldsAccountSignInButton");
            }
        } else if (button == "Having Trouble Signing In") {
            //Having Trouble Signing in
            ClickUIElementByID(Org + AppName + "." + BuildType + ":id/ldsAccountLoginForgotCredentialsButton");
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/recovery", WebElementById("com.android.chrome:id/url_bar"),false);
        } else if (button.toLowerCase() == "Create LDS Account"){
            //Create LDS Account
            ClickUIElementByText("Create LDS Account", false);
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"),false);
        } else {
            fail("\"" + button + "\" is not a valid button for the Sign In Page. Valid entries are \"Sign In\", \"Having Trouble Signing In\", and \"Create LDS Account\"");
        }
    }

    //Assert Menu Bar
    public void assertMenuBar(String title, String subTitle, Boolean CheckNavigateUp) throws Exception {
        //assert menu bar
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/mainToolbar"));
        if (CheckNavigateUp) {
            assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        }
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/mainToolbarTextLayout"));
        if (CheckNavigateUp) {
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/dropArrowImageView"));
        }
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/mainToolbarTitleTextView"));
        verifyText(title, WebElementByResourceId(Org + AppName + "." + BuildType + ":id/mainToolbarTitleTextView"), false);
        if (CheckNavigateUp) {
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/mainToolbarSubTitleTextView"));
        }
        if (CheckNavigateUp) {
            verifyText(subTitle, WebElementByResourceId(Org + AppName + "." + BuildType + ":id/mainToolbarSubTitleTextView"), false);
        }
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
    }

    //Assert Side Bar
    public void assertSideBar(String title, Boolean isAnnotation, String annotationType, String TagName) throws Exception {
        //assert sidebar
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/contentDrawerToolbar"));
        //assert close icon
        assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/contentDrawerToolbar\"]/android.widget.ImageButton"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/contentDrawerToolbarTitleTextView"));
        verifyText(title,WebElementByResourceId(Org + AppName + "." + BuildType + ":id/contentDrawerToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsByAccessibilityId("Related Content"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView[@content-desc=\"More options\"])[2]"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/sideBarContainer"));
        if (isAnnotation) {
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/annotationView"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/lastModifiedTextView"));
        }
        if (annotationType == "Tag"){
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/bubbleLayout"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/bubbleTextView"));
            verifyText(TagName, WebElementByResourceId(Org + AppName + "." + BuildType + ":id/bubbleTextView"), false);
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/tag_text"));
        } else if (annotationType == ""){
        } else {
            fail(annotationType + " is not supported. Supported annotations are \"Tag\"");
        }
    }

    //Verify Sync Check
    public void SyncCheck(String buttonToPress) throws Exception {
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/md_title"));
        verifyText("Back Up Annotations",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/md_title"),false);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/md_content"));
        verifyText("Signing in with an LDS Account backs up all your highlights, notes, and bookmarks, keeping them safe and making them available on the web or any mobile device.",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/md_content"),false);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/md_buttonDefaultPositive"));
        verifyText("Sign In",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/md_buttonDefaultPositive"),true);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/md_buttonDefaultNegative"));
        verifyText("No Thanks",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/md_buttonDefaultNegative"),true);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/md_buttonDefaultNeutral"));
        verifyText("Create LDS Account", WebElementByResourceId(Org + AppName + "." + BuildType + ":id/md_buttonDefaultNeutral"), true);
        if (buttonToPress == "Sign In"){
            ClickUIElementByResourceID(Org + AppName + "." + BuildType + ":id/md_buttonDefaultPositive");
            signInPage(testUser1,testUser1Password,"Sign In",true);
        } else if (buttonToPress == "No Thanks"){
            ClickUIElementByResourceID(Org + AppName + "." + BuildType + ":id/md_buttonDefaultNegative");
        } else if (buttonToPress == "Create LDS Account"){
            ClickUIElementByResourceID(Org + AppName + "." + BuildType + ":id/md_buttonDefaultNeutral");
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"),false);
        } else {
            fail("\""+buttonToPress +"\" is not a valid selection. valid buttons are \"Sign In\", \"No Thanks\", and \"Create LDS Account\"");
        }

    }

    //Tap Paragraph
    public List TapParagraph(String id, int duration) throws Exception {

        WebElement element = WebElementByResourceId(id);
        int eHeight = element.getSize().getHeight();
        int eWidth = element.getSize().getWidth();
        int eUpperX = element.getLocation().x;
        int eUpperY = element.getLocation().y;
        driver.context("WEBVIEW_org.lds." + AppName + "." + BuildType + "");
        WebElement wElement = WebElementById(id);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        String script = "var s = getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);" +
                "return s;";

        String scriptReturnLineHeight = executor.executeScript(script, wElement, "line-height").toString();
        scriptReturnLineHeight = scriptReturnLineHeight.substring(0, (scriptReturnLineHeight.length() - 2));
        double LineHeight = Double.parseDouble(scriptReturnLineHeight);
        int scriptReturnLineHeightAsInt = (int) LineHeight;
        System.out.println(scriptReturnLineHeightAsInt);
        String scriptReturnFontHeight = executor.executeScript(script, wElement, "font-size").toString();
        scriptReturnFontHeight = scriptReturnFontHeight.substring(0, (scriptReturnFontHeight.length() - 2));
        double FontHeight = Double.parseDouble(scriptReturnFontHeight);
        int scriptReturnFontHeightAsInt = (int) FontHeight;
        System.out.println(scriptReturnFontHeightAsInt);
        driver.context("NATIVE_APP");
        int tapX = eUpperX + (eWidth / 5);
        int tapY = eUpperY + scriptReturnFontHeightAsInt + scriptReturnLineHeightAsInt;
        driver.tap(1, tapX, tapY, duration);
        List TapXYList = new ArrayList();
        TapXYList.add(tapX);
        TapXYList.add(tapY);
        return TapXYList;
    }

    //Get Location Of Tap Paragraph
    public List LocationOfTapParagraph(String id) throws Exception {
        WebElement element = WebElementByResourceId(id);
        int eHeight = element.getSize().getHeight();
        int eWidth = element.getSize().getWidth();
        int eUpperX = element.getLocation().x;
        int eUpperY = element.getLocation().y;
        driver.context("WEBVIEW_org.lds." + AppName + "." + BuildType + "");
        WebElement wElement = WebElementById(id);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        String script = "var s = getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);" +
                "return s;";

        String scriptReturnLineHeight = executor.executeScript(script, wElement, "line-height").toString();
        scriptReturnLineHeight = scriptReturnLineHeight.substring(0, (scriptReturnLineHeight.length() - 2));
        double LineHeight = Double.parseDouble(scriptReturnLineHeight);
        int scriptReturnLineHeightAsInt = (int) LineHeight;
        System.out.println(scriptReturnLineHeightAsInt);
        String scriptReturnFontHeight = executor.executeScript(script, wElement, "font-size").toString();
        scriptReturnFontHeight = scriptReturnFontHeight.substring(0, (scriptReturnFontHeight.length() - 2));
        double FontHeight = Double.parseDouble(scriptReturnFontHeight);
        int scriptReturnFontHeightAsInt = (int) FontHeight;
        System.out.println(scriptReturnFontHeightAsInt);
        driver.context("NATIVE_APP");
        int tapX = eUpperX + (eWidth / 5);
        int tapY = eUpperY + scriptReturnFontHeightAsInt + scriptReturnLineHeightAsInt;
        List TapXYList = new ArrayList();
        TapXYList.add(tapX);
        TapXYList.add(tapY);
        return TapXYList;
    }

    //Assert Choose Highlight Screen
    public void assertChooseHighlightScreen() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Choose Highlight", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
    }

    //Assert Remove Annotation Popup
    public void assertRemoveAnnotationPopup() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Remove Annotation", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("Any notes, tags, or links attached to this highlight will also be removed.", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Delete", WebElementById(AppId("md_button_positive")), true);
    }

    //******************************** Empty State assertions ***********************************
    //Assert Empty Note Text
    public void assertEmptyNoteText() throws Exception{
        verifyText("Note Title",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/noteTitleEditText"),false);
        String placeHolderText = WebElementByResourceId(Org + AppName + "." + BuildType + ":id/markdownEditText").getText();
        List defaultPlaceHolderText = new ArrayList();
        defaultPlaceHolderText.add("And it came to pass…");
        defaultPlaceHolderText.add("And thus we see…");
        defaultPlaceHolderText.add("And now, behold…");
        Boolean placeHolder;
        if (placeHolderText.contentEquals(defaultPlaceHolderText.get(0).toString()) || placeHolderText.contentEquals(defaultPlaceHolderText.get(1).toString()) || placeHolderText.contentEquals(defaultPlaceHolderText.get(2).toString())){
            placeHolder = true;
            System.out.println("Placeholder text was one of the preset values");
        } else {
            placeHolder = false;
            System.out.println("Placeholder text was not one of the three preset values");
        }
        assert placeHolder;
    }

    //Assert Empty State Tag Screen
    public void assertEmptyStateTagScreen() throws Exception{
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateImageView"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateTitleTextView"));
        verifyText("No Tags",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateTitleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateSubTitleTextView"));
        verifyText("Create a tag to group content from anywhere in the app.",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateSubTitleTextView"),false);
    }

    //Assert Empty State Add To Notebook Screen
    public void assertEmptyStateAddToNotebookScreen() throws Exception{
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateImageView"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateTitleTextView"));
        verifyText("No Notebooks",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateTitleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateSubTitleTextView"));
        verifyText("Create notebooks to collect and organize your notes for talks, lessons, and personal study.",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/emptyStateSubTitleTextView"),false);
    }

    //Assert Links Screen
    public void assertLinksScreen() throws Exception{
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Links",false));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/searchEditText"));
        verifyText("Search for keywords, verses, or titles.",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/searchEditText"),false);
    }

    //Assert Share Screen
    public void assertShareScreen() throws Exception{
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/ToolbarTitleTextView"));
        verifyText("Share",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/ToolbarTitleTextView"), false);
    }

    //Assert Search Screen
    public void assertSearchScreen() throws Exception{
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/backImageView"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/searchEditText"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/searchClearTextImageView"));
    }

    //Assert Highlight Style Screen
    public void assertHighlightStyleScreen() throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/Toolbar"));
        assertElementExistsBy(WebElementsByText("Highlight Style",false));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/textView2"));
        verifyText("Recent",WebElementByResourceId(Org + AppName + "." + BuildType + ":id/textView2"),true);
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/indicatorImageView"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/fillIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/underlineIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/clearIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/underlineView"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/highlightStyleImageView"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/redColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/orangeColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/yellowColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/greenColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/blueColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/darkBlueColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/purpleColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/pinkColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/brownColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/grayColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/recentSeparatorView"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/recent1ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/recent2ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/recent3ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/recent4ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/recent5ColorIndicator"));
    }

    //Assert Highlight Style Screen Style And Color
    public void assertHighlightStyleScreenStyleAndColor(String Style,String Color) throws Exception{
        if (Style == "solid"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/fillIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/indicatorImageView\"]"));
        } else if (Style == "underline"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/underlineIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/indicatorImageView\"]"));
        } else if (Style == "clear"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/clearIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/indicatorImageView\"]"));
            Color = "clear";
        } else {
            fail(Style + " is not a valid style. Valid styles are \"solid\" \"underline\" and \"clear\"");
        }

        if (Color == "red"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/redColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "orange"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/orangeColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "yellow"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/yellowColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "green"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/greenColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "blue"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/blueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "dark_blue"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/darkBlueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "purple") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/purpleColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "pink"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/pinkColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "brown"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/brownColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "gray") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/grayColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "clear"){
        }else {
            fail(Color + " is not a valid color. Valid colors are \"red\" \"orange\" \"yellow\" \"blue\" \"dark_blue\" \"purple\" \"pink\" \"brown\" \"gray\"");
        }
    }

    //Changing Highlight Color And Style
    public String ChangeHighlightColorAndStyle(String Style,String Color) throws Exception{
        if (Style == "solid"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/fillIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/fillIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/indicatorImageView\"]"));
            Style = "box";
        } else if (Style == "underline"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/underlineIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/underlineIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/indicatorImageView\"]"));
            Style = "underline";
        } else if (Style == "clear"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/clearIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/clearIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/indicatorImageView\"]"));
            Style = "box";
            Color = "clear";
        } else {
            fail(Style + " is not a valid style. Valid styles are \"solid\" \"underline\" and \"clear\"");
        }

        if (Color == "red"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/redColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/redColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "orange"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/orangeColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/orangeColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "yellow"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/yellowColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/yellowColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "green"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/greenColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/greenColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "blue"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/blueColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/blueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "dark_blue"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/darkBlueColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/darkBlueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "purple") {
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/purpleColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/purpleColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "pink"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/pinkColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/pinkColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "brown"){
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/brownColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/brownColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "gray") {
            ClickUIElementByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/grayColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/grayColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=" + Org + AppName + "." + BuildType + ":id/checkmarkImageView\"]"));
        } else if (Color == "clear"){
            System.out.println("Style was \"clear\" skipping color");
        } else {
            fail(Color + " is not a valid color. Valid colors are \"red\" \"orange\" \"yellow\" \"blue\" \"dark_blue\" \"purple\" \"pink\" \"brown\" \"gray\"");
        }
        String StyleAndColorClass = "hl-" + Color + "-" + Style;
        return StyleAndColorClass;
    }

    //Featured Apps Launch Test
    public void featuredAppsCheck(String appTitle) throws Exception{
        scrollDownTo(appTitle);
        assertElementExistsBy(WebElementsByText(appTitle, false));
        ClickUIElementByText(appTitle, false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search Google Play"));
        assertElementExistsBy(WebElementsByTextContains(appTitle));
        driver.navigate().back();
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("Featured Apps", false));
    }

    //Get Computed Css Using Xpath
    public String getComputedCssUsingXpath(String xPath, String cssAttribute) throws Exception {
        driver.context("WEBVIEW_org.lds." + AppName + "." + BuildType + "");
        Set<java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        System.out.println("Checking window handles");

        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
            if (WebElementsByXpathWebview(xPath).size() > 0) {
                break;
            }
        }
        WebElement we = WebElementByXpath(xPath);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        String script = "var s = getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);" +
                "return s;";

        String scriptReturn = (executor.executeScript(script, we, cssAttribute)).toString();
        System.out.println(scriptReturn);
        driver.context("NATIVE_APP");
        return scriptReturn;
    }

    //Fill Out Feedback Form And Assert
    public void fillOutFeedbackFormAndAssert(String theName, String theEmail, String theCategory, Boolean checkAllCategories, String theDescription, Boolean attachImage, Boolean deletePhoto, Boolean submit) throws Exception {
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Send Feedback", WebElementById(AppId("mainToolbarTitleTextView")), false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById(AppId("feedbackNameTextInputEditText")));
        verifyText("Name (Optional)", WebElementById(AppId("feedbackNameTextInputEditText")), false);
        //Verify Email field
        assertElementExistsBy(WebElementsById(AppId("feedbackEmailTextInputEditText")));
        verifyText("Email", WebElementById(AppId("feedbackEmailTextInputEditText")), false);
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
        assertElementExistsBy(WebElementsById("android:id/text1"));
        verifyText("Category", WebElementById("android:id/text1"), false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById(AppId("feedbackDescriptionEditText")));
        verifyText("Description", WebElementById(AppId("feedbackDescriptionEditText")), false);
        //Verify text field counter
        assertElementExistsBy(WebElementsById(AppId("textinput_counter")));
        verifyText("0 / 1000", WebElementById(AppId("textinput_counter")), false);

        //enter text into form
        sendText(Org + AppName + "." + BuildType + ":id/feedbackNameTextInputEditText", theName);
        sendText(Org + AppName + "." + BuildType + ":id/feedbackEmailTextInputEditText", theEmail);

        //verify category wheel options
        List category = new ArrayList();
        category.add("How do I…?");
        category.add("Compliment");
        category.add("Feature request");
        category.add("Functionality issue (Bug)");
        category.add("Content issue");
        category.add("Sign in or syncing issue");
        category.add("Other");

        if (checkAllCategories) {
            for (int x = 0; x < category.size(); x++) {
                ClickUIElementByID(AppId("feedbackCategorySpinner"));
                assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
                ClickUIElementByCheckedText((String) category.get(x), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(x), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            }
        } else {
//            ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
            ClickUIElementByID(AppId("feedbackCategorySpinner"));
            for (int x = 0; x < category.size(); x++) {
                assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            }
            if (theCategory == "How do I") {
                ClickUIElementByCheckedText((String) category.get(0), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(0), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Compliment") {
                ClickUIElementByCheckedText((String) category.get(1), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(1), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Feature request") {
                ClickUIElementByCheckedText((String) category.get(2), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(2), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Bug") {
                ClickUIElementByCheckedText((String) category.get(3), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(3), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Content") {
                ClickUIElementByCheckedText((String) category.get(4), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(4), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Sync") {
                ClickUIElementByCheckedText((String) category.get(5), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(5), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Other") {
                ClickUIElementByCheckedText((String) category.get(6), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(6), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "") {
                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                System.out.println("Category was left blank");
            } else {
                fail(theCategory + " isn't a valid category. Valid categories are \"How do I\", \"Compliment\", \"Feature request\", \"Bug\", \"Content\", \"Sync\" and, \"Other\"");
            }
        }


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();


        if (theDescription == "default") {
            String description = ("sendto:" + sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
            sendText(Org + AppName + "." + BuildType + ":id/feedbackDescriptionEditText", description);
            int screenHeight = driver.manage().window().getSize().getHeight();
            int screenWidth = driver.manage().window().getSize().getWidth();
            driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
            verifyText("" + description.length() + " / 1000", WebElementById(AppId("textinput_counter")), false);
            Thread.sleep(milliseconds_1);
        } else if (theDescription == "") {
            System.out.println("Leaving Description Blank");
        } else {
            String description = ("sendto:" + sendtoemail + " " + theDescription);
            sendText(Org + AppName + "." + BuildType + ":id/feedbackDescriptionEditText", description);
            int screenHeight = driver.manage().window().getSize().getHeight();
            int screenWidth = driver.manage().window().getSize().getWidth();
            driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
            verifyText("" + description.length() + " / 1000", WebElementById(AppId("textinput_counter")), false);
            Thread.sleep(milliseconds_1);
        }

        if (attachImage) {
            ClickUIElementByAccessibilityID("Attach Image");
            ClickUIElementByID("com.android.packageinstaller:id/permission_allow_button");
            ClickUIElementByAccessibilityID("Show roots");
            ClickUIElementByText("Images", false);
            ClickUIElementByID("android:id/title");
            ClickUIElementByXpath("(//*/android.widget.ImageView)[2]");
//            ClickUIElementByText("Gallery", false);
//            ClickUIElementByAccessibilityID("More options");
//            if (WebElementsByTextWebview("List view", false).size() > 0){
//                ClickUIElementByText("List view", false);
//            } else {
//                TapCenterScreen();
//            }
//            String photoTitle = WebElementByXpath("//android.widget.ImageView/../android.widget.TextView").getText();
//            System.out.println(photoTitle);
//            ClickUIElementByXpath("//android.widget.ImageView");
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/bubbleLayout"));
            assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/bubbleTextView"));
            assertElementExistsBy(WebElementsByAccessibilityId("Remove tag"));
//            verifyText(photoTitle, WebElementById(AppId("bubbleTextView"),false);

            if (deletePhoto) {
                ClickUIElementByAccessibilityID("Remove tag");
                assertElementNotPresentBy(WebElementsById(AppId("bubbleLayout")));
            }
            ;

        }


        if (submit) {
            ClickUIElementByAccessibilityID("Submit");

            if (theEmail == "") {
                Thread.sleep(milliseconds_1);
                System.out.println("Email was empty, checking that error message is present");
                verifyText("Please enter a valid email address", WebElementByXpath("(//*[@resource-id='org.lds." + AppName + "." + BuildType + ":id/textinput_error'])[1]"), false);
                sendText(Org + AppName + "." + BuildType + ":id/feedbackEmailTextInputEditText", email);
                if (theDescription != "" || theCategory != "") {
                    ClickUIElementByAccessibilityID("Submit");
                    Thread.sleep(milliseconds_3);
                }
            }

            if (theCategory == "") {
                ClickUIElementByID(AppId("feedbackCategorySpinner"));
                ClickUIElementByCheckedText((String) category.get(1), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(1), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
                if (theDescription != "") {
                    ClickUIElementByAccessibilityID("Submit");
                    Thread.sleep(milliseconds_3);
                }
            }


            if (theDescription == "") {
                Thread.sleep(milliseconds_1);
                System.out.println("Description was empty, checking that error message is present");
                //if theEmail is blank, then the description error will be the second in the list.
                if (theEmail == "") {
                    verifyText("Please enter a description", WebElementByXpath("(//*[@resource-id='org.lds." + AppName + "." + BuildType + ":id/textinput_error'])[2]"), false);
                } else {
                    verifyText("Please enter a description", WebElementByXpath("(//*[@resource-id='org.lds." + AppName + "." + BuildType + ":id/textinput_error'])[1]"), false);
                }
                String description = ("sendto:" + sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
                sendText(Org + AppName + "." + BuildType + ":id/feedbackDescriptionEditText", description);
                int screenHeight = driver.manage().window().getSize().getHeight();
                int screenWidth = driver.manage().window().getSize().getWidth();
                driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
                verifyText("" + description.length() + " / 1000", WebElementById(AppId("textinput_counter")), false);
                Thread.sleep(milliseconds_1);
                ClickUIElementByAccessibilityID("Submit");
                Thread.sleep(milliseconds_3);
            }
        }
    }

    //Splash Screen Wait Test
    public void SplashScreenWait() throws Exception {
        System.out.println("Splash Screen Wait Start…");
        Thread.sleep((milliseconds_1 / 2));
        System.out.println("Waited for " + (milliseconds_1 / 2) + " milliseconds");

        Boolean isPresent = driver.findElementsById("org.lds.justserve.alpha:id/action_bar_root").size() > 0;
        while (isPresent) {
            System.out.println("On Splash Screen… Waiting " + milliseconds_1 / 2 + " milliseconds");
            Thread.sleep(milliseconds_1 / 2);
            isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
        }
        System.out.println("Continuing Test…");
        Thread.sleep(milliseconds_2);
    }

    //Splash Screen Wait Test
    public void SplashScreenWaitOld() throws Exception {
        try {
            System.out.println("Splash Screen Wait Start…");
            Thread.sleep((milliseconds_1 / 2));
            System.out.println("Waited for " + (milliseconds_1 / 2) + " milliseconds");

            Boolean isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
            while (isPresent) {
                System.out.println("On Splash Screen… Waiting " + milliseconds_1 / 2 + " milliseconds");
                Thread.sleep(milliseconds_1 / 2);
                isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
            }
            System.out.println("Continuing Test…");
        }
        catch (Exception e) {
            System.out.println("Splash Screen Wait Test… Failed: " + e);
        }
    }

    //Logging In Screen Wait Test
    public void LoggingInScreenWait() throws Exception {
        System.out.println("Logging In Screen Wait Start…");
        Thread.sleep((milliseconds_1 / 2));
        System.out.println("Waited for " + (milliseconds_1 / 2) + " milliseconds");

        Boolean isPresent = driver.findElementsById(AppId("action_bar_root")).size() > 0;
        while (isPresent) {
            //  isPresent = driver.findElementsByXPath("android:id/content").size() > 0;
            //  while (isPresent) {
            System.out.println("On Logging In Screen… Waiting " + milliseconds_1 / 2 + " milliseconds");
            Thread.sleep(milliseconds_1 / 2);
            isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
            //  }
        }
        System.out.println("Continuing Test…");
        Thread.sleep(milliseconds_2);
    }

    //Select Gospel Library Content
    public void SelectLibraryContent(String ContentType) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Back"));
        assertElementExistsBy(WebElementsById(AppId("searchEditText")));
        assertElementExistsBy(WebElementsByAccessibilityId("Voice search"));
        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
        if (ContentType == "Scriptures") {
            sendText("searchEditText", "Book of Mormon");
            ClickUIElementByText("Book of Mormon", false);
        } else if (ContentType == "General Conference") {
            sendText("searchEditText", "General Conference");
            ClickUIElementByText("April 2019", false);
            ClickUIElementByID(AppId("md_button_positive"));
            ClickUIElementByText("April 2019", false);
        } else if (ContentType == "ComeFollowMe") {
            sendText("searchEditText", "Come follow me");
            ClickUIElementByText("Come, Follow Me—For Individuals and Families: New Testament 2019", false);
            ClickUIElementByID(AppId("md_button_positive"));
            ClickUIElementByText("Come, Follow Me—For Individuals and Families: New Testament 2019", false);
        }

    }

    //Assert Gospel Library Schedule Screen
    public void assertScheduleScreen() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("introTextView")));
        assertElementExistsBy(WebElementsById(AppId("scheduleSwitch")));
        assertElementExistsBy(WebElementsById(AppId("leftTextButton")));
        assertElementExistsBy(WebElementsById(AppId("rightTextButton")));
    }

    //Assert Gospel Library Set Schedule Screen
    public void assertSetScheduleScreen() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("introTextView")));
        assertElementExistsBy(WebElementsById(AppId("scheduleSwitch")));
        assertElementExistsBy(WebElementsById(AppId("dailyCheckBox")));
        assertElementExistsBy(WebElementsById(AppId("startTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("startValueTextView")));
        assertElementExistsBy(WebElementsById(AppId("endTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("endValueTextView")));
        assertElementExistsBy(WebElementsById(AppId("splitChaptersCheckBox")));
        assertElementExistsBy(WebElementsById(AppId("leftTextButton")));
        verifyAttributeWithBoolean(WebElementById("rightTextButton"), "enabled", false);

    }

    //Assert Gospel Library And Set Remainder Screen
    public void assertAndSetRemainderScreen() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("introTextView")));
        assertElementExistsBy(WebElementsById(AppId("reminderSwitch")));
        assertElementExistsBy(WebElementsById(AppId("leftTextButton")));
        assertElementExistsBy(WebElementsById(AppId("rightTextButton")));
        assertElementExistsBy(WebElementsById(AppId("reminderSwitch")));
        ClickUIElementByID(AppId("reminderSwitch"));
        ClickUIElementByID(AppId("timeTextView"));
        ClickUIElementByAccessibilityID("9");
        ClickUIElementByResourceID("android:id/am_label");
        ClickUIElementByResourceID("android:id/button1");
        ClickUIElementByID(AppId("rightTextButton"));
    }

    //Assert Gospel Library Schedule Summary Screen
    public void assertScheduleSummaryScreen() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        assertElementExistsBy(WebElementsByText(("Schedule"), false));
        assertElementExistsBy(WebElementsByText(("Reminder"), false));
        assertElementExistsBy(WebElementsById(AppId("leftTextButton")));
        assertElementExistsBy(WebElementsById(AppId("rightTextButton")));
        ClickUIElementByID(AppId("rightTextButton"));
    }

    //Assert Gospel Library  And Return Study Plan Summary Screen
    public void assertAndReturnStudyPlanSummaryScreen() throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarSubTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("dropArrowImageView")));
        assertElementExistsBy(WebElementsByAccessibilityId("Edit"));
        ClickUIElementByAccessibilityID("Navigate up");
    }

    //Assert Gospel Library Study Plan Summary Screen
    public void assertStudyPlanSummaryScreen() throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("dropArrowImageView")));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsById(AppId("imageView")));
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        assertElementExistsBy(WebElementsById(AppId("subtitleTextView")));
        assertElementExistsBy(WebElementsByResourceId(Org + AppName + "." + BuildType + ":id/progressView"));
        assertElementExistsBy(WebElementsByAccessibilityId("Toggle reminder"));
        assertElementExistsBy(WebElementsByAccessibilityId("Options menu"));
        ClickUIElementByAccessibilityID("Navigate up");
    }

//******Search Screen********

    //Assert Gospel Library Main Toolbar Text Layout
    public void assertMainToolbarTextLayout() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTextLayout")));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));

    }

    //Assert Main Search Screen
    public void assertMainSearchScreen() throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Back"));
        assertElementExistsBy(WebElementsById(AppId("searchEditText")));
        assertElementExistsBy(WebElementsByAccessibilityId("Voice search"));
    }

    //Assert Search Content Screen
    public void assertSearchContentScreen () throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Back"));
        assertElementExistsBy(WebElementsById(AppId("searchEditText")));
        assertElementExistsBy(WebElementsByAccessibilityId("Clear search"));
    }

    //Assert Search Screen Filters
    public void assertSearchScreenFilters () throws Exception {
        assertElementExistsBy(WebElementsById(AppId("searchTabLayout")));
        assertElementExistsBy(WebElementsByXpath("(//*/android.widget.TextView)[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*/android.widget.TextView)[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*/android.widget.TextView)[3]"));
//        TapAndDrag(WebElementByAccessibilityId("(//*/android.widget.TextView)[3]"), WebElementByAccessibilityId("(//*/android.widget.TextView)[1]"));
//        assertElementExistsBy(WebElementsByXpath("(//*/android.widget.TextView)[2]"));
//        assertElementExistsBy(WebElementsByXpath("(//*/android.widget.TextView)[3]"));
//        assertElementExistsBy(WebElementsByXpath("(//*/android.widget.TextView)[4]"));
    }

    //Assert Scriptures Search Sub Filters
    public void assertScripturesSearchSubFilters () throws Exception {
        assertElementExistsBy(WebElementsById(AppId("scriptureSelectionRecyclerView")));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/coverArtImageView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/coverArtImageView\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/coverArtImageView\"])[3]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/coverArtImageView\"])[4]"));
        TapAndDrag(WebElementByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/coverArtImageView\"])[4]"),WebElementByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/coverArtImageView\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/coverArtImageView\"])[4]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/scriptureSelectionItemCount\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/scriptureSelectionItemCount\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/scriptureSelectionItemCount\"])[3]"));
        TapAndDrag(WebElementByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/scriptureSelectionItemCount\"])[3]"),WebElementByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/scriptureSelectionItemCount\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/scriptureSelectionItemCount\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/scriptureSelectionItemCount\"])[3]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/scriptureSelectionItemCount\"])[4]"));

    }

    //Assert General Conference Search Subfilters
    public void assertGeneralConferenceSearchSubfilters () throws Exception {
        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView[@content-desc=\"Russell M. Nelson\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView[@content-desc=\"Dallin H. Oaks\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView[@content-desc=\"Henry B. Eyring\"])[2]"));
    }

    //Assert Search Results
    public void assertSearchResults () throws Exception {
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/titleTextView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/itemTitleTextView\"])[1])"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/previewTextView\"])[1])"));
    }

    //Assert Search Results Find On Page Layout
    public void assertSearchResultsFindOnPageLayout() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("findOnPageLayout")));
        assertElementExistsBy(WebElementsByAccessibilityId("Close"));
        assertElementExistsBy(WebElementsById(AppId("markTextPositionTextView")));
        assertElementExistsBy(WebElementsByAccessibilityId("Find previous"));
        assertElementExistsBy(WebElementsByAccessibilityId("Find next"));
    }

    //Assert Search General Conference Tab
    public void assertSearchGeneralConferenceTab () throws Exception {
        assertElementExistsBy(WebElementsById(AppId("speakerSelectionRecyclerView")));
        assertElementExistsBy(WebElementsByXpath("//*[@resource-id=" + Org + AppName + "." + BuildType + ":id/coverArtImageView\"][1]"));
        assertElementExistsBy(WebElementsById(AppId("searchSortDropdown")));

    }

    //Screen Rotation Test
    public void performOrientation() throws InterruptedException {

        countTestCases++;
        testsPassed++;

        //Get and print current screen orientation.
        System.out.println("Current screen orientation Is : " + "\033[34m " + driver.getOrientation() + "\033[0m");

        long startTime = System.currentTimeMillis();
        long totalTime = System.currentTimeMillis() - startTime;
        int count = 0;
        while( totalTime <= 65000)
        {

            System.out.println("\033[33mChanging screen Orientation to LANDSCAPE.\033[0m");
            Thread.sleep(500);
            //Changing screen Orientation to LANDSCAPE.
            driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
            //Get and print screen orientation after changing It.
            System.out.println("Now screen orientation Is : " + "\033[33m " + driver.getOrientation() + "\033[0m");
            Thread.sleep(500);
            count++;

            System.out.println("\033[34mChanging screen Orientation to PORTRAIT.\033[0m");
            Thread.sleep(500);
            //Changing screen Orientation to PORTRAIT.
            driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
            //Get and print screen orientation after changing It.
            System.out.println("Now screen orientation Is : " + "\033[34m " + driver.getOrientation() + "\033[0m");
            Thread.sleep(500);
            count++;
            totalTime = System.currentTimeMillis() - startTime;
        }

        System.out.println("Total screen rotations:" + " " + "\033[36m" + count + "\033[0m");

        countTestCases++;
        testsPassed++;
    }

    //FIR PFM Test Users
    public String pfmTestUser(String testUserNumber) throws Exception{
        String pfmTestUserName = "";
        switch(testUserNumber)
        {
            case "1":
                pfmTestUserName = "PFM1001";
                break;
            case "2":
                pfmTestUserName = "PFM1002";
                break;
            case "3":
                pfmTestUserName = "PFM1003";
                break;
            case "4":
                pfmTestUserName = "PFM1004";
                break;
            case "5":
                pfmTestUserName = "PFM1005";
                break;
            case "6":
                pfmTestUserName = "PFM1006";
                break;
            case "7":
                pfmTestUserName = "PFM1007";
                break;
            case "8":
                pfmTestUserName = "PFM1008";
                break;
            case "9":
                pfmTestUserName = "PFM1009";
                break;
            case "10":
                pfmTestUserName = "PFM1010";
                break;
            case "11":
                pfmTestUserName = "PFM1011";
                break;
            case "12":
                pfmTestUserName = "PFM1012";
                break;
            case "13":
                pfmTestUserName = "PFM1013";
                break;
            case "14":
                pfmTestUserName = "PFM1014";
                break;
            case "15":
                pfmTestUserName = "PFM1015";
                break;
            case "16":
                pfmTestUserName = "PFM1016";
                break;
            case "17":
                pfmTestUserName = "PFM1017";
                break;
            default:
                System.out.println("no match");
        }
        return pfmTestUserName;
    }
}
