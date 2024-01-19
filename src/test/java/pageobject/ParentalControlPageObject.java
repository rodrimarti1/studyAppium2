package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.CommonFunctions;
import utility.TestUtil;

import java.time.Duration;

public class ParentalControlPageObject extends TestUtil {

    public ParentalControlPageObject(ThreadLocal<AppiumDriver> driver){
        this.driver = driver;
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration),this);
    }
    CommonFunctions commonFunctions = new CommonFunctions();

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.TextView[3]")
    public WebElement operation;
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.TextView")
    public WebElement settingOptionLabel;
    @AndroidFindBy(accessibility = "Close")
    public WebElement closeButton;
    @AndroidFindBy(xpath = "android.widget.ScrollView/android.widget.TextView[2]")
    public WebElement errorMessage;

    public void resolveTheOperation(){
        String valuesOfOperation = operation.getText().replaceAll(" ", "");
        String numberOne = valuesOfOperation.substring(0,1);
        String numberTwo = valuesOfOperation.substring(2,3);

        int resultOperation = Integer.parseInt(numberOne) * Integer.parseInt(numberTwo);
        String resultNumberOne = Integer.toString(resultOperation).substring(0,1);
        String resultNumberTwo = Integer.toString(resultOperation).substring(1,2);

        commonFunctions.findElementByText(resultNumberOne).click();
        commonFunctions.findElementByText(resultNumberTwo).click();
    }

}
