import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "Input_Email")
    private WebElement email;
    @FindBy(id = "Input_Password")
    private WebElement pass;
    @FindBy(id = "Input_ConfirmPassword")
    private WebElement confirmPass;
    @FindBy(id = "Input_IsSubscribedToNewsletters")
    private WebElement CheckBox;
    @FindBy(xpath = "//button[@id='recaptcha']")
    private WebElement buttonReg;
    @FindBy(xpath = "//h2[contains(text(),'Check your inbox to activate your account')]")
    private WebElement successWindow;
    @FindBy(xpath = "//li[contains(text(),'Please fill in the e-mail address.')]")
    private WebElement errorEmail;
    @FindBy(xpath = "//span[@id='Input_ConfirmPassword-error']")
    private WebElement errorDiffPass;

    private SignUpPage typeEmail(String mail) {
        email.sendKeys(mail);
        return this;
    }

    private SignUpPage typePass(String password) {
        pass.sendKeys(password);
        return this;
    }

    private SignUpPage typeConfirmPass(String password) {
        confirmPass.sendKeys(password);
        return this;
    }

    private SignUpPage clickCheckBox() {
        CheckBox.click();
        return this;
    }

    public SignUpPage signUpWithCreds(String username, String password, String password2) {
        this.typeEmail(username);
        this.typePass(password);
        this.typeConfirmPass(password2);
        buttonReg.click();
        return new SignUpPage(driver);
    }

    public SignUpPage signUpWithoutCreds(String username, String password, String password2) {
        this.typeEmail(username);
        this.typePass(password);
        this.typeConfirmPass(password2);
        buttonReg.click();
        return new SignUpPage(driver);
    }

    private SignUpPage clickButtonReg() {
        buttonReg.click();
        return this;
    }

    public String getSuccessWindow() {
        //return successWindow.getText();
    return driver.findElement(By.xpath("//h2[contains(text(),'Check your inbox to activate your account')]")).getText();
    }


    public String getErrorEmail() {
        return errorEmail.getText();
    }

    public String getErrorDiffPass() {
        return errorDiffPass.getText();
    }

}




