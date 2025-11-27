package genericUtilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtility {
        public static String toReadDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
            FileInputStream fis = new FileInputStream("./src\\main\\resources\\NinzaTestData.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
            //String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
            wb.close();
            return data;
        }
    public static void toWriteDataToExcel(String sheetName, String value,int rowNum, int cellNum) throws Throwable {
        FileInputStream fis = new FileInputStream("./src\\main\\resources\\NinzaTestData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
        wb.close();
    }

        public int togetRowCount(String sheetName) throws Throwable {
            FileInputStream fis = new
                    FileInputStream("./src\\main\\resources\\NinzaTestData.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            int rowCount = wb.getSheet(sheetName).getLastRowNum();
            wb.close();
            return rowCount;
        }

    public static void main(String[] args) throws Throwable {
        String teamSize  = ExcelUtility.toReadDataFromExcel("Campaigns",1,1);
        System.out.println(teamSize);
        ExcelUtility.toWriteDataToExcel("Campaigns","ABC",1,0);
    }
    }
