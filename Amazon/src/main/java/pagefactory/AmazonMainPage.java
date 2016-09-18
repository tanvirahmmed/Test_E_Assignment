package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by admin on 9/18/16.
 */
public class AmazonMainPage {

    @FindBy(xpath=".//*[@id='nav-link-yourAccount']/span[2]")
    public WebElement link_YourAccount;

    @FindBy(xpath=".//*[@id='nav-flyout-yourAccount']")
    public WebElement btn_SingInSmall;

    @FindBy(xpath=".//*[@id='nav-flyout-ya-signin']/a/span")
    public WebElement btn_SingIn;

    @FindBy(css="#twotabsearchtextbox")
    public WebElement field_Search;

    public AmazonMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
