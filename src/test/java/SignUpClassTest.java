import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class SignUpClassTest extends ChromeBaseClass {

    @Test
    public void SignUpWithoutEmailTest() throws IOException, InterruptedException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.ClickSignUp();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.signUpWithoutCreds("", "123456789", "123456789");
        Thread.sleep(3000);
        String error = signUpPage.getErrorEmail();
        Assert.assertEquals("Please fill in the e-mail address.", error);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen3.png"));
    }

    @Test
    public void SignUpWithoutPassTest() throws IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.ClickSignUp();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.signUpWithoutCreds("Masha2003@mail.ru", "987456123", "123456789");
        String error = signUpPage.getErrorDiffPass();
        Assert.assertEquals("The passwords do not match!", error);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen4.png"));
    }

    @Test
    public void SignUpSuccessWindow() throws IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.ClickSignUp();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        int random = (int)(Math.random() * 50 + 1);
        SignUpPage newSingUpPage = signUpPage.signUpWithCreds("Sasha_"+ random + "@gmail.ru" , "Marisha1234", "Marisha1234");
        String success = newSingUpPage.getSuccessWindow();
        Assert.assertEquals("Check your inbox to activate your account", success);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen5.png"));
    }


}
