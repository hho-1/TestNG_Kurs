package _01_Giris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MetodDriver;
import utils.Tools;

import java.time.Duration;

public class _07_SubscribeOrnek extends MetodDriver {
    /*
    Senaryo:
    1- siteyi ac
    2- Newsletter kismina gel
    3- subscribe ve unsubscribe islemlerini ayri ayri testlerde yap
    4- subscribe degilsek subscribe olalim, subscribe isek unsubscribe olalim
     */


    /*
    Bu bolgede degisken tanimlayabilirsin ama kod calistiramazsin. Onun icin her yerde geciyor diye WebElementleri buraya alamazsin
     */

    By link = By.xpath("//a[@href='https://opencart.abstracta.us:443/index.php?route=account/newsletter']");
    By yes = By.xpath("//input[@value='1']");
    By no = By.xpath("//input[@value='0']");
    By continueClick = By.xpath("//input[@value='Continue']");


    @Test (priority = 1) //(enabled=false) yazarsan testin yanina bu test calismaz.
    void subscribeFunctionYes(){
        WebElement newsletter = driver.findElement(link);
        newsletter.click();

        WebElement yesButton = driver.findElement(yes);
        yesButton.click();

        WebElement continueButton = driver.findElement(continueClick);
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

    @Test (priority = 2)
    void subscribeFunctionNo(){
        WebElement newsletter = driver.findElement(link);
        newsletter.click();

        WebElement noButton = driver.findElement(no);
        noButton.click();

        WebElement continueButton = driver.findElement(continueClick);
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

    @Test (priority = 3)
    void subscribeFunctionForBoth(){

        WebElement newsletter = driver.findElement(link);
        newsletter.click();

        WebElement yesButton = driver.findElement(yes);
        if(yesButton.isSelected()){
            WebElement noButton = driver.findElement(no);
            noButton.click();
        }
        else {
            WebElement isSelected = driver.findElement(yes);
            isSelected.click();
        }

        WebElement continueButton = driver.findElement(continueClick);
        continueButton.click();

        Tools.successMessageValidation(driver);

    }

}
