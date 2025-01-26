package com.foodNow.pages;

import com.foodNow.kernel.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BaseHelper {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='#/user-profile']")
    private WebElement loginIcon;

    public LoginPage clickIconAuthorization() {
        click(loginIcon);
        return this;
    }

    @FindBy(xpath = "//a[@href='#/login']")
    private WebElement loginButton;

    public LoginPage clickLoginButton() {
        click(loginButton);
        return this;
    }

    @FindBy(id = "email-id")
    private WebElement userEmail;

    @FindBy(id = "password-id")
    private WebElement userPassword;

    public LoginPage enterPersonalData(String email, String password) {
        type(userEmail, email);
        type(userPassword, password);
        return this;
    }

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement submitLoginButton;

    public LoginPage clickSubmitLogin() {
        click(submitLoginButton);
        return this;
    }

    @FindBy(xpath = "(//button[@type='button'])[2]")
    // Локатор кнопки выхода после логина - ПРОВЕРТЬ ЛОКАТОР
    private WebElement logoutButton;

    public LoginPage verifyUserIsLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        Assert.assertTrue(logoutButton.isDisplayed(),
                "Logout button is not displayed after login");
        return this;
    }


    public void logout() {
        clickIconAuthorization();
        clickLogoutButton();
    }

    @FindBy(xpath = "//button[normalize-space(text())='Log out']")
    private WebElement logOutButtonAfterLogin;

    private LoginPage clickLogoutButton() {
        click(logOutButtonAfterLogin);
        return this;
    }



    public LoginPage loginExistedUser() {
        clickIconAuthorization();
        clickLoginButton();
        enterPersonalData("tL49 @gmx", "tl49@");
        clickSubmitLogin();
        return this;
    }
}
