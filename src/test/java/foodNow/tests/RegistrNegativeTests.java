package foodNow.tests;

import com.foodNow.pages.RegisterPage;
import com.foodNow.utiliten.DataProviders;
import foodNow.kernel.BaseTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class RegistrNegativeTests extends BaseTests {
    Logger logger = LoggerFactory.getLogger(RegistrNegativeTests.class);

    @BeforeMethod
    public void preCondition() {
        logger.info("[RegisterNegativeTests] Navigating to registration page");
        new RegisterPage(app.driver)
                .clickIconAuthorization()
                .clickRegisterButton();
    }

    @Test(dataProvider = "invalidRegistrationData", dataProviderClass = DataProviders.class)
    public void registerNegativeTest(String firstName, String lastName, String email,
                                     String password, String phone) {
        logger.info("[RegisterNegativeTests] Starting negative registration test with data:" +
                        " firstName={}, lastName={}, email={}, password={}, phone={}",
                firstName, lastName, email, password, phone);

        new RegisterPage(app.driver)
                .enterPersonalData(firstName, lastName, email, password, phone)
                .clickSubmitRegister();

        String expectedUrl = "https://oyster-app-hck73.ondigitalocean.app/#/registration";
        String actualUrl = app.driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert(); // Используем SoftAssert

        softAssert.assertEquals(actualUrl, expectedUrl,
                "[RegisterNegativeTests] Registration did not fail as expected." +
                        " Expected URL: " + expectedUrl +
                        ", Actual URL: " + actualUrl + ", Screenshot:" +
                        " " + app.getBaseHelper().takeScreenshot());

        softAssert.assertAll(); // Проверяем все assertionen в конце теста
    }


    @AfterMethod
    public void postCondition(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info(new StringBuilder().append("[RegisterNegativeTests] Test PASSED: ")
                    .append(method.getName()).toString());
        } else {
            logger.error("[RegisterNegativeTests] " +
                    "Test FAILED: {}, Screenshot: {}", method.getName(),
                    app.getBaseHelper().takeScreenshot());
        }
    }
}
