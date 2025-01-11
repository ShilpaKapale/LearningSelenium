package com.Testing.DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test01_DDTparallel {
    //If we want to excute parallel then give it true
    @DataProvider(name = "Logindata",parallel = true)
    public Object[][] getdata(){
        return new Object[][]
                {
                        new Object[]{"admin@gmail.com","pass"},
                        new Object[]{"admin1@gmail.com","pass1"},
                };
    }
    @DataProvider(name = "Logindata1",parallel = true)
    public Object[][] getdata1(){
        return new Object[][]
                {
                        new Object[]{"admin@gmail.com","pass"},
                        new Object[]{"admin1@gmail.com","pass1"},
                };
    }
    //Dataprovider will inject data to testcase
    @Test(dataProvider = "Logindata")
    public void logintest(String username, String password)
    {
        System.out.println(username + password);
    }
    //if we have multiple function than how dataprovider will work mention as above for different function
    @Test(dataProvider = "Logindata1")
    public void logintest1(String username, String password)
    {
        System.out.println(username + password);
    }
}
