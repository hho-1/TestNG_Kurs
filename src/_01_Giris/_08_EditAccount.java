package _01_Giris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MetodDriver;

import java.time.Duration;

public class _08_EditAccount extends MetodDriver {

    /*
    1- Siteyi ac
    2- Edit Accountu ac
    3- Yeni isim ve soy isim gondererek degistigini assertle kontrol et
    4- Bu islemi 2 kez calistirip eski halöine getiriniz
     */

    @Test
    void editAccount() throws InterruptedException {

        editAccount("Sucettin", "Donsuz");

        String expectedText = "Success: Your account has been successfully updated.";

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualText = bekle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success"))).getText();

        Assert.assertEquals(actualText, expectedText);


        editAccount("Muhittin", "Topalak");

        //String expectedText = "Success: Your account has been successfully updated.";

        WebDriverWait bekle2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualText2 = bekle2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success"))).getText();

        Assert.assertEquals(actualText2, expectedText);



    }

    public void editAccount(String firstname, String lastname){
        WebElement editAccount = driver.findElement(By.linkText("Edit Account"));
        editAccount.click();

        WebElement id = driver.findElement(By.id("input-firstname"));
        id.clear();
        id.sendKeys(firstname);

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys(lastname);

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();
    }


}
