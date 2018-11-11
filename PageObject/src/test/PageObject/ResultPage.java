import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {

    private WebDriver driver;

    private WebDriverWait wait;

    public ResultPage(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(this.driver, 50);

        waitLoadingPage();
    }

    private void waitLoadingPage(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("isLoaded")));
    }

    public boolean checkErrors(){
        int countOfOffers, countOfBuisnessClasses;
        countOfOffers = driver.findElements(By.xpath("//*[@id=sortedOffers]/div/div")).size();
        countOfBuisnessClasses = driver.findElements(By.xpath("//*[@class=fa fa-briefcase orange]")).size();

        return countOfOffers == countOfBuisnessClasses;
    }

}
