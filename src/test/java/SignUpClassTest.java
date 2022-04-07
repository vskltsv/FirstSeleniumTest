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

public class SignUpClassTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/FirstSeleniumTest/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://account.reverso.net/Account/Register?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void SignUpWithoutEmailTest() throws IOException {
        SignUpPage newSingUpPage = signUpPage.SignUpWithoutCreds("", "123456789", "123456789");
        String error = newSingUpPage.getErrorEmail();
        Assert.assertEquals("Пожалуйста, заполните электронный адрес.", error);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen3.png"));
    }

    @Test
    public void SignUpWithoutPassTest() throws IOException {
        SignUpPage newSingUpPage = signUpPage.SignUpWithoutCreds("Masha2003@mail.ru", "987456123", "123456789");
        String error = newSingUpPage.getErrorDiffPass();
        Assert.assertEquals("Пароли не совпадают!", error);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen4.png"));
    }

    @Test
    public void SignUpSuccessWindow() throws IOException {
        SignUpPage newSingUpPage = signUpPage.SignUpWithoutCreds("Mashalorna9004@mail.ru", "Masha1989", "Masha1989");
        String cool = newSingUpPage.getSuccessWindow();
        Assert.assertEquals("Мы отправили Вам письмо со ссылкой активации.", cool);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen5.png"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
