package _03_OpenqaWebsiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MetodDriver;
import utils.Tools;

import java.util.List;

public class _02_Specials extends MetodDriver {

    @Test
    public void specials(){

        WebElement specials = driver.findElement(By.linkText("Specials"));
        specials.click();

        List<WebElement> numberOfProducts = driver.findElements(By.cssSelector("div.product-thumb"));
        int sayi1 = numberOfProducts.size();

        List<WebElement> oldPrices = driver.findElements(By.cssSelector("span.price-old"));
        int sayi2 = oldPrices.size();

        if(sayi1 == sayi2) System.out.println("Specials altinda yer alan tum urunlerde indirim bulunuyor.");
        else System.out.println("Indirimde olmayan urunler var.");

        List<WebElement> newPriceList = driver.findElements(By.cssSelector("span[class='price-new']"));

        for(int i = 0; i < newPriceList.size(); i++){
            Assert.assertTrue(Tools.webelementToDouble(newPriceList.get(i)) < Tools.webelementToDouble(oldPrices.get(i)));
        }
    }
}
