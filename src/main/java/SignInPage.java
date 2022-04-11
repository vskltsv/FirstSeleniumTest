import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

      WebDriver driver ;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@Id='Email']")
    private  WebElement email;
    @FindBy(xpath = "//input[@id='Password']")
    private  WebElement pass;
    @FindBy(xpath = "//input[@id='RememberMe']")
    private  WebElement CheckBox;
//    @FindBy(xpath = "//button[contains(text(),'Войти')]")
//    private  WebElement buttonSignIn;
    @FindBy(xpath = "//li[contains(text(),'Please fill in the e-mail address.')]")
    private  WebElement error;
    @FindBy(xpath = "//span[@id='Password-error']")
    private  WebElement error2;

    public void openSignInPage(){
        driver.get("https://account.reverso.net/Account/Login?returnUrl=https%3A%2F%2Fcontext.reverso.net%2F&lang=ru");
    }

    public SignInPage typeEmail(String username) {
        //driver.findElement(By.xpath("//*[@Id='Email']")).sendKeys(username);
        email.sendKeys(username);
        return this;
    }

    public SignInPage typePass(String password) {
        // driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
         pass.sendKeys(password);
        return this;
    }

    public SignInPage signInWithoutCreds(String username, String password){
        this.typeEmail(username);
        this.typePass(password);
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
          //buttonSignIn.click();
        return new SignInPage(driver);

    }

    public String getErrorEmailText(){
        return  error.getText();
    }

    public String getErrorPassText(){
        return  error2.getText();

    }


//    private SignInPage clickButtonReg() {
//        buttonSignIn.click();
//        return this;
//    }

}
