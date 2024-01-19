package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.ScriptureStoriesGeneralPageObject;
import utility.CommonObject;
import utility.TestUtil;

import java.time.Duration;
import static org.testng.Assert.*;

public class ScriptureStoriesSteps extends TestUtil {

    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(15));
    ScriptureStoriesGeneralPageObject scriptureStoriesGeneralPageObject = new ScriptureStoriesGeneralPageObject(driver);
    CommonObject commonObject = new CommonObject(driver);

    @And("validate the Old Testament is displayed")
    public void validateTheOldTestamentIsDisplayed() {
        assertTrue(scriptureStoriesGeneralPageObject.oldTestamentSection.isDisplayed());
    }

    @And("validate the New Testament is displayed")
    public void validateTheNewTestamentIsDisplayed() {
        assertTrue(scriptureStoriesGeneralPageObject.newTestamentSection.isDisplayed());
    }

    @And("validate the Book of Mormon is displayed")
    public void validateTheBookOfMormonIsDisplayed() {
        assertTrue(scriptureStoriesGeneralPageObject.bookOfMormonSection.isDisplayed());
    }

    @And("validate the Doctrine and Covenants is displayed")
    public void validateTheDoctrineAndCovenantsIsDisplayed() {
        assertTrue(scriptureStoriesGeneralPageObject.doctrineAndCovenantsSection.isDisplayed());
    }

    @Then("validate the {string} title is displayed")
    public void validateTheTitleIsDisplayed(String titleValue) {
        assertEquals(commonObject.scriptureStoriesAndBooksTitle.getText(), titleValue, "The "+titleValue+" is not displayed on the screen.");
    }
}
