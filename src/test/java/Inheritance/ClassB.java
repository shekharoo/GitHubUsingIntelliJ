package Inheritance;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class ClassB extends ClassA{
    ClassB()
    {

    }
    {
        System.out.println("This is class B");
    }

    public static void main(String[] args) {
//        ClassB b = new ClassB();
//        ClassA a = new ClassB();
        ClassA a1= new ClassA();
        if(a1 instanceof ClassB)
        {
            System.out.println("Yes instance of Class A");
        }
        else
            System.out.println("Not an instance");
//        Actions action = new Actions();
//        action.
//        Select sel = new Select();
//        sel.


    }
}
