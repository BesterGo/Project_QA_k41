package com.foodNow.pages;

import com.foodNow.kernel.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShopCartPage extends BaseHelper {
    public ShopCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//img[@class='css-13s0wde'])[2]")
    WebElement cartIcon;
    public ShopCartPage clickIconCart() {
        //js.executeScript("window. scrollTo( 0,  0)");
        //wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        click(cartIcon);
        return this;
    }


    //@FindBy(xpath = "(//button[contains(@class,'MuiButton-root')])[2]")
    @FindBy(xpath = "//button[normalize-space(text())='+']")
    WebElement plusButton;
    public ShopCartPage clickPlusButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        click(plusButton);
        return this;
    }

    //@FindBy(xpath = "(//div[@class='css-1361dhl']//div)[2]")
    @FindBy(xpath = "//button[normalize-space(text())='Proceed to checkout']")
    WebElement checkout;
    public ShopCartPage proceedToCheckout() {
        //wait.until(ExpectedConditions.elementToBeClickable(checkout));
        click(checkout);
        return this;
    }

    public void addProductToCart() {
        new ProductAddPage(driver)
                .clickFoodCategory()
                .clickMeatCategory()
                .clickAddSteakToCart();
    }

    public void checkoutToCart() {
        new ShopCartPage(driver)
                .clickIconCart()
                .clickPlusButton()
                .proceedToCheckout();
    }
}
