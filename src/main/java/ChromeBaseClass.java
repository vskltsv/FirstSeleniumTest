import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class ChromeBaseClass {
    public WebDriver driver;

    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "D:/FirstSeleniumTest/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
//    public static void makeScreen (WebDriver driver, String fileWithPath) throws Exception {
//        TakesScreenshot scrShot = ((TakesScreenshot) driver);
//        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//        File DestFile = new File(fileWithPath);
//        FileUtils.copyFile(SrcFile, DestFile);
//    }

    public void takeScreenshot(WebDriver driver) throws IOException {
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
    }



    @After
    public void tearDown() {
        driver.quit();
    }


}


