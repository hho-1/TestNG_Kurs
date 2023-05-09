package _04_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.MetodDriver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Daha once yaptigimiz search fonksiyonunu dataProvider ile yap
 */

public class _04_Task1 extends MetodDriver {   //ParameterDriver xml ile calisiyordu. onun icin bunu metoddriverdan yapiyoruz

    @Test(dataProvider = "getData")
    public void searchFunction(String searchItem){

        WebElement search = driver.findElement(By.cssSelector("input.form-control.input-lg"));
        search.clear();
        search.sendKeys(searchItem);

        WebElement searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
        searchButton.click();

        List<WebElement> searchResults = driver.findElements(By.cssSelector(".product-layout"));

        for (WebElement searchResult : searchResults) {
            boolean isTrue;
            isTrue = searchResult.getText().toLowerCase().contains(searchItem);
        }

    }


    @DataProvider
    public Object[] getData(){

        Object[] data = {
                "mac",
                "samsung",
                "canon",
                "iphone"
        };
        return data;               //Gayet güzel calisiyor. Object'in kirmizi olmasina bakma.
    }

}
