package TestNGClasses;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTCDemo{

//    @DataProvider{name="DD1"}
//    {
//
//    }
    @BeforeSuite
    //@Override
    public void beforeSuite() {
        //super.beforeSuite();
        System.out.println("This is Before Suite in sub class");
    }
    @Test
    public void testSubClass()
    {
        System.out.println("This is sub class of Base class");
    }
}
