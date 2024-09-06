package praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login {

    public static final String URL = "https://stellarburgers.nomoreparties.site";
    private static WebDriver webDriver;

    public Login(WebDriver webDriver) {
        Login.webDriver = webDriver;
    }

    public void openPage() {
        webDriver.get(URL);
    }

    @Step("Click Login to Account")
    public void clickLoginAccount() {
        webDriver.findElement(By.xpath(".//button[text()='Войти в аккаунт']")).click();
    }

    @Step("Click Account")
    public void clickAccount() {
        webDriver.findElement(By.xpath(".//a[@href='/account']")).click();
    }

    @Step("Click Login")
    public void clickLogin() {
        webDriver.findElement(By.xpath(".//a[@href='/login']")).click();
    }

    @Step("Click Register link")
    public void clickRegisterLink() {
        webDriver.findElement(By.xpath(".//a[@href='/register']")).click();
    }

    @Step("Click Recover password")
    public void clickRecover() {
        webDriver.findElement(By.xpath(".//a[@href='/forgot-password']")).click();
    }

    @Step("Click Logoff")
    public WebElement clickLogoff() {
        webDriver.findElement(By.xpath(".//button[text()='Выход']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Войти']")));
    }

    @Step("Account check")
    public WebElement accountCheck() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@href='/account/profile']")));
    }

    @Step("Enter login info and click Enter")
    public WebElement enterLoginInfoAndClickEnter(String email, String password) {
        WebElement emailField = webDriver.findElement(By.xpath(".//label[text()='Email']/following-sibling::input"));
        emailField.sendKeys(email);
        WebElement passwordField = webDriver.findElement(By.xpath(".//label[text()='Пароль']/following-sibling::input"));
        passwordField.sendKeys(password);
        webDriver.findElement(By.xpath(".//button[text()='Войти']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Оформить заказ']")));
    }

}