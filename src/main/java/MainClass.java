import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "D:/FirstSeleniumTest/drivers/chromedriver.exe");

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
