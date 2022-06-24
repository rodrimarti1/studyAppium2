package UI;

import UI.Tests.LaunchTests;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.KeyEvent;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import static UI.EnvironmentConfig.BuildName;
import static UI.EnvironmentConfig.*;
import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.openqa.selenium.server.RobotRetriever.getRobot;

import UI.Tests.LaunchTests.*;

public class GospelForKids {
    //AppiumDriver driver;
    static mainFunctions main;
    static Timestamp startTime = new Timestamp(System.currentTimeMillis());
    //Date startTime = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    boolean msg;
    String msgStr;

    @Before
    public void setUp() throws Exception {
        Thread.sleep(milliseconds_2);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformVersion", "7.0");
        //capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("platformVersion", "9");
        //capabilities.setCapability("platformVersion", "10.0");
        //capabilities.setCapability("deviceName", "Galaxy S7");
        capabilities.setCapability("deviceName", "Galaxy S8");
        //capabilities.setCapability("deviceName", "Android Emulator");
        //capabilities.setCapability("deviceName", "Android SDK built for x86");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/APK/" + BuildName + BuildType + ".apk");
        capabilities.setCapability("automationName", "UIAutomator2");
        System.out.println(System.getProperty("user.dir") + "/APK/" + BuildName + BuildType + ".apk");
        capabilities.setCapability("chromedriverExecutableDir", System.getProperty("user.dir") + "/ChromeDriver/");
        //capabilities.setCapability("browserName", "Chrome");

        main = new mainFunctions();

        main.driver = new AndroidDriver(new URL("http://127.0.0.1:" + theAppiumPort + "/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        main.driver.closeApp();
        main.driver.quit();
    }

    @AfterClass
    public static void TestsSummary() throws InterruptedException{
        System.out.println("\033[35mGet Capabilities:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities() + "\033[0m");
        System.out.println("\033[35mCapabilities Map:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().asMap() + "\033[0m");
        System.out.println("\033[35mDevice Platform Name:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("platformName").toString() + "\033[0m");
        System.out.println("\033[35mDevice Name:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("deviceName").toString() + "\033[0m");
        System.out.println("\033[35mDevice UDID:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("deviceUDID").toString() + "\033[0m");
        System.out.println("\033[35mDevice Manufacturer:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("deviceManufacturer").toString() + "\033[0m");
        System.out.println("\033[35mDevice Model:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("deviceModel").toString() + "\033[0m");
        System.out.println("\033[35mDevice OS Version:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("platformVersion") + "\033[0m");
        System.out.println("\033[35mDevice Api Level:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("deviceApiLevel") + "\033[0m");
        System.out.println("\033[35mDevice Resolution:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("deviceScreenSize") + "\033[0m");
        System.out.println("\033[35mDevice Screen Density:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("deviceScreenDensity") + "\033[0m");
        System.out.println("\033[35mDevice Pixel Ratio:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("pixelRatio") + "\033[0m");

        if (main.driver.getCapabilities().getCapability("platform").toString() == "LINUX") {
            System.out.println("\033[35mTest Platform OS Name:\033[0m" + " " + "\033[35m" + "LINUX" + "\033[0m");
        } else {
            System.out.println("\033[35mTest Platform OS Name:\033[0m" + " " + "\033[35m" + "Not LINUX" + "\033[0m");
        }

        System.out.println("\033[35mProject:\033[0m" + " " + "\033[35m" + GospelForKids.class.getProtectionDomain().getCodeSource().getLocation() + "\033[0m");
        System.out.println("\033[35mApp Apk:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("app").toString() + "\033[0m");
        System.out.println("\033[35mApp Version #:\033[0m" + " " + "\033[33m" + Strings.versionNumber + "\033[0m");
        System.out.println("\033[33mTotal Number of Test Cases Ran:\033[0m" + " " + "\033[94m" + mainFunctions.countTestCases + "\033[0m");
        System.out.println("\033[34mTotal Number of Test Cases Passed:\033[0m" + " " + "\033[92m" + mainFunctions.testsPassed + "\033[0m");
        System.out.println("\033[37mTotal Number of Test Cases Failed:\033[0m" + " " + "\033[91m" + mainFunctions.testsFailed + "\033[0m");

        Timestamp endTime = new Timestamp(System.currentTimeMillis());

        Timestamp testDate = new Timestamp(System.currentTimeMillis());

        String fStartTimeNano = (String.format("%tN", startTime));
        String fStartTimeSecond = (String.format("%tS", startTime));
        String fStartTimeMinute = (String.format("%tM", startTime));
        String fStartTimeHour = (String.format("%tH", startTime));


        String fEndTimeNano = (String.format("%tN", endTime));
        String fEndTimeSecond = (String.format("%tS", endTime));
        String fEndTimeMinute = (String.format("%tM", endTime));
        String fEndTimeHour = (String.format("%tH", endTime));


        long lStartTimeNano = Long.parseLong(fStartTimeNano) / 1000000;
        long lStartTimeSecond = Long.parseLong(fStartTimeSecond) * 1000 * 60;
        long lStartTimeMinute = Long.parseLong(fStartTimeMinute) * 100000 * 60;
        long lStartTimeHour = Long.parseLong(fStartTimeHour) * 10000000 * 60;

        long lEndTimeNano = Long.parseLong(fEndTimeNano) / 1000000;
        long lEndTimeSecond = Long.parseLong(fEndTimeSecond) * 1000 * 60;
        long lEndTimeMinute = Long.parseLong(fEndTimeMinute) * 100000 * 60;
        long lEndTimeHour = Long.parseLong(fEndTimeHour) * 10000000 * 60;


        long sumStart = lStartTimeHour + lStartTimeMinute + lStartTimeSecond + lStartTimeNano;
        long sumEnd = lEndTimeHour + lEndTimeMinute + lEndTimeSecond + lEndTimeNano;
        long sum = sumEnd - sumStart;


        long nano = sum % 1000;
        long lNano = sum - nano;
        long second = (lNano / 60)  % 100000;
        long lSecond = (second / 1000) % 60;
        long minute = sum - nano - second;
        long lMinute = ((minute / 100000) / 60) % 60;
        long hour = sum - nano - second - minute;
        long lHour = (hour / 60) % 24;
        String time = (String.format("%02d:%02d:%02d.%03d",  lHour, lMinute, lSecond, nano));
        //String time = String.format("%09d", sum);

        SimpleDateFormat formatter1;

        formatter1 = new SimpleDateFormat("yyyy.MM.dd");

        System.out.println("\033[31mTests Date yyyy.MM.dd:\033[0m" + " " + formatter1.format(testDate));
        System.out.println("\033[31mTests Started HH:mm:ss:SSS:\033[0m" + " " + fStartTimeHour + ":" + fStartTimeMinute + ":" + fStartTimeSecond + "." + lStartTimeNano);
        System.out.println("\033[31mTests Ended HH:mm:ss:SSS:\033[0m" + " " + fEndTimeHour + ":" + fEndTimeMinute + ":" + fEndTimeSecond + "." + lEndTimeNano);
        System.out.println("\033[31mTests Total Time HH:mm:ss:SSS:\033[0m" + " " + time);
    }

    //*************************************************************** Tests ***************************************************************

    //********** Launch *********

    @Test
    public void LaunchTest() throws Exception {
        try {
            //Test Start
            System.out.println("Testing launchTest.");
            //Verify unique element exists so launch worked
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            System.out.println(main.driver.getContextHandles());
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("launchTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("launchTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Settings Screen *********
    @Test
    public void SettingsBackClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SettingsBackClickTest.");
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Find Settings text
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Back arrow button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books main title element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Coloring Books screen main title element text matches
            main.verifyTextContains("Coloring Books", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("SettingsBackClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SettingsBackClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Settings Screen *********
    @Test
    public void VerifySettingsScreenElementsTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifySettingsScreenElementsTest.");
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow icon Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Find Settings text
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //main section ScrollView Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Language main title element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Language text matches
            main.verifyTextContains("Language", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Language button element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Translated Language text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Translated Language text matches
            main.verifyTextContains("English", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Selected Language text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Selected Language text matches
            main.verifyTextContains("English", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Additional Info main title element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Additional Info text matches
            main.verifyTextContains("Additional Info", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Featured Apps button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Featured Apps text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Featured Apps text matches
            main.verifyTextContains("Featured Apps", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Send Feedback button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Send Feedback text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Send Feedback tet matches
            main.verifyTextContains("Send Feedback", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About button text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About text matches
            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Version text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Version text matches
            main.verifyTextContains(Strings.versionNumber, main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView[2]"), true);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifySettingsScreenElementsTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifySettingsScreenElementsTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Settings Screen *********
    @Test
    public void VerifySettingsScreenElementsDeveloperModeTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifySettingsScreenElementsDeveloperModeTest.");
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow icon Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Find Settings text
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //main section ScrollView Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Language main title element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Language text matches
            main.verifyTextContains("Language", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Language button element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Translated Language text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Translated Language text matches
            main.verifyTextContains("English", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Selected Language text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Selected Language text matches
            main.verifyTextContains("English", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.TextView[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Additional Info main title element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Additional Info text matches
            main.verifyTextContains("Additional Info", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Featured Apps button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Featured Apps text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Featured Apps text matches
            main.verifyTextContains("Featured Apps", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Send Feedback button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Send Feedback text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Send Feedback tet matches
            main.verifyTextContains("Send Feedback", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About button text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About text matches
            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Version text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Version text matches
            main.verifyTextContains(Strings.versionNumber, main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView[2]"), true);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Developer Mode text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Developer Mode text matches
            main.verifyTextContains("Developer Mode", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.TextView[3]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Work Manager Min Interval Switch
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[5]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Work Manager Min Interval text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[5]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Work Manager Min Interval text matches
            main.verifyTextContains("Work Manager Min Interval", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[5]/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Description text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[5]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Description text matches
            main.verifyTextContains("Force all scheduled work to min periodic interval (15 minutes). Cancel all work, and app restart required.", main.WebElementByXpath("            main.assertElementExistsBy(main.WebElementsByXpath(\"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[5]/android.widget.TextView[2]\"));\n"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Switch View exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[5]/android.widget.Switch"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Work Manager Monitor button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[6]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Work Manager Monitor text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[6]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Work Manager Monitor text matches
            main.verifyTextContains("Work Manager Monitor", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[6]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //View All DataStore Values button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[7]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //View All DataStore Values text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[7]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //View All DataStore Values text matches
            main.verifyTextContains("View All DataStore Values", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[7]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scroll down
            main.swipeByCoordinates(550, 1900, 550, 350);
            //Update stories database on launch Switch
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[8]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Update stories database on launch text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[8]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Update stories database on launch text matches
            main.verifyTextContains("Update stories database on launch.", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[8]/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Description text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[8]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Description text matches
            main.verifyTextContains("Forces update of stories database on launch.", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[8]/android.widget.TextView[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Switch View exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[8]/android.widget.Switch"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifySettingsScreenElementsDeveloperModeTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifySettingsScreenElementsDeveloperModeTest: \033[31mFailed\033[0m " + e);
        }
    }
/*       Temporarily removed from app

    //********** FeaturedApps Screen *********
    @Test
    public void FeaturedAppsBackClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing FeaturedAppsBackClickTest.");
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Featured Apps button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Featured Apps button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Screen container Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Content Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Find Church text
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify text matches
            main.verifyTextContains("The Church of Jesus Christ of Latter-day Saints", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Device Back button
            main.driver.navigate().back();
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Returned to Settings from Featured Apps. Settings text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("FeaturedAppsBackClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("FeaturedAppsBackClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Featured Apps Screen *********
    @Test
    public void VerifyFeaturedAppsScreenElementsTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifyFeaturedAppsScreenElementsTest.");
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            Thread.sleep(milliseconds_3);
            //Featured Apps button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Featured Apps button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Screen container Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Content Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Google Play text image element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Search Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.widget.TextView[@content-desc=\"Search Google Play\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Share Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.widget.TextView[@content-desc=\"Share\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Content Element exists
            main.assertElementExistsBy(main.WebElementsById("com.android.vending:id/nested_parent_recycler_view"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Church image ViewGroup Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Church image Element exists
            main.assertElementExistsBy(main.WebElementsById("com.android.vending:id/screenshot"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Church logo text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Church logo text matches
            main.verifyTextContains("The Church of Jesus Christ of Latter-day Saints", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Jesus image Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.ImageView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Linearlayout Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Church Apps text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Church Apps text matches
            main.verifyTextContains("Apps from the Church of Jesus Christ of Latter-day Saints", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Featured app text image exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.widget.FrameLayout[@content-desc=\"Featured app\n\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //LinearLayout container Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //LinearLayout container Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //FrameLayout container Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //RecyclerView container Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Screenshot 1 Element exists
            main.assertElementExistsBy(main.WebElementsByAccessibilityId("Screenshot \"1\" of \"7\""));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Screenshot 2 Element exists
            main.assertElementExistsBy(main.WebElementsByAccessibilityId("Screenshot \"2\" of \"7\""));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Screenshot 3 Element exists
            main.assertElementExistsBy(main.WebElementsByAccessibilityId("Screenshot \"3\" of \"7\""));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Screenshot 4 Element exists
            main.assertElementExistsBy(main.WebElementsByAccessibilityId("Screenshot \"4\" of \"7\""));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //ViewGroup Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Gospel Library icon Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Gospel Library text image Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[normalize-space(@content-desc=\"App: Gospel Library Books & Reference Installed\")]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Swipe Up
            main.scrollDown();
            //Close app
            main.driver.closeApp();
            //Passed Test Result
            System.out.println("VerifyFeaturedAppsScreenElementsTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifyFeaturedAppsScreenElementsTest: \033[31mFailed\033[0m " + e);
        }
    }
*/

    //********** Settings About Screen *********
    @Test
    public void SettingsAboutBackClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SettingsAboutBackClickTest.");
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Find Settings text
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click About button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About text matches
            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About Back button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click About Back button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Returned to Settings from About. Settings text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("SettingsAboutBackClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SettingsAboutBackClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Settings About Screen *********
    @Test
    public void VerifySettingsAboutScreenElementsTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifySettingsAboutScreenElementsTest.");
            //Settings button Element exists By text
            main.assertElementExistsBy((List) main.WebElementByButtonText("About", false));
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings button element is clickable
            main.verifyAttributeWithBoolean(main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"), "clickable", true);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings button element is enabled
            main.verifyAttributeWithBoolean(main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"), "enabled", true);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings button element is focusable
            main.verifyAttributeWithBoolean(main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"), "focusable", true);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings button element is displayed
            main.verifyAttributeWithBoolean(main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"), "displayed", true);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]"));
//            main.assertElementExistsBy(main.WebElementsByClassTextContains("android.view.View", "About", "//parent::"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click About button
            main.ClickUIElementByID(main.WebElementById("element[attribute='db79e09b-480c-4eef-8981-2cdf498c0d0b']").toString());
//            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]");
//            main.ClickUIElementByXpath(main.WebElementsByClassTextContains("android.view.View", "About", "//parent::").toString());
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //LinearLayout Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //FrameLayout Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back arrow button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About text exists
//            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            main.assertElementExistsBy(main.WebElementsByClassTextContains("android.view.View", "About", ""));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About text matches
//            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            main.verifyTextContains("About", main.WebElementByText("android.view.View","About", false), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //App Instance ID
            main.assertElementExistsBy(main.WebElementsById(main.AppId("about_info")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("constraintLayout")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Terms Of Use button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Terms Of Use text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Terms Of Use text matches
            main.verifyTextContains("Terms of Use", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Terms Of Use Updated text
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Terms Of Use Updated text
            main.verifyTextContains("Updated 2021-04-13", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Privacy Notice button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Privacy Notice text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Privacy Notice text matches
            main.verifyTextContains("Privacy Notice", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Privacy Notice Updated text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Privacy Notice Updated text matches
            main.verifyTextContains("Updated 2021-04-06", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Acknowledgements button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Acknowledgements text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Acknowledgements text matches
            main.verifyTextContains("Acknowledgements", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Church logo exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("aboutLogo")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Copyright exists exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("aboutCopyright")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Copyright text matches
            main.verifyTextContains("© 2021 by Intellectual Reserve, Inc. All rights reserved.", main.WebElementById(main.AppId("aboutCopyright")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifySettingsAboutScreenElementsTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifySettingsAboutScreenElementsTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Settings About Screen App Instance ID Popup *********
    @Test
    public void VerifyAboutScreenAppInstanceIdElementsTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifyAboutScreenAppInstanceIdElementsTest.");
            //Verify Settings Widget Icon Button Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings Widget Icon Button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings Screen Displays
            //Settings title text  exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings Screen Title Text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings About Button Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings About Button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify About Screen Displays
            //About title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify About Screen Title Text matches
            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //App Instance ID icon Button Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("about_info")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click App Instance ID icon Button
            main.ClickUIElementByID(main.AppId("about_info"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Action Bar Root Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Action Content Exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Parent Panel Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("parentPanel")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Top Panel Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("topPanel")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Title Template Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("title_template")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify App Instance ID Popup Displays
            //App Instance ID title text exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("alertTitle")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify App Instance ID text matches
            main.verifyTextContains("App Instance ID", main.WebElementById(main.AppId("alertTitle")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Title Divider No Custom Horizontal Separator Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("titleDividerNoCustom")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Content Panel Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("contentPanel")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scroll View Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("scrollView")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Message ID Text Displays
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("message")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //TODO Figure out how to compare App Instance ID since it changes every time app is launched
            /*//Verify Message ID Text*/
            /*main.verifyTextContains("ff8c3c12-5954-4772-a4eb-079bf94df94a", main.WebElementById(main.AndroidId("message")), false);*/
            /*Thread.sleep(milliseconds_1);*/
            /*main.countTestCases++;*/
            /*main.testsPassed++;*/
            //Verify Button Panel Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("buttonPanel")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup COPY Button Exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("button2")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup COPY Title Text matches
            main.verifyTextContains("COPY", main.WebElementById(main.AndroidId("button2")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup OK Button Exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("button1")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup OK Title Text matches
            main.verifyTextContains("OK", main.WebElementById(main.AndroidId("button1")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifyAboutScreenAppInstanceIdElementsTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            //Failed Test Result
            System.out.println("VerifyAboutScreenAppInstanceIdElementsTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Settings About Screen App Instance ID Popup *********
    @Test
    public void AboutScreenAppInstanceIdOkClickTest() throws Exception {
        try {
            
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing AboutScreenAppInstanceIdOkClickTest.");
            //Verify Settings Widget Icon Button Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings Widget Icon Button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings Screen Displays
            //Settings title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings Screen Title Text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings About Button Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings About Button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify About Screen Displays
            //About title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify About Screen Title Text matches
            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //App Instance ID icon Button Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //App Instance ID Button container Exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Information\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //App Instance ID widget Button container Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click App Instance ID icon Button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify App Instance ID Popup Displays
            //FrameLayout container element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //FrameLayout Content container element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //ViewGroup container element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //View container element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //View child container element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //View grand-child container element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //App Instance ID title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify App Instance ID Title Text matches
            main.verifyTextContains("App Instance ID", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //App Instance ID code text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup OK Button Exists
            main.assertElementExistsByWebElement(main.WebElementById(main.AndroidId("button1")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup OK Title Text matches
            main.verifyTextContains("OK", main.WebElementById(main.AndroidId("button1")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup OK Button Exists
            main.assertElementExistsByWebElement(main.WebElementById(main.AndroidId("button1")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup OK Title Text matches
            main.verifyTextContains("OK", main.WebElementById(main.AndroidId("button1")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Popup OK Button
            main.ClickUIElementByID(main.AndroidId("button1"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify You Returned To The About Screen
            //Settings title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify About Screen Title Text matches
            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("AboutScreenAppInstanceIdOkClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            //Failed Test Result
            System.out.println("AboutScreenAppInstanceIdOkClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Settings About Screen App Instance ID Popup *********
    @Test
    public void AboutScreenAppInstanceIdCopyClickTest() throws Exception {
        try {
            
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing AboutScreenAppInstanceIdCopyClickTest.");
            //Verify Settings Widget Icon Button Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings Widget Icon Button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings Screen Displays
            //Settings title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings Screen Title Text matches
            main.verifyTextContains("Settings", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings About Button Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Settings About Button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify About Screen Displays
            //About title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify About Screen Title Text matches
            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //App Instance ID icon Button Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("about_info")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click App Instance ID icon Button
            main.ClickUIElementByID(main.AppId("about_info"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify App Instance ID Popup Displays
            //App Instance ID title text exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("alertTitle")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify App Instance ID Title Text matches
            main.verifyTextContains("App Instance ID", main.WebElementById(main.AppId("alertTitle")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify App Instance Actual ID Exists
            main.assertElementExistsByWebElement(main.WebElementById(main.AndroidId("message")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Assign App Instance Actual ID Exists
            if (main.WebElementById(main.AndroidId("message")).getAttribute("Text").length() > 0) {
                //Copy test to App Instance ID string
                UI.Strings.appinstanceid = main.WebElementById(main.AndroidId("message")).getAttribute("Text");
                System.out.println("Assigned " + UI.Strings.appinstanceid + " to String.");
                Thread.sleep(milliseconds_1);
                main.countTestCases++;
                main.testsPassed++;
            } else {
                System.out.println("App Instance Actual ID is blank.");
                Thread.sleep(milliseconds_1);
                main.countTestCases++;
                main.testsPassed++;
            }
            //Verify text matches
            main.verifyTextContains("COPY", main.WebElementById(main.AndroidId("button2")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup OK Button Exists
            main.assertElementExistsByWebElement(main.WebElementById(main.AndroidId("button2")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Popup OK Title Text matches
            main.verifyTextContains("COPY", main.WebElementById(main.AndroidId("button2")), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Popup OK Button
            main.ClickUIElementByID(main.AndroidId("button2"));
            System.out.println("Copied " + UI.Strings.appinstanceid + " to Clipboard.");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify You Returned To The About Screen
            //About title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings Screen Title Text matches
            main.verifyTextContains("About", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //About Back button Exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click About Back button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Send Feedback button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Send Feedback Button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Description Edit Exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("feedbackDescriptionEditText")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Description Edit
            main.ClickUIElementByID(main.AppId("feedbackDescriptionEditText"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //LongPress and open Android keyboard paste controls
            TouchAction action = new TouchAction(main.driver);
            action
                    .longPress(200, 1030)
                    .release()
                    .perform();
            //Click Paste
            action
                    .longPress(155, 895)
                    .release()
                    .perform();
            //Verify Message ID Text and App Instance ID string match
            main.verifyTextContains(UI.Strings.appinstanceid, main.WebElementById(main.AppId("feedbackDescriptionEditText")), false);
            //Passed Test Result
            System.out.println("AboutScreenAppInstanceIdCopyClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            //Failed Test Result
            System.out.println("AboutScreenAppInstanceIdCopyClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Swipe Left To Coloring Books Screen From Scripture Stories *********
    @Test
    public void SwipeLeftToCBScreenFromSSTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SwipeLeftToCBScreenFromSSTest.");
            //Swipe Left
            main.SwipeLeftByCoordinates(800, 1940, 300, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Coloring Books\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("SwipeLeftToCBScreenFromSSTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SwipeLeftToCBScreenFromSSTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Swipe Left To Coloring Books Then To Sing Along Screen From Scripture Stories *********
    @Test
    public void SwipeLeftToCBThenToSAScreenFromSSTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SwipeLeftToCBThenToSAScreenFromSSTest.");
            //Swipe Left
            main.SwipeLeftByCoordinates(800, 1940, 600, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Coloring Books\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Swipe Left
            main.SwipeLeftByCoordinates(800, 1940, 200, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Sing Along\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("SwipeLeftToCBThenToSAScreenFromSSTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SwipeLeftToCBThenToSAScreenFromSSTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Swipe Left To Sing Along Screen From Scripture Stories *********
    @Test
    public void SwipeLeftToSAScreenFromSSTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SwipeLeftToSAScreenFromSSTest.");
            //Swipe Left
            main.SwipeLeftByCoordinates(1050, 1940, 500, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Sing Along\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("SwipeLeftToSAScreenFromSSTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SwipeLeftToSAScreenFromSSTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Swipe Right To Coloring Books Screen From Scripture Stories *********
    @Test
    public void SwipeRightToSSScreenFromCBTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SwipeRightToSSScreenFromCBTest.");
            //Swipe Left
            main.SwipeLeftByCoordinates(800, 1940, 600, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Coloring Books\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Swipe Right
            main.SwipeRightByCoordinates(500, 1940, 1000, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Scripture Stories\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("SwipeRightToSSScreenFromCBTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SwipeRightToSSScreenFromCBTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Swipe Right To Coloring Books Screen From Sing Along *********
    @Test
    public void SwipeRightToCBScreenFromSATest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SwipeRightToCBScreenFromSATest.");
            //Swipe Left
            main.SwipeLeftByCoordinates(800, 1940, 600, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Coloring Books\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;;
            //Swipe Left
            main.SwipeLeftByCoordinates(1050, 1940, 500, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Sing Along\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Swipe Right
            main.SwipeRightByCoordinates(600, 1940, 800, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Coloring Books\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;;
            //Passed Test Result
            System.out.println("SwipeRightToCBScreenFromSATest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SwipeRightToCBScreenFromSATest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Swipe Right To Coloring Books Screen From Sing Along *********
    @Test
    public void SwipeRightToSSScreenFromSATest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SwipeRightToSSScreenFromSATest.");
            //Swipe Left
            main.SwipeLeftByCoordinates(800, 1940, 600, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Swipe Left
            main.SwipeLeftByCoordinates(1050, 1940, 500, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Swipe Right
            main.SwipeRightByCoordinates(600, 1940, 800, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Swipe Right
            main.SwipeRightByCoordinates(500, 1940, 1050, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("SwipeRightToSSScreenFromSATest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SwipeRightToSSScreenFromSATest: \033[31mFailed\033[0m " + e);
        }
    }
/*      Temporarily removed from app

    //********** Scripture Stories Home Screen *********
    @Test
    public void VerifyScriptureStoriesHomeScreenElementsTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifyScriptureStoriesHomeScreenElementsTest.");
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Settings\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories main title element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Scripture Stories main title element text matches
            main.verifyTextContains("Scripture Stories", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Scripture Stories\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Coloring Books\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            //Passed Test Result
            System.out.println("VerifyScriptureStoriesHomeScreenElementsTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifyScriptureStoriesHomeScreenElementsTest: \033[31mFailed\033[0m " + e);
        }
    }
*/

/*          ************TODO To Be Added Later *****************

//********** More Activities Home Screen *********
    @Test
    public void VerifyMoreActivitiesHomeScreenElementsTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifyMoreActivitiesHomeScreenElementsTest.");
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Settings\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories main title element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Scripture Stories main title element text matches
            main.verifyTextContains("Scripture Stories", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //More Activities button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[7]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //More Activities icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"More Activities\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Coloring Books\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifyMoreActivitiesHomeScreenElementsTest: \033[32mPassed\033[0m");
            } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifyMoreActivitiesHomeScreenElementsTest: \033[31mFailed\033[0m " + e);
        }
    }
 */

    //********** Coloring Books Home Screen *********
    @Test
    public void VerifyColoringBooksHomeScreenElementsTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifyColoringBooksHomeScreenElementsTest.");
            //Swipe Left
//            main.SwipeLeftByCoordinates(800, 1940, 500, 1940);
            main.countTestCases++;
            main.testsPassed++;
            //Verify element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Settings button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Coloring Books text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Coloring Books text matches
            main.verifyTextContains("Coloring Books", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifyColoringBooksHomeScreenElementsTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifyColoringBooksHomeScreenElementsTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Sing Along Home Screen *********
    @Test
    public void VerifySingAlongHomeScreenElementsTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifySingAlongHomeScreenElementsTest.");
            Thread.sleep(milliseconds_1);
            //Swipe Left
            main.SwipeLeftByCoordinates(1050, 1940, 500, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            Thread.sleep(milliseconds_3);
            //Settings button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Settings Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along main title element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Sing Along main title element text matches
            main.verifyTextContains("Sing Along", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Coloring Books\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Sing Along\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifySingAlongHomeScreenElementsTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifySingAlongHomeScreenElementsTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Scripture Stories Screen *********
    @Test
    public void VerifyScriptureStoriesScreenElementsClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifyScriptureStoriesScreenElementsClickTest.");
            //Click Scripture Stories button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Scripture Stories\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back button element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Scripture Stories text matches
            main.verifyTextContains("Scripture Stories", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old testament View container exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old testament icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Old Testament\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old Testament Title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Old Testament title text matches
            main.verifyTextContains("Old Testament", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old testament View container exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old testament icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"New Testament\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //New Testament Title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify New Testament title text matches
            main.verifyTextContains("New Testament", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old testament View container exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old testament icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Book of Mormon\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Book of Mormon Title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[3]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Book of Mormon title text matches
            main.verifyTextContains("Book of Mormon", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[3]/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old testament View container exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Old testament icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Doctrine and Covenants\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Doctrine and Covenants Title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[4]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Doctrine and Covenants title text matches
            main.verifyTextContains("Doctrine and Covenants", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ScrollView/android.view.View[4]/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifyScriptureStoriesScreenElementsClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifyScriptureStoriesScreenElementsClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Coloring Books Screen *********
    @Test
    public void VerifyColoringBooksScreenElementsClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifyColoringBooksScreenElementsClickTest.");
            Thread.sleep(milliseconds_1);
            //Swipe left
//            main.SwipeLeftByCoordinates(800, 1940, 500, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Coloring Books button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Coloring Books\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Toolbar exits
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //X/Close button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coming Soon title exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Coming Soon title text matches
            main.verifyTextContains("Coming Soon", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Coloring Books text matches
            main.verifyTextContains("Coloring Books", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[3]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifyColoringBooksScreenElementsClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifyColoringBooksScreenElementsClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Sing Along Screen *********
    @Test
    public void VerifySingAlongScreenElementsClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing VerifySingAlongScreenElementsClickTest.");
            Thread.sleep(milliseconds_1);
            //Swipe Left
            main.SwipeLeftByCoordinates(1050, 1940, 500, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Sing Along button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Sing Along\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Element exists
            main.assertElementExistsBy(main.WebElementsById(main.AndroidId("content")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back button icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Close\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along title exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Sing Along title text matches
            main.verifyTextContains("Sing Along", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scroll view container element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Hymns button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Hymns icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Hymns\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Hymns title exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Hymns title text matches
            main.verifyTextContains("Hymns", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Children's Songs button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Children's Songs icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Children's Songs\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Children's Songs title exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Children's Songs title text matches
            main.verifyTextContains("Children's Songs", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //PlayLists button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //PlayLists icon exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"PlayLists\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //PlayLists title exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify PlayLists title text matches
            main.verifyTextContains("PlayLists", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("VerifySingAlongScreenElementsClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("VerifySingAlongScreenElementsClickTest: \033[31mFailed\033[0m " + e);
        }
    }
/*      Temporarily removed from app

    //********** Scripture Stories Screen *********
    @Test
    public void ScriptureStoriesBackClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing ScriptureStoriesBackClickTest.");
            Thread.sleep(milliseconds_1);
            //Click Scripture Stories button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Scripture Stories\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Scripture Stories text matches
            main.verifyTextContains("Scripture Stories", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Back button Element exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Back button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Scripture Stories title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Scripture Stories text matches
            main.verifyTextContains("Scripture Stories", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("ScriptureStoriesBackClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("ScriptureStoriesBackClickTest: \033[31mFailed\033[0m " + e);
        }
    }
*/

    //********** Coloring Books Screen *********
    @Test
    public void ColoringBooksXClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing ColoringBooksXClickTest.");
            Thread.sleep(milliseconds_1);
            //Swipe Left
//            main.SwipeLeftByCoordinates(800, 1940, 500, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Coloring Books button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Coloring Books\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Coloring Books text exists
            main.verifyTextContains("Coloring Books", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[3]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //X/Close button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click X/Close button
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Coloring Books title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Coloring Books text matches
            main.verifyTextContains("Coloring Books", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[3]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("ColoringBooksXClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("ColoringBooksXClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    //********** Sing Along Screen *********
    @Test
    public void SingAlongBackClickTest() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing SingAlongXClickTest.");
            Thread.sleep(milliseconds_1);
            //Swipe Left
            main.SwipeLeftByCoordinates(1050, 1940, 500, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Sing Along button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Sing Along\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along title text exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Sing Along text matches
            main.verifyTextContains("Sing Along", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Close button exists
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Close\"]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Close button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Close\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Sing Along button exists
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Verify Sing Along text matches
            main.verifyTextContains("Sing Along", main.WebElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]"), false);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Passed Test Result
            System.out.println("SingAlongXClickTest: \033[32mPassed\033[0m");
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SingAlongXClickTest: \033[31mFailed\033[0m " + e);
        }
    }

    @Test
    public void ScriptureStoriesScreenRotationTest() throws InterruptedException {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            //Screen Rotation Test
            System.out.println("\033[34mScriptureStoriesScreenRotationTest starting .....\033[0m");
            main.countTestCases++;
            main.testsPassed++;
            //Test screen rotation
            main.performOrientation();
            //End Screen Rotation Test
            System.out.println("\033[34mScriptureStoriesScreenRotationTest ending .....\033[0m" + " " + "\033[32m" + "PASSED\033" +  "[0m");
            //Passed Test Result
            System.out.println("ScriptureStoriesScreen.RotationOrientationTest=True:" + " " + "\033[32m" + "PASSED\033" + "[0m");
            main.countTestCases++;
            main.testsPassed++;
            //Close
            main.driver.closeApp();
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("ScriptureStoriesScreen.RotationOrientationTest=True: \033[31mFailed\033[0m " + e);
            e.printStackTrace();
        }
    }

    @Test
    public void ColoringBooksScreenRotationTest() throws InterruptedException {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            //Screen Rotation Test
            System.out.println("\033[34mColoringBooksScreenRotationTest starting .....\033[0m" + " " + "\033[32m" + "PASSED\033"  + "[0m");
            Thread.sleep(milliseconds_1);
            //Swipe Left
//            main.SwipeLeftByCoordinates(800, 1940, 500, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Coloring Books button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Coloring Books\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Test screen rotation
            main.performOrientation();
            //End Screen Rotation Test
            System.out.println("\033[34mColoringBooksScreenRotationTest ending .....\033[0m" + " " + "\033[32m" + "PASSED\033" +  "[0m");
            //Passed Test Result
            System.out.println("ColoringBooksScreen.RotationOrientationTest=True:" + " " + "\033[32m" + "PASSED\033" + "[0m");
            main.countTestCases++;
            main.testsPassed++;
            //Close
            main.driver.closeApp();
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("ColoringBooksScreen.RotationOrientationTest=True: \033[31mFailed\033[0m " + e);
            e.printStackTrace();
        }
    }

    @Test
    public void SingAlongScreenRotationTest() throws InterruptedException {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            //Screen Rotation Test
            System.out.println("\033[34mSingAlongScreenRotationTest starting .....\033[0m" + " " + "\033[32m" + "PASSED\033"  + "[0m");
            Thread.sleep(milliseconds_1);
            //Swipe Left
            main.SwipeLeftByCoordinates(1050, 1940, 500, 1940);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Click Sing Along button
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Sing Along\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            //Test screen rotation
            main.performOrientation();
            //End Screen Rotation Test
            System.out.println("\033[34mSingAlongScreenRotationTest ending .....\033[0m" + " " + "\033[32m" + "PASSED\033" +  "[0m");
            //Passed Test Result
            System.out.println("SingAlongScreen.RotationOrientationTest=True:" + " " + "\033[32m" + "PASSED\033" + "[0m");
            main.countTestCases++;
            main.testsPassed++;
            //Close
            main.driver.closeApp();
        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SingAlongScreen.RotationOrientationTest=True: \033[31mFailed\033[0m " + e);
            e.printStackTrace();
        }
    }
}