package UI;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static UI.EnvironmentConfig.*;
//import static org.openqa.selenium.server.RobotRetriever.getRobot;


public class GospelForKids {
    //AppiumDriver driver;
    static mainFunctions main;

    public AppiumDriverLocalService service;
    static Timestamp startTime = new Timestamp(System.currentTimeMillis());
    //Date startTime = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    boolean msg;
    String msgStr;

    @Before
    public void setUp() throws Exception {
        Thread.sleep(milliseconds_2);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("platformVersion", "13.0");
        //capabilities.setCapability("deviceName", "Android Device");
        // capabilities.setCapability("deviceName", "Galaxy S8");
        //capabilities.setCapability("deviceName", "Android Emulator");
        //capabilities.setCapability("deviceName", "Android SDK built for x86");
        //capabilities.setCapability("app", System.getProperty("user.dir") + "/APK/app-alpha.apk");
        //capabilities.setCapability("automationName", "UiAutomator2");
        //System.out.println(System.getProperty("user.dir") + "/APK/app-alpha.apk");
        //capabilities.setCapability("chromedriverExecutableDir", System.getProperty("user.dir") + "/ChromeDriver/");
        //capabilities.setCapability("browserName", "Chrome");

        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/APK/app-alpha.apk");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("newCommandTimeout", 5000);

        main = new mainFunctions();

        main.driver = new AndroidDriver(new URL("http://127.0.0.1:" + theAppiumPort + "/"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        main.driver.close();
        main.driver.quit();
    }

    @AfterClass
    public static void TestsSummary() throws InterruptedException {
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
       // System.out.println("\033[35mApp Apk:\033[0m" + " " + "\033[35m" + main.driver.getCapabilities().getCapability("app").toString() + "\033[0m");
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
        long second = (lNano / 60) % 100000;
        long lSecond = (second / 1000) % 60;
        long minute = sum - nano - second;
        long lMinute = ((minute / 100000) / 60) % 60;
        long hour = sum - nano - second - minute;
        long lHour = (hour / 60) % 24;
        String time = (String.format("%02d:%02d:%02d.%03d", lHour, lMinute, lSecond, nano));
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


    //passed''
    @Test
    public void ColoringBook() throws Exception {
        try {
            System.out.println("Testing Coloring Book");
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            // Finding and opening coloring book screen
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[2]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;//main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.widget.TextView"));

//            Coloring Book Heading

            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.widget.TextView"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            // Tapping on Old Testament book
            System.out.print(" Verifying the Old Testament Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            System.out.print(" Verifying the New Testament Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            System.out.print(" Verifying the Book of Mormon Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;
            System.out.print(" Verifying the Doctinie and Covenant Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Pearl of the great price Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Gathering the Family of Good Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[6]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;


            main.scrollDown();
            System.out.print(" Verifying the Old Testament Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[7]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the New Testament Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[8]/android.view.View"));
            main.scrollDown();
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Book of Mormon Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Church History Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Article of faith Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Gospel Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[6]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            main.scrollDown();

            System.out.print(" Verifying the Parables Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Proclamation of The World Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Love the neighbour Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Chrismas Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[6]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            main.scrollDown();
            System.out.print(" Verifying the Service Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Missionaries Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Heavenly Father Creation Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the Nativity Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[6]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            main.scrollDown();
            System.out.print(" Verifying the Bible Virtue Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;


            System.out.print(" Verify if Music button exist");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;


            System.out.print(" Verify if back button exist and work  exist");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button"));
            //main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Back\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify if back button exist and work  exist");
            //main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button"));
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Back\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.println("launchTest: \033[32mPassed\033[0m");

        } catch (Exception e) {
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("launchTest: \033[31mFailed\033[0m " + e);//       }
        }


    }



    @Test
    public void ColoringBookMusicSetting() throws Exception {
        try {
            System.out.println("Testing Coloring Book");
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            // Finding and opening coloring book screen
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify if Music button exist and work ");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button"));
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Play music\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify the content in Sound setting in coloring book");
            System.out.print(" Verifying the  popup for sound setting");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the  Sound heading in sound popup");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the  Background Sub-Sound heading in sound popup");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying if there is slide bar to set background music");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.SeekBar[1]  "));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying if there is slide bar is working for background music");
            main.SwipeRightByCoordinates(161, 1380, 549, 1370);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the  Sound effect Sub-Sound heading in sound popup");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying if there is slide bar is working for Sound effect slide bar");
            main.SwipeRightByCoordinates(158, 1668, 627, 1663);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify if Done button exist and work ");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView[2]"));
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView[2]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;


            System.out.println("launchTest: \033[32mPassed\033[0m");

        } catch (Exception e) {
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("launchTest: \033[31mFailed\033[0m " + e);//       }
        }


    }



    //Opening coloring page and testing coloring page items
    @Test
    public void OpenColoringPageAndVerifyItems() throws Exception {
        try {
            System.out.println("Testing Coloring Book");
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            // Finding and opening coloring book screen
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;


            System.out.print(" Verifying the downloaded Old Testament Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]"));
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]");
            Thread.sleep(20000);
            main.countTestCases++;
            main.testsPassed++;


            System.out.print(" Verifying the downloaded Old Testament Book is opening");
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View");
            main.countTestCases++;
            main.testsPassed++;

            //verifying coloring pages screen
            System.out.print(" Verifying the page heading in a Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView"));
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify if Music button exist and work ");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button"));
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"Play music\"]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify the content in Sound setting in coloring book");
            System.out.print(" Verifying the  popup for sound setting");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the  Sound heading in sound popup");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the  Background Sub heading in sound popup");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView[3]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying if there is slide bar to set background music");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.SeekBar[1]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying if there is slide bar is working for background music");
            main.SwipeRightByCoordinates(161, 1380, 549, 1370);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the  Sound effect Sub heading in sound popup");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView[4]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying if there is slide bar is working for Sound effect slide bar");
            main.SwipeRightByCoordinates(158, 1668, 627, 1663);
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify if Done button exist and work ");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView[2]"));
            Thread.sleep(milliseconds_1);
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView[2]");
            main.countTestCases++;
            main.testsPassed++;


            System.out.print(" Verify if More options button ");
            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"More options\"]"));
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"More options\"]");
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify the more option button drop down reset option ");
            main.ClickUIElementByXpath("//android.view.View[@content-desc=\"More options\"]");
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify the reset button exist and working ");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View"));
            main.ClickUIElementByXpath("/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.TextView");
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verify if reset confirmation popup appear ");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View"));
            //Verify confirmation popup information
            //Question
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]"));
            //Detail of question
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.TextView[2]"));

            main.countTestCases++;
            main.testsPassed++;


            System.out.print(" Verify cancel button and ok button ");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View"));
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"));
            main.countTestCases++;
            main.testsPassed++;

            //Verify ok button working

            System.out.print(" Verify and click ok button");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"));
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
            main.countTestCases++;
            main.testsPassed++;


        } catch (Exception e) {
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("launchTest: \033[31mFailed\033[0m " + e);//       }
        }


    }



    @Test
    public void VerifyColoringPageAndVerifyItems() throws Exception {
        try {
            System.out.println("Testing Coloring Book");
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            // Finding and opening coloring book screen
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]"));
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");
            Thread.sleep(milliseconds_1);
            main.countTestCases++;
            main.testsPassed++;

            System.out.print(" Verifying the downloaded Old Testament Book");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]"));
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]");
            Thread.sleep(20000);
            main.countTestCases++;
            main.testsPassed++;


            System.out.println("verify coloring page ");
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]");

            //Verify back button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button"));
            main.ClickUIElementByXpath("/android.view.View[@content-desc=\"Back\"]");

           //Open page again
            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]");

            //Verify Page heading
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.widget.TextView"));

            //verify share button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]"));

            //Verify music button
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View[3]/android.widget.Button"));

            main.countTestCases++;
            main.testsPassed++;

            // Verify Crayons
            System.out.println("verifying Crayons existance");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[2]"));

            //verify toolbar anf its content
            System.out.println("verifying toolbar and its contents ");
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.HorizontalScrollView]"));

            //Verifying magnifier availability
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.HorizontalScrollView/android.view.View[1]/android.widget.Button"));

            //Verifying undo availability
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.HorizontalScrollView/android.view.View[2]/android.widget.Button"));

            //Verifying redo availability
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.HorizontalScrollView/android.view.View[3]/android.widget.Button"));

            //Verifying clear color availability
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.HorizontalScrollView/android.view.View[4]/android.widget.Button"));

            //erify coloring tool
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.HorizontalScrollView/android.view.View[5]"));

            main.countTestCases++;
            main.testsPassed++;

        }
        catch (Exception e) {
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("launchTest: \033[31mFailed\033[0m " + e);//

             }
        }































            //********** Swipe right from  Coloring Books Screen to Scripture Stories *********



            @Test
            public void SwipeLeftOpenScriptureStories() throws Exception {
                try {
                    //Wait for Splash Screen to display and dismiss
                    main.SplashScreenWait();
                    main.countTestCases++;
                    main.testsPassed++;
                    //Test Start
                    System.out.println("Testing Swipe Left To SS from CB.");
                    //Swipe Left
                    main.SwipeLeftByCoordinates(526, 1632, 901, 1642);
                    main.countTestCases++;
                    main.testsPassed++;


                    //Scripture story button exists
                    System.out.println("verify Scripture stories button");
                            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]"));
                    Thread.sleep(milliseconds_1);
                            main.countTestCases++;
                            main.testsPassed++;

                    //Open Scripture stiory
                    System.out.println("verify Scripture stories opens");
                            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]");
                    Thread.sleep(milliseconds_1);
                            main.countTestCases++;
                            main.testsPassed++;


                    //Verify Scripture story screen content
                    System.out.println("Verify Scripture story screen content");

                    //verify theme colored header
                    System.out.println("Verify the header is displayed");
                            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]"));
                            main.countTestCases++;
                            main.testsPassed++;
                    // verify old testament Logo and title
                    System.out.println("verify old testament Logo exist ");

                    main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Old Testament\"]"));
                    System.out.println(" verify old testament Title exist" );
                            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView"));
                    main.countTestCases++;
                    main.testsPassed++;
                    //Verify New Testament Logo and its Title
                    System.out.println("verify new testament Logo exist ");
                            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"New Testament\"]"));
                    main.countTestCases++;
                    main.testsPassed++;
                    System.out.println(" verify New testament Title exist" );
                            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView"));
                    main.countTestCases++;
                    main.testsPassed++;
                    //Verify Book of Mormon Logo and its Title
                    System.out.println("verify Book of Mormon Logo exist ");
                            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Book of Mormon\"]"));
                    main.countTestCases++;
                    main.testsPassed++;
                    System.out.println("verify Book of Mormon title exist ");
                            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.widget.TextView"));
                    main.countTestCases++;
                    main.testsPassed++;
                    //Verify Doctrine and Covenants Logo and Title

                    System.out.println(" Verify if Doctrine and Covenants Logo exist");
                            main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Book of Mormon\"]"));
                    main.countTestCases++;
                    main.testsPassed++;
                    System.out.println(" Verify if Doctrine and Covenants title exist ");
                            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.widget.TextView"));
                    main.countTestCases++;
                    main.testsPassed++;


                } catch (Exception e) {
                    //Failed Test Result
                    main.countTestCases++;
                    main.testsFailed++;
                    System.out.println("SwipeLeftToSAScreenFromSSTest and opened Singalong: \033[31mFailed\033[0m " + e);
                }
            }



    @Test
    public void ScriptureStoriesOldTestamentScreen() throws Exception {
        try {
            //Wait for Splash Screen to display and dismiss
            main.SplashScreenWait();
            main.countTestCases++;
            main.testsPassed++;
            //Test Start
            System.out.println("Testing Swipe Left To SS from CB.");
            //Swipe Left
                main.SwipeLeftByCoordinates(526, 1632, 901, 1642);
                    main.countTestCases++;
                    main.testsPassed++;


            //Scripture story button exists
            System.out.println("verify Scripture stories button");
                main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]"));
                    Thread.sleep(milliseconds_1);
                    main.countTestCases++;
                    main.testsPassed++;

            //Open Scripture stiory
            System.out.println("verify Scripture stories opens");
                main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]");
                    Thread.sleep(milliseconds_1);
                    main.countTestCases++;
                    main.testsPassed++;

            System.out.println("verify if Old Testmant exist and open and verify content ");
                main.assertElementExistsBy(main.WebElementsByXpath("//android.view.View[@content-desc=\"Old Testament\"]"));

            System.out.println(" verify old testament Title exist" );
                main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView"));
                    main.countTestCases++;
                    main.testsPassed++;


            System.out.println("Opening Old testament");
                main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]");
                    main.countTestCases++;
                    main.testsPassed++;

            System.out.println(" verify the Olt testement page content" );

            System.out.println(" verify the Olt testement heading" );
                main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView"));
                    main.countTestCases++;
                    main.testsPassed++;

            System.out.println(" verify if user can tap and download a item " );
                main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView"));
                main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]");
                Thread.sleep(40000);
                    main.countTestCases++;
                    main.testsPassed++;


            main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]");
            main.countTestCases++;
            main.testsPassed++;














        } catch (Exception e) {
            //Failed Test Result
            main.countTestCases++;
            main.testsFailed++;
            System.out.println("SwipeLeftToSAScreenFromSSTest and opened Singalong: \033[31mFailed\033[0m " + e);
        }
    }










    //********** Swipe Right from Coloring Books  to Scripture Stories *********
            @Test
            public void SwipeRightToSSScreenFromCBTest () throws Exception {
                try {
                    //Wait for Splash Screen to display and dismiss
                    main.SplashScreenWait();
                    main.countTestCases++;
                    main.testsPassed++;

                    //Test Start
                    System.out.println("Testing SwipeRightToSSScreenFromCBTest.");

                    main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]"));
                    Thread.sleep(milliseconds_1);
                    main.countTestCases++;
                    main.testsPassed++;


                    main.SwipeRightByScreenSize();
                    main.countTestCases++;
                    main.testsPassed++;
                    //Scripture Stories button exists
                    main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]"));
                    Thread.sleep(milliseconds_1);
                    main.countTestCases++;
                    main.testsPassed++;
                    //Scripture Stories icon exists
                    main.ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]");
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
            public void SwipeRightToCBScreenFromSATest () throws Exception {
                try {
                    //Wait for Splash Screen to display and dismiss
                    main.SplashScreenWait();
                    main.countTestCases++;
                    main.testsPassed++;
                    //Test Start
                    System.out.println("Testing SwipeRightToCBScreenFromSATest.");
                    //Swipe Left
                    main.SwipeLeftByScreenSize();
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
                    ;
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
                    main.testsPassed++;
                    ;
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
            public void SwipeRightToSSScreenFromSATest () throws Exception {
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

            //********** Sing Along Home Screen *********
            @Test
            public void VerifySingAlongHomeScreenElementsTest () throws Exception {
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
            public void VerifyScriptureStoriesScreenElementsClickTest () throws Exception {
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
            public void VerifyColoringBooksScreenElementsClickTest () throws Exception {
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
            public void VerifySingAlongScreenElementsClickTest () throws Exception {
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
            public void ColoringBooksXClickTest () throws Exception {
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
            public void SingAlongBackClickTest () throws Exception {
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
            public void ScriptureStoriesScreenRotationTest () throws InterruptedException {
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
                    System.out.println("\033[34mScriptureStoriesScreenRotationTest ending .....\033[0m" + " " + "\033[32m" + "PASSED\033" + "[0m");
                    //Passed Test Result
                    System.out.println("ScriptureStoriesScreen.RotationOrientationTest=True:" + " " + "\033[32m" + "PASSED\033" + "[0m");
                    main.countTestCases++;
                    main.testsPassed++;
                    //Close
                    main.driver.close();
                } catch (Exception e) {
                    //Failed Test Result
                    main.countTestCases++;
                    main.testsFailed++;
                    System.out.println("ScriptureStoriesScreen.RotationOrientationTest=True: \033[31mFailed\033[0m " + e);
                    e.printStackTrace();
                }
            }

            @Test
            public void ColoringBooksScreenRotationTest () throws InterruptedException {
                try {
                    //Wait for Splash Screen to display and dismiss
                    main.SplashScreenWait();
                    main.countTestCases++;
                    main.testsPassed++;
                    //Test Start
                    //Screen Rotation Test
                    System.out.println("\033[34mColoringBooksScreenRotationTest starting .....\033[0m" + " " + "\033[32m" + "PASSED\033" + "[0m");
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
                    System.out.println("\033[34mColoringBooksScreenRotationTest ending .....\033[0m" + " " + "\033[32m" + "PASSED\033" + "[0m");
                    //Passed Test Result
                    System.out.println("ColoringBooksScreen.RotationOrientationTest=True:" + " " + "\033[32m" + "PASSED\033" + "[0m");
                    main.countTestCases++;
                    main.testsPassed++;
                    //Close
                    main.driver.close();
                } catch (Exception e) {
                    //Failed Test Result
                    main.countTestCases++;
                    main.testsFailed++;
                    System.out.println("ColoringBooksScreen.RotationOrientationTest=True: \033[31mFailed\033[0m " + e);
                    e.printStackTrace();
                }
            }

            @Test
            public void SingAlongScreenRotationTest () throws InterruptedException {
                try {
                    //Wait for Splash Screen to display and dismiss
                    main.SplashScreenWait();
                    main.countTestCases++;
                    main.testsPassed++;
                    //Test Start
                    //Screen Rotation Test
                    System.out.println("\033[34mSingAlongScreenRotationTest starting .....\033[0m" + " " + "\033[32m" + "PASSED\033" + "[0m");
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
                    System.out.println("\033[34mSingAlongScreenRotationTest ending .....\033[0m" + " " + "\033[32m" + "PASSED\033" + "[0m");
                    //Passed Test Result
                    System.out.println("SingAlongScreen.RotationOrientationTest=True:" + " " + "\033[32m" + "PASSED\033" + "[0m");
                    main.countTestCases++;
                    main.testsPassed++;
                    //Close
                    main.driver.close();
                } catch (Exception e) {
                    //Failed Test Result
                    main.countTestCases++;
                    main.testsFailed++;
                    System.out.println("SingAlongScreen.RotationOrientationTest=True: \033[31mFailed\033[0m " + e);
                    e.printStackTrace();
                }
            }
        }

