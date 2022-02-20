package step_def;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"step_def"},
        monochrome = true,
        plugin = {"pretty", "html:target/Reports/HTMLReport.html"},
        tags = "@functional"
)

public class TestRunner {
}
