import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.w3c.dom.ls.LSOutput;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //li[contains(text(),'Неверный электронный адрес.')]
    private By email = By.id("Input_Email");
    private By pass = By.id("Input_Password");
    private By confirmPass = By.id("Input_ConfirmPassword");
    private By CheckBox = By.id("Input_IsSubscribedToNewsletters");
    private By buttonReg = By.id("recaptcha");
    private By successWindow = By.xpath("//p[contains(text(),'Мы отправили Вам письмо со ссылкой активации.')]");
    private By errorEmail = By.xpath("//li[contains(text(),'Пожалуйста, заполните электронный адрес.')]");
    private By errorDiffPass = By.xpath("//span[@id='Input_ConfirmPassword-error']");

    private SignUpPage typeEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
        return this;
    }

    private SignUpPage typePass(String password) {
        driver.findElement(pass).sendKeys(password);
        return this;
    }

    private SignUpPage typeConfirmPass(String password) {
        driver.findElement(confirmPass).sendKeys(password);
        return this;
    }

    private SignUpPage clickCheckBox() {
        driver.findElement(CheckBox).click();
        return this;
    }

    public SignUpPage SignUpWithoutCreds(String username, String password, String password2) {
        this.typeEmail(username);
        this.typePass(password);
        this.typeConfirmPass(password2);
        driver.findElement(buttonReg).click();
        //driver.findElement(CheckBox).click();
        return new SignUpPage(driver);
    }

    private SignUpPage clickButtonReg() {
        driver.findElement(buttonReg).click();
        return this;
    }

    public String getSuccessWindow() {
        return driver.findElement(successWindow).getText();
    }

    public String getErrorEmail() {
        return driver.findElement(errorEmail).getText();
    }

    public String getErrorDiffPass() {
        return driver.findElement(errorDiffPass).getText();
    }

}




