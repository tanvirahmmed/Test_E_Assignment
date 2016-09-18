package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by admin on 9/18/16.
 */
public class AmazonLoginPage {

    @FindBy(id="ap_email")
    public WebElement usr;

    @FindBy(id="ap_password")
    public WebElement pass;

    @FindBy(id="signInSubmit")
    public WebElement btn_login;

    @FindBy(id="createAccountSubmit")
    public WebElement btn_create;

    public AmazonLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
