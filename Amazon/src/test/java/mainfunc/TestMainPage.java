package mainfunc;

import config.Base;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.testng.Assert;
import org.testng.annotations.*;
import pagefactory.AmazonMainPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 9/18/16.
 */
public class TestMainPage extends Base {

    private AmazonMainPage loginPage;

    private static final String url="https://www.amazon.com/ap/" +
            "signin?_encoding=UTF8&" +
            "openid.assoc_handle=usflex&" +
            "openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&" +
            "openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&" +
            "openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&" +
            "openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&" +
            "openid.pape.max_auth_age=0&" +
            "openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav";

    private static final String subUrl1=url+"_signin";
    private static final String subUrl2=url+"_custeric_signin";
    private static final String subUrl3=url+"_ya_signin";




    @BeforeClass
    public void initPageObjects(){
        loginPage=new AmazonMainPage(driver);
    }

    @BeforeMethod
    public void goToMainPage(){
        driver.get("http://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void getToMainPage(){
        driver.navigate().back();
    }

    @Test
    public void loginTestWithLink(){
        loginPage.link_YourAccount.click();
        Assert.assertEquals(driver.getCurrentUrl(), subUrl3, "some message");

    }

    @Test
    public void loginTestWithBtn(){
        Actions action=new Actions(driver);
        action
                .moveToElement(loginPage.link_YourAccount)
                .moveToElement(loginPage.btn_SingIn)
                .click()
                .perform();

        Assert.assertEquals(driver.getCurrentUrl(), subUrl1, "some message");
    }

    @Test
    public void loginTestWithSmallBtn(){
        Actions action=new Actions(driver);
        action
                .moveToElement(loginPage.btn_SingInSmall)
                .click()
                .perform();

        //Assert.assertEquals(driver.getCurrentUrl(), subUrl2, "some message");
    }

}
