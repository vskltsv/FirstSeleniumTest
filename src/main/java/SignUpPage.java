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
    private By successWindow = By.xpath("//h2[contains(text(),'Проверьте свою электронную почту, чтобы активирова')]");


    private SignUpPage typeEmail(String mail) {
        driver.findElement(email).sendKeys("lala@mail.com");
        return this;
    }

    private SignUpPage typePass(String password) {
        driver.findElement(pass).sendKeys("lala12345");
        return this;
    }

    private SignUpPage typeConfirmPass(String password) {
        driver.findElement(email).sendKeys("lala12345");
        return this;
    }

    private SignUpPage clickCheckBox() {
        driver.findElement(CheckBox).click();
        return this;
    }

    private SignUpPage clickButtonReg() {
        driver.findElement(buttonReg).click();
        return this;
    }

    private String getSuccessWindow() {
        return  driver.findElement(successWindow).getText();
    }



}




