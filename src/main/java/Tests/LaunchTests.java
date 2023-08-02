package Tests;

import UI.Functions;
import UI.mainFunctions;
import org.junit.After;
import org.junit.Before;

public class LaunchTests extends mainFunctions {
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

    //@Test
    public void launchTest() throws Exception {
        try {
            main.SplashScreenWait();
            System.out.println("Testing launchTest.");
            main.assertElementExistsBy(main.WebElementsById(main.AppId("homeImage")));
            //System.out.println(main.driver.getContextHandles());
            System.out.println("launchTest: \033[32mPassed\033[0m");
        }
        catch (Exception e) {
            System.out.println("launchTest: \033[31mFailed\033[0m " + e);
        }
    }
}
