package utility;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CommonFunctions extends TestUtil{

    public String editInformationValue(String changeValue) {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyMMdd"));
        String newValue = changeValue+today;
        return newValue;
    }

    public WebElement findElementByText(String textToLocated) {
        return driver.get().findElement(By.xpath("//android.widget.TextView[@text='"+textToLocated+"']"));
    }

    public String getSourceOfPage() throws Exception {
        String myString;
        Thread.sleep(2000);
        myString = driver.get().getPageSource();
        return myString;
    }
    public boolean newScrollDownSlow() {
        boolean canScrollMore;
        Dimension deviceSize = driver.get().manage().window().getSize();
        int deviceWidth = deviceSize.getWidth();
        int deviceHeight = deviceSize.getHeight();
        int left = deviceWidth / 5;
        int top = deviceHeight / 5;
        int width = 1;
        int height = deviceHeight / 3;
        canScrollMore = (Boolean) ((JavascriptExecutor) driver.get()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", left, "top", top, "width", width, "height", height,
                "direction", "down",
                "percent", 1.0,
                "speed", 600
        ));
        return canScrollMore;
    }

    public void newScrollToText(String myText) throws Exception {
        String pageSource;
        boolean textCheck = false;
        int myCounter = 1;
        {
            do {
                pageSource = getSourceOfPage();
                textCheck = pageSource.contains(myText);
                if (!textCheck) {
                    newScrollDownSlow();
                }
                if (myCounter > 9) {
                    textCheck = true;
                    System.out.println("TEXT: " + myText + " Not Found!");
                }
                myCounter++;
            } while (!textCheck);
        }
    }

    public void totalScrollDown(){
        boolean canScrollMore;
        Dimension deviceSize = driver.get().manage().window().getSize();
        int deviceWidth = deviceSize.getWidth();
        int deviceHeight = deviceSize.getHeight();
        int left = deviceWidth / 5;
        int top = deviceHeight / 5;
        int width = 1;
        int height = deviceHeight / 3;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver.get()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top, "width", width, "height", height,
                    "direction", "down",
                    "percent", 1.0,
                    "speed", 600
            ));
        }while (canScrollMore);
    }

    public void swipeRightFunction() {
        Dimension deviceSize = driver.get().manage().window().getSize();
        int deviceWidth = deviceSize.getWidth();
        int deviceHeight = deviceSize.getHeight();
        System.out.println("deviceheight" + deviceHeight);
        System.out.println("devicewidth" + deviceWidth);
        int fromX = deviceWidth / 2;
        int fromY = deviceHeight - 100;
        int toX = deviceWidth / 2 + 400;
        int toY = deviceHeight - 100;
        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(fromX, fromY);
        Point end = new Point (toX, toY);
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                start.getX(),
                                start.getY()))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(890),
                                PointerInput.Origin.viewport(),
                                end.getX(),
                                end.getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.get().perform(Arrays.asList(swipe));
    }

    public void swipeLeftFunction() {
        Dimension deviceSize = driver.get().manage().window().getSize();
        int deviceWidth = deviceSize.getWidth();
        int deviceHeight = deviceSize.getHeight();
        System.out.println("deviceheight" + deviceHeight);
        System.out.println("devicewidth" + deviceWidth);
        int fromX = deviceWidth / 2;
        int fromY = deviceHeight - 100;
        int toX = 50;
        int toY = deviceHeight - 100;
        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(fromX, fromY);
        Point end = new Point (toX, toY);
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                start.getX(),
                                start.getY()))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(890),
                                PointerInput.Origin.viewport(),
                                end.getX(),
                                end.getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.get().perform(Arrays.asList(swipe));
    }

}
