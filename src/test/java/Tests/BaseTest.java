package Tests;

import PageObjects.CarList;
import PageObjects.HomePage;
import PageObjects.navigatePage;
import Utils.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

public class BaseTest {

    protected HomePage homePage;
    protected navigatePage nPage;
    protected CarList carList;
    protected static SoftAssert SA;
    protected ChromeOptions options;
    protected static WebDriver driver;
    protected GetProperties properties = new GetProperties();

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void setupSuite(final String browser) throws MalformedURLException {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", properties.getString("CHROMEDRIVER_PATH_32_WIN"));

            options = new ChromeOptions();
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", properties.getString("FIREFOXDRIVER_PATH_64_WIN"));

            driver = new FirefoxDriver();
        }

        SA = new SoftAssert();

        driver.get(properties.getString("URL"));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterSuite(alwaysRun = true)
    public void teardownTest(){
        driver.quit();
    }
}
