import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class FramesTest {

    @Test
    public void CheckIframe() {

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.cssSelector("a[href='/iframe']")).click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String paragraphText = driver.findElement(By.xpath("//body[@id='tinymce']/p[text()='Your content goes here.']")).getText();
        softAssert.assertEquals(paragraphText, "Your content goes here.");
        softAssert.assertAll();
        driver.quit();
    }
}
