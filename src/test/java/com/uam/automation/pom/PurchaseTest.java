package com.uam.automation.pom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PurchaseTest {
    private WebDriver driver;
    LoginPage purchaseTest;
    @BeforeMethod
    public void setUp() throws Exception {
        purchaseTest = new LoginPage(driver);
        driver = purchaseTest.chromeDriverConnection();
        purchaseTest.visit("https://www.demoblaze.com/index.html");
    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testPurchase() throws Exception {
        purchaseTest.login("username", "password");
        Thread.sleep(2000);
        assertEquals(purchaseTest.loginSuccessfulText(),
                "Welcome username");
        purchaseTest.ProductPage();
        assertEquals(purchaseTest.productTitle(),
                "Nokia lumia 1520");
        purchaseTest.addToCart();
        purchaseTest.cartPage();
        purchaseTest.purchaseForm("Santiago", "Colombia", "Manizales",
                "123456789876", "09","2028");
        assertEquals(purchaseTest.purchaseSuccess(),
                "Thank you for your purchase!");
        purchaseTest.takeScreenShot("pantallazo.png");
    }
}