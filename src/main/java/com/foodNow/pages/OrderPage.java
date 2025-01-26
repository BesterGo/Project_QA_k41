package com.foodNow.pages;

import com.foodNow.kernel.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BaseHelper {
    public OrderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "address-id")
    WebElement address;
    public OrderPage enterAddress() {
        type(address, "Hauptstr. 1, 10827 Berlin");
        return this;
    }


    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitOrder;
    public OrderPage clickSubmitOrder() {
        click(submitOrder);
        return this;
    }
}
