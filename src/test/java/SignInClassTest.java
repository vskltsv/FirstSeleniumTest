import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignInClassTest extends ChromeBaseClass {

    private static final String CHECK_ErrorEmail = "Please fill in the e-mail address.";
    private static final String CHECK_ErrorPASSWORD = "Please fill in the 'Password' field.";


    @DisplayName(value = "Check input only password")
    @Test
    public void setSignIn() throws IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignIn();
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithoutCreds("", "Masha2002");
        String error = signInPage.getErrorEmailText();
        Assert.assertEquals(CHECK_ErrorEmail, error);
        takeScreenshot(driver);
    }

    @DisplayName(value = "Checking only email input")
    @Test
    public void loginWithoutPassTest() throws InterruptedException, IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignIn();

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInWithoutCreds("Masha2002@mail.ru", "");
        String error = signInPage.getErrorPassText();
        Assert.assertEquals(CHECK_ErrorPASSWORD, error);
        takeScreenshot(driver);

    }

}
