package com.foodNow.pages;

import com.foodNow.kernel.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BaseHelper {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='#/user-profile']")
    WebElement iconAuthorization;

    public RegisterPage clickIconAuthorization() {
        wait.until(ExpectedConditions.elementToBeClickable(iconAuthorization));
        click(iconAuthorization);
        return this;
    }

    @FindBy(xpath = "//a[@href='#/registration' and text()='or register']")
    WebElement registerButton;

    public RegisterPage clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        click(registerButton);
        return this;
    }

    @FindBy(id = "firstName-id")
    private WebElement userFirstName;
    @FindBy(id = "lastName-id")
    private WebElement userLastName;
    @FindBy(id = "email-id")
    private WebElement userEmail;
    @FindBy(id = "password-id")
    private WebElement userPassword;
    @FindBy(id = "phoneNumber-id")
    private WebElement userPhone;

    public RegisterPage enterFirstName(String firstName) {
        type(userFirstName, firstName);
        return this;
    }

    public RegisterPage enterLastName(String lastName) {
        type(userLastName, lastName);
        return this;
    }

    public RegisterPage enterEmail(String email) {
        type(userEmail, email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        type(userPassword, password);
        return this;
    }

    public RegisterPage enterPhone(String phone) {
        type(userPhone, phone);
        return this;
    }

    public RegisterPage
    enterPersonalData(String firstName, String lastName,
                      String email, String password, String phone) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterPhone(phone);
        return this;
    }

    @FindBy(xpath = "//button[text()='Registration']")
    WebElement submitRegister;

    public RegisterPage clickSubmitRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(submitRegister));
        click(submitRegister);
        return this;
    }
}
