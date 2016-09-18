package config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
/**
 * Created by admin on 9/18/16.
 */
public class Base {

    public WebDriver driver;


    @Parameters({"browser", "os"})
    @BeforeSuite
    public void setUp(@Optional("chrome") String browser,
                               @Optional("win") String os){

        switch(browser){

            case "chrome" : System.setProperty("webdriver.chrome.driver",
                    "/Users/admin/Desktop/WebTestAutomationFramework/Generic/drivers/chromedriver");
                driver=new ChromeDriver();

            case "firefox" : System.setProperty("webdriver.gecko.driver",
                    "/Users/admin/Desktop/WebTestAutomationFramework/Generic/drivers/geckodriver");
                driver=new FirefoxDriver();


        }

    }

    @AfterSuite
    public void tearDown(){
       driver.quit();
    }


}
