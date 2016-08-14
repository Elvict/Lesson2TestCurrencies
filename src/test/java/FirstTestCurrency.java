import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;
/**
 * Created by Elena Romanovskaya
 */
public class FirstTestCurrency {

    @Test
    public void testName() throws Exception {
//        String expectedResult = "49"+Character.toString((char)160)+"700,82";
        String expectedResult = "49700,82";
        WebDriver driver = new FirefoxDriver();
        driver.get("http://finance.i.ua/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[@onclick='fn_changeSell(this)']")).click();
        driver.findElement(By.id("fn_s1")).clear();
        driver.findElement(By.id("fn_s1")).sendKeys("2000");
        new Select(driver.findElement(By.id("fn_c1"))).selectByVisibleText("USD");
        new Select(driver.findElement(By.id("fn_bank"))).selectByVisibleText("НБУ");
//        assertEquals(driver.findElement(By.id("fn_o1_1")).getAttribute("value"), expectedResult);
        String actualResult = driver.findElement(By.id("fn_o1_1")).getAttribute("value");
        while(actualResult.contains(Character.toString((char)160))) {
            String replace = actualResult.replace(Character.toString((char)160), "");
            actualResult=replace;
        }
        assertEquals(actualResult, expectedResult);
//        (new WebDriverWait(driver,10))
//                .until(ExpectedConditions.textToBePresentInElement(result,expectedResult));
        Assert.assertEquals(actualResult,expectedResult);
        driver.quit();
    }
}
