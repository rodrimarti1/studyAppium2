package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtil;

import java.time.Duration;

public class SettingPageObject extends TestUtil {

    public SettingPageObject(ThreadLocal<AppiumDriver> driver){
        this.driver = driver;
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration),this);
    }

    @AndroidFindBy(xpath = "//android.view.View/android.view.View[1]/android.widget.TextView")
    public WebElement settingTitle;
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.TextView[2]")
    public WebElement languageTitle;
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ScrollView/android.widget.TextView[3]")
    public WebElement additionalInfoTitle;
}
