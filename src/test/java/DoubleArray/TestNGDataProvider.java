package DoubleArray;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestNGDataProvider extends Project{
    int i =1;
    public TestNGDataProvider()
    {

    }

    public TestNGDataProvider(String actAPIProjectNAme, String projectStatus) {
        super(actAPIProjectNAme, projectStatus);
    }

    //public static void main(String[] args) {


    @DataProvider
    public Object[][] getData() {
        Object[][] objArr = new Object[5][2];
        objArr[0][0] = "IDBS-0";
        objArr[0][1] = "Completed";

        objArr[1][0] = "IDBS-1";
        objArr[1][1] = "Completed";

        objArr[2][0] = "IDBS-2";
        objArr[2][1] = "Completed";

        objArr[3][0] = "IDBS-3";
        objArr[3][1] = "Completed";

        objArr[4][0] = "IDBS-4";
        objArr[4][1] = "Completed";

        return objArr;
    }
        @Test(dataProvider = "getData")
        public void createProjectTest(String actAPIProjectNAme, String projectStatus) throws Throwable {
            //Project pObj = new Project(actAPIProjectNAme, projectStatus);
            System.out.println("=======Values=======");
            System.out.println("ProjectName: "+actAPIProjectNAme);
            System.out.println("projectStatus: "+projectStatus);
            System.out.println("No of times it run: "+i);
            i++;
        }

//    public static void main(String[] args) {
//        Project proj = new Project("ABC","XYZ");
//    }
    }
//}
