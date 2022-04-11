import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class SignInClassTest extends ChromeBaseClass {

    @Test
    public void setSignIn() throws IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.ClickSignIn();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithoutCreds("", "Masha2002");
        String error = signInPage.getErrorEmailText();
        Assert.assertEquals("Please fill in the e-mail address.", error);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen1.png"));
    }

    @Test
    public void loginWithoutPassTest() throws InterruptedException, IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.ClickSignIn();

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithoutCreds("Masha2002@mail.ru", "");
        String error = signInPage.getErrorPassText();
        Assert.assertEquals("Please fill in the 'Password' field.", error);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File("D:/FirstSeleniumTest/screenshot/screen2.png"));
    }

}
