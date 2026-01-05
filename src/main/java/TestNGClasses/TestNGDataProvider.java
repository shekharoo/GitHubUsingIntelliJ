package TestNGClasses;

import org.testng.IReporter;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider implements IReporter {
    @DataProvider
    public Object[][] getData() {
        Object[][] objArr = new Object[4][2];
        objArr[0][0] = "DBMS";
        objArr[0][1] = "Completed";

        objArr[1][0] = "Selenium";
        objArr[1][1] = "InProgress";

        objArr[2][0] = "FireFlink";
        objArr[2][1] = "InProgress";

        objArr[3][0] = "API";
        objArr[3][1] = "Completed";

        return objArr;
    }
        @Test(dataProvider = "getData",invocationCount = 1)
        public void createProjectTest(String subjectName, String projectStatus) throws Throwable {

            //System.out.println("Subject Name: "+subjectName+"======"+"Project Status: "+projectStatus);
            Reporter.log("Subject Name: "+subjectName+"======"+"Project Status: "+projectStatus,true);

    }

//    @Test
//    public static void printMsg1()
//    {
//        System.out.println("This is outside of Test() of testng");
//    }
//    @Test
//    public static void printMsg()
//    {
//        System.out.println("This is inside printMsg()");
//        printMsg1();
//    }
}
