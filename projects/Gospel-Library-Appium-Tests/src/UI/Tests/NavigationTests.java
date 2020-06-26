package UI.Tests;

import UI.Functions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NavigationTests {

    private Functions functions = new Functions();

    @Before
    public void setUp() throws Exception {
        functions.setUp();
    }

    @After
    public void tearDown() throws Exception {
        functions.tearDown();
    }

    //Deep Links

    @Test
    public void contentNotInstalledTest() throws Exception {
        //If English BOM is installed removed it
        //In the Safari App on your device
        //Confirm donwload to Alma 60:1 succeeds
    }
}
