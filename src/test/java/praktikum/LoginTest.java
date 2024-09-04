package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    WebDriver webDriver = Browser.setBrowser("Chrome");

    public LoginTest() throws Exception {
    }

    @Test
    @DisplayName("Login test from Account")
    public void testLoginFromAccount() {
        Login loginTest = new Login(webDriver);
        User.registerUserUsingAPI("testemail@testdomain.local", "12345678", "Chubaka");
        loginTest.openPage();
        loginTest.clickAccount();
        Assert.assertTrue(loginTest.enterLoginInfoAndClickEnter("testemail@testdomain.local", "12345678").isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @Test
    @DisplayName("Login test from button Login to Account")
    public void testLoginFromAccountButton() {
        Login loginTest = new Login(webDriver);
        User.registerUserUsingAPI("testemail@testdomain.local", "12345678", "Chubaka");
        loginTest.openPage();
        loginTest.clickLoginAccount();
        Assert.assertTrue(loginTest.enterLoginInfoAndClickEnter("testemail@testdomain.local", "12345678").isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @Test
    @DisplayName("Login test from Registration")
    public void testLoginFromRegistration() {
        Login loginTest = new Login(webDriver);
        User.registerUserUsingAPI("testemail@testdomain.local", "12345678", "Chubaka");
        loginTest.openPage();
        loginTest.clickAccount();
        loginTest.clickRegisterLink();
        loginTest.clickLogin();
        Assert.assertTrue(loginTest.enterLoginInfoAndClickEnter("testemail@testdomain.local", "12345678").isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @Test
    @DisplayName("Login test from Recover password")
    public void testLoginFromRecover() {
        Login loginTest = new Login(webDriver);
        User.registerUserUsingAPI("testemail@testdomain.local", "12345678", "Chubaka");
        loginTest.openPage();
        loginTest.clickAccount();
        loginTest.clickRecover();
        loginTest.clickLogin();
        Assert.assertTrue(loginTest.enterLoginInfoAndClickEnter("testemail@testdomain.local", "12345678").isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @Test
    @DisplayName("Logoff test")
    public void testLogoff() {
        Login loginTest = new Login(webDriver);
        User.registerUserUsingAPI("testemail@testdomain.local", "12345678", "Chubaka");
        loginTest.openPage();
        loginTest.clickAccount();
        Assert.assertTrue(loginTest.enterLoginInfoAndClickEnter("testemail@testdomain.local", "12345678").isDisplayed());
        loginTest.clickAccount();
        Assert.assertTrue(loginTest.clickLogoff().isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @Test
    @DisplayName("Account test after login")
    public void testAccount() {
        Login loginTest = new Login(webDriver);
        User.registerUserUsingAPI("testemail@testdomain.local", "12345678", "Chubaka");
        loginTest.openPage();
        loginTest.clickAccount();
        Assert.assertTrue(loginTest.enterLoginInfoAndClickEnter("testemail@testdomain.local", "12345678").isDisplayed());
        loginTest.clickAccount();
        Assert.assertTrue(loginTest.accountCheck().isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @After
    public void close() {
        webDriver.quit();
    }

}