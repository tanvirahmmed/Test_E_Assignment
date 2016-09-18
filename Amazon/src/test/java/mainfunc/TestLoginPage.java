package mainfunc;

import config.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagefactory.AmazonLoginPage;
import pagefactory.AmazonMainPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 9/18/16.
 */
public class TestLoginPage extends Base{


    private AmazonMainPage mainPage=null;
    private AmazonLoginPage loginPage=null;

    @BeforeClass
    public void initPageObject(){
        mainPage=new AmazonMainPage(driver);
        loginPage=new AmazonLoginPage(driver);
    }

    @BeforeMethod
    public void goToLoginPage(){
        driver.get("http://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.link_YourAccount.click();
    }

    @AfterMethod
    public void getToLoginPage(){
        driver.navigate().back();
    }

    @Test
    public void testLoginWithDifferentUsersAndPasswords(){

        loginPage.usr.sendKeys("riz_aziz2002@mail.ru");
        loginPage.usr.sendKeys("somepassword");
        loginPage.btn_login.click();

    }

}
