package TestNGClasses;

import org.testng.annotations.*;

public class BaseClass {

    //To generate maven sure fire report
    //mvn surefire-report:report
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("This is before suite() for DB Connection");
    }
    @BeforeClass
    public void seleniumInitialization()
    {
        System.out.println("This is Before Class() initialize Global variables");
    }
    @BeforeMethod
    public void initiateDBConenction()
    {
        System.out.println("This is before method() fetch from DDD for data");
    }
    @BeforeTest
    public void beforePrintMsg()
    {
        System.out.println("This is before test()");
    }

    @Test
    public static void printMsg()
    {
        System.out.println("This is Test()");
    }
    @Test
    public static void printMsg1()
    {
        System.out.println("This is Test1()");
    }
    @AfterMethod
    public void closeBrowser()
    {
        System.out.println("This is after method() close DDD data connection");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("This is after test()");
    }
    @AfterSuite
    public void afterSuite()
    {
        System.out.println("This is after suite() close DB connection");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("This is after class()");
    }

}
