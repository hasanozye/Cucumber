package gun01t;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/gun01t/myFirstFeature.feature"},
        glue = {"gun01t"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
