package UI;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

import static UI.EnvironmentConfig.milliseconds_1;

public class Functions {

    private static final String APP = "/Users/crossfitpt/gospellibraryappiumtestsandroid/APK/gospel-library-alpha.apk";
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

    public void SplashScreenWait() throws Exception {
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
        catch (Exception ign) {}
    }

}
