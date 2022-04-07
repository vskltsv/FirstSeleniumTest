import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClassTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/FirstSeleniumTest/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://context.reverso.net/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
    }

    @Test
    public void setClickLogin() throws IOException {
       MainPage newMainPage = mainPage.ClickLogin();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen6.png"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
