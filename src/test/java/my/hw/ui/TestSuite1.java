package my.hw.ui;

import my.hw.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite1 extends BaseTest {

    @Test
    public void firstTest() {
        driver.get("http://automationpractice.com/");
        By signIn = By.xpath("//a[@class='login']");
        driver.findElement(signIn).click();

        //generate random email, and check register form is displayed

        final String email = String.format("user_%s@putsbox.com", RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("account-creation"));
        driver.findElement(By.xpath("//form[@id='account-creation_form']"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void firstTest1() {
        driver.get("http://automationpractice.com/");
        By signIn = By.xpath("//a[@class='login']");
        driver.findElement(signIn).click();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("example@email.com");
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //verify that error 'email already exist' is displayed
        Assert.assertTrue(driver.findElement(By.id("create_account_error")).getText().contains("already been registered"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
