import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.timer.Timer;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/*
Test case for looking on a capability of taken tickets for only childs
Expected value: We can't get some tickets with our conditions
 */

public class TestCase {
    @Test
    public void testOnlyChildPassangers(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        String url = "https://aviago.by/";
        String year = "2018", month = "11", day = "4";
        String cityXpath = "//div[(@class='autocomplete-suggestions') and (not(contains(@style,'display: none'))) and (not(contains(@data-index, .)))]";
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(url);
        driver.findElement(By.xpath("//*[@for='journey-oneway']")).click();
        driver.findElement(By.xpath( "//*[@name='children']/../a" )).click();
        driver.findElement(By.xpath( "//*[@name='adults']/../a[2]" )).click();
        driver.findElement(By.id("cty0")).sendKeys("Minsk");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityXpath)));
        driver.findElement(By.xpath(cityXpath+"/div[2]")).click();
        driver.findElement(By.id("cty1")).sendKeys("Moscow");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityXpath)));
        driver.findElement(By.xpath(cityXpath+"/div[2]")).click();
        driver.findElement(By.id("outDate")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outCalHolder")));
        driver.findElement(By.xpath("//td[@data-year='"+year+"' and @data-month='"+month+"']//a[text()='"+day+"']/..")).click();
        driver.findElement(By.xpath("//div[@class='element']/div[@class='button']")).submit();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("isLoaded")));
        Assert.assertEquals(0, driver.findElements(By.id("searchResList")).size());
        driver.quit();
        driver = null;
    }
}