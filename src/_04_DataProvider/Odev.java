package _04_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ParameterDriver;

import java.util.List;

public class Odev extends ParameterDriver {
    @Test(dataProvider = "getData")
    public void usernameFunction(String searchItem){
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

        Object[] data = {           //Bu sekilde parametreli web driverla calistirinca browseri sadece 1 kez acip sirayla her urunu girip test ediyor.
                "mac",
                "samsung",
                "canon",
                "iphone"
        };
        return data;               //Gayet güzel calisiyor. Object'in kirmizi olmasina bakma.
    }

}
