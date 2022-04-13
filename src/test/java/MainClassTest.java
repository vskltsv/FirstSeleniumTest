import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MainClassTest extends ChromeBaseClass{

    @DisplayName(value = "Clicking on the account button")
    @Test
    public void setClickLogin() throws IOException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickLogin();
        driver.findElement(By.className("login")).click();
        takeScreenshot(driver);
    }


}
