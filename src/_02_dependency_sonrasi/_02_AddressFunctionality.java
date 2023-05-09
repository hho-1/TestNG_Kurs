package _02_dependency_sonrasi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.MetodDriver;
import utils.Tools;

import java.time.Duration;
import java.util.List;

public class _02_AddressFunctionality extends MetodDriver {
    /*
    Senaryo:
    1- Siteyi ac
    2- Adres ekle
    3- edit address yap - ad soyadi degistir
    4- delete address yap

     */
    @Test
    void addAddress() throws InterruptedException {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAddress = driver.findElement(By.linkText("New Address"));
        newAddress.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Sucettin");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Sucu");

        WebElement company = driver.findElement(By.id("input-company"));
        company.sendKeys("Techno Study");

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("Simone Bolivar Boulivard 25");

        WebElement address2 = driver.findElement(By.id("input-address-2"));
        address2.sendKeys("Reading");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("London");

        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("24352");

        WebElement country = driver.findElement(By.id("input-country"));
        Tools.selectByIndex(country);                 //Ulkeyi rastgele sectirdik, Tools'daki fonksiyonlardan

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(10));
        bekle.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='input-zone']/option"),1));  //option sayisi 1'den fazla olana kadar bekle

        Thread.sleep(2000);      //Bunu mecburen ekledik. Cunku her sey dogru olmasina ragmen kod alttaki sehirler kismini gormuyordu

        WebElement zone = driver.findElement(By.id("input-zone"));
        Tools.selectByIndex(zone);        //yine rastgele bir bolge sec dedik

        //WebElement defaultAddress = driver.findElement(By.cssSelector("input[value='1']"));
        //defaultAddress.click();                                                                   Bunu iptal ettim, cunku default adresini sildirmiyor.

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);

    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress() throws InterruptedException {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editButtons = driver.findElements(By.xpath("//a[text()='Edit']"));
        editButtons.get(editButtons.size()-1).click();    //Son ekledigimi degistirmek istiyorum manasinda bu. Bircok adres varken gecerli

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Seyfullah");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys("Taci");

        WebElement country = driver.findElement(By.id("input-country"));
        Tools.selectByIndex(country);                 //Ulkeyi rastgele sectirdik, Tools'daki fonksiyonlardan

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(10));
        bekle.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='input-zone']/option"),1));  //option sayisi 1'den fazla olana kadar bekle

        Thread.sleep(2000);      //Bunu mecburen ekledik. Cunku her sey dogru olmasina ragmen kod alttaki sehirler kismini gormuyordu

        WebElement zone = driver.findElement(By.id("input-zone"));
        Tools.selectByIndex(zone);        //yine rastgele bir bolge sec dedik

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

    @Test (dependsOnMethods = {"editAddress"})    //2 tane bagimliligi oldugu icin bu test tek basina calismaz
    void deleteAddress(){

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[text()='Delete']"));
        deleteButtons.get(deleteButtons.size()-1).click();

        Tools.successMessageValidation(driver);

    }
}
