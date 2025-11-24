package SeleniumFiles;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadMultiRowExcel {
    public static void readMultiRow(String sheetName)
    {
        FileInputStream fis=null;
        Workbook wb = null;
        try {
            fis = new FileInputStream("./\\src\\main\\resources\\MultiRow.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            wb = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       Sheet sheet= wb.getSheet(sheetName);
        int rowNo = sheet.getLastRowNum();
        for(int row=1;row<=rowNo;row++)
        {
           String brand=sheet.getRow(row).getCell(0).getStringCellValue();
            String mobile = sheet.getRow(row).getCell(1).getStringCellValue();
            System.out.println("Brand: "+brand+"<===>"+"Mobile: "+mobile);
        }
        System.out.println("File read successfully!!");
    }

    public static void main(String[] args) {
        ReadMultiRowExcel.readMultiRow("Sheet1");
    }
}
