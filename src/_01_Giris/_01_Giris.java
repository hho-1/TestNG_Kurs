package _01_Giris;

import org.testng.annotations.Test;

public class _01_Giris {

    //Eger testlere oncelik verilmezse testler harflerin alfabetik sirasina gore calisir. priority eklersek degisir.

    @Test (priority =  1)
    void webSitesiAc(){
        System.out.println("Driver tanimlandi, web sitesi acildi.");
    }

    @Test(priority =  2)
    void loginTest(){
        System.out.println("Login test islemleri yapildi");
    }

    @Test(priority =  3)
    void driverKapat(){
        System.out.println("Driver kapatildi ve cikildi.");
    }
}
