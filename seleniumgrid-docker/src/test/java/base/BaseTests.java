package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        goHome();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }


//    @Parameters({"Port"})
//    @BeforeClass
//    public void initiateDriver(String Port) throws MalformedURLException {
//        if(Port.equalsIgnoreCase("9001"))
//        {
//            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
//            driver.manage().window().maximize();
//        }
//        else if(Port.equalsIgnoreCase("9002")){
//            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
//            driver.manage().window().maximize();
//        }
//
//        driver.get("https://the-internet.herokuapp.com/");
//        homePage = new HomePage(driver);
//    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
