package gun02t;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/gun02t/SenaryoIslemleri.feature"},
        glue = {"gun02t"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
