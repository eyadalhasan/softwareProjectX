package clinicsys;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",
monochrome = true,
snippets = SnippetType.CAMELCASE,
glue = { "clinicsys" })

public class AcceptanceTest {

}
