package my.hw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverInit {

    private static WebDriver driver;

    private DriverInit(Browser browser) {
        setWebDriver(browser);
    }

    public static WebDriver getWebDriver(Browser browser) {
        if (driver == null) {
            new DriverInit(browser);
        }
        return driver;
    }

    private void setWebDriver(Browser browserName) {
        switch (browserName) {
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            case FF:
                driver = WebDriverManager.firefoxdriver().create();
                break;
        }
    }

    public enum Browser {
        CHROME,
        FF
    }
}
