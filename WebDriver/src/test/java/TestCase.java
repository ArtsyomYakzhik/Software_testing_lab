import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(url);

        driver.findElement(By.xpath("//*[@for='journey-oneway']")).click();
        driver.findElement(By.xpath( "//*[@name='children']/../a" )).click();
        driver.findElement(By.xpath( "//*[@name='adults']/../a[2]" )).click();

        driver.findElement(By.id("cty0")).sendKeys("Minsk");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-index='0']")));
        driver.findElement(By.xpath("//div[@data-index='0']")).click();

        driver.findElement(By.id("cty1")).sendKeys("Moscow");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete-suggestions'][2]/div[@data-index='0']")));
        driver.findElement(By.xpath("//div[@class='autocomplete-suggestions'][2]/div[@data-index='0']")).click();
	    
        driver.findElement(By.xpath("//*[@id='cty0']")).sendKeys("Minsk");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autocomplete-suggestions'][1]")));
        driver.findElement(By.xpath("//*[@class='autocomplete-suggestions'][1]/div[2]")).click();

        driver.findElement(By.xpath("//*[@id='cty1']")).sendKeys("Moscow");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autocomplete-suggestions'][2]")));
        driver.findElement(By.xpath("//*[@class='autocomplete-suggestions'][2]/div[2]")).click();
	    
        driver.findElement(By.xpath("//input[@id='outDate']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='outCalHolderD']/div/div[2]/table/tbody/tr[2]/td[1]/a")));
        driver.findElement(By.xpath("//*[@id='outCalHolderD']/div/div[2]/table/tbody/tr[2]/td[1]/a")).click();

        driver.findElement(By.xpath("//div[@class='shared element']/div[2]/div")).submit();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"isLoaded\"]")));

        driver.findElement(By.xpath("//div[@class='element']/div[@class='button']")).submit();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("isLoaded")));

        Assert.assertEquals(0, driver.findElements(By.id("searchResList")).size());
        driver.quit();
        driver = null;
    }
}
}

}

