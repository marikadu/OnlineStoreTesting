package base;

import com.base.BasePage;
import com.ginandjuice.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    protected BasePage basePage;

    private String WebsiteUrl = ("https://ginandjuice.shop/");


    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(WebsiteUrl);
        basePage = new BasePage();
        homePage = new HomePage();
        basePage.setDriver(driver);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
