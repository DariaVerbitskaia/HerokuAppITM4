import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.time.Duration;


public class FileUploadTest {

    @Test
    public void CheckFileUpload() {

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/main/resources/Upload1.html");
        driver.findElement(By.cssSelector("[type='file']")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        String fileName = driver.findElement(By.id("uploaded-files")).getText();
        softAssert.assertEquals(fileName, "Upload1.html");
        softAssert.assertAll();
        driver.quit();
    }
}
