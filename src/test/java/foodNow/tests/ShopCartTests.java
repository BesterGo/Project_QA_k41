package foodNow.tests;

import com.foodNow.pages.ProductAddPage;
import com.foodNow.pages.ShopCartPage;
import com.foodNow.pages.LoginPage;
import foodNow.kernel.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopCartTests extends BaseTests {

    @BeforeMethod
    public void preCondition() {
        new LoginPage(app.driver).loginExistedUser();
        new ShopCartPage(app.driver).addProductToCart();
    }

    @Test
    public void proceedToCheckout() {
        checkoutToCart();
    }
    private void checkoutToCart() {
        new ShopCartPage(app.driver)
                .clickIconCart()
                .clickPlusButton()
                .proceedToCheckout();
    }
}
