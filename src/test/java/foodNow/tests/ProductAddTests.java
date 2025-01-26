package foodNow.tests;

import com.foodNow.pages.ProductAddPage;
import com.foodNow.pages.LoginPage;
import foodNow.kernel.BaseTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.time.Duration;


public class ProductAddTests extends BaseTests {

    @BeforeMethod
    public void preCondition(Method method) {
        logger.info("*** " + method.getName() + " TEST STARTED ***");
        new LoginPage(app.driver)
                .clickIconAuthorization()
                .clickLoginButton()
                .enterPersonalData("tl49@gmx.com", "TestProbe1$")
                .clickSubmitLogin();
        app.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void addProductPositiveTest() {
        addProduct();
    }

    private void addProduct() {
        new ProductAddPage(app.driver)
                .clickFoodCategory()
                .clickMeatCategory()
                .clickAddSteakToCart()
                .verifyProductIsAdded();
    }

    @AfterMethod
    public void postCondition(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info("[AddProductTests] Test PASSED: " + method.getName());
        } else {
            logger.error("[AddProductTests] Test FAILED: " + method.getName() +
                    ", Screenshot: " + app.getBaseHelper().takeScreenshot());
        }
    }
}
