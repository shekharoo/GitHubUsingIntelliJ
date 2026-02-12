package Strings;

import java.util.Arrays;

public class pRACTICEjAVAPgms {
    public static void main(String[] args) {
//        String s="shekharanands";
//        //System.out.println("First occurence: "+s.indexOf(s));
//        for(int i=0;i<s.length();i++)
//        {
//            int count=0;
//            for(int j=i+1;j<s.length();j++)
//            {
//                if(s.charAt(i)==s.charAt(j))
//                {
//                    //System.out.println(s.charAt(i));
//                    count++;
//                }
////                if(s.indexOf(s.charAt()))
////                {
////                    System.out.println("First occurence: "+s.indexOf(s.charAt(i)));
////                    System.out.println(s.charAt(i));
////                }
//            }
//        }

        int[] ar={10,0,0,10,20}; //{10,10,20,0,0}
        int left=0;
        int right=0;
        int temp=0;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]!=0)
            {
                temp=ar[left];
                ar[left]=ar[right];
                ar[right]=temp;
                left++;
            }
            right++;
        }
        System.out.println("Array is: "+ Arrays.toString(ar));
    }
}
