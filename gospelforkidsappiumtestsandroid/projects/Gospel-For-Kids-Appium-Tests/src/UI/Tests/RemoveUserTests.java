package UI.Tests;

import UI.Functions;
import java.net.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;

public class RemoveUserTests {

    public static void main(String[] args) throws MalformedURLException {

        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/jnknielsen/qa-justserve-android/gospelforkidsappiumtestsandroid/ChromeDriver/chromedriver.exe");

        //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Deleting all the cookies
        driver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //launching the specified URL
        driver.get("https://stage.justserve.org/");

        driver.quit();
    }
}
