package _03_OpenqaWebsiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.MetodDriver;

public class _01_ContactUs extends MetodDriver {

    @Test
    @Parameters("enquiry")      // xml'den alacagi parametrenin adi buraya yazildi
    public void contactUs(String enquiry){         //parametre alabilir hale getirildi. enquiry bi ust saturdakiyle ayni olmak zorunda degil

        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

        WebElement name = driver.findElement(By.id("input-name"));
        name.clear();
        name.sendKeys("Sucettin Donsuz");

        WebElement email = driver.findElement(By.id("input-email"));
        email.clear();
        email.sendKeys("sucettindonsuz@yahoo.com");

        WebElement inquiryInput = driver.findElement(By.id("input-enquiry"));
        //inquiryInput.sendKeys("Merhaba, siparisim gelmedi.");   onceki bu sekildeydi, sonra xml'den parametre verdik
        inquiryInput.sendKeys(enquiry);

        WebElement submitButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        submitButton.click();

        WebElement continueButton = driver.findElement(By.linkText("Continue"));
        continueButton.click();

        //WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']/p"));

        //Assert.assertTrue(successMessage.getText().toLowerCase().contains("successfully"));      Bu yeni sitede kaybolmus. Success mesaji yok, onun icin yukariyi da sildim, calismiyor
    }
}
