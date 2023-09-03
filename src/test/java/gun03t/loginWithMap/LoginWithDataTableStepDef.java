package gun03t.loginWithMap;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigDriver;
import utils.Driver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginWithDataTableStepDef {

    protected WebDriver driver;
    protected WebDriverWait wait;

    By lUsername = By.cssSelector("input[name='username']");
    By lPassword = By.cssSelector("input[name='password']");
    By lLoginBtn = By.cssSelector("button[type=submit]");
    By lDashboradText = By.xpath("//h6[contains(@class,'oxd-text')]");
    By lInvalidCredential = By.xpath("//p[text()='Invalid credentials']");
    By lUserPanel = By.cssSelector(".oxd-userdropdown-tab");
    By lUserPanelLogoutLink = By.xpath("//a[text()='Logout']//parent::li");
    By lNotificationRequired = By.xpath("//span[contains(@class,'oxd')]");

    public LoginWithDataTableStepDef() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Given("user on page {string}")
    public void userOnPage(String url) {
        url = ConfigDriver.get("orangeHRM");
        driver.get(url);
    }

    @When("user fill the login form as follows")
    public void userFillTheLoginFormAsFollows(DataTable table) {
        Map<String, String> map = table.asMap();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername))
                .sendKeys(map.get("username"));
        driver.findElement(lPassword)
                .sendKeys(map.get("password"));
        driver.findElement(lLoginBtn)
                .click();
    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lDashboradText, "Dashboard"));
        System.out.println("Login Successfull!");
    }

    @When("user tries to login as follows, conclusion should be in status")
    public void userTriesToLoginAsFollowsConclusionShouldBeInStatus(DataTable table) {
        List<Map<String, String>> maps = table.asMaps();
        for (Map<String, String> map : maps) {

            String username = map.get("username") == null ? "" : map.get("username");
            String password = map.get("password") == null ? "" : map.get("password");

            sendKeys(lUsername, username);
            sendKeys(lPassword, password);
            click(lLoginBtn);

            if (username.length() <= 0 || password.length() <= 0) {
                int numberOfNotification = username.length() <= 0 && password.length() <= 0 ? 2 : 1;
                wait.until(ExpectedConditions.numberOfElementsToBe(lNotificationRequired, numberOfNotification));
            } else {

                if (map.get("status").equalsIgnoreCase("false")) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(lInvalidCredential));
                } else {
                    wait.until(ExpectedConditions.urlContains("dashboard"));
                    click(lUserPanel);
                    click(lUserPanelLogoutLink);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername));
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Then("quit driver")
    public void quitDriver() {
        Driver.tearDown();
    }
}
