import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

      WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@Id='Email']")
    private  WebElement email;
    @FindBy(xpath = "//input[@id='Password']")
    private  WebElement pass;
    @FindBy(xpath = "//input[@id='RememberMe']")
    private  WebElement CheckBox;
    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private  WebElement buttonSignIn;
    @FindBy(xpath = "//li[contains(text(),'Пожалуйста, заполните электронный адрес.')]")
    private  WebElement error;
     @FindBy(xpath = "//li[contains(text(),'Пожалуйста, заполните поле Пароль.')]")
     private  WebElement error2;


    private SignInPage typeEmail(String username) {
        driver.findElement(By.xpath("//*[@Id='Email']")).sendKeys(username);
        return this;
    }

    private SignInPage typePass(String password) {
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        return this;
    }

    public SignInPage SignInWithoutCreds(String username,String password){
        this.typeEmail(username);
        this.typePass(password);
        driver.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();
        return new SignInPage(driver);
    }

    public String getErrorEmailText(){
        return  driver.findElement(By.xpath("//li[contains(text(),'Пожалуйста, заполните электронный адрес.')]")).getText();
    }

    public String getErrorPassText(){
        return  driver.findElement(By.xpath("//span[@id='Password-error']")).getText();

    }


    private SignInPage clickButtonReg() {
        driver.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();
        return this;
    }

}
