package InterviewPractice;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class ComparableExample implements Comparable<ComparableExample> {
    String name;
    int age;
    String address;

    ComparableExample()
    {

    }
    ComparableExample(String name,int age,String address)
    {
        super();
        this.name=name;
        this.age=age;
        this.address=address;
    }
    public int compareTo(ComparableExample c)
    {
        if(this.age==c.age)
        {
            return 0;
        } else if (this.age>c.age) {
            return 1;
        }
        else
            return -1;

    }
    public void display()
    {
        System.out.println("Name is: "+name);
        System.out.println("Age is: "+age);
        System.out.println("Address is: "+address);
    }

}
