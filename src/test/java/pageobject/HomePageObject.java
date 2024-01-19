package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.CommonFunctions;
import utility.TestUtil;

import java.time.Duration;

public class HomePageObject extends TestUtil {

    public HomePageObject(ThreadLocal<AppiumDriver> driver){
        this.driver = driver;
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration),this);
    }

    CommonFunctions commonFunctions= new CommonFunctions();
    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));

    //Objects in home page
    @AndroidFindBy(className = "android.widget.TextView")
    public WebElement titleHead;

    @AndroidFindBy(accessibility = "Settings")
    public WebElement settingGearButton;

    @AndroidFindBy(xpath = "//android.view.View/android.view.View[2]/android.view.View[1]")
    public WebElement scriptureStoriesOptionMenu;

    @AndroidFindBy(xpath = "//android.view.View/android.view.View[2]/android.view.View[2]")
    public WebElement othersOptionMenu;

    //Functions in home page
    public void swipeToOptionMenu(String optionMenu){
        commonFunctions.swipeRightFunction();
        wait.until(ExpectedConditions.attributeContains(titleHead,"text", "Scripture Stories"));
        boolean flag = true;
        do{
            if (!titleHead.getText().equals(optionMenu)){
                commonFunctions.swipeLeftFunction();
            }
            else{
                flag = false;
            }
        }while(flag);
    }

    public void tapToTheOptionMenu(String optionMenu){
        if(optionMenu.equals("Scripture Stories")){
            scriptureStoriesOptionMenu.click();
        }else{
            othersOptionMenu.click();
        }
    }
}
