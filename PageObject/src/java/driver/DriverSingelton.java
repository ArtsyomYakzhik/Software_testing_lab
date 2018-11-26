import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingelton {

    private static WebDriver driver;

    private DriverSingelton(){}

    public static WebDriver getDriver(){
        if(driver == null)
            setInstance();
        return driver;
    }

    private static void setInstance(){
        System.setProperty("webdriver.chrome.driver", "src/resources/driverbinary/chromedriver.exe");
        driver = new ChromeDriver();
        setSettings();
    }

    private static void setSettings(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeDriver(){
        driver.quit();
    }
}
