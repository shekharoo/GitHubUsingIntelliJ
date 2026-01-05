package Array;

import org.testng.annotations.Test;

import java.util.Arrays;

public class PointerConcept {
    @Test
    public void reverse()
    {
        String s= "Shekhar";
        char[] ch=s.toCharArray();
        //System.out.println(Arrays.toString(ch));
        int left=0;
        int right=ch.length-1;
        char temp;
        char temp1;
        while(left<right)
        {
            temp=ch[left];
            ch[left++]=ch[right];
            ch[right--]=temp;
        }
        System.out.println("Final String is: "+Arrays.toString(ch));

    }


}
