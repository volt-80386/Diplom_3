package praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class Browser {

    public static WebDriver setBrowser(String browser) throws Exception {
        WebDriver webDriver;
        switch (browser) {
            case "Chrome": {
                ChromeOptions options = new ChromeOptions();
                webDriver = new ChromeDriver(options);
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                return webDriver;
            }
            case "Yandex": {
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\yandexdriver.exe");
                webDriver = new ChromeDriver(options);
                options.setBinary("browser.exe");
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                return webDriver;
            }
            default:
                throw new Exception("Unknown browser");
        }
    }
}