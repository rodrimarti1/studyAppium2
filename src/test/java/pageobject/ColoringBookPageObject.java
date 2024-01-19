package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtil;

import java.time.Duration;

public class ColoringBookPageObject extends TestUtil {
    public ColoringBookPageObject(ThreadLocal<AppiumDriver> driver){
        this.driver = driver;
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration),this);
    }

    @AndroidFindBy(xpath = "//android.view.View/android.view.View[1]/android.widget.TextView")
    public WebElement coloringBookHeading;

    @AndroidFindBy(accessibility = "Play music")
    public WebElement playMusicButton;
}
