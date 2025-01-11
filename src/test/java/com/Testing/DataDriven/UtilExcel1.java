package com.Testing.DataDriven;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel1 {


    // Apache POI
    // Read the File
    //  Workbook Create
    // Sheet
    // Row and Cell
    // 2D Object  - getData()

    //Get workbook from apache poi
    static Workbook book;
    static Sheet sheet;

    public static String Sheet_Path = System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";
    public static Object[][]gettestdatafromexcel(String sheetname) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(Sheet_Path);
        } catch (FileNotFoundException e) {//Checked exception as JVM knows about it
            throw new RuntimeException(e);
        }

        book = WorkbookFactory.create(file);
        sheet = book.getSheet(sheetname);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        //Object[][] data = new Object[5,2]
        for(int i=0;i<sheet.getLastRowNum();i++)
            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++)
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();

        return data;
    }
    //    public static Object[][]gettestdatafromsql(String sheename)
//    {
//        return null;
//    }
    @DataProvider
    public Object[][] getData() throws IOException{
        return gettestdatafromexcel("Sheet1");
        // return gettestdatafromsql("Sheet1");
    }

}
