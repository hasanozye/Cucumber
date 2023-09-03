package gun02t;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/gun03t/loginWithMap/LoginWithDataTable.feature"},
        glue = {"gun03t/loginWithMap"},
        tags = "@Smoker"
)
public class Runner extends AbstractTestNGCucumberTests {
}
