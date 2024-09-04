package praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Register {

    private static final String URL = "https://stellarburgers.nomoreparties.site";
    private final WebDriver webDriver;
    public Register(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openPage() {
        webDriver.get(URL);
    }

    @Step("Click Account")
    public void clickAccount() {
        webDriver.findElement(By.xpath(".//a[@href='/account']")).click();
    }

    @Step("Click Register link")
    public void clickRegisterLink() {
        webDriver.findElement(By.xpath(".//a[@href='/register']")).click();
    }

    @Step("Enter Registration Info")
    public void enterRegInfo(String Name, String email, String password) {
        WebElement nameField = webDriver.findElement(By.xpath(".//label[text()='Имя']/following-sibling::input"));
        nameField.sendKeys(Name);
        WebElement emailField = webDriver.findElement(By.xpath(".//label[text()='Email']/following-sibling::input"));
        emailField.sendKeys(email);
        WebElement passwordField = webDriver.findElement(By.xpath(".//label[text()='Пароль']/following-sibling::input"));
        passwordField.sendKeys(password);
    }

    @Step("Click Register Button")
    public WebElement clickRegisterButton() {
        webDriver.findElement(By.xpath(".//button[text()='Зарегистрироваться']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
    }

    @Step("Click Register Button with short password")
    public WebElement clickRegisterButtonError() {
        webDriver.findElement(By.xpath(".//button[text()='Зарегистрироваться']")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[text()='Некорректный пароль']")));
    }

}