package gun04t.opencart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class OpenCartStepDefs {

    WebDriver driver;
    WebDriverWait wait;

    public OpenCartStepDefs() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    By lMyAccount = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']/ancestor::a[@title='My Account']");
    By lLoginHeader = By.xpath("//a[text()='Login']");
    By lMailAddressField = By.cssSelector("#input-email");
    By lPasswordField = By.cssSelector("#input-password");
    By lLoginBtnRegister = By.xpath("//input[@value='Login']");
    By lLoginSuccessfullVerify = By.id("content");
    By lSearchField = By.xpath("//input[@name='search']");
    By lSearchIcon = By.xpath("//button[@type='button']/ancestor::span");
    By lAddToCart = By.xpath("//button[@id='button-cart']");
    String lInput = "//h4//*[contains(text(),'%s')]";
    By lProducts = By.tagName("h4");
    By lSuccessMsg = By.xpath("//div[contains(@class,'success')]");
    By lBody = By.xpath("//body");

    @And("user login with the following credentials")
    public void userLoginWithTheFollowingCredentials(DataTable table) {
        Map<String, String> credentials = table.asMap();
        click(lMyAccount);
        click(lLoginHeader);
        sendKeys(lMailAddressField, credentials.get("username"));
        sendKeys(lPasswordField, credentials.get("password"));
        click(lLoginBtnRegister);

    }

    @Then("opencart login should be successfull")
    public void opencartLoginShouldBeSuccessfull() {
        //lol this is funny as fuck why am i ensuring double time you might ask, well well buckaroo..... none your god damn business
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginSuccessfullVerify)).isDisplayed());
    }

    @Given("user search for {string}")
    public void userSearchFor(String text) {
        sendKeys(lSearchField, text);
        click(lSearchIcon);

    }

    @When("user add {string} to the cart")
    public void userAddToTheCart(String text) {
        List<WebElement> eProducts = driver.findElements(lProducts);
        for (WebElement eProduct : eProducts) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eProduct);
            if (eProduct.getText().equalsIgnoreCase(text)) {
                click(xpath(lInput, text));
                click(lAddToCart);
                break;
            }
        }
    }

    @Then("product should be added")
    public void productShouldBeAdded() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(lSuccessMsg)).isDisplayed());
    }

    @Given("user goes on {string} page")
    public void userGoesOnPage(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lBody));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public void sendKeys(WebElement element, CharSequence... text) {
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.sendKeys(text);
    }

    public void scrollIntoView(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public By xpath(String xpathStr, String label) {
        return By.xpath(String.format(xpathStr, label));
    }

    public void sendKeys(By locator, CharSequence... text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.clear();
        sendKeys(element, text);
    }


}
