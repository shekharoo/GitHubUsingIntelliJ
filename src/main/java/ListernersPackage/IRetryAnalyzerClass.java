package ListernersPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListernersPackage.TestNGListeners.class)
public class IRetryAnalyzerClass implements IRetryAnalyzer{
    int counter = 0;
    int retryLimit = 4;
    @Override
    public boolean retry(ITestResult result) {

        if(counter<retryLimit)
        {
            //if(!result.isSuccess())
            {

                System.out.println("Calling function..!!"+counter +" times..");
                counter++;
                //iRetryAnalyzerDemo();

                return true;
            }
        }

        return false;
    }

    @Test(retryAnalyzer = ListernersPackage.IRetryAnalyzerClass.class)
    public void iRetryAnalyzerDemo()
    {
        System.out.println("This is IRetryAnalyzerDemo");
        Assert.assertEquals(false, true);
//        int counter=0;
        //Assert.assertTrue(false);
//        int status = result.getStatus();
//        System.out.println("Status: "+status);
//        boolean res = result.isSuccess();
//        System.out.println("Is Success: "+res);
        //result.getMethod().getRetryAnalyzer(result).retry(result);
        //OnTestSucc
//        if(status==2)
//        {
//            iRetryAnalyzerDemo(res);
//        }

    }


}
