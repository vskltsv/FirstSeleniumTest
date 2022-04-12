import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
   private static  WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

//    @FindBy(className = "login")
//    private WebElement login;
    @FindBy(xpath = "//span[contains(text(),'Зарегистрироваться')]")
    private WebElement SignUp;
    @FindBy(xpath = "//header/div[1]/div[2]/div[1]/div[2]/a[2]")
    private WebElement SignIn;

    public MainPage clickLogin() {
       driver.get("https://context.reverso.net/");
        return this;
    }

    public SignUpPage clickSignUp(){
        driver.get("https://account.reverso.net/Account/Register?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=en");
        return new SignUpPage(driver);
    }
    public SignInPage clickSignIn(){
        driver.get("https://account.reverso.net/Account/Login?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=en");
        return new SignInPage(driver);
    }

}
