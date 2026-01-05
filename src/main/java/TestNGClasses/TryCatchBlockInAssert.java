package TestNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TryCatchBlockInAssert {

    public static boolean testResult()
    {
        boolean flag=true;
        int a =5;
        int b=10;
        if(a>b) {
            return true;
        }
            else
                return false;
    }

    @Test
    public static void tryCatchAssertDemo()
    {
        try {
//            int a =5;
//            int b=0;
//            Assert.assertTrue(b>a);
//            int c = a/b;
            Assert.assertTrue(testResult());

        }catch (AssertionError e)
        {
            System.out.println("Error occurred..");
            Assert.fail("Failing this test..");
        }
    }
}
