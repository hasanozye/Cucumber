package gun04t;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/gun04t/demoqatable/DemoQATable.feature"},
        glue = {"gun04t/demoqatable"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
