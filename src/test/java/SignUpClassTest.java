import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignUpClassTest extends ChromeBaseClass {

    private static final String CHECK_SuccessWindow = "Check your inbox to activate your account";
    private static final String CHECK_PASSWORD = "The passwords do not match!";
    private static final String CHECK_ErrorEmail = "Please fill in the e-mail address.";


    @DisplayName(value = ("To verify that only passwords are entered"))
    @Test
    public void SignUpWithoutEmailTest() throws IOException, InterruptedException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignUp();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.signUpWithoutCreds("", "123456789", "123456789");
        String error = signUpPage.getErrorEmail();
        Assert.assertEquals(CHECK_ErrorEmail, error);
        takeScreenshot(driver);
    }

    @DisplayName(value = "Checking for different passwords when confirming")
    @Test
    public void SignUpWithoutPassTest() throws IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignUp();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.signUpWithoutCreds("Masha2003@mail.ru", "987456123", "123456789");
        String error = signUpPage.getErrorDiffPass();
        Assert.assertEquals(CHECK_PASSWORD, error);
        takeScreenshot(driver);
    }

    @DisplayName(value = "Validation of valid data")
    @Test
    public void SignUpSuccessWindow() throws IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignUp();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        int random = (int) (Math.random() * 100 + 1);
        signUpPage.signUpWithCreds("Sasha_" + random + "@gmail.com", "Marisha1234", "Marisha1234");
        String success = signUpPage.getSuccessWindow();
        Assert.assertEquals(CHECK_SuccessWindow, success);
        takeScreenshot(driver);
    }


}
