package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ParameterDriver {
    public WebDriver driver;   //Burasi normalde staticti, ama bu ayni anda birden cok browser calistirmaya engel oldugu icin sildik. static 1 tane demekmis, burada paralel testte coklu browsera ihtiyac var

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser){

        if(browser.equalsIgnoreCase( "chrome")){

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            driver = new ChromeDriver();

        }
        else if (browser.equalsIgnoreCase( "firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        //Bundan sonra bu siteyi kullanacagimiz icin asagidaki login kismini da buraya dahil ettik

        WebElement username = driver.findElement(By.cssSelector("input#input-email"));
        username.sendKeys("asdfgh54321@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input#input-password"));
        password.sendKeys("1234qweasd");

        WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        loginButton.click();

        /*
        if(!browser.equalsIgnoreCase( "firefox")){
            WebElement detailsButton = driver.findElement(By.id("details-button"));
            detailsButton.click();

            WebElement continueAnyway = driver.findElement(By.id("proceed-link"));
            continueAnyway.click();
        }

         */

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
