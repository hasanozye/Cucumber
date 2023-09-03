package gun02t;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenCartSearchStepDefs {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://opencart.abstracta.us/";

    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("user on opencart main page")
    public void userOnOpencartMainPage() {
        driver.get(url);
    }

    @When("user search {string}")
    public void userSearch(String text) {
        By locator = By.cssSelector("input[name='search']");
        By locator2 = By.xpath("//div[@id='search']//button[@type='button']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
        new Actions(driver).click(driver.findElement(locator2));


    }

    @Then("product count should be {int}")
    public void productCountShouldBe(int num) {
        By locator = By.xpath("//div[contains(@class,'product-layout')]");
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, num));
    }
}
