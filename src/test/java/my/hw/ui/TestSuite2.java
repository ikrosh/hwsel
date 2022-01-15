package my.hw.ui;

import my.hw.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite2 extends BaseTest {

    @Test
    public void test3() {
        driver.get("https://www.gismeteo.ua/");
        Assert.assertTrue(driver.getTitle().contains("GISMETEO"));
    }

    @Test
    public void test4() {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/mouse/");
        Assert.assertEquals("Mouse actions | Selenium", driver.getTitle());
    }
}
