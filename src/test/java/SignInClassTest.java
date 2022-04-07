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

public class SignInClassTest {

    private WebDriver driver;
    private SignInPage signInPage;

    @Before

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:/FirstSeleniumTest/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://account.reverso.net/Account/Login?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void loginWithoutNameTest() throws InterruptedException, IOException {
        //Thread.sleep(3000);
        SignInPage newSingInpage = signInPage.SignInWithoutCreds("","Masha2002");
      String error = newSingInpage.getErrorEmailText();
        Assert.assertEquals("Пожалуйста, заполните электронный адрес.", error);

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

     FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen1.png"));
    }

    @Test
    public void loginWithoutPassTest() throws InterruptedException, IOException {
        //Thread.sleep(3000);
        SignInPage newSingInpage = signInPage.SignInWithoutCreds("Masha2002@mail.ru","");
        String error = newSingInpage.getErrorPassText();
        Assert.assertEquals("Пожалуйста, заполните поле \"Пароль\".", error);

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen2.png"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
