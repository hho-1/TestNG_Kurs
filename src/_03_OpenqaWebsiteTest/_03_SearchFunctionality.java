package _03_OpenqaWebsiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.MetodDriver;

import java.util.List;

public class _03_SearchFunctionality extends MetodDriver {

    @Test
    @Parameters("arananKelime")
    public void searchFunction(String yazi){

        //String yazi = "canon";      Ilk olarak bu sekilde yapmistik. Sonra xml dosyasindaki parametrenin icine yazdik.
                                      //Dikkat!!!    xml dosyasina yazdiktan sonra dosyayi burdan calistirirsan hata verir, cunku yazi artik burada degil

        WebElement search = driver.findElement(By.cssSelector("input.form-control.input-lg"));
        search.sendKeys(yazi);

        WebElement searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
        searchButton.click();

        List<WebElement> searchResults = driver.findElements(By.cssSelector(".product-layout"));

        for (WebElement searchResult : searchResults) {
            boolean isTrue;
            isTrue = searchResult.getText().toLowerCase().contains(yazi);
        }

    }
}
