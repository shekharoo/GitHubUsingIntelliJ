package DoubleArray;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTestNG {

    //WHen values are not passing thru xml
    //@Parameters({"Shekhar","Bodhgaya"})
//    @Test
//    public void details(@Optional("Shekhar") String name,@Optional("Bodhgaya") String address)
//    {
//        System.out.println("Name is: "+name);
//        System.out.println("Address is: "+address);
//    }



    //When values are passing thru xml:
    @Parameters({"Name","Address"})
    @Test
        public void details(String name, String address)
    {
        System.out.println("Name is: "+name);
        System.out.println("Address is: "+address);
    }

}
