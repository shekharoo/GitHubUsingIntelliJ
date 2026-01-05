package TestNGClasses;

import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNGTCDemo extends BaseClass{

//    @DataProvider{name="DD1"}
//    {
//
//    }
//    @BeforeSuite
//    //@Override
//    public void beforeSuite() {
//        //super.beforeSuite();
//        System.out.println("This is Before Suite in sub class");
//    }
    @Test
    public void testSubClass()
    {
        Reporter.log("This is sub class of Base class",true);

        //System.out.println("This is sub class of Base class");
    }
}
