package browser;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.util.PackageUtils;
import org.openqa.selenium.WebDriver;

public class TestBase {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        driver = DriverFactory.getOrCreateDriver(Browser.CHROME);
        return driver;
    }


    @BeforeEach
    public void setupDriver() {

        driver.get("https://bugbank.netlify.app/#");
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            DriverFactory.quitDriver();
        }
    }
}
