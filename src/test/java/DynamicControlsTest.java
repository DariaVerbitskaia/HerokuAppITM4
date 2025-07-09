import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DynamicControlsTest {

    @Test
    public void CheckDynamicControl() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(inputField.isEnabled());
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        Assert.assertTrue(inputField.isEnabled());
        driver.quit();
    }
}