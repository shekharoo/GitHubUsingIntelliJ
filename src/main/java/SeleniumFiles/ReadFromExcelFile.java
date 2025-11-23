package SeleniumFiles;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ReadFromExcelFile {
    public static void readfromExcel(String sheetName) throws IOException {
        Workbook wbf = WorkbookFactory.create(new File("C:\\Users\\Shekhar\\IdeaProjects\\SeleniumDemo\\src\\main\\resources\\NinzaData.xlsx"));
        Sheet sheet = wbf.getSheet(sheetName);
//        Row row = sheet.getRow(1);
//        Cell cell = row.getCell(3);
//        String data = cell.getStringCellValue();
//        System.out.println("Data is: "+data);
        int rowNo = sheet.getLastRowNum();
        System.out.println("Row no is: "+rowNo);
        Row row = sheet.getRow(rowNo);
        Cell cell = row.getCell(rowNo);
        for(int i=0;i<rowNo;i++)
        {
            System.out.print(cell.getStringCellValue()+" ");
        }
        wbf.close();


    }

    public static void main(String[] args) throws IOException {
        ReadFromExcelFile.readfromExcel("Sheet1");
    }
}
