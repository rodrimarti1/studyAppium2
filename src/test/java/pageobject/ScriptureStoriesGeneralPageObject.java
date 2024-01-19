package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtil;

import java.time.Duration;

public class ScriptureStoriesGeneralPageObject extends TestUtil {

    public ScriptureStoriesGeneralPageObject(ThreadLocal<AppiumDriver> driver){
        this.driver = driver;
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration),this);
    }

    @AndroidFindBy(accessibility = "Old Testament")
    public WebElement oldTestamentSection;

    @AndroidFindBy(accessibility = "New Testament")
    public WebElement newTestamentSection;

    @AndroidFindBy(accessibility = "Book of Mormon")
    public WebElement bookOfMormonSection;

    @AndroidFindBy(accessibility = "Doctrine and Covenants")
    public WebElement doctrineAndCovenantsSection;
}
