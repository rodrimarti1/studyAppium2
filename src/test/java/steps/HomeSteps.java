package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.HomePageObject;
import utility.CommonFunctions;
import utility.TestUtil;

import java.time.Duration;

import static org.testng.Assert.*;

public class HomeSteps extends TestUtil {

    CommonFunctions commonFunctions= new CommonFunctions();
    HomePageObject homePageObject = new HomePageObject(driver);
    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));

    @Then("Validate that name {string} is displayed on the screen")
    public void validateThatNameIsDisplayedOnTheScreen(String titleLabel) {
        wait.until(ExpectedConditions.textToBePresentInElement(homePageObject.titleHead, titleLabel));
        String actualTitle = homePageObject.titleHead.getText();
        assertEquals(actualTitle, titleLabel,"The title is not equals to selected feature on the home page");
    }

    @Then("Validate the Setting button is displayed")
    public void validateTheSettingButtonIsDisplayed() {
        assertTrue(homePageObject.settingGearButton.isDisplayed(), "The setting button is hidden or the home page not load correctly");
    }

    @And("swipe and open the {string} option")
    public void swipeAndOpenTheOption(String menuValue) {
        homePageObject.swipeToOptionMenu(menuValue);
        homePageObject.tapToTheOptionMenu(menuValue);
    }
}
