package praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Constructor {

    public static final String URL = "https://stellarburgers.nomoreparties.site";
    private static WebDriver webDriver;

    public Constructor(WebDriver webDriver) {
        Constructor.webDriver = webDriver;
    }

    public void openPage() {
        webDriver.get(URL);
    }

    @Step("Click Account")
    public void clickAccount() {
        webDriver.findElement(By.xpath(".//a[@href='/account']")).click();
    }

    @Step("Click Login")
    public void clickLogin() {
        webDriver.findElement(By.xpath(".//a[@href='/login']")).click();
    }

    @Step("Click Constructor")
    public WebElement clickConstructor() {
        webDriver.findElement(By.xpath(".//p[text()='Конструктор']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Оформить заказ']")));
    }

    @Step("Click Logo")
    public WebElement clickLogo() {
        webDriver.findElement(By.className("AppHeader_header__logo__2D0X2")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Оформить заказ']")));
    }

    @Step("Click Sauces from Buns")
    public WebElement clickSauces() {
        webDriver.findElement(By.xpath(".//span[text()='Соусы']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Соусы']")));
    }

    @Step("Click Buns from Sauces")
    public WebElement clickBuns() {
        webDriver.findElement(By.xpath(".//span[text()='Булки']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Булки']")));
    }

    @Step("Click Mains from Buns")
    public WebElement clickMains() {
        webDriver.findElement(By.xpath(".//span[text()='Начинки']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Начинки']")));
    }

    @Step("Enter login info and click Enter")
    public void enterLoginInfoAndClickEnter(String email, String password) {
        WebElement emailField = webDriver.findElement(By.xpath(".//label[text()='Email']/following-sibling::input"));
        emailField.sendKeys(email);
        WebElement passwordField = webDriver.findElement(By.xpath(".//label[text()='Пароль']/following-sibling::input"));
        passwordField.sendKeys(password);
        webDriver.findElement(By.xpath(".//button[text()='Войти']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Оформить заказ']")));
    }

}