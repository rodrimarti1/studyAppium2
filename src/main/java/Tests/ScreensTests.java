package Tests;

import UI.Functions;
import UI.mainFunctions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static UI.EnvironmentConfig.milliseconds_1;

public class ScreensTests extends UI.GospelForKids {
    mainFunctions main;

    private Functions functions = new Functions();

    @Before
    public void setUp() throws Exception {
        functions.setUp();
    }

    @After
    public void tearDown() throws Exception {
        functions.tearDown();
    }

    @Test
    public void VerifyHomeScreenElementsTest() throws Exception {
        try {
            main.SplashScreenWait();
            System.out.println("Testing VerifyLoginScreenElementsTest.");
            main.assertElementExistsBy(main.WebElementsById(main.AppId("action_bar_root")));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsById(main.FindElementByID("content")));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsById(main.AppId("toolbar")));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsById(main.AppId("menu_item_settings")));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsById(main.AppId("homeImage")));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsById(main.AppId("homeChapel")));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsById(main.AppId("textTitle")));
            Thread.sleep(milliseconds_1);
            main.verifyTextContains("Scripture Stories", main.WebElementById(main.AppId("textTitle")), false);
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsById(main.AppId("viewPager")));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView"));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView"));
            Thread.sleep(milliseconds_1);
            main.assertElementExistsBy(main.WebElementsByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.ImageView"));
            Thread.sleep(milliseconds_1);
            System.out.println("VerifyHomeScreenElementsTest: \033[32mPassed\033[0m");
        }
        catch (Exception e) {
            System.out.println("VerifyHomeScreenElementsTest: \033[31mFailed\033[0m " + e);
        }
    }
}
