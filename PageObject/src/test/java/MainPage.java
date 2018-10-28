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

        driver.findElement(By.xpath("//*[@id=\"journey\"]/label[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"sf\"]/div[1]/div[2]/div/div[1]/label")).click();
    }

    private void fill(){

        driver.findElement(By.xpath("//*[@id=\"cty0\"]")).sendKeys("Minsk");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]")));

        driver.findElement(By.xpath("/html/body/div[3]/div[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"cty1\"]")).sendKeys("Moscow");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]")));

        driver.findElement(By.xpath("/html/body/div[4]/div[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"datesH\"]/div[1]/div[1]/div/div[2]/table")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"outCalHolderD\"]/div/div[2]/table/tbody/tr[2]/td[1]/a")));

        driver.findElement(By.xpath("//*[@id=\"outCalHolderD\"]/div/div[2]/table/tbody/tr[2]/td[1]/a")).click();
    }

    public WebDriver toResultPage() {

        setOptions();
        fill();

        driver.findElement(By.xpath("//*[@id=\"sf\"]/div[3]/div[2]/div")).submit();

        return driver;

    }
}