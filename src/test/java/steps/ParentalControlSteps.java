package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.HomePageObject;
import pageobject.ParentalControlPageObject;
import utility.CommonFunctions;
import utility.TestUtil;

import java.time.Duration;
import static org.testng.Assert.*;

public class ParentalControlSteps extends TestUtil {

    ParentalControlPageObject parentalControlPageObject = new ParentalControlPageObject(driver);
    HomePageObject homePageObject = new HomePageObject(driver);
    CommonFunctions commonFunctions = new CommonFunctions();
    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));
    @Then("open the parental control page")
    public void openTheParentalControlPage() {
        homePageObject.settingGearButton.click();
    }

    @And("resolve the operation to open setting page")
    public void resolveTheOperationToOpenSettingPage() {
        parentalControlPageObject.resolveTheOperation();
    }

    @Then("click on the {string} button")
    public void clickOnTheButton(String buttonValue) {
        commonFunctions.findElementByText(buttonValue);
    }

    @Then("validate the {string} label is displayed")
    public void validateTheLabelIsDisplayed(String labelValue) {
        wait.until(ExpectedConditions.visibilityOf(parentalControlPageObject.settingOptionLabel));
        assertEquals(parentalControlPageObject.settingOptionLabel.getText(), labelValue);
    }

    @And("select {string} as a number")
    public void selectAsANumber(String numberValue) {
        commonFunctions.findElementByText(numberValue).click();
    }

    @Then("validate the {string} error message is displayed")
    public void validateTheErrorMessageIsDisplayed(String messageErrorValue) {
        assertEquals(parentalControlPageObject.errorMessage.getText(), messageErrorValue, "Error message is not equals");
    }
}
