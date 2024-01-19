package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CommonObject extends TestUtil{

    public CommonObject(ThreadLocal<AppiumDriver> driver){
        this.driver = driver;
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration),this);
    }

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public WebElement toastMessage;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Back\"]")
    public WebElement backButton;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView")
    public WebElement scriptureStoriesAndBooksTitle;
}
