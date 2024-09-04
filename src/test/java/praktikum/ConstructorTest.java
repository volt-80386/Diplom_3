package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class ConstructorTest {

    WebDriver webDriver = Browser.setBrowser("Chrome");

    public ConstructorTest() throws Exception {
    }

    @Test
    @DisplayName("Test Click Constructor from Account")
    public void testConstructorFromAccount() {
        Constructor constructorClickTest  = new Constructor(webDriver);
        User.registerUserUsingAPI("testemail@testdomain.local", "12345678", "Chubaka");
        constructorClickTest.openPage();
        constructorClickTest.clickAccount();
        constructorClickTest.enterLoginInfoAndClickEnter("testemail@testdomain.local", "12345678");
        constructorClickTest.clickAccount();
        Assert.assertTrue(constructorClickTest.clickConstructor().isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @Test
    @DisplayName("Test Click Logo from Account")
    public void testLogoFromAccount() {
        Constructor constructorClickTest  = new Constructor(webDriver);
        User.registerUserUsingAPI("testemail@testdomain.local", "12345678", "Chubaka");
        constructorClickTest.openPage();
        constructorClickTest.clickAccount();
        constructorClickTest.enterLoginInfoAndClickEnter("testemail@testdomain.local", "12345678");
        constructorClickTest.clickAccount();
        Assert.assertTrue(constructorClickTest.clickLogo().isDisplayed());
        User.deleteUserUsingAPI("testemail@testdomain.local", "12345678");
    }

    @Test
    @DisplayName("Test Click Ingredients")
    public void testClickIngredients() {
        Constructor constructorClickTest  = new Constructor(webDriver);
        constructorClickTest.openPage();
        Assert.assertTrue(constructorClickTest.clickSauces().isDisplayed());
        Assert.assertTrue(constructorClickTest.clickBuns().isDisplayed());
        Assert.assertTrue(constructorClickTest.clickMains().isDisplayed());
    }

    @After
    public void close() {
        webDriver.quit();
    }

}