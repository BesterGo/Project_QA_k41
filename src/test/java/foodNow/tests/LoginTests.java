package foodNow.tests;

import com.foodNow.pages.LoginPage;
import com.foodNow.utiliten.DataProviders;
import foodNow.kernel.BaseTests;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class LoginTests extends BaseTests {

    @BeforeMethod
    public void preCondition() {
        logger.info("*** LOGIN TESTING IN PROGRESS ***");
        //Используется для подготовки тестового окружения
    }

    @Test
    //Тестирует успешный вход с валидными данными.
    public void loginPositiveTest() {
        logger.info("*** LOGIN POSITIVE TESTING IN PROGRESS ***");
        new LoginPage(app.driver)
                .clickIconAuthorization()
                .clickLoginButton()
                .enterPersonalData("tl49@gmx.com", "TestProba1$")
                .clickSubmitLogin()
                .verifyUserIsLoggedIn();
    }

    @Test
    //Тестирует вход с некорректными данными (например, неправильный email или пароль).
            (dataProvider = "invalidLoginData", dataProviderClass = DataProviders.class)
    public void loginNegativeTestWithAssert(String email, String password) {
        logger.info("[LoginTests] Starting negative login test with data: email={}," +
                " password={}", email, password);
        String loginUrl = "https://oyster-app-hck73.ondigitalocean.app/#/login";
        //  URL страницы логина
        new LoginPage(app.driver)
                .clickIconAuthorization()
                .clickLoginButton()
                .enterPersonalData(email, password)
                .clickSubmitLogin();

        String actualUrl = app.driver.getCurrentUrl();

        if (!actualUrl.equals(loginUrl)) {  // Проверка, что URL не изменился
            logger.error("[LoginTests] Test FAILED:" +
                    " Unexpected URL after login with invalid data: " + actualUrl + "," +
                    " Screenshot: " + app.getBaseHelper().takeScreenshot());
            Assert.fail("Unexpected URL after login with invalid data: " + actualUrl);
        } else {
            logger.info("[LoginTests] Invalid login attempt successfuly prevented.");
        }

    }
    @AfterMethod
    //Выполняется после каждого теста для выполнения завершающих операций
    public void postConditions(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info("[LoginTests] Test PASSED: " + method.getName());
        } else {
            logger.error("[LoginTests] Test FAILED: " + method.getName() +
                    ", Screenshot: " + app.getBaseHelper().takeScreenshot());
        }

        if (result.isSuccess() && method.getName().equals("loginPositiveTest")) {
            new LoginPage(app.driver).logout();
        }
    }
}