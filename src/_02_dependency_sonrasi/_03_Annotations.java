package _02_dependency_sonrasi;

import org.testng.annotations.*;

public class _03_Annotations {

    /*
    Simdiye kadar beforeTest afterTest gibi annotationslari gormustuk. Bir de sunlar var.

    @BeforeSuite
        @BeforeTest
            @BeforeGroups
                @BeforeClass
                    @BeforeMethod
                        @Test
                        @Test
                        @test
                    @AfterMethod
                @AfterClass
            @AfterGroups
        @AfterTest
    @AfterSuite

     */
    @BeforeSuite
    public void bSuite(){
        System.out.println("Before Suite");          ////Bunlari sirali yazdik ama siranin aslinda bi onemi yok.
    }

    @BeforeTest
    public void bTest(){
        System.out.println("Before Test");
    }

    @BeforeGroups
    public void bGroups(){
        System.out.println("Before Groups");
    }

    @BeforeClass
    public void bClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void bMethod(){
        System.out.println("Before Method");     //Bu her metoddan once calisir
    }

    @Test
    public void testIntro1(){
        System.out.println("Test 1");
    }
    @Test
    public void testIntro2(){
        System.out.println("Test 2");
    }
    @AfterMethod
    public void aMethod(){
        System.out.println("After Method");        //Bu her metoddan sonra calisir
    }

    @AfterClass
    public void aClass(){
        System.out.println("After Class");
    }

    @AfterGroups
    public void aGroups(){
        System.out.println("After Groups");
    }

    @AfterTest
    public void aTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    public void aSuite(){
        System.out.println("After Suite");
    }


}
