package _05_SomeAdditionalTopics;

/*
Soru:

1- Siteyi ac.
2- ipod ürüünü arat. ipod'u xml'den gönder
3- Cikan elemanlardan random bir tanesini wishliste ekle
4- Wishliste tikla
5- Burada cikan ürünle tiklanan ürünün isimlerinin ayni olup olmadigini kontrol et
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ParameterDriver;
import utils.Tools;

import java.util.List;

public class _05_WishList extends ParameterDriver {

    @Test
    @Parameters("searchedProduct")
    public void wishList(String searchItem){

        _05_WishListPOM items = new _05_WishListPOM(driver);

        items.searchBox.sendKeys(searchItem);
        items.searchButton.click();

        List<WebElement> addToWishListButton = driver.findElements(By.cssSelector("button[data-original-title='Add to Wish List']"));
        addToWishListButton.get(Tools.randomGenerator(addToWishListButton.size())).click();

        //items.addToWishListButtons.get(Tools.randomGenerator(addToWishListButtons.size())).click();

        WebElement successMessage = driver.findElement(By.cssSelector(".fa.fa-check-circle"));
        String successMessageText = successMessage.getText();
        System.out.println(successMessageText);

        items.wishList.click();

        WebElement actualProductName = driver.findElement(By.cssSelector(".text-left>a[href^='http://opencart.abstracta.us:80/index.php?route=product/product']"));
        String actProdName = actualProductName.getText();

        Assert.assertTrue(successMessageText.contains(actProdName));

    }
}
