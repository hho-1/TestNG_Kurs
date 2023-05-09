package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MetodDriver {
    public static WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        loginTest();
    }

    void loginTest(){
        //Bundan sonra bu siteyi kullanacagimiz icin asagidaki login kismini da buraya dahil ettik

        WebElement username = driver.findElement(By.cssSelector("input#input-email"));
        username.sendKeys("asdfgh54321@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input#input-password"));
        password.sendKeys("1234qweasd");

        WebElement loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        loginButton.click();

        //WebElement detailsButton = driver.findElement(By.id("details-button"));
        //detailsButton.click();

        //WebElement continueAnyway = driver.findElement(By.id("proceed-link"));
        //continueAnyway.click();
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
