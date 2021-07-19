package Runner_File;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
features = { "Features/Award_points_negative_scenarios.feature"	},
 glue= {"StepDefinitions"})
public class TestSuite {
}
