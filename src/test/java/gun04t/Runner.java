package gun04t;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/gun04t/opencart/Opencart.feature"},
        glue = {"gun04t/opencart"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
