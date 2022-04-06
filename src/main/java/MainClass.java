import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Vladimir Sokoltsov/Desktop/OneTest/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://context.reverso.net/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


       MainPage mainPage = new MainPage(driver);


//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(screenshot, new File("C:/Users/Vladimir Sokoltsov/Desktop/OneTest/screenshot/screen1.png"));

        driver.quit();
    }
}
