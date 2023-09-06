package gun05t;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
//        features = {"C:/features"}     // feature'lar genellikle test/resrouces altinda olur (Çünkü java class'ı değillerdir)
        features = {"src/test/java/gun05t/gun05.feature"},     // feature yolu alinirken content rootdan baslanir
        glue = {"gun05t"}, //glue'lar, stepdefs ve hooks classlarının yeridir, sourceroot'dan başlar
        dryRun = false,  // sadece step def'ler düzgün hazirlanmismi, yapilandırma uygun mu? bakar
        tags = "@login",  //@login tagli senaryolar calistirilir.
        plugin = {"pretty", "html:test-output/report.html",
                "json:test-output/report.json"}
)
public class RunnerGun05 extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("chrome") String browser) {
        System.out.println("TESTNG beforeTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("TESTNG after suite");
    }

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("TESTNG before suite");
    }

}
