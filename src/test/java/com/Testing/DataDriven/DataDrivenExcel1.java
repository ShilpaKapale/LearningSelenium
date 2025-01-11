package com.Testing.DataDriven;

import org.testng.annotations.Test;

public class DataDrivenExcel1 {
    @Test(dataProvider = "getData",dataProviderClass = UtilExcel1.class)
    public void testlogin(String email,String password){
        System.out.println("email"+ email);
        System.out.println("password"+password);

    }
}