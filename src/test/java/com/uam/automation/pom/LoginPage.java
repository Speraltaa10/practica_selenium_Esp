package com.uam.automation.pom;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class LoginPage extends BasePage {
    public By loginOption = By.linkText("Log in");
    public By nameofuser = By.id("nameofuser");
    public By username = By.id("loginusername");
    public By password = By.id("loginpassword");
    public By loginButton =
            By.xpath("//button[text()='Log in']");
    public By mobileSelected = By.xpath("//div[@class='col-lg-9']//div[2]//div[1]//a[1]//img[1]");
    public By productSelected = By.xpath("//h2[contains(.,'Nokia lumia 1520')]");
    public By addToCartButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    public By cartButton = By.xpath("//a[contains(.,'Cart')]");
    public By placeOrderButton = By.xpath("//button[@class='btn btn-success']");
    public By name = By.id("name");
    public By country = By.id("country");
    public By city = By.id("city");
    public By creditCard = By.id("card");
    public By month = By.id("month");
    public By year = By.id("year");
    public By purchaseButton = By.xpath("//button[@type='button'][contains(.,'Purchase')]");
    public By thankYou = By.xpath("//h2[contains(.,'Thank you for your purchase!')]");
    public By okButton = By.xpath("//button[@class='confirm btn btn-lg btn-primary'][contains(.,'OK')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String username, String password)
            throws InterruptedException {
        click(loginOption);
        Thread.sleep(2000);
        type(username, this.username);
        type(password, this.password);
        click(loginButton);
    }
    public String loginSuccessfulText() {
        return getText(nameofuser);
    }

    public void ProductPage() throws InterruptedException {
        Thread.sleep(2000);
        click(mobileSelected);
    }
    public String productTitle()throws InterruptedException{
        Thread.sleep(2000);
        return getText(productSelected);
    }

    public void addToCart() throws InterruptedException {
        click(addToCartButton);
        Thread.sleep(2000);
        String alertText = alertMessage();
    }
    public String alertMessage() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void cartPage() throws InterruptedException {
        click(cartButton);
        Thread.sleep(2000);
        click(placeOrderButton);
    }

    public void purchaseForm(String name, String country, String city, String creditCard, String month, String year )
            throws InterruptedException {
        Thread.sleep(2000);
        type(name, this.name);
        type(country, this.country);
        type(city, this.city);
        type(creditCard, this.creditCard);
        type(month, this.month);
        type(year, this.year);
        click(purchaseButton);
    }
    public String purchaseSuccess() throws InterruptedException{
        Thread.sleep(2000);
        return getText(thankYou);
        //click(okButton);
    }
}

