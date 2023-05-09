package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Tools {
    public static void compareToList (List<WebElement> actualList, List<String> menuExpectedList){
        int i = 0;
        for(WebElement el : actualList){
            //if(!Objects.equals(el.getText(), menuExpectedList.get(i++))) {
            //    System.out.println("Menü bulunamadi.");
            //}       Bu sekilde de olur.

            Assert.assertEquals(el.getText(), menuExpectedList.get(i++));
        }
    }

    public static int randomGenerator(int max){
        Random rnd = new Random();
        int randomNumber =  rnd.nextInt(max - 1)+1;
        return randomNumber;
    }

    public static void chooseRandomFromDropdown(WebElement dropdown){
        Select s1 = new Select(dropdown);

        //s1.selectByIndex(RandomGenerator(s1.getOptions().size()));         Bu kod hocada bu sekilde ama bende calismiyor nedense
    }

    public static void selectByIndex(WebElement dropDownName){
        Select select = new Select(dropDownName);

        select.selectByIndex(randomGenerator(select.getOptions().size()));
    }

    public static void successMessageValidation(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String expectedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success"))).getText();

        Boolean actualText = expectedText.contains("uccess"); //"Success: Your newsletter subscription has been successfully updated!";

        Assert.assertTrue(actualText, expectedText);
        //Assert.assertTrue(actualText.getText().contains("Success ");  seklinde de test edebilirsin
    }

    public static double webelementToDouble(WebElement e){
        String result = e.getText();
        //result = result.replaceAll("[^\\d]", .............)   buraya gelecek kismi hocadan göremedigim icin yazamadim
        return Double.parseDouble(result);
    }
}
