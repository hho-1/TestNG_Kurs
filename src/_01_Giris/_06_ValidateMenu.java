package _01_Giris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MetodDriver;
import utils.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _06_ValidateMenu extends MetodDriver {

    /*
    Senaryo:
    1- Siteye gir
    2- Menu icindeki basliklari check et
     */
    @Test
    void menuValidation(){

        List<String> menuExpectedList = new ArrayList<>();

        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");


        By menu = By.xpath("//ul[class='nav navbar-nav']/li");    //Buraya dikkat et. Cok yerde kullanabilmek icin bu sekilde tanimladik
        List<WebElement> actualList = driver.findElements(menu);

        Tools.compareToList(actualList, menuExpectedList);  //Once burda yaptigimiz seyi toolsa atip burdan yol verdik

    }
}
