package _04_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

public class _02_TwoDimensionalArrays {

    @Test(dataProvider = "UsersDataProvider")
    public void usernameTest2 (String username, String password){
        System.out.println(username + "   " + password);
    }

    @DataProvider(name="UsersDataProvider")
    public Object[][] getData2 (){      //

        Object[][] data = {
                {"ali", "abc"},
                {"veli", "xyz"},
                {"giyaseddin", "bcd"},
                {"pelinsu", "dfg"}
        };
        return data;
    }
}
