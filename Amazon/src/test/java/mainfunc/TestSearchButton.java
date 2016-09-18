package mainfunc;

import config.Base;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import pagefactory.AmazonMainPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 9/18/16.
 */
public class TestSearchButton extends Base {

    private AmazonMainPage mainPage=null;

    @BeforeClass
    public void initPageObjects(){
        driver.get("http://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void goToMainPage(){
        mainPage=new AmazonMainPage(driver);
    }

    @AfterMethod
    public void getToMainPage(){
        driver.navigate().back();
    }

    @Test(dataProviderClass = data.DataProviderClass.class, dataProvider="data")
    public void seachItemTest(String item){
        mainPage.field_Search.sendKeys(item, Keys.ENTER);

    }

}
