package _05_SomeAdditionalTopics;

/*
Senaryo:
1- Siteyi ac
2- ipod kelimesini arat
3- Cikan sonuclardan ilkini sepete at
4- Shopping Carta tikla
5- Checkout yap
6- Continue yapip cikan bilgileri gir
7- Confirm ile siparisi verdigini dogrula
Dogrulamayi cikan sayfadaki "Your order has been placed" yazisiyla yap
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MetodDriver;

import java.time.Duration;
import java.util.List;


public class _02_PlaceOrder extends MetodDriver {

    /*
    Altta bu sorunun cevabi olmasina ragmen 2 cesit problem goze carpmakta:
    1- Ayni elemani defalarca kez bulmak zorunda kaliyoruz. Bunlarin locatorlarini baska bir sayfada bulsak zamani gelince kullansak mukemmel olur
    2- Uzun oldugu icin kodun anlasilmasi nispeten zor

    Bu sorunlari asmak icin de 2 sayfa olusturacagiz:
    1- Webelementlerin tutuldugu sayfa
    2- Kodumuzun calistigi sayfa
     */

    @Test
    public void placeOrder(){
        WebElement search = driver.findElement(By.cssSelector("input.form-control.input-lg"));
        search.sendKeys("ipod");

        WebElement searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
        searchButton.click();

        WebElement ipod1cartButton = driver.findElement(By.cssSelector("button[type='button'][onclick*='cart']"));
        ipod1cartButton.click();

        WebElement cartButton = driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']"));
        cartButton.click();

        WebElement checkout = driver.findElement(By.cssSelector("i.fa.fa-share"));
        checkout.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-address"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='checkbox']"))).click();

        WebElement continueButton4 = driver.findElement(By.id("button-payment-method"));
        continueButton4.click();

        WebElement confirmOrder = driver.findElement(By.cssSelector(".pull-right > #button-confirm"));
        confirmOrder.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue")));

        String actualText = driver.findElement(By.cssSelector(".row>div#content.col-sm-12>h1")).getText();


        String expectedTest = "Your order has been placed!";

        Assert.assertEquals(actualText, expectedTest);

    }
}
