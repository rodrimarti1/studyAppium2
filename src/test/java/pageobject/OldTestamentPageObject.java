package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtil;

import java.time.Duration;

public class OldTestamentPageObject extends TestUtil {

    public OldTestamentPageObject(ThreadLocal<AppiumDriver> driver){
        this.driver = driver;
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration),this);
    }

    @AndroidFindBy(className = "android.widget.ProgressBar")
    public WebElement progressBar;



    
}
