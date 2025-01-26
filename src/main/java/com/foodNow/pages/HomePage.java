package com.foodNow.pages;

import com.foodNow.kernel.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BaseHelper {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get("https://oyster-app-hck73.ondigitalocean.app/#/");
    }


    @FindBy(xpath = "//a[@href='#/user-profile']")
    WebElement login;
    public HomePage clickOnIconAuthorization() {
        pause(2000);
        click(login);
        return this;
    }


    public void quitBrowser() {
        driver.quit();
    }

    @FindBy(xpath = "(//div[@class='css-1lr0q67']/following-sibling::div)[3]")
    WebElement homePageTitle;
    public HomePage verifyTitleHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(driver -> homePageTitle.isDisplayed());
        return this;
    }

    @FindBy(xpath = "(//img[@class='css-rbpvgo'])[1]")
    WebElement imageFoodNow;
    public HomePage clickOnImageFoodNow() {
        pause(2000);
        click(imageFoodNow);
        return this;
    }


    public HomePage scrollPageProducts() {
        scrollTo(700);
        return this;
    }


    public HomePage clickOnProduct(String product) {
        click(driver.findElement(By.xpath("//button[text()='"+ product +"']")));
        driver.navigate().refresh();
        return this;
    }


    @FindBy(xpath = "//button[text()='Seafood']")
    WebElement categoriesSeafood;
    public HomePage clickOnCategoriesSeafood() {
        pause(2600);
        click(categoriesSeafood);
        return this;
    }

    @FindBy(xpath = "(//div[@class='MuiStack-root css-jj2ztu']//button)[1]")
    WebElement buttonAddToCart;
    public HomePage clickOnButtonAddToCart() {
        pause(2600);
        click(buttonAddToCart);
        return this;
    }

    @FindBy(xpath = "(//img[@class='css-13s0wde'])[2]")
    WebElement cartIcon;
    public HomePage clickOnCart() {
        pause(2000);
        click(cartIcon);
        return this;
    }
}
