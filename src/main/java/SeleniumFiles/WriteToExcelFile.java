package SeleniumFiles;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToExcelFile {

    public static void writeToExcel(String sheetName) throws IOException {
        Workbook wb = WorkbookFactory.create(new FileInputStream("C:\\Users\\Shekhar\\IdeaProjects\\SeleniumDemo\\src\\main\\resources\\Ninza.xlsx"));
        Sheet sh = wb.createSheet(sheetName);
        Row r = sh.createRow(5);
        Cell c = r.createCell(5);
        Cell c1 = r.createCell(6);
        c1.setCellValue("Product Name");
        c.setCellValue("Price");
//
        wb.write(new FileOutputStream("C:\\Users\\Shekhar\\IdeaProjects\\SeleniumDemo\\src\\main\\resources\\NinzaTestData.xlsx"));
//
//        System.out.println("Successfully wrote int he file..");
        System.out.println("Successfully written to Excel file!!");
        wb.close();

    }

    public static void main(String[] args) throws IOException {
        WriteToExcelFile.writeToExcel("NinzaAutomation");
    }

}
