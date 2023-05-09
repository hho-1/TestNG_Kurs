package _01_Giris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _04_Enable {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @BeforeClass
    void beforeClass(){

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);                // Bu iki satiri sonraki videolardan görüp ekledim ama ne manaya geldiklerini bilmiyorum.

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
    }

    @AfterClass
    void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    void test1(){
        String u1 = driver.getCurrentUrl();
        System.out.println(u1);
    }

    @Test (enabled = false)  // BU testi calistirma demek bu
    void test2(){
        String u2 = driver.getTitle();
        System.out.println(u2);
    }

    @Test
    void test3(){
        String u3 = driver.getWindowHandle();
        System.out.println(u3);
    }

}
