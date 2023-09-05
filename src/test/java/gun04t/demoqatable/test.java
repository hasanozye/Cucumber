package gun04t.demoqatable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class test {
    WebDriver driver;

    {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        By lProducts = By.tagName("h4");
        By lMacBook = By.xpath("//a[text()='MacBook']");
        driver.get("https://opencart.abstracta.us/index.php?route=product/search&search=mac");
        List<WebElement> eProducts = driver.findElements(lProducts);
        for (WebElement eProduct : eProducts) {
            if (eProduct.getText().equalsIgnoreCase("macbook")) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eProduct);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.findElement(lMacBook).click();
                break;
            }

        }

    }
}
