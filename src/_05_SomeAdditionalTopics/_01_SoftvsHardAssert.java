package _05_SomeAdditionalTopics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftvsHardAssert {

    @Test
    void hardAssert(){
        String s1 = "Merhaba";

        System.out.println("Hard assert öncesi");
        Assert.assertEquals("Merhaba 123", s1, "Hard Assert Sonucu");
        System.out.println("Hard assert öncesi");           //Bu kisma gelmeden programdan cikilir, bu kisim calismaz yani
    }

    @Test
    void softAssert(){
        String strHomePage = "www.facebook/homepage";
        String strCartPage = "www.facebook/cartpage";
        String strEditAccount = "www.facebook/editaccountpage";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("www.facebook/homepage", strHomePage);   //true
        System.out.println("Assert-1");

        softAssert.assertEquals("www.facebook.com/profile", strCartPage);  //false olmasina ragmen isleme devam eder.
        System.out.println("Assert-2");

        softAssert.assertEquals("www.facebook.com/settings", strEditAccount);  //false olmasina ragmen devam eder
        System.out.println("Assert-3");


        softAssert.assertAll();
        System.out.println("Bakalim bunu da yazacak mi");    // Bunu yazmaz. assertAll artik genel manada fail var mi diye arastirir. Tek bir hata varsa bile fail verir.
    }
}
