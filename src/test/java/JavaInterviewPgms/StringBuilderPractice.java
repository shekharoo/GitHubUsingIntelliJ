package JavaInterviewPgms;

import com.mysql.jdbc.Driver;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class StringBuilderPractice {
    public static void reverseSentStringBuilder(String s)
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(driver));
        //Wait<WebDriver> wait1 = new FluentWait<>(driver);
        FluentWait<WebDriver> wait1 = new FluentWait<>(driver);
        wait1.withTimeout(Duration.ofSeconds(10));
        wait1.pollingEvery(Duration.ofSeconds(1));
        wait1.ignoring(NoSuchElementException.class);
        wait1.until(driver1 -> driver.findElement(By.xpath("abc")));
        String[] sSplit = s.split(" ");
        //StringBuilder sb=new StringBuilder();
        String rev="";
        for(int i=0;i<sSplit.length;i++)
        {
            StringBuilder sb = new StringBuilder(sSplit[i]);
            rev=rev+sb.reverse()+" ";
        }
        //rev=rev+" ";
        System.out.println("Rev sentence is: "+rev);
    }
    public static void main(String[] args) throws IOException, SQLException {

        //String s="My name is Shekhar Anand";
        //String s1="Java is good programming languages";
        //StringBuilderPractice.reverseSentStringBuilder(s1);
//        StringBuilder sb = new StringBuilder(s);
//        System.out.println(sb);
//        String s1 = sb.reverse().toString();
//        System.out.println(s1);
//        StringBuilder sb1 = new StringBuilder("Domuhan");
//        String s2=sb1+s1;
//        System.out.println("String builder and string combi: "+s2);
//        String[] sSplit = s1.split(" ");
//        System.out.println("Split size: "+sSplit.length);
//        //System.out.println(sSplit[4]);
//        String rev="";
//        for(int i=0;i<sSplit.length;i++)
//        {
//            for(int j=sSplit[i].length()-1;j>=0;j--)
//            {
//                rev=rev+sSplit[i].charAt(j);
//            }
//            rev=rev+" ";
//
//        }
//        System.out.println("Rev sentence is: "+rev);

//        FileInputStream fis = new FileInputStream("./\\src\\main\\resources\\MultiRow.xlsx");
//        Workbook wb = WorkbookFactory.create(fis);
//        Sheet sh = wb.getSheet("Sheet1");
//        String value = sh.getRow(1).getCell(0).getStringCellValue();
//        System.out.println("Value is: "+value);
//        wb.close();
//        fis.close();
//        Driver driver = new Driver();
//        DriverManager.registerDriver(driver);
//        Connection con = DriverManager.getConnection();
        //Class.
        //Assert.tr
    }

}
