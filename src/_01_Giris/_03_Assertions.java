package _01_Giris;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void equalsOrnek(){

        String s1 = "mehmet";
        String s2 = "ahmet";

        Assert.assertEquals(s1, s2, "Karsilastirma Sonucumuz: ");    //Sondaki sey baslik gibi cikiyor sonuclarda
    }

    @Test
    void trueOrnek(){
        int sayi1 = 5;
        int sayi2 = 7;

        Assert.assertTrue(sayi1 == sayi2);
    }

    @Test
    void nullOrnek(){
        String s = "";   //Dikkat: Bunun sonucu null gelmez. String s= null demen lazim. Eger bu classin disinda String s; desen burada sonucu null gelirdi.

        Assert.assertNull(s);
    }

    @Test
    void directFail(){
        Assert.fail();          //Bu if'li olarak falan kullanilabilir. Burada basitce yazdik
    }
}
