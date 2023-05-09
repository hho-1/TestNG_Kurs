package _02_dependency_sonrasi;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar(){
        System.out.println("Car is started.");
        Assert.fail();       //Bilincli olarak bir hata olusturduk
    }

    @Test (dependsOnMethods = {"driveCar"})       //Bunu driveCar'dan sonra calistir demek. Bunlari koymazsak alfabetik calisir.
    void stopCar(){                                 //Burada zincirde herhangi biri calismazsa kendine bagli olan sonrakiler de calismaz.
        System.out.println("Car is stopped.");    //bunun iki tane bagimliligi oldugu icin tek basina calistirirsan calismaz. onceki hata verse de vermese de calismaz.
    }

    @Test (dependsOnMethods = {"startCar"})     //Bunu startCar'dan sonra calistir demek
    void driveCar(){                            //Eger tek olarak bu metodu calistirirsam kendinden bir onceki metodu da cagirip onu da calistirir. Onda hata varsa yaten hata verir, yoksa ikisi beraber calisir.
        System.out.println("Car is driven.");
    }

    @Test (dependsOnMethods = {"stopCar", "driveCar"}, alwaysRun = true)     //Bunu stopCar'dan ve driveCar'dan sonra calistir demek
    void parkCar(){                                                             //alwaysRun = true dedigimiz icin her durumda calistir manasina geldi
        System.out.println("Car is parked.");
    }


}
