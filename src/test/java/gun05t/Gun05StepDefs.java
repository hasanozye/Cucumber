package gun05t;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Gun05StepDefs {
    @Given("user multiply {int}")
    public void userMultiply(int arg0) {
        Assert.assertEquals(1,1);

    }

    @When("user divide {int}")
    public void userDivide(int arg0) {
        Assert.assertEquals(1,2);
    }

    @Then("result is {string}")
    public void resultIs(String arg0) {
        Assert.assertEquals(1,1);
    }
}
