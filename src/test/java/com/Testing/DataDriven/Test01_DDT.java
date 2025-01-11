package com.Testing.DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test01_DDT {
    @DataProvider
    public Object[][] getdata(){
        return new Object[][]
                {
                        new Object[]{"admin@gmail.com","pass"},
                        new Object[]{"admin1@gmail.com","pass1"},
                };
    }
    //Dataprovider will inject data to testcase
    @Test(dataProvider = "getdata")
    public void logintest(String username, String password)
    {
        System.out.println(username + password);
    }
}
