import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
            "html:target/cucumber-reports/cucumber",
            "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
            "rerun:target/cucumber-reports/rerun-reports/rerun.txt"
        },
        glue = {"steps.API","steps.UI"},
        tags = "@inWork",
        features = "test-classes/features", //src/test/resources/features   test-classes/features
        monochrome = true,
        publish = true)

public class RunCucumberTest{}
