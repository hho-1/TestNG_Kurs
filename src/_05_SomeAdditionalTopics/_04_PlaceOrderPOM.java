package _05_SomeAdditionalTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MetodDriver;

import java.time.Duration;

public class _04_PlaceOrderPOM extends MetodDriver {
    @Test
    public void proceedToCheckout(){

        _03_PlaceOrderElements elements = new _03_PlaceOrderElements(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        elements.searchBox.sendKeys("ipod");
        elements.searchButton.click();
        elements.addToCart.click();
        elements.shoppingCart.click();
        elements.checkout.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.agree)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        elements.confirm.click();
        wait.until(ExpectedConditions.urlContains("success"));

        String actualText = driver.findElement(By.cssSelector(".row>div#content.col-sm-12>h1")).getText();
        String expectedTest = "Your order has been placed!";

        Assert.assertEquals(actualText, expectedTest);

    }
}
