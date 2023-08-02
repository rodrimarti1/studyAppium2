package UI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static UI.EnvironmentConfig.milliseconds_1;

public class Functions {

    private static final String APP = "/Users/jnknielsen/qa-gospelforkids-android/gospelforkidsappiumtestsandroid/APK/gospel-for-kids-alpha.apk";
    private static final String APPIUM = "http://localhost:4723/wd/hub";
    private AppiumDriver driver;

    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "Android Device");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("app", System.getProperty("user.dir") + "/APK/app-alpha.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
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
            Boolean isPresent = driver.findElements(By.xpath("//android.widget.ProgressBar")).size() > 0;
            while (isPresent) {
                System.out.println("On Splash Screen… Waiting " + milliseconds_1 / 2 + " milliseconds");
                Thread.sleep(milliseconds_1 / 2);
                isPresent = driver.findElements(By.xpath("//android.widget.ProgressBar")).size() > 0;
            }
            System.out.println("Continuing Test…");
        }
        catch (Exception ign) {}
    }

}
