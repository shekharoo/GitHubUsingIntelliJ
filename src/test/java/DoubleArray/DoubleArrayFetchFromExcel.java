package DoubleArray;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DoubleArrayFetchFromExcel {
    @Test
    public static Object[][] loginDetails() throws IOException {
        FileInputStream fis = new FileInputStream("./src\\main\\resources\\NinzaTestData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Login");
        int row = sh.getLastRowNum();
        int cell =sh.getRow(row).getLastCellNum();
        Object[][] data=new Object[row][cell];
        for(int i=0;i<row;i++)
        {
            //sh.getRow(i).get
            for(int j=0;j<cell;j++)
            {
                data[i][j]= sh.getRow(i+1).getCell(j).getStringCellValue();
//            data[i][0]= sh.getRow(i).getCell(j).getStringCellValue();
//            data[i][1]= sh.getRow(i).getCell(j).getStringCellValue();
//            data[i][2]= sh.getRow(i).getCell(j).getStringCellValue();
            }

            //cell=sh.getRow(i).getCell(i+1);
        }

        System.out.println("Data is: "+data.toString());
        for(int i=0;i<data.length;i++)
        {
            for(int j=0;j<data[i].length;j++)
            {
                System.out.println(data[i][j]);
            }
        }
        return data;
    }
    @Test
    public void getName() throws IOException {
        Reporter.log("Name is Shekhar Anand",true);
        loginDetails();
    }

}
