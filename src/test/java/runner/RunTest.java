package runner;

import io.cucumber.testng.CucumberOptions;
import utility.TestUtil;

@CucumberOptions(
        features= {"src/test/java/features"},
        glue={"steps"},
        tags = "@test",
        plugin = {
                "pretty",
                "html:src/test/java/Reports/cucumber-reports/cucumber-pretty.html",
                "json:src/test/java/Reports/cucumber-reports/CucumberTestReport.json",
                "junit:src/test/java/Reports/cucumber-reports/CucumberTestReport.xml",
                "rerun:src/test/java/Reports/cucumber-reports/rerun.txt"
        }
)


public class RunTest extends TestUtil {
}
