package my.hw;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void initWebDriver() {
        String browser = System.getProperty("browser");

        switch (browser) {
            case "chrome":
                driver = DriverInit.getWebDriver(DriverInit.Browser.CHROME);
                break;
            case "ff":
                driver = DriverInit.getWebDriver(DriverInit.Browser.FF);
                break;
            default:
                System.err.println("You have to chose from 'chrome' and 'ff'");
        }
    }

    @AfterSuite
    public void closeWebDriver() {
        driver.quit();
    }
}

