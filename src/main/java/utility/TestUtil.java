package utility;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@CucumberOptions()
public class TestUtil extends AbstractTestNGCucumberTests {

    public AppiumDriverLocalService service;
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    @Parameters({"appInformation", "deviceName"})
    public void appiumServerConnector(String appInformation, String deviceName) throws MalformedURLException {

        service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//alvaromartinez//.nvm//versions//node//v21.1.0//bin//appium"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();

        service.start();
        appiumOptionToConnect(appInformation, deviceName);
    }

    public void appiumOptionToConnect(String appInformation, String deviceName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("app", appInformation);
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("appium:disableIdLocatorAutocompletion", true);
        capabilities.setCapability("fullReset", false);

        driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @AfterMethod
    public void appiumCloseDriverConnection(){
        driver.get().quit();
        service.stop();
    }
}
