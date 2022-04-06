import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

      WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//input[@id='Email']")
    private By email;
    @FindBy(xpath = "//input[@id='Password']")
    private By pass;
    @FindBy(xpath = "//input[@id='RememberMe']")
    private By CheckBox;
    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private By buttonSignIn;
    //private By successWindow = By.xpath("//h2[contains(text(),'Проверьте свою электронную почту, чтобы активирова')]");


    private SignInPage typeEmail(String mail) {
        driver.findElement(email).sendKeys("lala@mail.com");
        return this;
    }

    private SignInPage typePass(String password) {
        driver.findElement(pass).sendKeys("lala12345");
        return this;
    }
    private SignInPage clickButtonReg() {
        driver.findElement(buttonSignIn).click();
        return this;
    }

}
