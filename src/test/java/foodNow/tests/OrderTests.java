package foodNow.tests;

import com.foodNow.pages.LoginPage;
import com.foodNow.pages.OrderPage;
import com.foodNow.pages.ProductAddPage;
import com.foodNow.pages.ShopCartPage;
import com.foodNow.pages.ProductAddPage;
import com.foodNow.pages.ShopCartPage;
import com.foodNow.pages.LoginPage;
import com.foodNow.pages.OrderPage;
import foodNow.kernel.BaseTests;
import foodNow.kernel.BaseTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class OrderTests extends BaseTests {

    @BeforeMethod
    //Используется для подготовки тестового окружения
    //Переходит на страницу корзины и подтверждает переход к оформлению заказа.
    public void preCondition() {
        new LoginPage(app.driver).loginExistedUser();
        new ProductAddPage(app.driver).addProduct();
        new ShopCartPage(app.driver).checkoutToCart();
    }


    @Test
    //Проверяет что форма заказа корректно заполняется.
    public void formPayment() {
        logger.info("*** ORDER DETAILS TESTING IN PROGRESS ***");
        new OrderPage(app.driver)
                .enterAddress()
                .clickSubmitOrder();
    }

    @AfterMethod
    //Выполняется после каждого теста, чтобы обработать результаты и очистить состояние системы.
    //Если успешно прошел тест oderDetailsTests, вызывается метод logout() для выхода из системы.
    public void postConditions(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info("[OderDetailsTests] Test PASSED: " + method.getName());
        } else {
            logger.error("[OderDetailsTests] Test FAILED: " + method.getName() +
                    ", Screenshot: " + app.getBaseHelper().takeScreenshot());
        }

        if (result.isSuccess() && method.getName().equals("oderDetailsTests")) {
            new LoginPage(app.driver).logout();
        }
    }
}