import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class TestClass {

    private WebDriver driver;
    PageClass pageClass;

    @Parameters({"Port"})
    @BeforeClass
    public void initiateDriver(String Port) throws MalformedURLException {
        if(Port.equalsIgnoreCase("9001"))
        {
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            driver.manage().window().maximize();
        }
        else if(Port.equalsIgnoreCase("9002")){
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
            driver.manage().window().maximize();
        }

        pageClass = new PageClass(driver);
    }

    @AfterClass
    public void quitDriver()
    {
        driver.quit();
    }

    @Parameters("browser")
    @Test
    public void Test1(String browser){

        System.out.println("Test1 :" + browser);
        driver.get("https://www.amazon.in/");
        pageClass.enterItemToSearch("books");
        pageClass.getSearchedItem(0);
    }

    @Parameters("browser")
    @Test
    public void Test2(String browser){

        System.out.println("Test2 :" + browser);
        driver.get("https://www.amazon.in/");
        pageClass.enterItemToSearch("headphones");
        pageClass.getSearchedItem(0);
    }
}