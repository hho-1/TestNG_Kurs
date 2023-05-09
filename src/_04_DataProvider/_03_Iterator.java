package _04_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_Iterator {

    @Test(dataProvider = "getData")  //senin dataProviderin getDatadir
    public void usernameTest(String username){
        System.out.println(username);
    }

    @DataProvider
    public Iterator<Object> getData(){      // Kirmizi olmasini önemseme, gayet güzel calisiyor

        List<Object> data = new ArrayList<>();

        data.add("sacit");
        data.add("feyzi");
        data.add("sitki");
        data.add("rifki");
        data.add("taci");


        return data.iterator();

    }

    //****************************************** 2 Boyutlu *******************************

    @Test(dataProvider = "getData2")  //Bu asagidaki sekilde calisti iterator
    public void usernameTest2(String username, String password){
        System.out.println(username+"    "+ password);
    }

    @DataProvider
    public Iterator<Object[]> getData2(){

        List<Object[]> data = new ArrayList<>();

        data.add( new Object[]{"seyfettin", "fgdh"});
        data.add( new Object[]{"serafettin", "skfl"});
        data.add( new Object[]{"nizamettin", "ritj"});
        data.add( new Object[]{"rüknettin", "pslf"});
        data.add( new Object[]{"neetiin", "wbmn"});


        return data.listIterator();
    }
}
