package foodNow.kernel;

import com.foodNow.kernel.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTests {

    protected final ApplicationManager app = new ApplicationManager();
    WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(BaseTests.class);

    @BeforeSuite //Suite - запускается несколько раз
    public void start() {
        logger.info("*** TESTING IN PROGRESS ***");
        app.init();
    }

    @BeforeMethod
    public void startTest(Method method){
        logger.info("test " + method.getName() + " started");
    }

    @AfterMethod
    public void stopTest(Method method, ITestResult result){
        if (result.isSuccess()){
            logger.info("Test is PASSED: [" + method.getName() + "]");
        } else {
            logger.info("Test is FAILED: [" + method.getName() + "], Screenscot: [" + app.getBaseHelper().takeScreenshot() + "]");
        }
    }


    @AfterSuite(enabled = true)
    public void tearDown() {
        logger.info("*** TESTING Ended ***");
        app.stop(); //завершение работы браузера
    }
}
