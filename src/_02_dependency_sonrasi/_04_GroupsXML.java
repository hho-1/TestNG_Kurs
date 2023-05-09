package _02_dependency_sonrasi;

import org.testng.annotations.Test;

public class _04_GroupsXML {

    @Test (groups = "Regression")          //Regression sistemin tumunu kontrol eden teste verilen isim
    public void test1(){
        System.out.println("Test-1 Regression");
    }
    @Test (groups = "Regression")
    public void test7(){
        System.out.println("Test-7 Regression");
    }
    @Test (groups = "Regression")
    public void test4(){
        System.out.println("Test-4 Regression");
    }
    @Test (groups = "SmokeTest")                //SmokeTest sistemin en genel haliyle calisabilirliginin testi
    public void test5(){
        System.out.println("Test-5 SmokeTest");
    }
    @Test (groups = "SmokeTest")
    public void test2(){
        System.out.println("Test-2 SmokeTest");
    }
    @Test (groups = "Regression")
    public void test6(){
        System.out.println("Test-6 Regression");
    }
    @Test
    public void test3(){System.out.println("Test-3");}       //Gruplar dahil seklinde calistirildiginda herhangi bir grubu olmayanlar calismaz. Bu satir calismaz yani.
}
