package gun04t.demoqatable;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class DemoQATableStepDefs {

    protected WebDriver driver;
    protected WebDriverWait wait;
    int countOfDataFirst;
    int countOfDataAfter;


    By lBody = By.xpath("//body");
    By lElements = By.xpath("//h5[text()='Elements']");
    By lWebTables = By.xpath("//span[text()='Web Tables']");
    By lAddNewBtn = By.cssSelector("#addNewRecordButton");
    By lFirstName = By.id("firstName");
    By lLastName = By.id("lastName");
    By lEmail = By.id("userEmail");
    By lAge = By.id("age");
    By lSalary = By.id("salary");
    By lDepartment = By.id("department");
    By lSubmitBtn = By.id("submit");
    By lDelButtons = By.xpath("//span[starts-with(@id,'delete')]");

    public DemoQATableStepDefs() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @And("kullanici WebTables linkine tiklar")
    public void kullaniciWebTablesLinkineTiklar() {
        scrollIntoView(lWebTables);
        click(lWebTables);
    }

    @Given("kullanici {string} adresine gider")
    public void kullaniciAdresineGider(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lBody));
    }

    @And("kullanici Elements linkine tiklar")
    public void kullaniciElementsLinkineTiklar() {
        scrollIntoView(lElements);
        click(lElements);
    }

    @When("kullanici formu asagidaki bilgilerle doldurdugunda")
    public void kullaniciFormuAsagidakiBilgilerleDoldurdugunda(DataTable table) {

        countOfDataFirst = driver.findElements(lDelButtons).size();

        Map<String, String> maps = table.asMap();
        click(lAddNewBtn);
        sendKeys(lFirstName, maps.get("FirstName"));
        sendKeys(lLastName, maps.get("LastName"));
        sendKeys(lEmail, maps.get("Email"));
        sendKeys(lAge, maps.get("Age"));
        sendKeys(lSalary, maps.get("Salary"));
        sendKeys(lDepartment, maps.get("Department"));
        click(lSubmitBtn);




    }

    @Then("kayit eklenmis olmali")
    public void kayitEklenmisOlmali() {
        countOfDataAfter = driver.findElements(lDelButtons).size();
        Assert.assertTrue(countOfDataFirst < countOfDataAfter);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void scrollIntoView(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }


}
