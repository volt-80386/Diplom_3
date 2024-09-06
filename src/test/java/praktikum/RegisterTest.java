package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class RegisterTest {

    private final WebDriver webDriver = Browser.setBrowser("Chrome");

    public RegisterTest() throws Exception {
    }

    @Test
    @DisplayName("Successful registration test")
    public void testSuccessfulRegistration () {
        Register registrationTest = new Register(webDriver);
        registrationTest.openPage();
        registrationTest.clickAccount();
        registrationTest.clickRegisterLink();
        registrationTest.enterRegInfo("Chubaka","testemail@testdomain.local", "12345678");
        Assert.assertTrue(registrationTest.clickRegisterButton().isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @Test
    @DisplayName("Error registration with short password")
    public void testErrorRegistration () {
        Register registrationTest = new Register(webDriver);
        registrationTest.openPage();
        registrationTest.clickAccount();
        registrationTest.clickRegisterLink();
        registrationTest.enterRegInfo("Chubaka","testemail@testdomain.local", "1234");
        Assert.assertTrue(registrationTest.clickRegisterButtonError().isDisplayed());
    }

    @After
    public void close() {
        webDriver.quit();
    }

}