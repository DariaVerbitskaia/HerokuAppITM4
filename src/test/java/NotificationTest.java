import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

public class NotificationTest {
    @Test
    public void test7() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[@href='/notification_message']")).click();
        String notificationMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText().replace("×", "").replaceAll("[\\n\\r]", "").trim();
        if (notificationMessage.equals("Action successful")) {
            System.out.println("Успешное уведомление");
        } else if (notificationMessage.equals("Action unsuccesful, please try again"))  {
            System.out.println("Уведомление об ошибке!");
        } else {
            System.out.println("Некорректное уведомление");
        }
        driver.quit();
    }

}
