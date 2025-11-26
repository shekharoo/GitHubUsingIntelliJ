package TestNGClasses;

import org.testng.annotations.*;

public class BaseClass {
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("This is before suite()");
    }
    @BeforeClass
    public void seleniumInitialization()
    {
        System.out.println("This is Before Class()");
    }
    @BeforeMethod
    public void initiateDBConenction()
    {
        System.out.println("This is before method()");
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
    @AfterMethod
    public void closeBrowser()
    {
        System.out.println("This is after method()");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("This is after test()");
    }
    @AfterSuite
    public void afterSuite()
    {
        System.out.println("This is after suite()");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("This is after class()");
    }

}
