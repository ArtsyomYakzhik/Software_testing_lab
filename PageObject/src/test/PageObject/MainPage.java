import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    private WebDriverWait wait;


    public MainPage(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(this.driver, 50);
    }

    private void setOptions(){

        driver.findElement(By.xpath("//*[@for='journey-oneway']")).click();
        driver.findElement(By.xpath("//label[@for='cabin2']")).click();
    }

    private void fill(){

        driver.findElement(By.id("cty0")).sendKeys("Minsk");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autocomplete-suggestions'][1]")));
        driver.findElement(By.xpath("//*[@class='autocomplete-suggestions'][1]/div[2]")).click();

        driver.findElement(By.id("cty1")).sendKeys("Moscow");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autocomplete-suggestions'][2]")));
        driver.findElement(By.xpath("//*[@class='autocomplete-suggestions'][2]/div[2]")).click();

        driver.findElement(By.id("outDate")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='outCalHolderD']/div/div[2]/table/tbody/tr[2]/td[1]/a")));
        driver.findElement(By.xpath("//*[@id='outCalHolderD']/div/div[2]/table/tbody/tr[2]/td[1]/a")).click();
    }

    public WebDriver toResultPage() {

        setOptions();
        fill();

        driver.findElement(By.xpath("//div[@class='element']/div[@class='button']")).submit();

        return driver;

    }
}