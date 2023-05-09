package _01_Giris;

import org.testng.annotations.*;

public class _02_Annotations {
    /*

    @BeforeClass           ----> Her classtan önce calisacak olanlar buraya yaziliyor.
        @BeforeMethod      ----> Her metod calismadan önce calisacaklar buraya yaziliyor.
            @Test
            @Test          ----> Bunlar testlerimiz.
            @Test
        @AfterMethod       ----> Her metod calistiktan sonra calisacaklar buraya yaziliyor.
    @AfterMethod           ----> Her class calistiktan sonra calisacaklar buraya yaziliyor.
     */

    @BeforeClass
    void beforeClass(){
        System.out.println("Classtan önce bu");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("Her metoddan önce calisacak");
    }
    @AfterClass
    void afterClass(){
        System.out.println("Her classtan sonra");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("Her metoddan sonra calisacak");
    }

    @Test
    void test1(){
        System.out.println("Burasi test1");
    }

    @Test
    void test2(){
        System.out.println("Burasi test2");
    }

    @Test
    void test3(){
        System.out.println("Burasi test3");
    }
}
