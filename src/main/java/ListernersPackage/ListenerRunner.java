package ListernersPackage;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListernersPackage.TestNGListeners.class)//package name
public class ListenerRunner{
    //@Test(retryAnalyzer = ListernersPackage.IRetryAnalyzerClass.class)
    public void sampleMethod()
    {
        System.out.println("Test started and passed");
        Assert.assertEquals(true,false);
    }
//    @Test
//    public void sampleMethod1()
//    {
//        System.out.println("Test started but failed");
//        Assert.assertTrue(false);
//    }
//    @Test
//    public void sampleMethod2()
//    {
//        System.out.println("Test started");
//        throw new SkipException("This test will be skipped");
//    }
//    @Test
//    public void sampleMethod3()
//    {
//        System.out.println("Test will be printed on test finish..");
//    }
}
