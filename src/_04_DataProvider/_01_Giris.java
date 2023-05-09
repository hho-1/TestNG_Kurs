package _04_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

public class _01_Giris {

    /*
    DataProvider bir testi birden fazla data icin calistirmak amacli kullanilir
    xml ise gruplama, paralel test ve farkli testleri koordine edip bir arada calistirmak icin kullanilir

    Asagidaki dataProviderin icindeki usernameler tekere teker teste gonderilecek ve test hepsi icin calistirilacak
     */


    @Test(dataProvider = "getData")  //senin dataProviderin getDatadir
    public void usernameTest(String username){
        System.out.println(username);
    }

    @DataProvider                      //DataProvider Object olmak zorundaymis hocanin dedigine gore
    public Object[] getData(){                                 //Burada kirmiziya dönüsmesi hata manasina gelmiyor, dikkat et. Bu sekilde calisiyor.
        Object [] data = {"ali", "veli", "ahmet", "mehmet"};

        return data;
    }

    //*********************************************************************************************

    @Test(dataProvider = "UsersDataProvider")  //Bu sekilde de yapilabiliyor. DataProvidera asagida isim verip o ismi buraya yazdik
    public void usernameTest2 (String username){
        System.out.println(username);
    }

    @DataProvider(name="UsersDataProvider")
    public Object[] getData2 (){      //Kirmizi olmasi problem degil. Sadece renklendirme o sekilde yapilmis

        Object[] data = {
                "ali",
                "veli",
                "giyaseddin",
                "pelinsu"
        };
        return data;
    }


}
