package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SettingPageObject;
import utility.CommonFunctions;
import utility.TestUtil;

import java.time.Duration;
import static org.testng.Assert.*;

public class SettingSteps extends TestUtil {

    SettingPageObject settingPageObject = new SettingPageObject(driver);
    CommonFunctions commonFunctions = new CommonFunctions();
    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));

    @Then("validate the setting title is displayed")
    public void validateTheSettingTitleIsDisplayed() {
        assertTrue(settingPageObject.settingTitle.isDisplayed());
    }
}
