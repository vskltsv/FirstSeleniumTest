import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(className = "login")
    private WebElement login;
    @FindBy(xpath = "//span[contains(text(),'Зарегистрироваться')]")
    private WebElement SignUp;
    @FindBy(xpath = "//span[text() = 'Войти']")
    private WebElement SignIn;

    public void ClickLogin(){
        login.click();
    }

    public SignUpPage ClickSignUp(){
        SignUp.click();
        return new SignUpPage(driver);
    }
    public SignInPage ClickSignIn(){
        SignIn.click();
        return new SignInPage(driver);
    }

}
